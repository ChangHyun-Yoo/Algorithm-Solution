select animal_id, name, if(sex_upon_intake like 'Neutered%' or sex_upon_intake like 'Spayed%', 'O', 'X') from animal_ins
order by animal_id