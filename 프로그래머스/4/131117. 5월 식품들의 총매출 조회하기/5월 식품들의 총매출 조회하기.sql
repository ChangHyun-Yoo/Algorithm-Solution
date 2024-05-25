select p.product_id, p.product_name, sum(o.amount * p.price) as 'TOTAL_SALES' from food_order o join food_product p on o.product_id = p.product_id
where left(o.produce_date, 7) = '2022-05'
group by p.product_id
order by total_sales desc, p.product_id
