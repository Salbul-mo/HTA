package ex19_06_serialversionuid_no;
//사각형 클래스에 메서드를 추가
public class Rectangle implements java.io.Serializable {
	
	private int width, height;
	Rectangle (int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public String toString() {
		return "가로: " + width + "\n높이: " + height;
		
	}

	
	 // 실행방법
	/* 1.아래 getArea 메서드의 주석을 달고 실행하면 에러 없음
	 * ObjectOutputExample.java 실행
	 * ObjectInputExample.java 실행
	 * 
	 * 2. 아래 메서드의 주석을 푼 후 - 에러 발생
	 * ObjectInputExample.java 실행
	 * 
	 * serialVersionUIO 는 같은 클래스임을 알려주는 식별자 역할을 하며
	 * Serializlble 인터페이스를 구현한 클래스를 컴파일하면 자동적으로 serialVersionUID 상수 필드가 추가된다.
	 * 
	 * serialVersionUID는 자바의 직렬화 메커니즘과 역직렬화 메커니즘이 실행될 때
	 * 자동으로 부여되는데 직렬화 가능 클래스의 내용이 그대로이면 같은 번호가 부여되고
	 * 클래스의 구성요소가 하나라도 바뀌면 완전히 다른 serialVersionUID가 부여된다.
	 * 
	 * 하지만 명시적으로 클래스에 serialVersionUID가 선언되어 있으면
	 * 컴파일 시 추가 되지 않기 때문에 동일한 값을 유지할 수 있다.
	 * => 클래스 구성 요소 바뀌어도 명시적으로 값이 정해지면 동일한 클래스로 인식한다.
	 */
	
	
	int gerArea() {
	return width * height;
	}
	 
	
}
