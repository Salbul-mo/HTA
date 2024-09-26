package ex17_03_thread_four.name;

public class MultithreadExample2 {

	public static void main(String[] args) {
		//세 개의 스레드 생성
		Thread thread1 = new DigitThread();
		Thread thread2 = new DigitThread();
		Thread thread3 = new AlphabetThread();
		//스레드에 이름 부여 setName(String)
		thread3.setName("alphabet");
		thread1.setName("digit1");
		thread2.setName("digit2");
		
		//세 스레드 시작
		thread1.start();
		thread2.start();
		thread3.start();
		
		/*
		 * Thread t = Thread.currentThread();
		 * Thread 의 정적 메서드인 currentThread()로 코드를 실행하는 현재 스레드의 참조를 얻을 수 있다.
		 * setName() 메서드로 스레드의 이름을 변경할 수 있고
		 * getName() 메서드로 스레드의 이름을 가져올 수 있다.
		 * t.setName("스레드 이름");
		 * t.getName();
		 */
		
		System.out.println("스레드 이름 : " + Thread.currentThread().getName());
	}
	/*
	스레드 이름 : main
	A00B11C22D33E44F55G66H77I88J99K1010L1111M1212N1313O1414P1515Q1616R1717S1818T1919U2020V2121W2222X2323Y2424Z2525스레드 이름(alphabet) : alphabet
	스레드 이름 (digit) : digit2
	스레드 이름 (digit) : digit1
	*/
}
