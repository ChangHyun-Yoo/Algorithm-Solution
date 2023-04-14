-- 코드를 입력하세요
SELECT b.book_id, a.author_name, left(b.published_date, 10) from book b left join author a on b.author_id = a.author_id where b.category = '경제' order by b.published_date