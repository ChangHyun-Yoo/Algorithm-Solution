select cast(substring(datetime, 12, 2) as signed), count(*) from animal_outs
where cast(substring(datetime, 12, 2) as signed) >= 9 and cast(substring(datetime, 12, 2) as signed) <= 19
group by cast(substring(datetime, 12, 2) as signed)
order by cast(substring(datetime, 12, 2) as signed)