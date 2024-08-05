package ex08_09_abstract_method;

// 추상 클래스 - 추상 메서드를 포함하는 클래스 . 메시지 전송 클래스
public abstract class MessageSender { //클래스 자체도 추상 클래스로 선언
	
	String title;
	String senderName;
	
	MessageSender(String title , String senderName) {
		this.title = title;
		this.senderName = senderName;
	}
	
	//추상 메서드 선언
	abstract void sendMessage(String recipient);
	

}
