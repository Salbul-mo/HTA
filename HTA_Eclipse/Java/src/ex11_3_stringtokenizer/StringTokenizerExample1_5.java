package ex11_3_stringtokenizer;

import java.util.StringTokenizer;

public class StringTokenizerExample1_5 {
	public static void main(String args[]) {
		
		//true : 구분자도 토큰으로 추출하도록 만드는 키워드
		StringTokenizer stok2 = new StringTokenizer("사과=10|초콜렛=3|샴페인=1","=|",true);
		while (stok2.hasMoreTokens()) { //토큰이 있는 동안 반복해라
			String str = stok2.nextToken();//문자열로부터 토큰 추출하여 대입
			System.out.println(str);
		}
		
	}

}
