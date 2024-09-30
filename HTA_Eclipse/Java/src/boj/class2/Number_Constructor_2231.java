package boj.class2;

import java.io.*;

public class Number_Constructor_2231 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine(); 
		
		int i = Integer.parseInt(input);
		
		int length = input.length();
		
		for (int cons = (i - length*9); cons < i; cons++) {
			String temp1 = Integer.toString(cons);
			int temp2 = 0;
			for(int j = 0; j < temp1.length(); j++) {
				temp2 += Character.getNumericValue(temp1.charAt(j));
			}
			if((cons + temp2) == i) {
				System.out.println(cons);
				return;
			}
		
		}
		System.out.println(0);	
	}
};