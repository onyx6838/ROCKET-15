/*Ques1*/
DROP TRIGGER IF EXISTS Ques1;
DELIMITER$$
CREATE TRIGGER Ques1 BEFORE INSERT ON `group`
FOR EACH ROW
BEGIN
	IF YEAR(NOW()) - YEAR(NEW.CreateDate) > 1
		THEN SIGNAL SQLSTATE '02000' SET MESSAGE_TEXT = 'Warning: Dont create before 1 year ago ! ';
  END IF;
END $$
DELIMITER ;

INSERT INTO `group`(`GroupID`, `GroupName`, `CreatorID`, `CreateDate`) VALUES 
(11, 'Testing System', 5, '2019-03-05 00:00:00');

/*Ques2 Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào
department "Sale" nữa, khi thêm thì hiện ra thông báo "Department
"Sale" cannot add more user*/

DROP TRIGGER IF EXISTS Ques2;
DELIMITER$$
CREATE TRIGGER Ques2 BEFORE INSERT ON `account`
FOR EACH ROW
BEGIN
	IF NEW.DepartmentID = 2
		THEN SIGNAL SQLSTATE '02000' SET MESSAGE_TEXT = 'Warning: cannot add more user to department "Sale" ! ';
  END IF;
END $$
DELIMITER ;

/*Ques3 Cấu hình 1 group có nhiều nhất là 5 user*/
DROP TRIGGER IF EXISTS Ques3;
DELIMITER$$
CREATE TRIGGER Ques3 BEFORE INSERT ON `groupaccount`
FOR EACH ROW
BEGIN
  DECLARE count_gr_acc int;
	SET count_gr_acc := (SELECT COUNT(gc.AccountID) from `groupaccount` gc WHERE gc.GroupID = NEW.GroupID);
	IF count_gr_acc = 5
		THEN SIGNAL SQLSTATE '02000' SET MESSAGE_TEXT = 'Warning: cannot add more user to group, max 5 users ! ';
  END IF;
END $$
DELIMITER ;

INSERT INTO `groupaccount`(`GroupID`, `AccountID`, `JoinDate`) VALUES
(1, 4, '2019-03-05 00:00:00');

/*Ques4 Cấu hình 1 bài thi có nhiều nhất là 10 Question*/
DROP TRIGGER IF EXISTS Ques4_For_Insert;
DELIMITER$$
CREATE TRIGGER Ques4_For_Insert BEFORE INSERT ON `examquestion`
FOR EACH ROW
BEGIN
  DECLARE count_ques_each_exam int;
	SET count_ques_each_exam := (SELECT COUNT(eq.QuestionID) from `examquestion` eq WHERE eq.ExamID = NEW.ExamID);
	IF count_ques_each_exam = 2
		THEN SIGNAL SQLSTATE '02000' SET MESSAGE_TEXT = 'Warning: max 10 question ! ';
  END IF;
END $$
DELIMITER ;

INSERT INTO `examquestion`(`ExamID`, `QuestionID`) VALUES
(8, 2);

/*Ques5 Tạo trigger không cho phép người dùng xóa tài khoản có email là
admin@gmail.com (đây là tài khoản admin, không cho phép user xóa),
còn lại các tài khoản khác thì sẽ cho phép xóa và sẽ xóa tất cả các thông
tin liên quan tới user đó*/
DROP TRIGGER IF EXISTS Ques5;
DELIMITER$$
CREATE TRIGGER Ques5 BEFORE DELETE ON `account`
FOR EACH ROW
BEGIN
	DECLARE id_delete_multi_table int;
  IF OLD.Email = 'admin@gmail.com' THEN 
	  SIGNAL SQLSTATE '02000' SET MESSAGE_TEXT = 'Warning: cannot delete admin email account ! ';
	ELSE
		/* check table delete WHERE id = id_delete_multi_table*/
		/*co constraint chua lm*/
	  SIGNAL SQLSTATE '01000' SET MESSAGE_TEXT = 'Lower than 50';
  END IF;
END $$
DELIMITER;

DELETE FROM account WHERE Username = 'mink.giang';

INSERT INTO `testingsystem_assignment_6`.`account`(`AccountID`, `Email`, `Username`, `Fullname`, `DepartmentID`, `PositionID`, `CreateDate`) VALUES (12, 'mink.giang@gmail.com', 'mink.giang', 'Doan Minh Giang', 10, 1, '2021-07-06');

