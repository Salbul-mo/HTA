package ex06_1_array;

public class HomeWork_ref {

	public static void main(String args[]) {
		String name[] = { "강호동", "이승기", "유재석", "하하", "이광수" };
		String sub_name[] = { "국어", "수학", "영어" };
		int[][] score = { { 85, 60, 70 }, // 0행("강호동")
				{ 90, 95, 80 }, // 1행("이승기")
				{ 75, 80, 100 }, // 2행("유재석")
				{ 80, 70, 95 }, // 3행("하하")
				{ 100, 65, 80 } // 4행("이광수")
		};
		int[] subject = new int[3]; // 과목총점 저장
		/*
		 * for (int j = 0; j < sub_name.length; j++) { for (int i = 0; i < name.length;
		 * i++) { subject[j] += score[i][j]; } }
		 */

		int[] student = new int[5]; // 학생의 총점 저장
		/*
		 * int c;
		 * 
		 * for (int i = 0; i < name.length; i++) { c = 0; for (int j = 0; j <
		 * sub_name.length; j++) { c += score[i][j]; } student[i] = c; }
		 */
		int r = sub_name.length;

		System.out.println("=========== 학생별 / 과목별 총점 구하기 ===========");
		//출력하면서 학생 총점, 과목 총점 합산과 출력 동시에 가능하다.
		//(과목 총점은 for문 빠져나오고 사용하기 때문이다.)		
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
				student[i] += score[i][j];
				subject[j] += score[i][j];
			}
			System.out.printf("%d\t%.1f", student[i], ((double) student[i] / r));
			System.out.println();
		}
		System.out.println("=============================================");
		System.out.printf("%s\t%d\t%d\t%d", "과목총점", subject[0], subject[1], subject[2]);

	}
}
