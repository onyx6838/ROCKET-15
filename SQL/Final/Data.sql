INSERT INTO `student`(`ID`, `Name`, `Age`, `Gender`) 
VALUES 
(1, N'Đoàn Minh Giang', '2021-07-12 19:35:54', 0),
(2, N'Trương Việt Anh', '2021-07-12 19:35:54', 0),
(3, N'Nguyễn Đức Mạnh', '2021-07-12 19:35:54', 0),
(4, N'Nguyễn Văn Đạt', '2021-07-12 19:35:54', 0),
(5, N'Phạm Ngọc Sơn', '2021-07-12 19:35:54', 0),
(6, N'Hoàng Đức Huy', '2021-07-12 19:35:54', 0),
(7, N'Bùi Duy', '2021-07-12 19:35:54', 0);

INSERT INTO `subject`(`ID`, `Name`) VALUES 
(1, 'SQL'),
(2, 'Java'),
(3, 'FE'),
(4, 'BE'),
(5, 'FE - Advance');

INSERT INTO `studentsubject`(`StudentID`, `SubjectID`, `Mark`, `Date`) VALUES 
(1, 1, 7, NULL),
(2, 2, 8, NULL),
(3, 1, 9, NULL),
(4, 4, 6, NULL),
(5, 3, 10, NULL),
(6, 5, 8, NULL),
(7, 3, 8.5, NULL);