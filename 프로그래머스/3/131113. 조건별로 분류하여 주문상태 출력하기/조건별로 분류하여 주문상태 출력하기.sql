select order_id, product_id, left(out_date, 10), if(out_date is null, '출고미정', if(left(out_date, 10) <= '2022-05-01', '출고완료', '출고대기')) from food_order
order by order_id