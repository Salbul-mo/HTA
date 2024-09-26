package boj.class1;

import java.io.*;
import java.util.*;

public class OvenTime_2525 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stok = new StringTokenizer(br.readLine());
		
		int h = 0;
		int m = 0;
		int oven = 0;
		while (stok.hasMoreTokens()){
			h = Integer.valueOf(stok.nextToken());
			m = Integer.valueOf(stok.nextToken());
		}
		oven = Integer.valueOf(br.readLine());
		
		int newM = m + oven;
		
		while( newM > 60) {
			newM = newM - 60;
			h++;
		}
		if (h >= 24)
			h = h -24;
		
		System.out.println(h + " " + newM);
		
		
	}
}
