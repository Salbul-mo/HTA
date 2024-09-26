package ex08_18_interface_extends;

public interface Movable {
	
	void moveTo(int x, int y);   //절대 위치로 이동

	void moveBy(int xOffset, int yOffset);  //상대 위치 만큼 이동
}
