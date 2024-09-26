package ex08_14_02_interface;

//인터페이스를 구현하는 클래스
public class SeparateVolume implements Lendable { //대여 도서 클래스
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

	@Override
	public void checkOut(String borrower, String date) {
		if (state != 0) {
			System.out.println("이미 대출된 상태입니다.");
			return;
		} else {
			this.borrower = borrower;
			this.checkOutDate = date;
			this.state = 1;
			System.out.println("*" + bookTitle + " 이(가) 대출되었습니다.");
			System.out.println("대출인:" + borrower);
			System.out.println("대출일:" + date + "\n");
		}
	}

	@Override
	public void checkIn() {
		this.borrower = null;
		this.checkOutDate = null;
		this.state = 0;
		System.out.println("*" + bookTitle + " 이(가) 반납되었습니다.\n");
	}
}