package ex04_09_incr_dec;

public class IncrDec1 {

	public static void main(String[] v) {
		int num = 0;
		num = num + 1;
		System.out.println(num); //1
		
		num = num - 1; //1-1
		System.out.println(num); //0
		
		
		//증감 연산자
		
		num++; // num = num + 1;
		System.out.println(num); //1
		
		++num; // num = num + 1;
		System.out.println(num); //2
		
		num--; // num = num - 1;
		System.out.println(num); //1
		
		--num; // num = num - 1;
		System.out.println(num); //0
	}	
}
