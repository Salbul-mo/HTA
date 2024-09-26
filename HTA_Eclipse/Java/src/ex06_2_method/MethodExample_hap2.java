package ex06_2_method;

public class MethodExample_hap2 {

	public static void main(String args[]) {
		int i = 1;
		int j = 100;
		
		//hap(i,j);  //아무것도 출력되지 않는다. return 된 sum값이 아무대도 대입되지 않았다.
		int result = hap(i,j);
		System.out.println("1: result = " + result);
		
		//2번째 방법
		System.out.println("출력문 안에서 호출 : " + hap(i,j));
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
