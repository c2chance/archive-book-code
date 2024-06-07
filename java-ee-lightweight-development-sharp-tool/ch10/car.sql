/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.6.23-log : Database - car
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`car` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `car`;

/*Table structure for table `car_brand` */

DROP TABLE IF EXISTS `car_brand`;

CREATE TABLE `car_brand` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `enabled` bit(1) DEFAULT b'1',
  `modified_at` datetime DEFAULT NULL,
  `begin_time` varchar(255) DEFAULT NULL,
  `cars_brand` varchar(255) DEFAULT NULL,
  `dept` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `end_time` varchar(255) DEFAULT NULL,
  `friend` varchar(255) DEFAULT NULL,
  `interest` varchar(255) DEFAULT NULL,
  `leave_time` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcpi24xe2h71hwhbs1b5kvgxns` (`created_by`),
  KEY `FK515305e0ylejel6lsto5ghn0j` (`modified_by`),
  CONSTRAINT `FK1k3lw7j71bi3ejccxhwiwgy3t` FOREIGN KEY (`modified_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FK515305e0ylejel6lsto5ghn0j` FOREIGN KEY (`modified_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FK9dx9mgfddx2bh2lifx13w4e3d` FOREIGN KEY (`created_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FKcpi24xe2h71hwhbs1b5kvgxns` FOREIGN KEY (`created_by`) REFERENCES `car_sys_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `car_brand` */

insert  into `car_brand`(`id`,`created_at`,`enabled`,`modified_at`,`begin_time`,`cars_brand`,`dept`,`description`,`end_time`,`friend`,`interest`,`leave_time`,`name`,`phone`,`created_by`,`modified_by`) values (1,'2020-11-27 00:03:32','','2020-12-04 21:25:56','早晨5点','奔驰','开发部','开发人员','晚上22点',NULL,'物理',NULL,'牛顿','172',1,1),(2,'2020-11-27 00:03:43','','2020-12-04 21:25:49','早晨5点','宝马','业务部','业务人员','晚上22点',NULL,'天文',NULL,'伽利略','171',1,1),(3,'2020-11-27 00:24:15','','2020-12-04 21:25:40','早晨5点','比亚迪','人事部','人事情况','晚上22点',NULL,'哲学',NULL,'柏拉图','170',1,1),(7,'2020-12-02 23:24:06','\0','2020-12-02 23:24:06','早晨5点','111','11','11','晚上22点',NULL,'111',NULL,'11','18519680608',1,1);

/*Table structure for table `car_notice_manager` */

DROP TABLE IF EXISTS `car_notice_manager`;

