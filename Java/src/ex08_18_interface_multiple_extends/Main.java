package ex08_18_interface_multiple_extends;

public class Main {
	public static void main(String args[]) {
		Label obj = new Label("안녕하세요", 100, 30, "yellow", "green", "굴림체");
		printLabel(obj);
		obj.resize(200, 70);
		obj.setForeground("black");
		obj.setBackground("white");
		obj.setFont("궁서체");
		printLabel(obj);
	}

	public static void printLabel(Label obj) {
		System.out.printf("%s: %d x %d 배경색(%s) 전경색(%s) 폰트(%3s) \n"
		, obj.text, obj.width, obj.height, obj.background, obj.foreground, obj.font);
	}
}
