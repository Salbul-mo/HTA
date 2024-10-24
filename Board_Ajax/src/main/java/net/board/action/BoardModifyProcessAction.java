package net.board.action;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import net.common.action.*;
import net.board.db.*;
import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.*;

public class BoardModifyProcessAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardDAO boardDAO = new BoardDAO();
		BoardBean boardData = new BoardBean();
		ActionForward forward = new ActionForward();
		
		String saveFolder = "boardupload"; // 프로젝트의 업로드 폴더 이름
		
		int fileSize = 5 * 1024 * 1024; // 업로드할 파일의 최대 사이즈 5MB
		
		// 실제 저장 경로를 지정한다.
		ServletContext sc = request.getServletContext();
		String realFolder = sc.getRealPath(saveFolder); // 실제 서버의 업로드 폴더 경로
		System.out.println("realFolder= " + realFolder);
		
		try {
			MultipartRequest multi = new MultipartRequest(request, realFolder, fileSize, "utf-8", new DefaultFileRenamePolicy());
			
			int num = Integer.parseInt(multi.getParameter("board_num"));
			String pass = multi.getParameter("board_pass");
			
			// 글쓴이 인지 확인하기 위해 저장된 비밀번호와 입력한 비밀번호를 비교한다.
			boolean usercheck = boardDAO.isBoardWriter(num, pass);
			
			if (!usercheck) {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.print("<script>");
				out.print("alert('비밀번호가 다릅니다.');");
				out.print("history.back();");
				out.print("</script>");
				out.close();
				return null;
			}
			
			// 비밀번호가 일치하는 경우 수정 내용을 설정한다.
			// BoardBean 객체에 글 등록 폼에서 입력 받은 정보들을 저장
			boardData.setBoard_num(num);
			boardData.setBoard_subject(multi.getParameter("board_subject"));
			boardData.setBoard_content(multi.getParameter("board_content"));
			
			String check = multi.getParameter("check");
			System.out.println("check = " + check);
			
			if (check != null) {
				boardData.setBoard_file(check);
			} else {
				// 업로드된 파일의 시스템 상에 업로드된 실제 파일명을 얻어온다.
				String filename = multi.getFilesystemName("board_file");
				boardData.setBoard_file(filename);
			}
			
			// DAO 에서 수정 메서드 호출하여 수정한다.
			
			boolean result = boardDAO.boardModify(boardData);
			
			// 수정에 실패한 경우
			
			if (!result) {
				System.out.println("게시판 수정 실패");
				forward.setRedirect(false);
				request.setAttribute("message", "게시판 수정 오류입니다");
				forward.setPath("/WEB-INF/views/error/error.jsp");
			} else {
				// 수정 성공의 경우
				System.out.println("게시판 수정 완료");
				forward.setRedirect(true);
				// 수정한 글을 보여주기 위해 글 내용 보기 페이지로 경로 설정
				forward.setPath("detail?num=" + boardData.getBoard_num());
			}
		} catch (IOException ex) {
			ex.printStackTrace();
			forward.setPath("/WEB-INF/views/error/error.jsp");
			request.setAttribute("message", "게시판 업로드 중 실패입니다.");
			forward.setRedirect(false);
		}
		return forward;
	}

}
