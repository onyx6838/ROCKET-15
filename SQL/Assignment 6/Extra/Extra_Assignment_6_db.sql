DROP DATABASE IF EXISTS testingsystem_assignment_6_1;
CREATE DATABASE testingsystem_assignment_6_1;
use testingsystem_assignment_6_1;

DROP TABLE IF EXISTS Employee;
CREATE TABLE Employee
(
	EmployeeID           INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	EmployeeLastName     NVARCHAR(50) NOT NULL,
	EmployeeFirstName    NVARCHAR(50) NOT NULL,
	EmployeeHireDate 		 DATETIME DEFAULT NOW(),
	EmployeeStatus       BIT NOT NULL,
	SupervisorID         INT UNSIGNED NOT NULL,
	SocialSecurityNumber VARCHAR(50) NOT NULL,
	FOREIGN KEY (SupervisorID) REFERENCES Employee(EmployeeID)
);

DROP TABLE IF EXISTS Projects;
CREATE TABLE Projects
(
	ProjectID            INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	EmployeeID					 INT UNSIGNED NOT NULL,
	ProjectName          VARCHAR(50) NOT NULL,
	ProjectStartDate 		 DATETIME DEFAULT NOW(),
	ProjectDescription   VARCHAR(255) NULL,
	ProjectDetail        VARCHAR(255) NULL,
	ProjectCompletedOn   DATETIME DEFAULT NOW(),
	FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID)
); 

DROP TABLE IF EXISTS Project_Modules;
CREATE TABLE Project_Modules
(
	ModuleID                  INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	ProjectID                 INT UNSIGNED NOT NULL,
	ProjectModulesDate    		DATETIME DEFAULT NOW(),
	ProjectModulesCompletedOn DATETIME DEFAULT NOW(),
	ProjectModulesDescription VARCHAR(255) NULL,
	FOREIGN KEY (ProjectID) REFERENCES Projects(ProjectID)
); 

DROP TABLE IF EXISTS Work_Done;
CREATE TABLE Work_Done
(
	WorkDoneID          INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	EmployeeID          INT UNSIGNED NOT NULL,
	ModuleID            INT UNSIGNED NOT NULL,
	WorkDoneDate    DATETIME DEFAULT NOW(),
	WorkDoneDescription VARCHAR(255) NULL,
	WorkDoneStatus      BIT(1) NULL,
	FOREIGN KEY (ModuleID) REFERENCES Project_Modules(ModuleID),
	FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID)
);

INSERT INTO Employee (EmployeeLastName, EmployeeFirstName, EmployeeHireDate, EmployeeStatus, SupervisorID, SocialSecurityNumber)
VALUES						
(N'Nguyễn Hải',N'Đăng','2019-06-06', 1,1,'SS001'),
(N'Lê Thị',N'Thư','2019-07-06', 1,1,'SS002'),
(N'Nguyễn Hữu',N'Thắng','2019-08-06', 1,2,'SS003'),
(N'Dương Văn',N'Hữu','2019-07-06', 0,2,'SS004');

INSERT INTO Projects (EmployeeID , ProjectName , ProjectStartDate, ProjectDescription, ProjectDetail, ProjectCompletedOn)
VALUES						
(1,'Java','2019-06-06', 'Làm đúng vào','Làm đúng hạn','2019-08-06'),
(2,'C#','2019-07-06', 'Làm nhanh lên','Làm trước hạn','2019-09-06'),
(3,'Android','2019-08-06', 'Nộp trước ngày 17/3','Làm quá hạn','2019-10-06'),
(1,'C++','2019-07-06', 'Không biết đừng làm','Làm trước hạn','2019-11-06');

INSERT INTO Project_Modules (ProjectID, ProjectModulesDate, ProjectModulesCompletedOn, ProjectModulesDescription)
VALUES						
(1,'2019-06-06', '2019-06-06','Làm đúng hạn'),
(2,'2019-07-06', '2019-06-06','Làm trước hạn'),
(3,'2019-08-06', '2019-09-06','Làm quá hạn'),
(4,'2019-07-06', '2019-06-06','Làm trước hạn');

INSERT INTO Work_Done	(EmployeeID, ModuleID, WorkDoneDate, WorkDoneDescription, WorkDoneStatus)
VALUES						
(1,1,'2019-06-06', 'Làm được phết',1),
(2,2,'2019-07-06', 'Làm ổn phết',1),
(3,3,'2019-08-06', 'Không biết làm',0),
(1,4,'2019-07-06', 'Không biết ko làm',0);