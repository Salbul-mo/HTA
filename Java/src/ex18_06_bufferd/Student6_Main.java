package ex18_06_bufferd;

import java.util.*;

public class Student6_Main {
	public static void main(String args[]) {
		ArrayList<Student6> as = new ArrayList<Student6>();
		input(as);
		Collections.sort(as);
		print(as);
	}

	private static int inputNumber(Scanner sc, int min, int max) {
		while (true) {
			try {
				int number = Integer.valueOf(sc.nextLine());
				if (min <= number && number <= max)
					return number;
				else {
					System.out.print(min + " ~ " + max + " 사이의 숫자로 다시 입력하세요>");
					continue;
				}
			} catch (Exception e) {
				System.out.print("숫자로 다시 입력하세요>");
			}
		}
	}

	private static void input(ArrayList<Student6> as) {

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("이름을 입력하세요>");
			String name = sc.nextLine();
			System.out.print("국어 점수를 입력하세요(0~100)>");
			int kor = inputNumber(sc, 0, 100);
			System.out.print("영어 점수를 입력하세요(0~100)>");
			int eng = inputNumber(sc, 0, 100);
			System.out.print("수학 점수를 입력하세요(0~100)>");
			int math = inputNumber(sc, 0, 100);
			as.add(new Student6(name, kor, eng, math));
			System.out.print("계속 입력하시겠습니까?(q 또는 Q이면 종료 그외는 계속)");
			String str = sc.nextLine();
			if (str.equalsIgnoreCase("q")) {
				break;
			}
		}
		sc.close();
	}

	public static void print(ArrayList<Student6> as) {

		System.out.println("=========== 학생별 / 과목별 총점 구하기 ===========");
		System.out.println("\t국어\t영어\t수학\t총점\t평균");

		for (int i = 0; i < as.size(); i++) {
			System.out.println(as.get(i).toString());
		}

		System.out.print(String.format("%48s", "\n총점").replace(" ", "="));
		for (int sub : Student6.subject) {
			System.out.print("\t" + sub);
		}
		System.out.println();
	}

}
