select s.y as 'year', s.m as 'month', s.g as 'gender', count(*) as 'users' from
(select year(o.sales_date) as 'y', month(o.sales_date) as 'm', u.gender as 'g', u.user_id as 'user' from online_sale o join user_info u
on o.user_id = u.user_id
where u.gender is not null
group by year(o.sales_date), month(o.sales_date), u.gender, u.user_id) s
group by year, month, gender
order by year, month, gender