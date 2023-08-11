SELECT 
    year(a.sales_date) as year
    , month(a.sales_date) as month
    , count(distinct a.user_id) as PUCHASED_USERS
    , round(1.00*count(distinct a.user_id)/
            (select count(distinct user_id) from USER_INFO where year(joined) = 2021),1)
            as PUCHASED_RATIO
from ONLINE_SALE a
join USER_INFO b on a.user_id = b.user_id
where year(b.joined) = 2021
group by 1, 2
order by 1, 2
