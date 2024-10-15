<%--
	JSTL (JSP Standard Tag Library)
		- 자주 사용되는 기능을 모아둔 커스텀 태그(개발자가 직접 정의할 수 있다)
		
	JSTL 다운로드
	1) http://mvnrepository.com/ 접속
		검색어 jstl 입력
		
		https://mvnrepository.com/artifact/org.glassfish.web/jakarta.servlet.jsp.jstl/3.0.1
		https://mvnrepository.com/artifact/jakarta.servlet.jsp.jstl/jakarta.servlet.jsp.jstl-api/3.0.0
		
	2) 이클립스에 파일 넣기
		webapp / WEB-INF / lib / jakarta.servlet.jsp.jstl-3.0.1.jar
								 jakarta.servlet.jsp.jstl-api-3.0.0.jar
--%>
<%-- 		
	taglib 지시어 : JSTLd 이나 커스텀 태그 등 태그 라이브러리를 JSP 에서 사용할 때 사용하는 지시어 
    
    	① prefix 속성은 사용할 커스텀 태그의 네임스페이스를 지정하고
    				 명시된 값은 태그 라이브러리를 호출할 때 사용할 접두사를 의미한다.
    
    	② uri 속성은 태그 라이브러리에 정의한 태그와 속성 정보를 저장한 파일이 존재하는 위치를 지정한다.
    	
		* taglib 장점 : 사용하면 코드의 길이가 줄어들고 인식성이 좋아진다.    
--%>
<%--
	JSP 페이지에서 core 라이브러리를 사용하기 위한 태그 선언이다.
	이 선언을 통해 JSP 페이지에서 JSTL 코어 태그를 사용할 수 있게 된다.
 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
	prefix="c" : 사용할 태그의 네임스페이스의 이름이다.
		예) <네임스페이스:태그이름/>
			<c:set/>
	uri="http://java.sun.com/jsp/jstl/core"
		=> 코어 라이브러리를 사용하겠다는 의미.
			이 URI 는 실제 웹상의 URL 이 아니며, JSP 컨테이너가 내부적으로 해당 URI 를 인식하여 
			올바른 태그 라이브러리로 연결해준다 
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL core 라이브러리 사용 예제</title>
</head>
<body>
	<%-- 
		<c:set> 변수에 값을 설정하는 태그이다.
			var : 값을 저장할 변수 이름
			value : 저장할 값
	 --%>
	 <c:set var="test" value="Hello JSTL!"/>
	 
	 <h3>
	 	&lt;c:set&gt; 사용 후 :
	 	<c:out value="${test}"/>
	 	<%-- 지정된 값을 출력하는 태그 
	 	<c:set> 사용 후 : Hello JSTL! --%>
	 </h3>
	 
	 <h3>
	 	&lt;c:set&gt; 사용 후 :
	 	<c:out value="test"/>
	 	<%-- EL 로 지정된 값을 부른 것이 아니라서 문자열이 출력된다.
	 	<c:set> 사용 후 : test --%>
	 </h3>
	 
	 <c:remove var="test"/> <!-- "test"라는 이름의 변수를 제거하는 태그이다. -->
	 <h3>
	 	&lt;c:remove&gt; 사용 후 :
	 	<c:out value="${test}"/>
	 </h3>
	 
	 <c:catch var="err"> <%-- 예외 처리를 위한 태그
	 							예외가 발생하면 var 에 지정된 예외 객체가 할당된다.
	  --%>
	  <%=10 / 0 %>
	 </c:catch>
	  <h3>
	  	&lt;c:catch&gt;로 잡아낸 오류 :
	  	<c:out value="${err}"/>
	  </h3>
	  <%--java.lang.ArithmeticException: / by zero --%>
	  
	  
	  <%-- 조건 처리를 위한 태그이다.
	  		if 와 유사하지만 else 는 지원하지 않는다. --%>
	  <c:if test="true">
	  	조건식이 참이어서 무조건 수행한다.
	  </c:if>
	  
	  <c:if test="${5<10}">
	  	<h3>5는 10보다 작다.</h3>
	  </c:if>
	  
	  <c:if test="${6+3==8}">
	  	<h3>6 + 3 은 9 이다.</h3>
	  </c:if>
	  
	  <%--
	  	1. <c:choose>, <c:when>, <c:otherwise> 태그
	  		- 조건절이 여러 개인 경우,
	  		
	  		- 조건 중에 만족하는 것이 있으면 실행하고 벗어난다.
	  			하나의 choose 태그에는 여러 개의 when 태그가 존재
	  			
	  	2. 사용 예
	  		<c:choose>
	  			
	  			<c:when test="testCondition"> // 조건을 만족하면 실행 - 여러 개 작성할 수 있다. 
	  			
	  			~
	  			
	  			</c:when>
	  			
	  			<c:when test="testCondidion"> 
	  			
	  			~
	  			
	  			</c:when>
	  			
	  			<c:otherwise> // 조건을 만족하지 않으면 실행
	  			
	  			~
	  			
	  			<c:otherwise>
	  		<c:choose>
	   --%>
	   <c:choose>
	   		<c:when test="${5+10==50}">
	   			<h3>5+10 은 50이다.</h3>
	   		</c:when>
	   		
	   		<c:otherwise>
	   			<h3>5+10은 50이 아니다.</h3>
	   		</c:otherwise>
	   	</c:choose>
	   	
	   	<%--
	   		1. 변수 a 에 3을 설정한다.
	   		
	   		2. 만약 a의 값이 
	   			1이면 "1입니다"
	   			2이면 "2입니다"
	   			1 또는 2가 아니면 "1 또는 2가 아닙니다."
	   			라고 출력한다.
	   		3. 변수 a 의 값을 1 증가한다.
	   		
	   		4. 변수 a 의 값을 출력한다.
	   	 --%>
	   	 <c:set var="a" value="3"/>
	   	 <c:choose>
	   	 	<c:when test="${a==1}">
	   	 		<h3>1입니다.</h3>
	   	 	</c:when>
	   	 	<c:when test="${a==2}">
	   	 		<h3>2입니다.</h3>
	   	 	</c:when>
	   	 	<c:otherwise>
	   	 		<h3>1 또는 2가 아닙니다. </h3>
	   	 	</c:otherwise>
	   	 </c:choose>
	   	 
		<c:set var="a" value="${a+1}"/>
		<h3>
			<c:out value="${a}"/>	   	 
		</h3>
</body>
</html>
