DELIMITER $$
CREATE PROCEDURE sp_delete_department(IN depart_id INT)
BEGIN
  DELETE FROM department WHERE DepartmentID = depart_id;
END $$
DELIMITER;