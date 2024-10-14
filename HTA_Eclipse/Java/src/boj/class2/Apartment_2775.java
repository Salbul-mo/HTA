package boj.class2;

import java.io.*;
import java.util.*;

public class Apartment_2775 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int cnt = 1; cnt <= t; cnt++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			int total = 0;
			/* 1	5	15	35	70	126	210	330	495
			 * 1	4	10	20	35	56	84	120	165
			 * 1	3	6	10	15	21	28	36	45
			 * 1	2	3	4	5	6	7	8	9
			 */
			for(int floor = 0 ; floor < k ; floor++) {
				for(int ho = 1 ; ho <= n ; ho++) {
					total += ho;
				}
			}  
			
			
			
		}
		
		
	}

}
