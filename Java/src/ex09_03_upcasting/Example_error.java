package ex09_03_upcasting;

public class Example_error {

	public static void main(String args[]) {


		Account obj2 = new CheckingAccount("444-55-666666", "홍길동", 20000, "5555-6666-7777");
			
		try {
			int amount = obj2.pay("5555-6666-7777", 47000); //Account 에 pay 메서드 없음, 접근 불가
			System.out.println("인출액:" + amount);
			System.out.println("카드번호:" + obj2.cardNo); //Account 에 cardNo 필드 없음, 실행 불가
			/*Exception in thread "main" java.lang.Error: Unresolved compilation problems: 
				The method pay(String, int) is undefined for the type Account
				cardNo cannot be resolved or is not a field	 */	
			} catch (Exception e) {
			System.out.println(e.getMessage());
			}
	}
}