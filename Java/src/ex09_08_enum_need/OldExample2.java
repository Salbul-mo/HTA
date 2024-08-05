	package ex09_08_enum_need;
	
	public class OldExample2 {
		public static void main(String[] args) {
			//ClothingInfo.SUMMER : ClothingInfo 클래스에 선언된 상수 필드를 사용
			ClothingInfo obj = new ClothingInfo("32919", "반팔 티셔츠", "면100%", 5);
			System.out.println("상품코드: " + obj.code);
			System.out.println("상품명: " + obj.name);
			System.out.println("소재: " + obj.material);
			System.out.println("계절구분: " + obj.season);
		}
	
	}
