-- =============================================
-- INSERT DATA 
-- =============================================
USE hb_ts_as1;
INSERT INTO `User` (`username`,			`email`,						`password`,			`firstName`,	`lastName`,		`gender`,
										`date_Of_Birth` ,  				`address` ,  		`phone` , 		 `role` ,		 `status`	)
-- password: password
VALUE			('hanh.havan@vti',		'hanhhanoi1999@gmail.com',		'$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu',		'Hà',			'Văn Hanh',			'M', '1999-08-07',			'Hải Dương',		'0397685637',	'MANAGER',		0), 
				('thanhhung12@vti',		'hung122112@gmail.com',			'$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu',		'Nguyễn ',		'Thanh Hưng',		'M', '1998-03-28',			'Nam Định',			'0383929264',	'MANAGER',		0), 
				('can.tuananh@vti',		'cananh.tuan12@vti.com',		'$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu',		'Cấn',			'Tuấn Anh',			'M', '1998-10-20',			'Hà Nội',			'0971133263',	'MANAGER',		0), 
				('toananh123@vti',		'toananh123@vti.com',			'$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu',		'Nguyễn',		'Anh Toàn',			'M', '1992-10-15',			'Hà Nội',			'0898999315',	'MANAGER',		0), 
				('duynn03@gmail.com',	'duynn03@gmail.com',			'$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu',		'Nguyễn',		'Duy',				'M', '1995-10-15',			'Nam Định',			'0898912125',	'MANAGER',		0), 
				('manhhung123@vti',		'manhhung123@vti.com',			'$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu',		'Nguyễn',		'Mạnh Hùng',		'M', '1998-09-27',			'Hà Nội',			'0992226789',	'MANAGER',		0),
 				('maianhvti123',		'maianhng@gmail.com', 			'$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu',		'Nguyễn',		'Mai Anh',			'F', '1999-05-02',			'Hà Nội',			'03944725474',	'EMPLOYEE',		0),
				('tuanvti12344',		'tuan1234@gmail.com', 			'$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu',		'Nguyễn',		'Văn Tuấn',			'M', '1999-06-02',			'Quảng Ninh',		'03988725474',	'EMPLOYEE',		0),
				('ngthuy123',			'thuyhanoi@gmail.com', 			'$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu',		'Nguyễn',		'Thị Thủy',			'F', '1999-07-02',			'Hải Dương',		'03919925474',	'EMPLOYEE',		0),
				('quanganhvti',			'quanganh@gmail.com', 			'$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu',		'Nguyễn',		'Quang Anh',		'M', '1989-05-12',			'Hà Nam',			'03912225474',	'MANAGER',		0),
				('hoanghungvti',	    'hunghoang@gmail.com', 			'$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu',		'Vũ',			'Hoàng Hưng',		'M', '1988-05-02',			'Bắc Ninh',			'03914425474',	'EMPLOYEE',		0),
				('quocanhvti',			'quocanh12@gmail.com', 			'$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu',		'Nguyễn',		'Quốc Anh',			'M', '1990-09-09',			'Hà Nội',			'03913325474',	'ADMIN',		0),
				('vananhvti',			'vananhb1@gmail.com', 			'$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu',		'Nguyễn',		'Vân Anh',			'F', '1999-09-09',			'Hà Nội',			'03918825474',	'EMPLOYEE',		0),
				('mailanvti',			'mailan123@gmail.com', 			'$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu',		'Nguyễn',		'Ngọc Bảo Lan',		'F', '1988-10-10',			'Hà Nội',			'03999925474',	'MANAGER',		0),
				('tuanhungvti',			'tuanhung@gmail.com', 			'$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu',		'Vũ',			'Tuấn Hưng',		'M', '1999-09-03',			'Hà Nội',			'03122225474',	'EMPLOYEE',		0),
				('xuanmaivti',			'xuanmai12@gmail.com', 			'$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu',		'Nguyễn',		'Xuân Mai',			'F', '1987-08-02',			'Hà Nội',			'03988825474',	'EMPLOYEE',		0);
				
 


INSERT INTO `Group` (`name` ,		`author_ID`, 	create_time)

VALUE				('Java Fresher',		4, 			'2020-03-03'),			
					('Java Web',			4, 			'2020-03-03'),			
					('C# Fresher',		    4, 			'2020-03-03');
                    
  
 
INSERT INTO `User_Group` 	(`group_id` ,	`user_id`, 		join_time)
VALUE					 	('1',				4, 			'2007-03-28 09:29:30'), 
							('1',				3, 			'2007-03-28 09:29:30'), 
							('1',				2, 			'2007-03-28 09:29:30'),
							('2',				1, 			'2007-03-28 09:29:30'),
							('2',				5, 			'2007-03-28 09:29:30'),
							('2',				7, 			'2007-03-28 09:29:30'),
							('3',				8, 			'2007-03-28 09:29:30'),
							('3',				9, 			'2007-03-28 09:29:30'),
							('3',				10, 		'2007-03-28 09:29:30');
							
  
  
  
  
INSERT INTO `Testing_Category` (`name` ,						`author_ID`, 	create_time)
VALUE							('Java ',						4, 				'2007-02-28 09:29:30'),
								('C# ',							4, 				'2007-02-28 13:29:30'),
								('Tiếng Anh chuyên ngành ',		8, 				'2007-02-28 15:29:30'),
								('SQL ',						8, 				'2007-02-27 07:29:30');
								


