package ex07_00_object;

public class Saram_Make {
	public static void main(String[] s) {
		
/*
 * 다른 클래스에 있는 필드나 메서드를 사용하려면 먼저 객체를 생성해야한다.
 * 생성된 객체 맴버에 접근하려면 .(dot) 연산자를 사용한다.
 * 예) 참조변수.필드; 참조변수.메서드()
 */
		
		
		
	  //클래스  참조변수 =  연산자    생성자호출;
		Saram   s1 =     new     Saram();
		s1.name = "아이유";
		s1.w = 47.4;
		s1.ki = 162.1;
		s1.age = 32;
		s1.eat();
		
		Saram s2 = new Saram();
		s2.name = "장범준";
		s2.age = 33;
		s2.w = 64;
		s2.ki = 172;
		s2.eat();
		s2.sesu();
	}

}

