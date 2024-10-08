package ex11_2_stringbuffer_stringbuilder;
/*
 * StringBuffer 는 멀티쓰레드에 안전하도록 동기화 되어 있다.
 * 동기화란 공유 데이터 사용중에 그 공유 데이터를 다른 스레드가
 * (실행 중인 프로그램을 프로세스라고 하며 프로세스를 구성하는 세부 작업 단위)
 * 사용하지 못하도록 만드는 것을 의미한다.
 * 
 * 멀티 쓰레드로 작성된 프로그램이 아닌 경우 StringBuffer 의 동기화는 불필요하게 성능만 떨어뜨리게 되어
 * StringBuffer에서 쓰레드의 동기화만 뺀 StringBuilder 가 추가되었다.
 * StringBuilder 는 StringBuffer와 똑같은 기능으로 작성되어 있다.
 * 
 * 문자열 값을 수정할 수 있는 mutable(가변) 이다.
 */
public class StringBufferExample1 {
	
	public static void main(String args[]) {
		StringBuffer sb = new StringBuffer("동해물과 백두산이 마르고  ");
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
