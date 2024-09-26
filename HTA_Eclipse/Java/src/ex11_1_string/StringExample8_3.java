package ex11_1_string;

public class StringExample8_3 {
	public static void main(String[] args) {
		String message = "Java program .... Chrome";
		
		int index1 = message.indexOf("Chrome");
		
		if (index1 != -1) { 
		// -1은 못찾았다는 뜻이니 -1이 아니면 해당 구문이 있다는 체크 코딩이 된다.
			System.out.println("크롬브라우저입니다.");
		} else {
			System.out.println("크롬브라우저가 아닙니다.");
		}
		
		
	}
}
