-- 코드를 입력하세요
SELECT a.author_id, a.author_name, b.category, sum(bs.sales * b.price) from book_sales bs
    left join book b
    on bs.book_id = b.book_id
    left join author a
    on b.author_id = a.author_id
    where left(bs.sales_date, 7) = '2022-01'
    group by a.author_id, a.author_name, b.category
    order by a.author_id, b.category desc