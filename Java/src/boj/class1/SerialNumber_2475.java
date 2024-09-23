package boj.class1;

import java.io.*;
import java.util.*;

public class SerialNumber_2475 {

	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stok = new StringTokenizer(br.readLine());
		int a,b,c,d,e;
		while (stok.hasMoreTokens()) {
			a = (int) Math.pow(Integer.parseInt(stok.nextToken()),2);
			b = (int) Math.pow(Integer.parseInt(stok.nextToken()),2);
			c = (int) Math.pow(Integer.parseInt(stok.nextToken()),2);
			d = (int) Math.pow(Integer.parseInt(stok.nextToken()),2);
			e = (int) Math.pow(Integer.parseInt(stok.nextToken()),2);
			
			int	result = (a + b + c + d + e) % 10;
			System.out.println(result);
			
		}
		
	
	
	}
	
}
