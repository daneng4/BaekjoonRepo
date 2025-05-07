select first_half.flavor
from icecream_info join first_half
on icecream_info.flavor = first_half.flavor
where first_half.total_order > 3000 and icecream_info.ingredient_type = 'fruit_based'
order by total_order desc