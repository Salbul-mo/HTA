package trie;

import java.util.*;

public class Trie {
	
	private TrieNode root;
	
	public Trie () {
		this.root = new TrieNode();
	}
	
	public void insert(String input) {

		TrieNode node = this.root;
		
		String regex = "[^a-zA-Z0-9가-힣ㄱ-ㅎㅏ-ㅣ]";
		String edit = input.replaceAll(regex, "");
		// 특수문자 제외
		
		for (int cnt = 0 ; cnt < edit.length() ; cnt++) {
		
			node.getChild().putIfAbsent(edit.charAt(cnt), new TrieNode());
			
			node = node.getChild().get(edit.charAt(cnt));
		}
		
		node.setEndOfWord(true);
		node.setInput(input);
	}
	
	public ArrayList<String> recommendedSearch(String input) {
		
		ArrayList<String> result = new ArrayList<>();
		
		TrieNode node = this.root;
		
		String regex = "[^a-zA-Z0-9가-힣ㄱ-ㅎㅏ-ㅣ]";
		String edit = input.replaceAll(regex, "");
		
		for (int cnt = 0; cnt < edit.length() ; cnt++) {
			
			if (node.getChild().get(edit.charAt(cnt)) == null) {
				result.add("검색된 대상이 없습니다.");
				return result; 
			} else {
				node = node.getChild().get(edit.charAt(cnt));
			}
		}
		
		if (node.isEndOfWord()) {
			result.add(node.getInput());
		}
		
		 
		
		ArrayList<TrieNode> list = new ArrayList<TrieNode>(node.getChild().values());
		
		while (!list.isEmpty()) {
			TrieNode next = list.remove(list.size()-1);
			
			if (next.isEndOfWord()) {
				result.add(next.getInput());
			}
			
			if(!next.getChild().isEmpty()) {
				list.addAll(next.getChild().values());
			}
		}
		
		return result;
		
	}

}
