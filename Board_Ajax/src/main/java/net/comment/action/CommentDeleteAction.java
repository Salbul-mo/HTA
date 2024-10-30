package net.comment.action;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.common.action.Action;
import net.common.action.ActionForward;
import net.comment.db.*;

public class CommentDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		CommentDAO commentDAO = new CommentDAO();
		
		int result = commentDAO.commentDelete(num);
		PrintWriter out = response.getWriter();
		out.print(result);
		
		return null;
	}

}
