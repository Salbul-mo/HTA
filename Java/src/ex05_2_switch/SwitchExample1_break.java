package ex05_2_switch;

public class SwitchExample1_break {

	public static void main(String args[]) {
		int num = 3;
		
		switch (num) {
			case 1 :
				System.out.println("안녕하세요~");
				break;
			case 2 :
				System.out.println("맛점하세요~");
				break;
			case 3 :
				System.out.println("퇴실 찍으세요~");
				break;
			default :
				System.out.println("수고 많으셨어요~");
		}
		System.out.println("끝.");
	}
}
