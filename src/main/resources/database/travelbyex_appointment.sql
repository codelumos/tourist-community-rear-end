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
-- Table structure for table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `appointment` (
  `appointment_id` int(11) NOT NULL AUTO_INCREMENT,
  `author_id` varchar(15) DEFAULT NULL,
  `lp` varchar(20) DEFAULT NULL,
  `sp` varchar(20) DEFAULT NULL,
  `spot_name` varchar(50) DEFAULT NULL,
  `time` date DEFAULT NULL,
  `content_ex` mediumtext,
  `image_path` varchar(150) DEFAULT NULL,
  `sum` smallint(6) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `tag_1` varchar(8) DEFAULT NULL,
  `tag_2` varchar(8) DEFAULT NULL,
  `tag_3` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`appointment_id`),
  KEY `FK_pointment_user` (`author_id`),
  CONSTRAINT `FK_pointment_user` FOREIGN KEY (`author_id`) REFERENCES `account` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment`
--

LOCK TABLES `appointment` WRITE;
/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
INSERT INTO `appointment` VALUES (5,'liu','湖南','张家界','天门山','2018-10-05','国庆节天门山约一波，有人一起吗？微信号123456',NULL,5,'国庆之行','爬山','户外','刺激'),(6,'huang','广东','广州','小蛮腰','2018-10-31','机票已出11.01长沙飞广州，打算在广州玩几天，去小蛮腰等地方。大家有兴趣可以一起拼车拼吃。男的打地铺都行！期待你的加入。。。微信ydy4541（备注结伴哦）',NULL,8,'11月小蛮腰','都市风情','摄影',''),(7,'huang','内蒙古','赤峰市','乌兰布统','2018-11-15','#乌兰布统8天游#2018.11.16从长沙出发，现已有3人拼车出发，为了节省费用还差一名女同胞，有兴趣的伙伴可以约一起哟~',NULL,10,'乌兰布统，与众不同的草原风光','草原风光','户外','摄影'),(8,'zhang','湖南','长沙','橘子洲','2018-12-10','在橘子洲走走，转下五一广场，坡子街放松下心情，有意者加我微信etctc46615噢！',NULL,5,'长沙休闲游','都市风情','摄影','徒步'),(9,'zhang','云南','大理','洱海','2018-12-20','行程车和酒店都已经定了，之前水了两个小伙伴，再捡5人。我们是12..21长沙包车出发一共8天时间，29号回长沙 微信号etctc46615',NULL,5,'大理组团','古城','自驾游','摄影'),(10,'shi','江苏','泰州','','2018-09-25','实训结束趁着国庆回家里休息一下，可以充当导游，感兴趣的朋友加QQ49816518449。',NULL,3,'泰州5日行','休闲','都市风情',''),(11,'shi','河南','郑州','二七广场','2018-10-02','想借长假出去走走，不想跟团，边走边逛，有童鞋要组队吗？加微信5284yiuubu',NULL,5,'郑州','都市风情','背包客',''),(12,'shi','湖南','长沙','岳麓书院','2018-10-03','去岳麓书院转一下，有湖大的同学做导游，感兴趣的私我。QQ456195946',NULL,5,'岳麓书院','书院','休闲',''),(13,'liu','印度尼西亚','巴厘岛','巴厘岛蓝点','2018-10-02','#巴厘岛8日游#   10.03的机票，欢迎加入，一起拼吃拼喝都可以，QQ7892826',NULL,8,'巴厘岛组团','休闲','摄影','户外'),(14,'liu','河南','郑州','二七广场','2018-10-02','#二七拼途# 目前已有2人均为郑州人，欢迎加入！QQ465498498',NULL,3,'二七广场','都市风情','休闲','徒步'),(15,'liu','湖南','长沙','橘子洲','2018-10-03','中南本科生，实训结束出去放松一波，有人约吗？最好也是中南铁道的。QQ598615849',NULL,5,'橘子洲','休闲','都市风情','户外'),(16,'huang','湖南','长沙','橘子洲','2018-10-01','中南铁道一把抓，去橘子洲附近放松心情，散散步，有没有中南的女生：-）。QQ4984519811',NULL,5,'橘子洲头','休闲','都市风情','摄影'),(17,'huang','湖南','长沙','岳麓书院','2018-09-29','先去岳麓山，然后去岳麓书院。QQ46579484984',NULL,3,'岳麓书院','书院','休闲','爬山'),(18,'zhang','湖南','长沙','橘子洲','2018-10-27','去橘子洲、五一广场、太平街吃吃喝喝。QQ68748918',NULL,5,'橘子洲','休闲','户外','都市风情'),(19,'zhang','印度尼西亚','巴厘岛','海神庙','2018-10-23','去做历史考察，有兴趣的约一波！QQ4687665',NULL,3,'巴厘岛','背包客','徒步','户外'),(20,'liu','印度尼西亚','巴厘岛','库塔海滩','2018-10-02','到库塔海滩去冲浪，需要会游泳，大约7天。QQ76815653434',NULL,5,'巴厘岛库塔海滩','刺激','户外','摄影'),(21,'shi','印度尼西亚','巴厘岛','库塔海滩','2018-09-29','为结婚做准备，选个好点的地方。有没有组团的？QQ46416511',NULL,3,'乌布','休闲','海滨','摄影'),(22,'zhang','印度尼西亚','巴厘岛','乌鲁瓦图断崖','2018-09-28','喜爱自然，去感受更多的美景。QQ6874186848',NULL,3,'巴厘岛','爬山','休闲','徒步'),(24,'liu','福建','厦门','白城沙滩','2018-09-28','有一起去的吗？QQ6848648','/static/img/sea.jpg',5,'厦门','海滨','','');
/*!40000 ALTER TABLE `appointment` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-21  9:08:59
