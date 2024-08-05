package ex08_12_polymorphism;

public class InheritanceExample {

	public static void main(String args[]) {
		Account obj1 = new Account("111-22-333333", "임꺽정", 10000);
		printAccountInfo(obj1);

		CheckingAccount obj2 = new CheckingAccount("444-55-666666", "홍길동", 20000, "5555-6666-7777");
		printAccountInfo(obj2);

		CreditLineAccount obj3 = new CreditLineAccount("777-88-999999", "김선달", 30000, 20000000);
		printAccountInfo(obj3);

		BonusPointAccount obj4 = new BonusPointAccount("000-00-000000", "김미영", 0, 0);
		printAccountInfo(obj4);
		
		//다양한 클래스 타입의 객체를 하나의 클래스 타입으로 호출할 수 있다.
		//모두 Account 를 상속하기 때문에 조상 클래스로 자손 클래스의 인스턴스를 참조할 수 있다.
	}

	static void printAccountInfo(Account obj) {
		System.out.println("계좌번호: " + obj.accountNo);
		System.out.println("예금주 이름: " + obj.ownerName);
		System.out.println("잔액: " + obj.balance);
		System.out.println();
	}
}
