package boj;

import java.io.*;
import java.util.*;

public class EqualCheck_1330 {

	public static void main(String args[]) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stok = new StringTokenizer(br.readLine());
		int a = 0;
		int b = 0;
		while (stok.hasMoreTokens()) {
			a = Integer.valueOf(stok.nextToken());
			b = Integer.valueOf(stok.nextToken());
			
		}
		
		if (a > b)
		System.out.println(">");
		else if (a < b)
		System.out.println("<");
		else 
		System.out.println("==");
		
	}
}
