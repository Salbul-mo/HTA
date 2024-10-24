<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" />
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>
</head>
<body>
	<div class="container-fluid d-flex p-0">
		<div class="col- col-md- bg-info">
			사이드
			<ul class="nav flex-column">
				<li class="nav-item"><a class="nav-link active" href="#">회원 관리</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#">강사관리</a></li>
				<li class="nav-item"><a class="nav-link" href="#">학생관리</a></li>
				<li class="nav-item"><a class="nav-link" href="#">추가사항</a>
				</li>
			</ul>
		</div>
		<div class="col-9 col-md-11 bg-success">
			메인
			<div class="container row row-cols-2 mx-2 d-flex">
				<div class="col">
					<img class="img-fluid"
						src="${pageContext.request.contextPath}/image/uploading.png">
				</div>
				<div class="col">
					<img class="img-fluid"
						src="${pageContext.request.contextPath}/image/desk.jpg">
				</div>
				<div class="col">2. 장점[편집] 부트스트랩 프레임워크는 글자, 인용문, 목록, 표, 입력 폼, 버튼, 이미지, 아이콘
					등의 자잘한 것뿐만 아니라, 드롭다운 메뉴, 내비게이션 바, 버튼, 탭, 리스트, 페이지 이동 바, 알림 메시지,
					섬네일, 진행 바 등의 웹 페이지에서 많이 쓰이는 요소를 거의 전부 내장하고 있다. 이 때문에 웬만한 웹 페이지는
					부트스트랩의 CSS와 JavaScript 관련 사항만 설치하고 미리 지정된 CSS 클래스나 JavaScript 함수만
					불러오면 트위터에서 쓰는 것과 비슷한 디자인을 순식간에 만들 수 있었다. 다만 v5 버전에서는 트위터의 디자인과는 거리가
					멀어졌다. PC용 디자인뿐 아니라 태블릿이나 스마트폰 같은 모바일용 디자인을 반응형으로 한 번에 지원한다. 이 때문에
					디자인 소요 시간이 크게 줄어들었고, 여러 웹 브라우저를 지원하기 위한 크로스 브라우징에 골머리를 썩일 필요가 없어졌다.
					크로스 브라우징을 위한 각종 핵도 들어 있기 때문이다.[2] 거기다 화면 해상도 크기에 따라 자동으로 정렬되는 '그리드
					시스템'[3]을 채용하고 있기 때문에 하나의 웹 페이지로 데스크톱, 태블릿, 스마트폰 모든 기기에서 무리 없이 보게 만들
					수 있다. 즉 반응형 웹을 지원한다는 의미이다. 심지어 이게 오픈 소스다. 라이선스는 MIT 허가서를 사용하는데, 소스
					코드 공개의 의무가 없어 재배포 면에서는 GPL보다 휠씬 자유로운 라이선스이다. 단, 같이 들어 있는 Glyphicon
					아이콘은 CCL BY 3.0을 사용하므로 출처를 밝혀야 한다.[4] 소스까지 오픈되어 있다 보니 여기서 파생된 프로젝트만
					해도 수천 개가 넘어간다.
				</div>
				<div class="col">3. 단점[편집] 사전 정의 된 디자인이 있다 보니 비슷한 디자인의 페이지가 양산될 수 있지만, 사실
					이 문제는 오픈 소스의 힘으로 극복할 수 있다. 부트스트랩은 오픈 소스다 보니 사용자가 임의로 변경하는 것이 자유롭고,
					변경한 것을 재배포하거나 상업적으로 판매하는 것이 가능하다. 유저들이 변경한 테마를 내려받아 적용하는 것도 어렵지 않다.

					HTML5에 맞춰져 있다 보니 구형 브라우저 지원이 미흡하다. HTML5가 제대로 지원되지 않는 IE7, 8을 지원하려면
					강제로 HTML5를 인식시키는 html5shiv 같은 JavaScript 코드가 필요하고, 가뜩이나 JavaScript
					해석이 느린 IE 구버전을 더 느려지게 하는 주범이 된다. 사실 IE 8을 아직도 쓰는 사람이 문제긴 하다. 2022년
					시점에서는 IE 구버전과 그 구버전을 기본 탑재 했던 OS는 모두 지원이 종료되었고 Windows 8.1, 10에 기본
					탑재된 IE 11만 남은 상황이므로 구버전 지원은 특수한 상황 이외에는 필요가 없어졌다. 마지막으로 남아 있는 IE
					11도 2022~2023년 내에 모두 지원이 종료될 예정이다.
				</div>
			</div>

		</div>
	</div>
	<div class="jumbotron mt-auto"><jsp:include page="footer.jsp"/></div>
</body>
</html>