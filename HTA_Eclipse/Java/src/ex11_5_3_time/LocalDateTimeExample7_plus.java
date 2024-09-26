package ex11_5_3_time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeExample7_plus {

	public static void main(String[] args) {
		/*
		 * LocalDateTime 객체는 불변(immutable)이다.
		 * 한 번 생성되면 그 값을 변경할 수 없다.
		 * 즉, 멀티 쓰레드 환경에서 안전하게 사용할 수 있다는 장점이 있다.
		 *  
		 */
		LocalDateTime now = LocalDateTime.now();
		print(now);
		
		//now.plusDays(5).plusMonths(1) => now와는 다른 새로운 객체를 생성해서
		//메서드를 실행한 후 newDateTime에 대입한다. 
		LocalDateTime newDateTine = now.plusDays(5).plusMonths(1);
		//plusDays(long 정수);
		//Returns a copy of this LocalDateTime with the specified number of days added. 
		//This method adds the specified amount to the days field 
		//incrementing the month and year fields as necessary to ensure the result remains valid.
		//The result is only invalid if the maximum/minimum year is exceeded. 
		//For example, 2008-12-31 plus one day would result in 2009-01-01. 
		//This instance is immutable and unaffected by this method call.
		//plusMonth(long 정수);
		//Returns a copy of this LocalDateTime with the specified number of months added. 
		//This method adds the specified amount to the months field in three steps: 
		//1.Add the input months to the month-of-year field
		//2.Check if the resulting date would be invalid
		//3.Adjust the day-of-month to the last valid day if necessary
		//For example, 2007-03-31 plus one month would result in the invalid date2007-04-31. 
		//Instead of returning an invalid result,
		//the last valid day of the month, 2007-04-30, is selected instead. 
		//This instance is immutable and unaffected by this method call.
		
		print(newDateTine);

		LocalDateTime now2 = LocalDateTime.now();
		print(now2);

		LocalDateTime newDateTime2 = now2.minusHours(3).minusMinutes(30);
		//LocalDateTime 은 년도-00월-00일 00시:00분:00초.123456789나노초
		print(newDateTime2);
		String dateStr = "2024-08-02"; // LocalDate 는 년도 00월 00일
		LocalDate str = LocalDate.parse(dateStr);
		
		System.out.println("년도 : " + str.getYear());
		System.out.println("월 : " + str.getMonthValue());
		System.out.println("일 : " + str.getDayOfMonth());

	}

	private static void print(LocalDateTime newDateTime2) {
		//원하는 형식 지정
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd EEEE HH:mm:ss");
		//날짜와 시간을 형식에 맞춰 문자열로 전환
		String formattedDateTime = newDateTime2.format(formatter);
		//문자열 출력
		System.out.println(formattedDateTime);

	}
}
