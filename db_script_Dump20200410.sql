CREATE DATABASE  IF NOT EXISTS `demo` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `demo`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: demo
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `abc`
--

DROP TABLE IF EXISTS `abc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `abc` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `fname` varchar(45) NOT NULL,
  `number` bigint NOT NULL,
  `password` varchar(45) NOT NULL,
  `active_flag` varchar(45) NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `abc`
--

LOCK TABLES `abc` WRITE;
/*!40000 ALTER TABLE `abc` DISABLE KEYS */;
INSERT INTO `abc` VALUES (1,'kin',123,'123','0'),(2,'Gaurang',111,'111','0');
/*!40000 ALTER TABLE `abc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faculty_selection`
--

DROP TABLE IF EXISTS `faculty_selection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `faculty_selection` (
  `fsID` int NOT NULL AUTO_INCREMENT,
  `userID` int NOT NULL,
  `syID` int NOT NULL,
  `stID` int NOT NULL,
  `priorityID` int NOT NULL,
  PRIMARY KEY (`fsID`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculty_selection`
--

LOCK TABLES `faculty_selection` WRITE;
/*!40000 ALTER TABLE `faculty_selection` DISABLE KEYS */;
/*!40000 ALTER TABLE `faculty_selection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `program_timeline`
--

DROP TABLE IF EXISTS `program_timeline`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `program_timeline` (
  `ptID` int NOT NULL AUTO_INCREMENT,
  `programID` int NOT NULL,
  `startingTerm` varchar(45) NOT NULL,
  `startingYear` varchar(45) NOT NULL,
  `active_flag` tinyint(1) DEFAULT '1',
  `createdBy` varchar(45) DEFAULT NULL,
  `createdDate` date DEFAULT NULL,
  `updatedBy` varchar(45) DEFAULT NULL,
  `updatedDate` date DEFAULT NULL,
  PRIMARY KEY (`ptID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `program_timeline`
--

LOCK TABLES `program_timeline` WRITE;
/*!40000 ALTER TABLE `program_timeline` DISABLE KEYS */;
INSERT INTO `program_timeline` VALUES (4,8,'winter','2020',1,'kinresh','2020-04-09','kinresh','2020-04-09'),(5,8,'summer','2020',1,'kinresh','2020-04-09',NULL,NULL);
/*!40000 ALTER TABLE `program_timeline` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `programs`
--

DROP TABLE IF EXISTS `programs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `programs` (
  `programID` int NOT NULL AUTO_INCREMENT,
  `programName` varchar(45) NOT NULL,
  `totalTerms` int NOT NULL,
  `winter` tinyint(1) DEFAULT '1',
  `summer` tinyint(1) DEFAULT '1',
  `fall` tinyint(1) DEFAULT '1',
  `active_flag` tinyint(1) DEFAULT '1',
  `createdBy` varchar(45) DEFAULT NULL,
  `createdDate` date DEFAULT NULL,
  `updatedBy` varchar(45) DEFAULT NULL,
  `updatedDate` date DEFAULT NULL,
  PRIMARY KEY (`programID`),
  UNIQUE KEY `programName_UNIQUE` (`programName`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `programs`
--

LOCK TABLES `programs` WRITE;
/*!40000 ALTER TABLE `programs` DISABLE KEYS */;
INSERT INTO `programs` VALUES (8,'MAC',4,1,0,1,1,'kinresh','2020-04-09','kinresh','2020-04-09'),(9,'MAEP',4,1,1,1,1,'kinresh','2020-04-09',NULL,NULL),(10,'MENG',4,1,1,1,1,'kinresh','2020-04-09',NULL,NULL);
/*!40000 ALTER TABLE `programs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule_year`
--

DROP TABLE IF EXISTS `schedule_year`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `schedule_year` (
  `syID` int NOT NULL AUTO_INCREMENT,
  `year` varchar(45) NOT NULL,
  `active_flag` tinyint(1) DEFAULT '1',
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`syID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule_year`
--

LOCK TABLES `schedule_year` WRITE;
/*!40000 ALTER TABLE `schedule_year` DISABLE KEYS */;
INSERT INTO `schedule_year` VALUES (7,'2020',1,'summer_schedule_01');
/*!40000 ALTER TABLE `schedule_year` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject_term`
--

DROP TABLE IF EXISTS `subject_term`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject_term` (
  `stID` int NOT NULL AUTO_INCREMENT,
  `subjectID` int NOT NULL,
  `web_termsID` int NOT NULL,
  `syID` int NOT NULL,
  `notes` varchar(50) DEFAULT NULL,
  `active_flag` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`stID`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject_term`
--

LOCK TABLES `subject_term` WRITE;
/*!40000 ALTER TABLE `subject_term` DISABLE KEYS */;
INSERT INTO `subject_term` VALUES (24,9,1,7,'',1),(25,9,2,7,'',1),(26,10,2,7,'4 pm or later',1),(27,12,1,7,'',1),(28,12,2,7,'',1),(29,25,3,7,'',1),(30,26,3,7,'',1),(31,29,1,7,'',1),(32,29,2,7,'',1),(33,30,3,7,'',1);
/*!40000 ALTER TABLE `subject_term` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subjects`
--

DROP TABLE IF EXISTS `subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subjects` (
  `subjectID` int NOT NULL AUTO_INCREMENT,
  `subjectCode` varchar(45) NOT NULL,
  `subjectName` varchar(100) DEFAULT NULL,
  `subjectDescription` varchar(45) DEFAULT NULL,
  `maxInstructor` int DEFAULT '1',
  `active_flag` tinyint DEFAULT '1',
  `createdBy` varchar(45) DEFAULT NULL,
  `createdDate` date DEFAULT NULL,
  `updatedBy` varchar(45) DEFAULT NULL,
  `updatedDate` date DEFAULT NULL,
  PRIMARY KEY (`subjectID`),
  UNIQUE KEY `subjectCode_UNIQUE` (`subjectCode`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='			';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subjects`
--

LOCK TABLES `subjects` WRITE;
/*!40000 ALTER TABLE `subjects` DISABLE KEYS */;
INSERT INTO `subjects` VALUES (9,'1000','Key Concepts in Computer Science','COMP',1,1,'kinresh','2020-04-09',NULL,NULL),(10,'1000-02','Key Concepts in Computer Science',' COMP',1,1,'kinresh','2020-04-09',NULL,NULL),(11,'1400','Introduction to Algorithms and Programming I','COMP',1,1,'kinresh','2020-04-09',NULL,NULL),(12,'1400 labs','Introduction to Algorithms and Programming I','COMP',1,1,'kinresh','2020-04-09',NULL,NULL),(13,'1410','Introduction to Algorithms and Programming II','COMP',1,1,'kinresh','2020-04-09','kinresh','2020-04-09'),(14,'2120','Object-Oriented Programming Using Java','COMP',1,1,'kinresh','2020-04-09',NULL,NULL),(15,'2310','Theoretical Foundations of Computer Science','COMP',1,1,'kinresh','2020-04-09',NULL,NULL),(16,'3220','Fluid Mechanics II','MECH',1,1,'kinresh','2020-04-09',NULL,NULL),(17,'4670','Aerospace Propulsion','MECH ',1,1,'kinresh','2020-04-09',NULL,NULL),(18,'8117','Advanced Software Eng. Topics','COMP',1,1,'kinresh','2020-04-09',NULL,NULL),(19,'8547','Advanced Computing Concepts','COMP',1,1,'kinresh','2020-04-09',NULL,NULL),(20,'8997','Project/Internship','COMP',1,1,'kinresh','2020-04-09',NULL,NULL),(21,'8567','Advanced Systems Programming','COMP',1,1,'kinresh','2020-04-09',NULL,NULL),(22,'8157','Advanced Database Topics','COMP',1,1,'kinresh','2020-04-09',NULL,NULL),(25,'8120','Finance in a Global Perspective','BSMM',1,1,'kinresh','2020-04-09',NULL,NULL),(26,'8130','Managing Employees','BSMM',1,1,'kinresh','2020-04-09',NULL,NULL),(27,'8140','Marketing','BSMM',1,1,'kinresh','2020-04-09',NULL,NULL),(28,'8677','Networking and Data Security','COMP',1,1,'kinresh','2020-04-09',NULL,NULL),(29,'8970','M.Sc. Thesis','COMP',1,1,'kinresh','2020-04-09',NULL,NULL),(30,'9980','Doctoral Dissertation Research','COMP',1,1,'kinresh','2020-04-09',NULL,NULL);
/*!40000 ALTER TABLE `subjects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `userID` int NOT NULL AUTO_INCREMENT,
  `userName` varchar(45) NOT NULL,
  `userEmail` varchar(45) NOT NULL,
  `userPassword` varchar(45) NOT NULL,
  `userDob` date DEFAULT NULL,
  `userContact` varchar(45) NOT NULL,
  `userRole` varchar(45) NOT NULL DEFAULT 'faculty',
  `active` tinyint DEFAULT '1',
  `userCountry` varchar(45) DEFAULT NULL,
  `userAddress` varchar(80) DEFAULT NULL,
  `lastUpdated` date DEFAULT NULL,
  `updatedBy` varchar(45) DEFAULT NULL,
  `createdDate` date DEFAULT NULL,
  `createdBy` varchar(45) DEFAULT NULL,
  `userDepartment` varchar(45) DEFAULT NULL,
  `gender` varchar(15) NOT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE KEY `userEmail_UNIQUE` (`userEmail`),
  UNIQUE KEY `userName_UNIQUE` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'kinresh','k@gmail.com','password','1997-09-24','5199197144','admin',1,'India',NULL,NULL,NULL,'2020-03-16','db','','male'),(2,'john','john@gmail.com','password','1995-06-15','5199197145','faculty',1,'Canada',NULL,NULL,NULL,'2020-03-16','kinresh','','male');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `web_country`
--

DROP TABLE IF EXISTS `web_country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `web_country` (
  `cid` int NOT NULL AUTO_INCREMENT,
  `cname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `web_country`
--

LOCK TABLES `web_country` WRITE;
/*!40000 ALTER TABLE `web_country` DISABLE KEYS */;
INSERT INTO `web_country` VALUES (1,'india'),(2,'Australia'),(3,'USA'),(4,'Canada'),(5,'UK');
/*!40000 ALTER TABLE `web_country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `web_hobbie`
--

DROP TABLE IF EXISTS `web_hobbie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `web_hobbie` (
  `hid` int NOT NULL AUTO_INCREMENT,
  `hname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`hid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `web_hobbie`
--

LOCK TABLES `web_hobbie` WRITE;
/*!40000 ALTER TABLE `web_hobbie` DISABLE KEYS */;
INSERT INTO `web_hobbie` VALUES (1,'swimming'),(2,'running'),(3,'Coding'),(4,'driving'),(5,'skipping');
/*!40000 ALTER TABLE `web_hobbie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `web_priorities`
--

DROP TABLE IF EXISTS `web_priorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `web_priorities` (
  `priorityID` int NOT NULL AUTO_INCREMENT,
  `description` varchar(45) NOT NULL,
  `active_flag` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`priorityID`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `web_priorities`
--

LOCK TABLES `web_priorities` WRITE;
/*!40000 ALTER TABLE `web_priorities` DISABLE KEYS */;
INSERT INTO `web_priorities` VALUES (1,'High',1),(2,'Medium',1),(3,'Low',1),(4,'Very Unlikely',1),(999,'Select Priority',1);
/*!40000 ALTER TABLE `web_priorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `web_terms`
--

DROP TABLE IF EXISTS `web_terms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `web_terms` (
  `web_termID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `active_flag` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`web_termID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `web_terms`
--

LOCK TABLES `web_terms` WRITE;
/*!40000 ALTER TABLE `web_terms` DISABLE KEYS */;
INSERT INTO `web_terms` VALUES (1,'SUMMER',1),(2,'FALL',1),(3,'WINTER',1);
/*!40000 ALTER TABLE `web_terms` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-10 14:35:40
