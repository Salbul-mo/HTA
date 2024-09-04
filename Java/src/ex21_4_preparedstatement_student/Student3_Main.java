package ex21_4_preparedstatement_student;

import java.util.*;

public class Student3_Main {

	static String[] menus = new String[] { "입력", "조회", "수정", "삭제", "모두조회", "종료" };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		DAO dao = new DAO();
		do {
			int menu = menuselect(sc);
			switch (menu) {
			case 1:
				insert(sc, dao);
				break;
			case 2:
				select(sc, dao);
				break;
			case 3:
				update(sc, dao);
				break;
			case 4:
				delete(sc, dao);
				break;
			case 5:
				selectAll(dao);
				break;
			case 6:
				sc.close();
				return;
			}
		} while (true);
	}

	private static int menuselect(Scanner sc) {
		int i = 1;
		System.out.println("==================================================");
		for (String str : menus) {
			System.out.println(i++ + "." + str);
		}
		System.out.println("==================================================");
		System.out.print("메뉴를 선택하세요>");

		return inputNumber(sc, 1, menus.length);
	}

	private static int inputNumber(Scanner sc, int start, int end) {

		while (true) {
			try {
				int inputNumber = Integer.parseInt(sc.nextLine());

				if (inputNumber < start || end < inputNumber) {
					System.out.print(start + "~" + end + "사이의 숫자를 입력하세요>");
					continue;
				}

				return inputNumber;
			} catch (NumberFormatException ne) {
				System.out.print("숫자로 입력하세요>");
				continue;
			}
		}
	}

	private static void insert(Scanner sc, DAO dao) {
		String name = null;
		int kor;
		int math;
		int eng;
		
		while(name == null ||name.trim().length() == 0) {
		System.out.print("이름을 입력하세요>");
		name = sc.nextLine();
		}

		System.out.print("국어 점수를 입력하세요(0~100)>");
		kor = inputNumber(sc, 0, 100);

		System.out.print("수학 점수를 입력하세요(0~100)>");
		math = inputNumber(sc, 0, 100);

		System.out.print("영어 점수를 입력하세요(0~100)>");
		eng = inputNumber(sc, 0, 100);

		Student3 s = new Student3(name, kor, math, eng);

		int result = dao.insert(s);
		
		if (result > 0)
			System.out.println("삽입 되었습니다.");
	}

	private static void select(Scanner sc, DAO dao) {
		// TODO Auto-generated method stub
	}

	private static void update(Scanner sc, DAO dao) {
		// TODO Auto-generated method stub

	}

	private static void delete(Scanner sc, DAO dao) {
		// TODO Auto-generated method stub

	}

	private static void selectAll(DAO dao) {
		// TODO Auto-generated method stub

	}

}
