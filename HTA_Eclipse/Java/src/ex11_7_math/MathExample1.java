package ex11_7_math;

public class MathExample1 {
	public static void main(String args[]) {

		System.out.println("12.45 반올림=>" + Math.round(12.45)); // 12 소수점 첫째자리 반올림
		System.out.println("124.5 반올림=>" + Math.round(124.5)); // 125 소수점 첫째자리 반올림
		// Math.round(Double)가장 가까운 double을 반환한다.
		System.out.println("12.45 반올림=>" + Math.round(124.5) * 0.1);
		// 12.45 10 곱해서 Math.rount하고 0.1 곱하면 소수점 둘째자리에서 반올림한것처럼 된다.
		// 10의 n승 곱해서 돌리고 10의 n승으로 나누면 n+1 자리에서 반올림한 형태가 된다.
	}

}
