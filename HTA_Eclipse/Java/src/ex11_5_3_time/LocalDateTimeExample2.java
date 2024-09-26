package ex11_5_3_time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeExample2 {

	public static void main(String[]args) {
		//현재 날짜와 시간 데이터 가져오기
		LocalDateTime current = LocalDateTime.now();
		//원하는 형식을 
	  //DateTimeFormatter 타입       식별자 =  DateTimeFormatter.메서드이름(서식);
		DateTimeFormatter      formatter =  DateTimeFormatter.ofPattern("yyyy-MM-dd EEEE HH:mm:ss");
		
		// 날짜와 시간 데이터를 형식에 맞춰 문자열로 변환
		String formattedDateTime = current.format(formatter);
		// date-time using the specified formatter. 
		//This date-time will be passed to the formatter to produce a string.
		//Specified by: format(...) in ChronoLocalDateTime
		//Parameters:formatter the formatter to use, not null
		//Returns:the formatted date-time string, not null
		//Throws:DateTimeException - if an error occurs during printing
		
		System.out.println(formattedDateTime);
		
	}
}
