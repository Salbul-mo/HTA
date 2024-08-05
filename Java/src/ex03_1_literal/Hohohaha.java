package ex03_1_literal;

public class Hohohaha {
	/* escape character
	 * 문자열 안에서 특수 문자를 표현하거나 특수 기능을 수행하는 문자
	 * (1) tab      -  \t
	 * (2) new line -  \n
	 * (3) 역슬래시   -  \\
	 * (4) 큰따옴표   -  \"
	 */
	
	public static void main(String[] v) {
		System.out.println("호호하하");
		System.out.println("\"호호하하\"");
	/*	System.out.println("호호");
		System.out.println("하하");
		System.out.println("");   */
		System.out.println("호호\n하하\n");
		System.out.println("호호하하%n");
		//System.out.println("호호         하하");
		System.out.println("호호\t하하");
		System.out.println("호호\\하하");
	}
}
