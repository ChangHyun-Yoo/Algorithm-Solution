-- 코드를 입력하세요
SELECT car_id, round(sum(datediff(end_date, start_date) + 1) / count(car_id), 1) as 'average_duration'
    from car_rental_company_rental_history
    group by car_id
    having average_duration >= 7
    order by average_duration desc, car_id desc