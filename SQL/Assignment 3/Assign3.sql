use testingsystem_assignment_3;

-- Ques1
insert into department(DepartmentID,DepartmentName) VALUES
(1,'Phong1'),
(2,'Phong2'),
(3,'Phong3'),
(4,'Phong4'),
(5,'Phong5'),
(6,'Phong6'),
(7,'Phong7'),
(8,'Phong8'),
(9,'Phong9'),
(10,'Phong10')
-- Ques2
select * from department

-- Ques3
select DepartmentID from department WHERE DepartmentName = 'Sale'

-- Ques4
insert into account(AccountID,Fullname) VALUES
(1,N'Đoàn Minh Giang'),
(2,N'Lê Thái'),
(3,N'Vũ Văn Thanh'),
(4,N'Nguyễn Bách Phong')

SELECT *,LENGTH(Fullname) from account ORDER BY LENGTH(Fullname) DESC LIMIT 1

-- Ques5
SELECT *,LENGTH(Fullname) from account WHERE DepartmentID = 3
 ORDER BY LENGTH(Fullname) DESC LIMIT 1
 
 -- Ques6
select * from `group` WHERE CreateDate < '2019-12-20'

-- Ques7
