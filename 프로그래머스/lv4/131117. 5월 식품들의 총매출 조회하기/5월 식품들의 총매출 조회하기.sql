SELECT o.product_id, p.product_name, sum(amount) * p.price as 'TOTAL_SALES' from food_order o right join food_product p on o.product_id = p.product_id where left(o.produce_date, 7) = '2022-05' group by o.product_id order by total_sales desc, o.product_id asc