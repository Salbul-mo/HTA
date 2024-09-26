package ex09_03_upcasting;

public class Example2_error {

	public static void main(String args[]) {


		Account obj2 = (Account) new CheckingAccount("444-55-666666", "홍길동", 20000, "5555-6666-7777");
		// 서브 클래스 참조타입을 슈퍼 클래스 참조타입으로 업 캐스팅 해서 인스턴스룰 생성한다.
			
		try {
			obj2.withdraw(1000); //Account에 있는 메서드는 당연히 사용가능하다. 
			System.out.println("계좌번호:" + obj2.accountNo);
			System.out.println("예금주 이름:" + obj2.ownerName);
			System.out.println("잔액:" + obj2.balance); //Account 에 cardNo 필드 없음, 실행 불가
			/*Exception in thread "main" java.lang.Error: Unresolved compilation problems: 
				The method pay(String, int) is undefined for the type Account
				cardNo cannot be resolved or is not a field	 */	
			} catch (Exception e) {
			System.out.println(e.getMessage());
			}
		
		try {
			int amount = ((CheckingAccount) obj2).pay("5555-6666-7777", 4700);//다운 캐스팅하면 매서드는 실행 가능
			System.out.println("인출액:" + amount);
			System.out.println("카드번호:" + (CheckingAccount)obj2.cardNo); //Account 에 cardNo 필드 없음, 실행 불가
			/*Exception in thread "main" java.lang.Error: Unresolved compilation problems: 
				The method pay(String, int) is undefined for the type Account
				cardNo cannot be resolved or is not a field	 */	
			} catch (Exception e) {
			System.out.println(e.getMessage());
			}
	}
}
/*Account에 있는 메서드는 사용
계좌번호:444-55-666666
예금주 이름:홍길동
잔액:19000
*/