package ex16_3_system.arraycopy;

public class System3_currentTimeMillis {

	public static void main(String[] args) {

		long time1 = System.currentTimeMillis(); // 현재 시간 데이터 밀리초까지 불러옴
		System.out.println("시작 = " + time1); 

		double total = 0.0;

	        for (int cnt = 1; cnt < 1000000000; cnt += 2)
	            if (cnt / 2 % 2 == 0)
	                total += 1.0 / cnt;
	            else
	                total -= 1.0 / cnt;
	        double pi = total * 4;

			long time2 = System.currentTimeMillis(); // 계산이 끝난 시간 데이터 밀리초까지 불러옴
			System.out.println("끝= " + time2);
			System.out.println("result " + pi);
			System.out.printf("계산에 %d ms 가 소요되었습니다.\n ", time2 - time1);
			System.out.printf("계산에 %6.3f 가 소요되었습니다.\n ", (time2 - time1) / 1000D);
		}

	}
