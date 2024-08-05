package ex03_2_variable;

public class Variable5_reference {
	
	public static void main(String[] v) {
		// s1 , s2 참조형 변수, new 는 연산자
		// new String("자바"); 에서 String("자바")는 생성자이다.
		String s1 = "자바";
		
		//리터럴로 선언되는 String 변수는 String Constant Pool 이라는 영역에 저장
		//만약 값이 같다면 메모리 영역을 공유하여 메모리를 최적화한다. 
		
		String s3 = "자바";
		
		//String 은 자바에서 기본으로 제공되는 클래스
		//객체 생성
		//클래스   참조형 변수 =    연산자     생성자 호출
		 String     s2 =       new      String("자바");
		 
		 //String *변수이름* = new String("value"); 
		 // 로 선언되면 새로운 문자열 객체로 생성되어 heap 영역에 저장된다.
		 // 따라서 내용의 값이 같더라도 다른 주소값을 갖는다.
		 
		 String s4 = new String("자바");
		
		System.out.println("s1=" + s1 + " s2=" + s2);
		
		// 주소값(참조값) 같은지 비교 
		// == 는 참조값이 같은지 확인하는 연산자
		if (s1 == s2) {
			System.out.println("같은 주소");
		} else {
			System.out.println("다른 주소");
		}
		// 내용값 같은지 비교
		// .equals() 는 객체의 내용을 비교하여 같은지 확인하는 메서드
		if (s1.equals(s2)) {
			System.out.println("같은 값");
		} else {
			System.out.println("다른 값");
		}
		
		///////////////////////////////////////////////////////
		if (s1 == s3) { // 같은 메모리를 공유하여 같은 주소이다.
			System.out.println("같은 주소");
		} else {
			System.out.println("다른 주소");
		}
		
		if (s2 == s4) { // 서로 다른 인스턴스이므로 다른 주소이다.
			System.out.println("같은 주소");
		} else {
			System.out.println("다른 주소"); 
		}
		if (s2.equals(s4)) {  // 객체의 값은 같다.
			System.out.println("같은 값");
		} else {
			System.out.println("다른 값");
	    }
	}
}
