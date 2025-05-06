select info.id, name.fish_name, info.length
from fish_info info join fish_name_info name
on info.fish_type = name.fish_type
where info.fish_type in (
    select fish_type
    from fish_info
    group by fish_type
    having length = max(length)
)
order by id