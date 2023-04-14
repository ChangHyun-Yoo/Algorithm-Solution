-- 코드를 입력하세요
SELECT round(sum(daily_fee) / count(daily_fee)) from car_rental_company_car where car_type = 'SUV'