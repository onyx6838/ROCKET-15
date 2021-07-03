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
CREATE OR REPLACE VIEW vw_ContenTren18Tu
AS
SELECT 	LENGTH(Content)
FROM	Question
WHERE	LENGTH(Content) > 18;
SELECT * FROM vw_ContenTren18Tu;
DROP VIEW vw_ContenTren18Tu;

-- Ques4 Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
CREATE OR REPLACE VIEW Ques4