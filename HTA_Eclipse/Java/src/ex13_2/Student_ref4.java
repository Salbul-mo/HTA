package ex13_2;

public class Student_ref4 {

	String name;

	int[] score = new int[3];
	// [0]-국어 [1]-영어 [2]-수학
	static int[] subject = new int[3];

	Student_ref4(String name, int kor, int eng, int math) {
		this.name = name;
		score[0] = kor;
		score[1] = eng;
		score[2] = math;
		subject[0] += score[0];
		subject[1] += score[1];
		subject[2] += score[2];
	}

	public int getTotal() {
		int sum = 0;
		for (int score : score) {
			sum += score;
		}
		return sum;
	}

	public float getAverage() {
		return Math.round((getTotal() / 3f) *10) / 10.0f ;
	}

	// sort 도 Student 클래스로 할 수 있다.
	public static void sort(Student_ref4[] student_ref) {
		for (int i = 0; i < student_ref.length - 1; i++) { // < 오름차순 / > 내림차순
			for (int j = i + 1; j < student_ref.length; j++) {
				if (student_ref[i].getTotal() < student_ref[j].getTotal()) {
					Student_ref4 temp = student_ref[i];
					student_ref[i] = student_ref[j];
					student_ref[j] = temp;
				}
			}
		}
		
		/*
		 * 버블정렬?
		 * for(int i = 0 ; i < .length - 1; i++) {
		 *		for(int j = 0; j < .length - 1 - i ; j++) {
		 *			if([j].getTotal() < [j+1]/getTotal()) {
		 *				temp = [j];
		 *				[j] = [j+1];
		 *				[j+1] = temp;
		 *			}
		 *		}
		 *	}
		 */

	}
	

	public String toString() {

		return name + "\t" + score[0] + "\t" + score[1] + "\t" + score[2] + "\t" + getTotal() + "\t"
				+ getAverage() ;

	}
}
