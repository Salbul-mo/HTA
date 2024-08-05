package ex07_02_constructor;

public class GoodsStock { // 클래스의 선언을 시작하는 키워드 : class

	
	String goodsCode; // 상품 코드 참조형 기본값은 null
	int stockNum; // 재고 수량 int 기본값은 0
	/* 
	 * 1. 생성자 
	 * 		(1) 인스턴스가 생성될 때 호출되는 '인스턴스 초기화 메서드' 이다.
	 * 			따라서 인스턴스 변수의 초기화 작업에 주로 사용되며 인스턴스 생성시에
	 * 			실행되어야 할 작업을 위해서도 사용된다.
	 * 		(2) 생성자도 오버로딩이 가능하여 여러 개의 생성자가 존재할 수 있다.
	 * 
	 * 2. 생성자 조건
	 * 		(1) 생성자의 이름은 클래스의 이름과 같아야 한다.
	 * 		(2) 생성자는 리턴 타입이 없다.
	 * 
	 * 3. 기본 생성자(매개 변수가 없고 본체 내용이 없는 생성자) default 생성자
	 * 		(1) 클래스에는 반드시 하나 이상의 생성자가 정의되어 있어야 한다.
	 * 		(2) 생성자가 없는 경우 자동으로 추가되는 생성자이다.
	 * 		(3) 매개변수가 있는 생성자가 한개라도 작성된 경우에는 기본 생성자는 자동 추가되지 않는다.
	 */
	
	
	public GoodsStock (String goodsCode, int stockNum) { // 매개 변수를 이용한 필드값 변경
		this.goodsCode = goodsCode;
		this.stockNum = stockNum;
	}

	void addStock(int add) { // 재고를 더하는 기능에 해당하는 메서드
		stockNum += add; //this.stockNum 생략이라고 보면 된다. 필드에 대한 참조값을 this 키워드가 가지고 있다.
	}

	int subtractStock(int sub) { // 재고를 빼는 기능에 해당하는 메서드
		if (stockNum < sub) {
			return 0;
		} else {
			stockNum -= sub;
		}
		return sub;
	}
	
	void print() {
		System.out.println("상품코드 : " + goodsCode + "\n재고수량 : " + stockNum);
	}
}