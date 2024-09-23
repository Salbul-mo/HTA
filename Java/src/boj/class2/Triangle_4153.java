package boj.class2;

import java.util.*;
import java.io.*;

public class Triangle_4153 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String result = "";
		while (true) {
			StringTokenizer stok = new StringTokenizer(br.readLine());

			long a = Long.parseLong(stok.nextToken());
			long b = Long.parseLong(stok.nextToken());
			long c = Long.parseLong(stok.nextToken());

			if (a == 0 && b == 0 && c == 0)
				break;
			
			ArrayList<Long> list = new ArrayList<>();
			list.add(a);
			list.add(b);
			list.add(c);
			
			Collections.sort(list);
			
			a = list.get(0);
			b = list.get(1);
			c = list.get(2);
			
			if (a*a + b*b == c*c)
				result += "right" + "\n";
			else
				result += "wrong" + "\n";
		}

		System.out.println(result.trim());
	}
}
