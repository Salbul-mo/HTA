package trie;

import java.util.*;

public class TrieNode {

	private Map<Character, TrieNode> child = new HashMap<>();
	private boolean endOfWord = false;
	private String input = null;
	
	public boolean isEndOfWord() {
		return endOfWord;
	}
	
	public void setEndOfWord(boolean endOfWord) {
		this.endOfWord = endOfWord;
	}
	
	public String getInput() {
		return input;
	}
	
	public Map<Character, TrieNode> getChild() {
		return child;
	}
	
	public void setInput(String input) {
		this.input = input;
	}
	
	
}
