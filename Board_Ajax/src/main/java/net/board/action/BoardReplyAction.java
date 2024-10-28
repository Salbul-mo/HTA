package net.board.action;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import net.common.action.*;
import net.board.db.*;

public class BoardReplyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ActionForward forward = new ActionForward();
		BoardDAO boardDAO = new BoardDAO();
		int board_num = Integer.parseInt(request.getParameter("num"));
			
		BoardBean boardData = boardDAO.getDetail(board_num);
		// 원본 글의 내용을 DAO 에서 읽은 후 얻은 결과를 boardData 객체에 저장
		
		// boardData = null; //error 테스트를 위한 강제 값 설정
		// DAO 에서 글의 내용을 읽지 못했을 경우 null 반환
		if (boardData == null) {
			System.out.println("원본 글이 존재하지 않습니다.");
			request.setAttribute("message", "원본 글이 존재하지 않습니다..");
			forward.setPath("/WEB-INF/views/error/error.jsp");
		} else {
			System.out.println("답변 페이지 이동 성공");
			// request 객체에 boardData 저장
			request.setAttribute("boardData", boardData);
			forward.setPath("/WEB-INF/views/board/boardReplyWrite.jsp");
			// 답변 작성 페이지로 경로 설정
		}
		forward.setRedirect(false);
		return forward;
	}
}
