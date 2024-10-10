<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	footer {
		position:fixed;
		bottom:0px;
		height:3rem;
		background-color:#ccc;
		width:100%;
		text-align:center;
		line-height:3rem;
	}
</style>
</head>
<body>

<%
// template.jsp 에서 실행할 경우 파라미터 page 값은 없다.
// 따라서 기본으로 보여주는 페이지를 newitem.jsp 로 설정한다.
String pagefile = request.getParameter("page");
if(pagefile == null) {
	pagefile = "newitem";
}
%>
	<header>
		<div class="jumbotron text-center" style="margin-bottom:0">
			<h1>상품목록(<%=pagefile + ".jsp" %>)</h1>
		</div>
	</header>
	<nav>
		<jsp:include page="top2.jsp"/><br><br>
	</nav>
	<div class="container" style="margin-top:10px">
		<div class="row">
			<div class="col-sm-4">
				<aside>
					<jsp:include page="left.jsp"/>
				</aside>
			</div>
			<div class="col-sm-8" style="margin-bottom:5rem">
				<section>
					<jsp:include page='<%=pagefile + ".jsp" %>'/>
				</section>
			</div>
		</div>
	</div>
<script>
	const pagefile='<%=pagefile %>';
	const filelist = ["newitem", "bestitem", "useditem"];
	/*
		toggleClass() 메서드는 선택한 요소에 지정한 클래스를 추가하거나 제거하는 역할을 한다.
		클래스가 이미 존재하면 제거하고 존재하지 않으면 추가하는 방식으로 동작한다.
		
		1. 매개변수 한 개
			형식) $(selector).toggleClass(className);
				 className : 추가하거나 제거할 클래스 이름
			
			예) $('.my-element').toggleClass('active');
			의미) .my-element 요소에 active 클래스를 추가하거나 제거한다.
				 active 클래스가 있으면 제거되고 없으면 추가된다.
				 
		2. 매개변수 두 개
			형식) $(selector).toggleClass(className, boolean);
				 boolean : true(클래스를 추가) 또는 false(클래스를 제거)
			예)  $('.my-element').toggleClass('active', true); // 클래스 추가
				$('.my-element').toggleClass('active', false); // 클래스 제거
	*/
	filelist.forEach((file, index) => {
		$('.nav-pills > .nav-item > .nav-link').eq(index)
				.toggleClass('active', pagefile === file);
				// getParameter 로 가져온 pagefile 과 file 이 일치하면 active 클래스 추가
	});
</script>
</body>
</html>