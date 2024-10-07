<%-- 
	JSP 스크립트 요소 
	- JSP 페이지에서 자바코드를 사용할 수 있는 영역을 의미한다.
	
	스크립트 요소의 종류 - 선언문 (<%! %>), 스크립트릿(<% %>), 표현식(<%= %>)
	
	
	1. 선언문 (Declarations)
		(1) JSP 페이지에서 자바 코드의 멤버 변수(필드)와 메서드를 선언하기 위해 사용된다.
		(2) 선언문을 사용해 선언된 변수는 JSP 파일이 웹 컨테이너에 의해 컴파일 될 때 
			멤버 변수로 인식되기 때문에 JSP 페이지의 어느 위치에서도 해당 변수를 참조하는 것이 가능하다.
		
			eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core
			\tmp0\work\Catalina\localhost\JSP\org\apache\jsp\ex2_005fjsp\_005f3_declaration
			폴더에 Declaration_jsp.java 와 Declaration_jsp.class 파일들이 있다. 
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1><%=getStr()  %></h1>
<!-- 
	 해당 블럭은 자바 클래스에서 out.print(getStr()  ); 로 바뀌는데 이때 세미콜론을 사용할 수 없으므로 jsp 입력
	 에서도 세미콜론을 사용할 수 없다.
-->
<%!
	private String getStr() {
		str += " 테스트입니다.";
		return str;
	}
	
	private String str= "선언문 ";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Declaration 테스트</title>
</head>
<body>

</body>
</html>