package net.comment.action;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import net.common.action.*;
import net.comment.db.*;

public class CommentAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CommentDAO commentDAO = new CommentDAO();
		
		Comment co = new Comment();
		
		co.setId(request.getParameter("id"));
		co.setContent(request.getParameter("content"));
		System.out.println("content = " + co.getContent());
		co.setComment_board_num(Integer.parseInt(request.getParameter("comment_board_num")));
		co.setComment_re_lev(Integer.parseInt(request.getParameter("comment_re_lev")));
		co.setComment_re_seq(Integer.parseInt(request.getParameter("comment_re_seq")));
		
		int ok = commentDAO.commentInsert(co);
		response.getWriter().print(ok);
		return null;
		
	}
}
