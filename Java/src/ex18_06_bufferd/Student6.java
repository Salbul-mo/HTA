package ex18_06_bufferd;

public class Student6 implements Comparable<Student6> {

	String name;

	int[] score = new int[3];
	// [0]-국어 [1]-영어 [2]-수학
	static int[] subject = new int[3];

	Student6(String name, int kor, int eng, int math) {
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

	public String toString() {
		String score = "";
		for (int i : this.score) {
			score += "\t" + i;
		}
		return this.name + score + "\t" + getTotal() + "\t" + getAverage();

	}

	@Override
	public int compareTo(Student6 o) {
		if (getTotal() < o.getTotal()) {
			return -1;
		} else if (getTotal() == o.getTotal()) {
			return this.name.compareTo(o.name);
		} else {
			return 1;
		}

	}
}
