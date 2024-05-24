select mcdp_cd as '진료과 코드', count(*) as '5월예약건수' from appointment
where left(apnt_ymd, 7) = '2022-05'
group by mcdp_cd
order by count(*), mcdp_cd