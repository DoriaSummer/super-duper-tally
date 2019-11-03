CREATE DATABASE  IF NOT EXISTS `VOTESYS` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `VOTESYS`;
-- MySQL dump 10.13  Distrib 8.0.18, for macos10.14 (x86_64)
--
-- Host: localhost    Database: VOTESYS
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `candidate`
--

DROP TABLE IF EXISTS `candidate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `candidate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `surname` varchar(45) DEFAULT NULL,
  `firstname` varchar(45) DEFAULT NULL,
  `party` varchar(100) DEFAULT NULL,
  `state` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=633 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidate`
--

LOCK TABLES `candidate` WRITE;
/*!40000 ALTER TABLE `candidate` DISABLE KEYS */;
INSERT INTO `candidate` VALUES (1,'HOBBS','Christina','The Greens','ACT'),(2,'HENNINGS','Cawley','Liberal Democrats','ACT'),(3,'KIM','David William','Christian Democratic Party (Fred Nile Group)','ACT'),(4,'MONTAGNE','Jessica','Animal Justice Party','ACT'),(5,'EDWARDS','David','Secular Party of Australia','ACT'),(6,'GALLAGHER','Katy','Australian Labor Party','ACT'),(7,'DONNELLY','Matt','Liberal Democrats','ACT'),(8,'FIELD','Deborah','Animal Justice Party','ACT'),(9,'TYE','Martin','Sustainable Australia','ACT'),(10,'SMITH','David','Australian Labor Party','ACT'),(11,'O\'CONNOR','Sandie','Rise Up Australia Party','ACT'),(12,'SESELJA','Zed','Liberal','ACT'),(13,'HAYDON','John','Sustainable Australia','ACT'),(14,'WYATT','Jess','Rise Up Australia Party','ACT'),(15,'HIATT','Jane','Liberal','ACT'),(16,'BAILEY','Steven','Australian Sex Party','ACT'),(17,'HAY','Michael Gerard','VOTEFLUX.ORG | Upgrade Democracy!','ACT'),(18,'HANSON','Anthony','Mature Australia','ACT'),(19,'WAREHAM','Sue','The Greens','ACT'),(20,'MIHALJEVIC','Denis','Secular Party of Australia','ACT'),(21,'SWAN','Robbie','Australian Sex Party','ACT'),(22,'TADROS','Elizabeth','Christian Democratic Party (Fred Nile Group)','ACT'),(23,'WILLIS','Dawn','Democratic Labour Party (DLP)','NSW'),(24,'O\'SULLIVAN','Mary','Labor','NSW'),(25,'SPRUCE-PEET-BOYD','Santa','Independent','NSW'),(26,'CARR','Mitch','Jacqui Lambie Network','NSW'),(27,'THOMPSON','Andy','Non-Custodial Parents Party (Equal Parenting)','NSW'),(28,'TUCKER','Brian Malcolm','Rise Up Australia Party','NSW'),(29,'RHIANNON','Lee','The Greens','NSW'),(30,'EVANS','Gillian','Seniors United Party of Australia','NSW'),(31,'MAIDEN','Kathryn','The Greens','NSW'),(32,'PATTERSON','Andrew James','Health Australia Party','NSW'),(33,'GRAHAM','Greg','Sustainable Australia','NSW'),(34,'STONER','Lynda','Animal Justice Party','NSW'),(35,'RAYE','Sue','Australian Sex Party','NSW'),(36,'JOBE','Phil','Family First','NSW'),(37,'CAMERON','Doug','Labor','NSW'),(38,'WRIGHTSON','Suellen Marree','Palmer United Party','NSW'),(39,'FIERRAVANTI-WELLS','Concetta','Liberal','NSW'),(40,'LIONS','Deborah Ann Jane','Christian Democratic Party (Fred Nile Group)','NSW'),(41,'FERNANDES','Sarah','The Greens','NSW'),(42,'MULLER','Stephen','Independent','NSW'),(43,'FREARSON','Gregory','Mature Australia','NSW'),(44,'NICHOLS','Maree','Rise Up Australia Party','NSW'),(45,'BYRNES','Howard','Socialist Alliance','NSW'),(46,'ROSE','Ash','Australian Progressives','NSW'),(47,'DASTYARI','Sam','Labor','NSW'),(48,'JANSSON','James','Science Party','NSW'),(49,'DONA','Anthony','Nick Xenophon Team','NSW'),(50,'GOOLEY','Peter','Independent','NSW'),(51,'AVASALU','Rhonda','Christian Democratic Party (Fred Nile Group)','NSW'),(52,'KNOX','Charles','Christian Democratic Party (Fred Nile Group)','NSW'),(53,'VINCENT','Sally','Family First','NSW'),(54,'DER SARKISSIAN','Berge Anthony','Online Direct Democracy - (Empowering the People!)','NSW'),(55,'BROWN','Leonard','Independent','NSW'),(56,'PERROW','Susan','Renewable Energy Party','NSW'),(57,'STEVENS','Ken','Derryn Hinch\'s Justice Party','NSW'),(58,'OSBORNE','Chris','Seniors United Party of Australia','NSW'),(59,'JOHNSON','Peter','Shooters, Fishers and Farmers','NSW'),(60,'BENNIE','Raymond','Veterans Party','NSW'),(61,'HALL','Nella','Christian Democratic Party (Fred Nile Group)','NSW'),(62,'LAMBERT','Bryan','Independent','NSW'),(63,'KELDOULIS','Barry','The Arts Party','NSW'),(64,'RZETELSKI','Joanna','Independent','NSW'),(65,'BURSTON','Brian','Pauline Hanson\'s One Nation','NSW'),(66,'RELPH','Bruce','Jacqui Lambie Network','NSW'),(67,'PAYNE','Marise','Liberal','NSW'),(68,'SMITH','Kirralie Jane','Australian Liberty Alliance','NSW'),(69,'SMITH','Nigel James','Independent','NSW'),(70,'TSAY','Richelle Girado','Independent','NSW'),(71,'HUGHES','Hollie','Liberal','NSW'),(72,'BANDARA','Jagath','Labor','NSW'),(73,'MULLER','Peter','Independent','NSW'),(74,'LOPEZ','Steven','VOTEFLUX.ORG | Upgrade Democracy!','NSW'),(75,'NASH','Fiona','The Nationals','NSW'),(76,'CANNING','Ken','Socialist Alliance','NSW'),(77,'HOUSEMAN','Karl','Shooters, Fishers and Farmers','NSW'),(78,'McINTOSH','Darren','Pirate Party Australia','NSW'),(79,'LEA','Archie','Christian Democratic Party (Fred Nile Group)','NSW'),(80,'BROADBRIDGE','Colin','Christian Democratic Party (Fred Nile Group)','NSW'),(81,'WASHBOURNE','Adam','Derryn Hinch\'s Justice Party','NSW'),(82,'HAN','Paul Yi-Wen','Labor','NSW'),(83,'LEYONHJELM','David','Liberal Democrats','NSW'),(84,'WILLIAMS','John','The Nationals','NSW'),(85,'KIRKNESS','Daniel','Australian Motoring Enthusiast Party','NSW'),(86,'BREEN','Peter','Renewable Energy Party','NSW'),(87,'JANARTHANA','Jananie','The Greens','NSW'),(88,'THOMSON','Vivien','Labor','NSW'),(89,'SPATARO','Nathan','VOTEFLUX.ORG | Upgrade Democracy!','NSW'),(90,'MOLAN','Jim','Liberal','NSW'),(91,'BUTLER','Robert','Citizens Electoral Council','NSW'),(92,'BRADBURY','Mark','Veterans Party','NSW'),(93,'MORGAN','Methuen','CountryMinded','NSW'),(94,'HO','Christina','The Greens','NSW'),(95,'MARKS','Robert James','Palmer United Party','NSW'),(96,'COOPER','Jai','Australian Cyclists Party','NSW'),(97,'LAWLER','Ann','Citizens Electoral Council','NSW'),(98,'DONNELLY','Cara Melissa','Palmer United Party','NSW'),(99,'POULSEN','Ron','','NSW'),(100,'COGAN','James','Socialist Equality Party','NSW'),(101,'BRYDEN','Rob','Australian Motoring Enthusiast Party','NSW'),(102,'MORIARTY','Tara','Labor','NSW'),(103,'EMMETT','Arthur John','Online Direct Democracy - (Empowering the People!)','NSW'),(104,'RALPH','Ingrid','Australian Cyclists Party','NSW'),(105,'QUARTLY','Allan','Australian Progressives','NSW'),(106,'SMITH','Beth','Christian Democratic Party (Fred Nile Group)','NSW'),(107,'FARRELL','Janise','Voluntary Euthanasia Party','NSW'),(108,'KONTELLIS','Marika','The Greens','NSW'),(109,'DALGLIESH','Aidan','Nick Xenophon Team','NSW'),(110,'McGAHEY','Victoria','Liberal','NSW'),(111,'BOURKE','William','Sustainable Australia','NSW'),(112,'SLAVICH','Eve','Science Party','NSW'),(113,'LIM','Danny','Independent','NSW'),(114,'OSBORNE','Michael','The Greens','NSW'),(115,'VAN LIESHOUT','Teresa','','NSW'),(116,'WARD','Jane','Independent','NSW'),(117,'BERNIER','Christine Pamela','Pauline Hanson\'s One Nation','NSW'),(118,'DAVIS','John','Socialist Equality Party','NSW'),(119,'FANG','Wes','The Nationals','NSW'),(120,'QUINN','Paul','Mature Australia','NSW'),(121,'ZHOU','Shuo','Labor','NSW'),(122,'BELCASTRO','Anthony Geno','Katter\'s Australian Party','NSW'),(123,'GRZIC','Warren','Independent','NSW'),(124,'HIGSON','Shayne','Voluntary Euthanasia Party','NSW'),(125,'ELLIS','Dee','Secular Party of Australia','NSW'),(126,'EL-DAGHL','Lena','Christian Democratic Party (Fred Nile Group)','NSW'),(127,'KEARNS','Sam','Pirate Party Australia','NSW'),(128,'OAKLEY','Jane','The Greens','NSW'),(129,'HARRIS','Tom','Katter\'s Australian Party','NSW'),(130,'McALLISTER','Jenny','Labor','NSW'),(131,'GREENING','Eric','Non-Custodial Parents Party (Equal Parenting)','NSW'),(132,'ANDERSON','Gary','Australian Liberty Alliance','NSW'),(133,'KOLIADIS','Kerry','Seniors United Party of Australia','NSW'),(134,'PHILLIPS','Andrew','Christian Democratic Party (Fred Nile Group)','NSW'),(135,'McCORMACK','Paul','Democratic Labour Party (DLP)','NSW'),(136,'GOODLASS','Ray','The Greens','NSW'),(137,'LEROY-DYER','Sharlene','Socialist Alliance','NSW'),(138,'PRICE','Susan','Socialist Alliance','NSW'),(139,'ELKINGTON','Gordon','Animal Justice Party','NSW'),(140,'RICHARDS','Sarah','Liberal','NSW'),(141,'FITZGERALD','Ross','Australian Sex Party','NSW'),(142,'THOMAS','Allan','Jacqui Lambie Network','NSW'),(143,'BRYANT','Gareth','The Greens','NSW'),(144,'CHAPMAN','Nick','Independent','NSW'),(145,'OLBOURNE','Jason Mark','Marijuana (HEMP) Party','NSW'),(146,'COOPER','John','Independent','NSW'),(147,'THORPE','Ray','Drug Law Reform','NSW'),(148,'CRUZE','Maree Ann','Antipaedophile Party','NSW'),(149,'KATELARIS','Andrew John','Marijuana (HEMP) Party','NSW'),(150,'PAFF','Leanne','Health Australia Party','NSW'),(151,'DONAYRE','Christine','The Greens','NSW'),(152,'RAHME','Peter','Christian Democratic Party (Fred Nile Group)','NSW'),(153,'BRYCE','Ian Robert','Secular Party of Australia','NSW'),(154,'DOWSON','Stacey','Drug Law Reform','NSW'),(155,'MUNDAY','Liam','Independent','NSW'),(156,'WALLACE','Peter','Independent','NSW'),(157,'BENNETT','Colin','','NSW'),(158,'COSTELLO','Alexandra','Labor','NSW'),(159,'LEVINY','Fiona','The Nationals','NSW'),(160,'McCAFFREY','Simon','Family First','NSW'),(161,'OK','Sang','Liberal','NSW'),(162,'WRIGHT','James','Independent','NSW'),(163,'RIZVI','Miriam','Labor','NSW'),(164,'KENNARD','Sam','Liberal Democrats','NSW'),(165,'BUCKMAN','Christopher','CountryMinded','NSW'),(166,'SINODINOS','Arthur','Liberal','NSW'),(167,'PARKER','Kate','The Greens','NSW'),(168,'ASH','David','Independent','NSW'),(169,'VINCENT','Dave','Christian Democratic Party (Fred Nile Group)','NSW'),(170,'GLEDHILL','Nicholas','The Arts Party','NSW'),(171,'O\'NEILL','Deborah','Labor','NSW'),(172,'MACKIN','Dean','Pauline Hanson\'s One Nation','NSW'),(173,'PIPER','Tania Stephanie','Christian Democratic Party (Fred Nile Group)','NSW'),(174,'CONNARD','Michael','The Greens','NT'),(175,'HONAN','Pat','Australian Labor Party (Northern Territory) Branch','NT'),(176,'RYAN','Maurie Japarta','Independent','NT'),(177,'ORDISH','Carol','Christian Democratic Party (Fred Nile Group)','NT'),(178,'JONES','Timothy','Australian Sex Party','NT'),(179,'MARSHALL','Tristan','Online Direct Democracy - (Empowering the People!)','NT'),(180,'CAMPBELL','Trudy','Citizens Electoral Council','NT'),(181,'ORDISH','John','Christian Democratic Party (Fred Nile Group)','NT'),(182,'BANNISTER','Kathy','The Greens','NT'),(183,'BARRY','Ian','Citizens Electoral Council','NT'),(184,'LEE','TS','Independent','NT'),(185,'SCULLION','Nigel','Country Liberals (NT)','NT'),(186,'MacDONALD','Marney','Antipaedophile Party','NT'),(187,'STRETTLES','Greg','Independent','NT'),(188,'GIMINI','Jimmy','Rise Up Australia Party','NT'),(189,'LILLIS','Jenni','Country Liberals (NT)','NT'),(190,'McCARTHY','Malarndirri','Australian Labor Party (Northern Territory) Branch','NT'),(191,'PILE','Jan','Rise Up Australia Party','NT'),(192,'KAVASILAS','Andrew','Marijuana (HEMP) Party','NT'),(193,'STEVENS','Ken','Australian Progressives','QLD'),(194,'DAVEY','Jeremy','Veterans Party','QLD'),(195,'THOMPSON','Cheryl','Australian Labor Party','QLD'),(196,'REDDY','Shyamal','Independent','QLD'),(197,'CAMERON','Belinda','Mature Australia','QLD'),(198,'BARTLETT','Andrew','The Greens','QLD'),(199,'BOYD','Julie','Independent','QLD'),(200,'DOBSON','Chelle','Australian Liberty Alliance','QLD'),(201,'O\'SULLIVAN','Barry','Liberal National Party of Queensland','QLD'),(202,'MOYLAN','James','Renewable Energy Party','QLD'),(203,'LYNCH','Deb','Drug Law Reform','QLD'),(204,'QUIRK','Elena','The Greens','QLD'),(205,'PUKALLUS','Jan','Citizens Electoral Council','QLD'),(206,'GRANT','Suzanne','Nick Xenophon Team','QLD'),(207,'HANNA-McGUFFIE','Leeanne','Independent','QLD'),(208,'HANSON','Pauline','Pauline Hanson\'s One Nation','QLD'),(209,'GOLDEN','Sarinah','Health Australia Party','QLD'),(210,'HEAD','Mike','Socialist Equality Party','QLD'),(211,'FAINGES','Neil','The Arts Party','QLD'),(212,'WATT','Murray','Australian Labor Party','QLD'),(213,'MAJOOR','Lucius','Democratic Labour Party (DLP)','QLD'),(214,'BEVAN','Paul','Animal Justice Party','QLD'),(215,'ROOTH','John','Liberal Democrats','QLD'),(216,'MARRIAGE','Belinda','Independent','QLD'),(217,'JANKOWSKI','Frances','The Arts Party','QLD'),(218,'GUNDRUM','MaryBeth','Renewable Energy Party','QLD'),(219,'LINDGREN','Joanna','Liberal National Party of Queensland','QLD'),(220,'KENNEDY','Kirsten','The Greens','QLD'),(221,'PECKETT','Crystal','Jacqui Lambie Network','QLD'),(222,'KLOOT','Johanna','The Greens','QLD'),(223,'RADIC','Peter Joseph','Online Direct Democracy - (Empowering the People!)','QLD'),(224,'SOUTHWARD','Marnie','Marriage Equality','QLD'),(225,'HORAN','Kate','Family First','QLD'),(226,'NOBLE','Louise','The Greens','QLD'),(227,'ROBERTS','Malcolm','Pauline Hanson\'s One Nation','QLD'),(228,'SELIC','Brandon','Pirate Party Australia','QLD'),(229,'VINCENT','Sheila','Democratic Labour Party (DLP)','QLD'),(230,'SALTMARSH','Marcus','Jacqui Lambie Network','QLD'),(231,'BRICE','Malcolm','Australian Christians','QLD'),(232,'McDONALD','James','Palmer United Party','QLD'),(233,'WALTERS','Kerrod','Glenn Lazarus Team','QLD'),(234,'WATSON','Zade','Animal Justice Party','QLD'),(235,'GIBSON','John','Independent','QLD'),(236,'SAVAGE','Jim','Independent','QLD'),(237,'RENNICK','Gerard','Liberal National Party of Queensland','QLD'),(238,'McGARVIE','Rod','Family First','QLD'),(239,'CASEY','Jane','Australian Labor Party','QLD'),(240,'PELLOWE','David','Family First','QLD'),(241,'MORAN','Matt','Sustainable Australia','QLD'),(242,'McMAHON','Greg','Independent','QLD'),(243,'LEO','Janina','The Greens','QLD'),(244,'RIVAS','Sal','','QLD'),(245,'MARRIOTT','Joy','Katter\'s Australian Party','QLD'),(246,'TAYLOR','Shea','Australian Christians','QLD'),(247,'BUNDY','David','Independent','QLD'),(248,'CANAVAN','Matthew','Liberal National Party of Queensland','QLD'),(249,'EUGARDE','Ian','Independent','QLD'),(250,'ANDERSON','Fiona','The Greens','QLD'),(251,'CHISHOLM','Anthony','Australian Labor Party','QLD'),(252,'BAYNES','Sue','Family First','QLD'),(253,'HANBIDGE','Karin','Derryn Hinch\'s Justice Party','QLD'),(254,'STIVANO','Sherrill','CountryMinded','QLD'),(255,'MAILLER','Pete','CountryMinded','QLD'),(256,'ANDERSON','Marshal','Independent','QLD'),(257,'TAYLOR','Paul','Rise Up Australia Party','QLD'),(258,'COOKE','Erin','Socialist Equality Party','QLD'),(259,'HARDING','Stephen','Citizens Electoral Council','QLD'),(260,'MOONEY','Neroli','Rise Up Australia Party','QLD'),(261,'HODKINSON','Darryl','Veterans Party','QLD'),(262,'WATERS','Larissa','The Greens','QLD'),(263,'FLOWERS','Reece','VOTEFLUX.ORG | Upgrade Democracy!','QLD'),(264,'MACDONALD','Ian','Liberal National Party of Queensland','QLD'),(265,'MISSINGHAM','David','Online Direct Democracy - (Empowering the People!)','QLD'),(266,'ANNING','Fraser','Pauline Hanson\'s One Nation','QLD'),(267,'MORAN','William','Marriage Equality','QLD'),(268,'POTTER','Josephine','Independent','QLD'),(269,'McCORMACK','Jo','Australian Progressives','QLD'),(270,'VUGA','Kim','Independent','QLD'),(271,'WALTON','Rowell','Katter\'s Australian Party','QLD'),(272,'McGRATH','James','Liberal National Party of Queensland','QLD'),(273,'PATTEN','Kirsty','Australian Sex Party','QLD'),(274,'COTTER','Deb','Derryn Hinch\'s Justice Party','QLD'),(275,'PENNINGS','Ben','The Greens','QLD'),(276,'BUCKLEY','Gabe','Liberal Democrats','QLD'),(277,'TURNER','Michael','Shooters, Fishers and Farmers','QLD'),(278,'SMITH','Lorraine','Drug Law Reform','QLD'),(279,'ROLES','John','Sustainable Australia','QLD'),(280,'BEATTIE','Greg','Independent','QLD'),(281,'COX','Chris','Australian Cyclists Party','QLD'),(282,'SNELL','Terry','Mature Australia','QLD'),(283,'GAYNOR','Bernard William','Australian Liberty Alliance','QLD'),(284,'CROW','Daniel','Nick Xenophon Team','QLD'),(285,'GARDNER','Mark','VOTEFLUX.ORG | Upgrade Democracy!','QLD'),(286,'BRANDIS','George','Liberal National Party of Queensland','QLD'),(287,'PURSEHOUSE','Isaac','Pirate Party Australia','QLD'),(288,'SWEERIS-SIGRIST','Ludy Charles','Christian Democratic Party (Fred Nile Group)','QLD'),(289,'WORRINGHAM','Charles','The Greens','QLD'),(290,'KETTER','Chris','Australian Labor Party','QLD'),(291,'WOODFORTH','Jason','Health Australia Party','QLD'),(292,'MOORE','Tony R.','Independent','QLD'),(293,'LAZARUS','Glenn','Glenn Lazarus Team','QLD'),(294,'GUNNIS','Craig','Palmer United Party','QLD'),(295,'ANDERSON','Meg','The Greens','QLD'),(296,'HOWES','Therese','Marijuana (HEMP) Party','QLD'),(297,'CLARK','Scott','Secular Party of Australia','QLD'),(298,'MOORE','Claire','Australian Labor Party','QLD'),(299,'HARRIS','Zoemaree','Independent','QLD'),(300,'GEE','Michael Anthony','Shooters, Fishers and Farmers','QLD'),(301,'BRISTOW','Robin','Australian Sex Party','QLD'),(302,'RYAN','Dan','Liberal National Party of Queensland','QLD'),(303,'BELL','Trevor','Secular Party of Australia','QLD'),(304,'BIGGS','Alan','Australian Liberty Alliance','QLD'),(305,'KAFF','Michael','Independent','QLD'),(306,'RE','Edward','Australian Cyclists Party','QLD'),(307,'STEVENSON','Paul Joseph','Independent','QLD'),(308,'SOLOMON','Wayne','Christian Democratic Party (Fred Nile Group)','QLD'),(309,'LOURIGAN','Annette','Glenn Lazarus Team','QLD'),(310,'PEAD','Gary James','Independent','QLD'),(311,'JORGENSEN','Terry','Independent','QLD'),(312,'TANGUILIG','Val','','QLD'),(313,'SMITH','Judy','Pauline Hanson\'s One Nation','QLD'),(314,'SKINNER','Rainee','The Greens','QLD'),(315,'BIRMINGHAM','Simon','Liberal','SA'),(316,'HAHN','John','Shooters, Fishers and Farmers','SA'),(317,'PAZESKI-NIKOLOSKI','Sasha','Australian Progressives','SA'),(318,'BUCKLEY','Kym','Voluntary Euthanasia Party','SA'),(319,'FILINGERI','Carlo','Palmer United Party','SA'),(320,'PRIDDEY','Jaz','Australian Progressives','SA'),(321,'BERNARDI','Cory','Liberal','SA'),(322,'GICHUHI','Lucy','Family First','SA'),(323,'KAKOSCHKE-MOORE','Skye','Nick Xenophon Team','SA'),(324,'STORER','Tim','Nick Xenophon Team','SA'),(325,'CARTER','Nick','Shooters, Fishers and Farmers','SA'),(326,'BOTHE','Darryl','Mature Australia','SA'),(327,'TUAZON-McCHEYNE','Adrian','Marriage Equality','SA'),(328,'EDWARDS','Sean','Liberal','SA'),(329,'KUERSCHNER','Judith','Australian Motoring Enthusiast Party','SA'),(330,'McEWEN','Anne','Australian Labor Party','SA'),(331,'WONG','Penny','Australian Labor Party','SA'),(332,'NOBLE','Tania','Animal Justice Party','SA'),(333,'SIMMS','Robert','The Greens','SA'),(334,'PARKER','Ryan Douglas','Marijuana (HEMP) Party','SA'),(335,'HORWOOD','Andrew','Australian Liberty Alliance','SA'),(336,'DAY','Bob','Family First','SA'),(337,'GREEN','Nathan','Australian Motoring Enthusiast Party','SA'),(338,'DAVEY','Malcolm Lloyd','Independent','SA'),(339,'MARSH','Wanda Lee','Australian Liberty Alliance','SA'),(340,'BAKER','Jeff','VOTEFLUX.ORG | Upgrade Democracy!','SA'),(341,'BURGESS','Steven David','Pauline Hanson\'s One Nation','SA'),(342,'HARKER-SMITH','Angus','Australian Cyclists Party','SA'),(343,'REES','Kristian','Palmer United Party','SA'),(344,'XENOPHON','Nick','Nick Xenophon Team','SA'),(345,'SADRI','Roostam','Liberal Democrats','SA'),(346,'WATERS','Ron','Antipaedophile Party','SA'),(347,'KNIGHT','Jessica','Voluntary Euthanasia Party','SA'),(348,'KOZLOW','Alex','Citizens Electoral Council','SA'),(349,'THOMAS','Colin','Derryn Hinch\'s Justice Party','SA'),(350,'RICHARDS','Adam','Independent','SA'),(351,'GALLACHER','Alex','Australian Labor Party','SA'),(352,'DE KOK','Harriet','The Greens','SA'),(353,'MOATE','Jody','The Greens','SA'),(354,'BREAGAN','Emma','Animal Justice Party','SA'),(355,'BILSON-THOMPSON','Sundance','Australian Cyclists Party','SA'),(356,'LIDDLE','Kerrynne','Liberal','SA'),(357,'COCHRANE','Christopher Mark','Independent','SA'),(358,'SADDLER','Dave','Independent','SA'),(359,'DENNY','Lyndal','Mature Australia','SA'),(360,'GRIFF','Stirling','Nick Xenophon Team','SA'),(361,'NICOLIS','Angelina','Pauline Hanson\'s One Nation','SA'),(362,'BOND','Alex','Marriage Equality','SA'),(363,'FAWCETT','David','Liberal','SA'),(364,'HANSON-YOUNG','Sarah','The Greens','SA'),(365,'ATTIA','Matt','Christian Democratic Party (Fred Nile Group)','SA'),(366,'SAUNDERS','Margaret','Australian Sex Party','SA'),(367,'GALLACHER','Bronwyn','Australian Labor Party','SA'),(368,'CRAWFORD','Terence Michael','The Arts Party','SA'),(369,'SIEBERT','Paul','Citizens Electoral Council','SA'),(370,'RUSTON','Anne','Liberal','SA'),(371,'GROSSER','Lynn-Marie','Derryn Hinch\'s Justice Party','SA'),(372,'FARRELL','Don','Australian Labor Party','SA'),(373,'STEPHEN','Joseph Kelton','Christian Democratic Party (Fred Nile Group)','SA'),(374,'BIRD','Adam Anthony','VOTEFLUX.ORG | Upgrade Democracy!','SA'),(375,'ALI','Mohammad','Independent','SA'),(376,'ALLISON','Michael','Australian Labor Party','SA'),(377,'SANDERS','Charles Andrew Laurence','The Arts Party','SA'),(378,'NOACK','Michael','Liberal Democrats','SA'),(379,'Surname','GivenName','PartyName','State'),(380,'BROWN','Carol','Australian Labor Party','TAS'),(381,'O\'HARA','Scott','The Arts Party','TAS'),(382,'DUNIAM','Jonathon','Liberal','TAS'),(383,'KAYE','Max','VOTEFLUX.ORG | Upgrade Democracy!','TAS'),(384,'MARSKELL','Kaye','Independent','TAS'),(385,'COHEN','Nicky','Nick Xenophon Team','TAS'),(386,'ROBERTS','Andrew','Family First','TAS'),(387,'SHORT','John','Australian Labor Party','TAS'),(388,'THORNTON','Meg','Citizens Electoral Council','TAS'),(389,'CASS','Suzanne','Derryn Hinch\'s Justice Party','TAS'),(390,'LAMBIE','Jacqui','Jacqui Lambie Network','TAS'),(391,'KUCINA','Steve','Citizens Electoral Council','TAS'),(392,'ALLEN','Matthew','Shooters, Fishers and Farmers','TAS'),(393,'POLLEY','Helen','Australian Labor Party','TAS'),(394,'MORGAN','Kevin','Palmer United Party','TAS'),(395,'HORWOOD','Susan','Australian Liberty Alliance','TAS'),(396,'McCULLOCH','Kate','Pauline Hanson\'s One Nation','TAS'),(397,'WHISH-WILSON','Peter','The Greens','TAS'),(398,'BAKER','Daniel','Derryn Hinch\'s Justice Party','TAS'),(399,'ALSTON','Ian','Liberal Democrats','TAS'),(400,'COLBECK','Richard','Liberal','TAS'),(401,'STRINGER','Justin Leigh','Palmer United Party','TAS'),(402,'TUCKER','John','Liberal','TAS'),(403,'MANSON','Rob','Renewable Energy Party','TAS'),(404,'BUSHBY','David','Liberal','TAS'),(405,'GORA','Mishka','Christian Democratic Party (Fred Nile Group)','TAS'),(406,'ABETZ','Eric','Liberal','TAS'),(407,'McKIM','Nick','The Greens','TAS'),(408,'URQUHART','Anne','Australian Labor Party','TAS'),(409,'CHOI','Jin-oh','Science Party','TAS'),(410,'POULTON','Adam','VOTEFLUX.ORG | Upgrade Democracy!','TAS'),(411,'VON STIEGLITZ','Quentin','Palmer United Party','TAS'),(412,'ROBINSON','Tony','Australian Liberty Alliance','TAS'),(413,'MEAD','Clinton','Liberal Democrats','TAS'),(414,'BILYK','Catryna','Australian Labor Party','TAS'),(415,'BAKER','Alison','Animal Justice Party','TAS'),(416,'MADDEN','Peter','Family First','TAS'),(417,'JOYCE','Sharon','Renewable Energy Party','TAS'),(418,'WATERMAN','Rob','Jacqui Lambie Network','TAS'),(419,'PARRY','Stephen','Liberal','TAS'),(420,'VOLTA','JoAnne','The Arts Party','TAS'),(421,'CRAWFORD','David','Antipaedophile Party','TAS'),(422,'MIDSON','Ricky','Shooters, Fishers and Farmers','TAS'),(423,'NERO-NILE','Silvana','Christian Democratic Party (Fred Nile Group)','TAS'),(424,'WILLINK','Hans','Science Party','TAS'),(425,'TEMBY','Richard','Mature Australia','TAS'),(426,'MARTIN','Steve','Jacqui Lambie Network','TAS'),(427,'REYNOLDS','Anna','The Greens','TAS'),(428,'COLLINS','Francesca','Australian Sex Party','TAS'),(429,'MANZI','Natasia','Pauline Hanson\'s One Nation','TAS'),(430,'HARKINS','Kevin','Australian Recreational Fishers Party','TAS'),(431,'LANE','George','Independent','TAS'),(432,'RUSSELL','Grant','Independent','TAS'),(433,'SINGH','Lisa','Australian Labor Party','TAS'),(434,'EVANS','Carmen','Australian Recreational Fishers Party','TAS'),(435,'BEVIS','Karen','Animal Justice Party','TAS'),(436,'HOULT','Michelle','Nick Xenophon Team','TAS'),(437,'OWEN','Matt','Marijuana (HEMP) Party','TAS'),(438,'GREEN','Randell','Family First Party','VIC'),(439,'RYAN','Chris','Independent','VIC'),(440,'NYE','Trevor William','Independent','VIC'),(441,'JONES','Miranda','Voluntary Euthanasia Party','VIC'),(442,'SHMUEL','Immanuel','Independent','VIC'),(443,'KERR','Garry','Australian Country Party','VIC'),(444,'PATERSON','James','Liberal','VIC'),(445,'BOTROS','Stephanie','Christian Democratic Party (Fred Nile Group)','VIC'),(446,'LUTZ','Geoff','Independent','VIC'),(447,'FIFIELD','Mitch','Liberal','VIC'),(448,'TRELOAR','Rebecca','The Nationals','VIC'),(449,'SEARLE','James','The Greens','VIC'),(450,'OKUMU','Anne','Australian Christians','VIC'),(451,'MINIFIE','Tasma','The Greens','VIC'),(452,'POON','Bruce','Animal Justice Party','VIC'),(453,'KARAGIANNIDIS','John','Independent','VIC'),(454,'LARKIN','Phil','Australian Country Party','VIC'),(455,'NICHOLLS','Kenneth','Australian Liberty Alliance','VIC'),(456,'LEHRER','Danielle','VOTEFLUX.ORG | Upgrade Democracy!','VIC'),(457,'MULL','Allan','Independent','VIC'),(458,'CAMERON','Ian John','Pauline Hanson\'s One Nation','VIC'),(459,'FREEMAN','Michael','DLP Democratic Labour','VIC'),(460,'HUME','Jane','Liberal','VIC'),(461,'DOLAN','Hugh','Jacqui Lambie Network','VIC'),(462,'HINCH','Derryn','Derryn Hinch\'s Justice Party','VIC'),(463,'CARR','Kim','Australian Labor Party','VIC'),(464,'HENSON','Jamie Christopher','The Arts Party','VIC'),(465,'TIMSON','Matt','Jacqui Lambie Network','VIC'),(466,'MILNE','Stuart James','VOTEFLUX.ORG | Upgrade Democracy!','VIC'),(467,'SHERMAN','John','Drug Law Reform','VIC'),(468,'MARSHALL','Gavin','Australian Labor Party','VIC'),(469,'ASKEY','Graham','Renewable Energy Party','VIC'),(470,'MULCAHY','Amy','Australian Sex Party','VIC'),(471,'HAWKS','Peter John','Independent','VIC'),(472,'KNIGHT','David','Australian Progressives','VIC'),(473,'ARAPOGLOU','Eleni','Australian Christians','VIC'),(474,'CRESTANI','Rosalie','Rise Up Australia Party','VIC'),(475,'CHIPP','Greg','Drug Law Reform','VIC'),(476,'GRIMLEY','Stuart','Derryn Hinch\'s Justice Party','VIC'),(477,'BAIN','Peter Timothy','Family First Party','VIC'),(478,'LIMBRICK','David','Liberal Democrats','VIC'),(479,'SPENDER','Duncan','Liberal Democrats','VIC'),(480,'McKENZIE','Bridget','The Nationals','VIC'),(481,'PEUT','Gabrielle','Citizens Electoral Council','VIC'),(482,'KENT','Steve','Australian Labor Party','VIC'),(483,'GODDE','Rose','The Arts Party','VIC'),(484,'BYRNE','Peter','Socialist Equality Party','VIC'),(485,'NICHOLLS','Georgia','Sustainable Australia','VIC'),(486,'ANDREW','Maureen J','The Arts Party','VIC'),(487,'GOLDEN','Isaac','Health Australia Party','VIC'),(488,'ARMSTRONG','Steven','Sustainable Australia','VIC'),(489,'MAGUIRE-ROSIER','Josephine','The Greens','VIC'),(490,'DOIG','Meredith','Australian Sex Party','VIC'),(491,'MACKLEY','Aaron','Australian Motoring Enthusiast Party','VIC'),(492,'HANNA','May','Christian Democratic Party (Fred Nile Group)','VIC'),(493,'LEE','Justin','Nick Xenophon Team','VIC'),(494,'GILMORE','Josh','Australian Progressives','VIC'),(495,'THOOLEN','Catriona Cecilia','Palmer United Party','VIC'),(496,'SCANLON','David James','Voluntary Euthanasia Party','VIC'),(497,'VEREKER','Stephen','DLP Democratic Labour','VIC'),(498,'ARASU','Karthik','Independent','VIC'),(499,'NALLIAH','Daniel','Rise Up Australia Party','VIC'),(500,'COLLYER','David','','VIC'),(501,'COLEMAN','Misha','The Greens','VIC'),(502,'KLEIN','Elise','The Greens','VIC'),(503,'CONROY','Stephen Michael','Australian Labor Party','VIC'),(504,'TOMLINS','Jacqueline','Marriage Equality','VIC'),(505,'JANSON','Vickie','Australian Christians','VIC'),(506,'BREAKWELL','Kathryn','Health Australia Party','VIC'),(507,'EDGECOMBE','Jacqueline','Animal Justice Party','VIC'),(508,'BURLEIGH','Richard','Pirate Party','VIC'),(509,'RICE','Janet','The Greens','VIC'),(510,'SIMPSON','Lachlan','Pirate Party','VIC'),(511,'READ','Rose','The Greens','VIC'),(512,'ISHERWOOD','Craig','Citizens Electoral Council','VIC'),(513,'CHELLIAH','Lalitha','Socialist Alliance','VIC'),(514,'MANNERS','Craig','Family First Party','VIC'),(515,'OKOTEL','Karina','Liberal','VIC'),(516,'MITCHELL-COOK','Wanda','','VIC'),(517,'TUAZON-McCHEYNE','Jason','Marriage Equality','VIC'),(518,'GOODEN','Tim','Socialist Alliance','VIC'),(519,'SPASOJEVIC','Dana','Independent','VIC'),(520,'ALDEN','Jennifer','The Greens','VIC'),(521,'PERSSE','Louise','Australian Labor Party','VIC'),(522,'McCARTHY','Graham','Mature Australia','VIC'),(523,'WILSON','Jake','Shooters, Fishers and Farmers','VIC'),(524,'MADIGAN','John','MFP','VIC'),(525,'FLOYD','Glenn','Independent','VIC'),(526,'COLLINS','Jacinta','Australian Labor Party','VIC'),(527,'CONSTANTINOU','Ethan','Shooters, Fishers and Farmers','VIC'),(528,'RYAN','Scott','Liberal','VIC'),(529,'SEKHON','Gurm','The Greens','VIC'),(530,'JONES','Daniel','Australian Liberty Alliance','VIC'),(531,'ROYLANCE','Simon Peter','Pauline Hanson\'s One Nation','VIC'),(532,'CAMERON','Judy','The Greens','VIC'),(533,'TARCZON','Les','Australian Labor Party','VIC'),(534,'MUIR','Ricky','Australian Motoring Enthusiast Party','VIC'),(535,'VADARLIS','Eric','Independent','VIC'),(536,'RIDGE','Roy','Mature Australia','VIC'),(537,'CRABB','Anna','The Greens','VIC'),(538,'DOW','Nik','Australian Cyclists Party','VIC'),(539,'JUHASZ','Stephen','Independent','VIC'),(540,'GEORGE','Mark','MFP','VIC'),(541,'DICKENSON','Mark Francis','Independent','VIC'),(542,'HALPERN','Naomi','Nick Xenophon Team','VIC'),(543,'BESLIS','Christopher','Independent','VIC'),(544,'URIE','Meredith','Independent','VIC'),(545,'CARR','Alice','Secular Party of Australia','VIC'),(546,'WILSON','Gray','Renewable Energy Party','VIC'),(547,'YANG','Chien-Hui','Australian Labor Party','VIC'),(548,'JAMES','Luke','Science Party','VIC'),(549,'SINNEMA','Chris','Socialist Equality Party','VIC'),(550,'PERKINS','John','Secular Party of Australia','VIC'),(551,'HALL','Dennis','Independent','VIC'),(552,'DI NATALE','Richard','The Greens','VIC'),(553,'HICKEY','Cameron','Palmer United Party','VIC'),(554,'BOWERS','Susan','Australian Labor Party','WA'),(555,'BALDOCK','Michael','The Greens (WA)','WA'),(556,'BURATTI','Robert','The Arts Party','WA'),(557,'STERLE','Glenn','Australian Labor Party','WA'),(558,'JENKINSON','Samantha','The Greens (WA)','WA'),(559,'ROBINSON','Jean','Citizens Electoral Council','WA'),(560,'SUTTON','Alicia','Animal Justice Party','WA'),(561,'SKERRITT','Andrew','Shooters, Fishers and Farmers','WA'),(562,'MATHESON','Julie','Independent','WA'),(563,'HARDWICK','Anthony','Rise Up Australia Party','WA'),(564,'BOLTON','Luke','Nick Xenophon Team','WA'),(565,'McREA','Brian','Australia First Party','WA'),(566,'JONES','Kai','Independent','WA'),(567,'BRADSHAW','Patti','Mature Australia','WA'),(568,'PAULL','Stuey','','WA'),(569,'HOWARD','Christopher John','Australian Cyclists Party','WA'),(570,'BOVE','Fernando','Democratic Labour Party (DLP)','WA'),(571,'STEELE-JOHN','Jordon','The Greens (WA)','WA'),(572,'HIGGINS','Rachael','Derryn Hinch\'s Justice Party','WA'),(573,'EMANUEL','Kamala','Socialist Alliance','WA'),(574,'BOVELL','Michael','Nick Xenophon Team','WA'),(575,'ROBINSON','Debbie','Australian Liberty Alliance','WA'),(576,'SUDHOLZ','Judy','Citizens Electoral Council','WA'),(577,'YOUNG','Jacky','Australian Christians','WA'),(578,'CASH','Michaelia','Liberal','WA'),(579,'MAH','Peter','Australian Cyclists Party','WA'),(580,'IMISIDES','Mark David','Christian Democratic Party (Fred Nile Group)','WA'),(581,'MORRIS','Gary J','','WA'),(582,'WHITTLE','Connor','Liberal Democrats','WA'),(583,'SUNDBLADH','Camilla','Renewable Energy Party','WA'),(584,'HURLEY','James','Australian Sex Party','WA'),(585,'MOODY','Tammara','Australian Antipaedophile Party','WA'),(586,'CONNOLLY','Mark','VOTEFLUX.ORG | Upgrade Democracy!','WA'),(587,'CULLETON','Rodney Norman','Pauline Hanson\'s One Nation','WA'),(588,'RE','Elizabeth','The Nationals','WA'),(589,'ROSE','Linda','Family First Party','WA'),(590,'BALDERSTONE','Michael','Marijuana (HEMP) Party','WA'),(591,'BACK','Chris','Liberal','WA'),(592,'IQBAL','Farida','Socialist Alliance','WA'),(593,'DOHERTY','Seamus','Socialist Alliance','WA'),(594,'GEORGIOU','Peter','Pauline Hanson\'s One Nation','WA'),(595,'HENG','Henry','Family First Party','WA'),(596,'TILBURY','Samantha','Health Australia Party','WA'),(597,'DONALD','Stuart','Mature Australia','WA'),(598,'REED','Mark','Australian Labor Party','WA'),(599,'TAYLOR','Robert Kenneth Leslie','The Arts Party','WA'),(600,'SIEWERT','Rachel','The Greens (WA)','WA'),(601,'FARDELL','Nick','The Nationals','WA'),(602,'ONORATO','Mia','Australian Labor Party','WA'),(603,'FARGHER','Sara','Health Australia Party','WA'),(604,'WILLIAMSON','Ross','Shooters, Fishers and Farmers','WA'),(605,'LOVE','Katrina','Animal Justice Party','WA'),(606,'HIDE','Nicki','Derryn Hinch\'s Justice Party','WA'),(607,'REYNOLDS','Linda','Liberal','WA'),(608,'SCHWINDT','Pedro','Renewable Energy Party','WA'),(609,'KLASS','Graeme Michael','Liberal Democrats','WA'),(610,'ISMAIL','Rai','The Greens (WA)','WA'),(611,'RAMSAY','Norm','Independent','WA'),(612,'HERCOCK','Marion','Australian Liberty Alliance','WA'),(613,'THOMAS','Richard','VOTEFLUX.ORG | Upgrade Democracy!','WA'),(614,'INGRAM','Sheridan','Liberal','WA'),(615,'VICKERY','Lyn','Australia First Party','WA'),(616,'CASTIEAU','Peter','Independent','WA'),(617,'HODDINOTT','Susan','Katter\'s Australian Party','WA'),(618,'CORMANN','Mathias','Liberal','WA'),(619,'MUNDY','Sheila','Rise Up Australia Party','WA'),(620,'WANG','Zhenya Dio','Palmer United Party','WA'),(621,'CAMERON','Lindsay','Australian Christians','WA'),(622,'READ','Philip Campbell','Christian Democratic Party (Fred Nile Group)','WA'),(623,'KIERNAN','Troy','Democratic Labour Party (DLP)','WA'),(624,'PRATT','Louise','Australian Labor Party','WA'),(625,'JOHNSTON','David','Liberal','WA'),(626,'LUDLAM','Scott','The Greens (WA)','WA'),(627,'MUIR','Kado','The Nationals','WA'),(628,'SMITH','Dean','Liberal','WA'),(629,'KRUGER','Jacque','Palmer United Party','WA'),(630,'LINES','Sue','Australian Labor Party','WA'),(631,'DODSON','Patrick','Australian Labor Party','WA'),(632,'CULLETON','Ioanna','Pauline Hanson\'s One Nation','WA');
/*!40000 ALTER TABLE `candidate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delegate`
--

DROP TABLE IF EXISTS `delegate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delegate` (
  `delegate_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `delegate_name` varchar(100) NOT NULL,
  `delegate_pwd` varchar(40) NOT NULL,
  PRIMARY KEY (`delegate_id`),
  UNIQUE KEY `delegate_name` (`delegate_name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delegate`
--

LOCK TABLES `delegate` WRITE;
/*!40000 ALTER TABLE `delegate` DISABLE KEYS */;
INSERT INTO `delegate` VALUES (1,'Dumbledore','e8c8007c7371ed1d664e3b6c218f199b'),(2,'McGonagall','06b8813251876b73ce1a3c58a57a4550');
/*!40000 ALTER TABLE `delegate` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-03 18:03:42