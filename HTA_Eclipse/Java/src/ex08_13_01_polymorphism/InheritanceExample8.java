package ex08_13_01_polymorphism;

public class InheritanceExample8 {

	public static void main(String args[] ) {
		EMailSender obj1 =new EMailSender("생일 축하합니다.","고객센터","admin@dukeshop.co.kr", "10% 할인쿠폰이 발행되었습니다.");
		
		SMSSender obj2 = new SMSSender("생일 축하합니다.", "고객센터", "064-123-45675","10% 할인쿠폰이 발행되었습니다.");
		
		send(obj1,"hoho@naver.com");
		send(obj1,"stickman@hahaha.com");
		send(obj2,"010-7777-7777");
	}
	
	//컴파일 후 슈퍼 클래스의 바디가 없는 추상메서드에 접근한 후
	//상속한 서브 클래스의 인스턴스로 가서 오버라이딩된 메서드로 다시 찾아가서 실행한다.
	static void send(MessageSender obj, String recipient) {
		obj.sendMessage(recipient);
	}
}
