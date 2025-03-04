-- 코드를 작성해주세요
-- 연도별 가장 큰 대장균의 크기 어떻게 구할거? group by year? 해서 max?
-- group by year 하고 각 연도별 max를 구한뒤에 연도가 일치하는 row들을 max-size한다?
select year(differentiation_date) as year, (
    select max(size_of_colony) from ecoli_data
    where year(differentiation_date) = year
) - size_of_colony as year_dev, id
from ecoli_data
order by year, year_dev;