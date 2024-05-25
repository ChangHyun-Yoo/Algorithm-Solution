-- 코드를 작성해주세요
select he.dept_id, hd.dept_name_en, round(avg(he.sal)) as 'AVG_SAL' from hr_employees he join hr_department hd
on he.dept_id = hd.dept_id
group by he.dept_id
order by avg_sal desc