-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: travelbyex
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `appointment_participant`
--

DROP TABLE IF EXISTS `appointment_participant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `appointment_participant` (
  `user_id` varchar(15) NOT NULL,
  `appointment_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`appointment_id`),
  KEY `FK_appoitment_to_participant` (`appointment_id`),
  CONSTRAINT `FK_appoitment_to_participant` FOREIGN KEY (`appointment_id`) REFERENCES `appointment` (`appointment_id`),
  CONSTRAINT `FK_user_participant` FOREIGN KEY (`user_id`) REFERENCES `account` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment_participant`
--

LOCK TABLES `appointment_participant` WRITE;
/*!40000 ALTER TABLE `appointment_participant` DISABLE KEYS */;
INSERT INTO `appointment_participant` VALUES ('liu',5),('huang',6),('huang',7),('zhang',8),('zhang',9),('shi',10),('shi',11),('shi',12),('liu',13),('liu',14),('liu',15),('huang',16),('huang',17),('zhang',18),('zhang',19),('liu',20),('shi',21),('zhang',22),('liu',24);
/*!40000 ALTER TABLE `appointment_participant` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-21  9:09:01
