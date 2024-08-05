package ex07_11_account_Exception;

public class Numbers_Main {
	
	public static void main(String[] args) {
		
		//int[] arr = {10,20,30,40,50};

		Numbers num = new Numbers(new int[] {10,20,30,40,50});
		//int total = num.getTotal();
		//int average = num.getAverage();
		
		print(num);
	}
	
	public static void print(Numbers num) {
		System.out.println("합계 = " +num.getTotal() +"\n평균 = " + num.getAverage());
	}

}
