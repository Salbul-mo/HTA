<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header>
	<div>
	<% 
		String id = (String) session.getAttribute("id");
		if (id != null && !id.equals("")) {
	%>
		<%=id %> 님이 로그인 되었습니다.
		<a href="logout">(로그아웃)</a>
	<% 
		} else {	
	%>
		<a href="login"> 로그인 </a>
	<%
		}	
	%>
	</div>
</header>
