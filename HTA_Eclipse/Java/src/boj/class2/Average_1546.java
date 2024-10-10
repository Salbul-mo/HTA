package boj.class2;

import java.io.*;
import java.util.stream.Stream;

public class Average_1546 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int subject = Integer.parseInt(br.readLine());
		
		String[] score = br.readLine().split(" ");
		
		int[] arr = Stream.of(score).mapToInt(Integer::parseInt).toArray();
		int max = 0;
		
		for(int cnt = 0 ; cnt < subject ; cnt++) {
			max = max < arr[cnt] ? arr[cnt] : max;
		}
		
		double sum = 0;
		
		for(int num : arr)
			sum += ((double) num / (double)max) * 100;
		
		bw.write(Double.toString(sum/subject));
		bw.flush();
	}

}
