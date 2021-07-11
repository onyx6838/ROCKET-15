/*Ques2 Remove tất cả thông tin
project đã hoàn thành sau 3 tháng kể từ ngày hiện. In số lượng record đã remove từ các table liên quan trong khi removing */

DELIMITER$$
CREATE PROCEDURE Ques2()
BEGIN
	 -- tao ra 3 bien de luu so luong ban ghi se xoa o moi bang
   DECLARE del_project int;
	 DECLARE del_project_modules int;
	 DECLARE del_work_done int;
	 
	 -- lay ra so luong ban ghi thuoc bang Project
	 SELECT COUNT(*)
	 INTO   del_project
	 FROM   projects
	 WHERE  ProjectCompletedOn < NOW() - INTERVAL 3 MONTH;
	 -- tinh so luong ban ghi se bi xoa khoi bang project_modules
	 SELECT Count(*)
	 INTO   del_project_modules
	 FROM   project_modules
	 WHERE  ProjectID IN
	 (
		SELECT ProjectID
		FROM   projects
		WHERE  ProjectCompletedOn < NOW() - INTERVAL 3 MONTH);
	 -- tinh so luong ban ghi xoa khoi  bang work_done
		SELECT Count(*)
		INTO   del_work_done
		FROM   work_done
		WHERE  ModuleID IN
       (
				SELECT ModuleID
				FROM   project_modules
				WHERE  ProjectID IN
					 (
						SELECT ProjectID
						FROM   projects
						WHERE  ProjectCompletedOn < NOW() - INTERVAL 3 MONTH));
	 -- xoa work_done
	 DELETE FROM work_done
   WHERE  ModuleID IN (SELECT ModuleID
									from   project_modules
									WHERE  ProjectID IN (SELECT ProjectID
																			 FROM   projects
																			 WHERE  ProjectCompletedOn < NOW() -
																							INTERVAL 3 MONTH)); 
		
		-- xoa project modules
	 DELETE FROm project_modules
   WHERE  ProjectID in (SELECT ProjectID
                     FROM   projects
                     WHERE  ProjectCompletedOn < NOW() - INTERVAL 3 MONTH); 
	 
	 DELETE FROm projects
   WHERE  ProjectCompletedOn < NOW() - INTERVAL 3 MONTH; 
	 
	 -- thong ke so ban ghi da xoa
	 SELECT 
	 CONCAT("so ban ghi da xoa trong projects",' ',del_project),
	 CONCAT("so ban ghi da xoa trong projects_mo",' ',del_project_modules),
	 CONCAT("so ban ghi da xoa trong wd",' ',del_work_done);
-- 	 SELECT CONCAT("so ban ghi da xoa trong projects_mo",' ',del_project);
-- 	 SELECT CONCAT("so ban ghi da xoa trong wd",' ',del_project);
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