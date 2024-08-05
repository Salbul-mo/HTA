package ex08_17_interface_exception;

//인터페이스를 구현하는 클래스
public class SeparateVolume implements Lendable2 { // 대여 도서 클래스
	String requestNo; // 청구번호
	String bookTitle; // 제목
	String writer; // 저자
	String borrower; // 대출인
	String checkOutDate; // 대출일
	byte state; // 대출상태

	SeparateVolume(String requestNo, String bookTitle, String writer) { // 생성자
		this.requestNo = requestNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}

	@Override                                          //오류를 메서드 호출한 곳으로 되던짐
	public void checkOut(String borrower, String date) throws Exception {
		//Exception Exception is not compatible with 
		//throws clause in Lendable.checkOut(String, String)
		//오버라이딩하는 원래 메서드보다 더 큰 범위의 예외를 선언할 수 없다.
		if (state != STATE_NOMAL) {
			throw new Exception("*대출불가: " + bookTitle);
		} else {
			this.borrower = borrower;
			this.checkOutDate = date;
			this.state = STATE_BORROWED;
			System.out.println("*" + bookTitle + " 이(가) 대출되었습니다.");
			System.out.println("저 자: " + writer); // 저자 추가
			System.out.println("대출인: " + borrower);
			System.out.println("대출일: " + date + "\n");
		}
	}

	@Override
	public void checkIn() {
		this.borrower = null;
		this.checkOutDate = null;
		this.state = STATE_NOMAL;
		System.out.println("*" + bookTitle + " 이(가) 반납되었습니다.\n");
	}

	@Override
	public void printState() {
		if (this.state == STATE_NOMAL) {
			System.out.println("--------------");
			System.out.println("대출상태: 대출 가능!");
			System.out.println("--------------");
		} else {
			System.out.println("--------------");
			System.out.println("대출상태: 대출 중");
			System.out.println("대출인: " + borrower);
			System.out.println("대출일: " + checkOutDate);
			System.out.println("--------------");
		}

	}

}