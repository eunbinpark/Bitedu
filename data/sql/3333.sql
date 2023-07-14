-- 문제1. 1) 주어진 파일을 이용하여 필요한 데이터를 테이블에 삽입
insert into book_info(book_isbn,book_title,book_author,book_publisher,book_published_date)
VALUES('PM0000037905','도둑맞은 뇌 : 뇌과학이 발견한 기억의 7가지 오류','대니얼 샥터 지음 ; 홍보람 옮김','인물과사상사','2023-09-08');
insert into book_info(book_isbn,book_title,book_author,book_publisher,book_published_date)
VALUES('PM0000037912','만들어진 붕괴 : 역사상 최악의 인플레이션 공격에서 당신의 돈을 지키는 법','데이비드 A. 스톡맨 지음 ; 한다해 옮김','한스미디어','2023-03-16');
insert into book_info(book_isbn,book_title,book_author,book_publisher,book_published_date)
VALUES('PM0000037918','부모라는 낯선 타인 : 나를 알기 위해 부모 공부를 시작합니다','양미영 지음','프롬북스','2023-05-01');
insert into book_info(book_isbn,book_title,book_author,book_publisher,book_published_date)
VALUES('PM0000037952','두 뇌 협력의 뇌과학 : 뇌와 마음 인간의 상호작용에 관한 유쾌한 탐구','우타 프리스 크리스 프리스 앨릭스 프리스 [공]지음 ; 대니얼 로크 그림 ; 정지인 옮김','김영사','2023-02-28');

-- 문제1. 1) 주어진 파일을 이용하여 필요한 데이터를 테이블에 삽입
insert into book_info(book_isbn,book_title,book_author,book_published_date)
VALUES('PM0000037905','도둑맞은 뇌 : 뇌과학이 발견한 기억의 7가지 오류','대니얼 샥터 지음 ; 홍보람 옮김','2023-09-08');
insert into book_info(book_isbn,book_title,book_author,book_published_date)
VALUES('PM0000037912','만들어진 붕괴 : 역사상 최악의 인플레이션 공격에서 당신의 돈을 지키는 법','데이비드 A. 스톡맨 지음 ; 한다해 옮김','2023-03-16');
insert into book_info(book_isbn,book_title,book_author,book_published_date)
VALUES('PM0000037918','부모라는 낯선 타인 : 나를 알기 위해 부모 공부를 시작합니다','양미영 지음','2023-05-01');
insert into book_info(book_isbn,book_title,book_author,book_published_date)
VALUES('PM0000037952','두 뇌 협력의 뇌과학 : 뇌와 마음 인간의 상호작용에 관한 유쾌한 탐구','우타 프리스 크리스 프리스 앨릭스 프리스 [공]지음 ; 대니얼 로크 그림 ; 정지인 옮김','2023-02-28');


insert into book_copy(book_seq,book_position,book_status,book_isbn)
VALUES(3,'BS-0001','BM-0001','PM0000037905');
insert into book_copy(book_seq,book_position,book_status,book_isbn)
VALUES(10,'BS-0001','BM-0001','PM0000037912');
insert into book_copy(book_seq,book_position,book_status,book_isbn)
VALUES(16,'BS-0001','BM-0001','PM0000037918');
insert into book_copy(book_seq,book_position,book_status,book_isbn)
VALUES(27,'BS-0001','BM-0001','PM0000037952');

insert into book_user(user_id,user_pass,user_phone_number)
VALUES('user1','1234','010-1234-5678');
insert into book_user(user_id,user_pass,user_phone_number)
VALUES('user2','5678','010-1111-2222');

-- 문제2. 1) 시나리오1을 직접 수행하는 쿼리 작성
insert into book_use_status(book_seq,user_id,borrow_start,borrow_end)
VALUES(3,'user1','2023-06-01', date_add(borrow_start, interval 13 day));
insert into book_use_status(book_seq,user_id,borrow_start,borrow_end)
VALUES(10,'user1','2023-06-05', date_add(borrow_start, interval 13 day));
insert into book_use_status(book_seq,user_id,borrow_start,borrow_end,return_date)
VALUES(16,'user1','2023-06-05', date_add(borrow_start, interval 13 day),'2023-06-14');

-- 문제2. 2) 시나리오1을 완성하기 위한 추가 쿼리 작성

-- 미반납 도서는 반납기한이 지나고 반납되지 않은 도서이다.
select * from book_use_status
where borrow_end - now() < 0
and isnull(return_date) = true;

-- 반납예정도서는 반납기한이 지나지 않고 반납되지 않은 도서이다.
select * from book_use_status
where borrow_end - now() >= 0
and isnull(return_date) = true;

-- 반납도서는 이미 반납된 도서이다.
select * from book_use_status
where isnull(return_date) = false;
  
-- 대출정지기간은 반납기한을 초과한 일자만큼 적용하여 적용은 반납다음날 부터 적용한다.

SELECT DATEDIFF(NOW(), min(borrow_end)) AS MAX FROM book_use_status
        WHERE isnull(return_date) = true
        AND borrow_end < NOW()
        AND user_id = 'user1'
        GROUP BY user_id;

UPDATE book_user SET service_stop = DATE_ADD(NOW(), interval (
        SELECT DATEDIFF(NOW(), MIN(borrow_end)) AS MAX FROM book_use_status
        WHERE isnull(return_date) = true
        AND borrow_end < NOW()
        AND user_id = 'user1'
        GROUP BY user_id
    ) day)
WHERE user_id = 'user1';


select *, max_book - (return_cnt + actual_return_cnt) as acc_cnt from (
select user.*,
    (select count(*) from book_use_status where user_id = user.user_id) as total_cnt,
    (select count(*) from book_use_status where user_id = user.user_id and ifnull(return_date, '') != '') as return_cnt,
    (select count(*) from book_use_status where user_id = user.user_id and ifnull(return_date, '') = '' and now() > borrow_end) as non_return_cnt,
    (select count(*) from book_use_status where user_id = user.user_id and ifnull(return_date, '') = '' and borrow_start <= now() and now() <= borrow_end) as actual_return_cnt
from book_user user where user.user_id = 'user1') a;

select copy.book_seq, 
copy.book_position, 
copy.book_status, 
info.book_isbn, 
info.book_title, 
info.book_author, 
stat.borrow_start, 
stat.borrow_end, 
stat.user_id, 
stat.return_date 
from book_copy copy
left join book_info info on info.book_isbn = copy.book_isbn
left join book_use_status stat on stat.book_seq = copy.book_seq
where stat.user_id = 'user1';


select a.*, b.* from book_info a inner join book_copy b on a.book_isbn=b.book_isbn;