INSERT INTO `Question_Category` (`name` ,					`Testing_Category_ID`,		author_ID,			create_time)
VALUE							('OOP',							1, 							4,				'2007-02-28 09:29:30'),
								('Hibernate',					1, 							4,				'2007-02-28 09:50:30'),
								('.Net',						2, 							4,				'2007-02-28 10:15:30'),
								('C# basic',					2, 							4,				'2007-02-28 13:29:30'),
								('Tiếng Anh chuyên ngành',		3, 							8,				'2007-02-28 09:29:30'),
								('SQL',							4, 							4,				'2007-02-28 16:29:30');
                                

								
INSERT INTO `Question_Level`    (`level`)
VALUE						    ("Easy"),
								("Medium"),
								("Hard"),
								("Very Hard");
                                
INSERT INTO `Image`   		 	(`name` ,					`author_ID`,		create_time)
VALUE						    ('Profile photo',				8,				'2007-02-28 09:29:30');
								

INSERT INTO `Question`  (`title` ,																`Question_Category_ID`,		`type`,			`level_ID`,		`version`,		`author_ID`,	`create_time`)
VALUE					(' Trường khóa chính là trường',	 										6,	  					'Essay',			 1,   			1,			  8			,  '2007-02-28 09:29:30'),
						(' Tiêu chí nào sau đây thường được dùng để chọn khóa chính?',	 			6,	  					'Essay',			 1,   			1,			  8			,  '2007-02-28 09:29:30'),
						(' Thế nào là cơ sở dữ liệu quan hệ?',	 									6,	  					'Essay',			 1,   			1,			  8			,  '2007-02-28 09:29:30'),
						(' Liên kết giữa các bảng được dựa trên',	 								6,	  					'Essay',			 1,   			1,			  8			,  '2007-02-28 09:29:30'),
						('  Các bước chính để tạo CSDL',	 										6,	  					'Essay',			 1,   			1,			  8			,  '2007-02-28 09:29:30');
            
INSERT INTO `Answer`  	(`question_ID` ,	`key`,		is_correct		)
VALUE					(1,				'Unique Key',	FALSE),
						(1,				'First Key',	FALSE),
						(1,				'Primary Key ',	TRUE),
						(1,				'Single Key',	FALSE),
                        
						(2,				'Khóa có ít thuộc tính nhất',	TRUE),
						(2,				'Không chứa các thuộc tính thay đổi theo thời gian',	FALSE),
						(2,				'Khóa bất kì',	FALSE),
						(2,				'Chỉ là khóa có một thuộc tính ',	FALSE),
                        
						(3,				'Cơ sở dữ liệu được xây dựng dựa trên mô hình dữ liệu quan hệ ',		FALSE),
						(3,				'Cơ sở dữ liệu dùng để tạo lập, cập nhật và khai thác CSDL quan hệ ',	FALSE),
						(3,				'Cơ sở dữ liệu được xây dựng dựa trên mô hình dữ liệu quan hệ và khai thác CSDL quan hệ',	FALSE),
						(3,				'Cơ sở dữ liệu dùng để tạo lập, cập nhật và khai thác CSDL quan hệ dựa trên mô hình dữ liệu quan hệ ',	TRUE),
                        
						(4,				'Thuộc tính khóa  ',	TRUE),
						(4,				'Các thuộc tính trùng tên nhau giữa các bảng ',	FALSE),
						(4,				'Ý định của người quản trị hệ CSDL ',	FALSE),
						(4,				'Ý định ghép các bảng thành một bảng có nhiều thuộc tính hơn  ',	FALSE);
                        
                        
            
INSERT INTO `Testing`  	(`name` ,		`Testing_Category_ID`,		`time`	,		`generation_Type`,		`version`,	`status`,	
											examiner_ID,		`author_ID`,		create_time		)
                                            
VALUE					('SQL',		4,		60,		"Custom",		1,			0,			4,		8,		'2007-02-28 09:29:30'),
						('JAVA',	4,		70,		"Custom",		1,			0,			3,		7,		'2007-02-28 09:29:30');


                       
INSERT INTO `Question_Testing`  	(`question_id` ,	`testing_id` )
VALUE								(	1,					1),				
									(	2,					1),	
									(	3,					1),	
									(	4,					1);


INSERT INTO `Exam`  	(`name`,			`start_time` ,			`end_time`, 			`version`,		`status`,		author_ID,		create_time  )
VALUE					('Tuyển fresher ',	'2007-04-28 08:00:00',	'2007-02-28 10:00:00',		1,			0,				8,			'2007-02-28 09:29:30');
	
INSERT INTO `Exam`  	(`name`,			`start_time` ,			`end_time`, 			`version`,		`status`,		author_ID,		create_time  )
VALUE					('Tuyển fresher1 ',	'2007-04-28 08:00:00',	'2007-02-28 10:00:00',		1,			0,				8,			'2007-02-28 09:29:30');
    
INSERT INTO `Testing_Exam`  	(`exam_id`,			`testing_id`   )
VALUE							(1,					1);