package ex17_21_stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exam4Origin {

	public static void main(String[] args) {

		List<String> myList = Arrays.asList("CLERK", "SALESMAN", "MANAGER", "ANALYST", "PRESIDENT", "ANALYST");

		// 1. job 에 대한 인원 수 구하기 - 리스트의 크기
		long size = myList.stream().count();
		System.out.println(size + "명");

		// 2. job의 종류를 중복 제거하고 출력
		List<String> job_list = myList.stream().distinct().collect(Collectors.toList());
		System.out.println(job_list);

		// 2-2. toList() 16버전부터 사용가능하다.
		List<String> job_listex = myList.stream().distinct().toList();
		/*
		 * List<String> java.util.stream.Stream.toList()
		 * 
		 * 
		 * Accumulates the elements of this stream into a List. 
		 * The elements in the list will be in this stream's encounter order, if one exists. 
		 * The returned List is unmodifiable; 
		 * calls to any mutator method will always cause UnsupportedOperationException to be thrown. 
		 * There are no guarantees on the implementation type or serializability of the returned List.
		 * 
		 * The returned instance may be value-based.
		 * Callers should make no assumptions about the identity of the returned instances.
		 * Identity-sensitive operations on these instances 
		 * (reference equality (==),identity hash code, and synchronization)
		 * are unreliable and should be avoided.
		 * 
		 * This is a terminal operation. 
		 * Returns: a List containing the stream elements
		 * Since:16
		 */
		System.out.println(job_listex);
		job_list.add("king"); // 오류 발생. Stream 을 toList() 로 만든 List 는 변경이 불가능 하다.

		// 3. job의 종류를 중복 제거 후 오름차순 정렬 출력
		List<String> job_list2 = myList.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(job_list2);

		// 4. job의 갯수 구하기
		long job_size = myList.stream().distinct().count();
		System.out.println(job_size);
	}
}
