package kr.or.ddit.auth.filter;

import java.io.IOException;
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

import kr.or.ddit.member.vo.MemberVO;

/**
 * 보호자원에 대한 요청인 경우,
 * 인증된 사용자가 적절한 권한을 획득했는지 여부 확인,
 * 인가된 사용자라면 통과
 * 비인가된 사용자라면 403(Forbidden) 에러 전송
 */
public class AuthorizationFilter implements Filter {

	private ServletContext application;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		application = filterConfig.getServletContext();
	}
	
	private String getResourceRole(HttpServletRequest req) {
		Map<String, String> securedResources = (Map) application.getAttribute("securedResources");
		String uri = req.getRequestURI();
		for(String key : securedResources.keySet()) {
			//보호자원이면
			if(uri.contains(key)) {
				return securedResources.get(key);
			}
		}
		//보호자원 아님
		return null;
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpServletRequest req = (HttpServletRequest) request;
		boolean pass = true;
		
//		1. 보호 자원 요청 여부 판단
		String resRole = getResourceRole(req);
		if(resRole!=null) {
//			2. 자원에 설정된 보호 등급과 사용자에게 부여된 역할의 일치 여부 판단
			
			MemberVO authMember = (MemberVO)req.getSession().getAttribute("authMember");
			if(!authMember.getAuthorities().contains(resRole)) {
//				403 에러 
				pass = false;
			}
		}
		
		if(pass) {
			chain.doFilter(request, response);
		}else {
			resp.sendError(HttpServletResponse.SC_FORBIDDEN, "접근 권한 없음.");
		}
			
	}
	
	

}
