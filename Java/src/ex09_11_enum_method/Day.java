package ex09_11_enum_method;
/*
 *	열거타입 이름은 소스 파일명과 대소문자 모두 일치해야한다
 * 
 *	열거 타입은 컴파일을 하고 나면 내부적으로 클래스로 만들어 지는데
 *	이때 values() 와 valueOf(String s) 라는 두 정적 메서드가 자동적으로 추가된다.
 * 
 * 	1. public static ex09_11_enum_method.Day[] values(); 
 * 							열거타입에 속하는 모든 열거 상수들을 배열에 담아서 리턴하는 메서드
 * 	2. public static ex09_11_enum_method.Day 
 * 											valueOf(java.lang.String);
 * 							열거 상수의 이름을 문자열로 넘겨주면 그에 해당하는 열거 상수를 리턴하는 메서드
 */
public enum Day {

	MONDAY, TUESDAY, WENDSDAY, THUSDAY, FRIDAY, SATURDAY, SUNDAY
}
