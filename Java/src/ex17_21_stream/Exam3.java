package ex17_21_stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exam3 {

	public static void main(String args[]) {
		
		List<String> myList = Arrays.asList("test2.java","test.java", "test2.java", "test.txt", "test.txt", "hta");
		List<String> list = myList.stream().filter(str -> str.indexOf(".") != -1)
												.map(String::toUpperCase)
													.sorted()
														.collect(Collectors.toList());
		System.out.println(list);
		System.out.println(list.size());
		
		List<String> list2 = myList.stream().filter( str -> str.indexOf(".") != -1)
												.map(String::toLowerCase)
													.distinct().sorted()
														.collect(Collectors.toList());
		System.out.println(list2);
		System.out.println(list2.size());
		
		
		
	}
}
