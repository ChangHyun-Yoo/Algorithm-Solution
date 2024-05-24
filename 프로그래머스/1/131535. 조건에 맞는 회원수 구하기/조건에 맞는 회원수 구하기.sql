select count(*) from user_info
where left(joined, 4) = '2021' and (age >= 20 and age <= 29)