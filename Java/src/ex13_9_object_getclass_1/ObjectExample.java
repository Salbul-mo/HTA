package ex13_9_object_getclass_1;

public class ObjectExample {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		Point p = new Point(5, 10);
		// 1. 생성된 객체로 부터 얻는 방법
		Class c1 = p.getClass();
		// The Class object that represents the runtimeclass of this object.
		// The actual result type is Class <? extends |X|>
		// where |X| is the ??erasure of the static type?? of the expression on which
		// getClass is called

		// 2. 클래스 리터럴(.class)로 부터 얻는 방법
		Class c2 = Point.class;
		// .class는 클래스 리터럴을 참조하는 구문입니다.
		// 예를 들어, String.class는 String 클래스의 Class 객체를 참조합니다.
		// 이는 특정 클래스의 Class 객체를 얻기 위한 가장 간단한 방법입니다.

		// 3. 클래스 이름으로 부터 얻는 방법 - throws ClassNotFoundException
		Class c3 = null;
		try { // 매개변수로 패키지명.클래스명을 사용한다.
			c3 = Class.forName("ex13_9_object_getclass_1.Point");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println(c1.toString());
		System.out.println(c2);
		System.out.println(c3);

		// 패키지명.클래스명
		System.out.println(c1.getName());
		System.out.println(c2.getName());
		System.out.println(c3.getName());

		// 접근제어자 class 패키지명.클래스명
		System.out.println(c1.toGenericString());
		System.out.println(c2.toGenericString());
		System.out.println(c3.toGenericString());
	}

}
