CREATE DATABASE  IF NOT EXISTS `spring_boot_security`;
USE `spring_boot_security`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP DEFAULT NULL,
  `deleted_at` TIMESTAMP DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--

INSERT INTO `employee` VALUES 
	(1,'Leslie','Andrews','leslie@luv2code.com',CURRENT_TIMESTAMP, null, null),
	(2,'Emma','Baumgarten','emma@luv2code.com',CURRENT_TIMESTAMP, null, null),
	(3,'Avani','Gupta','avani@luv2code.com',CURRENT_TIMESTAMP, null, null),
	(4,'Yuri','Petrov','yuri@luv2code.com',CURRENT_TIMESTAMP, null, null),
	(5,'Juan','Vega','juan@luv2code.com',CURRENT_TIMESTAMP, null, null);

