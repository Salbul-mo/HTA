package ex15_7_generic1_3_method_box_key_value_2;

public class Box_Util_Main {

	public static void main(String[] args) {
		Box<Integer,String> box1 = Util.boxing(1,"홍길동");
		// Util의 static 메서드이므로 new 로 객체 생성할 필요없다.
		System.out.println(box1);
		
	}

}

