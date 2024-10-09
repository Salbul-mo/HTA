package boj.class2;

import java.io.*;
import java.util.*;

public class BlackJack_2798 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nm = br.readLine().split(" ");
		
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		
		
		String[] nums = br.readLine().split(" ");
		
		int[] arr = List.of(nums).stream().mapToInt(str -> Integer.parseInt(str)).toArray();
		
		int max = -1;
		
		for (int cnt1 = 0; cnt1 < n-2; cnt1++) {
 		
			for (int cnt2 = cnt1 + 1; cnt2 < n-1; cnt2++) {
			
				for (int cnt3 = cnt2 + 1; cnt3 < n; cnt3++) {
					
					int sum = arr[cnt1] + arr[cnt2] + arr[cnt3]; 

					if (sum > max && sum <= m)
						max = sum;
				}
			}
		}
		
		
		System.out.println(max);
	}

}
