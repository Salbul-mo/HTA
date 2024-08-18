/*		
		000 0               00 0
		001 1               01 1    
		010 2 		        11 3
		011 3               
		100 4 X
		101 5
		110 6 X       
		111 7       
		           
				   0000 0           2진수 표현
				   0001 1           I -> 0
				   0010 2           X -> 1
				   0011 3 
				   0100 4 X 
		           0101 5 
		           0110 6 
		           0111 7 
		           1000 8 X
		           1001 9  
		           1010 10 X
		           1011 11 
		           1100 12 X 
		           1101 13 X
		           1110 14 X
		           1111 15 
		           
		           				00000 0
		           				00001 1
		           				00010 2
		           				00011 3 
		           				00100 4
		           				00101 5
		           				00110 6 
		           				00111 7
		           				01000 8 X
		           				01001 9  
		           				01010 10 
		           				01011 11 
		           				01100 12 X
		           				01101 13 
		           				01110 14 
		           				01111 15 
		           				10000 16 X
		           				10001 17
		           				10010 18 X
		           				10011 19  
		           				10100 20 X
		           				10101 21 
		           				10110 22 X
		           				10111 23 
		           				11000 24 X
		           				11001 25 X
		           				11010 26 X
		           				11011 27 
		           				11100 28 X
		           				11101 29 X 
		           				11110 30 X
		           				11111 31 
	n 자리 => 0부터 Math.pow(2,n)-1 까지의 정수
	
		           
 */
package boj;

import java.io.*;
import java.util.*;

public class MasicStone {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stok = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(stok.nextToken());
		int k = Integer.valueOf(stok.nextToken());
		Long i = Long.valueOf(stok.nextToken());

		Trie trie = new Trie();

		ArrayList<Long> num = new ArrayList<>();
		Long cnt = 0L;
		Long val = 0L;
		Long limit =1L; 
		for(int j = 1; j <= n ; i++) {
			limit = limit*2;
		}
		
		while (cnt < limit && val <= i) {
			String str = Long.toBinaryString(cnt);
			while (str.length() != n) {
				str = "0" + str;
			}
			StringBuilder sb = new StringBuilder(str);
			String re = sb.reverse().toString();
			if (Integer.valueOf(re) < cnt) {
				continue;
			}
			if (trie.insert(str, k)) {
				num.add(cnt);
				val++;
			}
			cnt++;
			

		}
		Collections.sort(num);
		int iInt = 0;
		if (Long.valueOf(i).intValue() > Integer.MAX_VALUE) {
			iInt = Integer.MAX_VALUE;
		} else {
			iInt = Long.valueOf(i).intValue();
		}
		try {
			String answer = Long.toBinaryString(num.get(iInt));
			answer = answer.replaceAll("0", "I");
			answer = answer.replaceAll("1", "X");
			System.out.println(answer);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("NO SUCH STONE");
		}
	}
}

class Trie {
	Node root;
	static final int SIZE = 2;

	public Trie() {
		this.root = new Node();
		this.root.val = ' ';
	}

	private static class Node {
		Node[] child = new Node[SIZE];
		boolean isTerminal = false;
		int childNum = 0;
		char val;
	}

	public boolean insert(String str, int k) {
		Node current = this.root;
		char[] arr = str.toCharArray();
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			int num = Character.getNumericValue(arr[i]);
			if (current.child[num] == null) {
				current.child[num] = new Node();
				current.child[num].val = arr[i];
				if (i != 0 && current.val != current.child[num].val) {
					cnt++;
				}

				current.childNum++;
			}

			current = current.child[num];
		}
		current.isTerminal = true;

		if (cnt > k) {
			delete(str);
			return false;
		}

		return true;
	}

	public void delete(String str) {
		delete(this.root, str, 0);
	}

	private void delete(Node current, String str, int idx) {
		int leng = str.length();

		if (idx == leng) {
			current.isTerminal = false;

			if (current.childNum == 0) {
				current = null;
			}
		} else {
			char c = str.charAt(idx);
			int num = Character.getNumericValue(c);

			delete(current.child[num], str, idx + 1);

			if (current.child[num] == null)
				current.childNum--;

			if (current.childNum == 0 && !current.isTerminal) {
				current = null;
			}
		}

	}

}
