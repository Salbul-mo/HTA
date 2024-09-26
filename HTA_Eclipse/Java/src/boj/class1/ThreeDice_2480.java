package boj.class1;

import java.io.*;
import java.util.*;

public class ThreeDice_2480 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stok = new StringTokenizer(br.readLine());

		int temp = 0;
		int a = 0;
		int acnt = 0;
		int b = 0;
		int bcnt = 0;
		int c = 0;

		while (stok.hasMoreTokens()) {
			a = Integer.valueOf(stok.nextToken());
			acnt++;

			temp = Integer.valueOf(stok.nextToken());

			if (temp == a)
				acnt++;

			else {
				b = temp;
				bcnt++;
			}

			temp = Integer.valueOf(stok.nextToken());

			if (temp == a)
				acnt++;
			else if (b == 0) {
				b = temp;
				bcnt++;
			} else if (b == temp)
				bcnt++;
			else
				c = temp;
		}

		switch (acnt) {
		case 3:
			System.out.println(10000 + a * 1000);
			break;
		case 2:
			System.out.println(1000 + a * 100);
			break;
		case 1:
			if (bcnt == 2) {
				System.out.println(1000 + b * 100);
				break;
			} else {
				int[] arr = { a, b, c };
				int max = a;
				for (int i = 1; i < 3; i++) {
					max = max > arr[i] ? max : arr[i];
				}
				System.out.println(100 * max);
			}

		}

	}
}