CREATE TABLE `car_notice_manager` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `enabled` bit(1) DEFAULT b'1',
  `modified_at` datetime DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfdiesoefbs7n7lng2h6aj707v` (`created_by`),
  KEY `FKmxtkfky2586k3skafduil9os6` (`modified_by`),
  CONSTRAINT `FK38sy0spha7mvm60hdfjhog2wu` FOREIGN KEY (`created_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FK3bfr0407ft4afn0mq6502copo` FOREIGN KEY (`modified_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FKdjkfws06u0bta32vdsh0pknsb` FOREIGN KEY (`created_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FKdq3r0d53c4di4tatb8anq7a3m` FOREIGN KEY (`modified_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FKqlyeldhf6tim2t4mxbayqw8r8` FOREIGN KEY (`modified_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FKscqbgia7pkwr87ia6jeo15gfl` FOREIGN KEY (`created_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `car_notice_manager_ibfk_1` FOREIGN KEY (`created_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `car_notice_manager_ibfk_2` FOREIGN KEY (`modified_by`) REFERENCES `car_sys_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

/*Data for the table `car_notice_manager` */

insert  into `car_notice_manager`(`id`,`created_at`,`enabled`,`modified_at`,`created_by`,`modified_by`,`description`,`title`) values (21,'2021-01-08 13:58:09','','2021-02-06 18:09:06',1,1,'二郎神','杨戬'),(22,'2021-02-07 19:07:49','','2022-04-01 02:26:13',1,1,'猴子','孙悟空'),(23,'2021-02-07 19:35:48','\0','2021-02-07 19:35:48',1,1,'水电费','事实上');

/*Table structure for table `car_role_permission` */

DROP TABLE IF EXISTS `car_role_permission`;

CREATE TABLE `car_role_permission` (
  `roles_id` bigint(20) NOT NULL,
  `permission_id` bigint(20) NOT NULL,
  KEY `FKpermiss` (`permission_id`),
  KEY `FKroles` (`roles_id`),
  CONSTRAINT `FKmc2xj4fmhto6d394xjjsqkhmy` FOREIGN KEY (`roles_id`) REFERENCES `car_sys_role` (`id`),
  CONSTRAINT `FKpe6eb6nc65jasif4v6kiqenvn` FOREIGN KEY (`permission_id`) REFERENCES `car_sys_permission` (`id`),
  CONSTRAINT `FKpermiss_idys` FOREIGN KEY (`permission_id`) REFERENCES `car_sys_permission` (`id`),
  CONSTRAINT `FKrole_idys` FOREIGN KEY (`roles_id`) REFERENCES `car_sys_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `car_role_permission` */

insert  into `car_role_permission`(`roles_id`,`permission_id`) values (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,11),(1,12),(1,9),(1,15),(1,10),(1,13),(1,14),(6,11),(6,14);

/*Table structure for table `car_sys_organization` */

DROP TABLE IF EXISTS `car_sys_organization`;

CREATE TABLE `car_sys_organization` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `enabled` bit(1) DEFAULT b'1',
  `modified_at` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoq9j9uem4u42sl601owvhbyxl` (`created_by`),
  KEY `FK9o45jxw1itybgi6v1gqxguegc` (`modified_by`),
  KEY `FKhcrlgc06l5rc2hvw315lwet44` (`parent_id`),
  CONSTRAINT `FK2fd0mwdo7t6b67elohvrw9sxx` FOREIGN KEY (`modified_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FK9o45jxw1itybgi6v1gqxguegc` FOREIGN KEY (`modified_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FKalow7bhj3fdbyac4lcim1i9u8` FOREIGN KEY (`parent_id`) REFERENCES `car_sys_organization` (`id`),
  CONSTRAINT `FKcs44m0bxnwtrvpjbtbk4n8ob1` FOREIGN KEY (`modified_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FKgc8i3d51rqmgit6iubjf4at8l` FOREIGN KEY (`parent_id`) REFERENCES `car_sys_organization` (`id`),
  CONSTRAINT `FKhcrlgc06l5rc2hvw315lwet44` FOREIGN KEY (`parent_id`) REFERENCES `car_sys_organization` (`id`),
  CONSTRAINT `FKhoejxjr9aux4dti305743uqao` FOREIGN KEY (`created_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FKoq9j9uem4u42sl601owvhbyxl` FOREIGN KEY (`created_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FKrotkdr2t1vuv09wunfn94sk` FOREIGN KEY (`created_by`) REFERENCES `car_sys_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `car_sys_organization` */

insert  into `car_sys_organization`(`id`,`created_at`,`enabled`,`modified_at`,`name`,`created_by`,`modified_by`,`parent_id`) values (1,'2018-05-02 17:33:02','','2018-05-02 17:33:02','停车场',1,1,NULL),(2,'2018-05-02 17:47:35','','2018-05-02 17:47:35','停车场',NULL,NULL,1),(3,'2018-05-02 17:47:35','','2018-05-02 17:47:35','停车场',NULL,NULL,2),(4,'2018-05-02 17:47:35','','2018-05-02 17:47:35','停车场',NULL,NULL,3);

/*Table structure for table `car_sys_permission` */

DROP TABLE IF EXISTS `car_sys_permission`;

CREATE TABLE `car_sys_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `enabled` bit(1) DEFAULT b'1',
  `modified_at` datetime DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `module` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `operation` varchar(255) DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpmc4f6go0d5` (`created_by`),
  KEY `FKpmciyx4a1ge` (`modified_by`),
  CONSTRAINT `FK6s9aso5f` FOREIGN KEY (`created_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FKa9ntwhwajjb4hhcgsg0spjyx5` FOREIGN KEY (`created_by`) REFERENCES `car_t_sys_user` (`id`),
  CONSTRAINT `FKhbsx4m35` FOREIGN KEY (`modified_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FKhgnevekc8b2wgm5nso7km9fxf` FOREIGN KEY (`modified_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FKlb0bxogykahys9sv6ivtmlsfs` FOREIGN KEY (`modified_by`) REFERENCES `car_t_sys_user` (`id`),
  CONSTRAINT `FKpdihsjfs` FOREIGN KEY (`created_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FKpmciyx4a` FOREIGN KEY (`modified_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FKrkh67asbf37ful00dnrbrhc9h` FOREIGN KEY (`created_by`) REFERENCES `car_sys_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `car_sys_permission` */

insert  into `car_sys_permission`(`id`,`created_at`,`enabled`,`modified_at`,`code`,`module`,`name`,`operation`,`created_by`,`modified_by`) values (1,NULL,'',NULL,'role','用户管理','角色权限管理',NULL,NULL,NULL),(2,NULL,'',NULL,'user','用户管理','后台账户管理',NULL,NULL,NULL),(3,NULL,'',NULL,'driver','用户管理','车主信息管理',NULL,NULL,NULL),(4,NULL,'',NULL,'pass-category','基础数据管理','通行证类别管理',NULL,NULL,NULL),(5,NULL,'',NULL,'papers','基础数据管理','通行证证件管理',NULL,NULL,NULL),(6,NULL,'',NULL,'gate','基础数据管理','停车场管理管理',NULL,NULL,NULL),(7,NULL,'',NULL,'refuse-reason','基础数据管理','审核拒绝原因',NULL,NULL,NULL),(8,NULL,'',NULL,'organization','基础数据管理','组织机构管理',NULL,NULL,NULL),(9,NULL,'',NULL,'passs','通行证管理','通行证审核',NULL,NULL,NULL),(10,NULL,'',NULL,'peccancy','违章管理','违章信息审核',NULL,NULL,NULL),(11,NULL,'',NULL,'notice','基础数据管理','站内信',NULL,NULL,NULL),(12,NULL,'',NULL,'peccancyType','基础数据管理','违章类型管理',NULL,NULL,NULL),(13,NULL,'',NULL,'hobbylist','我的兴趣','兴趣管理',NULL,NULL,NULL),(14,NULL,'',NULL,'carBrand','汽车品牌管理','汽车品牌管理',NULL,NULL,NULL),(15,NULL,'',NULL,'authorization','通行证管理','临时授权',NULL,NULL,NULL);

/*Table structure for table `car_sys_role` */

DROP TABLE IF EXISTS `car_sys_role`;

CREATE TABLE `car_sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `enabled` bit(1) DEFAULT b'1',
  `modified_at` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `role_id` varchar(255) DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8o8oyoj` (`created_by`),
  KEY `FKtn0rryj` (`modified_by`),
  CONSTRAINT `FK3in1gxrqy99pi` FOREIGN KEY (`modified_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FK4pxw6md9cvbcn` FOREIGN KEY (`created_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FK5rgdt8ipenjrtld` FOREIGN KEY (`created_by`) REFERENCES `car_t_sys_user` (`id`),
  CONSTRAINT `FK6nlmkcvqa6cheljedxetlb4f4` FOREIGN KEY (`modified_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FK6nlmkcvqtlb4f4` FOREIGN KEY (`modified_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FK6oy7e32jwe2osl7v` FOREIGN KEY (`modified_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FK8o8oyose34jp34xd` FOREIGN KEY (`created_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FKd5457utkqqhgh` FOREIGN KEY (`modified_by`) REFERENCES `car_t_sys_user` (`id`),
  CONSTRAINT `FKth5wjqjtjsxj7v` FOREIGN KEY (`created_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FKth5wjqjtjsxj7vgdv2hy59jcr` FOREIGN KEY (`created_by`) REFERENCES `car_sys_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `car_sys_role` */

insert  into `car_sys_role`(`id`,`created_at`,`enabled`,`modified_at`,`description`,`name`,`role_id`,`created_by`,`modified_by`) values (1,NULL,'',NULL,'','管理员',NULL,NULL,NULL),(2,NULL,'',NULL,NULL,'其他',NULL,NULL,NULL),(6,'2021-02-07 21:39:15','',NULL,'super角色','super角色',NULL,NULL,NULL);

/*Table structure for table `car_sys_user` */

DROP TABLE IF EXISTS `car_sys_user`;

CREATE TABLE `car_sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `enabled` bit(1) DEFAULT b'1',
  `modified_at` datetime DEFAULT NULL,
  `is_password_reset` bit(1) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `real_name` varchar(255) DEFAULT NULL,
  `symbol` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `org_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1n1l7nudpp0qc8ixo` (`created_by`),
  KEY `FKn1ryhd6u0uqawc6pk` (`modified_by`),
  KEY `FKj5ujdr7e28k1qv7yu` (`org_id`),
  CONSTRAINT `FK1n1l76sqr` FOREIGN KEY (`created_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FK5hs3m9kg3h3tkb2tnw582okqt` FOREIGN KEY (`modified_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FK5hs3m9kqt` FOREIGN KEY (`modified_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FKd4dycq4yf` FOREIGN KEY (`created_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FKd4dycq4yfbqxqmmdkdhrqk2u3` FOREIGN KEY (`created_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FKj5ujdr7e2` FOREIGN KEY (`org_id`) REFERENCES `car_sys_organization` (`id`),
  CONSTRAINT `FKmxop4tua9` FOREIGN KEY (`modified_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FKn1ryhd6u6` FOREIGN KEY (`modified_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FKp5sefkewa` FOREIGN KEY (`created_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FKrgy2lx201` FOREIGN KEY (`org_id`) REFERENCES `car_sys_organization` (`id`),
  CONSTRAINT `FKt674nx322` FOREIGN KEY (`org_id`) REFERENCES `car_sys_organization` (`id`),
  CONSTRAINT `FKt674nx3bx3ehqeryc853xxwfe` FOREIGN KEY (`org_id`) REFERENCES `car_sys_organization` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `car_sys_user` */

insert  into `car_sys_user`(`id`,`created_at`,`enabled`,`modified_at`,`is_password_reset`,`password`,`real_name`,`symbol`,`telephone`,`username`,`created_by`,`modified_by`,`org_id`) values (1,NULL,'',NULL,NULL,'2111c427fe8c16b0a7be319e537828d7',NULL,'manager',NULL,'admin',NULL,NULL,NULL),(2,'2018-05-02 17:34:46','','2018-05-02 17:34:46',NULL,'2111c427fe8c16b0a7be319e537828d7',NULL,'driver','1','2',1,1,NULL),(10,'2018-05-02 17:47:36','','2018-05-02 17:47:36',NULL,'2111c427fe8c16b0a7be319e537828d7',NULL,'driver',NULL,'a110111',NULL,NULL,NULL),(11,'2021-02-07 19:46:37','','2021-02-07 19:46:37',NULL,'8777f676af9df550b96e115908090f6b',NULL,'manager','','super',1,1,3);

/*Table structure for table `car_t_sys_abnormal_car` */

DROP TABLE IF EXISTS `car_t_sys_abnormal_car`;

CREATE TABLE `car_t_sys_abnormal_car` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `enabled` bit(1) DEFAULT b'1',
  `modified_at` datetime DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `license` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfdiesoefbs7n7lng2h6aj707v` (`created_by`),
  KEY `FKmxtkfky2586k3skafduil9os6` (`modified_by`),
  CONSTRAINT `FK3yk4myms5kltrdv5j7djf234m` FOREIGN KEY (`modified_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FKjhj2i8nngr3ujtws5fjqgpv9w` FOREIGN KEY (`created_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FKngfr1kohy1v0vx7dvdxnsvtm2` FOREIGN KEY (`modified_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FKrhtg4j9dr46qj0i0lfr47c3ow` FOREIGN KEY (`created_by`) REFERENCES `car_sys_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

/*Data for the table `car_t_sys_abnormal_car` */

insert  into `car_t_sys_abnormal_car`(`id`,`created_at`,`enabled`,`modified_at`,`created_by`,`modified_by`,`description`,`license`) values (26,'2018-05-08 13:58:09','','2018-05-08 13:58:09',1,1,'刘备','刘备'),(27,'2018-05-08 13:58:09','','2018-05-08 13:58:09',1,1,'刘备','刘备'),(28,'2018-05-08 13:58:09','','2018-05-08 13:58:09',1,1,'刘备','刘备');

/*Table structure for table `car_t_sys_authorization` */

DROP TABLE IF EXISTS `car_t_sys_authorization`;

CREATE TABLE `car_t_sys_authorization` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `enabled` bit(1) DEFAULT b'1',
  `modified_at` datetime DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `license` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `grant_man` varchar(255) DEFAULT NULL,
  `grant_dept` varchar(255) DEFAULT NULL,
  `grant_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfdiesoefbs7n7lng2h6aj707v` (`created_by`),
  KEY `FKmxtkfky2586k3skafduil9os6` (`modified_by`),
  CONSTRAINT `FK9cr8c0cxxy16uo9b29foifj65` FOREIGN KEY (`modified_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FKff2f6j7lupermmg2t8c7eo376` FOREIGN KEY (`created_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FKi0snp315jqud1xfop6ehb4lxb` FOREIGN KEY (`modified_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FKt01thhp8yjawtwi1qr9upj5pw` FOREIGN KEY (`created_by`) REFERENCES `car_sys_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

/*Data for the table `car_t_sys_authorization` */

insert  into `car_t_sys_authorization`(`id`,`created_at`,`enabled`,`modified_at`,`created_by`,`modified_by`,`description`,`license`,`name`,`phone`,`grant_man`,`grant_dept`,`grant_time`) values (25,'2018-05-08 13:58:09','','2018-05-08 13:58:09',1,1,'诸葛亮','刘备',NULL,NULL,NULL,NULL,NULL),(28,'2018-05-08 13:58:09','','2018-05-08 13:58:09',1,1,'刘备','刘备',NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `car_t_sys_driver` */

DROP TABLE IF EXISTS `car_t_sys_driver`;

CREATE TABLE `car_t_sys_driver` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `enabled` bit(1) DEFAULT b'1',
  `modified_at` datetime DEFAULT NULL,
  `car_type` varchar(255) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `license` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `org_id` bigint(20) DEFAULT NULL,
  `pass_category_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5n1a0y2rjwug12arlvuyi511o` (`created_by`),
  KEY `FKa6toaf18xxlyyeehlj7ejsyp5` (`modified_by`),
  KEY `FKlkjppnlrtvxa020mynkpcuo71` (`org_id`),
  KEY `FK64vyf8jn0yqqcebs4gd48xu6b` (`pass_category_id`),
  KEY `FK5q5kcs9w79o9938g9or90gybn` (`user_id`),
  CONSTRAINT `FK1wlrppijgrrquspf8s73oxag7` FOREIGN KEY (`pass_category_id`) REFERENCES `car_t_sys_pass_category` (`id`),
  CONSTRAINT `FK4rt8rssupeq41otwap8qhpsol` FOREIGN KEY (`created_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FK5n1a0y2rjwug12arlvuyi511o` FOREIGN KEY (`created_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FK5q5kcs9w79o9938g9or90gybn` FOREIGN KEY (`user_id`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FK64vyf8jn0yqqcebs4gd48xu6b` FOREIGN KEY (`pass_category_id`) REFERENCES `car_t_sys_pass_category` (`id`),
  CONSTRAINT `FK9197232hnjlaunyexrc9u7hd0` FOREIGN KEY (`modified_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FKa6toaf18xxlyyeehlj7ejsyp5` FOREIGN KEY (`modified_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FKapb0a1l6nx3x2mapvf182neer` FOREIGN KEY (`org_id`) REFERENCES `car_sys_organization` (`id`),
  CONSTRAINT `FKefdocy1ucwrplh8w9camwluwg` FOREIGN KEY (`user_id`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FKhu7rmw74c6qn4r714x3f39ydp` FOREIGN KEY (`org_id`) REFERENCES `car_sys_organization` (`id`),
  CONSTRAINT `FKjhn8ptvehilxo020rjpa3axil` FOREIGN KEY (`modified_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FKlkjppnlrtvxa020mynkpcuo71` FOREIGN KEY (`org_id`) REFERENCES `car_sys_organization` (`id`),
  CONSTRAINT `FKoj3l4cfm7rcurhprl6542d15s` FOREIGN KEY (`user_id`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FKqyg3ohgrpcuesj2fn7cwjb2ph` FOREIGN KEY (`created_by`) REFERENCES `car_sys_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `car_t_sys_driver` */

insert  into `car_t_sys_driver`(`id`,`created_at`,`enabled`,`modified_at`,`car_type`,`company`,`license`,`name`,`number`,`telephone`,`created_by`,`modified_by`,`org_id`,`pass_category_id`,`user_id`) values (1,'2021-01-01 17:34:46','','2018-05-02 17:51:17','abc','abc','123','ddd','aaa','333',1,NULL,NULL,1,2),(9,'2019-12-05 17:47:36','','2018-05-02 17:54:30','abc','abc','123','ddd','aaa','333',NULL,NULL,2,1,10);

/*Table structure for table `car_t_sys_log` */

DROP TABLE IF EXISTS `car_t_sys_log`;

CREATE TABLE `car_t_sys_log` (
  `log_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `browser` varchar(255) DEFAULT NULL,
  `browser_major_version` varchar(255) DEFAULT NULL,
  `browser_version` varchar(255) DEFAULT NULL,
  `device` varchar(255) DEFAULT NULL,
  `execute_time` varchar(255) DEFAULT NULL,
  `exinfo` varchar(255) DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `log_type` varchar(255) DEFAULT NULL,
  `method` varchar(255) DEFAULT NULL,
  `operate_person` varchar(255) DEFAULT NULL,
  `operate_time` datetime DEFAULT NULL,
  `os` varchar(255) DEFAULT NULL,
  `os_bit` varchar(255) DEFAULT NULL,
  `os_manu` varchar(255) DEFAULT NULL,
  `os_type` varchar(255) DEFAULT NULL,
  `os_version` varchar(255) DEFAULT NULL,
  `params` varchar(255) DEFAULT NULL,
  `request_uri` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `car_t_sys_log` */

/*Table structure for table `car_t_sys_pass_category` */

DROP TABLE IF EXISTS `car_t_sys_pass_category`;

CREATE TABLE `car_t_sys_pass_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `enabled` bit(1) DEFAULT b'1',
  `modified_at` datetime DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `papers` varchar(255) DEFAULT NULL,
  `re_marks` varchar(255) DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpib5oly73fl1qwcr5b4l9cohu` (`created_by`),
  KEY `FKt6tj7w6qkyr6ksm975932n0e4` (`modified_by`),
  CONSTRAINT `FKban4dwisdxsa09wvcaam7yavi` FOREIGN KEY (`modified_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FKfnohbcvgjaniicumc410kappl` FOREIGN KEY (`created_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FKgobkxiik5mmenquax4t07jq43` FOREIGN KEY (`created_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FKmud5tm6eddx49vnj6sw65chxg` FOREIGN KEY (`modified_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FKpib5oly73fl1qwcr5b4l9cohu` FOREIGN KEY (`created_by`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FKt6tj7w6qkyr6ksm975932n0e4` FOREIGN KEY (`modified_by`) REFERENCES `car_sys_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `car_t_sys_pass_category` */

insert  into `car_t_sys_pass_category`(`id`,`created_at`,`enabled`,`modified_at`,`category`,`papers`,`re_marks`,`created_by`,`modified_by`) values (1,NULL,'','2021-02-06 17:41:49','行驶证','4','',NULL,1),(2,NULL,'','2021-02-06 17:41:58','工作证','2,3,4,5','工作证',NULL,1),(3,NULL,'','2021-02-06 17:42:06',' 驾驶证','2,3,4,5',' 驾驶证',NULL,1);

/*Table structure for table `car_t_sys_user` */

DROP TABLE IF EXISTS `car_t_sys_user`;

CREATE TABLE `car_t_sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `enabled` bit(1) DEFAULT b'1',
  `modified_at` datetime DEFAULT NULL,
  `is_password_reset` bit(1) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `real_name` varchar(255) DEFAULT NULL,
  `symbol` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `org_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `car_t_sys_user` */

insert  into `car_t_sys_user`(`id`,`created_at`,`enabled`,`modified_at`,`is_password_reset`,`password`,`real_name`,`symbol`,`telephone`,`username`,`created_by`,`modified_by`,`org_id`) values (1,NULL,'',NULL,NULL,'2111c427fe8c16b0a7be319e537828d7',NULL,'manager',NULL,'admin',NULL,NULL,NULL);

/*Table structure for table `car_t_sys_user_role` */

DROP TABLE IF EXISTS `car_t_sys_user_role`;

CREATE TABLE `car_t_sys_user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  KEY `FKl2o4hxlyp8d0nt2guqsu1qssr` (`role_id`),
  KEY `FKpshjnr5jb9asjww3lc7vk46dq` (`user_id`),
  CONSTRAINT `FK126njhfabue8x5xve0errvxm5` FOREIGN KEY (`role_id`) REFERENCES `car_sys_role` (`id`),
  CONSTRAINT `FK4thos6ax5a7vdqbu79tl6ndy1` FOREIGN KEY (`user_id`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FKiyvn0xh9ly5n0e9go9hgrid5a` FOREIGN KEY (`role_id`) REFERENCES `car_sys_role` (`id`),
  CONSTRAINT `FKl2o4hxlyp8d0nt2guqsu1qssr` FOREIGN KEY (`role_id`) REFERENCES `car_sys_role` (`id`),
  CONSTRAINT `FKpshjnr5jb9asjww3lc7vk46dq` FOREIGN KEY (`user_id`) REFERENCES `car_sys_user` (`id`),
  CONSTRAINT `FKq50aro2dnhfg9br3rb8tkhguo` FOREIGN KEY (`user_id`) REFERENCES `car_sys_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `car_t_sys_user_role` */

insert  into `car_t_sys_user_role`(`user_id`,`role_id`) values (1,1),(11,6);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
