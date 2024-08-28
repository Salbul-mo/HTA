package boj;

import java.util.NoSuchElementException;

public class Trie_ex {

	Node root;
	static final int SIZE = 2; // 0 아니면 1 , I 아니면 X

	public Trie_ex() {
		this.root = new Node();
		this.root.val = ' ';
	}

	private static class Node {
		Node[] child = new Node[SIZE]; // 뒤로 연결되는 문자열 저장하는 배열
		boolean isTerminal = false; // 현재 노드가 문자열 완성되는 노드인지 여부
		int childNum = 0; // 현재 노드에 연결된 문자열 갯수
		@SuppressWarnings("unused")
		char val; // 현재 노드의 값
	}

	public void insert(String str) {
		int length = str.length();
		Node current = this.root; // root 부터 시작
		for (int i = 0; i < length; i++) {
			char c = str.charAt(i);
			int num = Character.getNumericValue(c);
			if (current.child[num] == null) { // 기존에 null이면 연결 문자열로 처음 추가
				current.child[num] = new Node();
				current.child[num].val = c;
				current.childNum++;
			}

			current = current.child[num]; // 자식 노드로 넘어감
		}
		current.isTerminal = true;
	}

	public boolean find(String str) {
		int length = str.length();
		Node current = this.root; // 현재 노드 설정

		for (int i = 0; i < length; i++) {
			int c = str.charAt(i);
			if (current.child[c] == null) { // 문자열 일부 추출했는데 null이라면 false 반환
				return false;
			}
			current = current.child[c];
		}
		return current != null && current.isTerminal; // 문자열의 마지막이라면 true
	}

	public void printAll(int length) {
		Node current = this.root;
		for (int i = 0; i < SIZE ; i++) {
			System.out.print(current.child[i]);
			current = current.child[i];
		}
	}
		
	

	

			
		
		

	

	public void delete(String str) {
		delete(this.root, str, 0);

	}

	public void delete(Node current, String str, int idx) {
		int length = str.length();

		if ((current.childNum == 0 && idx != length) || (idx == length && !current.isTerminal)) {
			throw new NoSuchElementException("Value " + str + " does Not exist in Trie");
		}

		if (idx == length) {
			current.isTerminal = false;

			if (current.childNum == 0) {
				current = null;
			}

		} else {
			int c = str.charAt(idx);

			delete(current.child[c], str, idx + 1);

			if (current.child[c] == null)
				current.childNum--;

			if (current.childNum == 0 && !current.isTerminal) {
				current = null;
			}

		}
	}

}
