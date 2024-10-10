<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<a class="navbar-brand" href="#">액션태그</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#collapsesibleNavbar">
			<span class="navbar-toggler-icon"></span>
			</button>
			<%-- flex-row-reverse 추가 -오른쪽 끝으로 붙는다. --%>
			<div class="collapse navbar-collapse flex-row-reverse" is="collapsibleNavbar">
				<ul	class="navbar-nav">
					<%
					// header 의 이름 중에서 Cookie의 값을 가져온다.
					String cookie = request.getHeader("Cookie");
					String cookieid = ""; 
					// 쿠키가 존재하는지 확인한다.
					if(cookie != null) {
						// 존재하는 쿠키들을 배열로 가져온다.
						Cookie cookies[] = request.getCookies();
						
						// 쿠키의 이름이 "language1" 인 값을 찾기 위해 쿠키 배열을 모두 확인한다.
						for(int i = 0; i < cookies.length; i++){
							if(cookies[i].getName().equals("id")) {
								cookieid = cookies[i].getValue();
							}
						}
					}
					
						if (!cookieid.equals("jsp")) {
						String id = (String) session.getAttribute("id");
						if(id != null && !id.equals("")) {
					%>
					<li class="nav-item"><a class="nav-link"> <%=id %>님이 로그인 되었습니다.</a></li>
					<li class="nav-item"><a class="nav-link" href="logout.jsp">로그아웃</a></li>
					<%
						} else {
					%>
					<li class="nav-item"><a class="nav-link" href="login.jsp">로그인</a></li>
					<li class="nav-item"><a class="nav-link" href="join.jsp">회원가입</a></li>
					<%
						}
						} else {
					%>
					<li class="nav-item"><a class="nav-link"> <%=cookieid %>님이 로그인 되었습니다.</a></li>
					<li class="nav-item"><a class="nav-link" href="logout.jsp">로그아웃</a></li>
					<%	} %>
				</ul>
			</div>
</nav>