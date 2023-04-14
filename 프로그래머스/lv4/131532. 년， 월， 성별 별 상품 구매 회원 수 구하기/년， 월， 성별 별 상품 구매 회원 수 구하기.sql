-- 코드를 입력하세요
select y, m, gender, count(*) from
(SELECT extract(year from s.sales_date) as 'y', extract(month from s.sales_date) as 'm', i.gender as 'gender'
from online_sale s left join user_info i on s.user_id = i.user_id group by extract(year from s.sales_date), extract(month from s.sales_date), i.gender, s.user_id) a where gender is not null
group by y, m, gender order by y, m, gender