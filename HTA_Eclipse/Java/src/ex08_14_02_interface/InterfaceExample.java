package ex08_14_02_interface;

public class InterfaceExample {

	public static void main(String[] args) {

		SeparateVolume obj1 = new SeparateVolume("863ㅂ774개", "개미", "베르베르");

		obj1.checkOut("홍길동", "2024-07-31");
		obj1.checkIn();

		AppCDInfo obj2 = new AppCDInfo("111r555뱌", "베토벤 운명");

		obj2.checkOut("홍길동", "2024-07-31");
		obj2.checkIn();
	}
}
