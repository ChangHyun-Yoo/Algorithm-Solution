select p1.category, p1.price, p1.product_name from food_product p1 join
(select max(price) as 'price', category from food_product
where category in ('과자', '국', '김치', '식용유')
group by category) p2
on p1.price = p2.price and p1.category = p2.category
order by p1.price desc