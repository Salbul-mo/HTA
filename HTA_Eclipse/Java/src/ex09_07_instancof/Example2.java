package ex09_07_instancof;

public class Example2 {

	public static void main(String args[]) {
		Account obj = new CheckingAccount("444-55-666666", "홍길동", 2000000, "5555-6666-7777");
		// obj 를 CheckingAccount로 캐스트 가능한지 여부 확인((CheckingAccount) obj)

		if (obj instanceof CheckingAccount) {
			// obj를 CheckingAccount로 캐스트할 수 있을 때만 pay메서드 호출
			pay((CheckingAccount) obj);
		} else {
			// obj를 CheckingAccount로 캐스트할 수 없을 경우
			System.out.println("캐스트할 수 없는 타입입니다.");
		}

	}

	private static void pay(CheckingAccount obj) {
		try {
			int amount = obj.pay("5555-6666-7777", 47000);
			System.out.println("인출액:" + amount);
			System.out.println("카드번호:" + obj.cardNo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
} 
//캐스트 성공 및 메서드 정상 작동