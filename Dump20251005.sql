-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: employee_db
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.28-MariaDB

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
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) NOT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `position` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKj9xgmd0ya5jmus09o0b8pqrpb` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'2025-10-03 20:29:22.000000','kartik1605@gmail.com','Kartik Marne','Associate Software Engineer'),(2,'2025-10-03 20:35:02.000000','kaveri1602@gmail.com','Kaveri Bhoj','Associate Software Developer'),(3,'2025-10-03 20:42:51.000000','niti0207@gmail.com','Nitish Kumbhar','Manual Software Tester'),(4,'2025-10-03 20:42:51.000000','kushi@gmail.com','Khushi Gupchup','Jr. Java Developer'),(6,'2025-10-03 20:42:51.000000','adi@gmail.com','Aditya Survase','Data Scientist'),(8,'2025-10-04 17:54:40.000000','harshalg03@gmail.com','Harshal Gaikwad','Research Analust'),(9,'2025-10-04 17:57:47.000000','sakshik@gmail.com','Sakshi Kumbhar','Web Dev Intern'),(10,'2025-10-04 17:57:47.000000','abhin0604@gmail.com','Abhi Gaikwad','Quality Analyst'),(11,'2025-10-04 17:57:47.000000','sandy98@gmail.com','Sandesh Mandhre','Admin Officer'),(14,'2025-10-04 19:41:22.000000','sakshi26@gmail.com','Sakshi Dhawle','Digital Marketing Intern'),(15,'2025-10-04 19:50:27.000000','anis0206@gmail.com','Aniket Shelar','Network Engineer'),(16,'2025-10-04 19:58:47.000000','pratham01510@gmail.com','Prathamesh Deokar','Data Analyst'),(28,'2025-10-05 12:39:34.000000','shubsk14@gmail.com','Shubham Kamble','Full Stack Java Developer'),(30,'2025-10-05 13:01:20.000000','sakshij26@gmail.com','Sakshi Jadhav','AutoSoftware Tester'),(31,'2025-10-05 13:02:40.000000','varun@gmail.com','Varun Kaul','Software Engineer'),(34,'2025-10-05 13:21:19.000000','tulja23@gmail.com','Tulja Bagate','Finance Analyst');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-10-05 13:25:11
