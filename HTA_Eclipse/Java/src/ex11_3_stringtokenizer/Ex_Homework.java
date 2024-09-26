package ex11_3_stringtokenizer;

import java.util.Scanner;

public class Ex_Homework {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("주민번호 입력(exit=e)");
			String jumin = sc.next();
			if (jumin.equals("e")) {
				System.out.println("종료합니다.");
				break;
			}
			printCheck(jumin);
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
	static boolean inNumber(String str) {

		if (str == null) {
			return false;
		}

		for (int i = 0; i < 6; i++) {
			if (str.charAt(i) == ' ') {
				return false;
			} else {
				switch (str.charAt(i)) {
				case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9':
					continue;
				default:
					return false;
				}
			}

		}

		return true;
	}

	static String getGender(String str) {
		char check = str.charAt(7);
		String message = "";
		if (check == '4' || check == '2')
			message += "여자";
		else if (check == '3' || check == '1')
			message += "남자";
		else
			message += "외국인";

		return message;
	}

	static void printCheck(String str) {
		if (!checkLength(str)) {
			System.out.println("주민번호 길이는 14개 입니다.");
		} else if (!checkHyphen(str)) {
			System.out.println("주민번호 형식에 맞지 않습니다. (-위치)");
		} else if (!inNumber(str.substring(0, 6))) {
			System.out.println("앞자리에 숫자를 입력하세요.");
		} else if (!inNumber(str.substring(7))) {
			System.out.println("뒷자리에 숫자를 입력하세요.");
		} else {
			System.out.println(getGender(str));
		}
	}
}
