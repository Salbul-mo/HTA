package ex13_6_object_equals;

import java.util.GregorianCalendar;
/*
 * Object 클래스의 equals() 메소드
 * 1. 매개변수로 객체의 참조변수를 받아서 비교하여 그 결과를 boolean으로 리턴한다
 * 2. public boolean equals(Object arg0) {
 * 		return this == arg0;
 * 	  }
 * 3.두 객체의 같고 다름을 참조변수의 값으로 판단한다.
 * 4.서로 다른 두 객체를 equals메서드로 비교하면 항상 false결과를 얻게 된다.
 */

public class ObjectExample {

	public static void main(String args[]) {
		GregorianCalendar obj1 = new GregorianCalendar(2024, 7, 5);
		GregorianCalendar obj2 = new GregorianCalendar(2024, 7, 5);

		System.out.println(obj1);
		System.out.println(obj2);

		System.out.println(obj1.toString());
		// 오버라이딩 되어 있다.Return a string representation of this calendar
		System.out.println(obj2.toString());

		if (obj1 == obj2)
			System.out.println("obj1 == obj2 : 같음");
		else
			System.out.println("obj1 == obj2 : 다름");

		if (obj1.equals(obj2)) // 오버라이딩 되어있다.
			/*
			 * Compares this GregorianCalendar to the specified Object. The result is true
			 * if and only if the argument is a GregorianCalendar object that represents the
			 * same time value (millisecond offset from the Epoch) under the same Calendar
			 * parameters and Gregorian change date as this object.
			 */

			System.out.println("obj1.equals(obj2) : 같음");
		else
			System.out.println("obj1.equals(obj2) : 다름");

	}
}
