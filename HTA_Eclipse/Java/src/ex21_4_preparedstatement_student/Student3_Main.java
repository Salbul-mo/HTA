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
		System.out.println("===========================================================");
		for (String str : menus) {
			System.out.println(i++ + "." + str);
		}
		System.out.println("===========================================================");
		System.out.print("메뉴를 선택하세요>");

		return inputNumber(sc, 1, menus.length);
	}

	private static int inputNumber(Scanner sc, int start, int end) {

		while (true) {
			try {
				int inputNumber = Integer.parseInt(sc.nextLine());

				if (start == 0 && end == 0) // inputNumber(sc, 0, 0) 으로 호출 시 입력값 그대로 반환
					return inputNumber;

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

	// inputNumber(sc, start, end) 메서드 재활용 생각하자.
	private static void insert(Scanner sc, DAO dao) {

		String name = null;
		int kor;
		int math;
		int eng;

		while (name == null || name.trim().length() == 0) {
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
		System.out.print("조회할 번호를 입력하세요>");
		int no = inputNumber(sc, 0, 0);

		Student3 s = dao.select(no);
		if (s == null) {
			System.out.println("해당 번호로 조회된 학생이 없습니다.");
			return;
		}

		System.out.println("번호\t이름\t국어\t수학\t영어\t총점\t평균\t학점");
		System.out.println(s.toString());

	}

	private static void update(Scanner sc, DAO dao) {
		System.out.print("수정할 번호를 입력하세요>");
		int no = inputNumber(sc, 0, 0);

		if (!isExist(no, dao)) {
			System.out.println("테이블에 없는 번호입니다.");
			return;
		}

		String newName = null;

		while (newName == null || newName.trim().length() == 0) {
			System.out.print("이름을 입력하세요>");
			newName = sc.nextLine();
		}

		int newKor, newMath, newEng;

		System.out.print("국어 점수를 입력하세요(0~100)>");
		newKor = inputNumber(sc, 0, 100);

		System.out.print("수학 점수를 입력하세요(0~100)>");
		newMath = inputNumber(sc, 0, 100);

		System.out.print("영어 점수를 입력하세요(0~100)>");
		newEng = inputNumber(sc, 0, 100);

		Student3 newStudent = new Student3(newName, newKor, newMath, newEng);

		newStudent.setNo(no);

		if (dao.update(newStudent) == 1)
			System.out.println("수정이 되었습니다.");
		else
			System.out.println("수정 중 오류 발생했습니다.");
	}

	private static void delete(Scanner sc, DAO dao) {
		System.out.print("삭제할 번호를 입력하세요>");
		int no = inputNumber(sc, 0, 0);
		// inputNumber(sc, 0, 0) 을 호출하는 inputNumber(sc)를 따로 오버로딩으로 만들어서 사용한다.

		if (!isExist(no, dao)) {
			System.out.println("테이블에 없는 번호입니다.");
			return;
		}

		if (dao.delete(no) == 1)
			System.out.println("삭제 되었습니다.");
		else
			System.out.println("삭제 되지 않았습니다.");

	}

	private static void selectAll(DAO dao) {
		ArrayList<Student3> allList = dao.selectAll();

		if (allList.isEmpty()) {
			System.out.println("테이블에 데이터가 없습니다.");
		} else {
			System.out.println("번호\t이름\t국어\t수학\t영어\t총점\t평균\t학점");
			// allList.forEach(System.out::println);
			// ArrayList 도 forEach 사용할 수 있다.
			// System.out.println(Object) => System.out.println(Object.toString())
			for (Student3 s : allList) {
				System.out.println(s.toString());
			}
		}

	}

	private static boolean isExist(int no, DAO dao) {
		Student3 check = dao.select(no);

		if (check == null)
			return false;

		return true;
		// return dao.select(no,dao) != null // null 이면 false, 아니면 true
	}

}
