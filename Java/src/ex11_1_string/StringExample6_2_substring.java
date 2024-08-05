package ex11_1_string;

public class StringExample6_2_substring {
	public static void main(String[] args) {
		String jumin = "123456-4123456";
		String check = jumin.substring(7, 8);
		if (check.equals("4") || check.equals("2"))
			System.out.println("추출한 숫자는 " + check + "이고 여자입니다.");
		else if (check.equals("3") || check.equals("1"))
			System.out.println("추출한 숫자는 " + check + "이고 남자입니다.");
		else 
			System.out.println("외국인 입니다.");
	}
	/*
		String message = "추출한 숫자는 " + check + "이고 ";
		if (check.equals("4") || check.equals("2"))
			message += "이고 여자입니다.";
		else if (check.equals("3") || check.equals("1"))
			message += "이고 남자입니다.";
		else
			message += "외국인 입니다.";
	*/

}
