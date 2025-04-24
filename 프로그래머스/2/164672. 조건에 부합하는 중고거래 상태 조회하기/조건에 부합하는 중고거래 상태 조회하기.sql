select board_id, writer_id, title, price, if(status = 'SALE', '판매중', if(status = 'RESERVED', '예약중', '거래완료'))
from used_goods_board
where created_date = '2022-10-05'
order by board_id desc
