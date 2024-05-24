select factory_id, factory_name, address from food_factory
where left(address, 3) = '강원도'
order by factory_id