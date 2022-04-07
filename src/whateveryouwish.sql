CREATE DATABASE  IF NOT EXISTS `whateveryouwishdb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `whateveryouwishdb`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: whateveryouwishdb.mysql.database.azure.com    Database: whateveryouwishdb
-- ------------------------------------------------------
-- Server version	5.6.47.0

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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(64) NOT NULL,
  `role` varchar(45) NOT NULL,
  `enabled` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`user_id`, `username`, `password`, `role`, `enabled`) VALUES (1,'namhm','$2a$10$XptfskLsT1l/bRTLRiiCgejHqOpgXFreUnNUa35gJdCr2v2QbVFzu','ROLE_USER',1),(2,'admin','$2a$10$zxvEq8XzYEYtNjbkRsJEbukHeRx3XS6MDXHMu8cNuNsRfZJWwswDy','ROLE_ADMIN',1),(4,'adamtest17','$2a$10$H2WJbzmzHiQuB.JcaY0nOeS.LEVrJ/wUUT/mCLtZoZRTkPwH/1xq6','ROLE_USER',1),(5,'test2','$2a$10$Z2OPQoiaKX.l1NpwlqMyLOWiYduzrT2ej1qHunyoK/1fpeCi2KZJa','ROLE_USER',1),(6,'test22','$2a$10$k1mrMZoHJFv1pXHUk0HYYebwUGFvVMfhtL/1.jeYPfkAmeezvwMeC','ROLE_USER',1),(7,'test222','$2a$10$Cp.lhuCspsRBN2edLU7/bu2y8EglrRrh9d6yd5JT4MFnJUn6Mqmgi','ROLE_USER',1),(8,'peder','$2a$10$8KhHKTRtw0c9Qt8EoeBTbeNi/woGX7V9i5iG1q6d5lUK7PAQApGvW','ROLE_USER',1),(9,'test2222','$2a$10$YcgaiJ2fXkrT7mPLkrv5BOeFEVF63uXLRB0fGXbwH.1pqZ7dGLoNK','ROLE_USER',1),(10,'adamtest99','$2a$10$lbD8oLoWb6UeIhfr8jJD2eHxw.QrfOK63Y/ZbL5LOG/WtpDpGZS/e','ROLE_USER',1),(11,'adamtest89','$2a$10$X.1jG79oMasi3HLmvtCH6.da1bmrS//7qXmv2tixNvRBLrnHropka','ROLE_USER',1),(12,'tester','$2a$10$d9Q.GBEqjztNxpCzUDXfFuYWO/Qh5z8tKsqpfLnDc94sVR226t61O','ROLE_USER',1),(13,'tester2','$2a$10$nTxE54HABc/b6q.BXIgFYeP2QD.5GK1BAogIrEmyDd1wYtURrx7T6','ROLE_USER',1),(14,'usertest','$2a$10$Lq.kSGOerCDuSW3ZQbpPBucKQU7Fjmxyf/8WWTdnX8W5YlF3c0Lqe','ROLE_USER',1),(15,'test4','$2a$10$26dzJ64n3P8bk6XwJXUiw.RmW.BDxxnEvt0kOOEoCS6LQK3vYJZXe','ROLE_USER',1),(16,'testertester','$2a$10$aNGjBvr5DakH4SgHighyPeFZAND3mMZX5x1pnLZckJyEfCzRdixzG','ROLE_USER',1),(17,'testnybruger','$2a$10$fThm7g.VpEh.52prKX5OIeO/6fsYV3dX5Lx3lBIldBxmS1nhm036G','ROLE_USER',1),(18,'testudenuser','$2a$10$56BjLxLDs4mGRIRNIFYf/uQDmHP1r6HaPAnUCoHtTJ4aS4XXhKAhW','ROLE_USER',1),(19,'autistedetforser','$2a$10$blKkgoXv41aestCuItMb7OhqtjPgRe2.tJTQe.5jGpKuFT.iwr3Gi','ROLE_USER',1),(20,'testmedprinci','$2a$10$nN2RgSCRsHFtD10zGTOu0.fR.NtsyRQv2sTnyR8ql9oJutmDM/fQ.','ROLE_USER',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wish`
--

DROP TABLE IF EXISTS `wish`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wish` (
  `id_wish` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `description` varchar(45) NOT NULL,
  `quantity` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_wish`),
  KEY `user_id_idx` (`user_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wish`
--

LOCK TABLES `wish` WRITE;
/*!40000 ALTER TABLE `wish` DISABLE KEYS */;
INSERT INTO `wish` (`id_wish`, `user_id`, `name`, `description`, `quantity`) VALUES (1,1,'hej med dig bamse','sød bamse',1),(2,1,'testønske','dette er en test',2),(5,8,'Et hus','Stort',1),(8,10,'Nissan GTR','Hurtig bil',1),(9,10,'GeForce RTX 3090Ti','Høj fps',1),(10,10,'4K Monitor','Godt billede til PC',1),(14,5,'pc','I want all the power',1),(15,9,'øl','classic',2),(25,13,'sommer','snart',1),(26,14,'userønske','2',1),(28,2,'test','Dette er en test',1),(30,9,'hus','med poll',1),(34,17,'et ønske','ønske',1),(41,19,'testønske','øl',22),(42,5,'testønske med aut','',2),(44,20,'testønske med princ','testbruger',1),(48,5,'test af tilføj 7/4','',2);
/*!40000 ALTER TABLE `wish` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'whateveryouwishdb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-07 10:17:27