/*Ques6 Không sử dụng cấu hình default cho field DepartmentID của table
Account, hãy tạo trigger cho phép người dùng khi tạo account không điền
vào departmentID thì sẽ được phân vào phòng ban "waiting Department"*/
DROP TRIGGER IF EXISTS trigger_create_account;
DELIMITER $$
CREATE TRIGGER trigger_create_account
	BEFORE INSERT ON `Account`
	FOR EACH ROW
	BEGIN
	DECLARE WaitingDepartment_ID TINYINT UNSIGNED;
		SELECT DepartmentID INTO WaitingDepartment_ID
					FROM Department
					WHERE DepartmentName = 'Phòng chờ';
	IF NEW.DepartmentID IS NULL
			THEN SET NEW.DepartmentID = WaitingDepartment_ID;
	END IF;
END $$
	DELIMITER ;
	
-- Question 7: Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 4 answers cho mỗi
-- question, trong đó có tối đa 2 đáp án đúng.
DROP TRIGGER IF EXISTS trigger_create_answer;
DELIMITER $$
CREATE TRIGGER trigger_create_answer
BEFORE INSERT ON Answer
FOR EACH ROW
BEGIN
	DECLARE NumberAnswer TINYINT UNSIGNED;
	DECLARE NumberCorrectAnswer TINYINT UNSIGNED;
		SELECT COUNT(AnswerID) INTO NumberAnswer
		FROM Answer
		WHERE QuestionID = New.QuestionID;
		
		SELECT COUNT(AnswerID) INTO NumberCorrectAnswer
		FROM Answer
		WHERE QuestionID = New.QuestionID AND isCorrect = 'Yes';
		
	IF NumberAnswer >=4 OR NumberCorrectAnswer>=2 THEN 
	SIGNAL SQLSTATE '12345'
	SET MESSAGE_TEXT = 'Cannot insert data';
	END IF;
   
END $$
DELIMITER ;

-- Question 8: Viết trigger sửa lại dữ liệu cho đúng: nếu người dùng nhập vào gender
-- của account là nam, nữ, chưa xác định thì sẽ đổi lại thành M, F, U cho giống với cấu
-- hình ở database
DROP TRIGGER IF EXISTS Auto_Gender_Update;
DELIMITER $$
CREATE TRIGGER Auto_Gender_Update
BEFORE INSERT ON `Account`
FOR EACH ROW
BEGIN
      IF NEW.Gender = 'Nam' THEN
         SET NEW.Gender = 'M';
	  ELSEIF NEW.Gender = 'Nu' THEN
         SET NEW.Gender = 'F';
	  ELSEIF NEW.Gender = 'Chưa xác định' THEN
         SET NEW.Gender = 'U';
	  END IF ;
END $$
DELIMITER ;
-- Question 9: Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày
DROP TRIGGER IF EXISTS Delete_Exam;
DELIMITER $$
CREATE TRIGGER Delete_Exam
BEFORE DELETE ON Exam
FOR EACH ROW
BEGIN
      IF (NEW.CreateDate = DATE_SUB(NOW(),INTERVAL 2 DAY)) THEN
         SIGNAL SQLSTATE '12345'
         SET MESSAGE_TEXT = 'Không được xóa Exam vừa tạo 2 ngày trước';
	  END IF ;
END $$
DELIMITER ;
-- Question 12: Lấy ra thông tin exam trong đó
-- Duration <= 30 thì sẽ đổi thành giá trị "Short time"
-- 30 < duration <= 60 thì sẽ đổi thành giá trị "Medium time"
-- duration >60 thì sẽ đổi thành giá trị "Long time"
SELECT ExamID,
		CASE 
			WHEN Duration <= 30 THEN 'Short time'
            WHEN Duration <= 60 AND Duration >30 THEN 'Medium time'
            ELSE 'Longtime'
		END AS ExamDuration
FROM Exam;
-- Question 13: Thống kê số account trong mỗi group và in ra thêm 1 column nữa có tên
-- là the_number_user_amount và mang giá trị được quy định như sau:
-- Nếu số lượng user trong group =< 5 thì sẽ có giá trị là few
-- Nếu số lượng user trong group <= 20 và > 5 thì sẽ có giá trị là normal
-- Nếu số lượng user trong group > 20 thì sẽ có giá trị là higher
SELECT GroupID, 
		CASE
			WHEN COUNT(AccountID) <=5 THEN 'Few'
            WHEN COUNT(AccountID) <=20 AND COUNT(AccountID)>5 THEN 'Normal'
            ELSE 'Higher'
		END AS the_number_user_amount
FROM GroupAccount
GROUP BY GroupID;
-- Question 14: Thống kê số mỗi phòng ban có bao nhiêu user, nếu phòng ban nào
-- không có user thì sẽ thay đổi giá trị 0 thành "Không có User"

SELECT d.DepartmentName,
		CASE
			WHEN COUNT(a.AccountID) = 0 THEN 'Khong co User'
            ELSE COUNT(a.AccountID)
		END AS Number_of_Account
FROM Department d
JOIN `Account` a ON d.DepartmentID = a.DepartmentID
GROUP BY d.DepartmentName;