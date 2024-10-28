package boj.class2;

import java.io.*;
import java.util.*;

public class Apartment_2775 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine()); // 입력 케이스 수
		
		for (int j = 0; j < t; j++) {
		
		int k = Integer.parseInt(br.readLine()); // 입력 층
		int n = Integer.parseInt(br.readLine()); // 입력 호
		
		int[] one = new int[n];
		
		for (int i = 1; i <= one.length; i++) {
			one[i-1] = i;
		}
		
		int[] beforefloor = one;
		int[] presentfloor = one;
		
		
		for(int cnt = 2; cnt <= k; cnt++) {
			// 층 for
			for (int ho = 0; ho < presentfloor.length; ho++) {
				// ho for
				int sum = 0;
				
				for (int before = 0; before <= ho; before++) {
					sum += beforefloor[before];
				}
				presentfloor[ho] = sum;
			}
			beforefloor = presentfloor;
		}
		
		bw.write(presentfloor[n-1] + "\n");
		}
		
		bw.flush();
	}

}
