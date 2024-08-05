package ex04_09_incr_dec;

public class IncrDec2 {

	public static void main(String[] b) {
		
		int n1 = 10, n2 = 10, n3 = 10, n4 = 10;
		
		System.out.println(++n1); 
		//더하고 출력한다. 10 + 1 대입하고 / 11 출력 
		
		System.out.println(n1); // 11
		
		System.out.println(n2++); 
		// 출력하고 더한다. 10 출력하고 / 10 + 1 대입 
		
		System.out.println(n2); // 11
		
		System.out.println(--n3); 
		// 빼고 출력한다. 10 - 1 대입하고 / 9 출력 
		
		System.out.println(n3); // 9
		
		System.out.println(n4--); 
		// 출력하고 뺀다. 10 출력하고 / 10 - 1 대입
		
		System.out.println(n4); // 9
	}
}
