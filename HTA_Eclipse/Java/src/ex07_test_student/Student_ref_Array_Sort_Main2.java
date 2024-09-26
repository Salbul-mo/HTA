package ex07_test_student;

public class Student_ref_Array_Sort_Main2 {

	public static void main(String args[]) {
		Student_ref[] student_ref = { 
										new Student_ref("강호동", 85, 60, 70), 
										new Student_ref("이승기", 90, 95, 80),
										new Student_ref("유재석", 75, 80, 100), 
										new Student_ref("하하", 80, 70, 95),
										new Student_ref("이광수", 100, 65, 80) 
									};

		Student_ref.sort(student_ref);
		//sort 도 student_ref 에서 구현할 수 있다.
		print(student_ref, Student_ref.subject);

	}

	public static void print(Student_ref student_ref) {
		System.out.printf(student_ref.name + "\t");
		for (int i = 0; i < Student_ref.subject.length; i++) {
			System.out.printf(student_ref.score[i] + "\t");
		}
		System.out.printf(student_ref.getTotal() + "\t" + "%.1f\n", student_ref.getAverage());

	}

	public static void print(Student_ref[] student_ref, int[] subject) {
		System.out.println("=========== 학생별 / 과목별 총점 구하기 ===========");
		System.out.println("\t국어\t영어\t수학\t총점\t평균");

		for (int i = 0; i < student_ref.length; i++) {
			print(student_ref[i]);
		}

		// System.out.print("============================================\n총점");
		System.out.print(String.format("%48s", "\n총점").replace(" ", "="));
		for (int sub : subject) {
			System.out.print("\t" + sub);
		}
		System.out.println();
	}


}
