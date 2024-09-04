package ex21_2_select_statement_method_list_2_try_with_resources;

public class GoodsInfo {

	private String code;
	private String name;
	private int price;
	private String maker;

	@Override
	public String toString() {
		return String.format("%s\t%-12s\t%-8d%s", code, name, price, maker);

	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

}
