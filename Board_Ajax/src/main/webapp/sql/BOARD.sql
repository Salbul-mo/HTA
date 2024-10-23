drop table board cascade constraints purge;

CREATE TABLE BOARD(
	BOARD_NUM 			NUMBER, 				-- 글 번호
	BOARD_NAME 			VARCHAR2(30),			-- 작성자
	BOARD_PASS			VARCHAR2(30),			-- 비밀번호
	BOARD_SUBJECT		VARCHAR2(300),			-- 제목
	BOARD_CONTENT		VARCHAR2(4000),			-- 내용
	BOARD_FILE			VARCHAR2(50),			-- 첨부될 파일 명
	BOARD_RE_REF		NUMBER,					-- 답변 글 작성시 참조되는 글의 번호
	BOARD_RE_LEV		NUMBER,					-- 답변 글의 깊이
	BOARD_RE_SEQ		NUMBER,					-- 답변 글의 순서
	BOARD_READCOUNT		NUMBER,					-- 글의 조회수
	BOARD_DATE			DATE default sysdate,	-- 글의 작성 날짜
	PRIMARY KEY(BOARD_NUM)
);


select * from board;
delete from board;
select * from comm;

-- 테스트 용 데이터 삽입

insert into board (BOARD_NUM, BOARD_SUBJECT, BOARD_NAME, BOARD_RE_REF)
values(1, '처음', 'admin', 1);
insert into board (BOARD_NUM, BOARD_SUBJECT, BOARD_NAME, BOARD_RE_REF)
values(2, '둘째', 'admin', 2);
insert into board (BOARD_NUM, BOARD_SUBJECT, BOARD_NAME, BOARD_RE_REF)
values(3, '셋째', 'admin', 3);

insert into comm (num, id, comment_board_num) values(1,'admin',1);
insert into comm (num, id, comment_board_num) values(2,'admin',1);
insert into comm (num, id, comment_board_num) values(3,'admin',2);
insert into comm (num, id, comment_board_num) values(4,'admin',2);

update board
set board_subject = '오늘도 행복하세요'
where board_num = 1;

-- 1. comm 테이블에서 comment_board_num 별 갯수를 구한다.
select comment_board_num, count(*) as cnt from comm group by comment_board_num;

-- 2. baord 와 조인한다.
--select board_num, board_subject, cnt
--from board, (select comment_board_num, count(*) as cnt form comm group by comment_board_num)
--where board.board_num = comm.comment_board_num;

select board_num, board_subject, cnt
from board join (select comment_board_num, count(*) cnt
					from comm
					group by comment_board_num)
on board_num = comment_board_num;

-- 3. outer join 으로 board 의 글을 모두 표시하고 cnt 가 Null 인 경우 0으로 표시한다.
select board_num, board_subject, nvl(cnt,0) as cnt
from board left outer join (select comment_board_num, count(*) cnt
								from comm
								group by comment_board_num)
on board_num = comment_board_num
order by board_re_ref desc, board_re_seq asc;

-- 4. 인라인 뷰를 이용한 쿼리문 작성
select *
from (select rownum as rnum, j.*
		from ( select board.*, nvl(cnt,0) as cnt
				from board left outer join (select comment_board_num, count(*) as cnt
												from comm
												group by comment_board_num)
				on board_num = comment_board_num
				order by board_re_ref desc, board_re_seq asc) j
		where rownum <= 10 )
where rnum >= 1 and rnum <= 10;
