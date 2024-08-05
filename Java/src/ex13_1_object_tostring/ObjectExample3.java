package ex13_1_object_tostring;

//Object 클래스에 정의된 toString() 은 인스턴스에 대한 정보를 문자열로 반환한다.
/*
 * 클래스 작성할 때 toString()을 오버라이딩 하지 않으면 아래와 같이 정의된 내용이 사용된다.
 * 
 * return getClass().getName() + "@" + Integer.toHexString(hashCode());
 * 
 * -getClass() 메서드와 hashCode() 메서드 역시 Object 클래스의 메서드이므로 호출할 수 있다.
 * 해시 코드는 인스턴스의 주소와 관련된 값이다.
 * 
 * -Integer.toHexString() 는 정수 hashCode()의 리턴값을 16진수 문자열로 리턴한다
 * 
 * -hashCode()메서드는 해싱(hashing)기법에 사용되는 해시 함수(hash function)를 구현한 것이다.
 * (1) 해싱은 키를 이용해서 해시 테이블로부터 데이터를 가져오는 과정으로
 * 데이터 관리 기법 중의 하나로 다량의 데이터를 저장하고 검색하는 데 유용하다.
 * (2) 해시 함수는 찾고자하는 값을 입력하는 그 값이 저장된 위치를 알려주는 해시코드를 반환한다.
 * (3) 해시테이블이란 키를 입력 받아 해시함수를 통해 얻은 해시코드에 대응하는 배열의 위치를 찾아 데이터에 접근하는 자료구조이다.
 * 
 */
public class ObjectExample3 {

	public static void main(String args[]) {
		Circle2 obj1 = new Circle2(5);
		Circle2 obj2 = new Circle2(15);

		System.out.println(obj1.hashCode());// 617901222
		System.out.println(obj2.hashCode());// 1159190947

		System.out.println(obj1.toString()); // Circle2 에서 오버라이딩된 toString()이 사용되었다.
		System.out.println(obj1);

		System.out.println(obj2.toString()); // Circle2 에서 오버라이딩된 toString()이 사용되었다.
		System.out.println(obj2);
	}
}
