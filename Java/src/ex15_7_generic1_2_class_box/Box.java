package ex15_7_generic1_2_class_box;
/*
 * 멀티 타입 파라미터
 * class 뒤에 <K, V> 를 추가한다.
 * Object => K, V 로 변경
 */

public class Box<K, V> { // 지네릭 클래스 선언

	private K key;
	private V value;

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Box [Key=" + key + ", value=" + value + "]";
	}
}
