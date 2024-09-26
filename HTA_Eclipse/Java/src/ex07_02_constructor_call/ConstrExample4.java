package ex07_02_constructor_call;

public class ConstrExample4 {

	public static void main(String[] a) {
		SubscriberInfo obj
		= new SubscriberInfo ("제임스 고슬링", "java","java", "010-111-2222","나를 찾지 마세요~");
		
		printSubscriberInfo(obj);
		
		//주소 변경
		obj.setAddress("서울시 강남구 역삼동");
		printSubscriberInfo(obj);
			
	}

	private static void printSubscriberInfo(SubscriberInfo obj) {
		// TODO Auto-generated method stub
		System.out.println("이름 : " + obj.name);
		System.out.println("아이디 : " + obj.id);
		System.out.println("패스워드 : " + obj.password);
		System.out.println("전화번호 : " + obj.phoneNo);
		System.out.println("주소 : " + obj.address);
		System.out.println();
	}
	
}
