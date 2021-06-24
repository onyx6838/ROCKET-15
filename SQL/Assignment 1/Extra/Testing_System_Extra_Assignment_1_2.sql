-- drop DATABASE if EXISTS testingsystem_assignment_extra_1_2;
create DATABASE testingsystem_assignment_extra_1_2;
use testingsystem_assignment_extra_1_2;

-- table Trainee
create table Trainee(
	TraineeID  TINYINT AUTO_INCREMENT	PRIMARY KEY,
	Full_Name  VARCHAR(50),
	Birth_Date Date,
	Gender 		 Enum('male','female','unknown'),
	ET_IQ 		 INT CHECK(ET_IQ BETWEEN 0 AND 20),
	ET_Gmath 	 INT CHECK(ET_Gmath BETWEEN 0 AND 20),
	ET_English INT CHECK(ET_English BETWEEN 0 AND 20),
	Training_Class int,
	Evaluation_Notes TEXT
);

-- alter table Trainee
ALTER TABLE Trainee
ADD COLUMN VTI_Account VARCHAR(50) NOT NULL UNIQUE