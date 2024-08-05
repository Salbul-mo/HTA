package ex07_02_constructor;

public class GoodsStockMain {

	public static void main(String[] args) {

		
		//GoodsStock goodsStock = new GoodsStock(); 오류. undefined constr
		
		GoodsStock goodsStock = new GoodsStock("53135", 200);
		//매개 변수를 통해 필드 초기화하는 생성자 사용
		goodsStock.print();

		goodsStock.addStock(1000);
		System.out.println("=====addStock(1000) 후=====");
		goodsStock.print();

		goodsStock.subtractStock(500);
		System.out.println("=====subractStock(500) 후=====");
		goodsStock.print();

	}

}
