package ex17_04_ruunable_interface_anon_ramda_method;

public class RamdaExample_Parse {

	public static void main(String[] args) {
		
		Parse p;
		
		p = new Parse() {
			
			@Override
			public int toInt(String x) {
				return Integer.parseInt(x);
			}
		};
		
		System.out.println(p.toInt("100"));
		
		
		p = x -> Integer.parseInt(x);
		
		System.out.println(p.toInt("200"));
		
		
		
		/*방법 5. 람다식이 하나의 메서드만 호출하는 경우 메서드 참조(method reference) 방식으로 간단히 나타낼 수 있다.
		 * 
		 *지금까지 방식은 값 하나를 받아서 Integer.parseInt()에 넘겨주는 일을 하고 있다.
		 *즉 하나의 메서드를 호출하고 있다.
		 *이것을 메서드 참조방법으로 나타낼 수 있다.
		 *메서드 참조는 클래스이름::메서드이름 또는 참조변수::메서드이름 형식으로 작성한다. 
		 */
		p = Integer::parseInt; // 익명 객체의 구현된 메서드가 하나의 메서드를 호출하여 변수를 전달하는 형태라면 
		//그냥 해당 메서드만 참조 선언하여 나타낼 수 있다.
		
		System.out.println(p.toInt("600"));
	}
}
