-- 코드를 작성해주세요
select A.year as year, (B.max - A.size_of_colony) as year_dev, a.id
from 
    (SELECT YEAR(DIFFERENTIATION_DATE) AS YEAR, SIZE_OF_COLONY, ID
    FROM ECOLI_DATA) as A
    join 
    (select year(DIFFERENTIATION_DATE) as year, max(size_of_colony) as max
    from ecoli_data
    group by year(DIFFERENTIATION_DATE)) as B
on A.year = B.year
order by year, year_dev