use testingsystem_assignment_4;
-- Ques1 
-- nhan vien k co phong ban -> LEFT JOIN
select a.Username,a.Fullname,d.DepartmentName from `account` a LEFT JOIN department d ON a.DepartmentID = d.DepartmentID;

-- Ques2
SELECT a.Username,a.Fullname,d.DepartmentName,p.PositionName from `account` a 
LEFT JOIN department d ON a.DepartmentID = d.DepartmentID
LEFT JOIN `position` p ON a.PositionID = p.PositionID
WHERE a.CreateDate > '2020-12-20';

-- Ques4
SELECT d.DepartmentID,d.DepartmentName,COUNT(1) from `account` a JOIN department d ON a.DepartmentID = d.DepartmentID
GROUP BY d.DepartmentID
HAVING COUNT(1) > 1;

-- Ques5
SELECT e.Title,COUNT(eq.QuestionID) from exam e
JOIN examquestion eq ON e.ExamID = eq.ExamID 
GROUP BY QuestionID
ORDER BY COUNT(eq.QuestionID) DESC
LIMIT 1;

-- Ques6
SELECT q.QuestionID,q.Content,COUNT(QuestionID) sl from question q
JOIN categoryquestion cq ON q.CategoryID = cq.CategoryID
GROUP BY q.CategoryID
ORDER BY q.QuestionID;

-- Ques7
SELECT examquestion.QuestionID,COUNT(ExamID) from examquestion 
GROUP BY QuestionID;

-- Ques8
SELECT a.questionid,
       q.content,
       Count(a.answerid)
FROM   question q
       JOIN answer a ON q.questionid = a.questionid
GROUP  BY a.questionid
HAVING Count(a.answerid) = (SELECT Count(a.answerid)
                            FROM   answer a
                            GROUP  BY a.questionid
                            ORDER  BY Count(a.answerid) DESC
                            LIMIT  1) 
-- Ques9
SELECT *, COUNT(1) sl from groupaccount
GROUP BY GroupID;

-- Ques10
SELECT *
FROM   position
WHERE  positionid = (SELECT p.positionid
                     FROM   position p
                            LEFT JOIN account a ON p.positionid = a.positionid
                     GROUP  BY p.positionid
                     ORDER  BY Count(a.accountid) ASC
                     LIMIT  1) 

-- Ques11 Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM (Pivot,cross)
SELECT a.DepartmentID,COUNT(a.AccountID),GROUP_CONCAT(DISTINCT(p.PositionName)) from account a
JOIN position p ON a.PositionID = p.PositionID
GROUP BY a.DepartmentID;

-- cross
SELECT t.departmentname,
       t.positionname,
       Count(t.accountid) AS employee
FROM   (SELECT a.departmentname,
               b.positionname,
							 c.accountid
        FROM   department a
               CROSS JOIN position b
               LEFT JOIN account c ON a.departmentid = c.departmentid AND b.positionid = c.positionid
        ORDER  BY departmentname,
                  positionname) t
GROUP  BY t.departmentname,
          t.positionname; 

-- Ques12
/*Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của
question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, …*/
SELECT q.questionid,
       q.content,
       q.categoryid,
       cq.categoryname,
       acc.fullname,
       a.content ans
FROM   question q
       JOIN answer a ON q.questionid = a.questionid
       JOIN categoryquestion cq ON cq.categoryid = q.categoryid
       JOIN account acc ON q.creatorid = acc.accountid; 

-- Ques13 Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
SELECT q.TypeID,tq.TypeName,COUNT(1) from question q
JOIN typequestion tq ON q.TypeID = tq.TypeID
GROUP BY tq.TypeID;

-- Ques14 Lấy ra group không có account nào
SELECT g.GroupID,g.GroupName,COUNT(gc.AccountID) from `group` g
LEFT JOIN groupaccount gc ON g.GroupID = gc.GroupID
GROUP BY g.GroupID
HAVING COUNT(gc.AccountID) = 0;

-- Ques 15
SELECT *,COUNT(a.AnswerID) from question q
LEFT JOIN answer a ON q.QuestionID = a.QuestionID
GROUP BY q.QuestionID
HAVING COUNT(a.AnswerID) = 0;

-- Ques17
SELECT * from groupaccount g WHERE GroupID = 1
UNION
SELECT * from groupaccount g WHERE GroupID = 2;

-- Ques18
SELECT g.GroupID, COUNT(1) sl from groupaccount g GROUP BY g.GroupID 
HAVING COUNT(1) < 2
UNION
SELECT g.GroupID, COUNT(1) sl from groupaccount g GROUP BY g.GroupID 
HAVING COUNT(1) >= 2;
