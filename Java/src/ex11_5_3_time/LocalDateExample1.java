package ex11_5_3_time;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class LocalDateExample1 {

	public static void main(String[] args) {
		LocalDate current = LocalDate.now();
		//기존 Calendar의 문제 any application that makes use of historical dates, 
		//and requires them to be accurate will find the ISO-8601 approach unsuitable. 
		//그래서 Time.LocalDate를 사용한다.
		//often viewed as year-month-day. 
		// day-of-year,day-of-week and week-of-year를 필드로 갖는다
		//This is a value-basedclass; 
		//programmers should treat instances that are equal as interchangeable 
		//and should not use instances for synchronization, 
		//or unpredictable behavior may occur. 
		//For example, in a future release, synchronization may fail.
		//The equals method should be used for comparisons.
		//This class does not store or represent a time or time-zone.
		//Instead, it is a description of the date, as used for birthdays.
		//It cannot represent an instant on the time-line 
		//without additional informationsuch as an offset or time-zone. 

		// 기본 시간대의 시스템 시계에서 현재 날짜를 가져옵니다.
		int year = current.getYear(); // 년도를 가져온다.

		int month = current.getMonthValue(); // 월을 가져온다.(1~12)

		int day = current.getDayOfMonth(); // (1 ~ 31)

		System.out.println("년도 = " + year);
		System.out.println("월 = " + month);
		System.out.println("날 = " + day);

		int days = current.getDayOfYear();// 1~365, 윤년은 1~366
		System.out.println("1년 365일 중 " + days + "일");

		DayOfWeek enums = current.getDayOfWeek();
		int dayOfWeek = enums.getValue(); // the day-of-week. from 1(Mon) to 7(Sun)
		System.out.println(enums + ":" + dayOfWeek);
		//DayOfWeek is an enum representing the 7 days of the week 
		//-Monday, Tuesday, Wednesday, Thursday, Friday, Saturday and Sunday. 

		// 특정 날짜 생성
		LocalDate special = LocalDate.of(2024, 1, 30);
		year = special.getYear();

		month = special.getMonthValue();

		day = special.getDayOfMonth();

		System.out.println("년도 = " + year);
		System.out.println("월 = " + month);
		System.out.println("날 = " + day);

		days = special.getDayOfYear();// 1~365, 윤년은 1~366
		System.out.println("1년 365일 중 " + days + "일");

	}

}
