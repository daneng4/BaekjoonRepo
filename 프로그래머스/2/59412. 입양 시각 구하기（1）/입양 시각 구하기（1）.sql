-- 코드를 입력하세요
SELECT hour(datetime) as hour, count(animal_id) as count
from animal_outs
group by hour
having hour >= 9 and hour < 20
order by hour