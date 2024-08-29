package ex17_04_runnable_interface_anon_ramda;

public class RamdaExample2_Sample2_배포 {

	public static void main(String args[]) {
		// 객체 구현할 필요 없이 바로 익명 클래스 구현하듯이 사용할 수 있다.
		
		// 1.인터페이스 익명 구현 객체
		write(new Sample() {

			@Override
			public void print() {
				System.out.println("new Sample - 1");
			};
		});

		// 람다식으로 변경
		write(() -> {
			System.out.println("new Sample - 2");
		});

		// 실행문이 하나 있는 경우 중괄호를 생략하면 세미콜론을 생략한다.
		write(() -> System.out.println("new Sample - 3"));
	
	}

	static void write(Sample sample) {
		sample.print();
	}
}
