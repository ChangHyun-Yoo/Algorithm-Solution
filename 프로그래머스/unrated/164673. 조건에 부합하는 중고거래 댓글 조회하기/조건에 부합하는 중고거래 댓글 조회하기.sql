-- 코드를 입력하세요
SELECT b.title, b.board_id, r.reply_id, r.writer_id, r.contents, date_format(r.created_date, '%Y-%m-%d') from used_goods_reply r
    left join used_goods_board b
    on r.board_id = b.board_id
    where left(b.created_date, 7) = '2022-10'
    order by r.created_date, b.title