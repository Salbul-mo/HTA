package ex13_2;

class GoodsStock2 { 

	
	String goodsCode; 
	int stockNum; 

	
	
	GoodsStock2 (String goodsCode, int stockNum) { 
		this.goodsCode = goodsCode;
		this.stockNum = stockNum;
	}

	
	@Override
	public String toString() {
		String str = "상품코드:" + goodsCode +" 재고수량:" + stockNum;
		return str;
	}
	
	
	
	void addStock(int add) { 
		stockNum += add; 
	}

	int subtractStock(int sub) { 
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