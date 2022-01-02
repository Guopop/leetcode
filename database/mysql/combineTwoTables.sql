SELECT t1.FirstName,
     t1.LastName,
     t2.City,
     t2.State
FROM Person t1
LEFT JOIN Address t2
  ON t1.PersonId = t2.PersonId ;