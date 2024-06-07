/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.6.23-log : Database - manage
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`manage` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `manage`;

/*Table structure for table `custom` */

DROP TABLE IF EXISTS `custom`;

CREATE TABLE `custom` (
  `ID` int(11) DEFAULT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  `SEX` varchar(100) DEFAULT NULL,
  `AGE` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `custom` */

insert  into `custom`(`ID`,`NAME`,`SEX`,`AGE`) values (23,'菲斯','女',30);

/*Table structure for table `goods_sendcount` */

DROP TABLE IF EXISTS `goods_sendcount`;

CREATE TABLE `goods_sendcount` (
  `CITY` varchar(100) DEFAULT NULL COMMENT '城市',
  `GOODS` varchar(100) DEFAULT NULL COMMENT '货物',
  `AMOUNT` varchar(100) DEFAULT NULL COMMENT '数量',
  `RECEIVER` varchar(100) DEFAULT NULL COMMENT '收货人',
  `TAKEDATE` datetime DEFAULT NULL COMMENT '收货日期',
  `SENDDATE` datetime DEFAULT NULL COMMENT '发货日期',
  `REMARK` varchar(100) DEFAULT NULL COMMENT '备注'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goods_sendcount` */

insert  into `goods_sendcount`(`CITY`,`GOODS`,`AMOUNT`,`RECEIVER`,`TAKEDATE`,`SENDDATE`,`REMARK`) values ('杭州','苹果','100','老农','2015-03-01 00:00:00','2015-01-01 00:00:00','不错'),('张掖','麻辣粉','18','秦朝','2015-06-23 00:00:00','2015-06-23 00:00:00','啊'),('上海','桔子','50','阿明','2015-07-10 00:00:00','2015-07-28 00:00:00','收到了'),('33','33','33','33','2020-09-08 00:00:00','2020-09-23 00:00:00',''),('33','33','33','33','2020-12-22 00:00:00','2020-12-22 00:00:00','ces'),('33','33','33','33','2020-12-22 00:00:00','2020-12-22 00:00:00','ces'),('33','33','33','33','2020-12-22 00:00:00','2020-12-22 00:00:00','ces');

/*Table structure for table `manage_area` */

DROP TABLE IF EXISTS `manage_area`;

CREATE TABLE `manage_area` (
  `ICODE` varchar(100) NOT NULL,
  `NO` varchar(100) DEFAULT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  `SPELLNO` varchar(100) DEFAULT NULL,
  `CUSTOMNO` varchar(100) DEFAULT NULL,
  `PARENTICODE` varchar(100) DEFAULT NULL,
  `STOPFLAG` int(11) DEFAULT NULL,
  `ADDRESS` varchar(100) DEFAULT NULL,
  `ZIP` varchar(100) DEFAULT NULL,
  `TEL` varchar(100) DEFAULT NULL,
  `LEVEL1` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ICODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `manage_area` */

insert  into `manage_area`(`ICODE`,`NO`,`NAME`,`SPELLNO`,`CUSTOMNO`,`PARENTICODE`,`STOPFLAG`,`ADDRESS`,`ZIP`,`TEL`,`LEVEL1`) values ('1','0','销售总部','xszb','1','',0,'0','0','0',NULL),('b12ad5d2-b005-4bbe-82f2-8fb0c625f44f','zcxd','测试','cs','1','',0,'0','0','0',NULL);

/*Table structure for table `manage_model` */

DROP TABLE IF EXISTS `manage_model`;

CREATE TABLE `manage_model` (
  `ICODE` varchar(100) NOT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  `URL` varchar(100) DEFAULT NULL,
  `PARENTICODE` varchar(100) DEFAULT NULL,
  `LEVEL1` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ICODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `manage_model` */

insert  into `manage_model`(`ICODE`,`NAME`,`URL`,`PARENTICODE`,`LEVEL1`) values ('04e480dc-5cfd-4580-b145-2d608f3dbb12','Dialog对话框窗口','example/Dialog.jsp','d21c7ea9-ea2e-4729-a5dd-488d57c54d6c','具体功能菜单=具体功能菜单'),('05e17d87-e3ac-43f7-b486-2dd07f895ed2','人员管理',NULL,'a5a969bd-169d-4fc9-9985-cf74125c2e85','二级菜单=二级菜单'),('072aad32-2940-4f55-8095-0f987cb4ac3f','Resizable调整大小','example/Resizable.jsp','d21c7ea9-ea2e-4729-a5dd-488d57c54d6c','具体功能菜单=具体功能菜单'),('08797b4f-2418-4eeb-9a79-6bb557de57db','ValidateBox验证框','example/ValidateBox.jsp','d21c7ea9-ea2e-4729-a5dd-488d57c54d6c','具体功能菜单=具体功能菜单'),('0fc443e6-18d5-495c-895b-39cadb8f431f','ComboGrid数据表格下拉框','example/ComboGrid.jsp','d21c7ea9-ea2e-4729-a5dd-488d57c54d6c','具体功能菜单=具体功能菜单'),('0fc497c1-57b7-4e70-b4f2-39bdf0d8f7f9','DataGridView数据表格展示','example/DataGridView.jsp','d21c7ea9-ea2e-4729-a5dd-488d57c54d6c','具体功能菜单=具体功能菜单'),('1','1','0','1',NULL),('1661317f-e60b-4f3d-9096-bb7ebdf5f889','EditableDataGrid可编辑表格','example/EditableDataGrid.jsp','d21c7ea9-ea2e-4729-a5dd-488d57c54d6c','具体功能菜单=具体功能菜单'),('1763ddbe-cbbd-4b7f-a900-ad31669a03db','发货数量统计','report/sendamount.jsp','c1bddbe2-b908-45af-8e5a-257012c03dae','具体功能菜单=具体功能菜单'),('194c2e71-bb43-4776-964a-907bc9686a0a','Menu菜单','example/Menu.jsp','d21c7ea9-ea2e-4729-a5dd-488d57c54d6c','具体功能菜单=具体功能菜单'),('1e146943-bdc1-4af4-b833-4dbcb147fb42','Window窗口','example/Window.jsp','d21c7ea9-ea2e-4729-a5dd-488d57c54d6c','具体功能菜单=具体功能菜单'),('253a71b1-a9fb-42cf-9ade-b53ca6a8816d','Draggable拖动','example/Draggable.jsp','d21c7ea9-ea2e-4729-a5dd-488d57c54d6c','具体功能菜单=具体功能菜单'),('26a188ed-78ee-48dd-bba2-1ee7d8b014a0','Slider滑动条','example/Slider.jsp','d21c7ea9-ea2e-4729-a5dd-488d57c54d6c','具体功能菜单=具体功能菜单'),('2ae2529e-ca35-47c9-84ae-e0346d01d700','Panel面板','example/Panel.jsp','d21c7ea9-ea2e-4729-a5dd-488d57c54d6c','具体功能菜单=具体功能菜单'),('36d257ad-42e4-4898-a7ed-279753ff416a','发货城市统计','report/sendcity.jsp','c1bddbe2-b908-45af-8e5a-257012c03dae','具体功能菜单=具体功能菜单'),('3bdec8ff-dfcb-47a4-93ba-3613078bd0c7','DateTimeBox日期时间输入框','example/DateTimeBox.jsp','d21c7ea9-ea2e-4729-a5dd-488d57c54d6c','具体功能菜单=具体功能菜单'),('4418db2c-2877-4adc-b056-8f417fe0d594','地市管理','area.jsp','5643512f-9b04-40e6-accb-986a1388dbd6','具体功能菜单=具体功能菜单'),('48dd6386-d0cd-49b3-b07e-b1c9ee4bc055','Droppable放置','example/Droppable.jsp','d21c7ea9-ea2e-4729-a5dd-488d57c54d6c','具体功能菜单=具体功能菜单'),('49312778-08c2-4b6c-9a30-11dedbcc6ffe','Portal门户','example/Portal.jsp','d21c7ea9-ea2e-4729-a5dd-488d57c54d6c','具体功能菜单=具体功能菜单'),('4c592edf-b5aa-4fe3-804a-318daf9a87c0','Parser解析器','example/Parser.jsp','d21c7ea9-ea2e-4729-a5dd-488d57c54d6c','具体功能菜单=具体功能菜单'),('5643512f-9b04-40e6-accb-986a1388dbd6','地市管理',NULL,'a5a969bd-169d-4fc9-9985-cf74125c2e85','二级菜单=二级菜单'),('5a3c1989-a9b1-4068-b62d-0475d7462288','报表',NULL,'bbf76355-e2aa-45f9-bb82-24947e1a4d63','二级菜单=二级菜单'),('5ca771ed-0550-4587-8813-82ad11efb7c5','sdcf','sdf','463ad545-254d-4fdb-ba2f-2a472a28b513','二级菜单=二级菜单'),('79578820-9154-43cf-a058-b6cb7d8d3566','ProgressBar进度条','example/ProgressBar.jsp','d21c7ea9-ea2e-4729-a5dd-488d57c54d6c','具体功能菜单=具体功能菜单'),('7a280c7a-a8ee-43d5-bcfc-a10f9d422087','Form表单','example/Form.jsp','d21c7ea9-ea2e-4729-a5dd-488d57c54d6c','具体功能菜单=具体功能菜单'),('7af09a26-88c2-449f-9d8f-41038ccb84b2','SplitButton分割按钮','example/SplitButton.jsp','d21c7ea9-ea2e-4729-a5dd-488d57c54d6c','具体功能菜单=具体功能菜单'),('7af1a041-e25d-4ba3-9a5b-089cc59f108e','ComboTree树形下拉框','example/ComboTree.jsp','d21c7ea9-ea2e-4729-a5dd-488d57c54d6c','具体功能菜单=具体功能菜单'),('7d573014-556a-48d0-9d1a-150e412ebfa4','报表统计',NULL,NULL,'一级菜单=一级菜单'),('7f8f55e2-5dd2-4790-afa3-8264dadec43e','Calendar日历','example/Calendar.jsp','d21c7ea9-ea2e-4729-a5dd-488d57c54d6c','具体功能菜单=具体功能菜单'),('872c45b6-35ef-48aa-ab62-9aae1731f01c','MenuButton菜单按钮','example/MenuButton.jsp','d21c7ea9-ea2e-4729-a5dd-488d57c54d6c','具体功能菜单=具体功能菜单'),('8809898e-b183-48bb-8f31-5f588954c038','客户管理',NULL,'ec912a8d-51db-4402-8b8f-71bd97db8e54','二级菜单=二级菜单'),('8d1bc4e7-cd83-4a23-ae3e-36ea8a185958','DateBox日期输入框','example/DateBox.jsp','d21c7ea9-ea2e-4729-a5dd-488d57c54d6c','具体功能菜单=具体功能菜单'),('91b87083-1b56-4697-a3e9-9057ee46e89f','Messager消息窗口','example/Messager.jsp','d21c7ea9-ea2e-4729-a5dd-488d57c54d6c','具体功能菜单=具体功能菜单'),('93593dba-f3ab-4c12-bf6c-252a84007278','Hibernate展示','report/senduser.jsp','c1bddbe2-b908-45af-8e5a-257012c03dae','具体功能菜单=具体功能菜单'),('9e3cfaf5-259a-45cc-9990-9f3c955c1ef9','EditableTree可编辑树','example/EditableTree.jsp','d21c7ea9-ea2e-4729-a5dd-488d57c54d6c','具体功能菜单=具体功能菜单'),('a5a969bd-169d-4fc9-9985-cf74125c2e85','系统管理',NULL,NULL,'一级菜单=一级菜单'),('aa70692d-a093-4035-9165-4796eb6aa7ff','二级菜单测试',NULL,'6f4eea7e-8be0-4ece-b8d5-1f150b6cdc2e','二级菜单=二级菜单'),('adea69f5-5d59-4629-b534-8e114af9c06a','Accordion分类','example/Accordion.jsp','d21c7ea9-ea2e-4729-a5dd-488d57c54d6c','具体功能菜单=具体功能菜单'),('ae4f5e7d-0313-451d-b2be-2f4e579b565d','TreeGrid树形表格','example/TreeGrid.jsp','d21c7ea9-ea2e-4729-a5dd-488d57c54d6c','具体功能菜单=具体功能菜单'),('b149f4d6-111e-4c36-823a-146340f91a13','ergd','dsf','b149f4d6-111e-4c36-823a-146340f91a13','一级菜单=一级菜单'),('b3d3f6f6-a72e-4884-a8c8-5f716fdc1a66','xczvs','xdfasdfasf','5ca771ed-0550-4587-8813-82ad11efb7c5','具体功能菜单=具体功能菜单'),('bd821871-ccfb-4971-96ee-f2c3cefd4194','发货报表','framework/sendoutreport.jsp','5a3c1989-a9b1-4068-b62d-0475d7462288','具体功能菜单=具体功能菜单'),('bfd358d7-dcde-4ee7-b4b7-9472a0d39789','Spinner微调','example/Spinner.jsp','d21c7ea9-ea2e-4729-a5dd-488d57c54d6c','具体功能菜单=具体功能菜单'),('c1bddbe2-b908-45af-8e5a-257012c03dae','发货统计',NULL,'7d573014-556a-48d0-9d1a-150e412ebfa4','二级菜单=二级菜单'),('c2a6fc6d-5a81-405b-bd3c-5794eb0a93ee','PropertyGrid属性表格','example/PropertyGrid.jsp','d21c7ea9-ea2e-4729-a5dd-488d57c54d6c','具体功能菜单=具体功能菜单'),('d05ceec0-7f6a-4517-abd4-b25164103499','Ajax实例',NULL,'dd5ffebd-5837-4f67-9bbe-4b434c61ee82','二级菜单=二级菜单'),('d1680696-7b3b-419e-a36e-0a15623b9f6f','人员管理','user.jsp','05e17d87-e3ac-43f7-b486-2dd07f895ed2','具体功能菜单=具体功能菜单'),('d21c7ea9-ea2e-4729-a5dd-488d57c54d6c','EasyUI控件实例',NULL,'dd5ffebd-5837-4f67-9bbe-4b434c61ee82','二级菜单=二级菜单'),('d3a8d102-957c-413f-9626-d5d605d4097f','Tooltip提示框','example/Tooltip.jsp','d21c7ea9-ea2e-4729-a5dd-488d57c54d6c','具体功能菜单=具体功能菜单'),('d59e7277-228e-4235-8123-9a474c4e21a2','城市管理','area.jsp','5643512f-9b04-40e6-accb-986a1388dbd6','具体功能菜单=具体功能菜单'),('dd5ffebd-5837-4f67-9bbe-4b434c61ee82','控件实例',NULL,NULL,'一级菜单=一级菜单'),('e33397d3-6fae-4177-90fc-59bde8522f62','库存管理',NULL,'f380dbe5-3a3d-40b0-8f0a-8236453b43ad','二级菜单=二级菜单'),('e33c7c00-437a-4f96-ac3c-2d5be9f81f94','ComboBox下拉列表框','example/ComboBox.jsp','d21c7ea9-ea2e-4729-a5dd-488d57c54d6c','具体功能菜单=具体功能菜单'),('e35cc053-9054-4e1b-83d7-5ad56625c97c',' 增加商品','data/addgoods.jsp','e33397d3-6fae-4177-90fc-59bde8522f62','具体功能菜单=具体功能菜单'),('e42d3c1d-c4dc-4ad0-a7f4-d24d885f10e0','EasyLoader简单加载','example/EasyLoader.jsp','d21c7ea9-ea2e-4729-a5dd-488d57c54d6c','具体功能菜单=具体功能菜单'),('ec912a8d-51db-4402-8b8f-71bd97db8e54','客户管理',NULL,NULL,'一级菜单=一级菜单'),('ef0e20ad-75a2-458f-b235-bb4c6107a955','Combo自定义下拉框','example/Combo.jsp','d21c7ea9-ea2e-4729-a5dd-488d57c54d6c','具体功能菜单=具体功能菜单'),('f1a404cd-4b0c-4be9-bc7d-80d8594059fb','NumberBox数值输入框','example/NumberBox.jsp','d21c7ea9-ea2e-4729-a5dd-488d57c54d6c','具体功能菜单=具体功能菜单'),('f261f091-dec1-4461-8a46-8d678ac7214e','NumberSpinner数字微调','example/NumberSpinner.jsp','d21c7ea9-ea2e-4729-a5dd-488d57c54d6c','具体功能菜单=具体功能菜单'),('f380dbe5-3a3d-40b0-8f0a-8236453b43ad','库存管理',NULL,NULL,'一级菜单=一级菜单'),('f415d1df-9178-4042-a1f4-ba8db54b9e24','SearchBox搜索框','example/SearchBox.jsp','d21c7ea9-ea2e-4729-a5dd-488d57c54d6c','具体功能菜单=具体功能菜单'),('f85c6466-685a-4f5f-869c-b7fa34ebafb7','Ajax的XmlHttpRequest实例','example/XMLHttpRequest.jsp','d05ceec0-7f6a-4517-abd4-b25164103499','具体功能菜单=具体功能菜单'),('fb6b21fb-fe10-4c09-81b7-9787d2fa4493','TimeSpinner时间微调','example/TimeSpinner.jsp','d21c7ea9-ea2e-4729-a5dd-488d57c54d6c','具体功能菜单=具体功能菜单'),('fe919bc1-603c-45ca-b578-3c414fa738e2','Layout布局','example/Layout.jsp','d21c7ea9-ea2e-4729-a5dd-488d57c54d6c','具体功能菜单=具体功能菜单');

/*Table structure for table `manage_permission` */

DROP TABLE IF EXISTS `manage_permission`;

CREATE TABLE `manage_permission` (
  `ICODE` varchar(100) NOT NULL,
  `ROLEICODE` varchar(100) DEFAULT NULL,
  `MODELICODE` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ICODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `manage_permission` */

insert  into `manage_permission`(`ICODE`,`ROLEICODE`,`MODELICODE`) values ('001545ad-dfe9-43fe-a986-1ea5cdaf1740','7951ea6f-7a4e-4007-8b77-a69daa5b9c0a','8809898e-b183-48bb-8f31-5f588954c038'),('01f82ba2-a8d8-41d8-b31a-eb3c275ca557','e5490a87-2248-47ec-aa79-5cf06fabf35f','ec912a8d-51db-4402-8b8f-71bd97db8e54'),('02dc93da-ca7c-44e3-874c-8c090cc9ea45','425b4463-4470-4ae3-abf5-d916da09f71c','7d573014-556a-48d0-9d1a-150e412ebfa4'),('04306e40-e938-4f60-8982-ab9ecdeefb18','d4cde3a3-472b-4ae6-8b74-864a4fb633c5','7fa1fe2d-870a-456f-a22a-65043022580b'),('06a5882e-33bc-4440-b302-c0355c72f045','834c2722-be2f-4d7c-b3e4-879371ae6069','55483301-1c90-4fd7-80d4-80268c3cf7eb'),('07202c54-bbb7-4f79-a12a-4c8706e8bcb9','7951ea6f-7a4e-4007-8b77-a69daa5b9c0a','ec912a8d-51db-4402-8b8f-71bd97db8e54'),('07e9eb13-ad46-427b-8a3d-105924726489','e5490a87-2248-47ec-aa79-5cf06fabf35f','fe919bc1-603c-45ca-b578-3c414fa738e2'),('0b46e293-13ef-409b-bc5f-30ffd3a6ec73','893bead6-f637-449e-af0c-22e1cac7ef03','8a3853c5-ec18-45e5-9127-8f91c3ca3a70'),('11f48d72-9746-4b60-85e3-b2beeee0564d','893bead6-f637-449e-af0c-22e1cac7ef03','1f95f068-162e-43ac-9f42-19d1650d3eb7'),('12c28525-4b53-4bcd-b393-f3f9c2f849a6','834c2722-be2f-4d7c-b3e4-879371ae6069','1a4802cd-b5ee-4e6d-a57f-9c0fd0c6b3a5'),('13281a90-1a3f-453c-bafd-dee5691e0d3d','c8ecfeab-868c-4fcc-b260-a2aaebc4e21a','18b5b7c9-df0c-45d3-8d61-5eedca17e04e'),('142ddb7f-1be7-4a9e-9fe9-fd5423f9fc47','e5490a87-2248-47ec-aa79-5cf06fabf35f','f85c6466-685a-4f5f-869c-b7fa34ebafb7'),('1625d24f-6dde-488d-a5c6-bdd6ab9b6286','d4cde3a3-472b-4ae6-8b74-864a4fb633c5','1a4802cd-b5ee-4e6d-a57f-9c0fd0c6b3a5'),('186ff9cd-6a89-452c-8b5a-b747d62bad6a','893bead6-f637-449e-af0c-22e1cac7ef03','2ada72b4-6b7e-4f96-8a08-89b2b116c523'),('19205267-f1ed-483a-ab52-3201ccc1189e','893bead6-f637-449e-af0c-22e1cac7ef03','ea3485ba-6da1-47b3-a72b-19dbc6f53872'),('19b08f5a-c993-4aa7-a263-96a096943f3f','e5490a87-2248-47ec-aa79-5cf06fabf35f','3bdec8ff-dfcb-47a4-93ba-3613078bd0c7'),('1c5bcfca-f2b8-4c82-a07b-87d85f0d7ef1','e5490a87-2248-47ec-aa79-5cf06fabf35f','79578820-9154-43cf-a058-b6cb7d8d3566'),('1f7350ca-f27c-4247-ac65-8dfe21a4f240','e5490a87-2248-47ec-aa79-5cf06fabf35f','0fc443e6-18d5-495c-895b-39cadb8f431f'),('20719c4d-aa10-470f-b219-71d665a0af58','e5490a87-2248-47ec-aa79-5cf06fabf35f','f261f091-dec1-4461-8a46-8d678ac7214e'),('208db8cd-06e3-4381-a3c5-ce77d832688f','893bead6-f637-449e-af0c-22e1cac7ef03','2f14f9a9-68fd-46f2-a06f-724fc4a74775'),('21dedf30-ee7a-4833-9677-026f808f7cb0','d4cde3a3-472b-4ae6-8b74-864a4fb633c5','99fb9b38-275e-4b37-a18f-07b31fa73711'),('21df05d9-5343-4743-95a5-26e077aaa8df','425b4463-4470-4ae3-abf5-d916da09f71c','cbb267e8-8cb0-4273-9352-7dce3bb1381e'),('2495a464-2dc8-4099-9fe2-6e56536497bc','d4cde3a3-472b-4ae6-8b74-864a4fb633c5','df012ba6-a6d3-4afe-b2bc-622bf218893f'),('26f23926-4d67-49dc-8887-3a8fa9a7e71e','c8ecfeab-868c-4fcc-b260-a2aaebc4e21a','8809898e-b183-48bb-8f31-5f588954c038'),('2bdcaeff-30e1-4788-9f62-74de838bab13','d4cde3a3-472b-4ae6-8b74-864a4fb633c5','de95fcac-e864-49a8-80f1-bb15e46d6a3e'),('2c2c1904-09b8-4edf-9728-bb6b7f707a6c','d4cde3a3-472b-4ae6-8b74-864a4fb633c5','166342c8-9863-46b6-a471-79f4634b787e'),('2ece266c-a5aa-41b4-b7cb-302fb4d67f7e','893bead6-f637-449e-af0c-22e1cac7ef03','8809898e-b183-48bb-8f31-5f588954c038'),('32cbe1de-a22c-4f7e-9a7f-f78bd7e0f8c2','893bead6-f637-449e-af0c-22e1cac7ef03','18b5b7c9-df0c-45d3-8d61-5eedca17e04e'),('369a3c5d-eaaa-49af-b0ca-bb60a95fd042','d4cde3a3-472b-4ae6-8b74-864a4fb633c5','55483301-1c90-4fd7-80d4-80268c3cf7eb'),('377b822d-6c65-4101-8b8e-8573da164d18','d4cde3a3-472b-4ae6-8b74-864a4fb633c5','49b3987a-8afb-467f-acde-7979121e8055'),('37afdc53-bf1d-4af0-94bc-f4c2dde20712','e5490a87-2248-47ec-aa79-5cf06fabf35f','1763ddbe-cbbd-4b7f-a900-ad31669a03db'),('38926e4c-9195-4e1e-bf8f-ef9d0a870f37','e5490a87-2248-47ec-aa79-5cf06fabf35f','1e146943-bdc1-4af4-b833-4dbcb147fb42'),('397b25b1-d6c9-4ea9-9f8a-cb7e9165a0a7','bf86fd0c-c372-4b81-86a7-3340a7c61090','463ad545-254d-4fdb-ba2f-2a472a28b513'),('3afa0661-c2cf-46e3-8771-1782281af73e','e5490a87-2248-47ec-aa79-5cf06fabf35f','9e3cfaf5-259a-45cc-9990-9f3c955c1ef9'),('3b20e1dd-5e71-4b45-a03e-07b2115514f5','834c2722-be2f-4d7c-b3e4-879371ae6069','99fb9b38-275e-4b37-a18f-07b31fa73711'),('3bde1d37-f846-4e1f-bdd7-dca7806c73dc','d4cde3a3-472b-4ae6-8b74-864a4fb633c5','64c4a6c1-3867-4463-bc04-0af76e6d9c6b'),('3c63e55f-c5e1-42c8-abbf-6de7f79c47e0','425b4463-4470-4ae3-abf5-d916da09f71c','12491e52-044c-4392-b042-76a94e2ca9b9'),('3d783d39-6366-4239-9e61-7d203cb5cde2','893bead6-f637-449e-af0c-22e1cac7ef03','fd856a36-2e40-4c39-848a-8ed64c8796a8'),('415d5a8b-a988-4d3d-8a43-0023a9733ac5','834c2722-be2f-4d7c-b3e4-879371ae6069','16c0a971-8f05-4d9d-bf65-a83b67b32eb6'),('4245b580-bc05-4fdd-bd0b-21b947daab0e','e5490a87-2248-47ec-aa79-5cf06fabf35f','36d257ad-42e4-4898-a7ed-279753ff416a'),('42c5df14-f13a-450f-92f9-eb9155014666','893bead6-f637-449e-af0c-22e1cac7ef03','4489e35c-54aa-46ae-b52e-a121b357d075'),('42e81bc4-f14b-4810-912d-aafcf40609c6','c8ecfeab-868c-4fcc-b260-a2aaebc4e21a','36eb854b-e351-4579-8e1f-dfc5e4f586d8'),('44b4552e-8af0-43b1-bf48-ec8b060cb7ee','893bead6-f637-449e-af0c-22e1cac7ef03','5a3c1989-a9b1-4068-b62d-0475d7462288'),('463b3070-ade8-4b9f-ba5a-edd121ac81ce','425b4463-4470-4ae3-abf5-d916da09f71c','c798b55e-c044-461a-a2f5-18180807772d'),('4899571d-272b-4c04-a981-7fa8b4ea2a0d','e5490a87-2248-47ec-aa79-5cf06fabf35f','1661317f-e60b-4f3d-9096-bb7ebdf5f889'),('4b70dcb4-348c-40fa-ae12-d72c49b305b2','893bead6-f637-449e-af0c-22e1cac7ef03','ec912a8d-51db-4402-8b8f-71bd97db8e54'),('4bef3088-e205-4663-8f93-99bd48386d42','1','6f4eea7e-8be0-4ece-b8d5-1f150b6cdc2e'),('4d48773b-022e-41d1-a6a0-012667cc86f6','c8ecfeab-868c-4fcc-b260-a2aaebc4e21a','ea3485ba-6da1-47b3-a72b-19dbc6f53872'),('4f29dada-62f5-4329-97ba-00b6560fdae0','893bead6-f637-449e-af0c-22e1cac7ef03','75e6b685-085c-4031-93fb-108c072f9bfb'),('53c004b0-f82c-4f4d-be3f-f7883462ac2d','e5490a87-2248-47ec-aa79-5cf06fabf35f','872c45b6-35ef-48aa-ab62-9aae1731f01c'),('55884608-010a-4f52-9c37-c215f225265b','834c2722-be2f-4d7c-b3e4-879371ae6069','49b3987a-8afb-467f-acde-7979121e8055'),('56494a6d-9dd1-43d6-9781-145e6d99f533','834c2722-be2f-4d7c-b3e4-879371ae6069','6e611d01-07ba-429b-8327-b1296b44129c'),('5a5d2369-05df-44c7-8a47-a3776549a669','1','aa70692d-a093-4035-9165-4796eb6aa7ff'),('5b2dc6c3-1529-4530-bdb9-901665993f82','7951ea6f-7a4e-4007-8b77-a69daa5b9c0a','de95fcac-e864-49a8-80f1-bb15e46d6a3e'),('5d084a2a-60d3-4dc1-9f99-8fcd7c600ba5','e5490a87-2248-47ec-aa79-5cf06fabf35f','08797b4f-2418-4eeb-9a79-6bb557de57db'),('5e8b85b3-d7fb-4d8e-ad43-fd1b45a0f6de','893bead6-f637-449e-af0c-22e1cac7ef03','9b7be628-9dc3-43e7-814a-2f49991e9f41'),('5fe73c24-7fd3-4846-82d4-06a8362a8345','e5490a87-2248-47ec-aa79-5cf06fabf35f','c2a6fc6d-5a81-405b-bd3c-5794eb0a93ee'),('613c400d-32d4-4c31-b929-8b86beb1da54','425b4463-4470-4ae3-abf5-d916da09f71c','aa70692d-a093-4035-9165-4796eb6aa7ff'),('61fc09d8-c3cd-4638-9ea6-9ed3f72af929','425b4463-4470-4ae3-abf5-d916da09f71c','4418db2c-2877-4adc-b056-8f417fe0d594'),('622ea2bf-9add-4d38-8060-d31d5537d646','834c2722-be2f-4d7c-b3e4-879371ae6069','f42584d8-145b-4bcf-b9c1-50aa890f0529'),('6273d1f2-8049-4a80-8c2a-60d747a8aa13','834c2722-be2f-4d7c-b3e4-879371ae6069','166342c8-9863-46b6-a471-79f4634b787e'),('6356e672-eb24-49e5-8133-60e6c9da95d3','425b4463-4470-4ae3-abf5-d916da09f71c','5689da3f-7dfc-42d9-abee-caab7008960e'),('645540bb-655e-4cdd-95fd-85e30717210a','e5490a87-2248-47ec-aa79-5cf06fabf35f','26a188ed-78ee-48dd-bba2-1ee7d8b014a0'),('64ad7281-be9e-4596-9f78-b8999dcd1c82','425b4463-4470-4ae3-abf5-d916da09f71c','6f4eea7e-8be0-4ece-b8d5-1f150b6cdc2e'),('65787af4-d268-4261-b394-56c726544274','c8ecfeab-868c-4fcc-b260-a2aaebc4e21a','28f295bb-c8cc-4016-a3ee-c069be72de2a'),('6665eeae-9de8-4a36-bb5d-34bd1b5ee215','e5490a87-2248-47ec-aa79-5cf06fabf35f','7f8f55e2-5dd2-4790-afa3-8264dadec43e'),('6822423f-fa19-4daa-8bb5-767e42cb4203','e5490a87-2248-47ec-aa79-5cf06fabf35f','0fc497c1-57b7-4e70-b4f2-39bdf0d8f7f9'),('6da7033b-0d16-41fc-a386-b9c4ac16e892','425b4463-4470-4ae3-abf5-d916da09f71c','d59e7277-228e-4235-8123-9a474c4e21a2'),('6e1d5cc8-50d2-4f84-a316-d7a2fb8c5f94','e5490a87-2248-47ec-aa79-5cf06fabf35f','f415d1df-9178-4042-a1f4-ba8db54b9e24'),('6e7ec27e-2af8-4976-8f1b-37f1465adf2b','834c2722-be2f-4d7c-b3e4-879371ae6069','aeedbffd-e7d2-4caa-8f57-4c62cca32a4f'),('6f448778-f363-42f5-85d5-93367b081f9a','1','12491e52-044c-4392-b042-76a94e2ca9b9'),('7080744e-0733-4141-bc46-4fd216a7ffeb','bf86fd0c-c372-4b81-86a7-3340a7c61090','5ca771ed-0550-4587-8813-82ad11efb7c5'),('708528d9-dd0b-4cc1-91d2-f31093bb4969','425b4463-4470-4ae3-abf5-d916da09f71c','5643512f-9b04-40e6-accb-986a1388dbd6'),('71823ae0-6ce1-43fc-9d3b-af5ac0e1098f','425b4463-4470-4ae3-abf5-d916da09f71c','05e17d87-e3ac-43f7-b486-2dd07f895ed2'),('72e8b7e9-3910-45c8-a667-d1dc592ebd7d','893bead6-f637-449e-af0c-22e1cac7ef03','bbf76355-e2aa-45f9-bb82-24947e1a4d63'),('73bfb643-913e-4b30-8c1a-f187963b4618','893bead6-f637-449e-af0c-22e1cac7ef03','f380dbe5-3a3d-40b0-8f0a-8236453b43ad'),('73fb70f1-0c31-4093-877a-a4d28a63618e','425b4463-4470-4ae3-abf5-d916da09f71c','d1680696-7b3b-419e-a36e-0a15623b9f6f'),('7462f029-84ac-475f-8121-f9b8d61816dd','834c2722-be2f-4d7c-b3e4-879371ae6069','c1bddbe2-b908-45af-8e5a-257012c03dae'),('77cdd7b0-5363-43ad-969a-e15b189810fa','d4cde3a3-472b-4ae6-8b74-864a4fb633c5','87ce834d-57dd-4532-bf9b-95ae567463ff'),('7a0a13ea-358a-417b-a60b-8a2288f497c7','e5490a87-2248-47ec-aa79-5cf06fabf35f','7af09a26-88c2-449f-9d8f-41038ccb84b2'),('7a9c5def-ffae-46ad-865d-5c8ff18c2e81','425b4463-4470-4ae3-abf5-d916da09f71c','a5a969bd-169d-4fc9-9985-cf74125c2e85'),('7aa2ca68-845a-40ab-bb66-e673ebaf68cb','e5490a87-2248-47ec-aa79-5cf06fabf35f','c1bddbe2-b908-45af-8e5a-257012c03dae'),('7b9ff083-bc7d-431a-b725-8130a99bb8c0','e5490a87-2248-47ec-aa79-5cf06fabf35f','48dd6386-d0cd-49b3-b07e-b1c9ee4bc055'),('7d3b7775-15d1-4ef3-9779-50b4aa9dd88d','e5490a87-2248-47ec-aa79-5cf06fabf35f','e35cc053-9054-4e1b-83d7-5ad56625c97c'),('7ea0f1ba-e645-484e-98d4-6100f1febe2c','425b4463-4470-4ae3-abf5-d916da09f71c','da982bf1-ba0b-4a9b-8a41-1951ebe05a72'),('7faaeac1-6f1e-4f4c-a965-d35cc21aa4b2','834c2722-be2f-4d7c-b3e4-879371ae6069','99273217-1de1-483a-99b5-bef997a6bbf0'),('7fdc3d27-97a0-4e61-9fae-5854ae29b20c','e5490a87-2248-47ec-aa79-5cf06fabf35f','7af1a041-e25d-4ba3-9a5b-089cc59f108e'),('8063e138-4b08-41e7-8c74-ae0fc8e670d4','425b4463-4470-4ae3-abf5-d916da09f71c','5643512f-9b04-40e6-accb-986a1388dbd6'),('80706c8a-f35b-4e37-ad88-111d4c864684','834c2722-be2f-4d7c-b3e4-879371ae6069','87ce834d-57dd-4532-bf9b-95ae567463ff'),('81aa5bf0-1623-49e7-889a-724a52d3e174','d4cde3a3-472b-4ae6-8b74-864a4fb633c5','32b78004-6e3f-495f-ab7d-7a1195b0aabb'),('82e73599-4091-47f4-8ebc-98f13d729e47','d4cde3a3-472b-4ae6-8b74-864a4fb633c5','1763ddbe-cbbd-4b7f-a900-ad31669a03db'),('83cad7fe-1cc4-4bf5-9c18-346ac02e9161','d4cde3a3-472b-4ae6-8b74-864a4fb633c5','d1680696-7b3b-419e-a36e-0a15623b9f6f'),('85926a75-00d7-4924-8426-acee43520d93','425b4463-4470-4ae3-abf5-d916da09f71c','a1d84d37-cffe-4117-91b1-c9c6bebd8d89'),('8677d112-6b72-41d1-a634-c9a8614187a8','834c2722-be2f-4d7c-b3e4-879371ae6069','da982bf1-ba0b-4a9b-8a41-1951ebe05a72'),('87b00eba-1c94-4158-a7ec-67c4e4b69273','e5490a87-2248-47ec-aa79-5cf06fabf35f','d05ceec0-7f6a-4517-abd4-b25164103499'),('8a469461-c973-4437-b561-f92944db6c55','e5490a87-2248-47ec-aa79-5cf06fabf35f','8d1bc4e7-cd83-4a23-ae3e-36ea8a185958'),('8a9af78e-a9dc-4a20-bece-b5cfd16ed6b1','e5490a87-2248-47ec-aa79-5cf06fabf35f','e33c7c00-437a-4f96-ac3c-2d5be9f81f94'),('8b607ffc-737b-4eef-a8ed-7addbcdf47a3','893bead6-f637-449e-af0c-22e1cac7ef03','28f295bb-c8cc-4016-a3ee-c069be72de2a'),('8dafa819-1469-4d0d-a27c-075d56e1db75','e5490a87-2248-47ec-aa79-5cf06fabf35f','e42d3c1d-c4dc-4ad0-a7f4-d24d885f10e0'),('922b3362-d633-4122-ad60-214077065baa','d4cde3a3-472b-4ae6-8b74-864a4fb633c5','77a552c0-f045-468e-a0a2-f4caf2c989d2'),('957c0b95-40d3-4234-91b7-1710369a8fc5','834c2722-be2f-4d7c-b3e4-879371ae6069','d9c64009-e9f4-450e-b193-3194c5eeeb59'),('95a9aafa-3f62-4152-be3d-7391bb614140','425b4463-4470-4ae3-abf5-d916da09f71c','d9c64009-e9f4-450e-b193-3194c5eeeb59'),('9609c3bc-f734-4128-b643-f96a0a099539','e5490a87-2248-47ec-aa79-5cf06fabf35f','f1a404cd-4b0c-4be9-bc7d-80d8594059fb'),('96c50328-28b7-46ea-b639-0e7e623fdbf5','e5490a87-2248-47ec-aa79-5cf06fabf35f','7d573014-556a-48d0-9d1a-150e412ebfa4'),('9735665c-88d0-496d-a610-9895626e74ef','425b4463-4470-4ae3-abf5-d916da09f71c','4418db2c-2877-4adc-b056-8f417fe0d594'),('981ca3b8-aca2-4ae6-b5c9-295999a418d9','e5490a87-2248-47ec-aa79-5cf06fabf35f','04e480dc-5cfd-4580-b145-2d608f3dbb12'),('99410059-ee38-4446-8e75-e491031cf71f','e5490a87-2248-47ec-aa79-5cf06fabf35f','2ae2529e-ca35-47c9-84ae-e0346d01d700'),('9c06f059-e7ea-4c1e-b621-f95da481da9f','e5490a87-2248-47ec-aa79-5cf06fabf35f','4c592edf-b5aa-4fe3-804a-318daf9a87c0'),('9d4bbb57-afe3-417e-ab7c-456c9ed4b81b','d4cde3a3-472b-4ae6-8b74-864a4fb633c5','a5a969bd-169d-4fc9-9985-cf74125c2e85'),('a172304d-e670-46e2-bb8d-418023e679b5','425b4463-4470-4ae3-abf5-d916da09f71c','d1680696-7b3b-419e-a36e-0a15623b9f6f'),('a32dee27-f0dc-4e5c-af4d-1c2ff1e5efbc','d4cde3a3-472b-4ae6-8b74-864a4fb633c5','99273217-1de1-483a-99b5-bef997a6bbf0'),('a355a2fa-cf98-499d-896d-30487b10f12c','e5490a87-2248-47ec-aa79-5cf06fabf35f','bfd358d7-dcde-4ee7-b4b7-9472a0d39789'),('a3ac3195-52eb-44bb-81c8-ac14f315e2b7','d4cde3a3-472b-4ae6-8b74-864a4fb633c5','f42584d8-145b-4bcf-b9c1-50aa890f0529'),('a78c9bde-860e-48b2-aa67-c4102f3ca605','425b4463-4470-4ae3-abf5-d916da09f71c','da982bf1-ba0b-4a9b-8a41-1951ebe05a72'),('a849e7b9-020e-4aac-8d7c-bec62feb3d64','e5490a87-2248-47ec-aa79-5cf06fabf35f','ae4f5e7d-0313-451d-b2be-2f4e579b565d'),('a8851fd3-034d-4dd9-806a-6fce0583f6a0','425b4463-4470-4ae3-abf5-d916da09f71c','12491e52-044c-4392-b042-76a94e2ca9b9'),('ab061237-56e3-4d4d-b244-5d7bcb424720','d4cde3a3-472b-4ae6-8b74-864a4fb633c5','6e611d01-07ba-429b-8327-b1296b44129c'),('ab06cbbc-0387-4531-8341-7c1a7573b71b','bf86fd0c-c372-4b81-86a7-3340a7c61090','b3d3f6f6-a72e-4884-a8c8-5f716fdc1a66'),('ab7f31a2-6d94-4f51-9a8c-960df50013d4','893bead6-f637-449e-af0c-22e1cac7ef03','de95fcac-e864-49a8-80f1-bb15e46d6a3e'),('ac5a11e8-c61b-4d31-bf6c-5583fda26d4c','893bead6-f637-449e-af0c-22e1cac7ef03','651461b6-4c69-4622-a3aa-7f7de335a971'),('ad5ea724-f907-4d60-87b9-bd7ba31ea3aa','d4cde3a3-472b-4ae6-8b74-864a4fb633c5','daf209cc-2748-46aa-902e-ec5327260f04'),('ad63afda-515a-4b12-8f7d-ee775a7d7961','e5490a87-2248-47ec-aa79-5cf06fabf35f','253a71b1-a9fb-42cf-9ade-b53ca6a8816d'),('ae89be93-c4d1-4651-a1a1-7e680c6096de','425b4463-4470-4ae3-abf5-d916da09f71c','5689da3f-7dfc-42d9-abee-caab7008960e'),('af74d1e2-68c4-44b0-a29e-78f7d9b2bd8e','834c2722-be2f-4d7c-b3e4-879371ae6069','31ed1d60-9f82-4b8a-ac7a-e186e3a28321'),('b0ce418e-37f4-4e78-9c00-891de4011bb4','425b4463-4470-4ae3-abf5-d916da09f71c','aa70692d-a093-4035-9165-4796eb6aa7ff'),('b58e2ee3-5307-41da-994a-df90e88af825','834c2722-be2f-4d7c-b3e4-879371ae6069','daf209cc-2748-46aa-902e-ec5327260f04'),('b5fc7a5a-e00c-49f0-82a2-8e44fd28e631','e5490a87-2248-47ec-aa79-5cf06fabf35f','e33397d3-6fae-4177-90fc-59bde8522f62'),('b9605f02-ca2b-42ea-b033-8f60b7c945b1','c8ecfeab-868c-4fcc-b260-a2aaebc4e21a','ec912a8d-51db-4402-8b8f-71bd97db8e54'),('ba186f6b-ccc3-4b3e-9dcd-f3fbc6a88ae9','e5490a87-2248-47ec-aa79-5cf06fabf35f','8809898e-b183-48bb-8f31-5f588954c038'),('bb522e71-70b3-43d7-85d1-a9757176a066','834c2722-be2f-4d7c-b3e4-879371ae6069','64c4a6c1-3867-4463-bc04-0af76e6d9c6b'),('bbc59021-3d8f-4028-997a-ef7529bffac7','e5490a87-2248-47ec-aa79-5cf06fabf35f','d21c7ea9-ea2e-4729-a5dd-488d57c54d6c'),('bbded931-465d-4fd5-b81d-42e11b350c27','893bead6-f637-449e-af0c-22e1cac7ef03','36eb854b-e351-4579-8e1f-dfc5e4f586d8'),('bc8b4a6e-0598-4349-8461-654d8031f4e6','425b4463-4470-4ae3-abf5-d916da09f71c','a5a969bd-169d-4fc9-9985-cf74125c2e85'),('bf3b01cc-f930-4b85-bb13-0bd56cc86079','893bead6-f637-449e-af0c-22e1cac7ef03','8c3264b0-fa00-47bf-a0ba-23d1a492df5d'),('c118b5b6-3181-4eab-b9f4-608341feaa39','e5490a87-2248-47ec-aa79-5cf06fabf35f','49312778-08c2-4b6c-9a30-11dedbcc6ffe'),('c2f27448-c2be-424d-bd34-fe74e8ccc72f','893bead6-f637-449e-af0c-22e1cac7ef03','7e0e549c-4ef4-4b94-ae1f-829696a3e049'),('c3749dfb-b526-40d6-a72b-b412e06243d1','c8ecfeab-868c-4fcc-b260-a2aaebc4e21a','7e0e549c-4ef4-4b94-ae1f-829696a3e049'),('c398d608-67b6-439c-b576-3cb664fdbec4','e5490a87-2248-47ec-aa79-5cf06fabf35f','adea69f5-5d59-4629-b534-8e114af9c06a'),('c3d381f9-eb74-44b3-a476-a75f7b8a42d9','425b4463-4470-4ae3-abf5-d916da09f71c','1a4802cd-b5ee-4e6d-a57f-9c0fd0c6b3a5'),('c5201db2-bed1-4432-b375-afbfd0797e28','d4cde3a3-472b-4ae6-8b74-864a4fb633c5','4418db2c-2877-4adc-b056-8f417fe0d594'),('c5b99690-b1f7-4db4-9d8e-572869ba02d3','d4cde3a3-472b-4ae6-8b74-864a4fb633c5','5643512f-9b04-40e6-accb-986a1388dbd6'),('c5cf5d01-1446-4100-94dc-2e9e879da4b5','e5490a87-2248-47ec-aa79-5cf06fabf35f','93593dba-f3ab-4c12-bf6c-252a84007278'),('c64c093a-116e-430a-b18b-d2f1db62356c','425b4463-4470-4ae3-abf5-d916da09f71c','05e17d87-e3ac-43f7-b486-2dd07f895ed2'),('c76e3ce0-dfba-4266-b8ab-bdff5da9cc12','893bead6-f637-449e-af0c-22e1cac7ef03','e35cc053-9054-4e1b-83d7-5ad56625c97c'),('c8b81d76-cbf3-4603-bed6-88818420d8a0','d4cde3a3-472b-4ae6-8b74-864a4fb633c5','7d573014-556a-48d0-9d1a-150e412ebfa4'),('c9306a97-4cda-4409-b3ce-4682004a6a53','425b4463-4470-4ae3-abf5-d916da09f71c','c798b55e-c044-461a-a2f5-18180807772d'),('ca392eb7-57d8-4eed-8912-84d352b9249e','834c2722-be2f-4d7c-b3e4-879371ae6069','7fa1fe2d-870a-456f-a22a-65043022580b'),('ce613cf4-d63d-4187-ac89-4af3e081260a','e5490a87-2248-47ec-aa79-5cf06fabf35f','ec912a8d-51db-4402-8b8f-71bd97db8e54'),('cf3f90ac-20a9-4a90-9346-2ab9a7dd8400','834c2722-be2f-4d7c-b3e4-879371ae6069','32b78004-6e3f-495f-ab7d-7a1195b0aabb'),('cf49f285-76e6-4995-8702-ceaabe127cc7','893bead6-f637-449e-af0c-22e1cac7ef03','e33397d3-6fae-4177-90fc-59bde8522f62'),('d11059f9-fd64-4cb7-b3b1-4d08e89c7904','c8ecfeab-868c-4fcc-b260-a2aaebc4e21a','2ada72b4-6b7e-4f96-8a08-89b2b116c523'),('d22d5e86-e7ab-4de5-bfdd-bb73aaa06265','e5490a87-2248-47ec-aa79-5cf06fabf35f','072aad32-2940-4f55-8095-0f987cb4ac3f'),('d39e945b-f591-433a-8300-54815b1f8b45','425b4463-4470-4ae3-abf5-d916da09f71c','d0c1e1ec-194a-478a-8226-59e844544c5c'),('d4c3d892-2c78-4768-8492-9a3abf664efa','d4cde3a3-472b-4ae6-8b74-864a4fb633c5','d59e7277-228e-4235-8123-9a474c4e21a2'),('d6e6b082-728e-4ae7-b151-3755221417c2','e5490a87-2248-47ec-aa79-5cf06fabf35f','f380dbe5-3a3d-40b0-8f0a-8236453b43ad'),('d7816b6b-a8a6-4bff-9955-5275b4cfd046','e5490a87-2248-47ec-aa79-5cf06fabf35f','d3a8d102-957c-413f-9626-d5d605d4097f'),('d803c812-d7aa-4824-ade1-2cb6ae97e187','e5490a87-2248-47ec-aa79-5cf06fabf35f','fb6b21fb-fe10-4c09-81b7-9787d2fa4493'),('d80b5737-e951-4081-84a4-e09d9a53d6cf','d4cde3a3-472b-4ae6-8b74-864a4fb633c5','16c0a971-8f05-4d9d-bf65-a83b67b32eb6'),('e07ae095-8ebc-4092-9969-3bf4109025ba','425b4463-4470-4ae3-abf5-d916da09f71c','d59e7277-228e-4235-8123-9a474c4e21a2'),('e0ea793c-86a0-4758-a925-7c51daf57d3a','e5490a87-2248-47ec-aa79-5cf06fabf35f','194c2e71-bb43-4776-964a-907bc9686a0a'),('e2252949-d286-4077-b25c-22f00db91987','e5490a87-2248-47ec-aa79-5cf06fabf35f','7a280c7a-a8ee-43d5-bcfc-a10f9d422087'),('e2335677-9e15-42bd-ae17-2ca39bf43612','834c2722-be2f-4d7c-b3e4-879371ae6069','1763ddbe-cbbd-4b7f-a900-ad31669a03db'),('e41da38d-6b96-4d01-bfbe-2e8e16ad88f1','c8ecfeab-868c-4fcc-b260-a2aaebc4e21a','de95fcac-e864-49a8-80f1-bb15e46d6a3e'),('e4ec4cd7-bf4d-4cfe-8751-b7de98ff3b2f','d4cde3a3-472b-4ae6-8b74-864a4fb633c5','8809898e-b183-48bb-8f31-5f588954c038'),('e6ecb0ce-3dd6-434a-baef-1d0b74571a66','d4cde3a3-472b-4ae6-8b74-864a4fb633c5','c1bddbe2-b908-45af-8e5a-257012c03dae'),('e9e3325e-63a5-4f4d-8114-0210a95ffa98','425b4463-4470-4ae3-abf5-d916da09f71c','cbb267e8-8cb0-4273-9352-7dce3bb1381e'),('f09c3731-7c08-4f46-9b19-21d6d1288ab6','893bead6-f637-449e-af0c-22e1cac7ef03','d96bc92b-4ea5-4675-be2c-43f609d60185'),('f0f25a8e-4aac-4f18-9d12-6357e7f90409','d4cde3a3-472b-4ae6-8b74-864a4fb633c5','aeedbffd-e7d2-4caa-8f57-4c62cca32a4f'),('f22b2f10-6f2e-4f41-8b04-c8ea6f9ffd21','425b4463-4470-4ae3-abf5-d916da09f71c','77449a48-5c4a-4105-849f-a10269421f5d'),('f3bcdeb9-37fe-41ca-9a0e-f500890c8caa','e5490a87-2248-47ec-aa79-5cf06fabf35f','91b87083-1b56-4697-a3e9-9057ee46e89f'),('f50142b4-956f-4ca2-96d2-eceab73c92b8','e5490a87-2248-47ec-aa79-5cf06fabf35f','ef0e20ad-75a2-458f-b235-bb4c6107a955'),('f86d8455-64f3-46f9-9faf-180bfce6b72d','e5490a87-2248-47ec-aa79-5cf06fabf35f','dd5ffebd-5837-4f67-9bbe-4b434c61ee82'),('f8ee288e-8ad4-440c-b00c-11c1701cd6bd','d4cde3a3-472b-4ae6-8b74-864a4fb633c5','31ed1d60-9f82-4b8a-ac7a-e186e3a28321'),('fbe9cc9d-caa8-4593-bd3d-f1bce6fa1633','834c2722-be2f-4d7c-b3e4-879371ae6069','77a552c0-f045-468e-a0a2-f4caf2c989d2'),('fc3300dd-cafd-4f30-8c3b-6710d9648297','425b4463-4470-4ae3-abf5-d916da09f71c','d9c64009-e9f4-450e-b193-3194c5eeeb59'),('fe309839-9c7a-4d01-8741-eaf8e529e1a5','834c2722-be2f-4d7c-b3e4-879371ae6069','c798b55e-c044-461a-a2f5-18180807772d'),('fec6a4fb-09d6-4dab-ac05-634c0dbc6d6e','834c2722-be2f-4d7c-b3e4-879371ae6069','7d573014-556a-48d0-9d1a-150e412ebfa4'),('ff31124b-092f-4383-b837-7d886d301324','d4cde3a3-472b-4ae6-8b74-864a4fb633c5','05e17d87-e3ac-43f7-b486-2dd07f895ed2');

/*Table structure for table `manage_role` */

DROP TABLE IF EXISTS `manage_role`;

CREATE TABLE `manage_role` (
  `ICODE` varchar(100) NOT NULL,
  `FULLNAME` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ICODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `manage_role` */

insert  into `manage_role`(`ICODE`,`FULLNAME`) values ('425b4463-4470-4ae3-abf5-d916da09f71c','超级管理员'),('d4cde3a3-472b-4ae6-8b74-864a4fb633c5','管理员'),('e5490a87-2248-47ec-aa79-5cf06fabf35f','销售总部');

/*Table structure for table `manage_user` */

DROP TABLE IF EXISTS `manage_user`;

CREATE TABLE `manage_user` (
  `ICODE` varchar(100) NOT NULL,
  `NO` varchar(100) DEFAULT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  `PHONE` varchar(100) DEFAULT NULL,
  `EMAIL` varchar(100) DEFAULT NULL,
  `STOPFLAG` int(11) DEFAULT NULL,
  `LOGINNAME` varchar(100) DEFAULT NULL,
  `PASSWORD` varchar(100) DEFAULT NULL,
  `AREAICODE` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ICODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `manage_user` */

insert  into `manage_user`(`ICODE`,`NO`,`NAME`,`PHONE`,`EMAIL`,`STOPFLAG`,`LOGINNAME`,`PASSWORD`,`AREAICODE`) values ('1',NULL,'管理员',NULL,NULL,NULL,'admin','123456','1'),('491a5774-774d-4758-9b35-53ec1ab382f8','','李四','','ww',0,'lisi','123456','1'),('fab9ff72-159a-4474-8431-4b2976434e14',NULL,'张三',NULL,NULL,0,'zhangsan','123456','1');

/*Table structure for table `manage_user_role` */

DROP TABLE IF EXISTS `manage_user_role`;

CREATE TABLE `manage_user_role` (
  `ICODE` varchar(100) NOT NULL,
  `USERICODE` varchar(100) DEFAULT NULL,
  `ROLEICODE` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ICODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `manage_user_role` */

insert  into `manage_user_role`(`ICODE`,`USERICODE`,`ROLEICODE`) values ('04d269b1-5353-4a39-9f07-391dbb0d9da9','de7d9239-9d7f-488c-ae56-c31880917ff2','893bead6-f637-449e-af0c-22e1cac7ef03'),('1cd59b20-a60a-4b64-b405-f72646e50743','9d2d8d30-34e6-4e96-ab7f-32e50871f49b','893bead6-f637-449e-af0c-22e1cac7ef03'),('2600a34c-c552-4c9f-a883-a0a897269e69','938920bb-fb00-461c-9acc-78e37b72fa85','c8ecfeab-868c-4fcc-b260-a2aaebc4e21a'),('2a4dded4-de74-4552-9163-6528ca276445','0d8e2bcc-1a2d-4073-8956-f9f93c64e283','c8ecfeab-868c-4fcc-b260-a2aaebc4e21a'),('32d0e009-15bf-4db8-9cf8-b4ce562a32c1','fab9ff72-159a-4474-8431-4b2976434e14','e5490a87-2248-47ec-aa79-5cf06fabf35f'),('3869861a-ee35-47ef-a53c-426d35214976','20c148ae-b662-4854-998d-e52391f8e43f','425b4463-4470-4ae3-abf5-d916da09f71c'),('42aafae6-97ff-4fc4-9811-bba48e84d76c','8b0e78c3-7da1-4400-b517-162be94a0f60','893bead6-f637-449e-af0c-22e1cac7ef03'),('52e016df-32d9-4a6e-bbd9-4c920f0f14de','fad2a764-5cbd-4882-afb1-21788a3c0247','893bead6-f637-449e-af0c-22e1cac7ef03'),('5810583d-9488-4ab4-afd2-d143cf194bb6','05f9ac3e-f9bb-440f-bc27-61fc6a9afbf5','893bead6-f637-449e-af0c-22e1cac7ef03'),('6cd3d432-5468-4fb9-b3b1-7233d37abe75','de5ef4be-e807-40bc-b334-4abb462e347e','e5490a87-2248-47ec-aa79-5cf06fabf35f'),('828f1c86-674b-4e3c-8c22-06d47f378f5b','940257a6-db71-4189-aa09-f0391486f873','e5490a87-2248-47ec-aa79-5cf06fabf35f'),('86b9e3cb-5578-49c8-b2e0-614c99ddfe2b','706fec37-c1f9-478c-b056-7f37e02c8201','7951ea6f-7a4e-4007-8b77-a69daa5b9c0a'),('8afae9c6-c92f-45e8-8777-fd8b66c89ce1','6d8d034c-424b-4046-a208-435f2d05b32a','834c2722-be2f-4d7c-b3e4-879371ae6069'),('a28e28b9-83da-4e2a-ab58-460829ba5a7b','43f4deaf-bad8-4495-8b31-7ccbb7ad9414','893bead6-f637-449e-af0c-22e1cac7ef03'),('a32d8257-b96f-4bf1-8c96-a8b9c01419f0','b9e45f7c-6329-496c-b2c7-0b1edae3a226','834c2722-be2f-4d7c-b3e4-879371ae6069'),('cecb414f-dadb-49a5-8bee-b3248e4a9971','0fd553b5-d93b-499a-b479-8044e0d398b4','893bead6-f637-449e-af0c-22e1cac7ef03'),('f0a7aacf-588d-4518-b185-354f87817891','1','d4cde3a3-472b-4ae6-8b74-864a4fb633c5'),('f2f19693-fc76-4f6c-8e67-a9300f7cf736','66d03665-5941-4d65-91cd-49a85601aeea','893bead6-f637-449e-af0c-22e1cac7ef03'),('f7c63f74-72a4-490d-a891-906354db72cf','4d2ce297-9bd3-4545-ab2b-fe54acca7965','893bead6-f637-449e-af0c-22e1cac7ef03'),('f9be54dc-d345-4935-854c-cbf2a00dd18c','269e60ff-619b-475b-8b26-c8508bcba9a4','893bead6-f637-449e-af0c-22e1cac7ef03');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` varchar(100) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `pwd` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`pwd`) values ('1','芹泽','520');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;