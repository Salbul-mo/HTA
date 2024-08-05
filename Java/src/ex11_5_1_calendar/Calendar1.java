package ex11_5_1_calendar;
/*
 * java.lang.Object
		java.util.Calendar
	
	추상 클래스이므로 new 키워드를 사용할 수 없다
	getInstance() 메서드로 참조값을 불러와서 사용한다
	아니면 상속하는 하위 클래스의 인스턴스를 만들고 업캐스팅하여 사용한다
	
	Calendar today = new GregorianCalendar();
 */
import java.util.Calendar;

public class Calendar1 {
	public static void main(String[] args) {
		
		Calendar today = Calendar.getInstance();
		
		System.out.println("이 해의 년도 : " + today.get(1)); // public final static int YEAR = 1;
		
		System.out.println("월(0~11, 0 : 1월) : " + today.get(2)); // public final static int MON = 2;
		
		// DATE 와 DAY_OF_MONTH는 같다.
		System.out.println("이 달의 며칠: " + today.get(Calendar.DATE));
		System.out.println("이 달의 며칠: " + today.get(Calendar.DAY_OF_MONTH));
		System.out.println("이 해의 며칠: " + today.get(Calendar.DAY_OF_YEAR));
		
		// 1:일요일 2:월요일, ... 7:토요일
		System.out.println("요일(1~7, 1: 일요일): " + today.get(Calendar.DAY_OF_WEEK));
		System.out.println("이 달의 몇번 째 무슨요일(ex 이달의 n번째 목요일): " + today.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		System.out.println("오전_오후(0:오전, 1:오후): " + today.get(Calendar.AM_PM));
		System.out.println("시간(0~11): " + today.get(Calendar.HOUR));
		System.out.println("시간(0~23): " + today.get(Calendar.HOUR_OF_DAY));
		System.out.println("분(0~ 59): " + today.get(Calendar.MINUTE));
		System.out.println("초(0~59): " + today.get(Calendar.SECOND));
		// 이 달의 마지막 일을 찾는다
		System.out.println("이 달의 마지막 날: " + today.getActualMaximum(Calendar.DATE));
		System.out.println("1000분의 1초(0~999): " + today.get(Calendar.MILLISECOND));
	}

}
