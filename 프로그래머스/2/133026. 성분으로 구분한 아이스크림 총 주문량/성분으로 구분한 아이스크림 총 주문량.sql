select i.ingredient_type, sum(f.total_order) as 'TOTAL_ORDER' from first_half f join icecream_info i on f.flavor = i.flavor
group by i.ingredient_type
order by sum(f.total_order)