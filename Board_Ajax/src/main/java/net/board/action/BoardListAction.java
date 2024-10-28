package net.board.action;

import java.io.*;
import java.util.*;
import com.google.gson.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import net.common.action.*;
import net.board.db.*;

public class BoardListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO boardDao = new BoardDAO();
		List<BoardBean> boardList = new ArrayList<>();
		
		// /boards/list 에서 /boards/detail 로 접속하는 경우에만 카운트 되도록하기 위해 세션에 저장한다.
		request.getSession().setAttribute("referer", "list");
		
		// 로그인 성공 시 파라미터 page 가 없다. 그래서 초기값 필요
		int page = 1; // 보여줄 초기 페이지
		int limit = 10; // 페이지당 최대 글 목록 초기값
		
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		System.out.println("넘어온 페이지 = " + page);
		
		// 추가
		if (request.getParameter("limit") != null) {
			limit = Integer.parseInt(request.getParameter("limit"));
		}
		System.out.println("넘어온 limit = " + limit);
		
		// 총 리스트 수를 받아온다.
		int listCount = boardDao.getListCount();
		
		// 리스트를 받아온다.
		boardList = boardDao.getBoardList(page, limit);
		
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
		System.out.println("listCount = " + listCount); 
		System.out.println("총 페이지 수 = " + maxPage);
		
		/*
		startPage : 현재 페이지 그룹에서 맨 처음에 표시될 페이지 수를 의미한다.
		([1], [11], [21], . . .)
		
		예) 페이지 그룹이 아래와 같은 경우
			[1] [2] [3] [4] [5] [6] [7] [8] [9] [10]
			
			페이지 그웁의 시작 페이지는 startPage 마지막 페이지는 endPage
		 */
		int startPage = ((page - 1) / 10) * 10 + 1; 
		// 현재 페이지에서 -1 후 페이지 그룹 수로 나눈 몫에 다시 페이지그룹 수를 곱하고 +1
		System.out.println("현재 페이지에서 보여줄 시작 페이지 수 : " + startPage);
		
		int endPage = startPage + 10 - 1; /*페이지 그룹의 총 수*/
		
		/*
		마지막 그룹의 마지막 페이지 값은 최대 페이지 값이다.
		 */
		if (endPage > maxPage) {
			endPage = maxPage;
		}
		
		System.out.println("현재 페이지에서 보여줄 마지막 페이지 수 : " + endPage);
		
		String state = request.getParameter("state"); // ajax에 실어 보낼 데이터
		
		if (state == null) { // ajax 를 사용하지 않을 경우 setAttribute()로 js 에서 사용할 정보를 담아 보낸다.
			System.out.println("state==null");
			request.setAttribute("page", page); // 현재 페이지 수
			request.setAttribute("maxPage", maxPage); // 최대 페이지 수
			request.setAttribute("startPage", startPage); // 현재 표시할 페이지 그룹 중 첫번째
			request.setAttribute("endPage" , endPage); // 현재 표시한 페이지 그룹 중 마지막
			request.setAttribute("limit", limit); // 페이지 당 표시할 게시글 수 
			request.setAttribute("listCount", listCount); // 총 게시글 수 
			request.setAttribute("boardList", boardList); // 해당 페이지의 글 목록을 갖고 있는 리스트

			ActionForward forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/board/boardList.jsp");
			return forward;
		
		} else {
			System.out.println("state=ajax");
			
			// request 에 담았던 정보를 JSON 에 담는다.
			JsonObject json = new JsonObject();
			json.addProperty("page", page);
			json.addProperty("maxPage", maxPage);
			json.addProperty("startPage", startPage);
			json.addProperty("endPage", endPage);
			json.addProperty("listCount", listCount);
			json.addProperty("limit", limit);
			
			// JsonObject 에 List 타입 담을 수 있는 addProperty() 메서드는 존재하지 않는다.
			// void com.google.gson.JsonObject.add(String property, JsonElement value) 메서드를 사용하여야 한다.
			// List 타입을 JsonElement 타입으로 바꾸어 주어야 json 객체에 저장할 수 있다.
			
			// List => JsonElement
			JsonElement je = new Gson().toJsonTree(boardList);
			System.out.println("baordList = " + je.toString());
			json.add("boardList", je);
			
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().print(json);
			System.out.println(json.toString());
			return null;
		}
	}
}
