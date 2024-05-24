select animal_type, count(*) from animal_ins
where animal_type = 'Cat' or animal_type = 'Dog'
group by animal_type
order by animal_type;