package boj.class2;

import java.io.*;
import java.util.*;

public class Apartment_2775 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine()); // 입력 케이스 수
		
		
		for (int c = 0; c < t; c++) {
			int k = Integer.parseInt(br.readLine()); // 입력 층
			int n = Integer.parseInt(br.readLine()); // 입력 호

			
			int[] present = new int[n];

			for (int j = 1; j <= k; j++) { // 1층 부터 시작
				
				for (int ho = 1; ho <= n; ho++) {
					present[ho-1] = 0;
					
					for (int bef = 1; bef <= ho; bef++) {
						present[ho-1] += before[bef-1];
					}
				}
				
				before = present;
			
			}
			
			
			bw.write(Integer.toString(before[n-1])+"\n");
		
		}
		
		bw.flush();
	}
}
