-- 코드를 입력하세요
SELECT i.name, i.datetime from animal_outs o right join animal_ins i on o.animal_id = i.animal_id where o.animal_id is null order by i.datetime limit 3