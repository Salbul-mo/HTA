package ex07_02_constructor_call;

public class SubscriberInfoMain {

	public static void main(String[] a) {

		SubscriberInfo obj1 = new SubscriberInfo("연흥부", "poorman", "zebi");
		print(obj1);

		obj1.setPhoneNo("010-7777-7777");
		obj1.setAddress("서울시 종로구");
		print(obj1);

		SubscriberInfo obj2 = new SubscriberInfo("연놀부", "richman", "money", "02-123-4567", "강남");
		print(obj2);

	}

	public static void print(SubscriberInfo obj) {
		System.out.println("이름 : " + obj.name);
		System.out.println("아이디 : " + obj.id);
		System.out.println("패스워드 : " + obj.password);
		System.out.println("전화번호 : " + obj.phoneNo);
		System.out.println("주소 : " + obj.address);
		System.out.println();
	}
}