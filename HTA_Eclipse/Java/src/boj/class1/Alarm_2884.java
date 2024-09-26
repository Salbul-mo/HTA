package boj.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alarm_2884 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stok = new StringTokenizer(br.readLine());
		
		int h = 0;
		int m = 0;
		
		while (stok.hasMoreTokens()) {
			h = Integer.valueOf(stok.nextToken());
			m = Integer.valueOf(stok.nextToken());
		}
		
		int temp = m -45;
		
		if (temp < 0) {
			int newM = 60 + temp;
			int newH = h - 1;
			if( newH < 0) {
				newH = 23;
			}
			
			System.out.println(newH+" "+newM);
		}
		
		else {
			System.out.println(h+" "+temp);
		}
		
		
	}
}
