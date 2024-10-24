package boj.class2;

import java.io.*;
import java.util.*;

public class Apartment_2775 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine()); // 입력 케이스 수
		int k = Integer.parseInt(br.readLine()); // 입력 층
		int n = Integer.parseInt(br.readLine()); // 입력 호
		
		int[] zero = new int[n];
		
		for (int i = 1; i < zero.length; i++) {
			zero[i] = i;
		}
		
		int[] beforefloor = zero;
		int[] presentfloor = new int[n];
		
		
		for(int cnt = 2; cnt < k; cnt++) {
			
			for (int ho = 0; ho < presentfloor.length; ho++) {
				
				int sum = 0;
				
				for (int before = 0; before <= ho; before++) {
					sum += beforefloor[before];
				}
				presentfloor[ho] = sum;
			}
		}
		
		
	}

}
