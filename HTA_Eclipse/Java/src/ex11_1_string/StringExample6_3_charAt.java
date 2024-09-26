package ex11_1_string;

public class StringExample6_3_charAt {
	public static void main(String[] args) {
		String jumin = "123456-4123456";
		char check = jumin.charAt(7);
	
		
		String message = "추출한 숫자는 " + check + "이고 ";
		if (check == '4' || check == '2')
			message += "이고 여자입니다.";
		else if (check == '3' || check == '1')
			message += "이고 남자입니다.";
		else
			message += "외국인 입니다.";
		
		System.out.println(message);
		
		//작은 따옴표가 없으면 char 형과 정수형을 비교하기 위해 아스키코드에 따라 변경하여 비교한다. 
		//check.equals('4');
		//Cannot invoke equals(char) on the primitive type char
	}
} 
