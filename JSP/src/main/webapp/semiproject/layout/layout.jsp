<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<title>템플릿</title>
<style>
	#side {
		background:black;
		width:50px;
		height:800px;
	}
	
	#top {
		background:red;
		width:900px;
		height:50px;
	}
</style>
</head>
<body>
<div class="header row no-gutters ">
  <div class="col-sm-6 col-md-8 d-flex flex-row">메뉴 영역</div>
  <div class="col-6 col-md-4 d-flex flex-row-reverse">로그인 관련 영역</div>
</div>
 <div class="d-flex align-items-start flex-column bd-highlight mb-3" style="height: 200px;">
  <div class="mb-auto p-2 bd-highlight">Flex item</div>
  <div class="p-2 bd-highlight">Flex item</div>
  <div class="p-2 bd-highlight">Flex item</div>
</div>
</body>
</html>