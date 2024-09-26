package ex08_01_inheritance;

//은행 계좌 클래스를 상속 받는 직불 계좌 클래스
//은행 계좌 클래스(Account)			- 슈퍼 클래스
//직불 계좌 클래스(CheckingAccount)	- 서브 클래스
public class CheckingAccount extends Account {
	String cardNo; // 직불 카드 번호


	
	int pay(String cardNo, int amount) throws Exception { 
		 	if(!cardNo.equals(this.cardNo) || (balance < amount) ) { 
		  		throw new Exception("지불이 불가능합니다."); 
		 	}
		   return withdraw(amount); 
		  }
		 
		/*public int pay(String cardNo, int amount) throws Exception {
			if (!cardNo.equals(this.cardNo)) {
			throw new Exception("카드 번호가 다릅니다.");
			}
			return super.withdraw(amount);
		*/
	}


/*
 * 1) pay : 직불 카드 사용액을 지불합니다. 
 * 매개변수 : 카드 번호(cardNo-문자열), 인출액(amount-정수형) 
 * 반환형 :int 
 * 반환되는 값 : 부모 클래스의 인출메서드 호출 
 * 기능 : 만약 카드넘버가 일치하지 않거나 잔액이 인출액보다 작으면 "지불이 불가능합니다."라는 예외를 발생시킵니다. 
 * 발생된 예외는 호출한 메서드가 처리하도록 합니다. 
 * 
 * int pay(String cardNo, int amount) throws Exception { 
 * 	if(!cardNo.equals(this.cardNo) || (balance < amount) ) { 
 * 		throw new Exception("지불이 불가능합니다."); 
 * 	}
 *  return withdraw(amount); 
 *  }
 */
