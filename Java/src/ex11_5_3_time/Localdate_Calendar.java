package ex11_5_3_time;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class Localdate_Calendar {
	public static void main(String[] args) {
		// 현재 날짜와 시간 가져오기
		LocalDateTime currentDateTime = LocalDateTime.now();

		// 년도 월 일 시 분 초 출력
		
		int year = currentDateTime.getYear();
		//Gets the year field. 
		//This method returns the primitive int value for the year. 
		//The year returned by this method is proleptic as per get(YEAR).
		//To obtain the year-of-era, use get(YEAR_OF_ERA).
		//Returns:the year, from MIN_YEAR to MAX_YEAR
		
		int month = currentDateTime.getMonthValue();
		//This method returns the month as an int from 1 to 12
		//Application code is frequently clearer if the enum Monthis used by calling getMonth().
	
		int day = currentDateTime.getDayOfMonth();
		//Gets the day-of-month field. 
		//This method returns the primitive int value for the day-of-month.
		//Returns:the day-of-month, from 1 to 31
		DayOfWeek dayOfWeek = currentDateTime.getDayOfWeek();
		//Gets the day-of-week field, which is an enum DayOfWeek. 
		//This method returns the enum DayOfWeek for the day-of-week.
		//This avoids confusion as to what int values mean.
		//If you need access to the primitive int value then the enumprovides the int value. 
		//Additional information can be obtained from the DayOfWeek.This includes textual names of the values.
		//Returns:the day-of-week, not null
		int hour = currentDateTime.getHour();
		//Gets the hour-of-day field.
		int minute = currentDateTime.getMinute();
		//Gets the minute-of-hour field.
		int second = currentDateTime.getSecond();
		//Gets the second-of-minute field.

		System.out.println("년도: " + year);
		System.out.println("월: " + month);
		System.out.println("날: " + day);

		System.out.println("요일: " + dayOfWeek);
		System.out.println("요일을 숫자로: " + dayOfWeek.getValue()); // 월요일 1 ~ 일요일 7
		System.out.println("시: " + hour);
		System.out.println("분: " + minute);
		System.out.println("초: " + second);

	}

}
