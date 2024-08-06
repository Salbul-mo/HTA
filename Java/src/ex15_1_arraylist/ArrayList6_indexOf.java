package ex15_1_arraylist;

import java.util.ArrayList;
/*
 *  ArrayList 에 있는 데이터 검색하는 예
 *  - indexOf(data) : 인자와 같은 값을 갖는 첫 번째 데이터를 찾아서 그 위치의 인덱스를 리턴
 *  
 *  -lastIndexOf(data) : 인자와 같은 값을 마지막부터 순서대로 탐색해서 그 위치의 인덱스를 리턴
 *  
 *  공통적으로 못 찾으면 -1 리턴
 *  
 */

public class ArrayList6_indexOf {

	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<>();
		//앞에 선언할 때 타입을 선언했으면 뒤에 생성자에는 타입 생략 가능하다?
		//Constructs an empty list with an initial capacity of ten.
		//기본 10개의 배열을 생성한다.

		list.add("머루");
		list.add("사과");
		list.add("앵두");
		list.add("자두");
		list.add("사과");
		int index1 = list.indexOf("사과");
		int index2 = list.lastIndexOf("사과");
		System.out.println("첫번째 사과: " + index1);
		System.out.println("마지막 사과: " + index2);

	}

}
