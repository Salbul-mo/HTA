package net.filter.action;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class ForbiddenFilter implements Filter {

	@Override //필터가 생성될 때 초기화 사용
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("ForbiddenFilter");
	}
	
	// 요청 마다 필터가 실행할 메서드
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("3");
		
		// ServletRequest를 HttpServletRequest 로 캐스팅하여 getSession 메서드를 사용하여 HttpSession 을 가져온다.
		HttpServletRequest hprequest = (HttpServletRequest) request;
		HttpSession session = hprequest.getSession();
		String id = (String)session.getAttribute("id");
		
		HttpServletResponse hpresponse = (HttpServletResponse) response;
		
		if(!id.equals("admin")) {
			System.out.println("admin이 아닙니다.");
			hprequest.getRequestDispatcher("forbidden.net").forward(hprequest,hpresponse);
			return; 
		}
		chain.doFilter(request, response);
		
		System.out.println("4");
		
	}
	

}
