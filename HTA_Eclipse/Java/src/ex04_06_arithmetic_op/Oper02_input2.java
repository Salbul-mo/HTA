package ex04_06_arithmetic_op;

import java.io.InputStream;
import java.util.Scanner;

// 커서 올려두고  ctrl + shift + o 누르면 자동으로 import 구문이 선언된다.
public class Oper02_input2 {

	public static void main(String[] v) {
		//값을 입력받는 Scanner 클래스를 사용해보자
		//Scanner 클래스는 java.util 패키지에 있다.
		//nextInt() : 키보드로 부터 입력받은 값을 정수형으로 변환하여 리턴해준다.
		
		//System.in 은 키보드로 데이터를 입력 받을때 사용한다.
		//InputStream java.lang.System.in
		InputStream is = System.in;
		//System.in 은 InputStream 의 형태이다.
		//java.util.Scanner.Scanner(InputStream source)
	//   클래스명   참조형 변수      연산자       생성자호출
  		Scanner      sc    =    new      Scanner(is);
		
		System.out.print("두 정수를 입력하세요>");
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		
		sc.close();
		// input 을 이용하면 키보드로 입력하기 전까지는 입력 대기상태로 멈춘다.
		// 방치하면 메모리 누수로 오류가 일어난다.
		
		System.out.println(a + "\t+\t" + b +" = " +(a+b));
		System.out.println(a + "\t-\t" + b +" = " +(a-b));
		System.out.println(a + "\t*\t" + b +" = " +(a*b));
		System.out.println(a + "\t/\t" + b +" = " +(a/b));
		System.out.println(a + "\t%\t" + b +" = " +(a%b));
		
	}
}
