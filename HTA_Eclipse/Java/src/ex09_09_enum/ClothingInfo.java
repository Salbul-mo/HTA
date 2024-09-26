package ex09_09_enum;
//사계절을 표현하는 코드 값을 상수로 선언해서 사용하는 예
//의류 정보 클래스
class ClothingInfo {
	String code;
	String name;
	String material;
	Season season;
	


	ClothingInfo(String code, String name, String material, Season season) {
		this.code = code;
		this.name = name;
		this.material = material;
		this.season = season;
	}

}
