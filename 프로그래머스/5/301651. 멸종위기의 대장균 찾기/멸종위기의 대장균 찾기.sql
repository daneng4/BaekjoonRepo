-- 코드를 작성해주세요
with recursive tmp as (
    #non recursive 문장
    select id, parent_id, 1 as generation
    from ecoli_data
    where parent_id is null
    union all
    #recursive 문장
    select s.id, s.parent_id, tmp.generation + 1
    from tmp join ecoli_data s
    on tmp.id = s.parent_id
)

select count(*) as count, generation
from tmp
where id not in (
        select parent_id
        from tmp
        where parent_id is not null)
group by generation
order by 2;