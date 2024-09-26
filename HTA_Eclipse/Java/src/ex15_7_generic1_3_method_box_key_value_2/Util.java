package ex15_7_generic1_3_method_box_key_value_2;
//멀티 타입 파라미터 제네릭 메서드
public class Util {
	//접근 제어자   정적 여부     <타입 파라미터>    반환타입      메서드 이름     매개 변수
	public       static         <K,V>          Box<K,V>      boxing       (K k, V v)  
	{
		Box<K,V> box = new Box<>();
		box.setKey(k);
		box.setValue(v);
	
		return box;
	}

}
