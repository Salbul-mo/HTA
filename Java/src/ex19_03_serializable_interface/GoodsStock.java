package ex19_03_serializable_interface;

//실행 순서 : ObjectOutputExample -> ObjectInputExample
class GoodsStock implements java.io.Serializable { /**
	 * 
	 */
	private static final long serialVersionUID = -6199412754960277552L;

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