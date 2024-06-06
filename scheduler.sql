CREATE DATABASE  IF NOT EXISTS `college_schedule` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `college_schedule`;
DROP TABLE IF EXISTS `classroom`;
CREATE TABLE `classroom` (
  `id` int NOT NULL AUTO_INCREMENT,
  `number` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

LOCK TABLES `classroom` WRITE;
INSERT INTO `classroom` VALUES (1,401),(2,402),(3,403),(4,6);
UNLOCK TABLES;

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `id` int NOT NULL AUTO_INCREMENT,
  `number` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

LOCK TABLES `course` WRITE;
INSERT INTO `course` VALUES (1,1),(2,2),(3,3);
UNLOCK TABLES;

DROP TABLE IF EXISTS `group`;
CREATE TABLE `group` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

LOCK TABLES `group` WRITE;
INSERT INTO `group` VALUES (1,'ИСиП'),(2,'Право'),(3,'Коммерция');
UNLOCK TABLES;

DROP TABLE IF EXISTS `lesson`;

CREATE TABLE `lesson` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

LOCK TABLES `lesson` WRITE;
INSERT INTO `lesson` VALUES (1,'БЖД'),(2,'Физра'),(3,'Английский');
UNLOCK TABLES;

DROP TABLE IF EXISTS `schedule`;
CREATE TABLE `schedule` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `lesson_id` int NOT NULL,
  `classroom_id` int NOT NULL,
  `teacher_id` int NOT NULL,
  `time_id` int NOT NULL,
  `group_id` int NOT NULL,
  `course_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_schedule_lesson_idx` (`lesson_id`),
  KEY `fk_schedule_classroom1_idx` (`classroom_id`),
  KEY `fk_schedule_teacher1_idx` (`teacher_id`),
  KEY `fk_schedule_time1_idx` (`time_id`),
  KEY `fk_schedule_course1_idx` (`course_id`),
  KEY `fk_schedule_group1_idx` (`group_id`),
  CONSTRAINT `fk_schedule_classroom1` FOREIGN KEY (`classroom_id`) REFERENCES `classroom` (`id`),
  CONSTRAINT `fk_schedule_course1` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`),
  CONSTRAINT `fk_schedule_group1` FOREIGN KEY (`group_id`) REFERENCES `group` (`id`),
  CONSTRAINT `fk_schedule_lesson` FOREIGN KEY (`lesson_id`) REFERENCES `lesson` (`id`),
  CONSTRAINT `fk_schedule_teacher1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`),
  CONSTRAINT `fk_schedule_time1` FOREIGN KEY (`time_id`) REFERENCES `time` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

LOCK TABLES `schedule` WRITE;
INSERT INTO `schedule` VALUES (1,'2024-04-04',1,2,1,1,1,1);
UNLOCK TABLES;


DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `id` int NOT NULL AUTO_INCREMENT,
  `surname` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `patronymic` varchar(45) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;


LOCK TABLES `teacher` WRITE;
INSERT INTO `teacher` VALUES (1,'Иван','Иванов','Иванович','example@mail.ru','89000000000'),(4,'Петр','Петров','Петрович','petrovich@mail.ru','89999999999');
UNLOCK TABLES;

DROP TABLE IF EXISTS `time`;
CREATE TABLE `time` (
  `id` int NOT NULL AUTO_INCREMENT,
  `number` int NOT NULL,
  `start` time NOT NULL,
  `end` time NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `number_UNIQUE` (`number`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

LOCK TABLES `time` WRITE;
INSERT INTO `time` VALUES (1,1,'08:15:00','09:55:00');
UNLOCK TABLES;
