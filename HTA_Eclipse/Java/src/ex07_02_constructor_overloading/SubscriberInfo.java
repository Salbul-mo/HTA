package ex07_02_constructor_overloading;

public class SubscriberInfo {
	
	String name;
	String id;
	String password;
	String phoneNo;
	String address;
	
	SubscriberInfo (String name, String id, String password) {
		this.name = name;
		this.id = id;
		this.password = password;
	}
	
	SubscriberInfo (String name, String id, String password, String phoneNo, String address) {
		this.name = name;
		this.id = id;
		this.password = password;
		this.phoneNo = phoneNo;
		this.address = address;
	}
	
	/*
	 * SubscriberInfo (String name, String id, String password, String phoneNo, String address) {
	 * this.SubscriberINfo(String name, String id, String password);
	 * this.phoneNo = phoneNo;
	 * this.address = address;
	 * }
	 */
	
	void changePassword (String password) {
		this.password = password;
	}
	
	void setPhoneNo (String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	void setAddress(String address) {
		this.address = address;
	}
	
}
