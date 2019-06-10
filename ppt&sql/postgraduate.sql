/*
SQLyog Community v13.1.2 (64 bit)
MySQL - 8.0.13 : Database - kaoyan
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`kaoyan` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;

USE `kaoyan`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `account` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `power` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=720 DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`id`,`account`,`password`,`power`) values 
(18,'root','admin','最高管理员'),
(21,'james','james','爬虫管理员'),
(22,'admin','admin','推送管理员'),
(715,'curry','curry','数据管理员');

/*Table structure for table `favorite` */

DROP TABLE IF EXISTS `favorite`;

CREATE TABLE `favorite` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `userid` int(20) NOT NULL,
  `pageid` int(20) NOT NULL,
  `title` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Frikey` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `favorite` */

/*Table structure for table `page` */

DROP TABLE IF EXISTS `page`;

CREATE TABLE `page` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `link` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `star` int(20) NOT NULL,
  `view` int(20) NOT NULL,
  `source` varchar(20) NOT NULL,
  `content` longtext NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=610 DEFAULT CHARSET=utf8;

/*Data for the table `page` */

/*Table structure for table `push` */

DROP TABLE IF EXISTS `push`;

CREATE TABLE `push` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `pid` int(20) NOT NULL,
  `type` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8;

/*Data for the table `push` */

insert  into `push`(`id`,`pid`,`type`) values 
(24,168,'考研工具'),
(25,169,'推荐免试'),
(26,247,'推荐免试'),
(27,302,'推荐免试'),
(28,313,'推荐免试'),
(30,172,'考研简章'),
(31,243,'考研简章'),
(33,266,'考研简章'),
(34,330,'考研简章'),
(35,336,'考研简章'),
(41,257,'考研简章'),
(46,485,'考研日程'),
(47,480,'考研热点'),
(48,162,'考研动态'),
(49,176,'考研动态'),
(50,192,'考研动态'),
(51,284,'考研政策'),
(52,190,'考研政策'),
(53,192,'考研政策'),
(54,175,'考研动态'),
(55,288,'考研动态'),
(56,486,'备考指南'),
(58,477,'考研热点'),
(59,355,'新闻资讯'),
(60,450,'备考指南'),
(61,510,'新闻资讯'),
(62,509,'学校选择'),
(63,505,'学校选择'),
(65,541,'推荐免试'),
(66,545,'考研资料'),
(67,521,'考研资料'),
(68,525,'推荐免试'),
(69,164,'考研动态'),
(70,160,'学校选择'),
(71,606,'考研简章'),
(73,316,'推荐免试'),
(74,321,'学校选择'),
(75,316,'考研日程'),
(76,356,'考研日程'),
(77,595,'考研日程'),
(78,360,'考研热点'),
(79,318,'推荐免试'),
(80,473,'考研热点'),
(81,473,'考研热点'),
(82,607,'学校选择');

/*Table structure for table `reviews` */

DROP TABLE IF EXISTS `reviews`;

CREATE TABLE `reviews` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `userid` int(20) NOT NULL,
  `pageid` int(20) NOT NULL,
  `content` text NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=142 DEFAULT CHARSET=utf8;

/*Data for the table `reviews` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `account` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `birthday` date NOT NULL,
  `nickname` varchar(20) NOT NULL,
  `sex` varchar(6) NOT NULL,
  `date` datetime NOT NULL,
  `status` int(1) NOT NULL,
  `image` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
