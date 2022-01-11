-- 请编写一个SQL查询来查找至少有5名直接下属的经理。
select
  e1.Name
from
  Employee e1
where
  (
    select
      count(*)
    from
      Employee e2
    where
      e1.Id = e2.ManagerId
  ) >= 5;