package ex11_5_2dateformat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormat_Example1_Date {

	public static void main(String args[]) {
		/*
		 * 379페이지 참고
		 * 패턴 문자    의미
		 * y		년
		 * M		월
		 * d		일
		 * D		일(1~365)
		 * E		요일
		 * a		오전/오후
		 * H		시(0~23)
		 * h		시(1~12)
		 * m		분
		 * s		초
		 */
		
		//현재 시스템 날짜와 시간 구하는 방법
		//클래스 Date 이용하는 방법 - 현재 시스템 날짜와 시간 구한다.
		
		Date d = new Date();
		System.out.println("Date 사용 : " + d);
		//System.out.println(new Date()); 위 문장과 같은 의미
		
		SimpleDateFormat sd1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sd2 = new SimpleDateFormat("yyyy년MM월dd일");
		System.out.println(sd1.format(d)); // yyyy-MM-dd 형태로 출력
		System.out.println(sd2.format(d)); // yyyy년MM월dd일 형태로 출력
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy년 MM월 dd일 a HH시 mm분 ss초 E요일");
		System.out.println(sdf1.format(d)); 
		//format.(Date date) 이므로 Calendar 타입 참조형 사용할 수 없다.
		//Calendar 의 getTime()메소드를 이용해서 Date형 리턴값 얻음
	}
}
