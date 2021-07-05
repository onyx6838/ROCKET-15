/* Ques1 Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các
account thuộc phòng ban đó */
DELIMITER $$
CREATE PROCEDURE getAccountWithDepartment(IN depart_name varchar(50))
BEGIN
  SELECT * FROM account a
  JOIN department d ON a.DepartmentID = d.DepartmentID
  WHERE d.DepartmentName = depart_name;
END $$
DELIMITER;

CALL getAccountWithDepartment('Sale');

/* Ques2 Tạo store để in ra số lượng account trong mỗi group */
DELIMITER $$
CREATE PROCEDURE getAccountEachGroup()
BEGIN
	 SELECT g.groupid,
				  g.groupname,
				  Count(ga.accountid)
	FROM   `group` g
				 LEFT JOIN groupaccount ga ON g.groupid = ga.groupid
	GROUP  BY g.groupid;
END $$
DELIMITER;

CALL getAccountEachGroup();

/*Ques3 Tạo store để thống kê mỗi type question có bao nhiêu question được tạo
trong tháng hiện tại */
DELIMITER $$
CREATE PROCEDURE typeQuestionEachQuestion()
BEGIN
 SELECT q.TypeID,COUNT(q.QuestionID) from question q
 WHERE q.CreateDate = MONTH(NOW())
 GROUP BY q.TypeID;
END $$
DELIMITER;

/* Ques4 Tạo store để trả ra id của type question có nhiều câu hỏi nhất */
DELIMITER $$
CREATE PROCEDURE idTypeQuestionMaxQuestion(OUT out_id_type_question Int)
BEGIN
	SELECT q.TypeID INTO out_id_type_question
	from   question q
	GROUP  BY q.TypeID
	HAVING COUNT(q.QuestionID) = (SELECT q.TypeID
																from   question q
																GROUP  BY q.TypeID
																ORDER BY COUNT(q.QuestionID) DESC
																LIMIT 1);
END $$
DELIMITER;

/* Ques 5 Sử dụng store ở question 4 để tìm ra tên của type question */
DELIMITER $$
CREATE PROCEDURE findNameTypeQuestion()
BEGIN
	SELECT tq.TypeName
	from   question q
	JOIN typequestion tq ON q.TypeID = tq.TypeID
	GROUP  BY q.TypeID
	HAVING COUNT(q.QuestionID) = (SELECT q.TypeID
																from   question q
																GROUP  BY q.TypeID
																ORDER BY COUNT(q.QuestionID) DESC
																LIMIT 1);
END $$
DELIMITER;

/*Ques6 Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên
chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa
chuỗi của người dùng nhập vào */
DELIMITER $$
CREATE PROCEDURE findGroup(in in_group VARCHAR(50),IN in_account VARCHAR(50))
BEGIN
	IF CHAR_LENGTH(in_group) > 0
		SELECT g.GroupName from `group` g
		WHERE g.GroupName LIKE in_group;
	ELSE
		SELECT a.Username from account a
		WHERE a.Username LIKE in_account;
	END IF;
END $$
DELIMITER;