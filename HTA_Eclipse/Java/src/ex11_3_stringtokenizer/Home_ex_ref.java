package ex11_3_stringtokenizer;

import java.util.Scanner;

public class Home_ex_ref {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("주민번호 입력(exit=e)");
			String jumin = sc.nextLine(); //String jumin = sc.nextLine().trim(); 도 가능하다.
			//jumin.trim(); 으로 공백 제거하여 유효성 체크하는게 정석이다.
			if (jumin.equals("e")) {
				System.out.println("종료합니다.");
				break;
			}
			try {
				printCheck(jumin);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
		sc.close();
	}

	static boolean checkLength(String str) {
		int a = str.length();
		return a == 14;
	}

	static boolean checkHyphen(String str) {
		char ch = str.charAt(6);
		return ch == '-';
	}

	// null 또는 공백 또는 숫자가 아니면
	static boolean isNumber(String str) {

		if (str == null || str.equals("")) {
			return false;
		}

		for (int i = 0; i < str.length(); i++) {
			/*
			 * char ch = str.charAt(i);
			 * if(ch < '0' || ch > '9') {
			 * 		return false;
			 * }
			 */ 
			
			switch (str.charAt(i)) {
			case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9':
				continue;
			case ' ':
				return false;
			default:
				return false;
			}
		}

		return true;
	}

	static String getGender(char check) {
		
		String message = "";
		if (check == '4' || check == '2')
			message += "여자";
		else if (check == '3' || check == '1')
			message += "남자";
		else
			message += "외국인";

		return message;
	}

	static void printCheck(String str) throws Exception {
		if (!checkLength(str)) {
			throw new Exception("주민번호 길이는 14개 입니다.");
		} else if (!checkHyphen(str)) {
			throw new Exception("주민번호 형식에 맞지 않습니다. (-위치)");
		} else if (!isNumber(str.substring(0, 6))) {
			throw new Exception("앞자리에 숫자를 입력하세요.");
		} else if (!isNumber(str.substring(7))) {
			throw new Exception("뒷자리에 숫자를 입력하세요.");
		} else {
			System.out.println(getGender(str.charAt(7)));

		}

	}

}