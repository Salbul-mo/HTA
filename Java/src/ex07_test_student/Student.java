package ex07_test_student;

public class Student {
	
	String name;
	int kor;
	int eng;
	int math;
	
	Student(String name, int kor, int math, int eng) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		
	}

	public int getTotal() {
		int sum = (kor + eng + math);
		return sum;
	}
	
	public float getAverage() {
		return this.getTotal() / (float) 3; // 3f
	}
	
}