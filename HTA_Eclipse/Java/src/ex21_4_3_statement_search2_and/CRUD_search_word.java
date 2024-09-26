package ex21_4_3_statement_search2_and;

import java.util.*;


public class CRUD_search_word {
	static String menus[] = { "사원번호", "사원이름", "직급", "매니저", "입사일자", "급여", "커미션", "부서번호", "종료" };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int menu = menuselect(sc);
		String search_word = input(menu, sc);
		System.out.println(search_word);
		sc.close();
	}
	
	private static String input(int menu, Scanner sc) {
		if (menu == 9) {
			return "";
		}
		
		return searchData(sc,menu);
		
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
	

	private static int menuselect(Scanner sc) {
		
		for (int i = 0; i < 9; i++) {
			System.out.println((i + 1) + "." + menus[i]);
		}

		System.out.print("조회할 컬럼을 선택하세요>");
		
		return inputNumber(sc);
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
