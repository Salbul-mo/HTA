package boj;

import java.util.*;
import java.util.stream.Stream;

public class Word_Count_1152 {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		String[] arr = input.trim().split(" ");
		
		Stream<String> stream = Stream.of(arr);
		
		stream = stream.filter(String -> !String.equals(""));
		
		long result = stream.count();
		
		
		System.out.println(result);
		
		
		
		sc.close();
		
		
	}
}
