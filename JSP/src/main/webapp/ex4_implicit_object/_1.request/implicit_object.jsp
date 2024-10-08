<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장 객체</title>
<!-- 
	내장 객체란 JSP 파일이 자바 소스 파일로 변환되면서 _jspService() 메서드 내에 자동으로 생성 및 초기화 되는 변수를
	내장 객체라고 한다.
	
	아래의 코드는 모든 JSP 파일이 자바 소스로 변환될 때 공통으로 삽입되는 코드이다.
	public void _jspService(final jakarta.servlet.http.HttpServletRequest request,
									final jakarta.servlet.http.HttpServletResponse response) 
	
	final jakarta.servlet.http.HttpServletRequest						
	- 웹 브라우저의 요청 정보를 저장하고 있는 객체
	
	final jakarta.servlet.http.HttpServletResponse				
	- 웹 브라우저의 요청에 대한 응답 정보를 저장하는 객체

	final jakarta.servlet.jsp.PageContext pageContext;			
	- JSP 페이지에 대한 정보를 저장하고 있는 객체

    jakarta.servlet.http.HttpSession session = null;			
    - 세션 정보를 저장하고 있는 객체

    final jakarta.servlet.ServletContext application;			
    - 웹 애플리케이션 Context의 정보를 담고 있는 객체

    final jakarta.servlet.ServletConfig config;					
    - JSP 페이지에 대한 설정 정보를 담고 있는 객체

    jakarta.servlet.jsp.JspWriter out = null;					
    - JSP 페이지의 출력할 내용을 가지고 있는 출력 스트림 객체

    final java.lang.Object page = this;							
    - JSP 페이지를 구현한 자바클래스 객체
    
	
	
	** 내장 객체의 영역은 객체의 유효 기간이다 **
	
	영역 이름		page 영역					request 영역				session 영역				application 영역
	사용 객체		pageContext			->	request			->		session			->		application
			하나의 JSP 페이지 처리시 사용		하나의 요청 처리시 사용	브라우저 닫기 전까지 유지		웹 애플리케이션 종료될 때까지 유지

    
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;
    
 -->
</head>
<body>

</body>
</html>