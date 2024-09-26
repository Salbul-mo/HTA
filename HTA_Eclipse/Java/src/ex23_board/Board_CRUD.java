package ex23_board;

import java.util.*;

public class Board_CRUD {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BoardDAO_seq dao = new BoardDAO_seq();

		do {
			int menu = menuselect(sc);
			switch (menu) {
			case 1:
				insert(sc, dao);
				break;
			case 2:
				update(sc, dao);
				break;
			case 3:
				reply(sc, dao);
				break;
			case 4:
				delete(sc, dao);
				break;
			case 5:
				selectAll(dao);
				break;
			case 6:
				selectPage(sc, dao);
				break;
			case 7:
				search(sc, dao);
				break;
			case 8:
				sc.close();
				return;
			}
		} while (true);
	}

	private static int menuselect(Scanner sc) {
		String[] menus = { "글쓰기", "수정", "답변달기", "글삭제", "조회", "페이지 선정", "검색", "종료" };
		int i = 1;

		System.out.println("=".repeat(120));

		for (String str : menus)
			System.out.println(i++ + "." + str);

		System.out.println("=".repeat(120));

		System.out.print("메뉴를 선택하세요>");

		return inputNumber(sc, 1, menus.length);
	}

	private static int inputNumber(Scanner sc) {
		return inputNumber(sc, 0, 0);
	}

	private static int inputNumber(Scanner sc, int start, int end) {
		while (true) {
			try {
				int input = Integer.parseInt(sc.nextLine());

				if (start == 0 && end == 0)
					return input;

				if (input < start || end < input) {
					System.out.println(start + "~" + end + " 사이의 숫자를 입력하세요");
					continue;
				}

				return input;

			} catch (NumberFormatException ne) {
				System.out.print("숫자로 입력하세요>");
			}
		}
	}

	private static void printTitle() {
		System.out.println("글번호\t작성자\t\t제목\t\t\t내용\t\t\tref\tlev\tseq\tdate");
	}

	private static Board select(BoardDAO_seq dao, int board_num) {
		Board board = dao.getDetail(board_num);

		if (board == null)
			System.out.println("해당 글이 존재하지 않습니다.");
		else
			System.out.println(board.toString());

		return board;
	} 
	
	private static void search(Scanner sc, BoardDAO_seq dao) {
		System.out.print("subject 또는 content 중 검색할 단어를 입력하세요>");
		String word = sc.nextLine();
		
		List<Board> list = dao.getSearchList(word);
		
		if (list == null) {
			System.out.println("해당하는 글이 존재하지 않습니다.");
		    return;
		}
		
		printTitle();
		list.forEach(System.out::println);
	}

	private static void selectAll(BoardDAO_seq dao) {
		List<Board> list = dao.getBoardList(1, 10);

		if (list.isEmpty()) {
			System.out.println("테이블에 데이터가 없습니다.");
		}
		printTitle();
		list.forEach(System.out::println);
	}

	private static void selectPage(Scanner sc, BoardDAO_seq dao) {
		int listCount = dao.count();

		if (listCount == 0) {
			System.out.println("테이블에 데이터가 없습니다.");
			return;
		}

		System.out.println("한 페이지에 보여줄 목록을 입력하세요(1~10)>");
		int limit = inputNumber(sc, 1, 10);

		int maxPage = ((listCount - 1) / limit) + 1;

		System.out.print("선택할 페이지를 입력하세요>(1~" + maxPage + ")");
		int page = inputNumber(sc, 1, maxPage);

		List<Board> arrs = dao.getBoardList(page, limit);

		printTitle();
		arrs.forEach(System.out::println);
	}

	private static void insert(Scanner sc, BoardDAO_seq dao) {
		// 원본 글 등록 re_ref = board_num, re_lev = 0, re_seq = 0
		Board board = new Board();

		System.out.print("작성자를 입력하세요>");
		board.setBoard_name(sc.nextLine());

		System.out.print("제목을 입력하세요>");
		board.setBoard_subject(sc.nextLine());

		System.out.print("내용을 입력하세요>");
		board.setBoard_content(sc.nextLine());

		System.out.print("비밀번호를 입력하세요>");
		board.setBoard_pass(sc.nextLine());
		
		if (dao.boardInsert(board) == 1)
			System.out.println("글이 작성되었습니다.");
		else
			System.out.println("오류가 발생되었습니다.");

	}

	private static void reply(Scanner sc, BoardDAO_seq dao) {
		System.out.print("답변을 달 글 번호를 입력하세요>");
		int board_num = inputNumber(sc);

		Board board = select(dao, board_num);

		if (board == null)
			return;

		System.out.print("작성자를 입력하세요>");
		board.setBoard_name(sc.nextLine());

		System.out.print("제목을 입력하세요>");
		board.setBoard_subject(sc.nextLine());

		System.out.print("내용을 입력하세요>");
		board.setBoard_content(sc.nextLine());

		System.out.print("비밀번호를 입력하세요>");
		board.setBoard_pass(sc.nextLine());

		if (dao.boardReply(board) == 1)
			System.out.println("답변 달기 성공");
		else
			System.out.println("답변 달기 실패");

	}

	private static void update(Scanner sc, BoardDAO_seq dao) {
		System.out.print("수정할 글 번호를 입력하세요>");
		int no = inputNumber(sc);

		Board board = select(dao, no);

		if (board == null)
			return;

		System.out.print("제목을 입력하세요>");
		board.setBoard_subject(sc.nextLine());

		System.out.print("내용을 입력하세요>");
		board.setBoard_content(sc.nextLine());

		System.out.print("비밀번호를 입력하세요>");
		String pass = sc.nextLine();

		if (!pass.equals(board.getBoard_pass())) {
			System.out.println("비밀번호가 다릅니다.");
			return;
		}

		if (dao.boardModify(board) == 1)
			System.out.println("수정에 성공했습니다.");
		else
			System.out.println("수정에 실패했습니다.");

	}

	private static void delete(Scanner sc, BoardDAO_seq dao) {
		System.out.print("삭제할 글 번호를 입력하세요>");
		int num = inputNumber(sc);

		Board board = select(dao, num);
		if (board == null)
			return;

		System.out.print("비밀번호를 입력하세요>");
		String pass = sc.nextLine();
		if (!pass.equals(board.getBoard_pass())) {
			System.out.println("비밀번호가 다릅니다.");
			return;
		}

		int result = dao.boardDelete(board);

		System.out.println(result + "개 삭제되었습니다.");
	}
}
