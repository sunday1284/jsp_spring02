package kr.or.ddit.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import kr.or.ddit.member.vo.MemberVO;
import lombok.ToString;

/**
 * adapter 
 */
@ToString
public class RealUserWrapper implements UserDetails{
	private final MemberVO realUser;

	public RealUserWrapper(MemberVO realUser) {
		super();
		this.realUser = realUser;
	}

	public MemberVO getRealUser() {
		return realUser;
	}
	
	//유저 권한 관리
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<String> roles = realUser.getAuthorities();
		//구현체로 변경 작업
		List<GrantedAuthority> authorites = new ArrayList<>();
		for(String role : roles) {
			authorites.add(new SimpleGrantedAuthority(role));
		}
		return authorites;
	}

	@Override
	public String getPassword() {
		//유저 비번
		return realUser.getMemPass();
	}

	@Override
	public String getUsername() {
		//유저 id 
		return realUser.getMemId();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	//비밀번호 오류 일정횟수 이상 -> 계정장금 -> true이면 사용x
	//db에 비밀번호 오류횟수 저장할 컬럼이 있어야함
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	//비밀번호 변경 날짜를 기록하고 일정 이상되면 바꾸라고 알림
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	//회원 탈퇴여부 -> 탈퇴하지 않았을때  isEnabled선택
	@Override
	public boolean isEnabled() {
		return !realUser.isMemDelete();
	}
	
}
