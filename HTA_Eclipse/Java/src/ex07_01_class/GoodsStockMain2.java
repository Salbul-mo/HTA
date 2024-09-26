package ex07_01_class;

public class GoodsStockMain2 {

	public static void main(String[] args) {

		GoodsStock goodsStock = new GoodsStock();
		goodsStock.goodsCode = "52135";
		goodsStock.stockNum = 200;

		goodsStock.print();

		goodsStock.addStock(1000);
		System.out.println("=====addStock(1000) 후=====");
		goodsStock.print();

		goodsStock.subtractStock(500);
		System.out.println("=====subractStock(500) 후=====");
		goodsStock.print();

	}

}
