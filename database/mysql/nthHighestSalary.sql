-- 编写一个 SQL 查询，获取 Employee 表中第 n 高的薪水（Salary)
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT BEGIN 
declare m INT;
set m = N -1;
RETURN (
  select
    ifnull(
      (
        select
          distinct Salary
        from
          Employee
        order by
          Salary desc
        limit
          m, 1
      ), null
    )
);
END