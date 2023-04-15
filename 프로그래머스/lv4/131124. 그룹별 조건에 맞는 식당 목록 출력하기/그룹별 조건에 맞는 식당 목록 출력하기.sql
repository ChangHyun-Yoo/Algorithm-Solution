-- 코드를 입력하세요
select m.member_name, r.review_text, date_format(r.review_date, '%Y-%m-%d') from rest_review r
    left join member_profile m
    on r.member_id = m.member_id
    where r.member_id =
    (SELECT member_id from rest_review
    group by member_id
    order by count(member_id) desc
    limit 1)
    order by r.review_date, r.review_text