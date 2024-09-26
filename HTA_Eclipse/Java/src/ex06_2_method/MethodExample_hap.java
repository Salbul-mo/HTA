package ex06_2_method;

public class MethodExample_hap {

	public static void main(String args[]) {
		int i = 1;
		int j = 10;
		
		hap(i,j);  //아무것도 출력되지 않는다. return 된 sum값이 아무대도 대입되지 않았다.
	/*	int hap = hap(i,j);
		System.out.println(hap);
	*/
		return;
	}
	           	//반환형
	public static int hap(int start , int end) {
		int sum = 0;
		for (int i = start ; i <= end ; i++) {
			sum += i;
		}
		
		return sum; // 반환되는 자료형과 메서드의 반환형이 반드시 일치해야 한다.
	}
}
