package net.board.action;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import net.common.action.*;
import net.board.db.*;

public class BoardReplyProcessAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardDAO boardDAO = new BoardDAO();
		ActionForward forward = new ActionForward();

		int board_re_ref = Integer.parseInt(request.getParameter("board_re_ref"));
		int board_re_lev = Integer.parseInt(request.getParameter("board_re_lev"));
		int board_re_seq = Integer.parseInt(request.getParameter("board_re_seq"));
		String board_subject = request.getParameter("board_subject");
		String board_pass = request.getParameter("board_pass");
		String board_name = request.getParameter("board_name");
		String board_content = request.getParameter("board_content");
		
		BoardBean boardData = new BoardBean();
		boardData.setBoard_name(board_name);
		boardData.setBoard_pass(board_pass);
		boardData.setBoard_subject(board_subject);
		boardData.setBoard_content(board_content);
		boardData.setBoard_re_ref(board_re_ref);
		boardData.setBoard_re_lev(board_re_lev);
		boardData.setBoard_re_seq(board_re_seq);
		
		int result = boardDAO.boardReply(boardData); // 답변 board_num
		
		if (result == 0) {
			System.out.println("답변 저장 실패");
			forward.setRedirect(false);
			request.setAttribute("message", "답변 저장 실패입니다");
			forward.setPath("/WEB-INF/views/error/error.jsp");
		} else {
			System.out.println("답변 완료");
			forward.setRedirect(true);
			forward.setPath("detail?num=" + result);
		}
		
		return forward;
	}

}
