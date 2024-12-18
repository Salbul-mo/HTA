package net.filter.action;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class LoginFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("초기화:필터1");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("1");
		
		// ServletRequest를 HttpServletRequest 로 캐스팅하여 getSession 메서드를 사용하여 HttpSession 을 가져온다.
		HttpServletRequest hprequest = (HttpServletRequest) request;
		HttpSession session = hprequest.getSession();
		String id = (String)session.getAttribute("id");
		
		HttpServletResponse hpresponse = (HttpServletResponse) response;
		
		if(id == null) {
			System.out.println("필터:null 입니다.");
			hpresponse.sendRedirect("login");
			return; // 다른 필터로 요청이 전달되지 않고 login.net로 이동한다.
		}
		// 요청의 필터링 결과를 다음 필터에 전달한다.
		// 만약 현재 필터가 마지막이라면 서블릿 컨테이너에 의해 요청된 서블릿으로 전달된다.
		
		chain.doFilter(request, response);
		
		// 응답 후 코드
		System.out.println("2");
		
	}
	

}
