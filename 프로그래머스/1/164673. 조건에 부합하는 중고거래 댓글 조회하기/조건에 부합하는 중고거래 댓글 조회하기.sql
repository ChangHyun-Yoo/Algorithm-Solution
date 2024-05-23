select b.title, b.board_id, r.reply_id, r.writer_id, r.contents, left(r.created_date, 10) from
used_goods_reply r left join used_goods_board b on b.board_id = r.board_id
where b.created_date like '2022-10%'
order by r.created_date, b.title