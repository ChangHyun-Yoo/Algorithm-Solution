-- 코드를 입력하세요
select t1.flavor from
    (SELECT flavor, sum(total_order) as 't2' from july group by flavor) t2
    left join
    (SELECT flavor, sum(total_order) as 't1' from first_half group by flavor) t1
    on t1.flavor = t2.flavor
    order by (t1.t1 + t2.t2) desc
    limit 3