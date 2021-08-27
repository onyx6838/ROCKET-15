-- =============================================
-- Create Structure database
-- =============================================

-- Drop the database if it already exists
DROP DATABASE IF EXISTS hb_ts_as1;
-- Create database
CREATE DATABASE IF NOT EXISTS hb_ts_as1;
USE hb_ts_as1;

-- Create table user
DROP TABLE IF EXISTS 	`User`;
CREATE TABLE IF NOT EXISTS `User` ( 	
	id 				SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`username`	 	CHAR(50) NOT NULL UNIQUE CHECK (LENGTH(`username`) >= 6 AND LENGTH(`username`) <= 50),
	`email` 		CHAR(50) NOT NULL UNIQUE CHECK (LENGTH(`email`) >= 6 AND LENGTH(`email`) <= 50),
	`password` 		VARCHAR(800) NOT NULL,
	`firstName` 	NVARCHAR(50) NOT NULL,
	`lastName` 		NVARCHAR(50) NOT NULL,
	`gender` 		ENUM('M','F','U') NOT NULL,
	`date_Of_Birth` DATE NOT NULL,
	`address` 		CHAR(100) NOT NULL,
	`phone` 		CHAR(15) NOT NULL UNIQUE CHECK (LENGTH(`phone`) >= 9 AND LENGTH(`phone`) <= 15),
	`role` 			ENUM('Admin','Employee','Manager') DEFAULT 'Employee',
	`status`		TINYINT DEFAULT 0 -- 0: Not Active, 1: Active, 2: block
);

-- Create table Registration_User_Token
DROP TABLE IF EXISTS 	`Registration_User_Token`;
CREATE TABLE IF NOT EXISTS `Registration_User_Token` ( 	
	id 				INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`token`	 		CHAR(36) NOT NULL UNIQUE,
	`user_id` 		SMALLINT UNSIGNED NOT NULL,
	`expiryDate` 	DATETIME NOT NULL
);

-- Create table Reset_Password_Token
DROP TABLE IF EXISTS 	`Reset_Password_Token`;
CREATE TABLE IF NOT EXISTS `Reset_Password_Token` ( 	
	id 				INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`token`	 		CHAR(36) NOT NULL UNIQUE,
	`user_id` 		SMALLINT UNSIGNED NOT NULL,
	`expiryDate` 	DATETIME NOT NULL
);

-- Create table Group
DROP TABLE IF EXISTS 	`Group`;
CREATE TABLE IF NOT EXISTS `Group` (
	id 				SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`name` 			NVARCHAR(50) NOT NULL UNIQUE,
	author_ID		SMALLINT UNSIGNED NOT NULl,
	create_time		DATETIME NOT NULL DEFAULT NOW(),
	FOREIGN KEY (author_ID) 		REFERENCES  `User` (id)
);

-- Create table user & group
DROP TABLE IF EXISTS 	`User_Group`;
CREATE TABLE IF NOT EXISTS `User_Group` (
    group_id 		SMALLINT UNSIGNED NOT NULL,
    user_id 		SMALLINT UNSIGNED NOT NULL,
    join_time		DATETIME NOT NULL DEFAULT NOW(),
	FOREIGN KEY (group_id) 		REFERENCES `Group`(`id`),
	FOREIGN KEY (user_id) 		REFERENCES  `User` (id),
	PRIMARY KEY (group_id,user_id)
);

-- Create table Testing_Category
DROP TABLE IF EXISTS 	`Testing_Category`;
CREATE TABLE IF NOT EXISTS `Testing_Category` (
	`id` 				SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`name` 				NVARCHAR(50) NOT NULL UNIQUE,
	author_ID			SMALLINT UNSIGNED NOT NULl DEFAULT 1,
	create_time			DATETIME NOT NULL DEFAULT NOW(),
	FOREIGN KEY (author_ID) REFERENCES  `User` (id)
);

-- Create table Question_Category
DROP TABLE IF EXISTS 	`Question_Category`;
CREATE TABLE IF NOT EXISTS `Question_Category` (
	`id` 						SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`name` 						NVARCHAR(50) NOT NULL UNIQUE,
	`Testing_Category_ID`		SMALLINT UNSIGNED NOT NULL,
	author_ID					SMALLINT UNSIGNED NOT NULl,
	create_time					DATETIME NOT NULL DEFAULT NOW(),
	FOREIGN KEY (Testing_Category_ID) 		REFERENCES  `Testing_Category` (id),
	FOREIGN KEY (author_ID) 				REFERENCES  `User` (id)
);


-- Create table level question
DROP TABLE IF EXISTS 	`Question_Level`;
CREATE TABLE IF NOT EXISTS `Question_Level` (
	id 						TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY, 
	`level` 				CHAR(20) NOT NULL
);

-- Create table Image
DROP TABLE IF EXISTS 	`Image`;
CREATE TABLE IF NOT EXISTS `Image` (
	id 						SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`name` 					NVARCHAR(50) NOT NULL UNIQUE,
	`author_ID` 			SMALLINT UNSIGNED NOT NULL,
	create_time				DATETIME NOT NULL DEFAULT NOW(),
	FOREIGN KEY (author_ID) 		REFERENCES  `User` (id)
);

