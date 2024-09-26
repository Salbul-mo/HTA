package ex15_2_stack;
/*	Stack 클래스
 * 1.LIFO(Last In First Out) 구조 - 마지막으로 입력된 자료가 가장 먼저 출력되는 구조
 * 
 * 2.여러가지 자료형의 Data 를 모두 저장할 수 있다.
 */

import java.util.Stack;

public class Stack3_Generics {

	public static void main(String[] args) {
		// Stack 객체 생성. java.util
		Stack<String> s = new Stack<String>();
		System.out.println("비었나요? " + s.empty());// true - 비어있음

		// Stack 에 값을 넣음 push(obj)
		s.push("좋아요");
		s.push("자바");

		System.out.println("비었나요? " + s.empty());// false - 비어있지 않음

		// Stack 에서 객체를 제거하지 않고 맨 위 데이터에 접근한다. peek()
		System.out.println("맨 마지막 데이터 : " + s.peek());

		// Stack 의 값을 출력 pop()
		while (!s.empty()) {
			System.out.println("데이터 출력 : " + s.pop()); // 스택의 맨 위에 있는 객체를 반환하고 제거
			System.out.println("남은 데이터 수 : " + s.size());

		}

		System.out.println("비었나요? " + s.empty());
	}
}
