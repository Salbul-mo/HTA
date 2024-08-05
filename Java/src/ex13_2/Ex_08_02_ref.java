package ex13_2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class Ex_08_02_ref {

	public static void main(String[] b) {
		String str;
		LocalDate data = null;
		// try with resource 로 하려 했는데
		/*
		 * try(Scanner sc = new Scanner(System.in)){ try 코드 }catch(Exception e) {
		 * System.out.println("경고문"); continue; } 로 하면 경고문이 sc.nextLine()에 입력되는건지 무한
		 * 루프하게된다.
		 * 
		 */

		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				System.out.print("형식에 맞추어 년도를 입력하세요(0000)년>");
				String yearIn = sc.nextLine().trim(); // 년도를 문자열로 받는다.
				System.out.print("형식에 맞추어 월을 입력하세요(00)월>");
				String monthIn = sc.nextLine().trim(); // 월을 문자열로 받는다.
				if (monthIn.length() < 2) {
					monthIn = "0" + monthIn; // 월이 2자릿수가 아니면 0을 붙여준다.
				}
				str = yearIn + "-" + monthIn + "-01"; // str = 0000-00-01 형식이 된다.
				data = LocalDate.parse(str); // LocalDate 클래스에서 사용할 수 있는 날짜 데이터를 문자열에서 추출한다.
			} catch (Exception e) {
				System.out.println("형식에 맞지 않은 입력입니다. 다시 입력해주세요.");
				continue;
			}
			break;
		}
		sc.close();
		DayOfWeek dayOfWeek = data.getDayOfWeek(); // 요일 열거상수 반환
		int date = dayOfWeek.getValue(); // 반환 받은 열거상수의 인덱스 반환

		int year = data.getYear(); // 년도
		int Month = data.getMonthValue(); // 월

		System.out.println("=================== " + year + "년 " + Month + " 월 " + "====================");
		System.out.println(" 일\t 월\t 화\t 수\t 목\t 금\t 토");
		/*
		 * switch (date) { // 시작일 요일 인덱스 switch로 공백주기 case 1 ->
		 * System.out.printf("\t%2d\t", 1); // 월 case 2 ->
		 * System.out.printf("\t\t%2d\t", 1); // 화 case 3 ->
		 * System.out.printf("\t\t\t%2d\t", 1); // 수 case 4 ->
		 * System.out.printf("\t\t\t\t%2d\t", 1); // 목 case 5 ->
		 * System.out.printf("\t\t\t\t\t%2d\t", 1); // 금 case 6 ->
		 * System.out.printf("\t\t\t\t\t\t%2d\t", 1); // 토 case 7 ->
		 * System.out.printf("%2d\t", 1); // 일
		 */
		// 월 1 - \t 화 2 - \t\t 수 3 - \t\t\t......
		if (date != 7) {// 일요일이 아니면
			for (int i = 0; i < date; i++) {
				System.out.print("\t");// 요일 데이터 인덱스만큼 공백준다.
			}
			System.out.printf("%2d\t", 1);

		}

		/*
		 * 찍을 때 마다 객체 생성해서 요일 상수 구해서 비교하는 로직
		 * for (int i = 1; i < data.lengthOfMonth(); i++) { // 2일 부터 시작 해당 월 마지막일까지 plusDays() -> 1+(i) ~ 1 +(lastday-1) 
		 * 		DayOfWeek dayOfWeek2 = (data.plusDays(i)).getDayOfWeek(); // data.plusDay(i) 한 LocalDate 객체의 요일 열거상수 반환 
		 * 		int date2 = dayOfWeek2.getValue(); // 요일 열거 상수의 인덱스 정수 반환
		 * 		System.out.printf("%2d\t", (data.plusDays(i).getDayOfMonth())); // 해당 객체 요일 출력 
		 * 			
		 * 		if (date2 == 6) { // 해당 요일이 토요일이면 줄바꿈 실행 
		 * 			System.out.println(); 
		 * 		}
		 * 
		 * }
		 */
		
		//그냥 기준 date 로 숫자 찍는 로직
		for (int i = 2; i <= data.lengthOfMonth(); i++) {
			System.out.printf("%2d\t", i);
			if ((i + date) % 7 == 0) {// 기준 날짜의 요일 상수 + i 값의 규칙성에 따라 줄 바꾸는 if구문 
									  //월 - 1 화 - 2 수 - 3 목 - 4 .....   i 값과 더해서 7의 배수가 되면 줄 바꾼다.
				System.out.println();
			}
		}

	}

}
