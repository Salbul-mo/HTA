package ex04_07_concate_op;

public class Concate2_hap {

	public static void main(String args[]) {
		String str1 = "hap=" + 3 + 4; // hap=34
		System.out.println(str1);
		String str2 = 3 + 4 + "=hap"; 
		System.out.println(str2); // 앞에서부터 처리 7=hap
		String str3 = "hap=" + (3+4);
		System.out.println(str3); // hap=7
	}
}
