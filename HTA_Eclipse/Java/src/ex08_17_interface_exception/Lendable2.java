package ex08_17_interface_exception;

interface Lendable2 {
	final static byte STATE_BORROWED = 1; // 대출 중
	final static byte STATE_NOMAL = 0; // 대출되지 않은 상태

	void checkOut(String borrower, String date) throws Exception; //예외 추가.

	void checkIn();
	
	void printState();
}
