drop DATABASE if EXISTS testingsystem_assignment_3;
create DATABASE if not EXISTS testingsystem_assignment_3;
use testingsystem_assignment_3;

drop table if EXISTS Department;
create table Department(
	DepartmentID SMALLINT AUTO_INCREMENT PRIMARY KEY,
	DepartmentName VARCHAR(50)
);

drop table if EXISTS `Position`;
create table `Position`(
	PositionID SMALLINT AUTO_INCREMENT PRIMARY KEY,
	PositionName Enum('Dev', 'Test', 'Scrum Master', 'PM')
);

drop table if EXISTS Account;
create table Account(
	AccountID SMALLINT AUTO_INCREMENT PRIMARY KEY,
	Email VARCHAR(50),
	Username VARCHAR(50),
	Fullname VARCHAR(50),
	DepartmentID SMALLINT,
	PositionID SMALLINT,
	CreateDate Date,
	FOREIGN KEY (DepartmentID) REFERENCES Department(DepartmentID),
	FOREIGN KEY (PositionID) REFERENCES `Position`(PositionID)
);

drop table if EXISTS `Group`;
create table `Group`(
	GroupID SMALLINT AUTO_INCREMENT PRIMARY KEY,
	GroupName VARCHAR(50),
	CreatorID SMALLINT,
	CreateDate Date,
	FOREIGN KEY (CreatorID) REFERENCES Account(AccountID)
);

drop table if EXISTS GroupAccount;
create table GroupAccount(
 GroupID SMALLINT,
 AccountID SMALLINT,
 JoinDate Date,
 FOREIGN KEY (GroupID) REFERENCES `Group`(GroupID),
 FOREIGN KEY (AccountID) REFERENCES Account(AccountID)
);

drop table if EXISTS TypeQuestion;
create table TypeQuestion(
	TypeID SMALLINT AUTO_INCREMENT PRIMARY KEY,
	TypeName ENUM('Essay', 'Multiple-Choice')
);

drop table if EXISTS CategoryQuestion;
create table CategoryQuestion(
	CategoryID SMALLINT AUTO_INCREMENT PRIMARY KEY,
	CategoryName VARCHAR(50)
);

drop table if EXISTS Question;
create table Question(
	QuestionID SMALLINT AUTO_INCREMENT PRIMARY KEY,
	Content VARCHAR(50),
	CategoryID SMALLINT,
	TypeID SMALLINT,
	CreatorID SMALLINT,
	CreateDate Date,
	FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion(CategoryID),
  FOREIGN KEY (TypeID) REFERENCES TypeQuestion(TypeID),
	FOREIGN KEY (CreatorID) REFERENCES Account(AccountID)
);

drop table if EXISTS Answer;
create table Answer(
	AnswerID SMALLINT AUTO_INCREMENT PRIMARY KEY,
	Content VARCHAR(50),
	QuestionID SMALLINT,
	isCorrect boolean,
	FOREIGN KEY (QuestionID) REFERENCES Question(QuestionID)
);

drop table if EXISTS Exam;
create table Exam(
	ExamID SMALLINT AUTO_INCREMENT PRIMARY KEY,
	`Code` VARCHAR(50),
	Title VARCHAR(50),
	CategoryID SMALLINT,
	Duration SMALLINT,
	CreatorID SMALLINT,
	CreateDate Date,
	FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion(CategoryID),
	FOREIGN KEY (CreatorID) REFERENCES Account(AccountID)
);

drop table if EXISTS ExamQuestion;
create table ExamQuestion(
	ExamID SMALLINT,
	QuestionID SMALLINT,
	FOREIGN KEY (ExamID) REFERENCES Exam(ExamID),
	FOREIGN KEY (QuestionID) REFERENCES Question(QuestionID)
);