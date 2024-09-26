package ex17_04_ruunable_interface_anon_ramda_method;

public class RamdaExample_Sample {

	public static void main(String args[]) {

		// 익명 객체 생성식
		write(new Sample() {
			public void print(String x) {
				System.out.println(x);
			}
		});

		// 람다식 표현
		write(x -> System.out.println(x)); // 파라미터 하나면 괄호 생략 가능하다. 하나도 없으면 생략할 수 없다.
		// write( (x) -> System.out.println(x) );

		// 람다식 메서드 참조 표현
		write(System.out::println);
	}

	static void write(Sample sample) {
		sample.print("오늘은 기다리던 금요일~ 좋다~");
	}
}
