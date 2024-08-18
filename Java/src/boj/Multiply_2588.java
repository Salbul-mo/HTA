package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String a = br.readLine();
		String b = br.readLine();
		
		int aNum = Integer.valueOf(a);
		
		int b100 = Character.getNumericValue(b.charAt(0));
		int b10 = Character.getNumericValue(b.charAt(1));
		int b1 = Character.getNumericValue(b.charAt(2));
		
		System.out.println(aNum * b1);
		System.out.println(aNum * b10);
		System.out.println(aNum * b100);
		System.out.println(aNum *((b100*100)+(b10*10)+b1));
	}

}
