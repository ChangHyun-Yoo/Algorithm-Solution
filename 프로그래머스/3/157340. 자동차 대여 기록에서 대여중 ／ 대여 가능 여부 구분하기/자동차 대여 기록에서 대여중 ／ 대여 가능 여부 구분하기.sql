select car_id as 'CAR_ID', if(car_id in (select car_id from car_rental_company_rental_history
 where left(start_date, 10) <= '2022-10-16' and left(end_date, 10) >= '2022-10-16'
 ), '대여중', '대여 가능') as 'AVAILABILITY'
from car_rental_company_rental_history
group by car_id
order by car_id desc
