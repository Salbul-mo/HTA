package ex05_7_continue;

public class ContinueExample2_1 {

	public static void main(String args[]) {
		int cnt = 0;
		//잘못된 예
		while (cnt < 10) {
			if (cnt == 5) {
				//cnt ++;
				continue;
			}
			//cnt 가 ++ 되지 않고 continue 되어 계속해서 While 문이 돌아간다.
			System.out.println(cnt);
			cnt++;
		}
		
		System.out.println("끝.");
	}
}
