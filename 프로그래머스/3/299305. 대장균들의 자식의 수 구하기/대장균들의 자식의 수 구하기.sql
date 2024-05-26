-- 코드를 작성해주세요
select e.id, count(if(p1.parent_id is null, null, p1.parent_id)) as 'CHILD_COUNT' from
ecoli_data e left join 
(
select parent_id from ecoli_data
where parent_id is not null
)
p1
on e.id = p1.parent_id
group by e.id
order by e.id