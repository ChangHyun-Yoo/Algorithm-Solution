select history_id, car_id, left(start_date, 10), left(end_date, 10),
if(datediff(end_date, start_date) + 1 >= 30, '장기 대여', '단기 대여') as 'RENT_TYPE'
from car_rental_company_rental_history
where left(start_date, 7) = '2022-09'
order by history_id desc