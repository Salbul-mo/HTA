package boj;

import java.io.*;
import java.util.*;

public class Smaller_X_10871 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] arr = br.readLine().split(" ");
		int n = Integer.parseInt(arr[0]);
		int x = Integer.parseInt(arr[1]);
		
		StringTokenizer stok = new StringTokenizer(br.readLine());
		
		while(stok.hasMoreTokens()) {
			for (int i = 1; i <= n ; i++) {
				int num = Integer.parseInt(stok.nextToken());
				
				if (num < x)
					bw.write(Integer.toString(num)+" ");
			
			}
		}
		bw.flush();
		
		
	}
}
