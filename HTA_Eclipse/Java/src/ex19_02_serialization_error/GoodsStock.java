package ex19_02_serialization_error;
/*
 * 직렬화 가능 클래스를 만드는 예
 * implements java.io.Serializable 없는 클래스는 직렬화 할 수 없다.
 * 실행 순서 : ObjectOutputExample.java -> ObjectInputExample.java
 */

class GoodsStock { //재고 정보 클래스

	private String code;
	private int num;

	GoodsStock(String code, int num) {
		this.code = code;
		this.num = num;
	}

	@Override
	public String toString() {
		String str = "상품코드:" + code + " \t상품수량:" + num;
		return str;
	}

	void addStock(int add) {
		num += add;
	}

	int subtractStock(int sub) throws Exception {
		if (num < sub) {
			throw new Exception("재고가 부족합니다.");
		} else {
			num -= sub;
		}
		return sub;
	}

	void print() {
		System.out.println("상품코드 : " + code + "\t상품수량 : " + num);
	}

}