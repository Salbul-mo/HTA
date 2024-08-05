package ex05_6_break;

public class BreakExample1 {

	public static void main(String[] a) {
		
		for (int cnt = 0; cnt < 10 ; cnt++) {
			System.out.println(cnt);
			if (cnt == 5)
				break; //break 를 내포하는 반복문 밖으로 제어가 이동합니다.
			}
		System.out.println("End.");
		}
	
		
	}


