package ex08_18_interface_multiple_extends;

public interface Changeable extends Resizable, Colorable {

	void setFont(String font); // 폰트 변경한다.
}
