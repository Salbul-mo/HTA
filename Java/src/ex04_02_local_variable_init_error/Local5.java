package ex04_02_local_variable_init;

public class Local5{

	public static void main(String[] v) {
		int num = 20;
		System.out.println("2=" + num);
		 
		int num = 10; 
		//Duplicate local variable num 오류 발생
		//이미 같은 이름으로 선언된 변수가 있다. 다른 이름으로 바꿔줘야 한다.
		System.out.println("1=" + num);
	}
}
