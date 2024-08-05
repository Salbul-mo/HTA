package ex08_09_abstract_method;

public class SMSSender extends MessageSender {

	String returnPhoneNo;
	String message;

	SMSSender(String title, String senderName, String returnPhoneNo, String message) {
		super(title, senderName);
		this.returnPhoneNo = returnPhoneNo;
		this.message = message;
	}

	// The type SMSSender must implement
	// the inherited abstract method MessageSender.sendMessage(String)
	// 상속한 추상 클래스의 추상 메서드 MessageSender.sendMessage(String)을 반드시 구현해야 한다.
	@Override //<--- 어노테이션 부모 클래스의 메서드를 오버라이드하고 있음을 명시적으로 나타내는 어노테이션이다.
			  //Java 에서 어노테이션(Annotation)은 코드에 메타데이터를 추가하는 데 사용되는 특수한 형태의 구문이다.
			  //어노테이션은 주로 컴파일러에게 추가 정보를 제공하거나 런타임에 특정 행동을 하도록 할 때 사용된다.  
	void sendMessage(String recipient) {   //추상 메서드의 구현은 빈 삼각형으로 표현된다.   
		System.out.println("------------------------------");
		System.out.println("제목: " + title);
		System.out.println("보내는 사람: " + senderName);
		System.out.println("전화번호: " + recipient);
		System.out.println("회신 전화번호: " + returnPhoneNo);
		System.out.println("메시지 내용: " + message);
	}

}
