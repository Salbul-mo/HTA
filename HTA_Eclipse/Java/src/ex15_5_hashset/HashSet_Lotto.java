package ex15_5_hashset;

import java.util.*;

public class HashSet_Lotto {
	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<>();
		for (; hs.size() < 6;) {
			hs.add((int) (Math.random() * 45) + 1);
			// Math.random 은 double 반환이므로 (int)로 형 변환해주어야 한다.
		}
		
		 List<Integer> list = new ArrayList<Integer>(hs);
		 Collections.sort(list);
		 
		 
		 System.out.println(hs);
		 System.out.println(list);
		 

	}

}
