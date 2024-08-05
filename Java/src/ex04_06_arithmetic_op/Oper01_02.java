package ex04_06_arithmetic_op;

public class Oper01_02 {
	
	public static void main(String[] v) {
		int a = 10, b = 4 , c;
		
		c = a + b; 
		System.out.println(a + "+" + b + "=" + c);
	
		c = a - b;
		System.out.println(a + "-" + b + "=" + c);
		
		c = a * b;
		System.out.println(a + "*" + b + "=" + c);
		
		c= a / b;
		System.out.println(a + "/" + b + "=" + c);
		
		c = a % b;
		System.out.println(a + "%" + b + "=" + c);
		
		System.out.printf("%d %% %d = %d\n" ,a,b,c);
		
		
		
		System.out.println(a + "/" + b + "=" + (double) a / b);
		
		// 어느 한쪽을 double 로 바꿔주면 다른 쪽은 자동으로 변경된다.
	}

}
