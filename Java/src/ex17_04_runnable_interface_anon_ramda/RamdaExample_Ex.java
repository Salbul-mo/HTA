package ex17_04_runnable_interface_anon_ramda;

public class RamdaExample_Ex {

	public static void main(String args[]) {

		
		// 인터페이스 익명 구현 객체 방법
		int max = getMax(new Sample2() {  // -> 인터페이스 익명 구현하여 객체 자체를 메서드의 파라미터로 넘긴다.
			@Override 
			public int max(int a, int b) {
				if (a > b)
					return a;

				else
					return b;
			};
		});
		System.out.println(max);

		
		// 람다식
		max = getMax((a, b) -> {
			if (a > b)
				return a;

				return b;
		});
		System.out.println(max);

		
		// 실행문이 하나 있는 경우 중괄호를 생략하면 세미콜론을 생략한다.
		max = getMax((a, b) -> a > b ? a : b); // 삼항 연산자를 사용하면 한 줄로 표현된다.
		System.out.println(max);

		
	}

	static int getMax(Sample2 sample) { // -> 파라미터로 받은 객체의 max() 메서드를 호출한다.
		return sample.max(100, 20);
	}
}
