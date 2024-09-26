package ex13_7_object_equals_overriding;

public class Rectangle {

	int width, height;
	Rectangle (int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public String toString() {
		return "가로는 " + width + ", 세로는 " + height;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Rectangle) {
			return (this.width == ((Rectangle) obj).width 
					&& 
					this.height == ((Rectangle) obj).height);
		}
		else
			return false;
	}
}
