package ex11_5_3_time;

import java.time.LocalTime;
import java.time.ZoneId;

public class LocalTimeExample {

	public static void main(String[] args) {
		
		//시스템 시계에서 현재 시간을 가져옵니다.
		LocalTime current = LocalTime.now();
		//Obtains the current time from the system clock in the default time-zone. 
		//This will query the system clock in the default time-zone to obtain the current time. 
		//Using this method will prevent the ability to use an alternate clock for testing
		//because the clock is hard-coded.


		int hour = current.getHour();
		int minute = current.getMinute();
		int second = current.getSecond();

		System.out.println("시간" + hour + ":" + minute + ":" + second);

		// 타임존 Id사용
		LocalTime currentTimeInParis = LocalTime.now(ZoneId.of("Europe/Paris"));
		System.out.println("The current time in paris is " + currentTimeInParis);
	}
}
