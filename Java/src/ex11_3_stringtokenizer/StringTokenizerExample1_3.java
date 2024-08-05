package ex11_3_stringtokenizer;

import java.util.StringTokenizer;

public class StringTokenizerExample1_3 {
	public static void main(String args[]) {
		
		//","를 기준으로 토큰 나눔
		StringTokenizer stok2 = new StringTokenizer("사과,배,복숭아",",");
		while (stok2.hasMoreTokens()) { //토큰이 있는 동안 반복해라
			String str = stok2.nextToken();//문자열로부터 토큰 추출하여 대입
			System.out.println(str);
		}
		
	}

}
           