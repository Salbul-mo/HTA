package boj.class1;

import java.io.*;

public class PrintN_2741 {

	public static void main(String args[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for (int cnt = 1; cnt <= n ; cnt++) {
			System.out.println(cnt);
		} 
		
		
	}
}
