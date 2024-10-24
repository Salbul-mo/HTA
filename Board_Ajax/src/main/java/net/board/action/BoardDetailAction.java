package net.board.action;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import net.common.action.*;
import net.board.db.*;

public class BoardDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardDAO boardDAO = new BoardDAO();
		
		// 글 번호 파라미터 값을 board_num 에 저장
		int board_num = Integer.parseInt(request.getParameter("num"));
		
		// boards/list 에서 boards/detail 로 이동 후 sessionReferer 확인 (조회수 장난 막기)
		HttpSession session = request.getSession();
		String sessionReferer = (String) session.getAttribute("referer");
		
		if (sessionReferer != null && sessionReferer.equals("list")) {
			
			// 특정 주소로부터 이동을 확인하는데 사용할 수 있는 정보는 request Header의 "referer"에 있다.
			String headerReferer = request.getHeader("referer");
			
			if (headerReferer != null && headerReferer.contains("boards/list")) {
				// 내용을 확인할 글의 조회수를 증가시킨다.
				if (boardDAO.setReadCountUpdate(board_num))
					System.out.println("count 증가");
			}
			
			session.removeAttribute("referer");
		}
			
		// 글의 내용을 DAO 에서 읽은 후 얻은 결과를 boardData 객체에 저장
		BoardBean boardData = boardDAO.getDetail(board_num);
		
		ActionForward forward = new ActionForward();
		
		// boardData = null; //error 테스트를 위한 강제 값 설정
		// DAO 에서 글의 내용을 읽지 못했을 경우 null 반환
		if (boardData == null) {
			System.out.println("상세보기 실패");
			request.setAttribute("message", "데이터를 읽지 못했습니다.");
			forward.setPath("/WEB-INF/views/error/error.jsp");
		} else {
			System.out.println("상세보기 성공");
			// request 객체에 boardData 저장
			request.setAttribute("boardData", boardData);
			forward.setPath("/WEB-INF/views/board/boardView.jsp");
			// 글 내용 보기 페이지로 경로 설정
		}
		forward.setRedirect(false);
		return forward;
	}

}
