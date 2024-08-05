package ex07_15_static_method;

public class Accumulator {
	int total = 0; 
	static int grandTotal = 0;
	
	void accumulate(int amount) {
		total += amount;
		
		grandTotal += amount;
	}

	/*
	 * 정적 메서드 안에서는 인스턴스 변수, 인스턴스 메서드 사용할 수 없다.
	 * 인스턴스 변수와 인스턴스 메서드는 객체 생성시 사용할 수 있는 멤버들이기 때문에
	 * 인스턴스 생성과 관련없는 static 메서드안에서는 사용할 수 없다.
	 * 따라서 this 도 사용할 수 없다. ( this 는 인스턴스의 참조값을 가지는 키워드이기 때문이다)
	 */
	static int getGrandTotal() { //정적 메서드 선언
		//total = 5; -> 에러 발생
		//accumulate(500) -> 에러 발생
		return grandTotal;
	}
}
