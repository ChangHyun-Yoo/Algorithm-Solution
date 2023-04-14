-- 코드를 입력하세요
select a.cart_id from (SELECT cart_id from cart_products where name = 'Yogurt') a inner join (SELECT cart_id from cart_products where name = 'Milk') b on a.cart_id = b.cart_id