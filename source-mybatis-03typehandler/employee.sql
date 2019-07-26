/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.6.34 : Database - hymc
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hymc` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `hymc`;

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) DEFAULT NULL,
  `gender` varchar(2) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `hobbys` varchar(200) DEFAULT NULL,
  `createtime` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `employee` */

insert  into `employee`(`id`,`user_name`,`gender`,`email`,`hobbys`,`createtime`) values (1,'zhangsan ','0','zhangsan@163.com','1,2,3,4,5',NULL),(8,'tinaqi','1','tinaqi@163.com',NULL,'1563869915836'),(9,'songba','1','songba@163.com',NULL,'1563871033745'),(10,'yanjiu','1','yanjiu@163.com','yuwen,shuxue,yingyu,zhengzhi','1563951958357');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
