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
	IF CHAR_LENGTH(in_group) > 0 THEN
		SELECT g.GroupName
		from   `group` g
		WHERE  g.GroupName LIKE in_group; 
	ELSE
		SELECT a.Username
		from   account a
		WHERE  a.Username LIKE in_account; 
	END IF;
END $$
DELIMITER;


/*Ques7 Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và trong store sẽ tự động gán: 
username sẽ giống email nhưng bỏ phần @..mail đi
positionID: sẽ có default là developer
departmentID: sẽ được cho vào 1 phòng chờ
Sau đó in ra kết quả tạo thành công*/
DELIMITER $$
CREATE PROCEDURE Ques7(in in_full_name VARCHAR(50),IN in_email VARCHAR(50))
BEGIN
	DECLARE p_username VARCHAR(50) DEFAULT ''; 
	DECLARE p_PositionID int DEFAULT 0;
	DECLARE p_DepartmentID int DEFAULT 0;
	DECLARE p_CreateDate date DEFAULT CURDATE();
	SET p_username = SUBSTRING_INDEX(in_email,'@',1);
	SET p_PositionID = 1;
	SET p_DepartmentID = 10;
	
	insert into account (Email,Username,Fullname,DepartmentID,PositionID,CreateDate) VALUES
	(in_email,p_username,in_full_name,p_DepartmentID,p_PositionID,p_CreateDate);
	
	SELECT * from account a
	WHERE a.username = username;
END $$
DELIMITER;

call Ques7('Doan Minh Giang','mink.giang@gmail.com');


/*Ques8 Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice
để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất*/
DELIMITER $$
CREATE PROCEDURE Ques8(in in_type_name VARCHAR(50))
BEGIN
	if (in_type_name = 'Essay') THEN
		SELECT q.Content, MAX(CHAR_LENGTH(q.Content)) from question q
		WHERE q.TypeID = 1;
	ELSEIF (in_type_name = 'Multiple-Choice') THEN
		SELECT q.Content, MAX(CHAR_LENGTH(q.Content)) from question q
		WHERE q.TypeID = 2;
  END IF;
END $$
DELIMITER;

/*Ques9 Viết 1 store cho phép người dùng xóa exam dựa vào ID*/
DELIMITER $$
CREATE PROCEDURE Ques9(in in_id_exam VARCHAR(50))
BEGIN
	DELETE 	
  FROM 	Exam 
  WHERE	ExamID = in_ExamID;	
  SELECT * FROM Exam;
END $$
DELIMITER;

/*Ques10 Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử dụng store ở câu 9 để xóa)
Sau đó in số lượng record đã remove từ các table liên quan trong khi removing*/
DELIMITER $$
CREATE PROCEDURE Ques10()
BEGIN
	DELETE
	FROM   exam
	WHERE  examid =
							(SELECT examid
               FROM   exam
               WHERE  (Year(Now()) - Year(createdate)) > 3);
END $$
DELIMITER;

/*Question 11: Viết store cho phép người dùng xóa phòng ban bằng cách người dùng
nhập vào tên phòng ban và các account thuộc phòng ban đó sẽ được
chuyển về phòng ban default là phòng ban chờ việc*/
DELIMITER $$
CREATE PROCEDURE Ques11(in in_dept_name VARCHAR(50))
BEGIN
	UPDATE account
  SET    departmentid = 10
  WHERE  departmentid =
       (
				SELECT departmentid
				FROM   department d
				WHERE  d.departmentname = in_dept_name);
	DELETE 	
  FROM 	department d
  WHERE	d.DepartmentName = in_dept_name;
END $$
DELIMITER;

/*Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm nay */
DELIMITER $$
CREATE PROCEDURE Ques12()
BEGIN
	SELECT statics.month, COUNT(q.QuestionID) sl
	FROM
	(
			 SELECT 1 AS MONTH
			 UNION SELECT 2 AS MONTH
			 UNION SELECT 3 AS MONTH
			 UNION SELECT 4 AS MONTH
			 UNION SELECT 5 AS MONTH
			 UNION SELECT 6 AS MONTH
			 UNION SELECT 7 AS MONTH
			 UNION SELECT 8 AS MONTH
			 UNION SELECT 9 AS MONTH
			 UNION SELECT 10 AS MONTH
			 UNION SELECT 11 AS MONTH
			 UNION SELECT 12 AS MONTH
	) as statics
	LEFT JOIN question q ON statics.month = MONTH(q.CreateDate)
	GROUP BY statics.month;
END $$
DELIMITER;

/*Ques13 Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6
tháng gần đây nhất
(Nếu tháng nào không có thì sẽ in ra là "không có câu hỏi nào trong
tháng") */
