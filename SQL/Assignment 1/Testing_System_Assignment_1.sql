create DATABASE testingsystem_assignment1;
use testingsystem_assignment1;

create table Department(
	DepartmentID int,
	DepartmentName VARCHAR(50)
);

create table `Position`(
	PositionID int,
	PositionName VARCHAR(50)
);

create table Account(
	AccountID int,
	Email VARCHAR(50),
	Username VARCHAR(50),
	Fullname VARCHAR(50),
	DepartmentID int,
	PositionID int,
	CreateDate Date
);

create table `Group`(
	GroupID int,
	GroupName VARCHAR(50),
	CreatorID int,
	CreateDate Date
);

create table GroupAccount(
 GroupID int,
 AccountID int,
 JoinDate Date
);

create table TypeQuestion(
	TypeID int,
	TypeName VARCHAR(50)
);

create table CategoryQuestion(
	CategoryID int,
	CategoryName VARCHAR(50)
);

create table Question(
	QuestionID int,
	Content VARCHAR(50),
	CategoryID int,
	TypeID int,
	CreatorID int,
	CreateDate Date
);

create table Answer(
	AnswerID int,
	Content VARCHAR(50),
	QuestionID int,
	isCorrect boolean
);

create table Exam(
	ExamID int,
	`Code` VARCHAR(50),
	Title VARCHAR(50),
	CategoryID int,
	Duration int,
	CreatorID int,
	CreateDate Date
);

create table ExamQuestion(
	ExamID int,
	QuestionID int
);