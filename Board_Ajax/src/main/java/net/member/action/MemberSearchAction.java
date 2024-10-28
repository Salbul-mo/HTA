package net.member.action;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import net.board.db.BoardBean;
import net.board.db.BoardDAO;
import net.common.action.*;
import net.member.db.*;
public class MemberSearchAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO memberDao = new MemberDAO();
		ActionForward forward = new ActionForward();
		
		// 파라미터 page 가 없다. 그래서 초기값 필요
		int page = 1; // 보여줄 초기 페이지
		int limit = 3; // 페이지당 최대 글 목록 초기값
		
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		System.out.println("넘어온 페이지 = " + page);
		
		List<Member> memberList = null;
		int listCount = 0;
		int index = -1; // search_fiedl에 존재하지 않는 값으로 초기화
		
		String search_word="";
		
		// 메뉴 - 관리자 - 회원정보 클릭한 경우 (list)
		// 또는 메뉴 - 관리자 - 회원 정보 클릭 후 페이지 클릭한 경우 (list?page=2&search_field=-1&search_word=)
		
		if (request.getParameter("search_word") == null || request.getParameter("search_word").equals("")) {
			listCount = memberDao.getListCount();
			memberList = memberDao.getMemberList(page, limit);
		} else {
			index = Integer.parseInt(request.getParameter("search_field"));
			String[] search_field = new String[] {"id","name","age","gender"};
			
			search_word = request.getParameter("search_word");
			listCount = memberDao.getListCount(search_field[index], search_word);
			memberList = memberDao.getMemberList(search_field[index], search_word, page, limit);
		}
		
		System.out.println("listCount = " + listCount); 
		
		/* 
		총 페이지 수
			= (DB 에 저장된 총 게시물의 수 + 한 페이지에서 보여주는 리스트의 수 - 1)/ 한 페이지에서 보여주는 리스트의 수 
		
		예를 들어 한 페이지에서 보여주는 리스트의 수가 10개인 경우
		예1) DB 에 저장된 총 리스트의 수 가 0 이면 총 페이지 수 는 0 페이지
		예2) DB 에 저장된 총 리스트의 수 가 (1~10) 이면 총 페이지 수는 1 페이지
		예3) DB 에 저장된 총 리스트의 수 가 (11~20) 이면 총 페이지 수는 2 페이지
		예4) DB 에 저장된 총 리스트의 수 가 (21~30) 이면 총 페이지 수는 3 페이지  
		*/
		int maxPage = (listCount + limit -1) / limit;
		System.out.println("총 페이지 수 = " + maxPage);
		
		int startPage = ((page - 1) / 10) * 10 + 1; 
		int endPage = startPage + 10 - 1; /*페이지 그룹의 총 수*/
		// 현재 페이지에서 -1 후 페이지 그룹 수로 나눈 몫에 다시 페이지그룹 수를 곱하고 +1
		System.out.println("현재 페이지에서 보여줄 시작 페이지 수 : " + startPage);
		System.out.println("현재 페이지에서 보여줄 마지막 페이지 수 : " + endPage);
		
		
		if (endPage > maxPage) {
			endPage = maxPage;
		}
		
		request.setAttribute("page", page); // 현재 페이지 수
		request.setAttribute("maxPage", maxPage); // 최대 페이지 수
		request.setAttribute("startPage", startPage); // 현재 표시할 페이지 그룹 중 첫번째
		request.setAttribute("endPage" , endPage); // 현재 표시한 페이지 그룹 중 마지막
		request.setAttribute("listCount", listCount); // 총 게시글 수 
		request.setAttribute("totalList", memberList); // 해당 페이지의 글 목록을 갖고 있는 리스트
		request.setAttribute("search_field", index);
		request.setAttribute("search_word", search_word);
		
		forward.setPath("/WEB-INF/views/member/memberList.jsp");
		forward.setRedirect(false);
		return forward;
		
		
	}
}
