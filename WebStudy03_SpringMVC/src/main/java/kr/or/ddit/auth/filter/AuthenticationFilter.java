package kr.or.ddit.auth.filter;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 보호자원에 대한 요청인 경우,
 * 신원확인(인증)을 거쳤는지 확인하고,
 * 인증된 사용자는 통과.
 * 미인증된 사용자라면 로그인 폼으로 이동.
 * 
 */
public class AuthenticationFilter implements Filter{
	
	private Map<String, String> securedResources;
	private ServletContext application;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		securedResources = new LinkedHashMap<>();
		application = filterConfig.getServletContext(); //application
		application.setAttribute("securedResources", securedResources);
		//보호자원관리
		securedResources.put("/mypage", "ROLE_USER");
		securedResources.put("/member/memberList.do", "ROLE_ADMIN");
		securedResources.put("/prod/prodInsert.do", "ROLE_ADMIN");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		boolean pass = true;
//		1. 현재 요청이 보호자원인지 여부 판단
		
		boolean secured = isSecured(req);
		if(secured) {
			//보호자원에 대한 요청
			Object authMember = req.getSession().getAttribute("authMember");
//			2. 인증된 사용자 여부 판단
			if(authMember==null) {
				//보호자원이 맞는데 아직 인증 x 일때
				pass = false;
			}
//				통과
//			else(부)
//				로그인 폼으로 이동( redirect )
		}
		//통과
		if(pass) {
			chain.doFilter(request, response);
		}else {
			resp.sendRedirect(req.getContextPath()+"/login/loginForm.jsp");
		}
		
			
	}

	private boolean isSecured(HttpServletRequest req) {
		String uri = req.getRequestURI();
		for(String key : securedResources.keySet()) {
			//보호자원이면
			if(uri.contains(key)) {
				return true;
			}
		}
		return false;
	}

}










