package net.board.action;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.board.db.BoardBean;
import net.board.db.BoardDAO;
import net.common.action.Action;
import net.common.action.ActionForward;

import java.io.IOException;

public class BoardAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardDAO boardDAO = new BoardDAO();
		BoardBean boardData = new BoardBean();
		ActionForward forward = new ActionForward();
		
		String realFolder = "";
		
		// webapp 아래에 폴더 생성
		String saveFolder = "boardupload"; // 프로젝트 내부 폴더 이름
		
		int fileSize = 5 * 1024 * 1024; // 업로드할 파일의 최대 사이즈 5MB
		
		// 실제 저장 경로 지정하기
		ServletContext sc = request.getServletContext(); // 컨텍스트 경로를 통해 실제 업로드할 폴더 경로를 구한다.
		realFolder = sc.getRealPath(saveFolder); 
		// D:\HTA\HTA\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Board_Ajax\boardupload
		System.out.println("realFolder = " + realFolder);
		
		try {
			MultipartRequest multi = new MultipartRequest(request, realFolder, fileSize, "utf-8", new DefaultFileRenamePolicy());
			
			// BoardBean 객체에 글 등록 폼에서 입력 받은 정보들을 저장한다.
			boardData.setBoard_name(multi.getParameter("board_name"));
			boardData.setBoard_pass(multi.getParameter("board_pass"));
			boardData.setBoard_subject(multi.getParameter("board_subject"));
			boardData.setBoard_content(multi.getParameter("board_content"));
			
			// 시스템 상에 업로드된 실제 파일명을 얻어온다.
			String fileName = multi.getFilesystemName("board_file");
			boardData.setBoard_file(fileName);
			
			// 글 등록 처리를 위해 DAO 의 boardInsert() 메서드를 호출한다.
			// 글 등록 폼에서 입력한 정보가 저장되어 있는 boradData 객체 전달
			
			boolean result = boardDAO.boardInsert(boardData);
			
			if (!result) {
				System.out.println("게시판 등록 실패");
				forward.setPath("/WEB-INF/views/error/error.jsp");
				request.setAttribute("message", "게시판 등록 실패입니다.");
				forward.setRedirect(false);
			} else {
				System.out.println("게시판 등록 완료");
				
				// 글 등록이 완료되면 글 목록 보여주기 위해 "boards/list" 로 이동
				// Redirect 여부 true 로 설정한다.
				forward.setRedirect(true);
				forward.setPath("list"); // 이동할 경로 지정
			}
			
			return forward;
		} catch (IOException ex) {
			ex.printStackTrace();
			forward.setPath("/WEB-INF/views/error/error.jsp");
			request.setAttribute("message", "게시판 업로드 실패입니다.");
			forward.setRedirect(false);
			return forward;
		}
	}
}
