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

			case 5:
				selectAll(dao);
				break;

			case 7:
				sc.close();
				return;
			}
		} while (true);
	}

	private static void selectAll(BoardDAO_seq dao) {
		List<Board> list = dao.getBoardList(1, 10);
		
		if(list.isEmpty()) {
			System.out.println("테이블에 데이터가 없습니다.");
		}
		printTitle();
		list.forEach(System.out::println);
	}

	private static void selectPage(Scanner sc, BoardDAO_seq dao) {

	}

	private static void insert(Scanner sc, BoardDAO_seq dao) {
		// 원본 글 등록 re_ref = board_num, re_lev = 0, re_seq = 0, readcount = 0, date = sysdate
		Board board = new Board();

		System.out.print("작성자를 입력하세요>");
		board.setBoard_name(sc.nextLine());

		System.out.print("비밀번호를 입력하세요>");
		board.setBoard_pass(sc.nextLine());

		System.out.print("제목을 입력하세요>");
		board.setBoard_subject(sc.nextLine());

		System.out.print("내용을 입력하세요>");
		board.setBoard_content(sc.nextLine());

		if (dao.boardInsert(board) == 1)
			System.out.println("글이 작성되었습니다.");
		else
			System.out.println("오류가 발생되었습니다.");

	}

	private static int menuselect(Scanner sc) {
		String[] menus = { "글쓰기", "수정", "답변달기", "글삭제", "조회", "페이지 선정", "종료" };
		int i = 1;

		System.out.println("=".repeat(120));

		for (String str : menus)
			System.out.println(i++ + "." + str);

		System.out.println("=".repeat(120));

		System.out.print("메뉴를 선택하세요>");

		return inputNumber(sc, 1, menus.length);
	}

	private static void printTitle() {
		System.out.println("글번호\t작성자\t\t제목\t\t\t내용\t\t\tref\tlev\tseq\tdate");
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
				System.out.println("숫자로 입력하세요.");
			}
		}
	}

	private static Board select(BoardDAO_seq dao, int board_num) {

		return new Board();
	}

	private static void reply(Scanner sc, BoardDAO_seq dao) {

	}

	private static void update(Scanner sc, BoardDAO_seq dao) {

	}

	private static void delete(Scanner sc, BoardDAO_seq dao) {

	}
}
