/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 8.0.16 : Database - xinda
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`xinda` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `xinda`;

/*Table structure for table `xd_bought_user` */

DROP TABLE IF EXISTS `xd_bought_user`;

CREATE TABLE `xd_bought_user` (
  `id` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户',
  `user_name` varchar(8) DEFAULT NULL COMMENT '用户名',
  `head_img` varchar(20) DEFAULT NULL COMMENT '头像',
  `sex` char(1) DEFAULT NULL COMMENT '性别',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号',
  `area` varchar(15) DEFAULT NULL COMMENT '所在地',
  `ts` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  `email` varchar(20) DEFAULT NULL COMMENT '邮箱',
  `bought_num` int(5) DEFAULT NULL COMMENT '购买订单数',
  `total` float DEFAULT NULL COMMENT '消费金额',
  `status` varchar(5) DEFAULT NULL COMMENT '登录状态（1已登录、未登录0）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `xd_bought_user` */

/*Table structure for table `xd_order` */

DROP TABLE IF EXISTS `xd_order`;

CREATE TABLE `xd_order` (
  `order_number` varchar(20) DEFAULT NULL COMMENT '订单号',
  `bought_user` varchar(20) DEFAULT NULL COMMENT '购买用户',
  `order_info` varchar(50) DEFAULT NULL COMMENT '订单内容',
  `order_price` float DEFAULT NULL COMMENT '订单金额',
  `order_no` varchar(20) DEFAULT NULL COMMENT '订单编号',
  `ts` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `id` varchar(8) NOT NULL COMMENT '客户',
  `pay` varchar(5) DEFAULT NULL COMMENT '支付方式',
  `status` varchar(5) DEFAULT NULL COMMENT '状态',
  `appraise` varchar(50) DEFAULT NULL COMMENT '评价',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `xd_order` */

insert  into `xd_order`(`order_number`,`bought_user`,`order_info`,`order_price`,`order_no`,`ts`,`id`,`pay`,`status`,`appraise`) values ('17042101','毕小雪','书',20,'1001','2019-10-23 17:35:29','1','1','1','1'),('17042102','车瑞瑶','书',20,'1001','2019-10-29 17:36:29','2','1','1','1'),('17042103','陈梦瑶','书',20,'1001','2019-10-29 17:37:10','3','1','1','1'),('17042104','陈烨','书',20,'1001','2019-10-24 17:37:41','4','1','1','1'),('17042105','程艳玲','书',20,'1002','2019-10-08 17:38:17','5','1','1','1'),('17042106','崔玉瑶','书',20,'1002','2019-09-30 17:39:14','6','1','1','1'),('17042107','杜杰','书',20,'1003','2019-10-16 17:39:42','7','1','1','1'),('17042108','关辉','书',20,'1004','2019-10-15 17:40:13','8','1','1','1');

/*Table structure for table `xd_product` */

DROP TABLE IF EXISTS `xd_product`;

CREATE TABLE `xd_product` (
  `service_product` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '服务产品',
  `product_img` blob COMMENT '服务产品图片',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '服务产品名称',
  `product_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '服务名称',
  `product_instruction` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '服务说明',
  `product_price` varchar(50) DEFAULT NULL COMMENT '服务价格',
  `status` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '服务状态',
  `ts` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `sales_volume` int(5) DEFAULT NULL COMMENT '销量',
  `id` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '服务商',
  `service_name` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '服务商名称',
  `recommend` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '是否推荐',
  `high_quality` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '是否初创必备',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `xd_product` */

insert  into `xd_product`(`service_product`,`product_img`,`username`,`product_name`,`product_instruction`,`product_price`,`status`,`ts`,`sales_volume`,`id`,`service_name`,`recommend`,`high_quality`) values (NULL,NULL,'',NULL,'','',NULL,'2019-11-07 11:43:16',NULL,'',NULL,NULL,NULL),(NULL,NULL,'1','1','1','100',NULL,'2019-10-30 17:10:56',NULL,'1',NULL,NULL,NULL),(NULL,NULL,'10','1','1','100',NULL,'2019-10-30 21:58:47',NULL,'10',NULL,NULL,NULL),(NULL,NULL,'11','2','2','100',NULL,'2019-10-30 21:58:53',NULL,'11',NULL,NULL,NULL),(NULL,NULL,NULL,'111','111','111',NULL,'2019-11-06 17:04:06',NULL,'111',NULL,NULL,NULL),(NULL,NULL,'12','2','2','100',NULL,'2019-10-30 21:58:57',NULL,'12',NULL,NULL,NULL),(NULL,NULL,'13','2','2','100',NULL,'2019-10-30 21:59:02',NULL,'13',NULL,NULL,NULL),(NULL,NULL,'14','2','2','100',NULL,'2019-10-30 21:59:10',NULL,'14',NULL,NULL,NULL),(NULL,NULL,'15','2','2','100',NULL,'2019-10-30 21:59:15',NULL,'15',NULL,NULL,NULL),(NULL,NULL,'16','3','3','100',NULL,'2019-10-30 21:59:21',NULL,'16',NULL,NULL,NULL),(NULL,NULL,'17','3','3','100',NULL,'2019-10-30 21:59:28',NULL,'17',NULL,NULL,NULL),(NULL,NULL,'18','3','3','100',NULL,'2019-10-30 22:17:24',NULL,'18',NULL,NULL,NULL),(NULL,NULL,'2','4','4','100',NULL,'2019-10-30 17:11:01',NULL,'2',NULL,NULL,NULL),(NULL,NULL,'21','4','4',NULL,NULL,'2019-10-31 16:37:59',NULL,'21',NULL,NULL,NULL),(NULL,NULL,'22','4','4',NULL,NULL,'2019-10-31 16:38:01',NULL,'22',NULL,NULL,NULL),(NULL,NULL,NULL,'222','222','222',NULL,'2019-11-06 17:02:19',NULL,'222',NULL,NULL,NULL),(NULL,NULL,'23','4','4',NULL,NULL,'2019-10-31 16:38:10',NULL,'23',NULL,NULL,NULL),(NULL,NULL,'24','4','4',NULL,NULL,'2019-10-31 16:38:18',NULL,'24',NULL,NULL,NULL),(NULL,NULL,'25',NULL,NULL,NULL,NULL,'2019-10-31 16:38:22',NULL,'25',NULL,NULL,NULL),(NULL,NULL,NULL,'333','222','222',NULL,'2019-11-06 16:51:43',NULL,'250',NULL,NULL,NULL),(NULL,NULL,'26',NULL,NULL,NULL,NULL,'2019-10-31 16:38:27',NULL,'26',NULL,NULL,NULL),(NULL,NULL,'27',NULL,NULL,NULL,NULL,'2019-10-31 16:38:34',NULL,'27',NULL,NULL,NULL),(NULL,NULL,'28',NULL,NULL,NULL,NULL,'2019-10-31 16:38:39',NULL,'28',NULL,NULL,NULL),(NULL,NULL,'29',NULL,NULL,NULL,NULL,'2019-10-31 16:38:49',NULL,'29',NULL,NULL,NULL),(NULL,NULL,'3',NULL,NULL,'100',NULL,'2019-10-30 17:11:10',NULL,'3',NULL,NULL,NULL),(NULL,NULL,'4',NULL,NULL,'100',NULL,'2019-10-30 21:57:34',NULL,'4',NULL,NULL,NULL),(NULL,NULL,NULL,'444','444','444',NULL,'2019-11-06 17:04:56',NULL,'444',NULL,NULL,NULL),(NULL,NULL,'5',NULL,NULL,'100',NULL,'2019-10-30 21:57:44',NULL,'5',NULL,NULL,NULL),(NULL,NULL,NULL,NULL,'55','55',NULL,'2019-11-06 17:09:09',NULL,'55',NULL,NULL,NULL),(NULL,NULL,'6',NULL,NULL,'100',NULL,'2019-10-30 21:57:53',NULL,'6',NULL,NULL,NULL),(NULL,NULL,NULL,NULL,'66','66',NULL,'2019-11-06 17:13:55',NULL,'66',NULL,NULL,NULL),(NULL,NULL,NULL,'666','666','666',NULL,'2019-11-06 16:55:37',NULL,'666',NULL,NULL,NULL),(NULL,NULL,'7',NULL,NULL,'100',NULL,'2019-10-30 21:58:01',NULL,'7',NULL,NULL,NULL),(NULL,NULL,'8',NULL,NULL,'100',NULL,'2019-10-30 21:58:07',NULL,'8',NULL,NULL,NULL),(NULL,NULL,'88',NULL,'88','88',NULL,'2019-11-06 17:18:09',NULL,'88',NULL,NULL,NULL),(NULL,NULL,NULL,'888','888','888',NULL,'2019-11-06 16:56:53',NULL,'888',NULL,NULL,NULL),(NULL,NULL,'9',NULL,NULL,'100',NULL,'2019-10-30 21:58:43',NULL,'9',NULL,NULL,NULL);

/*Table structure for table `xd_service_user` */

DROP TABLE IF EXISTS `xd_service_user`;

CREATE TABLE `xd_service_user` (
  `id` varchar(8) NOT NULL COMMENT '服务商用户',
  `service_head` varchar(20) DEFAULT NULL COMMENT '服务商头像',
  `service_name` varchar(20) DEFAULT NULL COMMENT '服务商名称',
  `area` varchar(8) DEFAULT NULL COMMENT '服务商地区',
  `service_phone` varchar(11) DEFAULT NULL COMMENT '服务商电话',
  `service_password` varchar(20) DEFAULT NULL COMMENT '服务商密码',
  `introduction` varchar(50) DEFAULT NULL COMMENT '给管理员查看的服务商简介',
  `status` varchar(5) DEFAULT NULL COMMENT '服务商登录状态',
  `email` varchar(20) DEFAULT NULL COMMENT '邮箱',
  `ts` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `synopsis` varchar(50) DEFAULT NULL COMMENT '给用户看的服务商简介',
  `worktime` varchar(50) DEFAULT NULL COMMENT '工作时间',
  `qq` varchar(10) DEFAULT NULL COMMENT 'QQ',
  `wechat` varchar(15) DEFAULT NULL COMMENT '微信',
  `custom_phone` varchar(15) DEFAULT NULL COMMENT '客服电话',
  `license` varchar(30) DEFAULT NULL COMMENT '营业执照',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `xd_service_user` */

/*Table structure for table `xd_shopping` */

DROP TABLE IF EXISTS `xd_shopping`;

CREATE TABLE `xd_shopping` (
  `id` varchar(10) NOT NULL COMMENT '服务产品',
  `product_id` varchar(5) DEFAULT NULL COMMENT '服务产品id',
  `count` int(10) DEFAULT NULL COMMENT '购买数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `xd_shopping` */

/*Table structure for table `xd_user` */

DROP TABLE IF EXISTS `xd_user`;

CREATE TABLE `xd_user` (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `head_img` blob COMMENT '用户头像',
  `name` varchar(8) DEFAULT NULL COMMENT '用户名字',
  `email` varchar(20) DEFAULT NULL COMMENT '邮箱',
  `status` varchar(8) DEFAULT NULL COMMENT '登录状态（1已登录、未登录0）',
  `ts` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `xd_user` */

insert  into `xd_user`(`id`,`phone`,`password`,`head_img`,`name`,`email`,`status`,`ts`) values ('1','15184526277','123',NULL,'bxx','1757950377@qq.com',NULL,'2019-10-19 16:25:23'),('2','2','2',NULL,NULL,NULL,NULL,NULL),('3','3','3',NULL,NULL,NULL,NULL,NULL),('4','4','4',NULL,NULL,NULL,NULL,NULL),('5','5','5',NULL,NULL,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
