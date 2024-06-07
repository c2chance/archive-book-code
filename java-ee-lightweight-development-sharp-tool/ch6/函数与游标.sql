-- 代码清单6-1　FN_GET_TITLE
DELIMITER $$ 
USE `manage`$$ 
DROP FUNCTION IF EXISTS `FN_GET_TITLE`$$ 
CREATE DEFINER=`admin`@`%` FUNCTION `FN_GET_TITLE`(CITY CHAR(32)) RETURNS VARCHAR(500) 
CHARSET utf8 
BEGIN 
  DECLARE i INT;
  SET i = 0;
  SET @result = '';
  SET @CITY = CITY;
  SET @cityCount = 0;
  SET @goodsTitle = '';
  SELECT COUNT(*) INTO @cityCount FROM goods_sendcount goods WHERE goods.city = @CITY;
  IF @cityCount = 1 THEN  
    SELECT goods.goods INTO @goodsTitle FROM goods_sendcount goods WHERE goods.city = @CITY;
    SET @result = @goodsTitle;
  ELSE 
    WHILE i < @cityCount DO  
      SELECT goods.goods INTO @goodsTitle FROM goods_sendcount goods WHERE goods.city = 
@CITY LIMIT i, 1;
      SET @result = CONCAT(@result,@goodsTitle,",");
      SET i = i + 1;
    END WHILE;
  END IF;
  RETURN @result;
END$$ 
DELIMITER ;



-- 代码清单6-2　SC_TITLE_VALIDAT
DELIMITER $$ 
USE `manage`$$ 
DROP PROCEDURE IF EXISTS `SC_TITLE_VALIDAT`$$ 
CREATE DEFINER=`admin`@`%` PROCEDURE `SC_TITLE_VALIDAT`(IN city CHAR(32), OUT success INT)
BEGIN 
  DECLARE no_more_record INT DEFAULT 0;
  DECLARE pValue CHAR(32);
 
  DECLARE cur_record CURSOR FOR SELECT goods FROM goods_sendcount t WHERE city = city;
  DECLARE CONTINUE HANDLER FOR NOT FOUND   
  SET  no_more_record = 1;
  SELECT COUNT(goods)INTO @goodsCount FROM goods_sendcount t WHERE city = city;
  IF @goodsCount = 1;
    SET success = 1;
  ELSE 
    OPEN  cur_record;
    FETCH  cur_record INTO pValue;
 
    WHILE no_more_record != 1 DO 
      SELECT SUM(AMOUNT) AS AMOUNT INTO @goodsTemp FROM goods_sendcount WHERE goods = pValue;
      SET @goodsCount = @goodsCount + @goodsTemp;
      FETCH  cur_record INTO pValue;
    END WHILE;
    CLOSE  cur_record;
    CASE WHEN @goodsCount > 10 THEN  
      SET success = 10;
      WHEN @goodsCount > 100 THEN  
        SET success = 100;
    END CASE;
  END IF;
END$$ 
DELIMITER ;



-- 代码清单6-3　SC_DELETE
DELIMITER $$ 
USE `manage`$$ 
DROP PROCEDURE IF EXISTS `SC_DELETE`$$ 
CREATE DEFINER=`admin`@`%` PROCEDURE `SC_DELETE`(IN CITY CHAR(32), OUT success CHAR(2)) 
BEGIN 
  DELETE goods_sendcount WHERE city = CITY;
  SET success=1;
END$$ 
DELIMITER ;



-- 代码清单6-4　SC _LIST
DELIMITER $$ 
USE `manage`$$ 
DROP PROCEDURE IF EXISTS `SC _LIST `$$ 
CREATE DEFINER=`admin`@`%` PROCEDURE `SC_ LIST `(IN CITY CHAR(32), OUT totalRecords INT)
BEGIN 
  SET @CITY = CITY;
  SET @sql = CONCAT('select * from goods_sendcount where city = ?');
  PREPARE _stmt FROM @sql;
  EXECUTE _stmt USING @CITY;
  DEALLOCATE PREPARE _stmt;
END$$ 
DELIMITER ;




