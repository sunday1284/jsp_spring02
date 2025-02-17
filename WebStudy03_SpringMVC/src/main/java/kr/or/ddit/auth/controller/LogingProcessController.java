package kr.or.ddit.auth.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.auth.exception.AuthenticateException;
import kr.or.ddit.auth.service.AuthenticateService;
import kr.or.ddit.auth.service.AuthenticateServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

//redirect는 파라미터를 넘기지 않고 넘어가게 하는법
@Controller
public class LogingProcessController {
	@Inject
	private AuthenticateService service;

	@PostMapping("/Login/LoginProcess")
	public String loginProcess(
		@RequestParam("memId") String memId
		,@RequestParam("memPass") String memPass
		,HttpSession session
		,RedirectAttributes redirectAttributes
	){
		String logical = null;

        // 2. 인증 처리
        try {
            MemberVO authMember = service.authenticate(memId, memPass);
            session.setAttribute("authMember", authMember);
            
            logical = "redirect:/"; // 인증 성공 시 메인 페이지로
        } catch (AuthenticateException e) {
            session.setAttribute("message", e.getMessage());
            
            logical = "redirect:/login/loginForm.jsp"; // 인증 실패 시 로그인 페이지로
        }
        return logical;
	}
}


