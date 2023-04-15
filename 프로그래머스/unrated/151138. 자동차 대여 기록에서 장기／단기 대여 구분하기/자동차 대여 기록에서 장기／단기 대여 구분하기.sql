-- 코드를 입력하세요
SELECT history_id, car_id, date_format(start_date, '%Y-%m-%d'), date_format(end_date, '%Y-%m-%d'), if(timestampdiff(day, start_date, end_date) + 1 >= 30, '장기 대여', '단기 대여') as 'rent_type' from car_rental_company_rental_history where left(start_date, 7) = '2022-09'
order by history_id desc