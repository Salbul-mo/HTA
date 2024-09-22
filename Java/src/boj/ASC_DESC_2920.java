package boj;

import java.io.*;
import java.util.stream.Stream;

public class ASC_DESC_2920 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stream<Integer> stream = Stream.of(br.readLine().split(" ")).map(String -> Integer.parseInt(String));

		Object[] arr = stream.toArray();

		int max = (int) arr[0];
		int min = (int) arr[0];

		for (int cnt = 1; cnt < arr.length; cnt++) {
			if (max < (int) arr[cnt])
				max = (int) arr[cnt];
			else
				break;
		}

		if (max == (int) arr[7])
			System.out.println("ascending");
		
		else {
			for (int cnt = 1; cnt < arr.length; cnt++) {
				if (min > (int) arr[cnt])
					min = (int) arr[cnt];
				else
					break;
			}
			if (min == (int) arr[7]) {
				System.out.println("descending");
			} else {
				System.out.println("mixed");
			}

		}

	}
}