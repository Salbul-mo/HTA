package boj;

import java.io.*;
import java.util.*;

public class Max_Min_10818 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
			
		StringTokenizer stok = new StringTokenizer(br.readLine());
				
		int max = Integer.parseInt(stok.nextToken());
		int min = max;
		
		for (int cnt = 1; cnt <= n - 1 ; cnt++) {
			int num = Integer.parseInt(stok.nextToken());
			if (num > max)
				max = num;
			
			if (num < min)
				min = num;
			
		}
		System.out.println(min + " " + max);
	}
}
