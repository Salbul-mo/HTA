package ex11_5_1_calendar;

import java.util.Calendar;

public class Calendar_Example1 {
	public static void main(String[] args) {
		// 2024년 8월 2일 오전 10:10:9 금요일 입니다

		Calendar today = Calendar.getInstance();
		// YEAR today.get(1) 는 정상 출력
		// MONTH today.get(2)+1 는 0~11 까지 출력되므로 +1 을 해줘야 현재 달이 나온다
		// DATE today.get(Calendar.DATE) 정상 출력
		// AM_PM today.get(Calendar.AM_PM) 0이 오전 1이 오후 String[] ampm = {"오전","오후"}; 배열로
		// 만들어서 쓰면 편하다
		// 12시간 포맷은 today.get(Calendar.HOUR)
		// 24시간 포맷은 today.get(Calendar.HOUR_OF_DAY)
		// 분은 today.get(Calendar.MINUTE)
		// 초는 today.get(Calendar.SECOND)
		// 무슨 요일 today.get(Calendar.DAY_OF_WEEK) 는 요일을 1~7까지 반환. 
		// String[] yoil = {"일요일","월요일","화요일","수요일","목요일","금요일","토요일"}; 배열로 만들어서 쓰면 편하다
		// 대신 배열은 0부터 시작하므로 반환받은 값 -1 을 해야 제대로 인덱스번호가 맞는다.

		String ampm = "";
		if (today.get(Calendar.AM_PM) == 0) {
			ampm = "오전";
		} else {
			ampm = "오후";
		}

		String date = "";
		switch (today.get(Calendar.DAY_OF_WEEK)) {
		case 1 -> date = "일요일";
		case 2 -> date = "월요일";
		case 3 -> date = "화요일";
		case 4 -> date = "수요일";
		case 5 -> date = "목요일";
		case 6 -> date = "금요일";
		case 7 -> date = "토요일";
		}

		System.out.printf("%d년 %d월 %d일 %s %d:%d:%d %s 입니다.", today.get(1), today.get(2) + 1, today.get(Calendar.DATE),
				ampm, today.get(Calendar.HOUR), today.get(Calendar.MINUTE), today.get(Calendar.SECOND), date);
		Calendar now = Calendar.getInstance();
		System.out.print(now);
		now.set(2025, 1 ,14); // ->> 타인이 로컬 데이터를 건들면 변조되어서 이제는 잘 쓰지 않는다. 
		System.out.print(now);
	}
}
