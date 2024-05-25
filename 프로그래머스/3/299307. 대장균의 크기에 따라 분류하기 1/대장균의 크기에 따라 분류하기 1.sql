-- 코드를 작성해주세요
select id as 'ID', 
if(size_of_colony <= 100, 'LOW', if(size_of_colony > 100 and size_of_colony <= 1000, 'MEDIUM', 'HIGH')) as 'SIZE'
from ecoli_data
order by id