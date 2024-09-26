package ex15_1_vector;

import java.util.Vector;

/*
 * Vector 클래스 - ArrayList 의 구버전
 * 				  ArrayList 와 거의 비슷, 둘 중에서 ArrayList를 더 많이 사용한다.
 * 무조건 동기화를 하기 때문에 단일 스레드 처리에서는 ArrayList나 LinkedList보다 성능이 떨어진다.
 * 동기화란 공유데이터 사용 중에 그 공유 데이터를 
 * 다른 스레드(실행 중인 프로그램을 프로세스라고 하며 프로세스를 구성하는 세부 작업 단위)가 
 * 사용하지 못하도록 막는 것을 의미한다.
 */
public class Vector1 {

	public static void main(String[] args) {
		Vector<String> vec = new Vector<String>(); //String형만 올 수 있다.
		vec.add("Apple");
		vec.add("Banana");
		vec.add("oRANGE");
		
		for(String result : vec) {
			System.out.println(result + "=> " + result.toUpperCase());
		}

	}

}
