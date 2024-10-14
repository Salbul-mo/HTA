<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.util.*" %>
<%@ page import="ex8.Dept" %>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
  <style>
	.container {
		width:500px;
		margin-top:3em;
	}
	
	table, h4 {
		text-align:center;
	}
</style>
<title>Insert title here</title>
</head>
<body>
 <div class="container">
	<%
		ArrayList<Dept> list = (ArrayList<Dept>) request.getAttribute("list");
		
		if (!list.isEmpty()) {
	%>
	<table class="table">
		<thead>
			<tr>
				<th>DEPTNO</th>
				<th>DNAME</th>
				<th>LOC</th>
			</tr>
		</thead>
		<tbody>
	<% 	
		Iterator<Dept> it = list.iterator();
		while(it.hasNext()) {
			Dept dept = it.next();
	%>
		<tr>
			<td><%=dept.getDeptno() %></td>
			<td><%=dept.getDname() %></td>
			<td><%=dept.getLoc() %> </td>
		</tr>
	<%
			}
	%>
		</tbody>	
	</table>
	<%
		} else {
			out.print("<h4>조회된 데이터가 없습니다.</h4>");
		}
	%>
 </div>
</body>
</html>