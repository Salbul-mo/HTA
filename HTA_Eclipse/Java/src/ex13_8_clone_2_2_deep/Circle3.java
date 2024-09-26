package ex13_8_clone_2_2_deep;

public class Circle3 implements Cloneable { // 클래스 작성자가 복제를 허용한다는 의미
	Point p; // 원점
	double r;

	Circle3(Point p, double r) {
		this.p = p;
		this.r = r;
	}

	@Override // deep copy
	public Circle3 clone() { // 반환 타입이 Circle2가 되도록 return 타입을 다운캐스팅
		try {
			// 슈퍼 클래스의 clone 메서드를 호출해서 그 결과를 리턴
			Circle3 cloned = (Circle3) super.clone();
			cloned.p = new Point(this.p.x, this.p.y); // 같은 값을 가지는 새로운 참조 객체 생성
			return cloned;
		} catch (CloneNotSupportedException e) {
			System.out.println("복제 오류 발생했습니다.");
			return null;
		}
	}

	@Override
	public String toString() {
		return "[p=" + p + ", r=" + r + "]";
		// return "[p=" + p.toString() + ", r=" + r + "]"; 과 같다.
	}
}
