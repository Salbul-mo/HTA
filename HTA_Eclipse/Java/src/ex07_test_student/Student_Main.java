package ex07_test_student;

public class Student_Main {

	public static void main(String[] args) {

		Student student1 = new Student("강호동", 85, 60, 70);
		Student student2 = new Student("이승기", 90, 95, 80);
		Student student3 = new Student("유재석", 75, 80, 100);
		Student student4 = new Student("하하", 80, 70, 95);
		Student student5 = new Student("이광수", 100, 65, 80);

		int[] subject = subject(student1, student2, student3, student4, student5);

		print(student1, student2, student3, student4, student5, subject);
	}



	public static int[] subject(Student student1, Student student2, Student student3, Student student4,
			Student student5) {
		int[] subject = new int[3];
		subject[0] = student1.kor + student2.kor + student3.kor + student4.kor + student5.kor;
		subject[1] = student1.math + student2.math + student3.math + student4.math + student5.math;
		subject[2] = student1.eng + student2.eng + student3.eng + student4.eng + student5.eng;
		return subject; // 참조값 리턴
	}
	
	
	public static void print(Student student) {
		System.out.printf(student.name + "\t" + student.kor + "\t" + student.math + "\t" + student.eng + "\t"
				+ student.getTotal() + "\t" + "%.1f\n", student.getAverage());
	}

	
	public static void print(Student student1, Student student2, Student student3, Student student4, Student student5,
			int[] subject) {
		System.out.println("=========== 학생별 / 과목별 총점 구하기 ===========");
		System.out.println("\t국어\t수학\t영어\t총점\t평균");
		print(student1);
		print(student2);
		print(student3);
		print(student4);
		print(student5);

		//System.out.print("============================================\n총점");
		String str1 = String.format("%48s", "\n총점").replace(" ", "=");
		System.out.print(str1);
		for (int sub : subject) {
			System.out.print("\t" + sub);
		}
	}
}
