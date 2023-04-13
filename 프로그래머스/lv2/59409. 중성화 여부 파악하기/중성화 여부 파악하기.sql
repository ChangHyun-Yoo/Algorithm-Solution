-- 코드를 입력하세요
SELECT animal_id, name, if(left(sex_upon_intake, 8) = 'Neutered' or left(sex_upon_intake, 6) = 'Spayed', 'O', 'X') as '중성화' from animal_ins order by animal_id