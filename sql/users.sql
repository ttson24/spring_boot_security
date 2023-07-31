CREATE DATABASE  IF NOT EXISTS `spring_boot_security`;
USE `spring_boot_security`;

--
-- Table structure for table `users`
--
DROP TABLE IF EXISTS `roles`;
DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name`varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password`varchar(120) NOT NULL,
  `active` tinyint NOT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP DEFAULT NULL,
  `deleted_at` TIMESTAMP DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--

INSERT INTO `users` VALUES 
	(1,'Tran','Thanh','tranthanh@gmail.com','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 1,CURRENT_TIMESTAMP, null, null),
	(2,'Le','Tuan','letuan@gmail.com','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 1,CURRENT_TIMESTAMP, null, null),
	(3,'Nguyen','Huy','nguyenhuy@gmail.com','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 1,CURRENT_TIMESTAMP, null, null),
	(4,'Thai','Tam','thaitam@gmail.com','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 1,CURRENT_TIMESTAMP, null, null),
	(5,'Dinh','Toan','dinhtoan@gmail.com','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 1,CURRENT_TIMESTAMP, null, null);
    

CREATE TABLE `roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `role` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `authorities5_idx_1` (`user_id`,`role`),
  CONSTRAINT `authorities5_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `roles`
--

INSERT INTO `roles`
VALUES
(1,1,'ROLE_EMPLOYEE'),
(2,2,'ROLE_MANAGER'),
(3,3,'ROLE_EMPLOYEE'),
(4,4,'ROLE_MANAGER'),
(5,5,'ROLE_ADMIN');