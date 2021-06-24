drop DATABASE if EXISTS testingsystem_assignment_2;
create DATABASE testingsystem_assignment_2;
use testingsystem_assignment_2;

create table Department(
	DepartmentID SMALLINT PRIMARY KEY,
	DepartmentName VARCHAR(50)
);

create table `Position`(
	PositionID SMALLINT PRIMARY KEY,
	PositionName VARCHAR(50)
);

create table Account(
	AccountID SMALLINT PRIMARY KEY,
	Email VARCHAR(50),
	Username VARCHAR(50),
	Fullname VARCHAR(50),
	DepartmentID SMALLINT,
	PositionID SMALLINT,
	CreateDate Date
);

create table `Group`(
	GroupID SMALLINT PRIMARY KEY,
	GroupName VARCHAR(50),
	CreatorID SMALLINT,
	CreateDate Date
);

create table GroupAccount(
 GroupID SMALLINT,
 AccountID SMALLINT,
 JoinDate Date
);

create table TypeQuestion(
	TypeID SMALLINT PRIMARY KEY,
	TypeName VARCHAR(50)
);

create table CategoryQuestion(
	CategoryID SMALLINT,
	CategoryName VARCHAR(50)
);

create table Question(
	QuestionID SMALLINT PRIMARY KEY,
	Content VARCHAR(50),
	CategoryID SMALLINT,
	TypeID SMALLINT,
	CreatorID SMALLINT,
	CreateDate Date
);

create table Answer(
	AnswerID SMALLINT PRIMARY KEY,
	Content VARCHAR(50),
	QuestionID SMALLINT,
	isCorrect boolean
);

create table Exam(
	ExamID SMALLINT PRIMARY KEY,
	`Code` VARCHAR(50),
	Title VARCHAR(50),
	CategoryID SMALLINT,
	Duration SMALLINT,
	CreatorID SMALLINT,
	CreateDate Date
);

create table ExamQuestion(
	ExamID SMALLINT,
	QuestionID SMALLINT
);