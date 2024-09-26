package ex09_01_reference;

public class RefTypeExample {
	public static void main(String[] args) {
		
		Point obj1 = new Point(10,20); //객체 생성
		Point obj2 = obj1; // 같은 타입의 다른 식별자에 참조값 대입
		System.out.printf("obj1 = (%d,%d) %n", obj1.x, obj1.y);  
		System.out.printf("obj2 = (%d,%d) %n", obj2.x, obj2.y);  
		//obj1 과 obj2 는 같은 객체를 가르키게 된다.
		obj2.x = 30;
		System.out.printf("obj1 = (%d,%d) %n", obj1.x, obj1.y);  
		System.out.printf("obj2 = (%d,%d) %n", obj2.x, obj2.y);  
		
	}

}
