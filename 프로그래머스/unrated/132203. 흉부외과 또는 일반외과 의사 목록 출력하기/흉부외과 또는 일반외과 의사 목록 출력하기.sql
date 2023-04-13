-- 코드를 입력하세요
SELECT dr_name, dr_id, mcdp_cd, left(hire_ymd, 10) from doctor where mcdp_cd = 'CS' or mcdp_cd = 'GS' order by hire_ymd desc, dr_name