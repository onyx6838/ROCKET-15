drop DATABASE if EXISTS testingsystem_assignment_extra_3;
create DATABASE testingsystem_assignment_extra_3;
use testingsystem_assignment_extra_3;

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

SELECT Month(birth_date),
       Count(*),
       Group_concat(full_name) AS list
FROM   trainee
GROUP  BY Month(birth_date) 

-- Ques3: 
select Full_Name,2021 - YEAR(Birth_Date),CHAR_LENGTH(Full_Name) from trainee ORDER BY CHAR_LENGTH(Full_Name) DESC LIMIT 1
-- 
SELECT full_name,
       2021 - Year(birth_date),
       Char_length(full_name)
FROM   trainee
WHERE  Char_length(full_name) = (SELECT Max(Char_length(full_name))
                                 FROM   trainee) 

-- loc trung ban ghi	?

-- Ques4
SELECT *
FROM   trainee
WHERE  ( et_iq + et_gmath >= 20 )
       AND ( et_iq >= 8 )
       AND et_gmath >= 8
       AND et_english >= 18 
-- Ques5
delete from trainee 
WHERE TraineeID = 3

-- Ques6
UPDATE trainee
SET    training_class = 2
WHERE  traineeid = 5 