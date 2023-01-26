-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: sop
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `association_value_entry`
--

DROP TABLE IF EXISTS `association_value_entry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `association_value_entry` (
  `id` bigint NOT NULL,
  `association_key` varchar(255) NOT NULL,
  `association_value` varchar(255) DEFAULT NULL,
  `saga_id` varchar(255) NOT NULL,
  `saga_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDXk45eqnxkgd8hpdn6xixn8sgft` (`saga_type`,`association_key`,`association_value`),
  KEY `IDXgv5k1v2mh6frxuy5c0hgbau94` (`saga_id`,`saga_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `association_value_entry`
--

LOCK TABLES `association_value_entry` WRITE;
/*!40000 ALTER TABLE `association_value_entry` DISABLE KEYS */;
/*!40000 ALTER TABLE `association_value_entry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `course_id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `image` varchar(255) NOT NULL,
  `price` float(8,2) NOT NULL,
  `menu1` varchar(255) DEFAULT NULL,
  `amount1` int DEFAULT '0',
  `menu2` varchar(255) DEFAULT NULL,
  `amount2` int DEFAULT '0',
  `menu3` varchar(255) DEFAULT NULL,
  `amount3` int DEFAULT '0',
  `menu4` varchar(255) DEFAULT NULL,
  `amount4` int DEFAULT '0',
  `menu5` varchar(255) DEFAULT NULL,
  `amount5` int DEFAULT '0',
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES ('5be9ad3a-2b5a-413a-b443-ea1c111a4361','China Course','https://cdn.discordapp.com/attachments/844870220757860372/1055519105752510534/china.png',1500.00,'e157867c-63d9-4b2f-bdb6-4842d8a03488',2,'92024674-7b4f-44aa-9a1c-c2c50f670118',1,'3aab2b35-4299-41c6-a9ad-2478f05997bf',3,'66bbf2ba-aaaa-4707-8841-7606af84c1a6',2,'7f8dabb1-374a-42e6-afb4-8f53ddb7141b',1),('72e7a001-67b1-49de-81b7-f969441bfaa5','Japan Course','https://cdn.discordapp.com/attachments/844870220757860372/1055519106171928666/japan.png',1600.00,'17674b70-99a7-4e78-848e-285dbdfcfafd',2,'a264975c-2217-40d2-b9e1-84d2dd141f49',3,'5fd4d609-39f9-4bc0-b536-05b0d6f9202d',1,'730f04da-084d-437e-8cca-5495fefcdd63',2,'a3f50106-f1cd-456b-9759-497e9b47552b',1),('8ac4cb76-3a67-4209-88dc-2f2e15ef1f08','Thai Course','https://cdn.discordapp.com/attachments/844870220757860372/1055519106411024444/thai.png',1200.00,'0a429c9f-0ef1-48bb-9750-886bd6b0a8d4',3,'2ca447a6-a508-4c71-8831-370fdd7e4750',1,'70e78138-c130-423d-b4b9-f04c0023785a',1,'74f4553c-e57f-4a70-a389-843def120c77',2,'a75306bc-ef7d-4ea3-83dc-a3f9ddc40fac',2);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dead_letter_entry`
--

DROP TABLE IF EXISTS `dead_letter_entry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dead_letter_entry` (
  `dead_letter_id` varchar(255) NOT NULL,
  `cause_message` varchar(255) DEFAULT NULL,
  `cause_type` varchar(255) DEFAULT NULL,
  `diagnostics` longblob,
  `enqueued_at` datetime(6) NOT NULL,
  `last_touched` datetime(6) DEFAULT NULL,
  `aggregate_identifier` varchar(255) DEFAULT NULL,
  `event_identifier` varchar(255) NOT NULL,
  `message_type` varchar(255) NOT NULL,
  `meta_data` longblob,
  `payload` longblob NOT NULL,
  `payload_revision` varchar(255) DEFAULT NULL,
  `payload_type` varchar(255) NOT NULL,
  `sequence_number` bigint DEFAULT NULL,
  `time_stamp` varchar(255) NOT NULL,
  `token` longblob,
  `token_type` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `processing_group` varchar(255) NOT NULL,
  `processing_started` datetime(6) DEFAULT NULL,
  `sequence_identifier` varchar(255) NOT NULL,
  `sequence_index` bigint NOT NULL,
  PRIMARY KEY (`dead_letter_id`),
  UNIQUE KEY `UKhlr8io86j74qy298xf720n16v` (`processing_group`,`sequence_identifier`,`sequence_index`),
  KEY `IDXe67wcx5fiq9hl4y4qkhlcj9cg` (`processing_group`),
  KEY `IDXrwucpgs6sn93ldgoeh2q9k6bn` (`processing_group`,`sequence_identifier`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dead_letter_entry`
--

LOCK TABLES `dead_letter_entry` WRITE;
/*!40000 ALTER TABLE `dead_letter_entry` DISABLE KEYS */;
/*!40000 ALTER TABLE `dead_letter_entry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `domain_event_entry`
--

DROP TABLE IF EXISTS `domain_event_entry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `domain_event_entry` (
  `global_index` bigint NOT NULL,
  `event_identifier` varchar(255) NOT NULL,
  `meta_data` longblob,
  `payload` longblob NOT NULL,
  `payload_revision` varchar(255) DEFAULT NULL,
  `payload_type` varchar(255) NOT NULL,
  `time_stamp` varchar(255) NOT NULL,
  `aggregate_identifier` varchar(255) NOT NULL,
  `sequence_number` bigint NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`global_index`),
  UNIQUE KEY `UK8s1f994p4la2ipb13me2xqm1w` (`aggregate_identifier`,`sequence_number`),
  UNIQUE KEY `UK_fwe6lsa8bfo6hyas6ud3m8c7x` (`event_identifier`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `domain_event_entry`
--

LOCK TABLES `domain_event_entry` WRITE;
/*!40000 ALTER TABLE `domain_event_entry` DISABLE KEYS */;
/*!40000 ALTER TABLE `domain_event_entry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `food`
--

DROP TABLE IF EXISTS `food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `food` (
  `food_id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `image` varchar(255) NOT NULL,
  PRIMARY KEY (`food_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food`
--

LOCK TABLES `food` WRITE;
/*!40000 ALTER TABLE `food` DISABLE KEYS */;
INSERT INTO `food` VALUES ('0a429c9f-0ef1-48bb-9750-886bd6b0a8d4','ผัดไท','https://cdn.discordapp.com/attachments/844870220757860372/1055521673362808912/f5ff71c37a2c4101b895432aae1ac01a.jpg'),('17674b70-99a7-4e78-848e-285dbdfcfafd','ซาชิมิ','https://cdn.discordapp.com/attachments/844870220757860372/1055523907836326008/shutterstock_545334682-1.jpg'),('2ca447a6-a508-4c71-8831-370fdd7e4750','แกงเขียวหวาน','https://cdn.discordapp.com/attachments/844870220757860372/1055521673815806023/f083c309eaab40b8b21efa7eaeda4b87_How_To_Make_Thai_Green_Curry_Like_A_MICHELIN_Starred_Restaurant2.jpg'),('3aab2b35-4299-41c6-a9ad-2478f05997bf','เห็ดโคนผัดไข่เค็ม','https://cdn.discordapp.com/attachments/844870220757860372/1055519105404391424/394759c1c6c269a4.jpg'),('5fd4d609-39f9-4bc0-b536-05b0d6f9202d','เนื้อย่าง','https://cdn.discordapp.com/attachments/844870220757860372/1055524502563459153/Capture-3.png'),('66bbf2ba-aaaa-4707-8841-7606af84c1a6','กุ้งผัดซอสxo','https://cdn.discordapp.com/attachments/844870220757860372/1055519892511670282/1fb8d2d7c882fbaba1a2c09d1d9cbe68_XL.jpg'),('70e78138-c130-423d-b4b9-f04c0023785a','พะโล้','https://cdn.discordapp.com/attachments/844870220757860372/1055521672825946164/12b4a0ebdb2ebd7c2749eeab3df12810_XL.jpg'),('730f04da-084d-437e-8cca-5495fefcdd63','สลัด','https://cdn.discordapp.com/attachments/844870220757860372/1055523908280913921/y4.jpg'),('74f4553c-e57f-4a70-a389-843def120c77','ขนมถ้วยฟู','https://cdn.discordapp.com/attachments/844870220757860372/1055521673102774352/3911a6e9-bed2-48b7-9562-53305e828df4.jpg'),('7f8dabb1-374a-42e6-afb4-8f53ddb7141b','ปลาเก๋าหยกนึ่งซีอิ๊ว','https://cdn.discordapp.com/attachments/844870220757860372/1055519622192967761/7b53c5fc9da5c5f59a036c1e92b7e11a.jpg'),('92024674-7b4f-44aa-9a1c-c2c50f670118','เป็ดย่างปักกิ่ง','https://cdn.discordapp.com/attachments/844870220757860372/1055520427826491462/chyna.jpg'),('a264975c-2217-40d2-b9e1-84d2dd141f49','กุ้งเทมปุระ','https://cdn.discordapp.com/attachments/844870220757860372/1055524186417811506/6430fe0f6ad7af72171f186f8a94820c.jpg'),('a3f50106-f1cd-456b-9759-497e9b47552b','หม้อไฟ','https://cdn.discordapp.com/attachments/844870220757860372/1055523908461281391/37c790c9baa847e4b4e4603e2b8f47cf.jpg'),('a75306bc-ef7d-4ea3-83dc-a3f9ddc40fac','ข้าวเหนียวมะม่วง','https://cdn.discordapp.com/attachments/844870220757860372/1055521672477810748/-1.jpg'),('e157867c-63d9-4b2f-bdb6-4842d8a03488','เป็ดทอดกระเทียม','https://cdn.discordapp.com/attachments/844870220757860372/1055520428078137384/e0b980e0b89be0b987e0b894e0b897e0b8ade0b894e0b881e0b8a3e0b8b0e0b980e0b897e0b8b5e0b8a2e0b8a1.jpg');
/*!40000 ALTER TABLE `food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordercourse`
--

DROP TABLE IF EXISTS `ordercourse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordercourse` (
  `order_id` varchar(255) NOT NULL,
  `price` float(8,2) NOT NULL,
  `discount` float(8,2) NOT NULL,
  `total_price` float(8,2) NOT NULL,
  `reserv_id` varchar(255) NOT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordercourse`
--

LOCK TABLES `ordercourse` WRITE;
/*!40000 ALTER TABLE `ordercourse` DISABLE KEYS */;
INSERT INTO `ordercourse` VALUES ('6e3cc2ef-8e40-4012-9e11-b68aca1f6252',1600.00,40.00,1560.00,'53c0cedb-732e-48d6-95c5-c0cd69d916db'),('7504f4f0-9b4b-4923-9dfb-abfd5117b749',1500.00,0.00,1500.00,'95eeea63-68b4-41ad-a54a-0936c0753a84'),('88ee66d1-d799-4a70-91c7-96b5be3ffe11',1500.00,40.00,1460.00,'0cea267a-772d-4a7a-99b0-9bf80153a155'),('d2bb1d56-f592-4073-80c1-111d75fb06df',1500.00,40.00,1460.00,'8b2f7593-dfb8-43a5-a442-8a5d87ea94f7'),('e4ce2a93-a2ff-4fcf-a193-49494506022b',1600.00,0.00,1600.00,'3952163b-e6a5-4ebf-9b4a-cc163cd890ed');
/*!40000 ALTER TABLE `ordercourse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `payment_id` varchar(255) NOT NULL,
  `image` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `time` time NOT NULL,
  `price` float(8,2) NOT NULL,
  `reserv_id` varchar(255) NOT NULL,
  PRIMARY KEY (`payment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES ('157e3751-3938-4f5c-89d7-6513135e08e2','https://cdn.discordapp.com/attachments/844870220757860372/1055519106171928666/japan.png','2022-12-23','22:05:00',1600.00,'53c0cedb-732e-48d6-95c5-c0cd69d916db'),('24c7be6d-2422-45fe-90d9-f3108782db91','https://cdn.discordapp.com/attachments/844870220757860372/1055519105752510534/china.png','2022-12-23','16:58:00',1500.00,'0cea267a-772d-4a7a-99b0-9bf80153a155'),('49292a5e-fce3-4c15-87fa-8691a710b386','https://cdn.discordapp.com/attachments/844870220757860372/1055519105752510534/china.png','2022-12-23','16:51:00',1500.00,'8b2f7593-dfb8-43a5-a442-8a5d87ea94f7'),('db5ddc57-4937-4391-9430-8ffc37a7ffb4','https://cdn.discordapp.com/attachments/844870220757860372/1055519105752510534/china.png','2022-12-23','14:49:00',1500.00,'95eeea63-68b4-41ad-a54a-0936c0753a84'),('e058149b-666c-48e5-8ecb-de1fb4225ede','https://cdn.discordapp.com/attachments/844870220757860372/1055519106171928666/japan.png','2022-12-23','19:30:00',1600.00,'3952163b-e6a5-4ebf-9b4a-cc163cd890ed');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promotion`
--

DROP TABLE IF EXISTS `promotion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `promotion` (
  `promotion_id` varchar(255) NOT NULL,
  `code` varchar(255) NOT NULL,
  `quantity` int NOT NULL,
  `discount` float(8,2) DEFAULT '0.00',
  PRIMARY KEY (`promotion_id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promotion`
--

LOCK TABLES `promotion` WRITE;
/*!40000 ALTER TABLE `promotion` DISABLE KEYS */;
INSERT INTO `promotion` VALUES ('46c1943c-8ef5-420a-8d9b-c9f9211e83fc','Konami',5,40.00),('c8138645-a139-4206-8110-15843145e837','AmagamiSS',88,40.00),('ce2f9033-cece-4013-abde-e47b8a72f186','Awesome',15,40.00);
/*!40000 ALTER TABLE `promotion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservation` (
  `reserv_id` varchar(255) NOT NULL,
  `booking_date` date NOT NULL,
  `eating_date` date NOT NULL,
  `eating_time` time NOT NULL,
  `user_id` varchar(255) NOT NULL,
  `status` enum('Approve','Waiting','Reject') NOT NULL DEFAULT 'Waiting',
  `rest_id` varchar(255) NOT NULL,
  PRIMARY KEY (`reserv_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` VALUES ('0cea267a-772d-4a7a-99b0-9bf80153a155','2022-12-23','2023-01-08','18:00:00','42d34a72-b7cb-4b00-a180-80cb2433b80a','Approve','96cf62d1-175a-4216-b842-ad9799e7f31b'),('3952163b-e6a5-4ebf-9b4a-cc163cd890ed','2022-12-23','2022-12-31','20:30:00','42d34a72-b7cb-4b00-a180-80cb2433b80a','Reject','7432e5c8-8128-4530-92f3-c7e544b6f32a'),('53c0cedb-732e-48d6-95c5-c0cd69d916db','2022-12-23','2022-12-31','09:16:00','42d34a72-b7cb-4b00-a180-80cb2433b80a','Waiting','7432e5c8-8128-4530-92f3-c7e544b6f32a'),('8b2f7593-dfb8-43a5-a442-8a5d87ea94f7','2022-12-23','2023-01-07','18:00:00','42d34a72-b7cb-4b00-a180-80cb2433b80a','Waiting','7b4ed2d1-1e4f-46c0-aebd-766a6a862d33'),('95eeea63-68b4-41ad-a54a-0936c0753a84','2022-12-23','2023-01-02','15:49:00','42d34a72-b7cb-4b00-a180-80cb2433b80a','Waiting','7b4ed2d1-1e4f-46c0-aebd-766a6a862d33');
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurant`
--

DROP TABLE IF EXISTS `restaurant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `restaurant` (
  `rest_id` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `rating` float(8,2) NOT NULL,
  `branch` varchar(255) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rest_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurant`
--

LOCK TABLES `restaurant` WRITE;
/*!40000 ALTER TABLE `restaurant` DISABLE KEYS */;
INSERT INTO `restaurant` VALUES ('7432e5c8-8128-4530-92f3-c7e544b6f32a','55 ถ.ศรีนครินทร์ แขวง หนองบอน เขต ประเวศ จ.กรุงเทพมหานคร 10250',4.25,'ศรีนครินทร์',NULL),('7b4ed2d1-1e4f-46c0-aebd-766a6a862d33','39 ม.6  ถ.บางนา-ตราด ต.บางแก้วอ.บางพลี จ.สมุทรปราการ 10540',0.00,'บางนา',NULL),('96cf62d1-175a-4216-b842-ad9799e7f31b','999 ม.1 ถ.สุขุมวิท ต.สำโรงเหนือ อ.เมืองสมุทรปราการ จ.สมุทรปราการ 10270',0.00,'สำโรง',NULL);
/*!40000 ALTER TABLE `restaurant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review` (
  `rv_id` varchar(255) NOT NULL,
  `comment` varchar(255) NOT NULL,
  `rest_id` varchar(255) NOT NULL,
  `user_id` varchar(255) NOT NULL,
  `rating` int NOT NULL,
  PRIMARY KEY (`rv_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES ('094fb126-fca2-4b8f-9283-d6ec49e77aab','test','7432e5c8-8128-4530-92f3-c7e544b6f32a','42d34a72-b7cb-4b00-a180-80cb2433b80a',3),('48ab84dc-d791-4ec7-a8f8-11bb04f4ee43','sda','7432e5c8-8128-4530-92f3-c7e544b6f32a','42d34a72-b7cb-4b00-a180-80cb2433b80a',5),('5dd9231b-74fa-4761-a80a-e74fc19a8b23','hello','7432e5c8-8128-4530-92f3-c7e544b6f32a','42d34a72-b7cb-4b00-a180-80cb2433b80a',5),('6f917ddb-fe01-4ed4-937c-99890800b016','delicious','7b4ed2d1-1e4f-46c0-aebd-766a6a862d33','42d34a72-b7cb-4b00-a180-80cb2433b80a',5),('7752bb9a-f4ed-4ec7-a8cb-fd478ec41cd4','tests','7432e5c8-8128-4530-92f3-c7e544b6f32a','42d34a72-b7cb-4b00-a180-80cb2433b80a',5),('a6d145dc-1718-4ba6-9bff-c7c846678052','ad','7432e5c8-8128-4530-92f3-c7e544b6f32a','42d34a72-b7cb-4b00-a180-80cb2433b80a',4),('aa2a275d-570b-4e72-a667-3bc792811cfb','awesome','7b4ed2d1-1e4f-46c0-aebd-766a6a862d33','42d34a72-b7cb-4b00-a180-80cb2433b80a',5),('cc679902-0d3d-4bdc-9433-6424ac345878','test2','7432e5c8-8128-4530-92f3-c7e544b6f32a','42d34a72-b7cb-4b00-a180-80cb2433b80a',3),('de2bbf83-f389-45cd-b439-5e7f576acfe9','recommand','96cf62d1-175a-4216-b842-ad9799e7f31b','42d34a72-b7cb-4b00-a180-80cb2433b80a',5),('e691a66e-61e3-40ce-9f4b-7f6dc949e92c','good','96cf62d1-175a-4216-b842-ad9799e7f31b','42d34a72-b7cb-4b00-a180-80cb2433b80a',4),('f48c0947-25d2-4d02-b2a4-dc22553a8e07','ad','7432e5c8-8128-4530-92f3-c7e544b6f32a','42d34a72-b7cb-4b00-a180-80cb2433b80a',4);
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `saga_entry`
--

DROP TABLE IF EXISTS `saga_entry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `saga_entry` (
  `saga_id` varchar(255) NOT NULL,
  `revision` varchar(255) DEFAULT NULL,
  `saga_type` varchar(255) DEFAULT NULL,
  `serialized_saga` longblob,
  PRIMARY KEY (`saga_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saga_entry`
--

LOCK TABLES `saga_entry` WRITE;
/*!40000 ALTER TABLE `saga_entry` DISABLE KEYS */;
/*!40000 ALTER TABLE `saga_entry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat`
--

DROP TABLE IF EXISTS `seat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seat` (
  `table_id` varchar(255) NOT NULL,
  `status` enum('Available','Unavailable') NOT NULL,
  `rest_id` varchar(255) NOT NULL,
  `table_no` int NOT NULL,
  PRIMARY KEY (`table_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat`
--

LOCK TABLES `seat` WRITE;
/*!40000 ALTER TABLE `seat` DISABLE KEYS */;
INSERT INTO `seat` VALUES ('0cf16838-3c96-495a-8628-6a99e96aa680','Unavailable','7b4ed2d1-1e4f-46c0-aebd-766a6a862d33',1),('20d48d8c-82d5-4480-88d4-3b24725c1199','Available','96cf62d1-175a-4216-b842-ad9799e7f31b',4),('36990a6b-6999-4ce1-b79f-1ebca335cc65','Unavailable','7432e5c8-8128-4530-92f3-c7e544b6f32a',1),('4de81219-5063-4dc9-b4c1-7b927594b120','Available','96cf62d1-175a-4216-b842-ad9799e7f31b',2),('5479fc7d-9c60-4af3-a8b6-1223ab67bb34','Unavailable','7432e5c8-8128-4530-92f3-c7e544b6f32a',2),('61bd4858-7f82-43af-93e7-655c3d08d1a4','Available','96cf62d1-175a-4216-b842-ad9799e7f31b',3),('743db813-712d-43f7-b6f9-d6ae02e3fbde','Available','7b4ed2d1-1e4f-46c0-aebd-766a6a862d33',2),('76db6739-cb95-458f-a327-ce525af8d077','Available','7b4ed2d1-1e4f-46c0-aebd-766a6a862d33',4),('7a75abb6-d0bb-46de-85f5-8de296d554e7','Available','7b4ed2d1-1e4f-46c0-aebd-766a6a862d33',3),('7c91925c-c3dc-40f5-ad75-2fee45be926c','Unavailable','7432e5c8-8128-4530-92f3-c7e544b6f32a',4),('a198370f-b9b9-4ba9-b248-0703bc3c3f6c','Available','7432e5c8-8128-4530-92f3-c7e544b6f32a',3),('f85c4003-ad21-4b62-aba3-6f5e15a808a7','Unavailable','96cf62d1-175a-4216-b842-ad9799e7f31b',1);
/*!40000 ALTER TABLE `seat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `snapshot_event_entry`
--

DROP TABLE IF EXISTS `snapshot_event_entry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `snapshot_event_entry` (
  `aggregate_identifier` varchar(255) NOT NULL,
  `sequence_number` bigint NOT NULL,
  `type` varchar(255) NOT NULL,
  `event_identifier` varchar(255) NOT NULL,
  `meta_data` longblob,
  `payload` longblob NOT NULL,
  `payload_revision` varchar(255) DEFAULT NULL,
  `payload_type` varchar(255) NOT NULL,
  `time_stamp` varchar(255) NOT NULL,
  PRIMARY KEY (`aggregate_identifier`,`sequence_number`,`type`),
  UNIQUE KEY `UK_e1uucjseo68gopmnd0vgdl44h` (`event_identifier`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `snapshot_event_entry`
--

LOCK TABLES `snapshot_event_entry` WRITE;
/*!40000 ALTER TABLE `snapshot_event_entry` DISABLE KEYS */;
/*!40000 ALTER TABLE `snapshot_event_entry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token_entry`
--

DROP TABLE IF EXISTS `token_entry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `token_entry` (
  `processor_name` varchar(255) NOT NULL,
  `segment` int NOT NULL,
  `owner` varchar(255) DEFAULT NULL,
  `timestamp` varchar(255) NOT NULL,
  `token` longblob,
  `token_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`processor_name`,`segment`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token_entry`
--

LOCK TABLES `token_entry` WRITE;
/*!40000 ALTER TABLE `token_entry` DISABLE KEYS */;
INSERT INTO `token_entry` VALUES ('__config',0,NULL,'2022-12-23T15:00:20.599Z',_binary '<org.axonframework.eventhandling.tokenstore.ConfigToken><config class=\"singleton-map\"><entry><string>id</string><string>94842502-f3af-4212-a551-bc6fe0f3dd72</string></entry></config></org.axonframework.eventhandling.tokenstore.ConfigToken>','org.axonframework.eventhandling.tokenstore.ConfigToken'),('com.example.menuservice.course.command.event',0,NULL,'2022-12-23T15:09:41.197Z',_binary '<org.axonframework.eventhandling.GlobalSequenceTrackingToken><globalIndex>7</globalIndex></org.axonframework.eventhandling.GlobalSequenceTrackingToken>','org.axonframework.eventhandling.GlobalSequenceTrackingToken'),('com.example.promotionservice.command.event',0,NULL,'2022-12-23T15:09:45.378Z',_binary '<org.axonframework.eventhandling.GlobalSequenceTrackingToken><globalIndex>7</globalIndex></org.axonframework.eventhandling.GlobalSequenceTrackingToken>','org.axonframework.eventhandling.GlobalSequenceTrackingToken'),('com.example.reservservice.order.command.event',0,NULL,'2022-12-23T15:09:37.286Z',_binary '<org.axonframework.eventhandling.GlobalSequenceTrackingToken><globalIndex>7</globalIndex></org.axonframework.eventhandling.GlobalSequenceTrackingToken>','org.axonframework.eventhandling.GlobalSequenceTrackingToken'),('com.example.reservservice.payment.command.event',0,NULL,'2022-12-23T15:09:37.097Z',_binary '<org.axonframework.eventhandling.GlobalSequenceTrackingToken><globalIndex>7</globalIndex></org.axonframework.eventhandling.GlobalSequenceTrackingToken>','org.axonframework.eventhandling.GlobalSequenceTrackingToken'),('com.example.reservservice.reservation.command.event',0,NULL,'2022-12-23T15:09:37.286Z',_binary '<org.axonframework.eventhandling.GlobalSequenceTrackingToken><globalIndex>7</globalIndex></org.axonframework.eventhandling.GlobalSequenceTrackingToken>','org.axonframework.eventhandling.GlobalSequenceTrackingToken'),('com.example.reservservice.restaurant.command.event',0,NULL,'2022-12-23T15:09:37.238Z',_binary '<org.axonframework.eventhandling.GlobalSequenceTrackingToken><globalIndex>7</globalIndex></org.axonframework.eventhandling.GlobalSequenceTrackingToken>','org.axonframework.eventhandling.GlobalSequenceTrackingToken'),('com.example.reservservice.table.command.event',0,NULL,'2022-12-23T15:09:37.287Z',_binary '<org.axonframework.eventhandling.GlobalSequenceTrackingToken><globalIndex>7</globalIndex></org.axonframework.eventhandling.GlobalSequenceTrackingToken>','org.axonframework.eventhandling.GlobalSequenceTrackingToken'),('com.example.reviewservice.command.event',0,NULL,'2022-12-23T15:09:47.799Z',_binary '<org.axonframework.eventhandling.GlobalSequenceTrackingToken><globalIndex>7</globalIndex></org.axonframework.eventhandling.GlobalSequenceTrackingToken>','org.axonframework.eventhandling.GlobalSequenceTrackingToken'),('com.example.userservice.command.event',0,NULL,'2022-12-23T15:09:32.505Z',_binary '<org.axonframework.eventhandling.GlobalSequenceTrackingToken><globalIndex>7</globalIndex></org.axonframework.eventhandling.GlobalSequenceTrackingToken>','org.axonframework.eventhandling.GlobalSequenceTrackingToken');
/*!40000 ALTER TABLE `token_entry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `role` enum('User','Admin') NOT NULL,
  `rest_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('42d34a72-b7cb-4b00-a180-80cb2433b80a','021@gmail.com',';<=','a','b','User',NULL),('9b100795-e579-4a69-9d2f-9252b054d253','037@gmail.com',';<=','Chinatip','Chanpong','User',NULL),('b361b9cd-4b98-4043-a123-de8f318589b9','022@gmail.com',';<=','c','d','Admin',NULL);
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

-- Dump completed on 2022-12-23 22:14:51
