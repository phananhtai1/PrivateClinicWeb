-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: clinicdbv3
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appointment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `appointment_date` date NOT NULL,
  `content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `patient_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_appointment_patient1_idx` (`patient_id`),
  CONSTRAINT `fk_appointment_patient1` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment`
--

LOCK TABLES `appointment` WRITE;
/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
INSERT INTO `appointment` VALUES (1,'2021-05-01','đau đầu, chóng mặt',1),(3,'2021-05-02','Đau dạ dày, khó chịu vùng bụng',2),(4,'2021-05-03','Ho dai dẵng lâu ngày',4),(5,'2021-05-12','Đau lưng, mỏi gối',6),(10,'2021-05-15','Đau lòng, khó chịu vùng bụng',10),(11,'2021-05-10','Đau lòng, khó chịu vùng bụng',1);
/*!40000 ALTER TABLE `appointment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill` (
  `id` int NOT NULL AUTO_INCREMENT,
  `charge` decimal(10,0) NOT NULL,
  `medicine_cost` decimal(10,0) DEFAULT '0',
  `total_amount` decimal(10,0) NOT NULL,
  `medical_form_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_bill_medical_form1_idx` (`medical_form_id`),
  CONSTRAINT `fk_bill_medical_form1` FOREIGN KEY (`medical_form_id`) REFERENCES `medical_form` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
INSERT INTO `bill` VALUES (1,100000,830000,930000,1),(2,150000,220000,370000,2),(3,80000,140000,220000,3),(4,200000,2025000,2225000,4),(5,200000,1000000,1200000,8),(6,100000,110000,210000,14),(7,150000,420000,570000,15);
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fullname` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `sex` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Lê Giang','01458741','22 Kha Vạn Cân','1990-07-21','nữ'),(2,'Sơn Tùng','01754181','172 Phạm Văn Đồng','1998-03-12','nam'),(3,'Jack','18618014','371 Nguyễn Huệ','1980-04-30','nam'),(4,'Ngọc Trinh','19631970','123 Phan Huy Ích','1988-09-21','nữ'),(6,'Quang Trung','1253813141','81 đường D6','1990-02-22','nam'),(7,'Anh Đức','12323124141','718 D5','1999-02-22','Nữ'),(8,'Nam Em','23131231231232','101 Nguyễn Gia Trí','1990-12-20','Nữ'),(9,'Thu Phương','1013123123','200 Nguyễn Gia Trí','1980-11-19','Nam');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medical_form`
--

DROP TABLE IF EXISTS `medical_form`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medical_form` (
  `id` int NOT NULL AUTO_INCREMENT,
  `symptom` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `examination_date` date NOT NULL,
  `diagnostic` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `patient_id` int NOT NULL,
  `employee_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_medical_form_patient_idx` (`patient_id`),
  KEY `fk_medical_form_employee1_idx` (`employee_id`),
  CONSTRAINT `fk_medical_form_employee1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
  CONSTRAINT `fk_medical_form_patient` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medical_form`
--

LOCK TABLES `medical_form` WRITE;
/*!40000 ALTER TABLE `medical_form` DISABLE KEYS */;
INSERT INTO `medical_form` VALUES (1,'đau đầu, chóng mặt','2021-05-01','Cảm cúm',1,2),(2,'đau dạ dày','2021-05-02','Viêm dạ dày',2,3),(3,'ho nhiều ngày không hết','2021-05-02','Ho do dị ứng thời tiết',6,6),(4,'tiêu chảy','2021-05-03','Tiêu chảy',4,3),(6,'Ói mửa','2021-05-05','Suy kiệt cơ thể',1,1),(7,'đau dạ dày, ăn hay bị đau','2021-05-05','Trào ngược dạ dày',4,4),(8,'đau dạ dày, ăn hay bị đau','2021-05-05','Trào ngược dạ dày',6,3),(9,'Ói mửa','2021-05-05','Suy kiệt cơ thể',4,4),(10,'đau dạ dày, ăn hay bị đau','2021-05-05','Trào ngược dạ dày',3,2),(11,'Ói mửa','2021-05-07','Suy kiệt cơ thể',8,6),(12,'Ói mửa','2021-05-10','Suy kiệt cơ thể',10,8),(13,'Khó thở, chóng mặt','2021-05-10','Mất nước, làm việc lao lực',11,6),(14,'Ói mửa','2021-04-06','Suy kiệt cơ thể',10,2),(15,'đau dạ dày, ăn hay bị đau','2021-03-17','Trào ngược dạ dày',9,8);
/*!40000 ALTER TABLE `medical_form` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicine`
--

DROP TABLE IF EXISTS `medicine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicine` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `unit` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `price` decimal(10,0) DEFAULT '0',
  `manufacturing_date` date DEFAULT NULL,
  `expiry_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicine`
--

LOCK TABLES `medicine` WRITE;
/*!40000 ALTER TABLE `medicine` DISABLE KEYS */;
INSERT INTO `medicine` VALUES (1,'Thuốc nhỏ mắt OSLA','hộp',20000,'2020-01-01','2022-01-01'),(2,'Xoang Spray','chai',55000,'2020-01-15','2022-02-01'),(3,'Logpatat 25mg','hộp',250000,'2020-02-01','2021-02-01'),(4,'Eugica','Chai',63000,'2020-02-20','2021-02-20'),(5,'Paracetamol','hộp',40000,'2021-01-21','2022-01-21'),(6,'Rocori','hộp',300000,'2020-03-20','2022-04-21'),(8,'Terpinzoat','hộp',55000,'2020-04-20','2022-05-20'),(10,'Gaviscon','Chai',123000,'2021-02-20','2022-03-22'),(11,'Alaxan','hộp',140000,'2020-03-29','2022-05-22'),(13,'Tyrosur','Chai',1000000,'2020-12-12','2022-12-12'),(15,'Flexsa 1500','Hộp',264000,'2021-05-11','2023-05-11'),(18,'Mongor','Vỉ',120000,'2019-10-17','2022-10-17'),(19,'Oztis','Chai',490000,'2019-06-12','2022-06-12');
/*!40000 ALTER TABLE `medicine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fullname` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `birth_date` date DEFAULT NULL,
  `sex` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (1,'Anh Tài','1999-01-21','Nam','71 Nguyễn Kiệm','123456789'),(2,'Văn A','1990-03-30','Nam','02 Quang Trung','816731213'),(3,'Lê Hạnh','1890-05-14','Nữ','152 Nguyễn Qanh','9658231'),(4,'Đức Phú','1996-03-06','nam','11/12 Phan Văn Trị','125131334'),(6,'Thu Minh','2000-10-20','nữ','81 Đường Bạch Đằng','1739160831'),(7,'Anh Tú','1980-01-31','nam','71 Cách Mạng Tháng 8','19107416191'),(8,'Quang Hiếu','2000-11-30','Nam','108 Tô Hiến Thành','12123831231'),(9,'Tóc Tiên','2002-12-31','Nữ','86 An Dương Vương','1231241124124'),(10,'Hữu Nghĩa','1999-01-21','Nam','71 Cách Mạng Tháng 8','1232312321321'),(11,'Lệ Rơi','2001-01-21','Nam','200 Đường Bạch Đằng','3125332123');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prescription`
--

DROP TABLE IF EXISTS `prescription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prescription` (
  `id` int NOT NULL AUTO_INCREMENT,
  `quantity` int NOT NULL,
  `usage` varchar(1000) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `medical_form_id` int NOT NULL,
  `medicine_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_prescription_medical_form1_idx` (`medical_form_id`),
  KEY `fk_prescription_medicine1_idx` (`medicine_id`),
  CONSTRAINT `fk_prescription_medical_form1` FOREIGN KEY (`medical_form_id`) REFERENCES `medical_form` (`id`),
  CONSTRAINT `fk_prescription_medicine1` FOREIGN KEY (`medicine_id`) REFERENCES `medicine` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prescription`
--

LOCK TABLES `prescription` WRITE;
/*!40000 ALTER TABLE `prescription` DISABLE KEYS */;
INSERT INTO `prescription` VALUES (1,2,'Uống sau khi ăn ',1,5),(2,3,'Uống trước khi ăn 15\'',1,3),(3,4,'Uống sau khi ăn',2,2),(4,1,'Uống trước khi ăn',3,11),(5,2,'Uống trước khi ăn',4,3),(6,3,'Uống',4,5),(7,3,'Sau khi ăn 30 phút',4,8),(8,4,'Trước khi ăn 30 phút',8,3),(9,2,'Trước khi ăn 30 phút',12,2),(10,3,'Sau khi ăn 15 phút',12,5),(11,2,'Trước khi ăn 30 phút',14,2),(12,3,'Sau khi ăn 15 phút',15,11);
/*!40000 ALTER TABLE `prescription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `user_role` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `employee_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `employee_id_UNIQUE` (`employee_id`),
  KEY `fk_user_employee1_idx` (`employee_id`),
  CONSTRAINT `fk_user_employee1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'anhtai','$2a$10$E/1xUSok8QlnKCs6TeP8w.21Lwp6K1DB93toNveBSHeMfsticx6kO','ROLE_ADMIN',1),(2,'tai','$2a$10$UBJ.ZXhRenJtOP0CU9yZMufGYGUDMaQHzXucjpL4faZtTClBoRIKK','ROLE_USER',2),(4,'anhtai1','$2a$10$AoYYA2CZITbBjSdqwc9SzOy0lxGnxhNMtNukQGAhxzfmr1xLPkvLW','ROLE_USER',4);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-15 13:56:02
