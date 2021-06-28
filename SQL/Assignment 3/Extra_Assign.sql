use testingsystem_assignment_extra_1_2;
Drop table  if EXISTS trainee;

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

INSERT INTO 
trainee
( `Full_Name`, `Birth_Date`, `Gender`, `ET_IQ`, `ET_Gmath`, `ET_English`, `Training_Class`, `Evaluation_Notes`) 
VALUES 
('Giang', '2000-08-03', NULL, 5, 10, 10, NULL, NULL),
('Giang', '2000-09-03', NULL, 5, 10, 10, NULL, NULL),
('Giang', '2000-08-03', NULL, 5, 10, 10, NULL, NULL),
('Giang', '2000-07-03', NULL, 5, 10, 10, NULL, NULL),
('Giang', '2000-06-03', NULL, 5, 10, 10, NULL, NULL),
('Giang', '2000-05-03', NULL, 5, 10, 10, NULL, NULL),
('Giang', '2000-04-03', NULL, 5, 10, 10, NULL, NULL),
('Giang', '2000-03-03', NULL, 5, 10, 10, NULL, NULL)

-- Ques 2 Viết lệnh để lấy ra tất cả các thực tập sinh đã vượt qua bài test đầu vào,
-- nhóm chúng thành các tháng sinh khác nhau

select MONTH(Birth_Date), count(*) , GROUP_CONCAT(Full_Name) as list from trainee GROUP BY MONTH(Birth_Date)

-- Ques3: 
select Full_Name,2021 - YEAR(Birth_Date),CHAR_LENGTH(Full_Name) from trainee ORDER BY CHAR_LENGTH(Full_Name) DESC LIMIT 1
select Full_Name,2021 - YEAR(Birth_Date),CHAR_LENGTH(Full_Name) from trainee WHERE CHAR_LENGTH(Full_Name) = 18

-- loc trung ban ghi	?

-- Ques4
select * from trainee WHERE (ET_IQ + ET_Gmath>=20) AND (ET_IQ>=8) AND ET_Gmath>=8 AND ET_English>=18

-- Ques5
delete from trainee WHERE TraineeID = 3

-- Ques6
update trainee set Training_Class = 2 WHERE TraineeID = 5
