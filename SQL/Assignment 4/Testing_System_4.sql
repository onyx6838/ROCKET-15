use testingsystem_assignment_4;
-- Ques1 
-- nhan vien k co phong ban -> LEFT JOIN
SELECT a.username,
       a.fullname,
       d.departmentname
FROM   `account` a
       LEFT JOIN department d ON a.departmentid = d.departmentid; 
-- Ques2
SELECT a.username,
       a.fullname,
       d.departmentname,
       p.positionname
FROM   `account` a
       LEFT JOIN department d ON a.departmentid = d.departmentid
       LEFT JOIN `position` p ON a.positionid = p.positionid
WHERE  a.createdate > '2020-12-20';

-- Ques4
SELECT d.departmentid,
       d.departmentname,
       Count(1)
FROM   `account` a
       JOIN department d ON a.departmentid = d.departmentid
GROUP  BY d.departmentid
HAVING Count(1) > 1; 

-- Ques5 Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất
SELECT e.title,
       Count(eq.questionid)
FROM   exam e
       JOIN examquestion eq ON e.examid = eq.examid
GROUP  BY questionid
ORDER  BY Count(eq.questionid) DESC
LIMIT  1;

-- count content ??
SELECT Q.questionid,
       Q.content,
       Q.categoryid,
       Q.typeid,
       Q.creatorid,
       Q.createdate,
       Count(Q.content) AS 'SO LUONG'
FROM   question Q
       JOIN examquestion EQ ON Q.questionid = EQ.questionid
GROUP  BY Q.content
HAVING Count(Q.content) = (SELECT Max(MaxQues.countques)
                           FROM   (SELECT Count(eq.questionid) CountQues
                                   FROM   examquestion eq
                                          JOIN question q ON eq.questionid = q.questionid
                                   GROUP  BY q.questionid) MaxQues) 

-- Ques6
SELECT cq.categoryid,
       cq.categoryname,
       Count(q.questionid) sl
FROM   categoryquestion cq
       LEFT JOIN question q ON cq.categoryid = q.categoryid
GROUP  BY cq.categoryid
ORDER  BY Count(q.questionid) ASC;

-- Ques7 Thông kê mỗi Question được sử dụng trong bao nhiêu Exam
SELECT q.content,
       Count(eq.questionid)
FROM   question q
       LEFT JOIN examquestion eq ON eq.questionid = q.questionid
GROUP  BY q.questionid;

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
                            LIMIT  1);

-- Ques9
SELECT g.groupid,
       g.groupname,
       Count(ga.accountid) sl
FROM   groupaccount ga
       RIGHT JOIN `group` g ON ga.groupid = g.groupid
GROUP  BY g.groupid; 

-- Ques10
SELECT p.PositionID,
       p.PositionName,
       Count(a.AccountID) slnv
FROM   account a
       RIGHT JOIN position p ON a.PositionID = p.PositionID
GROUP  BY p.PositionID
HAVING Count(a.AccountID) = (SELECT Min(MinAccPos.countaccpos)
                             FROM   (SELECT Count(a.AccountID) CountAccPos
                                     FROM   position p
                                            LEFT JOIN account a ON p.PositionID = a.PositionID
                                     GROUP  BY p.PositionID) MinAccPos);

-- Ques11 Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM (Pivot,cross)
SELECT a.departmentid,
       Count(a.accountid),
       Group_concat(DISTINCT(p.positionname))
FROM   account a
       JOIN position p ON a.positionid = p.positionid
GROUP  BY a.departmentid; 

-- cross
SELECT a.DepartmentName,
       b.PositionName,
       IFNULL(Count(c.AccountID), 0)
FROM   department a
       CROSS JOIN position b
       LEFT JOIN account c ON a.DepartmentID = c.DepartmentID
                 AND b.positionid = c.positionid
GROUP  BY a.DepartmentID,
          b.PositionName
ORDER  BY a.DepartmentName,
          b.PositionName

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
SELECT q.typeid,
       tq.typename,
       Count(1)
FROM   question q
       JOIN typequestion tq ON q.typeid = tq.typeid
GROUP  BY tq.typeid; 

-- Ques14 Lấy ra group không có account nào
SELECT g.groupid,
       g.groupname,
       Count(gc.accountid)
FROM   `group` g
       LEFT JOIN groupaccount gc ON g.groupid = gc.groupid
GROUP  BY g.groupid
HAVING Count(gc.accountid) = 0; 

-- Ques 15
SELECT *,
       Count(a.answerid)
FROM   question q
       LEFT JOIN answer a ON q.questionid = a.questionid
GROUP  BY q.questionid
HAVING Count(a.answerid) = 0; 

-- Ques17
SELECT * from groupaccount g WHERE GroupID = 1
UNION
SELECT * from groupaccount g WHERE GroupID = 2;

-- Ques18
SELECT g.groupid,
       Count(1) sl
FROM   groupaccount g
GROUP  BY g.groupid
HAVING Count(1) < 2

UNION

SELECT g.groupid,
       Count(1) sl
FROM   groupaccount g
GROUP  BY g.groupid
HAVING Count(1) >= 2; 
