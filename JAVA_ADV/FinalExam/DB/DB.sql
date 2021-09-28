-- create database
DROP DATABASE IF EXISTS boot_final_ex;
CREATE DATABASE boot_final_ex;
USE boot_final_ex;

-- table: Group
DROP TABLE IF EXISTS `Group`;
CREATE TABLE `Group`(
		GroupID 					INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    GroupName 				NVARCHAR(50) NOT NULL UNIQUE KEY,
		Member						INT UNSIGNED,
    Creator						INT UNSIGNED,
    CreateDate				DATETIME DEFAULT NOW()
);
-- table: Account
DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account`(
	  AccountID				INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Email						VARCHAR(50) NOT NULL UNIQUE KEY, 
    Username				VARCHAR(50) NOT NULL UNIQUE KEY,
    `password` 			VARCHAR(800) NOT NULL,
    FirstName				NVARCHAR(50) NOT NULL,
    LastName				NVARCHAR(50) NOT NULL,	
    GroupID 				INT UNSIGNED,	
    CreateDate			DATETIME DEFAULT NOW(), 
    FOREIGN KEY(GroupID) REFERENCES `Group`(GroupID) ON DELETE SET NULL
);