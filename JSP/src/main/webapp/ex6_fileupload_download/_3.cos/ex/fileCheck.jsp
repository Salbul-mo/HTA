<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 확인 및 다운로드</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<% 
	String name = (String) request.getAttribute("name");
	String subject =(String) request.getAttribute("subject");
	String systemName1 = (String) request.getAttribute("systemName1");
	String systemName2 = (String) request.getAttribute("systemName2");
	String origfileName1 = (String) request.getAttribute("origfileName1");
	String origfileName2 = (String) request.getAttribute("origfileName2");
	String uploadPath = (String) request.getAttribute("uploadPath");
%>
 <div class="container mt-3">
	<h2>파일 다운로드 폼</h2>
  <table class="table table-bordered table-striped">
    <tbody id="myTable">
      <tr>
      	<td>작성자</td>
		<td><%=name %></td>
      </tr>
      <tr>
		<td>제목</td>
		<td><%=subject %></td>
      </tr>
      <tr>
		<td>파일명1</td>
		<td><a href="<%=request.getContextPath()%>/down?fileName=<%=systemName1 %>"><%=origfileName1 %></a></td>
      </tr>
      <tr>
		<td>파일명2</td>
		<td><a href="<%=request.getContextPath()%>/down?fileName=<%=systemName2 %>"><%=origfileName2 %></a></td>
      </tr>
      <tr>
		<td>uploadPath</td>
		<td><%=uploadPath %></td>
      </tr>
    </tbody>
  </table>
 </div>
</body>
</html>