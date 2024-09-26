package boj.class1;

import java.util.*;
import java.util.stream.Stream;

public class Mod_3052 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int cnt = 1; cnt <= 10 ; cnt++) {
			int i = Integer.parseInt(sc.nextLine());
			list.add(i%42);
		}
		
		Stream<Integer> stream = list.stream();
		
		System.out.println(stream.distinct().count());
		
		sc.close();
	}
}
