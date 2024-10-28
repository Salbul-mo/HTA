package net.member.action;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import net.common.action.*;
import net.member.db.*;
import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.*;

public class MemberUpdateProcessAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MemberDAO memberDAO = new MemberDAO();
		Member mem = new Member();
		ActionForward forward = new ActionForward();
		
		String realFolder = "";
		
		// webapp 아래에 폴더 생성
		String saveFolder = "memberupload"; // 프로젝트 내부 폴더 이름
		
		int fileSize = 5 * 1024 * 1024; // 업로드할 파일의 최대 사이즈 5MB
		
		// 실제 저장 경로 지정하기
		ServletContext sc = request.getServletContext(); // 컨텍스트 경로를 통해 실제 업로드할 폴더 경로를 구한다.
		realFolder = sc.getRealPath(saveFolder); 
		// D:\HTA\HTA\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Board_Ajax\memberupload
		System.out.println("realFolder = " + realFolder);
		
		try {
			MultipartRequest multi = new MultipartRequest(request, realFolder, fileSize, "utf-8", new DefaultFileRenamePolicy());
			
			// member 객체에 수정 폼에서 입력 받은 정보들을 저장한다.
			// multipartRequest 객체를 사용하므로 그곳에서 데이터를 꺼내야 한다.
			String id =  request.getParameter("id");
			String pass =  request.getParameter("pass");
			String name = multi.getParameter("name");
			int age = Integer.parseInt(multi.getParameter("age"));
			String gender = multi.getParameter("gender");
			String email = multi.getParameter("email");
			// 시스템 상에 업로드된 실제 파일명을 얻어온다.
			String memberfile = multi.getFilesystemName("memberfile"); 
			
			mem.setId(id);
			mem.setPassword(pass);
			mem.setName(name);
			mem.setAge(age);
			mem.setGender(gender);
			mem.setEmail(email);
			mem.setMemberfile(memberfile);
			
			
			boolean result = memberDAO.updateMember(mem);
			
			if (!result) {
				System.out.println("회원 정보 수정 실패");
				forward.setPath("/WEB-INF/views/error/error.jsp");
				request.setAttribute("message", "회원 정보 수정 실패입니다.");
				forward.setRedirect(false);
			} else {
				System.out.println("회원 정보 수정 성공");
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.print("<script>");
				out.print("alert('회원 정보 수정 되었습니다.');");
				out.print("location.href='boards/list';");
				out.print("</script>");
				out.close();
				return null;
			}
		} catch (IOException ex) {
			ex.printStackTrace();
			forward.setPath("/WEB-INF/views/error/error.jsp");
			request.setAttribute("message", "회원 정보 수정 실패입니다.");
			forward.setRedirect(false);
			return forward;
		}
		
		return null;
	}
}
