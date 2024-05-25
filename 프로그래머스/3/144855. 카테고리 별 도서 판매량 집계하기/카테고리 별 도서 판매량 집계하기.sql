select b.category, sum(s.sales) from book_sales s join book b
on s.book_id = b.book_id
where left(s.sales_date, 7) = '2022-01'
group by b.category
order by b.category