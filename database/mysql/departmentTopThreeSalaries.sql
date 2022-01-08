-- Employee 表包含所有员工信息，每个员工有其对应的工号 Id，姓名 Name，工资 Salary 和部门编号 DepartmentId 。
-- Department 表包含公司所有部门的信息。
-- 编写一个 SQL 查询，找出每个部门获得前三高工资的所有员工。
select
  d.Name Department,
  e.Name Employee,
  e.Salary
from
  Employee e
  inner join Department d on e.DepartmentId = d.Id
where
  3 > (
    select
      count(distinct ei.Salary)
    from
      Employee ei
    where
      ei.Salary > e.Salary
      and ei.DepartmentId = e.DepartmentId
  );