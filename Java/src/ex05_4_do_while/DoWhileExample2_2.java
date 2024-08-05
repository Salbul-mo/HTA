package ex05_4_do_while;

import java.util.Scanner;

public class DoWhileExample2_2 {

	public static void main(String args[]) {
		String location = "";
		Scanner sc = new Scanner(System.in);
		String q = "q";
		do {
			System.out.print("지역입력(exit=q)>");
			location = sc.next();
			if (!location.equals(q)) {
			System.out.println("입력하신 지역은 " + location + " 입니다.");
			}
		} //while (true);
		while (!(location.equals(q)));
		System.out.println("끝.");
		
		sc.close();
	}
}
/* 
지역입력(exit=q)>서울
입력하신 지역은 서울 입니다.
지역입력(exit=q)>부산
입력하신 지역은 부산 입니다.
지역입력(exit=q)>광주
입력하신 지역은 광주 입니다.
지역입력(exit=q)>q
끝.
*/