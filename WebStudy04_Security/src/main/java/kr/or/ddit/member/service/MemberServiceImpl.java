package kr.or.ddit.member.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.member.exception.UserNotFoundException;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.paging.PaginationInfo;
import kr.or.ddit.security.CustomUserDetailService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	private final MemberDAO dao;
	
	@Autowired
	private AuthenticationManagerBuilder builder;
	
	@Autowired
	private PasswordEncoder encoder;
	
//	@PreAuthorize("hasRole('ADMIN')")
	@Override
	public boolean createMember(MemberVO member) {
		
		String plain = member.getMemPass();
		//비번 암호화
		String encoded = encoder.encode(plain);
		
		//암호화 셋팅
		member.setMemPass(encoded);
		
		int rowcnt = dao.insertMember(member);
		return rowcnt > 0;
	}
	
//	@PreAuthorize("hasRole('ADMIN')")
	@Override
	public List<MemberVO> readMemberList(PaginationInfo<MemberVO> paging) {
		int totalRecord = dao.selectTotalRecord(paging);
		paging.setTotalRecord(totalRecord);
		return dao.selectMemberList(paging);
	}

	@Override
	public MemberVO readMember(String memId) throws UserNotFoundException {
		MemberVO member = dao.selectMember(memId);
		if(member == null) {
			throw new UserNotFoundException(memId);
		}
		return member;
	}

	//로그인 인증 
	private void authenticate(MemberVO member) throws AuthenticationException{
		//토큰으로 id, 비번을 가져와서 인증, 성공, 실패 여부 결정 -> 예외처리
		UsernamePasswordAuthenticationToken token =
				UsernamePasswordAuthenticationToken.unauthenticated(member.getMemId(), member.getMemPass());
		builder.getObject().authenticate(token);
	}
	
	
	@Override
	public boolean modifyMember(MemberVO member) throws AuthenticationException {
		//1. 인증 가져오기 
		authenticate(member);
		//2. 인증 성공했으면 수정 가능 -> 아니면 수정 불가 
		boolean result = dao.updateMember(member) > 0;
		if(result) {
			createNewAuthentication();
		}
		
		return result;
	}
	@Autowired
	private CustomUserDetailService userDetailService;
	
	//업데이트 시 필요!!
	private void createNewAuthentication(){
		//기존 로그인 상태정보를 그대로 가짐
		Authentication beforeAuth = SecurityContextHolder.getContext().getAuthentication();
		
		SecurityContext context = SecurityContextHolder.createEmptyContext(); 
		//로그인 된 사용자 이름을 가져옴
		UserDetails principal = userDetailService.loadUserByUsername(beforeAuth.getName());
		Collection<? extends GrantedAuthority> authorities = principal.getAuthorities();
		Object details = beforeAuth.getDetails();
		
		//보통 null -> 비밀번호 null 넣어도 상관x
		UsernamePasswordAuthenticationToken newAuthentication =
				UsernamePasswordAuthenticationToken.authenticated(principal, null, authorities);
		//기존 사용자의 정보를 넣어줌
		newAuthentication.setDetails(details);
		
		//기존 인증객체 -> 새로운 객체로 바꿈
		context.setAuthentication(newAuthentication);
		SecurityContextHolder.setContext(context); 
	}
	
	@Override
	public boolean removeMember(MemberVO inputData) throws AuthenticationException {
		//1. 회원 인증 가져오기
		authenticate(inputData);
		//2. 인증 성공 -> 탈퇴 가능, 아니면 탈퇴 불가 
		int rowcnt = dao.deleteMember(inputData.getMemId());
		return rowcnt > 0;
		
	}

}
