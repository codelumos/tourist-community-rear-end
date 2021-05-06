-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: travel
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
-- Table structure for table `lp`
--

DROP TABLE IF EXISTS `lp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `lp` (
  `LP_id` int(11) NOT NULL AUTO_INCREMENT,
  `LP_name` varchar(20) DEFAULT NULL,
  `description` text,
  `is_home` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`LP_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lp`
--

LOCK TABLES `lp` WRITE;
/*!40000 ALTER TABLE `lp` DISABLE KEYS */;
INSERT INTO `lp` VALUES (1,'其他','用作用户输入',NULL),(2,'湖南','湖南是华夏文明的重要发祥地之一，相传炎帝神农氏在此种植五谷、织麻为布、制作陶器，坐落于炎陵县西部的炎帝陵成为凝聚中华民族的精神象征；舜帝明德天下，足历洞庭，永州九嶷山为其陵寝之地。 湖南自古盛植木芙蓉，五代时就有“秋风万里芙蓉国”之说，因此又有“芙蓉国”之称。',1),(3,'河南','河南是中华民族与华夏文明的发源地。中国四大发明中的指南针、造纸、火药三大技术均发明于河南。从夏朝至宋朝，河南一直是中国政治、经济、文化和交通中心，先后有20多个朝代建都或迁都河南，中国八大古都中河南有十三朝古都洛阳、八朝古都开封、七朝古都安阳、夏商古都郑州四个及商丘、南阳、许昌、濮阳等古都，是中国建都朝代最多、建都历史最长、古都数量最多的省份。河南自古就有“天下名人，中州过半”之说，有商汤、老子、庄子、墨子、韩非子、范蠡、商鞅、苏秦、吕不韦、李斯、贾谊、张衡、杜甫、韩愈、白居易、刘禹锡、李商隐、李贺、岳飞等历史名人。',1),(4,'广东','广东是岭南文化的重要传承地，在语言、风俗、生活习惯和历史文化等方面都有着独特风格。广东通行粤语、客家语和闽语，而且粤、客两大方言的中心都在广东。广东也是目前中国人口最多的省份。',1),(5,'江苏','江苏辖江临海，扼淮控湖，经济繁荣，教育发达，文化昌盛，素有“山水江南、鱼米之乡”的美誉，地理上跨越南北，同时具有南方和北方的特征 。地形以平原为主，陆地面积10.32万平方千米，占全国的1.08%。人均国土面积在全国各省区中最少，是中国面积较小的省份之一。',1),(6,'内蒙古','内蒙古自治区，通称内蒙古，简称“蒙”。首府呼和浩特市。内蒙古横跨中国东北、华北、西北三大地区，接邻八个省区，是中国邻省较多的省级行政区之一。',1),(7,'云南','云南动植物种类数为全国之冠，素有“动植物王国”之称，被誉为“有色金属王国”，历史文化悠久，自然风光绚丽，有丽江古城、三江并流、石林、哈尼梯田、大理古城、崇圣寺三塔、玉龙雪山、洱海、滇池、抚仙湖、梅里雪山、普达措国家公园、噶丹松赞林寺、西双版纳热带雨林等旅游景点。',1),(8,'湖北','湖北省位居华中腹地，是中华文明的重要发祥地之一。先秦时期，从哲学到文学，产生了老子、庄子、屈原，历经800年，楚国创造了灿烂的楚文化。湖北还具有光荣的革命传统，从武昌辛亥首义到新中国成立，为中国革命胜利作出了重要贡献。新民主主义革命时期，湖北有70万革命英雄献出了宝贵生命。',1),(10,'西藏','西藏北邻新疆，东接四川，东北紧靠青海，东南连接云南；周边与缅甸、印度、不丹、尼泊尔、克什米尔等国家及地区接壤，陆地国界线4000多公里，是中国西南边陲的重要门户。西藏以其雄伟壮观、神奇瑰丽的自然风光闻名。它地域辽阔，地貌壮观、资源丰富。自古以来，这片土地上的人们创造了丰富灿烂的民族文化。',1),(11,'印度尼西亚','印度尼西亚共和国（印尼语：Republik Indonesia，英语：Republic of Indonesia），简称印度尼西亚（Indonesia）。是东南亚国家，首都为雅加达。与巴布亚新几内亚、东帝汶和马来西亚等国家相接。由约17508个岛屿组成，是马来群岛的一部分，也是全世界最大的群岛国家，疆域横跨亚洲及大洋洲，别称“千岛之国”。',0),(12,'法国','法国为欧洲国土面积第三大、西欧面积最大的国家，东与比利时、卢森堡、德国、瑞士、意大利接壤，南与西班牙、安道尔、摩纳哥接壤。本土地势东南高西北低，大致呈六边形，三面临水，南临地中海，西濒大西洋，西北隔英吉利海峡与英国相望，科西嘉岛是法国最大岛屿。',0),(13,'英国','英国是一个高度发达的资本主义国家，欧洲四大经济体之一，其国民拥有较高的生活水平和良好的社会保障制度。作为英联邦元首国、八国集团成员国、北约创始会员国、英国同时也是联合国安全理事会五大常任理事国之一。',0),(14,'广西','广西先秦时已存在新石器时代和青铜时代高度文明，境内有距今7000年的甑皮岩遗址、白莲洞遗址等文化遗存，是桂柳文化、岭南文明的发源地，是中华文明的发祥地之一，广西是中国—东盟博览会的举办地，在中国与东南亚的经济交往中占有重要地位，是西南地区最便捷的出海通道。',1),(15,'北京',NULL,1),(16,'山东',NULL,1),(17,'帕劳',NULL,0),(18,'台湾',NULL,0),(19,'福建',NULL,NULL);
/*!40000 ALTER TABLE `lp` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-21  9:09:02
