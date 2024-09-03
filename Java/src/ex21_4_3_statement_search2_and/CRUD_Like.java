package ex21_4_3_statement_search2_and;

import java.util.*;

public class CRUD_Like {
	static String menus[] = { "사원번호", "사원이름", "직급", "매니저", "입사일자", "급여", "커미션", "부서번호", "종료" };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] search_word = menuselect();
		search(search_word);

		sc.close();
	}

	private static void search(String[] search_word) {
		DAO_Like dao = new DAO_Like();
		ArrayList<Emp> list = dao.search(search_word);

		if (list.isEmpty()) {
			System.out.println("검색 결과가 없습니다.");
		} else {
			System.out.printf("%s\t%s\t%s\t\t%s\t%s\t\t%s\t%s\t%s\t\n", menus[0], menus[1], menus[2], menus[3],
					menus[4], menus[5], menus[6], menus[7]);
			for (Emp s : list) {
				System.out.println(s.toString());
			}
		}

	}

	private static String searchData(Scanner sc, int menu) {
		switch (menu) {
		case 1 -> System.out.print("조회할 사원번호를 입력하세요>");
		case 2 -> System.out.print("조회할 사원이름를 입력하세요>");
		case 3 -> System.out.print("조회할 직급을 입력하세요>");
		case 4 -> System.out.print("조회할 매니저를 입력하세요>");
		case 5 -> System.out.print("조회할 입사일자를 입력하세요>");
		case 6 -> System.out.print("조회할 급여를 입력하세요>");
		case 7 -> System.out.print("조회할 커미션을 입력하세요>");
		case 8 -> System.out.print("조회할 부서번호를 입력하세요>");
		}
		return sc.nextLine();
	}
	// 향상된 switch 문은 case 의 코드 블럭이 두 줄 이상이면 {} 로 감싸주어야 힌다.

	private static String[] menuselect() {
		// Scanner 객체 생성
		Scanner sc = new Scanner(System.in);
		// 8개의 크기를 갖는 String배열 search 선언
		String[] search = new String[8];

		int i = 0;

		for (String m : menus) {
			System.out.println(++i + "." + m);
		}
		// 메뉴 출력
		int menu = 0;

		do {
			System.out.print("조회할 컬럼을 선택하세요>");

			// menu에 inputNumber(sc) 호출한 결과 저장;
			menu = inputNumber(sc);

			if (menu == 9) {
				sc.close();
				break;
			}

			// search의 특정 컬럼에 searchData(sc, menu) 호출한 결과 저장
			search[menu - 1] = searchData(sc, menu);
			// menu 에서 1을 빼야 맞는 위치에 들어간다.

		} while (true);

		return search;
	}

	static int inputNumber(Scanner sc) {

		try {
			int input = Integer.valueOf(sc.nextLine());

			while (input < 1 || input > 9) {
				System.out.print("1~9 사이의 숫자를 입력하세요>");
				input = Integer.valueOf(sc.nextLine());

			}

			return input;

		} catch (NumberFormatException ne) {
			System.out.print("숫자로 입력하세요>");
			return inputNumber(sc);
		}
	}

}
