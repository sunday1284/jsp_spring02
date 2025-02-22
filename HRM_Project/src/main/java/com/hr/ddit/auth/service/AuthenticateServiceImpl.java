package com.hr.ddit.auth.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hr.ddit.auth.exception.AuthenticateException;
import com.hr.ddit.member.dao.MemberDAO;
import com.hr.ddit.member.vo.MemberVO;

import lombok.Data;

@Service
@Data
public class AuthenticateServiceImpl implements AuthenticateService {
	
	@Inject
	private final MemberDAO dao;
	
	
	@Override
	public MemberVO authenticate(String username, String password) {
		MemberVO member = dao.selectMember(username);
		if(member!=null) {
			if(member.isMemDelete()) {
				//이미 탈퇴한 회원
				throw new AuthenticateException("이미 탈퇴한 회원임.");
			}else {
				// 아직 활동중인 회원 
				String savedPass = member.getMemPass();	
				if(savedPass.equals(password)) {
					return member;
				}else {
					throw new AuthenticateException("비밀번호 오류");
				}
				
			}
		}else {
			throw new AuthenticateException("존재하지 않는 회원.");
		}
	}

}
