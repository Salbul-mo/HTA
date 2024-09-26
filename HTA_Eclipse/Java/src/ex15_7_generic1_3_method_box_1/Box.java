package ex15_7_generic1_3_method_box_1;

public class Box<T> {

	private T object;

	public void set(T object) {
		this.object = object;
	}

	public T get() {
		return object;
	}
}
