package ex13_7_object_equals_overriding;

public class RectangleMain {

	public static void main(String[] args) {

		Rectangle obj1 = new Rectangle(16, 10);
		Rectangle obj2 = new Rectangle(16, 10);
		
		System.out.println(obj1);
		System.out.println(obj2);
		
		if(obj1 == obj2) 
			System.out.println("obj1 == obj2 같음");
		else
			System.out.println("obj1 == obj2 다름");

		if (obj1.equals(obj2))
			System.out.println("obj1.equals(obj2) : 같음");
		else
			System.out.println("obj1.equals(obj2) : 다름");
	}
}
