CREATE DATABASE `shop` /*!40100 DEFAULT CHARACTER SET latin1 */;

CREATE TABLE orders (
	id int(11) NOT NULL, 
    tableName varchar(45) NOT NULL, 
    amount int(11), 
    username varchar(45), 
    PRIMARY KEY(id, tableName)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `glovesClass` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `price` float NOT NULL,
  `stock` int(11) NOT NULL CHECK (test_column > -1),
  PRIMARY KEY (`glovesID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `shoeClass` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `price` float NOT NULL,
  `stock` varchar(45) NOT NULL,
  PRIMARY KEY (`shoeID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `pantsClass` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `price` float NOT NULL,
  `stock` int(11) NOT NULL,
  PRIMARY KEY (`pantsID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `shirtClass` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `price` float NOT NULL,
  `stock` varchar(45) NOT NULL,
  PRIMARY KEY (`shirtID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `user` (
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


CREATE TABLE `admin` (
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
