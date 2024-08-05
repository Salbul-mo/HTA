package ex05_5_for;

public class Callender_Ex2 {

	public static void main(String[] b) {
		int year = 2024;
		int month = 7;
		
		System.out.println("============= " + year + "년 " + month+ "월 " + "=============");
		for (int i = 0 ; i <= 31 ; i++) {
			if (i == 0) {
				System.out.printf("%5s","");
			} else {
				System.out.printf("%5d",i);
			}
				
			if ((i+1) % 7 == 0) {
				System.out.println();
			}
			// alt shift 위 아래 커서 기준 코드 블럭 증감
		}
	}
}
