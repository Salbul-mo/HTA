package boj.class1;

import java.io.*;
import java.util.*;

public class Hotel_ACM_10250 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());

		for (int i = 1; i <= t; i++) {
			StringTokenizer stok = new StringTokenizer(br.readLine());
			while (stok.hasMoreTokens()) {
				int h = Integer.parseInt(stok.nextToken());
				int w = Integer.parseInt(stok.nextToken());
				int n = Integer.parseInt(stok.nextToken());

				String yy = "";
				String xx = "";

				for (int x = 1, cnt = 1; x <= w && cnt <= n; x++) {
					if (x < 10)
						xx = "0" + Integer.toString(x);
					else
						xx = Integer.toString(x);

					for (int y = 1; y <= h && cnt <= n; y++) {
						yy = Integer.toString(y);
						cnt++;
					}
				}

				bw.write(yy + xx + "\n");
			}
		}
		bw.flush();
	}
}
