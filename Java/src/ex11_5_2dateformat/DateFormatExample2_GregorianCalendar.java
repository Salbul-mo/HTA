package ex11_5_2dateformat;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class DateFormatExample2_GregorianCalendar {

	public static void main(String[] args) {
		GregorianCalendar calendar = new GregorianCalendar();
		
		// Date 사용하다가 Calendar 쓰다가 부족해서 Timepackage 추가해서 사용한다.
		// calendar.getTime() : calendar 객체가 가지고 있는 날짜와 시간과 똑같은 
		// 정보를 갖는 Date 객체를 만들어서 리턴하는 메서드
		System.out.println(calendar.getTime());
		//Returns a Date object representing this Calendar's time value (millisecond offset from the Epoch").
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 M월 dd일 a h시 m분 s초 E요일");
		System.out.println(sdf.format(calendar.getTime()));
		
	}
}
