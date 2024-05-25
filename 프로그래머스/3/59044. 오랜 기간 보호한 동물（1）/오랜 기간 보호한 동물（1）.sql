select i.name, i.datetime from animal_ins i left join animal_outs o on i.animal_id = o.animal_id
where o.name is null and i.name is not null
order by i.datetime limit 3