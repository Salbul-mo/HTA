package boj;

import java.util.*;

public class Alphabet_10809 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		String result = "";
		
		for (int dec = 97; dec <= 122; dec++) {
			char ch = (char) dec;
			
			result += str.indexOf(ch) + " ";
		
		}
		
		System.out.println(result);
		sc.close();
	}

}
