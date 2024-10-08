<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<title>requestTest1</title>
</head>
<%	
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	String[] hobby = request.getParameterValues("hobby");
	
	gender = gender.equals("male") ? "남자" : "여자";
	
	String hobbys = "";
	for (String str : hobby)
		hobbys += str + " ";
%>
<body>
	<div class="container d-flex flex-column justify-content-center">
		<h2>Request 예제입니다.</h2>
		<table class="table table-bordered text-center">
			<tbody>
				<tr>
					<td>이름</td>
					<td><%=name %></td>
				</tr>
				<tr>
					<td>성별</td>
					<td><%=gender %></td>
					<%-- <td> <%=request.getParameter("gender").equals("male") ? "남자" : "여자" %> </td> --%> 
				</tr>
				<tr>
					<td>취미</td>
					<td><%=hobbys %></td>
					<%-- <td> <%=String.join(" ", request.getParameterValues("hobby")) %> </td>--%>
				</tr>
			</tbody>
		</table>
	</div>

</body>
</html>