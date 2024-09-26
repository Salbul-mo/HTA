package ex07_02_constructor_call;

public class SubscriberInfo {

	String name;
	String id;
	String password;
	String phoneNo;
	String address;

	SubscriberInfo(String name, String id, String password) {
		this.name = name;
		this.id = id;
		this.password = password;
	}

	SubscriberInfo(String name, String id, String password, String phoneNo, String address) {
		this(name, id, password);
		// this() : 같은 클래스에서 다른 생성자를 호출할 때 사용한다.
		// 반드시 생성자 첫째 줄에서 사용해야 한다. 안그러면 오류
		// Constructor call must be the first statement in a constructor
		// String 타입의 파라미터 3개를 갖는 생성자를 호출한다.
		this.phoneNo = phoneNo;
		this.address = address;
	}

	void changePassword(String password) {
		this.password = password;
	}

	void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	void setAddress(String address) {
		this.address = address;
	}

}
