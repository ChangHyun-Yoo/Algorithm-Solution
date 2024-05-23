select b.board_id, b.writer_id, b.title, b.price, if(b.status = 'SALE', '판매중', if(b.status = 'DONE', '거래완료', '예약중')) as status from used_goods_board b
where left(b.created_date, 10) = '2022-10-05'
order by b.board_id desc