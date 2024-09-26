package ex13_7_object_equals_overriding;

public class Circle2 {

	int radius; // 반지름

	Circle2(int radius) {
		this.radius = radius;

	}

	public String toString() {
		return "radius=" + radius;
	}
	
	@Override
	//Object obj 타입이므로 radius를 참조하기 위해서는 Circle2 타입으로 형변환이 필요하다. 
	//(참조 영역 축소때문에 다운 캐스팅해야한다.)
	public boolean equals(Object obj) {
		/*
		 * 1. obj가 null이 아니고 obj를 Circle2 로 형 변환가능한지 체크한다.
		 * 2. 조건을 만족하면 obj를 Circle2로 형변환하고
		 * 형변환한 obj의 radius값과 현재 객체의 radius 값을 비교해서 리턴
		 * 
		 * 1번을 만족하지 않으면 리턴 false
		 * 
		 */
		
		if(obj != null && obj instanceof Circle2) {
			return this.radius == ((Circle2)obj).radius; 
		}
		else 
			return false;
	}

}
