-- 코드를 작성해주세요
select t.id
from ecoli_data t
join ecoli_data s on t.parent_id = s.id
join ecoli_data f on s.parent_id = f.id
where f.parent_id is null
order by id