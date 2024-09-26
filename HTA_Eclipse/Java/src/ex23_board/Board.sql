CREATE TABLE BOARD(
BOARD_NUM 		NUMBER(5) PRIMARY KEY,	-- 글 번호(기본키)
BOARD_NAME 		VARCHAR2(30),			-- 작성자
BOARD_PASS 		VARCHAR2(30),			-- 비밀번호
BOARD_SUBJECT 	VARCHAR2(300),			-- 제목
BOARD_CONTENT 	VARCHAR2(4000),			-- 내용
BOARD_FILE 		VARCHAR2(50),			-- 첨부될 파일 명 (시스템에 저장되는 파일 이름)
BOARD_ORIGINAL 	VARCHAR2(50),			-- 첨부될 파일 명 (시스템에 저장된 파일의 원래 파일 이름)
BOARD_RE_REF 	NUMBER(5),				-- 답변 글 작성 시 참조되는 글의 번호
BOARD_RE_LEV 	NUMBER(5),				-- 답변 글의 깊이(원문 : 0, 답변 : 1, 답변의 답변 : 2 . . . .) 
BOARD_RE_SEQ 	NUMBER(5),				-- 답변 글의 순서 (원문 글을 기준으로 보여주는 순서)
BOARD_READCOUNT	NUMBER(5),				-- 글의 조회수
BOARD_DATE 		DATE					-- 글의 작성 일자
);

SELECT * FROM BOARD;

DELETE FROM BOARD;

/*
 * 글 번호는 시퀀스로 생성한다.
 * 1 부터 1 씩 증가
 */ 
CREATE SEQUENCE BOARD_SEQ
	START WITH 1
	INCREMENT BY 1;
	
DROP SEQUENCE BOARD_SEQ;


SELECT * 
FROM (SELECT ROWNUM RNUM , B.* 
		FROM (SELECT BOARD_NUM, BOARD_NAME, BOARD_SUBJECT, BOARD_CONTENT, BOARD_RE_REF, BOARD_RE_LEV, BOARD_RE_SEQ, BOARD_DATE
				FROM BOARD
				ORDER BY BOARD_RE_REF DESC, BOARD_RE_SEQ ASC) B
				WHERE ROWNUM <= 10)
WHERE RNUM BETWEEN 1 AND 10;

-- 상위 게시글을 삭제할 때 같이 삭제할 하위 게시글 중 re_seq 가 가장 큰 값 구하는 쿼리문 
-- (해당 상위 게시글보다 나중에 작성된 같은 레벨의 게시글들 중 가장 작은 re_seq를 가져와 -1 하면 자신의 하위 게시글 중 가장 큰 re_seq가 된다.)
-- 정렬 기준을 잘 세워야 삭제할 때 기준이 된다. 하위 글이 상위글 바로 아래에 정렬되도록 해서 이걸 가지고 삭제 범위를 결정할 수 있다.
select min(board_re_seq) -1
from board
where board_re_ref = ?
and board_re_lev = ?
and board_re_seq > ?;

-- 같은 레벨의 시퀀스가 높은 게시글이 존재할 때.
SELECT BOARD_NUM
FROM BOARD
WHERE BOARD_RE_REF = ?
AND BOARD_RE_LEV >= ?
AND BOARD_RE_SEQ >= ?
AND BOARD_RE_SEQ <= (SELECT MIN(BOARD_RE_SEQ) - 1 
					FROM BOARD
					WHERE BOARD_RE_REF = ?
					AND BOARD_RE_LEV = ?
					AND BOARD_RE_SEQ > ?);
					
-- 같은 레벨의 시퀀스가 높은 게시글이 없을 때 최대 SEQ 값을 구하기
SELECT MAX(BOARD_RE_SEQ)
FROM BOARD
WHERE BOARD_RE_REF = ?
AND BOARD_RE_LEV >= ?
AND BOARD_RE_SEQ >= ?;

-- NVL 로 합치기
SELECT NVL((SELECT MIN(BOARD_RE_SEQ) -1
			FROM BOARD
			WHERE BOARD_RE_REF = ?
			AND BOARD_RE_LEV = ?
			AND BOARD_RE_SEQ > ?), (SELECT MAX(BOARD_RE_SEQ)
									FROM BOARD
									WHERE BOARD_RE_REF = ?
									AND BOARD_RE_LEV >= ?
									AND BOARD_RE_SEQ >= ?))
FROM BOARD;



delete from board
             where board_num >= ? 
             and board_re_ref = ? 
             and board_re_lev >= ? 
             and board_re_seq >= ? 
             and board_re_seq <= nvl((select min(board_re_seq)-1 
                                      from board                                   
                                      where board_re_ref = ? 
                                      and board_re_lev = ? 
									  and board_re_seq > ?) 
                                      ,                                                              
                                      (select max(board_re_seq) 
                                       from board 
                                       where board_re_ref = ? 
                                       and board_re_lev >= ? 
                                       and board_re_seq >= ?)) )



select board_num from board 
where board_re_ref = ? 
and board_re_lev >= ? 
and board_re_seq >= ? 
and board_re_seq <= nvl((select min(board_re_seq)-1 
                         from board 
                         where board_re_ref = ? 
                         and board_re_lev = ? 
						 and board_re_seq > ?) 
                         ,                        
                         (select max(board_re_seq) 
                         from board 
                         where board_re_ref = ?));
                         
                         
SELECT BOARD_SEQ.CURRVAL FROM DUAL


COMMIT