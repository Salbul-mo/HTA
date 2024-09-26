package ex05_1_if;

public class IfExample3_1 {

	public static void main(String args[]) {
		
		int num1 = 52;
		int num2 = 24;
		int num3 = 32;
		/*
		if (num1 > num2) 
			if (num1 > num3)
				System.out.println("num1이 제일 큽니다.");
		*/
		
		if (num1 > num2 && num1 > num3) {
			System.out.println("num1 이 제일 큽니다.");
			}
	}
	
}
