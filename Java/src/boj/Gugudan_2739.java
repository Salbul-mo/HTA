package boj;

import java.io.*;

public class Gugudan_2739 {

	public static void main(String args[]) throws IOException {
		
		BufferedReader rs = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(rs.readLine());
		
		for (int i = 1 ; i <= 9 ; i++) {
			System.out.println(n + " * " + i + " = " + (n * i) );
		}
		
	}
}
