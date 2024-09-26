package ex19_04_1_serialiaztion_transient_no;
/*
 * 생성자, 메서드, 정적 필드는 직렬화 대상이 아니다.
 * 인스턴스 필드는 직렬화 대상이다.
 * transient 키워드 : 직렬화에서 제외 시킬 필드를 표시하는 키워드
 * 
 */

public class BBSItem implements java.io.Serializable {//게시물 클래스

	private static int itemNum = 0; // 게시물의 수 - 정적 필드는 직렬화 대상이 되지 않는다.
	//-> 데이터 베이스에서 기본키로 입력한다.
	private String writer; // 글쓴이 - 인스턴스 필드는 직렬화 대상이다.
	private String password; // 비밀번호 - 인스턴스 필드는 직렬화 대상이다.
	private String title; // 제목 - 인스턴스 필드는 직렬화 대상이다.
	private String content; // 내용 - 인스턴스 필드는 직렬화 대상이다.

	//생성자는 직렬화 대상이 되지 않는다.
	//-> 객체 생성해서 직렬화하여 데이터베이스에 전달
	BBSItem(String writer, String password, String title, String content) {
		this.writer = writer;
		this.password = password;
		this.title = title;
		this.content = content;

		itemNum++; // 객체 생성 시 게시물 증가
	}
	
	//메서드는 직렬화 대상이 되지 않는다.
	//-> 저장된 패스워드와 비교해서 맞으면 내용을 업데이트
	void modifyContent(String content, String password) {
		if (!password.equals(this.password)) // 비밀번호 체크하고 틀리면 리턴
			//문자열 비교는 equals로 해라
			return;
		else
			this.content = content; // 맞으면 내용 수정
	}
	
	//메서드는 직렬화 대상이 되지 않는다.
	@Override
	public String toString() {
		return "전체게시물의 수: " + itemNum + 
				"\n글쓴이: " + writer + 
				"\n패스워드: " + password + 
				"\n제목: " + title + 
				"\n내용: " + content;
	}
}
