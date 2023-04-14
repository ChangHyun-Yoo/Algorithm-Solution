-- 코드를 입력하세요
select f.flavor from first_half f left join icecream_info i on f.flavor = i.flavor where i.ingredient_type = 'fruit_based' group by f.flavor having sum(total_order) > 3000