-- 코드를 입력하세요
SELECT order_id, product_id, date_format(out_date, '%Y-%m-%d'), if(out_date is null, '출고미정', if(out_date <= '2022-05-01', '출고완료', '출고대기')) from food_order order by order_id