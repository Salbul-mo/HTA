package ex07_test_student;

public class Student_Array_Main {
	public static void main(String args[]) {
		Student[] student = { 
								new Student("강호동", 85, 60, 70),
								new Student("이승기", 90, 95, 80),
								new Student("유재석", 75, 80, 100), 
								new Student("하하", 80, 70, 95),
								new Student("이광수", 100, 65, 80)
							};

		int[] subject = subject(student);

		print(student, subject);
	}

	public static int[] subject(Student[] student) {
		int[] subject = new int[3];

		for (int j = 0; j < 5; j++) {
			subject[0] += student[j].kor;
			subject[1] += student[j].math;
			subject[2] += student[j].eng;
		}
		return subject;

	}
	
	public static void print(Student student) {
		System.out.printf(student.name + "\t" + student.kor + "\t" + student.math + "\t" + student.eng + "\t" + student.getTotal() + "\t" + "%.1f\n", student.getAverage());
	}

	public static void print(Student[] student, int[] subject) {
		System.out.println("=========== 학생별 / 과목별 총점 구하기 ===========");
		System.out.println("\t국어\t수학\t영어\t총점\t평균");

		for( int i = 0 ; i < student.length; i++) {
			print(student[i]);
			}

		// System.out.print("============================================\n총점");
		System.out.print(String.format("%48s", "\n총점").replace(" ", "="));
		for (int sub : subject) {
			System.out.print("\t" + sub);
		}
	}
}
