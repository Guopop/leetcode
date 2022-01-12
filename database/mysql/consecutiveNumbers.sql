-- 编写一个 SQL 查询，查找所有至少连续出现三次的数字。
-- 返回的结果表中的数据可以按 任意顺序 排列。
select
  distinct num ConsecutiveNums
from
  (
    select
      *,
      row_number() over(
        partition by num
        order by
          id
      ) as rownum,
      row_number() over(
        order by
          id
      ) as id2
    from
      Logs
  ) t
group by
  (id2 - rownum),
  num
having
  count(*) >= 3;