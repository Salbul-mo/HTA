package ex13_7_object_equals_overriding;

public class ObjectExample2 {

	public static void main(String args[]) {
		Circle2 obj1 = new Circle2(5);
		Circle2 obj2 = new Circle2(5);
		Circle2 obj3 = new Circle2(5);

		System.out.println(obj1);
		System.out.println(obj1.toString());
		System.out.println(obj2);
		System.out.println(obj2.toString());

		if (obj1.equals(null))
			System.out.println("obj1.equals(null) : 같음");
		else
			System.out.println("obj1.equals(null) : 다름");

		if (obj1.equals(obj1))
			System.out.println("obj1.equals(obj1) : 같음");
		else
			System.out.println("obj1.equals(obj1) : 다름");
		
		if (obj1.equals(obj2))
			// equals(Object 타입 참조 매개 변수) 이므로 
			// (Object)obj2 의 업캐스팅이 자동으로 실행된 후 매개 참조 변수를 집어넣고 메서드 호출한다/
			System.out.println("obj1.equals(obj2) : 같음");
		else
			System.out.println("obj1.equals(obj2) : 다름");
		
		if (obj2.equals(obj3))
			System.out.println("obj2.equals(obj3) : 같음");
		else
			System.out.println("obj2.equals(obj3) : 다름");
		
		if (obj1.equals(obj3))
			System.out.println("obj1.equals(obj3) : 같음");
		else
			System.out.println("obj1.equals(obj3) : 다름");

		if (obj1 == obj2)
			System.out.println("obj1 == obj2 : 같음");
		else
			System.out.println("obj1 == obj2 : 다름");

	}
}
