package personal;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class Ramda {

	public static void main(String args[]) {
		
		for( int i = 1; i <= 10 ; i++) {
			System.out.println(i);
		}
		
		
		IntStream.range(1,11).forEach(new IntConsumer() { 
			
			@Override
			public void accept(int value) {
			System.out.println(value);
			};
		});

		IntStream.range(1,11).forEach((int value) -> System.out.println(value));

		
		IntStream.range(1,11).forEach((value) -> System.out.println(value));
		
		// 메서드 참조식 표현
		IntStream.range(1, 11).forEach(System.out::println);
	}

	//private void prinln(int value) {
		//System.out.println(value);
	//}
}
