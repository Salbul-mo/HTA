package ex08_09_abstract_method;

public class InheritanceExample6 {

	public static void main(String args[] ) {
		EMailSender obj1 =new EMailSender("생일 축하합니다.","고객센터","admin@khshop.co.kr", "10% 할인쿠폰이 발행되었습니다.");
		obj1.sendMessage("hoho@naver.com");
		
		SMSSender obj2 = new SMSSender("생일 축하합니다.", "고객센터", "064-123-45675","10% 할인쿠폰이 발행되었습니다.");
		obj2.sendMessage("010-7777-7777");
	}
	//obj1.sendMessage 와 obj2.sendMessage 가 호출하는 메서드 이름이 같은 점에 주목하자.
}
