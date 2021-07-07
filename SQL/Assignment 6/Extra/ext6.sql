/*Ques2 Remove tất cả thông tin
project đã hoàn thành sau 3 tháng kể từ ngày hiện. In số lượng record đã remove từ các table liên quan trong khi removing */

DELIMITER$$
CREATE PROCEDURE Ques2()
BEGIN
   SELECT *
	 from projects p WHERE p.ProjectCompletedOn < date_sub('2021-12-06 00:00:00', interval 2 month);
	 
	 SELECT @@ROWCOUNT AS DELETED; 
END $$
DELIMITER;

/*Ques3 Viết stored procedure (có parameter) để in ra các module đang được thực hiện) */
DELIMITER$$
CREATE PROCEDURE Ques3(in in_module_id varchar(50))
BEGIN
  SELECT * from project_modules pm
	JOIN work_done wd ON pm.ModuleID = wd.ModuleID
	WHERE (wd.WorkDoneDate BETWEEN pm.ProjectModulesDate AND ProjectModulesCompletedOn) AND 
	pm.ModuleID = in_module_id;
END $$
DELIMITER;

/*Ques4 Viết hàm (có parameter) trả về thông tin 1 nhân viên đã tham gia làm mặc
dù không ai giao việc cho nhân viên đó (trong bảng Works) */
DELIMITER$$
CREATE FUNCTION Ques4() return int
BEGIN
  DECLARE @id_emp int;
	SELECT * from work_done wd
END $$
DELIMITER;