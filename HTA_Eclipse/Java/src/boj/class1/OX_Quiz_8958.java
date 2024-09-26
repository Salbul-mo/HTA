package boj.class1;

import java.util.*;

public class OX_Quiz_8958 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		String result = "";
		for (int i = 1; i <= t; i++) {
			String str = sc.nextLine();

			char[] arr = str.toCharArray();
			int score = 1;
			int total = 0;

			for (int cnt = 0; cnt < arr.length; cnt++) {
				if (cnt == 0 && arr[cnt] == 'O')
					total += score;

				else if (arr[cnt] == 'O' && cnt - 1 >= 0 && arr[cnt - 1] == 'O')
					total += ++score;

				else if (arr[cnt] == 'O')
					total += score;

				else
					score = 1;
			}
			result += total +"\n";

		}
		System.out.println(result);
		sc.close();
	}
}