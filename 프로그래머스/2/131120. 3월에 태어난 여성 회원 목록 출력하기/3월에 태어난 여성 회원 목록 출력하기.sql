select member_id, member_name, gender, left(date_of_birth, 10) from member_profile
where gender = 'W' and tlno is not null and date_format(date_of_birth, '%m') = '03'
order by member_id