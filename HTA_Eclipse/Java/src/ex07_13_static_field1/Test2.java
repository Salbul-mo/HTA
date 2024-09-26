package ex07_13_static_field1;

public class Test2 {
	
	public static void main(String[] args) {
		//클래스 변수 접근 Accumulator.grandTotal
		
		Accumulator obj1 = new Accumulator();
		obj1.total = 0;
		System.out.println("정적 변수 grandTotal =" + Accumulator.grandTotal);
		obj1.accumulate(10);
		System.out.println("obj1.total = " + obj1.total);
		System.out.println("obj1.grandTotal = " + /*obj1.grandTotal*/Accumulator.grandTotal); 
		//Accumulator.grandTotal 로 접근해야 한다.
		//The static field Accumulator.grandTotal should be accessed in a static way
		System.out.println("=========================================");
		
		
		Accumulator obj2 = new Accumulator();
		obj2.total = 0;
		obj2.accumulate(20);
		System.out.println("obj2.total = " + obj2.total);
		System.out.println("obj2.grandTotal = " + Accumulator.grandTotal); 
		//Accumulator.grandTotal 로 접근해야 한다.
		//The static field Accumulator.grandTotal should be accessed in a static way
		System.out.println("정적 변수 grandTotal =" + Accumulator.grandTotal);

	}

}
