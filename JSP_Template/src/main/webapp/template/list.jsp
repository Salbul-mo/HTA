<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%@ page import="java.util.*"%>
<%@ page import="net.template.db.*"%>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<style>
	.container {
		margin-top: 3em;
	}

	table, h4 {
		text-align: center;
	}
</style>
<title>Insert title here</title>
</head>
<body>
	<nav>
		<jsp:include page="top.jsp"/><br><br>
	</nav>
	<div class="container">
		<div class="form-group">
			<label for="usr">검색어를 입력하세요</label> 
			<input type="text" class="form-control" id="search" placeholder="Search..." name="search">
		</div>
		<c:choose>
			<c:when test="${!empty list}">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>번호</th>
							<th>아이디</th>
							<th>성별</th>
							<th>취미</th>
							<th>자기소개</th>
							<th>가입 일</th>
							<c:if test="${sessionScope.id == 'admin'}">
							<th>글  삭제</th>
							</c:if>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="temp" items="${list}" varStatus="status">
						<tr>
							<td>${status.count}</td>
							<td><a href="info.net?id=${temp.id}">${temp.id}</a></td>
							<td>${temp.gender == "m" ? "남자" : "여자"}</td>
							<td>${temp.hobby}</td>
							<td><c:out value="${temp.intro}"/></td>
							<td>${temp.register_date}</td>
						<c:if test="${sessionScope.id == 'admin'}">
							<td><input type="button" name="${temp.id}" class="btn btn-sm btn-danger" value="삭제">
						</c:if>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
			<c:otherwise>
				<h4>조회된 데이터가 없습니다.</h4>
			</c:otherwise>
		</c:choose>
	</div>
	<script>
		$(document).ready(function() {
			$('input').keyup(function() {
				
				let search = $('input').val().trim();
						
				if (search != null && search != "") {
					$('table tbody tr').hide();
					$('table tbody tr td:contains(' + '"' + search + '"' + ')')
																			.parent().show();
				} else {
					$('table tbody tr').show();
				}
			});
					
			/*
				button 에 속성 없이 이벤트 일으킨 행의 id 찾는 법
				$('input:button').click(function(){
					const answer = confirm("정말 삭제하시겠습니까?");
					
					if (answer) {
						const id = $(this).parent().parent().find(":nth-child(2)").text(); 
						// 버튼을 가진 td > tr 의 2번째 자식(id칸)의 text노드를 가져온다.
						console.log(id);
					}
				}
			*/
			
			$('input:button').on("click", (e) => {
				
				const answer = confirm("정말 삭제하시겠습니까?");
								
				if (answer) {
					const id = $(e.target).attr("name");
					console.log(id);
					// e.target 으로 이벤트 발생시킨 객체를 찾는다.
					// event.stopImmediatePropagation(); 상위 뿐만 아니라 같은 레벨에서의 전파 방지
					// return false; 제이쿼리에서 전파 방지
					output =  "<form action='delete.net' method=post>";
					output += "<input name=id value=" + id + ">";
					output += "<input type=submit>"
					output += "</form>";
					
					$('body').append(output);
					$('form').hide().submit(); // 화면상에 보이지 않도록 한 후 submit 실행한다.
					return false;
				} else {
					alert("취소를 선택하셨습니다.");
					return false;
				}
			});
			
			// 삭제 관련 메시지 출력
			const result = "${message}";
			if (result != '') {
				alert(result);
				<% session.removeAttribute("message"); %>
			}
		});
	</script>
</body>
</html>