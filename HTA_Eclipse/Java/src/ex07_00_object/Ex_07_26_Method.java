package ex07_00_object;

public class Ex_07_26_Method {
	
	public static void main(String args[]) {
		
		String name[] = { "강호동", "이승기", "유재석", "하하", "이광수" };
		String sub_name[] = { "국어", "수학", "영어" };
		int[][] score = { { 85, 60, 70 }, // 0행("강호동")
				{ 90, 95, 80 }, // 1행("이승기")
				{ 75, 80, 100 }, // 2행("유재석")
				{ 80, 70, 95 }, // 3행("하하")
				{ 100, 65, 80 } // 4행("이광수")
		};
		int[] subject = getSubjectTotal(score);
		int[] student = getStudentTotal(score);
		
		print(name, sub_name, score,subject, student);
		
	} //main() end



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
			System.out.printf("%s\t%d\t%d\t%d", "과목총점", subject[0], subject[1], subject[2]);
		
		
	}

	private static int[] getStudentTotal(int[][] score) {
		// TODO Auto-generated method stub
		
		int[] student = new int[score.length];
		for(int i = 0; i < score.length; i++) {
			for(int j = 0; j < score[i].length; j++ ) {
				student[i] += score[i][j];
			}
		}
		return student; 
	}

	private static int[] getSubjectTotal(int[][] score) {
		// TODO Auto-generated method stub
		int[] subject = new int[score[0].length];
		for(int i = 0; i < score.length; i++) {
			for(int j = 0; j < score[i].length; j++ ) {
				subject[j] += score[i][j];
			}
		}
		return subject;
	}
	
	/*private static int[][] getTotal(int[][] score) {
	 * int[][] total = 
	 * for(int i = 0; i < score.length; i++) {
			for(int j = 0; j < score[i].length; j++ ) {
	 * 
	 */
}
