-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: switzerlandbank_db
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `bank_statement_tb`
--

DROP TABLE IF EXISTS `bank_statement_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bank_statement_tb` (
  `bank_statement_id` bigint NOT NULL AUTO_INCREMENT,
  `client_id` bigint DEFAULT NULL,
  `data_hora` datetime(6) DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `tipo_transacao` varchar(255) DEFAULT NULL,
  `valor` decimal(38,2) DEFAULT NULL,
  PRIMARY KEY (`bank_statement_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bank_statement_tb`
--

LOCK TABLES `bank_statement_tb` WRITE;
/*!40000 ALTER TABLE `bank_statement_tb` DISABLE KEYS */;
INSERT INTO `bank_statement_tb` VALUES (1,2,'2023-06-11 22:44:28.501158','para Kauã dos Santos Silva','Pix enviado',22.44),(2,1,'2023-06-11 22:44:28.578266','de Amanda Meneghini','Pix recebido',22.44),(3,2,'2023-06-11 22:45:57.644219','para Breno Luiz','Pix enviado',11.06),(4,3,'2023-06-11 22:45:57.706196','de Amanda Meneghini','Pix recebido',11.06),(5,2,'2023-06-11 22:46:14.743417','para Kauã dos Santos Silva','Pix enviado',200.30),(6,1,'2023-06-11 22:46:14.777687','de Amanda Meneghini','Pix recebido',200.30),(7,1,'2023-06-11 22:47:39.374826','para Amanda Meneghini','Pix enviado',22.19),(8,2,'2023-06-11 22:47:39.421791','de Kauã dos Santos Silva','Pix recebido',22.19),(9,3,'2023-06-11 22:49:58.014149','para Amanda Meneghini','Pix enviado',80.80),(10,2,'2023-06-11 22:49:58.037808','de Breno Luiz','Pix recebido',80.80),(11,3,'2023-06-11 22:50:23.565107','para Kauã dos Santos Silva','Pix enviado',10.01),(12,1,'2023-06-11 22:50:23.614479','de Breno Luiz','Pix recebido',10.01);
/*!40000 ALTER TABLE `bank_statement_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cards_tb`
--

DROP TABLE IF EXISTS `cards_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cards_tb` (
  `cards_id` bigint NOT NULL AUTO_INCREMENT,
  `agency` int NOT NULL,
  `card_name` varchar(255) DEFAULT NULL,
  `card_password` int NOT NULL,
  `client_id` bigint DEFAULT NULL,
  `credit_limit` decimal(38,2) DEFAULT NULL,
  `expiration_date` date DEFAULT NULL,
  `holder_name` varchar(255) DEFAULT NULL,
  `number_card` varchar(255) DEFAULT NULL,
  `security_code` int NOT NULL,
  PRIMARY KEY (`cards_id`),
  UNIQUE KEY `UK_jxaj4ej7hadi8t5jcld750naf` (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cards_tb`
--

LOCK TABLES `cards_tb` WRITE;
/*!40000 ALTER TABLE `cards_tb` DISABLE KEYS */;
INSERT INTO `cards_tb` VALUES (1,1374,'SwiterCard',2483,1,500.00,'2030-06-11','Kauã dos Santos Silva','5851249464134764',519),(2,1374,'SwiterCard',3257,2,500.00,'2030-06-11','Amanda Meneghini','1415065061695157',561);
/*!40000 ALTER TABLE `cards_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client_tb`
--

DROP TABLE IF EXISTS `client_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client_tb` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) NOT NULL,
  `balance` decimal(38,2) DEFAULT NULL,
  `chave` varchar(255) DEFAULT NULL,
  `cpf` varchar(11) NOT NULL,
  `date_birth` date NOT NULL,
  `email` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `mother_name` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `password` varchar(128) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_nwso427d1owahmy6swmxoi0l1` (`cpf`),
  UNIQUE KEY `UK_6tcr087qwkcsqby8lkg61hwe9` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_tb`
--

LOCK TABLES `client_tb` WRITE;
/*!40000 ALTER TABLE `client_tb` DISABLE KEYS */;
INSERT INTO `client_tb` VALUES (1,'R. Rio das árvores altas',2450.67,'MhAFapvrFj','12522167075','2004-05-04','kaua.silva@gmail.com','Masculino','Vania dos Santos Silva','Kauã dos Santos Silva','HelloJava123'),(2,'R. dos Bobos',931.21,'pIXolLRVSD','12522192773','2001-02-02','amanda.meneghini@gmail.com','Feminino','Josefa Meneghini','Amanda Meneghini','TheFront3nd'),(3,'R. das Aventuras',3163.42,'wsiJ3aW6FC','12522169352','2004-06-07','breno.luiz@gmail.com','Masculino','Jennifer Luiz','Breno Luiz','C4rd1nnovate');
/*!40000 ALTER TABLE `client_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'switzerlandbank_db'
--

--
-- Dumping routines for database 'switzerlandbank_db'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-11 22:59:51
