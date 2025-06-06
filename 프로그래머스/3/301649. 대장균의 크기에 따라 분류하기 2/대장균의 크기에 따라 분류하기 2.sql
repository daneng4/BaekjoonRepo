-- 코드를 작성해주세요
select a.id, 
case
    when a.per <= 0.25 then 'CRITICAL'
    when a.per <= 0.50 then 'HIGH'
    when a.per <= 0.75 then 'MEDIUM'
    else 'LOW'
end as colony_name
from (
    select id, percent_rank() over (order by size_of_colony desc) as per
    from ecoli_data
) as a
order by id
