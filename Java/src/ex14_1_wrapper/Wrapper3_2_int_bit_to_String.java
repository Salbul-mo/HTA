package ex14_1_wrapper;

public class Wrapper3_2_int_bit_to_String {

	public static void main(String[] args) {
		int sum = 255;
		
		for (String arg : args) {
			sum += Integer.parseInt(arg);
		}
		
		System.out.println("합은 = " + sum);
		
		System.out.println("10진수 : " + sum + "\t 2진수 문자열: " + Integer.toBinaryString(sum));
		System.out.println("10진수 : " + sum + "\t 8진수 문자열: " + Integer.toOctalString(sum));
		System.out.println("10진수 : " + sum + "\t 16진수 문자열: " + Integer.toHexString(sum));
		
		/*
		 * 합은 = 255 
		 * 10진수 : 255  2진수 문자열: 11111111 
		 * 10진수 : 255  8진수 문자열: 377 
		 * 10진수 : 255 16진수 문자열: ff
		 * 
		 */
	}
}
