package boj;

import java.io.*;

class Long_25314 {

	public static void main(String args[]) throws Exception{
	
		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(rb.readLine());
		String result = "";
		
		for (int cnt = 1; cnt <= n/4; cnt++) {
			result += "long ";
		}
		
		result += "int";
		
		System.out.println(result);
	}

}
