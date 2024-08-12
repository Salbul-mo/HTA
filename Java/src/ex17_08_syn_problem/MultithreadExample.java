package ex17_08_syn_problem;

/*
 * 계좌 이체와 잔액 합계 출력 동시에 하는 멀티 스레드 프로그램
 * 입금과 출력 사이의 타이밍에 합계 출력이 되는 경우 
 * 잘못된 금액이 출력된다.
 * 해결법 
 * -> 동기화 : 공유 데이터 사용 중에 그 공유 데이터를 다른 스레드가 사용하지 못하도록 만드는 것을 의미한다.
 */
public class MultithreadExample {

	public static void main(String args[]) {
		Account company = new Account("111-111-1111","사장",20000000);
		// 회사 계좌 2천만
		Account employee = new Account("222-222-2222","직원",10000000);
		// 직원 계좌 천만
		
		SharedArea sa = new SharedArea(company,employee);
		PrintThread thread1 = new PrintThread(sa);
		TransferThread thread2 = new TransferThread(sa);
		
		thread2.start();
		thread1.start();
	}
	/*
회사 계좌: 100만원 인출, 직원 계좌: 100만원 입금
회사 계좌: 100만원 인출, 직원 계좌: 100만원 입금
계좌 잔액 합계 : 29000000
회사 계좌: 100만원 인출, 직원 계좌: 100만원 입금
회사 계좌: 100만원 인출, 직원 계좌: 100만원 입금
회사 계좌: 100만원 인출, 직원 계좌: 100만원 입금
회사 계좌: 100만원 인출, 직원 계좌: 100만원 입금
회사 계좌: 100만원 인출, 직원 계좌: 100만원 입금
회사 계좌: 100만원 인출, 직원 계좌: 100만원 입금
회사 계좌: 100만원 인출, 직원 계좌: 100만원 입금
회사 계좌: 100만원 인출, 직원 계좌: 100만원 입금
회사 계좌: 100만원 인출, 직원 계좌: 100만원 입금
회사 계좌: 100만원 인출, 직원 계좌: 100만원 입금
계좌 잔액 합계 : 30000000
계좌 잔액 합계 : 30000000

	 */
}
