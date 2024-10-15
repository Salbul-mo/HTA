package net.common.action;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

// 특정 비즈니스 요청으로 수행하고 결과 값을 ActionForward 타입으로 변환하는 메서드가 정의된 인터페이스
// Action : 인터페이스 명
// ActionForward : 반환형

public interface Action {
	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
