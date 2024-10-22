package trie;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		
		Trie test = new Trie();
		
		String teststr1 = "수학 교육 1-1 기초";
		String teststr2 = "영어 교육 1-1 기초";
		String teststr3 = "국어 교육 1-1 기초";
		String teststr4 = "수학 교육 2-1 심화";
		String teststr5 = "영어 교육 2-1 심화";
		String teststr6 = "국어 교육 2-1 심화";
		String teststr7 = "수학 파이널";
		String teststr8 = "국어 파이널";
		String teststr9 = "영어 파이널";
		String teststr10 = "강사 홍길동";
		String teststr11 = "모의고사";
		
		
		
		test.insert(teststr1);
		test.insert(teststr2);
		test.insert(teststr3);
		test.insert(teststr4);
		test.insert(teststr5);
		test.insert(teststr6);
		test.insert(teststr7);
		test.insert(teststr8);
		test.insert(teststr9);
		test.insert(teststr10);
		test.insert(teststr11);
		
		ArrayList<String> list = test.recommendedSearch("수학");
		System.out.println(list.toString());
		
		
	}

}
