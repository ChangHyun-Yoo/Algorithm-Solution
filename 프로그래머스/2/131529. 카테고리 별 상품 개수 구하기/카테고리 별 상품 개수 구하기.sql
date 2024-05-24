select left(PRODUCT_CODE, 2), count(PRODUCT_CODE) from product
group by left(PRODUCT_CODE, 2)
order by left(PRODUCT_CODE, 2)