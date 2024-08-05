package ex08_16_interface_constant;

// extends 먼저. implements 나중에
public class AppCDInfo extends CDInfo implements Lendable { // 대여 CD 클래스

	String borrower; // 대출인
	String checkOutDate; // 대출일
	byte state; // 대출상태
	String artistName; // 저자 추가

	AppCDInfo(String registerNo, String title, String artistName) { // 저자 추가
		super(registerNo, title);
		this.artistName = artistName;

	}

	@Override
	public void checkOut(String borrower, String date) {
		if (state != STATE_NOMAL) {
			System.out.println("이미 대출된 상태입니다.");
			return;
		} else {
			this.borrower = borrower;
			this.checkOutDate = date;
			this.state = STATE_BORROWED;
			System.out.println("*" + title + " CD가 대출되었습니다.");
			System.out.println("저  자: " + artistName); // 저자 추가
			System.out.println("대출인: " + borrower);
			System.out.println("대출일: " + date + "\n");
		}
	}

	@Override
	public void checkIn() {
		this.borrower = null;
		this.checkOutDate = null;
		this.state = STATE_NOMAL;
		System.out.println("*" + title + " CD가 반납되었습니다.\n");
	}

	@Override
	public void printState() {
		if (this.state ==  STATE_NOMAL) {
			System.out.println("--------------");
			System.out.println("대출상태: 대출가능");
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