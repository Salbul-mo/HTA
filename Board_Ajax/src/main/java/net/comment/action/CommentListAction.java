package net.comment.action;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import net.common.action.*;
import net.comment.db.*;
import com.google.gson.*;
import java.io.*;

public class CommentListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		CommentDAO commentDAO = new CommentDAO();
		
		// {"comment_board_num"} : ${"#comment_board_num"}.val(), state:state}, 
		// state 값이 1=> 등록순 2=> 최신순
		int comment_board_num = Integer.parseInt(request.getParameter("comment_board_num"));
		System.out.println(comment_board_num);
		int state = Integer.parseInt(request.getParameter("state"));
		int listCount = commentDAO.getListCount(comment_board_num);
		
		JsonObject object = new JsonObject();
		object.addProperty("listCount", listCount);
		
		JsonArray jarray = commentDAO.getCommentList(comment_board_num, state);
		JsonElement je = new Gson().toJsonTree(jarray);
		object.add("commentList", je);
		
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(object.toString());
		System.out.println(object.toString());
		return null;
		
		
	}

}
