
DROP TABLE IF EXISTS `classroom`;
CREATE TABLE `classroom` (
  `id` int NOT NULL AUTO_INCREMENT,
  `number` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;

LOCK TABLES `classroom` WRITE;
INSERT INTO `classroom` VALUES (1,401),(2,402),(5,404),(6,405),(7,406),(8,407),(9,408);
UNLOCK TABLES;


DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int NOT NULL AUTO_INCREMENT,
  `number` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

LOCK TABLES `course` WRITE;
INSERT INTO `course` VALUES (1,1),(2,2),(3,3),(4,4);
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


DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int NOT NULL AUTO_INCREMENT,
  `surname` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `patronymic` varchar(45) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;

LOCK TABLES `teacher` WRITE;
INSERT INTO `teacher` VALUES (1,'Иванов','Иван','Иванович','example@mail.ru','89000000000'),(5,'Федоров','Федор','Федорович','fedos45@mail.ru','89043587345');
UNLOCK TABLES;

DROP TABLE IF EXISTS `time`;
CREATE TABLE `time` (
  `id` int NOT NULL AUTO_INCREMENT,
  `number` int NOT NULL,
  `start` time NOT NULL,
  `end` time NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `number_UNIQUE` (`number`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;


LOCK TABLES `time` WRITE;
INSERT INTO `time` VALUES (1,1,'08:15:00','09:55:00'),(3,2,'10:00:00','11:50:00'),(4,3,'12:00:00','13:45:00'),(5,4,'13:55:00','14:40:00'),(9,5,'14:45:00','16:20:00'),(10,6,'16:25:00','17:10:00');
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;

LOCK TABLES `schedule` WRITE;
INSERT INTO `schedule` VALUES (1,'2024-04-04',1,2,1,1,1,1),(5,'2024-05-27',3,8,1,3,2,3),(6,'2024-06-06',3,6,5,3,1,3),(7,'2024-06-08',3,8,1,3,3,3),(8,'2024-06-08',2,6,5,3,3,3);
UNLOCK TABLES;

