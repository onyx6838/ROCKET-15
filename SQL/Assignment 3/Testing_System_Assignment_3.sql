use testingsystem_assignment_3;

-- Ques1 -- file script_data

-- Ques2
select * from department
SELECT * from `account`
-- Ques3
SELECT departmentid
FROM   department
WHERE  departmentname = N'Sale' 
-- Ques4
SELECT *,
       Char_length(fullname)
FROM   account
ORDER  BY Char_length(fullname) DESC
LIMIT  1 
-- sub query for multiple max length name ??
SELECT *,
       Char_length(fullname)
FROM   account
WHERE  Char_length(fullname) = (SELECT Max(Char_length(fullname))
                                FROM   account) 

-- Ques5
SELECT *,
       Char_length(fullname)
FROM   account
WHERE  departmentid = 3
ORDER  BY Char_length(fullname) DESC
LIMIT  1  
 -- sub query for multiple max length name ??
SELECT *,
       Char_length(fullname)
FROM   account
WHERE  departmentid = 3
       AND Char_length(fullname) = (SELECT Max(Char_length(fullname))
                                    FROM   account) 
 -- Ques6
select * from `group` WHERE CreateDate < '2019-12-20'

-- Ques7
SELECT QuestionID,
       Count(QuestionID) AS TotalAnswer
FROM   answer
GROUP  BY QuestionID
HAVING Count(QuestionID) >= 4 

-- Ques8
SELECT * 
FROM  exam 
WHERE  Duration >= 60 AND CreateDate < '2019-12-20'

-- Ques9
SELECT 		* 
FROM 		`Group`
ORDER BY 	CreateDate DESC 
LIMIT 5;

-- Ques10
select COUNT(*) from account WHERE DepartmentID = 2

-- Ques11
-- substring using SEPARATOR
-- count get from 1 to count sub string with LIKE Operator
SELECT *
FROM   account
WHERE  Substring_index(fullname, ' ', -1) LIKE N'D%o' 

-- Ques12
DELETE FROM Exam WHERE CreateDate < '2019-12-20';

-- Ques13
DELETE FROM question WHERE Content LIKE 'Câu hỏi%';

-- Ques14
UPDATE 		`Account` 
SET 		Fullname 	= 	N'Nguyễn Bá Lộc', 
			  Email 		= 	'loc.nguyenba@vti.com.vn'
WHERE 	AccountID = 5;

-- Ques15
UPDATE 		`GroupAccount` 
SET 		AccountID = 5 
WHERE 		GroupID = 4;