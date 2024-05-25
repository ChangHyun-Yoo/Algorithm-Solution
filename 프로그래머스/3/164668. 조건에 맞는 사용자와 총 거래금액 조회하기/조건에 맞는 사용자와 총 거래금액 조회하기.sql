select u.user_id, u.nickname, sum(b.price) from used_goods_board b join used_goods_user u on b.writer_id = u.user_id
where b.status = 'DONE'
group by u.user_id
having sum(b.price) >= 700000
order by sum(b.price)