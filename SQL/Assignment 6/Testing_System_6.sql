/* Ques1 Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các
account thuộc phòng ban đó */
DELIMITER $$
CREATE PROCEDURE getAccountWithDepartment(IN depart_name varchar(50))
BEGIN
  SELECT * FROM account a
  JOIN department d ON a.DepartmentID = d.DepartmentID
  WHERE d.DepartmentName = depart_name;
END $$
DELIMITER;

CALL getAccountWithDepartment('Sale');

/* Ques2 Tạo store để in ra số lượng account trong mỗi group */

/* nhap username lay id */
DELIMITER $$
CREATE FUNCTION getUserName (userName varchar(50)) RETURNS smallint
BEGIN
  DECLARE id int;
  SELECT a.AccountID INTO id FROM account a WHERE a.Username = userName;
  RETURN id;
END $$
DELIMITER;

SELECT getUserName('dangblack');