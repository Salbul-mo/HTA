package ex07_15_static_method;

public class StaticMethodExample2 {

	public static void main(String[] args) {

		// 정적 메서드 호출문
		int grandTotal = Accumulator.getGrandTotal();
		System.out.println("총계 = " + grandTotal);
		Accumulator obj1 = new Accumulator();
		Accumulator obj2 = new Accumulator();
		obj1.accumulate(10);
		obj2.accumulate(20);

		// 정적 메서드 호출문
		grandTotal = Accumulator.getGrandTotal();

		// 메인 클래스 자기 자신의 객체 생성
		// 메인 메서드 안에 자기 자신의 객체를 만들 수 있다.
		StaticMethodExample2 a = new StaticMethodExample2();
		// 객체 참조값.print();
		a.print(obj1);
		a.print(obj2);
		System.out.println("총계 = " + grandTotal);

	}

	// static 이 붙지 않은 메서드는 반드시 객체를 생성하고 사용해야 한다.
	void print(Accumulator a) {
		System.out.println("total = " + a.total);
	}

}
