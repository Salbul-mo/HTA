package net.template.action;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import net.template.db.*;


public class  TemplateJoinProcess extends HttpServlet {
	
	private static final long serialVersionUID = 6121597972569738161L;

	public TemplateJoin getTemplateJoin(HttpServletRequest request) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String jumin = request.getParameter("jumin1") + "-" + request.getParameter("jumin2");
		String email = request.getParameter("email") + "@" +request.getParameter("domain");
		String gender = request.getParameter("gender");
		String hobby = String.join(",", request.getParameterValues("hobby"));
		String post = request.getParameter("post1");
		String address = request.getParameter("address");
		String intro = request.getParameter("intro");
		
		TemplateJoin templateJoin = new TemplateJoin();
		templateJoin.setId(id);
		templateJoin.setPassword(pass);
		templateJoin.setJumin(jumin);
		templateJoin.setEmail(email);
		templateJoin.setGender(gender);
		templateJoin.setHobby(hobby);
		templateJoin.setPost(post);
		templateJoin.setAddress(address);
		templateJoin.setIntro(intro);
		
		return templateJoin;
	}

}
