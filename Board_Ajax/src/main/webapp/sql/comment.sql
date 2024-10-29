drop table comm cascade constraints purge;

create table comm (
	num					number 			primary key,
	id					varchar2(30)	references member(id) on delete cascade,
	content				varchar2(200),
	reg_date			date,
	comment_board_num	number			references board(board_num) on delete cascade,
	comment_re_lev		number(1)		check(comment_re_lev in (0,1,2)),
	comment_re_seq		number,
	comment_re_ref		number
);

select * from comm;

drop sequence com_seq;

create sequence com_seq;

delete comm;



select comm.* , member.memberfile
					from comm natural join member
					using id
					where comment_board_num = 1
					order by comment_re_ref asc, comment_re_seq asc;

