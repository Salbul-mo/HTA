package ex07_test_student;

public class Student_ref2 {
	
	String name;

	String[] sub_Name = {"국어" , "수학", "영어" } ;
	int[] score = new int[3];
	//[0]-국어 [1]-수학 [2]-영어
	static int[] subject = new int[3];
	
	Student_ref2(String name, int kor, int math, int eng) {
		this.name = name;
		score[0] = kor;
		score[1] = math;
		score[2] = eng;
		
	}

	public int getTotal() {
		int sum = 0;
		for (int score : score) {
			sum += score;
		}
		return sum;
	}
	
	public float getAverage() {
		return this.getTotal() / (float) 3; // 3f
	}
	
	//과목 총점을 static 으로 만들자.
	
	static void addSubject(Student_ref2 s) {
		subject[0] += s.score[0];
		subject[1] += s.score[1];
		subject[2] += s.score[2];
	}
}
