package ex13_2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class Callender_Ex2 {

	public static void main(String[] b) {
		Scanner sc = new Scanner(System.in);
		System.out.print("년도를 입력하세요.>");
		String yearIn = sc.nextLine();
		System.out.print("월을 입력하세요.>");
		String monthIn = sc.nextLine();
		if (monthIn.length() != 2) {
			monthIn = "0" + monthIn;
		}
		String str = yearIn + "-" + monthIn + "-01";
		LocalDate data = LocalDate.parse(str);
		DayOfWeek dayOfWeek = data.getDayOfWeek();
		int date = dayOfWeek.getValue();

		int year = data.getYear();
		int Month = data.getMonthValue();

		System.out.println("================== " + year + "년 " + Month + " 월 " + "===================");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		switch (date) {
		case 1 -> System.out.print("\t" + 1 + "\t");
		case 2 -> System.out.print("\t\t" + 1 + "\t");
		case 3 -> System.out.print("\t\t\t" + 1 + "\t");
		case 4 -> System.out.print("\t\t\t\t" + 1 + "\t");
		case 5 -> System.out.print("\t\t\t\t\t" + 1 + "\t");
		case 6 -> System.out.print("\t\t\t\t\t\t" + 1 + "\t");
		case 7 -> System.out.print(1 + "\t");
		}
		for (int i = 1; i < data.lengthOfMonth(); i++) {
			DayOfWeek dayOfWeek2 = (data.plusDays(i)).getDayOfWeek();
			int date2 = dayOfWeek2.getValue();
			System.out.print((data.plusDays(i).getDayOfMonth()) + "\t");
			if (date2 == 6) {
				System.out.println();
			}

		}
		sc.close();
	}

}
