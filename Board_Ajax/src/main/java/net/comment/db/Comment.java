package net.comment.db;

public class Comment {

	private int num;
	private String id;
	private String content;
	private String reg_date;
	private int comment_board_num;
	private int comment_re_lev;
	private int comment_re_seq;
	private int comment_re_ref;

	public Comment() {
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public int getComment_board_num() {
		return comment_board_num;
	}

	public void setComment_board_num(int comment_board_num) {
		this.comment_board_num = comment_board_num;
	}

	public int getComment_re_lev() {
		return comment_re_lev;
	}

	public void setComment_re_lev(int comment_re_lev) {
		this.comment_re_lev = comment_re_lev;
	}

	public int getComment_re_seq() {
		return comment_re_seq;
	}

	public void setComment_re_seq(int comment_re_seq) {
		this.comment_re_seq = comment_re_seq;
	}

	public int getComment_re_ref() {
		return comment_re_ref;
	}

	public void setComment_re_ref(int comment_re_ref) {
		this.comment_re_ref = comment_re_ref;
	}

}
