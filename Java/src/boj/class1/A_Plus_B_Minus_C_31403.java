package boj.class1;

import java.util.*;

public class A_Plus_B_Minus_C_31403 {

	public static void main(String args[]) {
		
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		input.nextLine();
		
		int b = input.nextInt();
		input.nextLine();
		
		int c = input.nextInt();
		input.nextLine();
		
		String sa = Integer.toString(a);
		String sb = Integer.toString(b);
		String sc = Integer.toString(c);
		
		System.out.println((a+b-c) + "\n" + (Integer.parseInt(sa + sb) - Integer.parseInt(sc))); 
		
		input.close();
	}
}
