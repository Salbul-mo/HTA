package ex15_1_linkedList;
/*
 * LinkedList 사용 예
 * LinkedList 와  ArrayList의 차이점
 * 		-데이터의 추가 또는 삭제시 ArrayList 보다 속도가 빠르다
 *		-하지만 중간에 데이터를 추가하려면 빈자리를 만들기 위해 다른 데이터를 복사해서 이동해야 하고,
 *		-삭제인 경우에는 데이터를 재배치해야 하지만
 *		-LinkedList의 경우에는 각 요소간 연결만 변경해주면 되기 때문에 처리 속도가 훨씬 빠르다.
 *
 *		- 검색에 ArrayList는 연속적인 메모리상에 존재하기 때문에 탐색이 빠르지만
 *		  불연속적으로 존재하는 LinkedList는 처음부터 차례대로 따라가야
 *		  원하는 값을 얻을 수 있어 검색시간이 느리다.		
 */

import java.util.LinkedList;

public class LinkedList1_add {
	
	public static void main(String[] args) {
		//LinkedList 객체를 생성
		LinkedList<String> list = new LinkedList<String>();
		list.add("포도");
		list.add("딸기");
		list.add("복숭아");
		
		int num = list.size();
		for (int cnt = 0; cnt < num ;cnt++) {
			String str = list.get(cnt);
			System.out.println(str);
		}
	}

}
