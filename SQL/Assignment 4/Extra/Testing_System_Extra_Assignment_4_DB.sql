drop DATABASE if EXISTS testingsystem_assignment_extra_4;
create DATABASE testingsystem_assignment_extra_4;
use testingsystem_assignment_extra_4;

drop table if EXISTS Department;
create table Department
(
	Department_Number MEDIUMINT AUTO_INCREMENT PRIMARY KEY,
	Department_Name VARCHAR(50) not null
);

drop table if EXISTS Employee_Table;
create table Employee_Table
(
	Employee_Number MEDIUMINT AUTO_INCREMENT PRIMARY KEY,
	Employee_Name VARCHAR(50) not null,
	Department_Number MEDIUMINT,
	FOREIGN KEY (Department_Number) REFERENCES Department(Department_Number)
);


drop table if EXISTS Employee_Skill_Table;
create table Employee_Skill_Table
(
	Employee_Number MEDIUMINT,
	Skill_Code VARCHAR(50) not null, 
	Date_Registered date,
	FOREIGN KEY (Employee_Number) REFERENCES Employee_Table(Employee_Number)
);