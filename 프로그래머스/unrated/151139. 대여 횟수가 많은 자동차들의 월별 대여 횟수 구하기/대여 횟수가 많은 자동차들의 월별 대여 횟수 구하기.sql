-- 코드를 입력하세요
select extract(month from start_date), car_id, count(car_id) from car_rental_company_rental_history
    where left(start_date, 7) in ('2022-08', '2022-09', '2022-10') and car_id in
    (SELECT car_id from car_rental_company_rental_history
    where left(start_date, 7) in ('2022-08', '2022-09', '2022-10')
    group by car_id
    having count(car_id) >= 5)
    group by extract(month from start_date), car_id
    order by extract(month from start_date), car_id desc