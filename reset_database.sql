use shop;

DROP USER IF EXISTS 'a1'@'localhost';
CREATE USER IF NOT EXISTS 'a1'@'localhost' identified BY 'a1';
GRANT SELECT, INSERT, UPDATE ON shoeClass TO 'a1'@'localhost';
GRANT SELECT, INSERT, UPDATE ON shirtClass TO 'a1'@'localhost';
GRANT SELECT, INSERT, UPDATE ON glovesClass TO 'a1'@'localhost';
GRANT SELECT, INSERT, UPDATE ON pantsClass TO 'a1'@'localhost';
GRANT SELECT, INSERT, UPDATE ON user TO 'a1'@'localhost';
GRANT SELECT, INSERT, UPDATE ON orders TO 'a1'@'localhost';
GRANT SELECT, INSERT, UPDATE ON orderDetails TO 'a1'@'localhost';
GRANT SELECT, INSERT, UPDATE ON admin TO 'a1'@'localhost';
GRANT SELECT, INSERT, UPDATE ON stockstaff TO 'a1'@'localhost';

DROP USER IF EXISTS 'u1'@'localhost';
CREATE USER IF NOT EXISTS 'u1'@'localhost' identified BY 'u1';
GRANT SELECT ON shoeClass TO 'u1'@'localhost';
GRANT SELECT ON shirtClass TO 'u1'@'localhost';
GRANT SELECT ON glovesClass TO 'u1'@'localhost';
GRANT SELECT ON pantsClass TO 'u1'@'localhost';
GRANT SELECT ON user TO 'u1'@'localhost';
GRANT SELECT, INSERT ON orders TO 'u1'@'localhost';
GRANT INSERT ON orderDetails TO 'u1'@'localhost';

DROP USER IF EXISTS 'l1'@'localhost';
CREATE USER IF NOT EXISTS 'l1'@'localhost' identified BY 'l1';
GRANT SELECT, INSERT, UPDATE ON shoeClass TO 'l1'@'localhost';
GRANT SELECT, INSERT, UPDATE ON shirtClass TO 'l1'@'localhost';
GRANT SELECT, INSERT, UPDATE ON glovesClass TO 'l1'@'localhost';
GRANT SELECT, INSERT, UPDATE ON pantsClass TO 'l1'@'localhost';
GRANT SELECT  ON user TO 'l1'@'localhost';
GRANT SELECT ON admin TO 'l1'@'localhost';
GRANT SELECT ON stockstaff TO 'l1'@'localhost';
GRANT SELECT, INSERT, UPDATE, DELETE ON orders TO 'l1'@'localhost';
GRANT SELECT, INSERT, UPDATE ON orderDetails TO 'l1'@'localhost';


DROP TABLE IF EXISTS orderDetails;
DROP TABLE IF EXISTS orders;

CREATE TABLE IF NOT EXISTS orders (
	`orderID` int(11) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (orderID)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS orderDetails (
	orderID int(11),
    id int(11) NOT NULL, 
    tableName varchar(45) NOT NULL, 
    amount int(11), 
    username varchar(45),
    PRIMARY KEY(orderID, id, tableName),
    FOREIGN KEY (orderID) REFERENCES orders(orderID)
    ON DELETE CASCADE
    ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS glovesClass;
CREATE TABLE IF NOT EXISTS `glovesClass` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `price` float NOT NULL,
  `stock` int(11) NOT NULL CHECK (test_column > -1),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS shoeClass;
CREATE TABLE IF NOT EXISTS `shoeClass` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `price` float NOT NULL,
  `stock` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS pantsClass;
CREATE TABLE IF NOT EXISTS `pantsClass` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `price` float NOT NULL,
  `stock` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS shirtClass;
CREATE TABLE IF NOT EXISTS `shirtClass` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `price` float NOT NULL,
  `stock` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS user;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS admin;
CREATE TABLE IF NOT EXISTS `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `user_UNIQUE` (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS stockstaff;
CREATE TABLE IF NOT EXISTS `stockstaff` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `user_UNIQUE` (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



INSERT INTO user (username, password, firstName, lastName, email) VALUES('u1', 'u1', 'u1fn', 'u1ln', 'u1email');
INSERT INTO admin (username, password, firstName, lastName, email) VALUES ('a1', 'a1', 'a1fn', 'a1ln', 'a1email');
INSERT INTO stockstaff (username, password, firstName, lastName, email) VALUES('l1', 'l1', 'l1fn', 'l1ln', 'l1email');

INSERT INTO shop.shoeClass (name, price, stock) VALUES('Puma',100, 24);
INSERT INTO shop.shoeClass (name, price, stock) VALUES('Adidas',120, 6);
INSERT INTO shop.shoeClass (name, price, stock) VALUES('Nike',89, 24);
INSERT INTO shop.shoeClass (name, price, stock) VALUES('Titleist',200, 9);
INSERT INTO shop.shoeClass (name, price, stock) VALUES('Ping',160, 16);

INSERT INTO shop.shirtClass (name, price, stock) VALUES('Canvas',130, 14);
INSERT INTO shop.shirtClass (name, price, stock) VALUES('Anvil',250, 12);
INSERT INTO shop.shirtClass (name, price, stock) VALUES('Soffe',100, 34);
INSERT INTO shop.shirtClass (name, price, stock) VALUES('Hanes',80, 38);

INSERT INTO shop.glovesClass (name, price, stock) VALUES('Everlast',30, 6);
INSERT INTO shop.glovesClass (name, price, stock) VALUES('Fighting',220, 7);
INSERT INTO shop.glovesClass (name, price, stock) VALUES('Onsdale',90, 26);
INSERT INTO shop.glovesClass (name, price, stock) VALUES('Bolmeer',60, 25);

INSERT INTO shop.pantsClass (name, price, stock) VALUES('Diesel',320, 22);
INSERT INTO shop.pantsClass (name, price, stock) VALUES('Lee',190, 52);
INSERT INTO shop.pantsClass (name, price, stock) VALUES('Guess',180, 23);
INSERT INTO shop.pantsClass (name, price, stock) VALUES('Monday',170, 32);
