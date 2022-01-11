-- 请编写SQL查询来查找每个公司的薪水中位数。
select
  a.id,
  a.company,
  a.salary
from
  (
    select
      e.id,
      e.company,
      e.salary,
      row_number() over(
        partition by e.company
        order by
          e.salary
      ) as ranking,
      count(e.id) over(partition by e.company) as cnt
    from
      Employee e
  ) a
where
  a.ranking >= a.cnt / 2
  and a.ranking <= a.cnt / 2 + 1;