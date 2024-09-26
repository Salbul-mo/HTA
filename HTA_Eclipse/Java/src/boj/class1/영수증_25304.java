package boj.class1;

import java.io.*;
import java.util.*;

public class 영수증_25304 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int sum = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer stok = new StringTokenizer(br.readLine());
			while (stok.hasMoreTokens()) {
				int price = Integer.parseInt(stok.nextToken());
				int quantity = Integer.parseInt(stok.nextToken());
				sum += price * quantity;
			}
		}
		if (x == sum)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
