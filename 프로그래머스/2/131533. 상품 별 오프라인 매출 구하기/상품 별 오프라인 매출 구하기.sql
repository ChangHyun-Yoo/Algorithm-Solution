select p.product_code, sum(p.price * o.sales_amount) from offline_sale o join product p
on o.product_id = p.product_id
group by p.product_code
order by sum(p.price * o.sales_amount) desc, p.product_code