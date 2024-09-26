package ex07_17_static_init;

public class HundredNumbers3 {

	static int arr[];
	String a;
	HundredNumbers3() {
		//System.out.println("여기는 생성자 입니다.");
	}
	
	HundredNumbers3(String a) {
		//System.out.println("여기는 생성자 입니다.");
		this.a = a;
	}
	
	
	//인스턴스 초기화 블럭 :
	{
		System.out.println("여기는 생성자 입니다.");
	}

}
