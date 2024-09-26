package ex08_18_interface_extends;

public class Rectangle implements Transformable {

	int x;
	int y;
	int width;
	int height;

	Rectangle(int x, int y, int width, int height) { //생성자
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	@Override
	public void moveTo(int x, int y) { //절대 위치로 이동 조상 인터페이스의 메서드
		this.x = x;
		this.y = y;
	}

	@Override
	public void moveBy(int xOffset, int yOffset) { //상대 위치 이동 조상 인터페이스의 메서드
		this.x += xOffset;
		this.y += yOffset;
	}

	@Override
	public void resize(int width, int height) { //크기 초기화
		this.width = width;
		this.height = height;

	}

}
