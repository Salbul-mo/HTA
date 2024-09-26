package ex09_11_enum_method;

public class EnumExample1 {

	public static void main(String[] args) {
		Day days[] = Day.values(); 
		//열거 타입에 속하는 모든 열거 상수들을 배열에 담아서 리턴하는 메서드
		//반환된 참조값을 을 Enum클래스 Day를 참조타입으로 하는 배열 days[] 에 대입 

		for (int i = 0; i < days.length; i++) {
			System.out.println(days[i] + " : " + days[i].ordinal());
			//Enum상수.ordinal(); 
			//Returns the ordinal of this enumeration constant (its positionin its enum declaration, where the initial constant is assignedan ordinal of zero).Most programmers will have no use for this method. It isdesigned for use by sophisticated enum-based data structures, suchas java.util.EnumSet and java.util.EnumMap.
			//열거형 클래스에 속하는 해당 상수의 순서에 해당하는 정수를 리턴하는 메서드
		}

		System.out.println("===============================");

		for (Day day : days)
			System.out.println(day + " : " + day.ordinal());
	}
}
