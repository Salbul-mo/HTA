package net.board.action;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import net.common.action.*;
import net.board.db.*;

public class BoardDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int num = Integer.parseInt(request.getParameter("num"));

		BoardDAO boardDAO = new BoardDAO();

		// 글 삭제 명령을 요청한 사용자가 글을 작성한 사용자인지 판단하기 위해
		// 입력한 비밀번호와 저장된 비밀번호를 비교하여 일치하면 삭제한다.

		boolean usercheck = boardDAO.isBoardWriter(num, request.getParameter("board_pass"));

		// 비밀번호 일치하지 않는 경우
		if (!usercheck) {

			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('비밀번호가 다릅니다');");
			out.print("history.back();");
			out.print("</script>");
			out.close();
			return null;
		}

		// 비밀번호가 일치하는 경우 삭제한다.

		if (!boardDAO.boardDelete(num)) {
			System.out.println("게시판 삭제 실패");
			ActionForward forward = new ActionForward();
			forward.setRedirect(false);
			request.setAttribute("message", "데이터를 삭제하지 못했습니다.");
			forward.setPath("/WEB-INF/views/error/error.jsp");
			return forward;
		} else {
			// 삭제 처리 성공한 경우
			System.out.println("게시판 삭제 성공");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('삭제 되었습니다.');");
			out.print("location.href='list';");
			out.print("</script>");
			out.close();
			return null;
		}

	}

}
