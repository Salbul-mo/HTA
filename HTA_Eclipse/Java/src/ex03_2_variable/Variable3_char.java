package ex03_2_variable;

public class Variable3_char {
	
	public static void main(String[] v) {
		
		System.out.println("========문자형 변수========");
		//문자형 변수 - 하나의 문자를 나타낼 수 있는 자료형으로
		//16비트의 유니코드를 사용한다.
		char c1 = 'A'; // 2byte
		char c2 = '@';
		char c3 = '가';
		
		System.out.println("c1=" + c1 + " c2=" + c2 + " c3=" + c3);
	/*
	 * 에러의 예
	 * 1. char cerror='AB'; 두 글자 입력하면 에러
	 * 2. char cerror_blank=''; 반드시 하나의 문자가 필요
	 */
		
	/*
	 * 컴퓨터가 문자를 저장하는 방법	
	 * 유니코드
	 * 'A' -> 65
	 *  : 문자를 코드로 변환하는 것을 문자 인코디(encoding) 이라고 한다.
	 *  
	 *  65 -> 'A'
	 *  : 코드를 문자로 변환하는 것을 문자 디코딩(decoding) 이라고 한다.
	 */
		
		//문자형에 정수를 배정하면 정수에 해당하는 유니코드를 찾아서 변수에 저장한다.
		char c4 = 65; 
		// 영문 'A'를 의미
		char c5 = '\uAC00';  
		// 한글 유니코드 '가' 를 의미 역슬래시u 가 유니코드 서식지정 AC00이 가
		System.out.println("c4=" + c4 + " c5=" + c5);
		
		// 유니코드 값을 통해 자바 내부에서 a 와 A 의 대소 구분이 가능하다.
	}
}
