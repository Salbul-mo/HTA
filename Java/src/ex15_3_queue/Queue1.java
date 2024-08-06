package ex15_3_queue;

/*
 * 큐(Queue) 인터페이스
 * -LinkedList(Queue 인터페이스를 구현한 클래스)를 사용
 * -FIFO (First In First Out) 구조
 *  먼저 입력된 자료가 먼저 출력되는 구조
 */
import java.util.LinkedList;
import java.util.Queue;

public class Queue1 {

	public static void main(String[] args) {
		// 큐로 사용할 LikedList객체 생성
		// LinkedList<String> queue = new LinkedList<String>();
		Queue<String> queue = new LinkedList<String>(); // 업캐스팅
		System.out.println("비었나?" + queue.isEmpty());

		// offer() 메서드 데이터 추가
		queue.offer("토끼");
		queue.offer("사슴");
		queue.offer("호랑이");

		// peek() 메서드 맨 처음 데이터를 그대로 둔 상태로 가져온다.
		System.out.println(queue.peek());
		System.out.println("비었나?" + queue.isEmpty());
		System.out.println("갯수 : " + queue.size());

		System.out.println("poll() 사용");
		while (!queue.isEmpty()) {
			// poll() 메서드는 큐에 있는 데이터를 제거하면서 가져온다. (pop처럼)
			String str = queue.poll();
			System.out.println(str);
			System.out.println("갯수 : " + queue.size());
		}
	}
}
