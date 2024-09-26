package ex13_8_clone_2_1_shallow;

public class Circle implements Cloneable { // 클래스 작성자가 복제를 허용한다는 의미
	Point p; // 원점
	double r;

	Circle(Point p, double r) {
		this.p = p;
		this.r = r;
	}

	@Override// protected Object clone() throws CloneNotSupportedException;
	// ==>오버라이딩 시 접근 제어자 public 으로 변경
	public Object clone() { // 반환 타입이 Object 이다.
		try {
			// 슈퍼 클래스의 clone 메서드를 호출해서 그 결과를 리턴
			return super.clone();
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
