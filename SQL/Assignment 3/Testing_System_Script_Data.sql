use testingsystem_assignment_5;

-- insert deparment table
INSERT INTO department(DepartmentID,DepartmentName) VALUES
(1,N'Marketing'),
(2,N'Sale'),
(3,N'Bảo vệ'),
(4,N'Nhân sự'),
(5,N'Kỹ thuật'),
(6,N'Tài chính'),
(7,N'Phó giám đốc'),
(8,N'Giám đốc'),
(9,N'Thư kí'),
(10,N'Bán hàng');

-- insert position table
INSERT into `position`(POSITIONID,PositionName) VALUES
(1,N'Dev'),
(2,N'Test'),
(3,N'Scrum Master');

-- insert account table
INSERT INTO account(`AccountID`, `Email`, `Username`, `Fullname`, `DepartmentID`, `PositionID`, `CreateDate`) VALUES
(1, 'haidang29productions@gmail.com', 'dangblack', 'Nguyen Hai', 5, 1,  '2020-03-05 00:00:00'),
(2, 'account1@gmail.com', 'quanganh', 'Tong Quang', 1, 2,  '2020-03-05 00:00:00'),
(3, 'account2@gmail.com', 'vanchien',  'Nguyen Van', 2, 3,  '2020-03-07 00:00:00'),
(4, 'account3@gmail.com', 'cocoduongqua',  'Duong', 3, 3, '2020-03-08 00:00:00'),
(5, 'account4@gmail.com', 'doccocaubai',  'Nguyen Chien', 4, 3,  '2020-03-10 00:00:00'),
(6, 'dapphatchetngay@gmail.com', 'khabanh',  'Ngo Ba', 6, 3,  '2021-06-07 22:02:28'),
(7, 'songcodaoly@gmail.com', 'huanhoahong',  'Bui Xuan', 7, 2,  '2021-06-07 22:02:28'),
(8, 'sontungmtp@gmail.com', 'tungnui',  'Nguyen Thanh', 8, 1,  '2020-04-07 00:00:00'),
(9, 'duongghuu@gmail.com', 'duongghuu', 'Duong Van', 9, 2,  '2020-04-07 00:00:00'),
(10, 'vtiaccademy@gmail.com', 'vtiaccademy',  'Vi Ti', 10, 1,  '2020-04-09 00:00:00'),
(11, 'NguyenVanA@gmail.com', 'NguyenVanA', 'Nguyen Van', NULL, NULL, '2021-06-20 23:01:18');

-- insert group table
INSERT INTO `group`(`GroupID`, `GroupName`, `CreatorID`, `CreateDate`) VALUES 
(1, 'Testing System', 5, '2019-03-05 00:00:00'),
(2, 'Developement', 1, '2020-03-07 00:00:00'),
(3, 'VTI Sale 01', 2, '2020-03-09 00:00:00'),
(4, 'VTI Sale 02', 3, '2020-03-10 00:00:00'),
(5, 'VTI Sale 03', 4, '2020-03-28 00:00:00'),
(6, 'VTI Creator', 6, '2020-04-06 00:00:00'),
(7, 'VTI Marketing 01', 7, '2020-04-07 00:00:00'),
(8, 'Management', 8, '2020-04-08 00:00:00'),
(9, 'Chat with love', 9, '2020-04-09 00:00:00'),
(10, 'Vi Ti Ai', 10, '2020-04-10 00:00:00');

-- insert groupaccount table
INSERT INTO `groupaccount`(`GroupID`, `AccountID`, `JoinDate`) VALUES
(1, 1, '2019-03-05 00:00:00'),
(1, 2, '2020-03-07 00:00:00'),
(1, 3, '2020-04-06 00:00:00'),
(1, 7, '2020-04-07 00:00:00'),
(1, 9, '2020-04-09 00:00:00'),
(3, 3, '2020-03-09 00:00:00'),
(3, 4, '2020-03-10 00:00:00'),
(5, 5, '2020-03-28 00:00:00'),
(8, 3, '2020-04-08 00:00:00'),
(10, 10, '2020-04-10 00:00:00');

