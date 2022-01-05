-- 编写一个 SQL 查询，查找所有至少连续出现三次的数字。
-- 返回的结果表中的数据可以按 任意顺序 排列。
SELECT
  DISTINCT Num ConsecutiveNums
FROM
(
    select
      *,
      row_number() over (
        partition by num
        order by
          id
      ) rownum
    from
      logs
  ) t
GROUP BY
  (Id + 1 - rownum),
  Num
HAVING
  COUNT(*) >= 3

 