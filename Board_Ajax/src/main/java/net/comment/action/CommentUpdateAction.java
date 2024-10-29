package net.comment.action;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import net.common.action.*;
import net.comment.db.*;

public class CommentUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CommentDAO commentDAO = new CommentDAO();
		Comment co = new Comment();
		co.setNum(Integer.parseInt(request.getParameter("num")));
		co.setContent(request.getParameter("content"));
		
		int result = commentDAO.commentUpdate(co);
		response.getWriter().print(result);
		
		return null;
	}

}
