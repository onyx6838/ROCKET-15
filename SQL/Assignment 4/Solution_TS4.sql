use testingsystem_assignment_4;

SELECT * FROM account;
-- cách 1 nối:
SELECT
	  b.DepartmentName,
    c.PositionName,
    count(a.AccountID) As total_employee
FROM
	account a
    INNER JOIN department b ON a.DepartmentID = b.DepartmentID
    INNER JOIN position c ON a.PositionID = c.PositionID
GROUP BY
	b.DepartmentName,
    c.PositionName;
    
-- Cách 2 Subquery 
SELECT 
	-- a.DepartmentID,
    (SELECT DepartmentName FROM Department WHERE DepartmentID = a.DepartmentID) AS DepartmentName,
	-- a.PositionID,
    (SELECT PositionName FROM position WHERE PositionID = a.PositionID) AS PositionName,
    count(*) AS total_employee
FROM 
	account a 
GROUP BY
	a.DepartmentID,
    a.PositionID;

-- cross join
-- Bước 1: Tạo khung bảng 
CREATE VIEW ResultQ11 AS
SELECT
	b.DepartmentName,
    c.PositionName,
    count(a.AccountID) As total_employee
FROM
	account a
    INNER JOIN department b ON a.DepartmentID = b.DepartmentID
    INNER JOIN position c ON a.PositionID = c.PositionID
GROUP BY
	b.DepartmentName,
    c.PositionName;


SELECT 
	t.DepartmentName, t.PositionName,
	CASE WHEN t.total > 0 then t.total ELSE 0 END AS total
FROM 
(SELECT 
	a.DepartmentName,
    b.PositionName,
    (select total_employee FROM ResultQ11 WHERE DepartmentName = a.DepartmentName AND PositionName = b.PositionName) AS total
FROM 
	Department a 
    CROSS JOIN Position b 
ORDER BY DepartmentName, PositionName) t ;
-- -----------------------------------------------------
SELECT 
	t.DepartmentName, t.PositionName, count(t.AccountID) AS employee
FROM
(SELECT 
	a.DepartmentName,
    b.PositionName,
		c.AccountID
FROM 
	Department a 
    CROSS JOIN Position b 
    LEFT JOIN Account c ON  a.DepartmentID = c.DepartmentID AND b.PositionID = c.PositionID
ORDER BY DepartmentName, PositionName) t
GROUP BY t.DepartmentName, t.PositionName;