-- Create table Question
DROP TABLE IF EXISTS 	`Question`;
CREATE TABLE IF NOT EXISTS `Question` (
	id 						INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`title` 				TEXT NOT NULL,
	`Question_Category_ID` 	SMALLINT UNSIGNED NOT NULL,
	`type` 					ENUM('Multiple-Choice','Essay') NOT NULL DEFAULT 'Multiple-Choice',
	`status` 				BIT DEFAULT 0, -- 0: draft, 1: published
	`level_ID`				TINYINT UNSIGNED NOT NULL,
    `version`				SMALLINT UNSIGNED NOT NULL DEFAULT '1',
    `author_ID` 			SMALLINT UNSIGNED NOT NULL,
    create_time				DATETIME NOT NULL DEFAULT NOW(),
    Image_ID				SMALLINT UNSIGNED,
	FOREIGN KEY (Question_Category_ID) 	REFERENCES `Question_Category`(id),
	FOREIGN KEY (level_ID) 				REFERENCES  `Question_Level` (id),
	FOREIGN KEY (author_ID) 			REFERENCES  `User` (id),
	FOREIGN KEY (Image_ID) 				REFERENCES  `Image` (id)
);

-- Create table Answer
DROP TABLE IF EXISTS 	`Answer`;
CREATE TABLE IF NOT EXISTS `Answer` (
	id 						SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    question_ID 			INT UNSIGNED NOT NULL,
    `key` 					TEXT NOT NULL,
    is_correct				BOOLEAN NOT NULL DEFAULT FALSE,
    Image_ID				SMALLINT UNSIGNED,
	FOREIGN KEY (question_ID) 	REFERENCES  `Question` (id),
    FOREIGN KEY (Image_ID) 		REFERENCES  `Image` (id)
);

-- Create table Testing
DROP TABLE IF EXISTS 	`Testing`;
CREATE TABLE IF NOT EXISTS `Testing` (
	id 							INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`name` 						NVARCHAR(200) NOT NULL UNIQUE,
	`Testing_Category_ID` 		SMALLINT UNSIGNED NOT NULL,
	`time`						SMALLINT NOT NULL,
    `generation_Type`			ENUM('Random','Custom') NOT NULL,
	`version`					SMALLINT UNSIGNED NOT NULL DEFAULT '1',
	`status`					BIT DEFAULT 0, -- 0:DRAFT ,1: PUBLISHED
	examiner_ID					SMALLINT UNSIGNED NOT NULL,
    `author_ID` 				SMALLINT UNSIGNED NOT NULL,
    create_time					DATETIME NOT NULL DEFAULT NOW(),
    Note						TEXT,
    FOREIGN KEY (author_ID) 			REFERENCES  `User` (id),
    FOREIGN KEY (examiner_ID) 			REFERENCES  `User` (id),
    FOREIGN KEY (Testing_Category_ID) 	REFERENCES `Testing_Category`(id)
);

-- Create table Question & Testing
DROP TABLE IF EXISTS 	`Question_Testing`;
CREATE TABLE IF NOT EXISTS `Question_Testing` (
    question_id 		INT UNSIGNED NOT NULL,
    testing_id 			INT UNSIGNED NOT NULL,
	FOREIGN KEY (question_id) 		REFERENCES `Question`(`id`),
	FOREIGN KEY (testing_id) 		REFERENCES  `Testing` (id),
	PRIMARY KEY (question_id,testing_id)
);


-- Create table Exam
DROP TABLE IF EXISTS 	`Exam`;
CREATE TABLE IF NOT EXISTS `Exam` (
   id 							INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
   `name` 						NVARCHAR(50) NOT NULL UNIQUE,
   start_time					DATETIME NOT NULL,
   end_time						DATETIME NOT NULL,
   `version`					SMALLINT UNSIGNED NOT NULL DEFAULT '1',
   `status`						BIT DEFAULT 0, -- 0:DRAFT ,1: PUBLISHED
	`author_ID` 				SMALLINT UNSIGNED NOT NULL,
    create_time					DATETIME NOT NULL DEFAULT NOW(),
    note						TEXT,
   FOREIGN KEY (author_ID) 		REFERENCES  `User` (id)
);

-- Create table Testing & Exam
DROP TABLE IF EXISTS 	`Testing_Exam`;
CREATE TABLE IF NOT EXISTS `Testing_Exam` (
    exam_id 			INT UNSIGNED NOT NULL,
    testing_id 			INT UNSIGNED NOT NULL,
	FOREIGN KEY (exam_id) 			REFERENCES `Exam`(`id`),
	FOREIGN KEY (testing_id) 		REFERENCES  `Testing` (id),
	PRIMARY KEY (exam_id,testing_id)
);

-- Create table Notice
-- DROP TABLE IF EXISTS 	`Notification`;
-- CREATE TABLE IF NOT EXISTS `Notification` (
--    id 				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
--    content 			NVARCHAR(50) NOT NULL UNIQUE
-- );
