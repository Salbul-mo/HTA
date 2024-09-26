package boj.class1;

import java.io.*;

public class SumOfNum_11720 {

	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String nums = br.readLine();
		int sum = 0;
		for (int i = 0; i < n ; i++) {
			sum += Integer.parseInt(nums.substring(i, i + 1));
		}
		
		System.out.println(sum);
	}
}
