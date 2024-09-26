package ex13_2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class Ex_08_02_ref2 {

	public static void main(String[] b) {
		String str;
		LocalDate data = null;
		// try with resource 로 하려 했는데
		int cnt = 0; 
		while (cnt < 10) {
			cnt++;
			try (Scanner sc = new Scanner(System.in)) {
				System.out.print("형식에 맞추어 년도를 입력하세요(0000)년>");//Scanner 오류다. catch 구문 따로 만들어보기
				String yearIn = sc.nextLine().trim(); // 년도를 문자열로 받는다.
				System.out.println(yearIn);
				System.out.print("형식에 맞추어 월을 입력하세요(00)월>");
				String monthIn = sc.nextLine().trim(); // 월을 문자열로 받는다.
				if (monthIn.length() < 2) {
					monthIn = "0" + monthIn; // 월이 2자릿수가 아니면 0을 붙여준다.
				}
				str = yearIn + "-" + monthIn + "-01"; // str = 0000-00-01 형식이 된다.
				System.out.println(str);
				data = LocalDate.parse(str); // LocalDate 클래스에서 사용할 수 있는 날짜 데이터를 문자열에서 추출한다.

			} catch (Exception e) {
				
				System.out.println("형식에 맞지 않은 입력입니다. 다시 입력해주세요.");
				continue;

			}
			break;

		}

		DayOfWeek dayOfWeek = data.getDayOfWeek(); // 요일 열거상수 반환
		int date = dayOfWeek.getValue(); // 반환 받은 열거상수의 인덱스 반환

		int year = data.getYear(); // 년도
		int Month = data.getMonthValue(); // 월

		System.out.println("=================== " + year + "년 " + Month + " 월 " + "====================");
		System.out.println(" 일\t 월\t 화\t 수\t 목\t 금\t 토");

		// 월 1 - \t 화 2 - \t\t 수 3 - \t\t\t......
		if (date != 7) {// 일요일이 아니면
			for (int i = 0; i < date; i++) {
				System.out.print("\t");// 요일 데이터 인덱스만큼 공백준다.
			}
			System.out.printf("%2d\t", 1);

		}

		// 그냥 기준 date 로 숫자 찍는 로직
		for (int i = 2; i <= data.lengthOfMonth(); i++) {
			System.out.printf("%2d\t", i);
			if ((i + date) % 7 == 0) {// 기준 날짜의 요일 상수 + i 값의 규칙성에 따라 줄 바꾸는 if구문
									  // 월 - 1 화 - 2 수 - 3 목 - 4 ..... i 값과 더해서 7의 배수가 되면 줄 바꾼다.
				System.out.println();
			}
		}

	}

}
