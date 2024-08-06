package ex14_1_wrapper;

public class Student4 {

	String name;

	int[] score = new int[3];
	// [0]-국어 [1]-영어 [2]-수학
	static int[] subject = new int[3];

	public int getTotal() {
		int sum = 0;
		for (int score : score) {
			sum += score;
		}
		return sum;
	}

	public float getAverage() {
		return Math.round((getTotal() / 3f) * 10) / 10.0f;
	}

	public static void sort(Student4[] student) {
		for (int i = 0; i < student.length - 1; i++) { // < 오름차순 / > 내림차순
			for (int j = i + 1; j < student.length; j++) {
				if (student[i].getTotal() < student[j].getTotal()) {
					Student4 temp = student[i];
					student[i] = student[j];
					student[j] = temp;
				}
			}
		}

	}

	public String toString() {

		return name + "\t" + score[0] + "\t" + score[1] + "\t" + score[2] + "\t" + getTotal() + "\t" + getAverage();

	}
}
