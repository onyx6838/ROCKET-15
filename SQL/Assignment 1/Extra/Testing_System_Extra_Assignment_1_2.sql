drop DATABASE if EXISTS testingsystem_assignment_extra_1_2;
create DATABASE if not EXISTS testingsystem_assignment_extra_1_2;
use testingsystem_assignment_extra_1_2;

-- table Trainee
drop table if EXISTS Trainee;
create table Trainee(
	TraineeID  TINYINT AUTO_INCREMENT	PRIMARY KEY,
	Full_Name  VARCHAR(50) not null,
	Birth_Date Date not null,
	Gender 		 Enum('male','female','unknown'),
	ET_IQ 		 INT not null CHECK(ET_IQ >= 0 AND ET_IQ <= 20),
	ET_Gmath 	 INT not null CHECK(ET_Gmath BETWEEN 0 AND 20),
	ET_English INT not null CHECK(ET_English BETWEEN 0 AND 20),
	Training_Class VARCHAR(50),
	Evaluation_Notes TEXT DEFAULT('empty')
);

-- alter table Trainee
-- ALTER TABLE Trainee
-- ADD COLUMN VTI_Account VARCHAR(50) NOT NULL UNIQUE

-- ex2
drop table if EXISTS Exercise2;
create table Exercise2(
	ID MEDIUMINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`Name` VARCHAR(50),
	`Code` VARCHAR(5),
	ModifiedDate DATETIME
);

-- ex3
drop table if EXISTS Exercise3;
create table Exercise3(
	ID MEDIUMINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`Name` VARCHAR(50),
	BirthDate DATETIME,
	Gender INT CHECK(Gender in(0,1)),
	IsDeletedFlag BOOLEAN
);