-- insert categoryquestion table
INSERT INTO categoryquestion(`CategoryID`, `CategoryName`) VALUES
(3, 'ADO.NET'),
(2, 'ASP.NET'),
(9, 'C Sharp'),
(8, 'C++'),
(1, 'Java'),
(10, 'PHP'),
(5, 'Assembly'),
(7, 'Python'),
(6, 'Ruby'),
(4, 'SQL');


-- insert TypeQuestion table
INSERT INTO TypeQuestion(`TypeID`, `TypeName`) VALUES 
(1, 'Multiple-Choice'),
(2, 'Essay');

-- insert question table
INSERT INTO `question`(`QuestionID`, `Content`, `CategoryID`, `TypeID`, `CreatorID`, `CreateDate`) VALUES 
(1, 'Câu hỏi về Java', 1, 1, 1, '2020-04-05 00:00:00'),
(2, 'Câu Hỏi về PHP', 10, 2, 2, '2020-04-05 00:00:00'),
(3, 'Hỏi về C#', 9, 2, 3, '2020-04-06 00:00:00'),
(4, 'Hỏi về Ruby', 6, 1, 4, '2020-04-06 00:00:00'),
(5, 'Hỏi về Postman', 5, 1, 5, '2020-04-06 00:00:00'),
(6, 'Hỏi về ADO.NET', 3, 2, 6, '2020-04-06 00:00:00'),
(7, 'Hỏi về ASP.NET', 2, 1, 7, '2020-04-06 00:00:00'),
(8, 'Hỏi về C++', 8, 1, 8, '2020-04-07 00:00:00'),
(9, 'Hỏi về SQL', 4, 2, 9, '2020-04-07 00:00:00'),
(10, 'Hỏi về Python', 7, 1, 10, '2020-04-07 00:00:00');

-- insert exam table
INSERT INTO `exam`(`ExamID`, `Code`, `Title`, `CategoryID`, `Duration`, `CreatorID`, `CreateDate`) VALUES 
(1, 'S-1', 'Đề thi C#', 1, 60, 5, '2019-04-05 00:00:00'),
(2, 'S-2', 'Đề thi PHP', 10, 60, 1, '2019-04-05 00:00:00'),
(3, 'M-1', 'Đề thi C++', 9, 120, 2, '2019-04-07 00:00:00'),
(4, 'S-3', 'Đề thi Java', 6, 60, 3, '2020-04-08 00:00:00'),
(5, 'M-2', 'Đề thi Ruby', 5, 120, 4, '2020-04-10 00:00:00'),
(6, 'S-4', 'Đề thi Postman', 3, 60, 6, '2020-04-05 00:00:00'),
(7, 'S-5', 'Đề thi SQL', 2, 60, 7, '2020-04-05 00:00:00'),
(8, 'S-6', 'Đề thi Python', 8, 60, 8, '2020-04-07 00:00:00'),
(9, 'L-1', 'Đề thi ADO.NET', 4, 180, 9, '2020-04-07 00:00:00'),
(10, 'L-2', 'Đề thi ASP.NET', 7, 180, 10, '2020-04-08 00:00:00');

-- insert answer table
INSERT INTO answer VALUES 
(1, 'Trả lời 01', 1, 0),
(2, 'Trả lời 02', 1, 1),
(3, 'Trả lời 03', 1, 0),
(4, 'Trả lời 04', 1, 1),
(5, 'Trả lời 05', 2, 1),
(6, 'Trả lời 06', 3, 1),
(7, 'Trả lời 07', 4, 0),
(8, 'Trả lời 08', 8, 0),
(9, 'Trả lời 09', 9, 1),
(10, 'Trả lời 10', 10, 1);

-- insert examquestion table
INSERT INTO `examquestion`(`ExamID`, `QuestionID`) VALUES
(7, 2),
(4, 3),
(3, 4),
(1, 5),
(5, 7),
(10, 8),
(9, 9),
(2, 10),
(6, 10),
(8, 10);