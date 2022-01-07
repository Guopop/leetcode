-- Employee 表包含所有员工信息，每个员工有其对应的 Id, salary 和 departm
-- Department 表包含公司所有部门的信息。
-- 编写一个 SQL 查询，找出每个部门工资最高的员工。对于上述表，您的 SQL 查询应返回以下行（行的顺序无关紧要）。
select
  d.Name Department,
  e.Name Employee,
  e.Salary
from
  Employee e
  inner join Department d on e.DepartmentId = d.Id
where
  (e.DepartmentId, e.Salary) in (
    select
      ei.DepartmentId,
      Max(ei.Salary)
    from
      Employee ei
    group by
      ei.DepartmentId
  );