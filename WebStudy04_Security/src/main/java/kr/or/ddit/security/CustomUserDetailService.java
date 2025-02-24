package kr.or.ddit.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.member.vo.MemberVO;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService{

	private final MemberDAO mapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVO member = mapper.selectMember(username);
		if(member==null) {
			//유저id가 없으면 not found
			throw new UsernameNotFoundException(String.format("%s 사용자 없음.",username));
		}
		//adapter에 select 단건 조회를 담음
		return new RealUserWrapper(member);
	}

}
