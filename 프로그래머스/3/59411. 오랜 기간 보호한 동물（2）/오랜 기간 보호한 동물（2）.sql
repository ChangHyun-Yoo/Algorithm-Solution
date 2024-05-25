select i.animal_id, i.name from animal_ins i join animal_outs o
on i.animal_id = o.animal_id
order by datediff(i.datetime, o.datetime) limit 2