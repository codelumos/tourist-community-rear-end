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
-- Table structure for table `sp`
--

DROP TABLE IF EXISTS `sp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `sp` (
  `sp_id` int(11) NOT NULL AUTO_INCREMENT,
  `LP_id` int(11) DEFAULT NULL,
  `sp_name` varchar(20) DEFAULT NULL,
  `description` text,
  `image_path1` varchar(150) DEFAULT NULL,
  `image_path2` varchar(150) DEFAULT NULL,
  `image_path3` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`sp_id`),
  KEY `FK_SP_to_LP` (`LP_id`),
  CONSTRAINT `FK_SP_to_LP` FOREIGN KEY (`LP_id`) REFERENCES `lp` (`lp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sp`
--

LOCK TABLES `sp` WRITE;
/*!40000 ALTER TABLE `sp` DISABLE KEYS */;
INSERT INTO `sp` VALUES (1,1,'其他','用作用户输入',NULL,NULL,NULL),(2,2,'长沙','长沙是首批国家历史文化名城，历经三千年城名、城址不变，有“屈贾之乡”、“潇湘洙泗”之称 。存有马王堆汉墓、三国吴简、铜官窑等历史遗迹。凝练出“经世致用、兼收并蓄”的湖湘文化和“心忧天下、敢为人先”的长沙精神。长沙作为维新运动、旧民主主义革命、新民主主义革命策源地和发祥地之一 ，孕育和走出了曾国藩、左宗棠、谭嗣同、黄兴、蔡锷、毛泽东、刘少奇等名人 。','','',''),(3,3,'郑州','郑州是国家历史文化名城，是华夏文明重要发祥地之一，为中华人文始祖轩辕黄帝的故里，历史上曾五次为都、八代为州，是“中国八大古都”  之一和世界历史都市联盟成员。全市有世界文化遗产2项15处，全国重点文物保护单位38处43项  ，拥有黄帝故里、商城遗址、天地之中等众多历史人文景观。','','',''),(4,4,'珠海','珠海是全国唯一以整体城市景观入选“全国旅游胜地四十佳”的城市，中国海滨城市。2013中国城市可持续发展指数报告珠海综合排名全国第一 ，珠海为新型花园城市；珠海属国家新颁布的“幸福之城”，有“浪漫之城” 的称号。','','',''),(5,4,'江门','江门市，广东省辖地级市，地处珠江三角洲西部，因位于西江与其支流蓬江的会合处，江南烟墩山和江北蓬莱山对峙如门，故名江门。江门市是珠江三角洲西部地区的中心城市之一。','','',''),(6,4,'揭阳','揭阳素有“海滨邹鲁”、“国画之乡”、“小戏之乡”、“龙舟之乡”、“华侨之乡”之美称，是潮汕文化的发祥地，粤东古邑，广东省历史文化名城，全国著名侨乡，有华侨320多万人，遍居世界各地，还有归侨、侨眷180万人。','','',''),(7,5,'泰州','泰州有2100多年的建城史，秦称海阳，汉称海陵，州建南唐，文昌北宋。南唐时（公元937年）为州治，取“国泰民安”之意，始名泰州。泰州人文荟萃、名贤辈出，“儒风之盛，素冠淮南”。王艮、刘熙载、施耐庵、郑板桥、梅兰芳是泰州文化艺术史上的杰出代表。','','',''),(8,6,'呼和浩特','呼和浩特有着悠久的历史和光辉灿烂的文化，是华夏文明的发祥地之一。先秦时期，赵武灵王在此设云中郡，故址在今呼市西南托克托县境。民国时期为绥远省省会，蒙绥合并后，呼和浩特成为内蒙古自治区首府。呼市中心城区本是由归化城与绥远城两座城市在清末民国合并而成，故名归绥。1954年改名为呼和浩特，蒙古语意为“青色的城”。','','',''),(9,7,'大理','地处低纬高原，四季温差不大，干湿季分明，以低纬高原季风气候为主，境内以蝴蝶泉、苍山、洱海、大理古城、崇圣寺三塔等景点最有代表性。','','',''),(10,4,'广州','广州是国家历史文化名城，从秦朝开始，广州一直是郡治、州治、府治的行政中心；一直是华南地区的政治、军事、经济、文化和科教中心，是岭南文化的发源地和兴盛地。广州从东汉时期起成为海上丝绸之路的主港，唐宋时期成为中国第一大港，是世界著名的东方港市；明清时期是中国唯一的对外贸易大港，是世界上唯一2000多年长盛不衰的大港。',NULL,NULL,NULL),(11,2,'张家界','张家界是湖南省辖地级市，原名大庸市，辖2个市辖区（永定区、武陵源区）、2个县（慈利县、桑植县）。位于湖南西北部，澧水中上游，属武陵山区腹地。 张家界因旅游建市，是中国最重要的旅游城市之一，是湘鄂渝黔革命根据地的发源地和中心区域。',NULL,NULL,NULL),(13,6,'赤峰市','赤峰是中华文化发源地之一，境内有红山文化遗址。历史上在辽西走廊得到开发之前曾是中原地区进入东北地区的唯一通道，自明清以来是关内商旅进出蒙古高原、松辽平原的必经之路，燕山以北地区的商贸重镇，自古便有“金朝阳，银赤峰，拉不败的哈达，填不满的八沟”之称。',NULL,NULL,NULL),(14,10,'拉萨','作为首批国家历史文化名城，拉萨以风光秀丽、历史悠久、风俗民情独特、宗教色彩浓厚而闻名于世，先后荣获中国优秀旅游城市、欧洲游客最喜爱的旅游城市、全国文明城市、中国最具安全感城市、中国特色魅力城市200强、世界特色魅力城市200强  、2018畅游中国100城等荣誉称号。',NULL,NULL,NULL),(15,11,'巴厘岛','在巴厘岛的语言中,根本就没有“天堂”这个词语,或许生活在天堂里的人是不需要把词语经常挂在嘴边的。没错,这里就是天堂。巴厘岛,行政上称为巴厘省,是印度尼西亚33个一级行政区之一,也是著名的旅游胜地。巴厘岛隔巴厘海峡与印度尼西亚东哇岛相望,这个美丽的岛屿因其如画的风景、纯朴的民风而成为世界级的旅游度假区。',NULL,NULL,NULL),(16,12,'巴黎','巴黎是法国的首都和最大的城市,也是法国的政治、经济、文化中心,同时又是四大世界级城市之一,仅次于美国纽约、英国伦敦,和日本东京并列。巴黎在自中世纪以来的发展中,一面保留过去的印记,甚至是历史最悠久的某些街道的布局一面保留过去的印记,甚至是历史最悠久的某些街道的布局,一面形成了统一的风格,实现了现代化的基础设施建设。',NULL,NULL,NULL),(17,13,'剑桥','剑桥是英国剑桥郡首府，剑桥大学所在地，早在两千年前，罗马人就曾在这个距伦敦约90公里的地方安营扎寨，屯兵驻军。虽然如此，在漫长的岁月里，剑桥只是个乡间集镇而已。直到剑桥大学成立后，这个城镇的名字才渐为人所知，今天它是座9.2万人口的城市。',NULL,NULL,NULL),(18,12,'安纳西','安纳西（Annecy）又译作安娜西，为法国东南部小城，位于罗纳-阿尔卑斯（Rhone Alpes)大区的上萨瓦省(Haute-Savoie），日内瓦(Geneva）以南35千米。安纳西地区有十三个自治市，是其管辖的三个行政区的首府。',NULL,NULL,NULL),(19,6,'乌海','乌海市素有“黄河明珠”的美誉，三山环抱，一水中流，民风淳厚，被誉为镶嵌在黄河金腰带上的一颗明珠。国家重点建设项目黄河海勃湾水利枢纽工程于2010年4月开工建设，2013年9月开始蓄水，形成118平方公里水面的“乌海湖”，水面面积是杭州西湖的20倍、宁夏沙湖的5.4倍，届时乌海市将成为依山傍水、水绕城中、特色鲜明的独特格局，环境更加优美，成为名副其实的“黄河明珠” 。',NULL,NULL,NULL),(20,14,'桂林','桂林昔称八桂、桂州，是首批国家历史文化名城，是华夏文明重要发祥地之一，桂林因桂树繁多，桂花成林而得名。是具有万年历史的人类智慧圣地，桂林是目前世界上唯一具有三处万年古陶遗址（甑皮岩、大岩、庙岩）的城市，桂林甑皮岩发现的\"陶雏器\"填补世界陶器起源空白点。同时佣有世界自然遗产桂林山水、世界灌溉遗产灵渠两大世界遗产。',NULL,NULL,NULL),(21,15,'海坨山',NULL,NULL,NULL,NULL),(22,16,'济南',NULL,NULL,NULL,NULL),(23,17,'长滩岛',NULL,NULL,NULL,NULL),(24,18,'花莲县',NULL,NULL,NULL,NULL),(25,19,'厦门',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `sp` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-21  9:09:00
