package boj;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stok = new StringTokenizer(br.readLine());
		double a = 0;
		double b = 0;
		while (stok.hasMoreTokens()) {
			a = Double.valueOf(stok.nextToken());
			b = Double.valueOf(stok.nextToken());
		}
		System.out.println(a / b);
	}
}