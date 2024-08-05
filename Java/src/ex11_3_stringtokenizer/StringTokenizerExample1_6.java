package ex11_3_stringtokenizer;

import java.util.StringTokenizer;

public class StringTokenizerExample1_6 {
	public static void main(String args[]) {

		// true : 구분자도 토큰으로 추출하도록 만드는 키워드
		StringTokenizer stok2 = new StringTokenizer("사과=10|초콜렛=3|샴페인=1", "=|", true);

		System.out.println("상품이름\t상품 수");
		do {
			String str = stok2.nextToken();// 문자열로부터 토큰 추출하여 대입
			if (str.equals("=")) {
				continue;
			} else if (str.equals("|")) {
				System.out.println();
				continue;
			}
			System.out.print(str + "\t");
		} while (stok2.hasMoreTokens()); // 토큰이 있는 동안 반복해라
	}

}
//특정 문자를 기준으로 편집하는 코딩도 가능하다.
/*
 * while( stok2.hasMoreTokens()) {
 * 	String str = stok2.nextToken();
 * if(str.equals("=")) {
 * System.out.print("\t");
 * } else if (str.equals("|")) {
 * 		System.out.println();
 * } else {
 * System.out.print(str);
 * 

 */
