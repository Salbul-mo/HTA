package ex15_7_generic1_4_wild;

public class Parent extends GrandParent{
	String name;
	
	 Parent() {
		
	}

	Parent(String name) {
		super(); // 슈퍼 클래스 생성자 호출. GrandParent의 디폴트 생성자 호출
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
