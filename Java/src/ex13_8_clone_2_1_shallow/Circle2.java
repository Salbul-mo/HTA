package ex13_8_clone_2_1_shallow;

public class Circle2 implements Cloneable { // 클래스 작성자가 복제를 허용한다는 의미
	Point p; // 원점
	double r;

	Circle2(Point p, double r) {
		this.p = p;
		this.r = r;
	}

	@Override
	/*
	 * 공변 반환 타입(covariant return type) -JDK1.5 부터
	 * 오버라이딩 할 때 조상 메서드의 반환 타입을 자손 클래스의 타입으로 변경을 허용하는 것
	 * 반환형을 Object 에서 자손 클래스 타입으로 변경한다.
	 * 
	 * 좋은 점 ㅣ clone() 후 따로 형 변환할 필요가 없다.
	 * Circle copy = (Circle)original.clone();
	 * => Circle copy = original.clone();
	 */
	public Circle2 clone() { // 반환 타입이 Circle2가 되도록 return 타입을 다운캐스팅
		try {
			// 슈퍼 클래스의 clone 메서드를 호출해서 그 결과를 리턴
			return (Circle2)super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("복제 오류 발생했습니다.");
			return null;
		}

	}
	
	@Override
	public String toString() {
		return "[p=" + p + ", r=" + r + "]";
		//return "[p=" + p.toString() + ", r=" + r + "]"; 과 같다.
	}
}
