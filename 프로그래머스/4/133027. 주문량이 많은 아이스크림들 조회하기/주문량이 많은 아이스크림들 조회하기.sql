-- 코드를 입력하세요

select f.flavor
from first_half f 
    inner join (select flavor, sum(total_order) as july_total_order
                from july
                group by flavor) j
    on f.flavor = j.flavor
order by total_order + july_total_order desc
limit 3;


