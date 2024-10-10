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
						String id = (String) session.getAttribute("id");
						if(id != null && !id.equals("")) {
					%>
					<li class="nav-item"><a class="nav-link"> <%=id %>님이 로그인 되었습니다.</a></li>
					<li class="nav-item"><a class="nav-link" href="logout2.jsp">로그아웃</a></li>
					<%
						} else {
					%>
					<li class="nav-item"><a class="nav-link" href="login2.jsp">로그인</a></li>
					<li class="nav-item"><a class="nav-link" href="join.jsp">회원가입</a></li>
					<%
						}
					%>
				</ul>
			</div>
</nav>