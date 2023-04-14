-- 코드를 입력하세요
select category, price, product_name from food_product
where category in
    (
        SELECT category 
        from food_product 
        where category = '과자' or category = '김치' or category = '국' or category = '식용유' 
        group by category 
        having price = max(price)
     )
     order by price desc