package ex05_2_switch;
//switch ~ case 문을 이용한 학점 처리
/*
95 ~ 100 : A+      // 95/5=19   96/5=19    97/5=19  98/5=19  99/5=19   100/5=20
90 ~   94 : A0     // 90/5=18   91/5=18    92/5=18  93/5=18  94/5=18   
85 ~   89 : B+
80 ~   84 : B0
75 ~   79 : C+
70 ~   74 : C0
65 ~   69 : D+
60 ~   64 : D0
0   ~   59 : F 

학점을 변수 String grade에 저장 후 출력합니다.
*/

import java.util.Scanner;

public class Ex_ref_EnhancedSwitch {

	public static void main(String[] c) {
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력하세요>");
		int jumsu = sc.nextInt();
		
		int mok = jumsu / 5;
		// 향상된 스위치문
		String grade = switch (mok) {
				case 19, 20 -> "A+";
				case 18 -> "A0";
				case 17 -> "B+";
				case 16 -> "B0";
				case 15 -> "C+";
				case 14 -> "C0";
				case 13 -> "D+";
				case 12 -> "D0";
				default -> "F";
			}; 
		//  String grade = switch{}; 형태이므로 ;으로 마무리 해야 한다. 
		System.out.println("학점은 " + grade +" 입니다");
		
		sc.close();
	}
}
