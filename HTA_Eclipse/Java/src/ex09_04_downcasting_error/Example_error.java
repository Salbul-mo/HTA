package ex09_04_downcasting_error;

public class Example_error {

	public static void main(String args[]) {

		Account obj1 = new Account("444-55-666666", "홍길동", 2000000);

		CheckingAccount obj2 = (CheckingAccount) obj1; // 다운 캐스팅을 할때는 반드시 명시적으로 표시해야한다.
		//CheckingAccount obj2 = obj1; 컴파일 오류가 일어난다. 자바가 주는 경고.
		//Type mismatch: cannot convert from Account to CheckingAccount

		try {
			int amount = obj2.pay("5555-6666-7777", 47000);
			System.out.println("인출액:" + amount);
			System.out.println("카드번호:" + obj2.cardNo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	//런타임 에러 발생
	//Account cannot be cast to class CheckingAccount Account and CheckingAccount are in unnamed module of loader 'app')
	//at ex09_04_downcasting_error.copy.Example_error.main(Example_error.java:9)
}
