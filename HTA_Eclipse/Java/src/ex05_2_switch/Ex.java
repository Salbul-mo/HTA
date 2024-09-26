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

public class Ex {

	public static void main(String[] c) {
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력하세요>");
		int jumsu = sc.nextInt();
		
		String grade = "";
		
		int mok = jumsu / 5;
		
		switch (mok) {
			
			case 19, 20 :
				grade = "A+";
				break;
				
			case 18 :
				grade = "A0";
				break;
				
			case 17 : 
				grade = "B+";
				break;
				
			case 16 :
				grade = "B0";
				break;
				
			case 15 :
				grade = "C+";
				break;
				
			case 14 :
				grade = "C0";
				break;
				
			case 13 :
				grade = "D+";
				break;
				
			case 12 :
				grade = "D0";
				break;
				
			default :
				grade = "F";
		}
		
		System.out.println("학점은 " + grade +" 입니다");
		
		sc.close();
	}
}
