package ex07_00_object;

public class Ex_07_26_Method3 {

	public static void main(String args[]) {

		String name[] = { "강호동", "이승기", "유재석", "하하", "이광수" };
		String sub_name[] = { "국어", "수학", "영어" };
		int[][] score = { { 85, 60, 70 }, // 0행("강호동")
				{ 90, 95, 80 }, // 1행("이승기")
				{ 75, 80, 100 }, // 2행("유재석")
				{ 80, 70, 95 }, // 3행("하하")
				{ 100, 65, 80 } // 4행("이광수")
		};

		// 한번에 구하는 메서드
		int[][] total = getTotal(score);
		int[] subject2 = total[0];
		int[] student2 = total[1];
		// 한번에 구하는 메서드

		print(name, sub_name, score, subject2, student2);

		sort(score, student2, name);
		print(name, sub_name, score, subject2, student2);

	} // main() end

	private static void sort(int[][] score, int[] student, String[] name) {

		for (int i = 0; i < score.length - 1; i++) {
			for (int j = i + 1; j < score.length; j++) {
				if (student[i] > student[j]) {
					String temp = name[i];
					name[i] = name[j];
					name[j] = temp;

					int[] temp2 = score[i]; // 다차원 배열에서 행의 참조값만 바꿔줘도 행이 바뀐것과 같다.
					score[i] = score[j]; // 일일이 정수값을 바꿔주지 않아도 된다.
					score[j] = temp2;

					int temp3 = student[i];
					student[i] = student[j];
					student[j] = temp3;

				}
			}
		}
	}

	private static void print(String[] name, String[] sub_name, int[][] score, int[] subject, int[] student) {
		// TODO Auto-generated method stub
		System.out.println("=========== 학생별 / 과목별 총점 구하기 ===========");
		for (int i = 0; i < sub_name.length; i++) {
			if (i == 0) {
				System.out.printf("\t%s\t", sub_name[i]);
			} else {
				System.out.printf("%s\t", sub_name[i]);
			}
		}
		System.out.printf("%s\t%s\n", "총점", "평균");

		for (int i = 0; i < name.length; i++) {
			System.out.print(name[i] + "\t");
			for (int j = 0; j < sub_name.length; j++) {
				System.out.print(score[i][j] + "\t");
			}

			System.out.printf("%d\t%.1f", student[i], ((double) student[i] / sub_name.length));
			System.out.println();
		}

		System.out.println("============================================");
		System.out.printf("%s\t%d\t%d\t%d\n", "과목총점", subject[0], subject[1], subject[2]);

	}

	// 총점 두 가지를 한번에 출력하려면 가변 배열을 사용할 수 있다.
	private static int[][] getTotal(int[][] score) {
		int[][] total = { { 0, 0, 0 }, // 과목 총점
				{ 0, 0, 0, 0, 0 } // 학생 총점
		};
		for (int i = 0; i < score.length; i++) { // 학생
			for (int j = 0; j < score[i].length; j++) { // 과목
				total[0][j] += score[i][j];
				total[1][i] += score[i][j];
			}
		}
		return total;
	}

}
