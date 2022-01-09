-- 编写一个 SQL 查询，来查找与之前（昨天的）日期相比温度更高的所有日期的 id 。
-- 返回结果 不要求顺序 。
select
  w2.id
from
  Weather w1,
  Weather w2
where
  datediff(w2.recordDate, w1.recordDate) = 1
  and w1.Temperature < w2.Temperature;