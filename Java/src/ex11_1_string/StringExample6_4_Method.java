package ex11_1_string;

public class StringExample6_4_Method {
	public static void main(String[] args) {
		String jumin = "123456-4123456";
		String jumin2 = "123456-3890123";
		String jumin3 = "123456-4890123";
		String jumin4 = "123456-7890123"; 
		String jumin5 = "123456-789012";
		System.out.println(getGender(jumin));
		System.out.println(getGender(jumin2));
		System.out.println(getGender(jumin3));
		System.out.println(getGender(jumin4));
		System.out.println(getGender(jumin5));
	}

	static boolean checkLength(String str) {
		int a = str.length();

		return a == 14;
		//return str.length() != 14 ? false : true;
	}

	static String getGender(String str) {
		String message = "";
		if (checkLength(str)) {
			char check = str.charAt(7);

			switch (check) {
			case '4', '2':				//case '2','4' -> "여자 입니다."
				message += "여자 입니다.";
				break;
			case '3', '1':				//case '1','3' -> "남자 입니다."
				message += "남자 입니다.";
				break;
			default:
				message += "외국인 입니다."; //default -> "외국인 입니다."
			}
		} else
			message += "주민등록번호는 14자리 입니다.";

		return message;
	}

}
/*향상된 switch 문
	String grade = switch (mok) {
									case 19, 20 -> "A+";
									case 18 -> "A0";
									case 17 -> "B+";
									case 16 -> "B0";
									case 15 -> "C+";
									case 14 -> "C0";
									case 13 -> "D+";
									case 12 -> "D0";
									default -> "F";
								}; 
*/
