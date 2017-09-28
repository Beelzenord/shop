use shop;


CREATE USER IF NOT EXISTS 'root'@'localhost' identified BY 'root';
GRANT SELECT, INSERT, UPDATE ON shoeClass TO 'root'@'localhost';
GRANT SELECT, INSERT, UPDATE ON shirtClass TO 'root'@'localhost';
GRANT SELECT, INSERT, UPDATE ON glovesClass TO 'root'@'localhost';
GRANT SELECT, INSERT, UPDATE ON pantsClass TO 'root'@'localhost';
GRANT SELECT, INSERT, UPDATE ON user TO 'root'@'localhost';

CREATE USER IF NOT EXISTS 'a1'@'localhost' identified BY 'a1';
GRANT SELECT, INSERT, UPDATE ON shoeClass TO 'a1'@'localhost';
GRANT SELECT, INSERT, UPDATE ON shirtClass TO 'a1'@'localhost';
GRANT SELECT, INSERT, UPDATE ON glovesClass TO 'a1'@'localhost';
GRANT SELECT, INSERT, UPDATE ON pantsClass TO 'a1'@'localhost';
GRANT SELECT, INSERT, UPDATE ON user TO 'a1'@'localhost';
GRANT SELECT, INSERT, UPDATE ON orders TO 'a1'@'localhost';
GRANT SELECT, INSERT, UPDATE ON orderDetails TO 'a1'@'localhost';
GRANT SELECT, INSERT, UPDATE ON admin TO 'a1'@'localhost';

CREATE USER IF NOT EXISTS 'u1'@'localhost' identified BY 'u1';
GRANT SELECT, INSERT, UPDATE ON shoeClass TO 'u1'@'localhost';
GRANT SELECT, INSERT, UPDATE ON shirtClass TO 'u1'@'localhost';
GRANT SELECT, INSERT, UPDATE ON glovesClass TO 'u1'@'localhost';
GRANT SELECT, INSERT, UPDATE ON pantsClass TO 'u1'@'localhost';
GRANT SELECT, INSERT, UPDATE ON user TO 'u1'@'localhost';
GRANT SELECT, INSERT, UPDATE ON orders TO 'u1'@'localhost';
GRANT SELECT, INSERT, UPDATE ON orderDetails TO 'u1'@'localhost';
