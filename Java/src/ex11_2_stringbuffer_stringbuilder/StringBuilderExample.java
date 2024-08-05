package ex11_2_stringbuffer_stringbuilder;
/*StringBuilder는 StringBuffer에서 멀티쓰레드의 동기화만 뺀 기능이다.
 */
public class StringBuilderExample {
	
	public static void main(String args[]) {
		StringBuilder sb = new StringBuilder("동해물과 백두산이 마르고  ");
		//기존 문자열에 추가함
		System.out.println(sb.append("닳도록 보우하사 "));
		
		//index가 19인 곳에 "하느님이 하느님이 "를 중간에 삽입
		System.out.println(sb.insert(19,"하느님이 하느님이 "));
		
		//index가 24부터 27까지 문자열 삭제 마찬가지로 EndIndex -1 까지만 삭제된다.
		System.out.println(sb.delete(24, 28));
		
		//index가 9인 곳의 문자 하나 삭제
		System.out.println(sb.deleteCharAt(9));
		
		System.out.println(sb.toString());
	}
}
