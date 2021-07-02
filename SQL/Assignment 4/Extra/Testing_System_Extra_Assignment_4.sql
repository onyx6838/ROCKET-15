-- Ques3
SELECT e.Employee_Number,e.Employee_Name from employee_table e
union
SELECT d.Employee_Number ,d.Employee_Name
from employee_skill_table em,employee_table d 
WHERE em.Employee_Number = d.Employee_Number AND em.Skill_Code = N'Java';

-- Ques4
SELECT *, COUNT(1) sl from department d
JOIN employee_table a ON a.Department_Number = d.Department_Number 
GROUP BY d.Department_Number
HAVING COUNT(a.Employee_Number) > 1

-- Ques5
SELECT *, COUNT(a.Employee_Number) from department d
lEFT JOIN employee_table a ON a.Department_Number = d.Department_Number 
GROUP BY d.Department_Number;

-- Ques6
SELECT e.Employee_Number,ee.Employee_Name,COUNT(DISTINCT(e.Skill_Code)),GROUP_CONCAT(DISTINCT(e.Skill_Code)) from employee_skill_table e 
JOIN employee_table ee ON ee.Employee_Number = e.Employee_Number
GROUP BY e.Employee_Number