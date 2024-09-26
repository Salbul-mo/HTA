package ex15_7_generic1_3_method_box_1;

public class Box_Util_Main {

	public static void main(String[] args) {
		Box<Character> box1 = Util.boxing('a');
		char test = box1.get();
		System.out.println(test);
		Box<Integer> box2 = Util.boxing(100);
		int intValue = box2.get();
		System.out.println(intValue);
		Box<String> box3 = Util.boxing("홍길동");
		String name = box3.get();
		System.out.println(name);

	}

}
