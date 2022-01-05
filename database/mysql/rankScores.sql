-- 编写一个 SQL 查询来实现分数排名。
-- 如果两个分数相同，则两个分数排名（Rank）相同。请注意，平分后的下一个名次应该是下一个连续的整数值。换句话说，名次之间不应该有“间隔”。
select
  t1.Score as score,
  (
    select
      count(distinct t2.Score)
    from
      Scores t2
    where
      t2.Score >= t1.Score
  ) as 'rank'
from
  Scores t1
order by
  t1.Score desc

