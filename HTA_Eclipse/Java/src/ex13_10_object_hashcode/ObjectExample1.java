//Java 의 hashCode 메서드는 객체의 해시 코드를 반환하며, 이 해시 코드는 해당 객체를 식별하는데 사용된다.
package ex13_10_object_hashcode;

public class ObjectExample1 {

	public static void main(String args[]) {
		String str1 = new String("abc");
		String str2 = new String("abc");

		// String 클래스는 문자열의 내용이 같으면 동일한 해시코드를 반환하도록
		// hashCode 메서드가 오버라이딩되어 있기 때문에
		// 문자열의 내용이 같은 str1 과 str2 에 대해 hashCode() 를 호출하면
		// 항상 동일한 해시코드값을 얻는다.
		// -> hashCode 자체를 문자열의 구조로 얻기 때문에 문자열이 같으면 해시코드도 동일하다
		// 만일 두 클래스의 equals(Object obj) 메서드가 true면
		// hashCode()의 값도 반드시 같아야 한다.
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		
		System.out.println(str1.equals(str2));
		// String .equals(Object obj); -> 문자열 객체에 포함된 문자들의 연속이 같은지 판단하고 리턴한다.

	}
}
