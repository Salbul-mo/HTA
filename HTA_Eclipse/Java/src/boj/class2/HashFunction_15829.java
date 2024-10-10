package boj.class2;

import java.math.BigInteger;
import java.io.*;

public class HashFunction_15829 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int l = Integer.parseInt(br.readLine());
		String input = br.readLine();
		
		BigInteger sum = new BigInteger("0");;
		BigInteger pow = new BigInteger("1");
		
		for (int cnt = 0; cnt < l; cnt++) {
			
			sum = sum.add(BigInteger.valueOf(( (int) input.charAt(cnt) - 96)).multiply(pow));
			
			pow = pow.multiply(BigInteger.valueOf(31));
		}
		
		sum = sum.remainder(BigInteger.valueOf(1234567891));
		
		bw.write(sum.toString());
		bw.flush();
	}
}

