/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/
-- Add data `Group`
INSERT INTO `group`(`GroupID`, `GroupName`, `Member`, `Creator`, `CreateDate`) VALUES  
(1, 'Testing System', 5, NULL, '2021-09-28 20:21:13');
(2, 'Development', 9, NULL, '2021-09-28 20:21:24'),
(3, 'Creator', 10, NULL, '2021-09-28 20:21:38'),
(4, 'Sale', 8, NULL, '2021-09-28 20:21:44'),
(5, 'Management', 7, NULL, '2021-09-28 20:21:52');

-- Add data Account
-- password: 123456
INSERT INTO `account`(`AccountID`, `Email`, `Username`, `password`, `FirstName`, `LastName`, `GroupID`, `CreateDate`) VALUES  
(1, 'haidang29productions@gmail.com', 'dangblack', '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi', 'Dang', 'Nguyen Hai', NULL, '2021-09-28 20:16:40'),
(2, 'giang.mink@gmail.com', 'minkgiang', '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi', 'Giang', 'Doan Minh', NULL, '2021-09-28 20:17:32'),
(3, 'onyxzt123@gmail.com', 'onyxzt123', '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi', 'Truong', 'Bui Duc', NULL, '2021-09-28 20:18:06'),
(4, 'thanglong98@gmail.com', 'thanglong98', '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi', 'Long', 'Tran Thang', NULL, '2021-09-28 20:18:43'),
(5, 'va29042000@gmail.com', 'va29042000', '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi', 'Anh', 'Truong Viet', NULL, '2021-09-28 20:19:36');

ALTER TABLE `Group`
ADD FOREIGN KEY (Creator) REFERENCES `Account`(AccountID);