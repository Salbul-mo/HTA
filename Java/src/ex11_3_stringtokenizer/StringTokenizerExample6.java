package ex11_3_stringtokenizer;

import java.util.StringTokenizer;

public class StringTokenizerExample6 {
	/*
	 * StringTokenizer : 010-1234-5678 토큰 분리
	 * 010
	 * 1234
	 * 5678
	 * String 의 split 메서드 이용 :  010-1234-5678
	 */
	public static void main(String[] args) {
		
		StringTokenizer stok = new StringTokenizer("010-1234-5678","-");
		
		while (stok.hasMoreTokens()) { //토큰이 있는 동안 반복해라
			String str = stok.nextToken();//문자열로부터 토큰 추출하여 대입
			System.out.println(str);
		
		
		}
		
		String[] st = "010-1234-5678".split("-");
		for (String s : st)
			System.out.println(s);
	}
}
