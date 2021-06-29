use testingsystem_assignment_3;

-- Ques1 -- file script_data

-- Ques2
select * from department

-- Ques3
select DepartmentID from department WHERE DepartmentName = N'Sale'

-- Ques4
SELECT *,CHAR_LENGTH(Fullname) from account ORDER BY CHAR_LENGTH(Fullname) DESC LIMIT 1

-- sub query for multiple max length name ??
SELECT *,CHAR_LENGTH(Fullname) from account WHERE CHAR_LENGTH(Fullname) = 
(
	SELECT MAX(CHAR_LENGTH(Fullname)) from account
)

-- Ques5
SELECT *,CHAR_LENGTH(Fullname) from account WHERE DepartmentID = 3 ORDER BY CHAR_LENGTH(Fullname) DESC LIMIT 1
 
 -- sub query for multiple max length name ??
SELECT *,CHAR_LENGTH(Fullname) from account WHERE DepartmentID = 3 AND CHAR_LENGTH(Fullname) = 
(
	SELECT MAX(CHAR_LENGTH(Fullname)) from account
)
 -- Ques6
select * from `group` WHERE CreateDate < '2019-12-20'

-- Ques7
select QuestionID, COUNT(QuestionID) as TotalAnswer from answer GROUP BY QuestionID HAVING COUNT(QuestionID) >= 4

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
select * from account WHERE SUBSTRING_INDEX(Fullname,' ', -1) like N'D%o'

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