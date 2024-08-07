package ex15_7_generic1_3_method_box_key_value_2;

public class Box<K, V> {

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
