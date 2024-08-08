package ex15_1_arraylist;

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

	// 자바 7 이상에서는 Integer.compare() 를 사용하여 간결하게 작성할 수 있다.
	//public static int compare(int x, int y) {
	//Integer.compare(int , int) 내용
	//return (x < y) ? -1 : ((x == y) ? 0 : 1); // y가 크면 -1 반환, (같으면 0 반환, 아니면 1 반환) 
	//삼항 연산자 두 번 겹쳐서 쓸 수 있다.
	@Override
	public int compareTo(Student6 o) {
		return Integer.compare(this.getTotal(), o.getTotal());
	}

}

