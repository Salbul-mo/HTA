package boj.class2;

import java.math.BigInteger;
import java.util.Scanner;

public class HashFunction_15829 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		sc.nextLine();
		
		int[] arr = sc.nextLine().chars().map( i -> i - 96).toArray();
		sc.close();
		
		BigInteger sum = new BigInteger("0");;
		
		for (int cnt = 0; cnt < arr.length; cnt++) {
			BigInteger pow = new BigInteger("1");
			
			for(int j = 0; j < cnt; j++) {
				pow = pow.multiply(BigInteger.valueOf(31));
			}
			
			sum.add(BigInteger.valueOf(arr[cnt]).multiply(pow));
			
		}
		
		sum = sum.mod(BigInteger.valueOf(1234567891));
		System.out.println(sum);
		
	}
}

