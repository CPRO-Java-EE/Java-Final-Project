CREATE DATABASE  IF NOT EXISTS `media_schema`;
USE `media_schema`;

--
-- Table structure for table `media`
--

DROP TABLE IF EXISTS `media`;

CREATE TABLE `media` (
  `media_id` int NOT NULL AUTO_INCREMENT,
  `capsule_id` int NOT NULL,
  `media_type` varchar(45) NOT NULL,
  `media_description` varchar(200) DEFAULT NULL,
  `file_path` varchar(100) NOT NULL,
  `upload_date` DATETIME DEFAULT NULL,
  PRIMARY KEY (`media_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `media`
--

INSERT INTO `media` VALUES
	(1,'1', 'Video', 'Summer Vacation', '/server/filepath', '2025-02-11 14:30:00'),
	(2,'1', 'Picture', 'My Wedding', '/server/filepath', '2025-03-11 14:30:00'),
	(3,'2', 'Video', 'Baby Steps', '/server/filepath', '2024-02-11 14:30:00'),
	(4,'2', 'Audio', 'Hello Future Self', '/server/filepath', '2020-02-21 14:30:00'),
	(5,'3', 'Picture', 'Grandma and Grandpa', '/server/filepath', '2021-11-14 14:30:00');

