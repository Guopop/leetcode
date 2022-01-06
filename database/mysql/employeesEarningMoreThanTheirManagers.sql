-- +----+-------+--------+-----------+
-- | Id | Name  | Salary | ManagerId |
-- +----+-------+--------+-----------+
-- | 1  | Joe   | 70000  | 3         |
-- | 2  | Henry | 80000  | 4         |
-- | 3  | Sam   | 60000  | NULL      |
-- | 4  | Max   | 90000  | NULL      |
-- +----+-------+--------+-----------+
-- 给定 Employee 表，编写一个 SQL 查询，该查询可以获取收入超过他们经理的员工的姓名。
-- 在上面的表格中，Joe 是唯一一个收入超过他的经理的员工。
select
  t1.Name as Employee
from
  Employee t1
  inner join Employee t2 on t1.ManagerId = t2.Id
where
  t1.Salary > t2.Salary;
