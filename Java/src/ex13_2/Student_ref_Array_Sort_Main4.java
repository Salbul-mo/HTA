package ex13_2;

public class Student_ref_Array_Sort_Main4 {

	public static void main(String args[]) {
		Student_ref4[] student_ref = { 
										new Student_ref4("강호동", 85, 60, 70), 
										new Student_ref4("이승기", 90, 95, 80),
										new Student_ref4("유재석", 75, 80, 100), 
										new Student_ref4("하하", 80, 70, 95),
										new Student_ref4("이광수", 100, 65, 80) 
									};

		print(student_ref, Student_ref4.subject);
		Student_ref4.sort(student_ref);
		//sort 도 student_ref 에서 구현할 수 있다.
		print(student_ref, Student_ref4.subject);

	}


	public static void print(Student_ref4[] student_ref, int[] subject) {
		System.out.println("=========== 학생별 / 과목별 총점 구하기 ===========");
		System.out.println("\t국어\t영어\t수학\t총점\t평균");

		for (int i = 0; i < student_ref.length; i++) {
			System.out.println(student_ref[i].toString());
		}

		System.out.print(String.format("%48s", "\n총점").replace(" ", "="));
		// System.out.print("============================================\n총점");
		for (int sub : subject) {
			System.out.print("\t" + sub);
		}
		System.out.println();
	}


}

