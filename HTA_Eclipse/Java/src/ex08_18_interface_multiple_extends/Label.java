package ex08_18_interface_multiple_extends;

public class Label implements Changeable {

	String text;
	int width;
	int height;
	String foreground;
	String background;
	String font;

	Label(String text, int width, int height, String foreground, String background, String font) {
		this.text = text;
		this.width = width;
		this.height = height;
		this.foreground = foreground;
		this.background = background;
		this.font = font;

	}

	@Override
	public void resize(int width, int height) { // 기능) 두 개의 매개변수를 이용해 필드 초기화
		this.width = width;
		this.height = height;
	}

	@Override
	public void setForeground(String color) { // 기능) 매개변수를 이용해 필드(foreground) 초기화

		this.foreground = color;

	}

	@Override
	public void setBackground(String color) { // 기능) 매개변수를 이용해 필드(background)로 초기화

		this.background = color;
	}

	@Override
	public void setFont(String font) { // 기능) 매개변수를 이용해 필드 초기화
		this.font = font;
	}

}
