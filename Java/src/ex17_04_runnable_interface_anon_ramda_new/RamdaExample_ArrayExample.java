package ex17_04_runnable_interface_anon_ramda_new;


public class RamdaExample_ArrayExample {

	public static void main(String[] args) {
		ArrayExample a;
		
		// 인터페이스 익명 구현 객체
		a = new ArrayExample() {
			
			@Override
			public int[] toArray(int size) {
				return new int[size];
			}
		};
		
		System.out.println(a.toArray(3).length);
		
		// 람다식 표현
		
		a = size -> new int[size];
		
		System.out.println(a.toArray(4).length);
		
		// 메서드 참조 방법
		
		a = int[]::new; //=> 객체를 생성하는 참조식은 타입을 먼저 사용하고 new를 넣는다. type::new;
		
		System.out.println(a.toArray(20).length);
			
	}
}
