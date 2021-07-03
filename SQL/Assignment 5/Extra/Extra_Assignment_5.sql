-- ------------------- Exe1

-- Ques1
SELECT *
FROM   product
WHERE  productsubcategoryid = (SELECT productsubcategoryid
                               FROM   productsubcategory
                               WHERE  `name` LIKE 'Saddles')
-- Ques2
SELECT *
FROM   product
WHERE  productsubcategoryid IN (SELECT productsubcategoryid
                               FROM   productsubcategory
                               WHERE  `name` LIKE 'Bo%')
															 
-- Ques3
SELECT p.`Name`,
       p.Size
FROM   product p
WHERE  p.ListPrice = (SELECT Min(listprice)
											FROM   product
											WHERE  listprice > 0
                           AND productsubcategoryid = 3)
       AND productsubcategoryid = 3 
			 
-- ------------------- Exe2

-- Ques1
SELECT cr.`name` Country,
       sp.`name` Province
FROM   countryregion cr
       JOIN stateprovince sp ON cr.countryregioncode = sp.countryregioncode 

-- Ques2
SELECT cr.`name` Country,
       sp.`name` Province
FROM   countryregion cr
       JOIN stateprovince sp ON cr.countryregioncode = sp.countryregioncode 
WHERE cr.`Name` IN (N'Germany', N'Canada')
ORDER BY cr.`Name` ASC

-- Ques3
SELECT soh.salesorderid,
       soh.orderdate,
       sp.salespersonid,
       sp.salespersonid AS BusinessEntityID,
       sp.bonus,
       sp.salesytd
FROM   salesperson sp
       JOIN salesorderheader soh ON sp.salespersonid = soh.salespersonid 
			 
-- Ques4
SELECT soh.salesorderid,
       soh.orderdate,
       e.Title,
       sp.bonus,
       sp.salesytd
FROM   salesperson sp
       JOIN salesorderheader soh ON sp.salespersonid = soh.salespersonid
			 JOIN  employee e ON sp.SalesPersonID = e.EmployeeID
