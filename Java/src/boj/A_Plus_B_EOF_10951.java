package boj;

import java.io.*;

public class A_Plus_B_EOF_10951 {

	public static void main(String[] args) throws Exception {

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String str = br.readLine();
			if (str == null)
				break;

			String[] arr = str.split(" ");
			int a = Integer.parseInt(arr[0]);
			int b = Integer.parseInt(arr[1]);
			bw.write(Integer.toString(a + b) +"\n");

		}
		bw.flush();

	}
}
