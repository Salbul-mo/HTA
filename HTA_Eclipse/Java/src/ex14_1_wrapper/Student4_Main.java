package ex14_1_wrapper;

import java.util.Scanner;

public class Student4_Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("학생 수를 입력하세요(최대10명)>");
		int su = inputNumber(sc);
		Student4 arr[] = new Student4[su];
		input(arr, sc);

		Student4.sort(arr);
		printStudent(arr);
		sc.close();

	}

	private static int inputNumber(Scanner sc) {
		while (true) {
			int number = inputNumber(sc, 1, 10);
			return number;

		}

	}

	private static int inputNumber(Scanner sc, int min, int max) {
		while (true) {
			try {
				int number = Integer.valueOf(sc.nextLine());
				if (min <= number && number <= max)
					return number;
				else {
					System.out.println(min + " ~ " + max + " 범위 안의 숫자를 입력하세요.");
					continue;
				}
			} catch (Exception e) {
				System.out.println("숫자로 입력하세요.");
			}
		}
	}

	private static void input(Student4[] arr, Scanner sc) {
		for (int i = 0; i < arr.length; i++) {

			arr[i] = new Student4();
			// 배열만 넘어왔지 실제 Student4 객체가 생성되지 않아서 null로 출력된다.
			// 기본 생성자로 바꾸고 입력받은 값으로 필드 초기화하도록 바꿈.
			// 그냥 국어 영어 수학 점수 차례대로 int로 받고 arr[i] = new Student4(name, int, int, int )
			// 생성자 호출했으면 더 간단했다.
			System.out.println((i + 1) + "번째 사람");
			System.out.println("이름을 입력하세요.");
			(arr[i]).name = sc.nextLine();
			for (int j = 0; j < (arr[i].score).length; j++) {
				switch (j) {
				case 0:
					System.out.print("국어 점수를 입력하세요(0~100)>");
					(arr[i]).score[j] = inputNumber(sc, 0, 100);
					Student4.subject[j] += (arr[i]).score[j];
					continue;
				case 1:
					System.out.print("영어 점수를 입력하세요(0~100)>");
					(arr[i]).score[j] = inputNumber(sc, 0, 100);
					Student4.subject[j] += (arr[i]).score[j];
					continue;
				case 2:
					System.out.print("수학 점수를 입력하세요(0~100)>");
					(arr[i]).score[j] = inputNumber(sc, 0, 100);
					Student4.subject[j] += (arr[i]).score[j];
					continue;
				}
			}
		}
	}

	public static void printStudent(Student4[] arr) {

		System.out.println("=========== 학생별 / 과목별 총점 구하기 ===========");
		System.out.println("\t국어\t영어\t수학\t총점\t평균");

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i].toString());
		}

		System.out.print(String.format("%48s", "\n총점").replace(" ", "="));
		for (int sub : Student4.subject) {
			System.out.print("\t" + sub);
		}
		System.out.println();
	}

}
