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
