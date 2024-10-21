package trie;

public class Trie {
	
	private TrieNode root = new TrieNode();
	
	public void insert(String input) {

		String regex = "[^a-zA-Z0-9가-힣ㄱ-ㅎㅏ-ㅣ]";
		String edited = input.replaceAll(regex, "");
		// 특수문자 제외
		
		
	}

}
