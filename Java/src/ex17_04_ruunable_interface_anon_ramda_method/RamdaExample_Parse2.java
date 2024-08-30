package ex17_04_ruunable_interface_anon_ramda_method;

public class RamdaExample_Parse2 {

	public static void main(String args[]) {
		Parse2 p;
		
		// 익명 구현 객체
		p = new Parse2() {
			
			@Override
			public boolean isSame(String a, String b) {
				return a.equals(b);
			}
			
		};
		System.out.println(p.isSame("1","2"));

		
		// 람다식 표현으로 객체 구현
		p = (a, b) -> a.equals(b);
		System.out.println(p.isSame("2","2"));
		
		
		
		// String 클래스에서 제공하는 equals 메서드를 참조해서 객체를 구현한다는 표현식이다.
		// 어차피 Parse2 객체의 isSame메서드는 파라미터를 String.equals()메서드에 전달할 뿐인 형태이므로 이런식으로 참조 표현의 생략이 가능하다.
		p = String::equals; 
		System.out.println(p.isSame("3", "4"));
		
		
	}
}
