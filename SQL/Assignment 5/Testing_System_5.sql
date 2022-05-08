-- Ques1
CREATE view ques1 
AS
SELECT a.accountid,
	 a.email,
	 a.username,
	 a.fullname,
	 d.departmentname
FROM   `account` a
			 JOIN department d ON a.departmentid = d.departmentid
WHERE  d.departmentname = N'Sale'; 

-- Ques2 Tạo view có chứa thông tin các account tham gia vào nhiều group nhất
CREATE OR REPLACE view ques2
AS
SELECT groupaccount.accountid
FROM   groupaccount
GROUP  BY groupaccount.accountid
HAVING Count(groupaccount.groupid) = (SELECT Count(ga.groupid)
																			FROM   groupaccount ga
																			GROUP  BY ga.accountid
																			ORDER  BY Count(ga.groupid) DESC
																			LIMIT  1) 
-- Ques3
CREATE OR REPLACE VIEW vw_Conten18Tu
AS
SELECT 	LENGTH(Content)
FROM	Question
WHERE	LENGTH(Content) > 18;
SELECT * FROM vw_Conten18Tu;
DROP VIEW vw_Conten18Tu;

-- Ques4 Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
CREATE OR REPLACE VIEW Ques4
AS
SELECT d.*
FROM   account a
       JOIN department d ON a.departmentid = d.departmentid
GROUP  BY a.departmentid
HAVING Count(a.accountid) = (SELECT COUNT(a.accountid)
                             FROM   account a
                             GROUP  BY a.departmentid
                             ORDER  BY COUNT(a.accountid) DESC
                             LIMIT  1) 
														 
-- Ques5
CREATE OR REPLACE VIEW Ques5
AS
SELECT q.*,
       a.Fullname
FROM   question q
       JOIN account a ON q.creatorid = a.accountid
WHERE  SUBSTRING_INDEX(a.fullname, ' ', 1) LIKE N'Nguyen'
