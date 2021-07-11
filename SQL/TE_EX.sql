-- Ques2 Viết lệnh lấy ra thông tin của khách hàng: tên, số lượng oto khách hàng đã
-- mua và sắp sếp tăng dần theo số lượng oto đã mua.
WITH CTE_CarEachCustomer AS(
	SELECT co.CustomerID, SUM(co.Amount) am from car_order co
	WHERE co.Staus = 0
	GROUP BY co.CustomerID
	HAVING SUM(co.Amount) > 0
	ORDER BY SUM(co.Amount)
)
SELECT c.`Name`,ce.am from customer c JOIN CTE_CarEachCustomer ce ON c.CustomerID = ce.CustomerID;

-- Ques3 Viết hàm (không có parameter) trả về tên hãng sản xuất đã bán được nhiều
-- oto nhất trong năm nay.
SET GLOBAL log_bin_trust_function_creators = 1;0
DROP FUNCTION IF EXISTS Ques3;
DELIMITER$$
CREATE FUNCTION Ques3() RETURNS VARCHAR(50)
BEGIN
	DECLARE name_cus VARCHAR(50);
	WITH CTE_max_car_sell AS
	(
		SELECT co.CustomerID, SUM(co.Amount) am from car_order co
		WHERE co.Staus = 0
		GROUP BY co.CustomerID
		HAVING SUM(co.Amount) > 0
		ORDER BY SUM(co.Amount) DESC
		LIMIT 1
	)
	SELECT c.`Name` INTO name_cus from car_order co
	JOIN customer c ON c.CustomerID = co.CustomerID
	GROUP BY co.CustomerID
	HAVING SUM(co.Amount) = (SELECT am from CTE_max_car_sell);
	
	return name_cus;
END$$
DELIMITER;
-- Ques4 Viết 1 thủ tục (không có parameter) để xóa các đơn hàng đã bị hủy của
-- những năm trước. In ra số lượng bản ghi đã bị xóa.
DROP PROCEDURE IF EXISTS Ques3;
DELIMITER $$
CREATE PROCEDURE Ques3()
BEGIN
	DELETE FROM car_order co WHERE co.Staus = 2 AND YEAR(CURRENT_DATE) > YEAR(co.OrderDate);
	SELECT ROW_COUNT() as DelRowCount;
END $
DELIMITER;

-- Ques5 Viết 1 thủ tục (có CustomerID parameter) để in ra thông tin của các đơn
-- hàng đã đặt hàng bao gồm: tên của khách hàng, mã đơn hàng, số lượng oto
-- và tên hãng sản xuất.
DROP PROCEDURE IF EXISTS Ques5;
DELIMITER $$
CREATE PROCEDURE Ques5(IN in_cus_id int)
BEGIN
	SELECT * from car_order co
	JOIN car c On co.CarID = c.CarID
	WHERE co.CustomerID = in_cus_id;
END $
DELIMITER;

-- Ques6 Viết trigger để tránh trường hợp người dụng nhập thông tin không hợp lệ
-- vào database (DeliveryDate < OrderDate + 15).
DROP TRIGGER IF EXISTS Ques6;
DELIMITER$$
CREATE TRIGGER Ques6 BEFORE INSERT ON car_order
FOR EACH ROW
BEGIN
  DECLARE		DeliveryDate_IN	DATE;
  DECLARE   OrderDate_IN		DATE;
	-- 
	SET DeliveryDate_IN := (SELECT DeliveryDate  from NEW);
  SET OrderDate_IN := (SELECT OrderDate  from NEW);
	IF DeliveryDate_IN < DATE_ADD(OrderDate_IN, INTERVAL 15 DAY)
		THEN SIGNAL SQLSTATE '02000' SET MESSAGE_TEXT = 'Warning: 2 date cannot over 15 days!';
	END IF;
END $$
DELIMITER ;