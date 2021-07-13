/*Ques1*/
drop DATABASE if EXISTS final_exam;
create DATABASE if not EXISTS final_exam;
use final_exam;

drop table if EXISTS Student;
create table Student(
	ID SMALLINT AUTO_INCREMENT PRIMARY KEY,
	`Name` VARCHAR(50),
	`Age` DATETIME DEFAULT NOW(),
	Gender boolean
);

drop table if EXISTS `Subject`;
create table `Subject`(
	ID SMALLINT AUTO_INCREMENT PRIMARY KEY,
	`Name` VARCHAR(50)
);

drop table if EXISTS StudentSubject;
create table StudentSubject(
	StudentID SMALLINT ,
	SubjectID SMALLINT ,
	Mark FLOAT,
	Date VARCHAR(50),
	PRIMARY KEY (StudentID, SubjectID),
	FOREIGN KEY (StudentID) REFERENCES Student(ID),
	FOREIGN KEY (SubjectID) REFERENCES `Subject`(ID)
);

INSERT INTO `student`(`ID`, `Name`, `Age`, `Gender`) 
VALUES 
(1, N'Đoàn Minh Giang', '2021-07-12 19:35:54', 0),
(2, N'Trương Việt Anh', '2021-07-12 19:35:54', 0),
(3, N'Nguyễn Đức Mạnh', '2021-07-12 19:35:54', 0),
(4, N'Nguyễn Văn Đạt', '2021-07-12 19:35:54', 0),
(5, N'Phạm Ngọc Sơn', '2021-07-12 19:35:54', 0),
(6, N'Hoàng Đức Huy', '2021-07-12 19:35:54', 0),
(7, N'Bùi Duy', '2021-07-12 19:35:54', 0);

INSERT INTO `subject`(`ID`, `Name`) VALUES 
(1, 'SQL'),
(2, 'Java'),
(3, 'FE'),
(4, 'BE'),
(5, 'FE - Advance');

INSERT INTO `studentsubject`(`StudentID`, `SubjectID`, `Mark`, `Date`) VALUES 
(1, 1, 7, NULL),
(2, 2, 8, NULL),
(3, 1, 9, NULL),
(4, 4, 6, NULL),
(5, 3, 10, NULL),
(6, 5, 8, NULL),
(7, 3, 8.5, NULL);


/*Ques2.a Lấy tất cả các môn học không có bất kì điểm nào*/
SELECT *
from   `subject` s
WHERE  s.ID NOT IN(SELECT DISTINCT so.SubjectID
                   from   studentsubject so); 
/*Ques2.b Lấy danh sách các môn học có ít nhất 2 điểm */
SELECT *,
       COUNT(so.SubjectID)
from   studentsubject so
GROUP  BY so.SubjectID
HAVING COUNT(so.SubjectID) >= 2;

/*Ques3 Tạo view có tên là "StudentInfo" lấy các thông tin về học sinh bao gồm:
Student ID,Subject ID, Student Name, Student Age, Student Gender,
Subject Name, Mark, Date
(Với cột Gender show 'Male' để thay thế cho 0, 'Female' thay thế cho 1 và
'Unknow' thay thế cho null) */
CREATE OR REPLACE VIEW StudentInfo AS
SELECT s.ID                               StudentID,
       so.SubjectID,
       s.`Name`                           StudentName,
       s.Age                              StudentAge,
       IF(s.Gender = 0, 'Male', 'Female') StudentGender,
       ss.`Name`,
       so.`Mark`,
       so.Date
from   student s
       JOIN studentsubject so ON s.ID = so.StudentID
       JOIN `subject` ss ON ss.ID = so.SubjectID;
			 
/*Ques4a Tạo trigger cho table Subject có tên là SubjectUpdateID:
Khi thay đổi data của cột ID của table Subject, thì giá trị tương
ứng với cột SubjectID của table StudentSubject cũng thay đổi
theo*/
DROP TRIGGER IF EXISTS SubjectUpdateID;
DELIMITER$$
CREATE TRIGGER SubjectUpdateID INSTEAD OF
UPDATE ON `subject`
FOR EACH ROW
BEGIN
	IF NEW.ID <> OLD.ID THEN	
		UPDATE studentsubject SET SubjectID = NEW.ID
		WHERE SubjectID = OLD.ID;
	END IF;
END $$
DELIMITER ;

/*Ques4b Tạo trigger cho table Student có tên là StudentDeleteID:
Khi xóa data của cột ID của table Student, thì giá trị tương ứng với
cột SubjectID của table StudentSubject cũng bị xóa theo */
DROP TRIGGER IF EXISTS StudentDeleteID;
DELIMITER$$
CREATE TRIGGER StudentDeleteID BEFORE DELETE ON student
FOR EACH ROW
BEGIN
	DECLARE old_id_student int;
	SET old_id_student = (SELECT OLD.ID from OLD);
	
	DELETE From studentsubject so WHERE so.StudentID = old_id_student;
END $$
DELIMITER ;
/*Ques5 Viết 1 store procedure (có 2 parameters: student name) sẽ xóa tất cả các
thông tin liên quan tới học sinh có cùng tên như parameter
Trong trường hợp nhập vào student name = "*" thì procedure sẽ xóa tất cả
các học sinh*/
DROP PROCEDURE IF EXISTS udf_DeleteStudent;
DELIMITER $$
CREATE PROCEDURE udf_DeleteStudent(IN student_name varchar(50),OUT mess VARCHAR(50))
BEGIN
  IF student_name <> '*' THEN
		DELETE FROM student s WHERE s.`Name`  LIKE student_name;
		SET mess := 'Deleted some record';
	ELSEIF
		DELETE FROM student;
		SET mess := 'Deleted all';
	END IF;
END $$
DELIMITER;