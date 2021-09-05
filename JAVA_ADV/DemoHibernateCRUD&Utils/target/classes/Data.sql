/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/
-- Add data Department
INSERT INTO Department(DepartmentName) 
VALUES
						(N'Marketing'	),
						(N'Sale'		),
						(N'Bảo vệ'		),
						(N'Nhân sự'		),
						(N'Kỹ thuật'	),
						(N'Tài chính'	),
						(N'Phó giám đốc'),
						(N'Giám đốc'	),
						(N'Thư kí'		),
						(N'Bán hàng'	);
    
-- Add data position
INSERT INTO Position	(`PositionName`	) 
VALUES 					('Dev'			),
						('Test'			),
						('ScrumMaster'	);
                        
-- Add data salary                 
INSERT INTO Salary		(SalaryName	) 
VALUES 					('600'		),
						('700'		),
						('1500'		);


-- Add data Account
INSERT INTO `Account`(Email								, Username			, FirstName,	LastName,			CreateDate)
VALUES 				('haidang29productions@gmail.com'	, 'dangblack'		,'Dang'	,		'Nguyen Hai'	,	'2020-03-05'),
					('account1@gmail.com'				, 'quanganh'		,'Anh'	,		'Tong Quang'	,	'2020-03-05'),
                    ('account2@gmail.com'				, 'vanchien'		,'Chien',		'Nguyen Van'	,	'2020-03-07'),
                    ('account3@gmail.com'				, 'cocoduongqua'	,'Do'	,		'Duong'			,	'2020-03-08'),
                    ('account4@gmail.com'				, 'doccocaubai'		,'Thang',		'Nguyen Chien'  ,	'2020-03-10'),
                    ('dapphatchetngay@gmail.com'		, 'khabanh'			,'Kha'	,		'Ngo Ba'		,	NOW()),
                    ('songcodaoly@gmail.com'			, 'huanhoahong'		,'Huan'	,		'Bui Xuan'		,	NOW()),
                    ('sontungmtp@gmail.com'				, 'tungnui'			,'Tung'	,		'Nguyen Thanh'	,	'2020-04-07'),
                    ('duongghuu@gmail.com'				, 'duongghuu'		,'Huu'	,		'Duong Van'		,	'2020-04-07'),
                    ('vtiaccademy@gmail.com'			, 'vtiaccademy'		,'Ai'	,		'Vi Ti'			,	'2020-04-09');

-- Add data Group
INSERT INTO `Group`	(  GroupName			, CreateDate)
VALUES 				(N'Testing System'		,'2019-03-05'),
					(N'Developement'		,'2020-03-07'),
                    (N'VTI Sale 01'			,'2020-03-09'),
                    (N'VTI Sale 02'			,'2020-03-10'),
                    (N'VTI Sale 03'			,'2020-03-28'),
                    (N'VTI Creator'			,'2020-04-06'),
                    (N'VTI Marketing 01'	,'2020-04-07'),
                    (N'Management'			,'2020-04-08'),
                    (N'Chat with love'		,'2020-04-09'),
                    (N'Vi Ti Ai'			,'2020-04-10');

-- Add data TypeQuestion
INSERT INTO TypeQuestion	(TypeName	) 
VALUES 						('0'), 
							('1'); 


-- Add data CategoryQuestion
INSERT INTO CategoryQuestion		(CategoryName	)
VALUES 								('Java'			),
									('ASP.NET'		),
									('ADO.NET'		),
									('SQL'			),
									('Postman'		),
									('Ruby'			),
									('Python'		),
									('C++'			),
									('C Sharp'		),
									('PHP'			);
													
-- Add data Question
INSERT INTO Question	(Content			, CreateDate )
VALUES 					(N'Câu hỏi về Java'	,'2020-04-05'),
						(N'Câu Hỏi về PHP'	,'2020-04-05'),
						(N'Hỏi về C#'		,'2020-04-06'),
						(N'Hỏi về Ruby'		,'2020-04-06'),
						(N'Hỏi về Postman'	,'2020-04-06'),
						(N'Hỏi về ADO.NET'	,'2020-04-06'),
						(N'Hỏi về ASP.NET'	,'2020-04-06'),
						(N'Hỏi về C++'		,'2020-04-07'),
						(N'Hỏi về SQL'		,'2020-04-07'),
						(N'Hỏi về Python'	,'2020-04-07');

-- Add data Answers
INSERT INTO Answer	(  Content		, isCorrect	)
VALUES 				(N'Trả lời 01'	,	0		),
					(N'Trả lời 02'	,	1		),
                    (N'Trả lời 03'	,	0		),
                    (N'Trả lời 04'	,	1		),
                    (N'Trả lời 05'	,	1		),
                    (N'Trả lời 06'	,	1		),
                    (N'Trả lời 07'	,	0		),
                    (N'Trả lời 08'	,	0		),
                    (N'Trả lời 09'	,	1		),
                    (N'Trả lời 10'	,	1		);
	
-- Add data Exam
INSERT INTO Exam	(`Code1`			, Title				, Duration	,  CreateDate )
VALUES 				('S-1'			, N'Đề thi C#'			,	60		, '2019-04-05'),
					('S-2'			, N'Đề thi PHP'			,	60		, '2019-04-05'),
                    ('M-1'			, N'Đề thi C++'			,	120		, '2019-04-07'),
                    ('S-3'			, N'Đề thi Java'		,	60		, '2020-04-08'),
                    ('M-2'			, N'Đề thi Ruby'		,	120		, '2020-04-10'),
                    ('S-4'			, N'Đề thi Postman'		,	60		, '2020-04-05'),
                    ('S-5'			, N'Đề thi SQL'			,	60		, '2020-04-05'),
                    ('S-6'			, N'Đề thi Python'		,	60		, '2020-04-07'),
                    ('L-1'			, N'Đề thi ADO.NET'		,	180		, '2020-04-07'),
                    ('L-2'			, N'Đề thi ASP.NET'		,	180		, '2020-04-08');
