package net.board.action;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import net.common.action.*;
import net.board.db.*;

public class BoardModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ActionForward forward = new ActionForward();
		BoardDAO boardDAO = new BoardDAO();
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardBean boardData = boardDAO.getDetail(num);
		
		// 글 내용 불러오기 실패한 경우
		if (boardData == null) {
			System.out.println("(수정)상세보기 실패");
			request.setAttribute("message", "게시판 수정 상세보기 실패입니다.");
			forward.setPath("/WEB-INF/views/error/error.jsp");
		} else {
			System.out.println("(수정)상세보기 성공");
			
			// 수정 폼 페이지로 이동할 때 원문 글 내용을 보여주기 때문에 boardData 객체를 request 객체에 담아준다.
			request.setAttribute("boardData", boardData);
			
			// 글 수정 폼 페이지로 이동하기 위한 경로 설정
			forward.setPath("/WEB-INF/views/board/boardModify.jsp");
		}
		forward.setRedirect(false);
		return forward;
	}
}
