-- 写一段 SQL 语句查出 "2013-10-01" 至 "2013-10-03" 期间非禁止用户（乘客和司机都必须未被禁止）的取消率。
-- 非禁止用户即 banned 为 No 的用户，禁止用户即 banned 为 Yes 的用户。
-- 返回结果表中的数据可以按任意顺序组织。其中取消率 Cancellation Rate 需要四舍五入保留 两位小数 。
select
  t.request_at as Day,
  round(
    sum(if(t.status = 'completed', 0, 1)) / count(t.status),
    2
  ) as ` Cancellation Rate `
from
  Trips t
where
  t.client_id not in (
    select
      u1.users_id
    from
      Users u1
    where
      u1.banned = 'Yes'
  )
  and t.driver_id not in (
    select
      u2.users_id
    from
      Users u2
    where
      u2.banned = 'Yes'
  )
  and t.request_at between '2013-10-01' and '2013-10-03'
group by
  t.request_at;