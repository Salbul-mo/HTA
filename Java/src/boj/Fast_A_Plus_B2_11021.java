package boj;

import java.io.*;
import java.util.*;

public class Fast_A_Plus_B2_11021 {

	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		
		for (int cnt = 1; cnt <= t; cnt++) {
			StringTokenizer stok = new StringTokenizer(br.readLine());
			while (stok.hasMoreTokens()) {
				int a = Integer.parseInt(stok.nextToken());
				int b = Integer.parseInt(stok.nextToken());
				bw.write("Case #" + cnt + ": " + Integer.toString((a+b))+"\n");
			}
			
				
		}
		bw.flush();
	}

}
