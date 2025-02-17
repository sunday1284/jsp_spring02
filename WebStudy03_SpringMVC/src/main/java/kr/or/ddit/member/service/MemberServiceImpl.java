package kr.or.ddit.member.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.auth.exception.AuthenticateException;
import kr.or.ddit.auth.service.AuthenticateService;
import kr.or.ddit.auth.service.AuthenticateServiceImpl;
import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.member.exception.UserNotFoundException;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.paging.PaginationInfo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	private final MemberDAO dao;
	
	@Autowired
	private AuthenticateService authservice;
	
	@Override
	public boolean createMember(MemberVO member) {
		int rowcnt = dao.insertMember(member);
		return rowcnt > 0;
	}

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

	@Override
	public boolean modifyMember(MemberVO member) throws AuthenticateException {
		//1. 인증 가져오기 
		authservice.authenticate(member.getMemId(), member.getMemPass());
		//2. 인증 성공했으면 수정 가능 -> 아니면 수정 불가 
		int rowcnt = dao.updateMember(member);
		return rowcnt > 0;
	}

	@Override
	public boolean removeMember(MemberVO inputData) throws AuthenticateException {
		//1. 회원 인증 가져오기
		authservice.authenticate(inputData.getMemId(), inputData.getMemPass());
		//2. 인증 성공 -> 탈퇴 가능, 아니면 탈퇴 불가 
		int rowcnt = dao.deleteMember(inputData.getMemId());
		return rowcnt > 0;
		
	}

}
