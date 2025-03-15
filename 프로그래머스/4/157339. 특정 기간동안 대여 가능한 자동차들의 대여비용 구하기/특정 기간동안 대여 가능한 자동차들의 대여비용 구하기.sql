select c.car_id as car_id, c.car_type as car_type,
        round(c.daily_fee*30*(100-p.discount_rate)/100) as fee
from car_rental_company_car c
        join car_rental_company_rental_history h on c.car_id = h.car_id
        join car_rental_company_discount_plan p on c.car_type = p.car_type
where c.car_id not in (
    select car_id
    from car_rental_company_rental_history
    where end_date >= '2022-11-01' and start_date <= '2022-12-01'
) and p.duration_type like '30%'
group by c.car_id
having c.car_type in ('세단', 'SUV') and (fee >= 500000 and fee < 2000000)
order by fee desc, car_type, car_id desc