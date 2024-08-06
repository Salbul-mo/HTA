package ex15_1_arraylist;

import java.util.ArrayList;

public class Student5 {

	String name;

	int[] score = new int[3];
	// [0]-국어 [1]-영어 [2]-수학
	static int[] subject = new int[3];

	Student5(String name, int kor, int eng, int math) {
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
		return Math.round((getTotal() / 3f) * 10) / 10.0f;
	}

	public static void sort(ArrayList<Student5> as) {
		for (int i = 0; i < as.size() - 1; i++) { // < 오름차순 / > 내림차순
			for (int j = i + 1; j < as.size(); j++) {
				if (((Student5) (as.get(i))).getTotal() < ((Student5) (as.get(j))).getTotal()) {
					Student5 temp = (Student5) as.get(i);
					as.set(i, (Student5) as.get(j));
					as.set(j, temp);
				}
			}
		}

	}

	public String toString() {

		return name + "\t" + score[0] + "\t" + score[1] + "\t" + score[2] + "\t" + getTotal() + "\t" + getAverage();

	}
}
