package ex07_11_account_Exception;

public class Numbers {

	private int[] num;
	
	Numbers(int[] num) {
		this.num = num;
	}
	
	int getTotal() {
		int sum = 0;
		for (int i = 0; i < num.length; i++) {
			sum += this.num[i];
		}
		return sum;
	}
	
	 int getAverage() {
		int sum = this.getTotal();
		int average = sum / (num.length);
		return average;
	}
}
