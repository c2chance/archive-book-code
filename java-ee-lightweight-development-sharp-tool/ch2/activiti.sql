/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.6.23-log : Database - activiti
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`activiti` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `activiti`;

/*Table structure for table `act_evt_log` */

DROP TABLE IF EXISTS `act_evt_log`;

CREATE TABLE `act_evt_log` (
  `LOG_NR_` bigint(20) NOT NULL AUTO_INCREMENT,
  `TYPE_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TIME_STAMP_` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DATA_` longblob,
  `LOCK_OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `LOCK_TIME_` timestamp(3) NULL DEFAULT NULL,
  `IS_PROCESSED_` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`LOG_NR_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_evt_log` */

/*Table structure for table `act_ge_bytearray` */

DROP TABLE IF EXISTS `act_ge_bytearray`;

CREATE TABLE `act_ge_bytearray` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DEPLOYMENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `BYTES_` longblob,
  `GENERATED_` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_BYTEARR_DEPL` (`DEPLOYMENT_ID_`),
  CONSTRAINT `ACT_FK_BYTEARR_DEPL` FOREIGN KEY (`DEPLOYMENT_ID_`) REFERENCES `act_re_deployment` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ge_bytearray` */

insert  into `act_ge_bytearray`(`ID_`,`REV_`,`NAME_`,`DEPLOYMENT_ID_`,`BYTES_`,`GENERATED_`) values ('2502',1,'diagrams/HelloWorld.png','2501','�PNG\r\n\Z\n\0\0\0\rIHDR\0\0�\0\0|\0\0\0�\nݸ\0\0 rIDATx���ol[W����T�1Hē�~\0��&���S��H�,1-����jbL�����Q�1u��FSZK�FX�Jڅ6M����6��4��si��&v|~\'�ݭ�?�v�듓�~��q��g��u�$\0\0\rפ�\0��_\0P��\0_\0P��\0_\0P��\0_\0P��\0_\0P��\0_\0P��\0_\0P��\0_\0P��\0_\0P��\0_\0P��\0_\0P��\0_\0P��\0_\0P��\0_\0P��\0_\0P��\0_\0P��\0_\0P��\0_\0P��\0_\0P��\0_�nÈ���ׯ�B���A�L,K�Ӫ/��ԁ�\\��GƮ�ھ��;^���W^}��\'��pss�+�Ѩ�ż@������ry+3W��L&k_C��tw������p(F�����W&�\\��4vkd��ʕ+׬Yc��@��27��pOOOM�[Xx�9�dN�R��5_�f2yW�X��n9y�W!�q�ɤ�A���\\��~�Z/A����\"|������Ϋ\r��׷5\n�\Z��jp��A��_���׃>�i�&ՃCC�@\rd���{������n//>�\n�T+��B��\'o�y��7nT=D4�T+�zKoM����V�CD��@U��tss�Cɛ������a�E��@U��h$q4|�ڰ���G�@� �/P�5k�lڴ����9�z P=P4�T%V�sn�N���}�W�@� �/P�n2+�K�S�G�@� �/P�����������&��t:\rT���y�(�z��@U�ɗ�|]����D^ܼ���ڽ���]�@� �/P��7>�ȏ\r_���?P=P4�T%�Lz�^G÷�����_�@� �/P-G�����Tss3���=_�Z�����3�ȃ�\"\Z���%��^�׉�}��|����@\rb��]],{q�_�6߹ﾾ��uL�7�mkk��_�#CC�@m��t{{{������2yO���\Z��j�H$d��ļ������z@P��n����uh���y�A&8��Z�/p����ʕ+�	���)v/MN=��3��.T����3C��e>�2R�I�7o��?�ȏed��|�D��+�J=�����߹�>����s]>�e��=��%����A2�T}�P���C����x$ikkk��|F&o,K�Ӫ/��8E��K��E�N�c)`��8���\r&��6��S_�`r\0N!|a��8���\r&��6��S_�`r\0N!|a��8���\r&��6��S_�`r\0N!|a��8���\r&��6�@=�b1�����������ϥK�&	՗�����i۶mM%:::���K��B��dƒ%K\n�w���r�����ٺu�-Zd��ڵk{zzT_�������|�vuuy�^�V}E�w_��v�ڵx�b��`�W{Q�8bժU��U}!��_��TJ�/w���p\no��\r&\Z�0b�X8^����[��c�?�P(�F��m\"|������Бɻe˖�\'��f2w���	���uww˟��`���\r_,rq�D:;;�O��df��:{`��I�R��k_,2y�~���_��LS�j�+���ۓɤ�vaዅ@�y��J��΁+W~]u�0�������;;Wg�UM=���n��ꦁ�����z��\'����������m97 +G�Bo�h4�d����~�ʛ�\n�rUm��+~׏r�/�\n�����z���@�wgŉ�86-M����ƭ��6qq���!�\Zb��qU�~�ȃkR��Jj����W�:�#|�7��w��Lv*_r=;)�TN\\̊3�?��M���ա����WE�\'��7���)���y�ǣ�unG�Bo�����Od����yzyVL��}+�����W���/�O=��RV\\̈�bǾ�f�N���x�j4\0z3��U�˩�8E��^� �N��������Ͻ� �3f(���h_W�\r���\0��Us�;+�^N��3�Ӿe˚��hj������GF��\"|��Л��ʿ� W��_g����ﴴ�ܱ蓟����o�}�G��uU���\0��дU��+9q��[���*�%��v�]��͟}�//]brZ\\���qhx_Ѿ�*�W9\Z\0���f?�*�)2/f�G3r���s$���{;���3��CC�1��i!�whﾢ}]U��r4\0z+\n�@���o�9�>��=��}����c��{�#�v����ۻ�=|����=���t=�<	_עЛ�\n�����m߽���]U��r4\0z3��<Uk���\0�m.|g�Q��\r����=K�Z��r4\0z3��Uk���\0����Z��U�@of���Z��U�@o�/�)\Z\0�����e��a�-�<���΍��,�[�v4\0z�!2;��e���NW�e��[�� ΍Nu�܎@of<M8Q֑KҰ̓�B�&������\r��̨:]�*�׿U�n����:1Fխs;\Z\0��	5�DYG.	��=��n��+��\\���\0�͌����j�\\�M�3�/;ܰ�M7���T���h\0��h<U�Ţ�,�ѲY|�ǥ�������@ofB�[�*���پ��O��q�����\nO��unG�����%�(�����v���+��P�D7=f�F��unG�73�N9Q֑�lNd�A�7}\\.�Z�\\�[�v4\0z3�\'�:r�A�}�忬t�J)�������unG�73���^�������[�|��K7�9~���unG�73�NR��\r����=A�Z��r4\0z#|	_M�\0�M�H.w���_�h\0�f���T�E�*G�73|T�E�*G�73|ߢj-�W9\Z\0�y<�+W�rǨ���U�@o^��ԩ�r��TME�*G��`0���M9�&U}��x���n����[oooO��Ǚ^���S�HDu�܎��ޒɤ���+�HN���PhU<W�:�#|���s���a���[�7�pPu�@�B�a��U�C�}�R�/\n���ꦁ�ł�H$��e�����A�R����\Z|Au�0���1<<,��GB�J+����Iu�p\rዅ�0���H pO4��Tj��T:��X���pg(��U���Xh#�o��~���+ݣ��3��j���ۂb�/�\r�pJo�EeL�)�/l09\0�����\0�B���p\n�L�)�/l09\0�����\0�B���p\n�L�)�/l09\0�����\0�B���p\n�L�)�/l09\0�����\0�)����x<~�_>hmm�.]�4�H��4�/�/PO۶m+�8����x<���0��@=��dɒ��]�|�\\���i՗�����lݺu�-��w�ڵ===�/\n���_KKK>y����^�\\��\"�;�/P�v�Z�x��`0ȫ�(���jժ|����S�/��T*%×;�P	�8�7Y���a�X,��[z׭Kȱ˟@(�F���6�XP���e���ݲe�΁��cc3��;K�]���������DF�����/���D\"�����g23Ta�=wVF���R)Ս�5�/��~����/�d��J��������dRu�0���B ׼f�^��k����+���]�C�B{������3Y�����O7lxRu�@�Bs�ax����L�\nUMMN}�ֶ���#|��h4\Z�D2��Vu�U��X�{��6l���G9�z�B}[�~=yWw~ Ļ��DF�����dv���_���wF��{\r1tY�*~?t��5)�A%�t����n���Л��;z�@&;�/���b*\'.fŅqY������O|z���DF�O��\"i��Y������kr���Q�:�#|�����s�\'2��|�<�<+�g羕�������◿򋧞�\nq)+.fą�H�c�a3|\'�YM��Y5\Z\0��z�*��TV��\"ff�m�N����O�������_�ɉ3���?T�����U�@of��Ϫ��g/�\'EF���i߲eMMw45y��^w�#���uU���\0��ЋV�_v�+��/�3W���wZZZ�X��O�yW��7����E���_�h\0�fh�*�啜�`̭|�^�_m�������>����\n19-.O��84��h_W�\r��d�d�Y����3�����9�l�ڽ���i�!������;�w_Ѿ�*�W9\Z\0�h�c��N�IL�M�>p|���=�ƑS�F��g����>t�ȉ������P���k�\0�������U�����ю�*�W9\Z\0���{���_�h\0�6���Z��U�@of���j-�W9\Z\0���{���_�h\0�f��T�E�*G�73|ST�E�*G�7��\r��������?��ݲ�Wy�����CS�:��Л�����^E	X�L�f�v/}\\z��\'���?~]��unG�73�&\ZP։�9���EO�n\\ӹny8�[�v4\0z3��tݫ����3�*�^v�ҽ\n7+�����R�:��ЛO�NT����,z\\iߏ��1��c���ѩn���\0�͌���[eW������e7��d����R�1�n���\0�͹x����$c5�ݦl��\r���xz��U���Z\'*}Pv����=f��84��S�n���\0�m.�rɺW�a�gJ��~�o���ׁ��ϥ�unG�73�Nս\n�\\��e����~��\r�\\��n���\0��̩w�^%��wJOdsjk���U�6\rPu�܎@ofN�ս\n�\\z���.����ߘ�7�����O��unG�73�NR��\r����=A�Z��r4\0z#|	_M�\0�M�H.w���_�h\0�f���T�E�*G�73|T�E�*G�73|ߢj-�W9\Z\0�y<�+W�rǨ���U�@o^��ԩ�r��TME�*G��`0���M9�&U}��x���n����[oooO��Ǚ^���S�HDu�܎��ޒɤ���+�HN���PhU<W�:�#|���s���a���[�7�pPu�@�B�a��U�C�}�R�/\n���ꦁ�ł�H$��e�����A�R����\Z|Au�0���1<<,��GB�J+����Iu�p\rዅ�0���H pO4��Tj��T:��X���pg(��U���Xh#�o��~��gC�Js�g���2U��_�)�K�/��&�ʘ�S_�`r\0N!|a��8���\r&��6��S_�`r\0N!|a��8���\r&��6��S_�`r\0N!|a��8���\r&��6��S_�`r\0N!|a���S,����x�~�|���*�\\�ti\"�P}i�__���m�V�q�x\\��a~!|�z2cɒ%�ɻ|�r��M�Ӫ/\r���ٺu�-Zd��ڵk{zzT_�������|�vuuy�^�V}E�w_��v�ڵx�b��`�W{Q�8bժU��U}!��_��TJ�/w���p\no��\r&\Z�0b�X8^����[��c�?�P(�F��m\"|������Бɻe˖�\'��f2w���	���uww˟��`���\r_,rq�D:;;�O��df��:{`��I�R��k_,2y�~���_��LS�j�+���ۓɤ�vaዅ@�y��J��΁+W~]u�0�������;;Wg�UM=���n��ꦁ�����z��\'����������m97 +G�Bo�h4�d����~�ʛ�\n�rUm��+~׏r�/�\n�����z���@�wgŉ�86-M����ƭ��6qq���!�\Zb��qU�~�ȃkR��Jj����W�:�#|�7��w��Lv*_r=;)�TN\\̊3�?��M���ա����WE�\'��7���)���y�ǣ�unG�Bo�����Od����yzyVL��}+�����W���/�O=��RV\\̈�bǾ�f�N���x�j4\0z3��U�˩�8E��^� �N��������Ͻ� �3f(���h_W�\r���\0��Us�;+�^N��3�Ӿe˚��hj������GF��\"|��Л��ʿ� W��_g����ﴴ�ܱ蓟����o�}�G��uU���\0��дU��+9q��[���*�%��v�]��͟}�//]brZ\\���qhx_Ѿ�*�W9\Z\0���f?�*�)2/f�G3r���s$���{;���3��CC�1��i!�whﾢ}]U��r4\0z+\n�@���o�9�>��=��}����c��{�#�v����ۻ�=|����=���t=�<	_עЛ�\n�����m߽���]U��r4\0z3��<Uk���\0�m.|g�Q��\r����=K�Z��r4\0z3��Uk���\0����Z��U�@of���Z��U�@o�/�)\Z\0����Ac��\\�<cs�R���ֹ\r��d��ξ߰*<]�S[O�jѓE[�й��n���\0�����͛�\n�)�c�/m4f8�[�v4\0z3�t�҉��K�ݫp�r9ވ��Ϯ�unG�73��P�Nd=_�7|�h���+=h�pT���h\0�f�{\r�J\'*z������\'?�2[6l,�s�n���\0譑�[�5_���-�C�\r����zw>ԍ�nI�^߬tG%W��unG�����%\\�\'�����Zϔ_�6p�[�v4\0z3�T*\"�t��-z\\�[e7(�Mc���unG�73��i@�OTt��\'?N�2{~y�m\Z6խs;\Z\0���5�t��䅂�ۗ{I�&4f,��n���\0����T�E�*G�73|OP��\r��_�WS4\0z�!���j-�W9\Z\0����6Uk���\0���Uk���\0��߷�Z��U�@o��ʕ��1��\"|��Л��=u�\\�(US���\0�-��SN�IU_o%^��|�[�v�/�������C�q�W�9�T$Q�:�#|��d2��}�1�G�*+Z��U���_ho��59q�����M8T�4�Пa������e_�Ԁ��B:=��i |� $	�Y\"!�*}��T2y���_P�.�!|�@�������Ҋǟ�����R�(\\C�b�0��\'���2��!�(�N�;�u8�\n�c�-�u�/����H�ۭ����i�����px��_�mA1�p\n����8����2&��6��S_�`r\0N!|a��8���\r&��6��S_�`r\0N!|a��8���\r&��6��S_�`r\0N!|a��8���\r&��6��S_�`r\0���d�z<��/����?�.]�H$T_\Z����m۶�~�DGGG<W}i�__���X�dIa�._�\\����K��B�u�nݺE�Y�v�ڞ���y��ꯥ�%��]]]^�W.�U_����]�v-^�X�o0��^�E��X�jU>|U_�)�pD*����f����,`��ԍa�x|����P(�`0(��F�r-��1��@�̕�[���\"~�ӦM��\0A��ipppŊ7��B^��[ @��H.`#�H�����~�׷u���V=�����E[ʕ2o{s3���T�h���#?>966��V��������j�Z<xP�P���,�L�ܴ24��nQ˅�����V= (@��1�p��Ԇ\rU�nam��2v��/7B���&[��׷��7_#�G�����	���F#|�\Z����\\���W^���q�FՃCC�@\r�O���6�7_�뿭�����*�/P��G���l��D]����u�ã�>�z�h��V ��*�K����͛�mnnV=D4�T%�N[���k�k��w_�qmppP�@� �/P�h4jݙP���������Te͚5��ɡ�v��?��+T\rB�U	��|��ʫuߓcc�.T\rB�U�n2�?Z��e���z�h:\rTź!��_�PSY�W=P4���������ѣN����T\rB���X7��x���{��yn�u����{����su_�������(\Z�����ۛ�����=|�ڰ!�p8�z�h��J\"��^�49U��]�re���hT�@� �/P-��+n�����u��ħ���T���\'�mmmu\\�~���\r�B����!|�j�e�u7n��d<�{�����4]��j�q��|Pz<�ۿ���ؘ��k֬Q=84�����L����n�K�Smmm֡�M�!|��$�I�/eh�گz?=a%�\\D�k|]��j&��z�VFg�o�ڽ�z�����t+���x�Z�����WM��]]MH^�\"|�[�H$�߶cE��?Q��wd���qggg��2�y���_�֥�����[���H{{{�o��a����_�v��~��M���a՗�_�>È�b2��ϼ�x��P(�i�&V���\0�\0�\0\n�\0�\0�\0\n�\0����5�U#r�{\0\0\0\0IEND�B`�',0),('2503',1,'diagrams/HelloWorld.bpmn','2501','<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<definitions xmlns=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:activiti=\"http://activiti.org/bpmn\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:omgdc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:omgdi=\"http://www.omg.org/spec/DD/20100524/DI\" typeLanguage=\"http://www.w3.org/2001/XMLSchema\" expressionLanguage=\"http://www.w3.org/1999/XPath\" targetNamespace=\"http://www.activiti.org/test\">\n  <process id=\"HelloWordlKey\" name=\"HelloWordlName\" isExecutable=\"true\">\n    <userTask id=\"usertask1\" name=\"提交申请\" activiti:assignee=\"张三\"></userTask>\n    <userTask id=\"usertask2\" name=\"部门经理\" activiti:assignee=\"李四\"></userTask>\n    <userTask id=\"usertask3\" name=\"总经理\" activiti:assignee=\"王五\"></userTask>\n    <endEvent id=\"endevent1\" name=\"End\"></endEvent>\n    <sequenceFlow id=\"flow3\" sourceRef=\"usertask1\" targetRef=\"usertask2\"></sequenceFlow>\n    <sequenceFlow id=\"flow4\" sourceRef=\"usertask2\" targetRef=\"usertask3\"></sequenceFlow>\n    <sequenceFlow id=\"flow5\" sourceRef=\"usertask3\" targetRef=\"endevent1\"></sequenceFlow>\n    <startEvent id=\"startevent1\" name=\"Start\"></startEvent>\n    <sequenceFlow id=\"flow6\" sourceRef=\"startevent1\" targetRef=\"usertask1\"></sequenceFlow>\n  </process>\n  <bpmndi:BPMNDiagram id=\"BPMNDiagram_HelloWordlKey\">\n    <bpmndi:BPMNPlane bpmnElement=\"HelloWordlKey\" id=\"BPMNPlane_HelloWordlKey\">\n      <bpmndi:BPMNShape bpmnElement=\"usertask1\" id=\"BPMNShape_usertask1\">\n        <omgdc:Bounds height=\"55.0\" width=\"105.0\" x=\"235.0\" y=\"100.0\"></omgdc:Bounds>\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape bpmnElement=\"usertask2\" id=\"BPMNShape_usertask2\">\n        <omgdc:Bounds height=\"55.0\" width=\"105.0\" x=\"235.0\" y=\"180.0\"></omgdc:Bounds>\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape bpmnElement=\"usertask3\" id=\"BPMNShape_usertask3\">\n        <omgdc:Bounds height=\"55.0\" width=\"105.0\" x=\"235.0\" y=\"260.0\"></omgdc:Bounds>\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape bpmnElement=\"endevent1\" id=\"BPMNShape_endevent1\">\n        <omgdc:Bounds height=\"35.0\" width=\"35.0\" x=\"270.0\" y=\"340.0\"></omgdc:Bounds>\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape bpmnElement=\"startevent1\" id=\"BPMNShape_startevent1\">\n        <omgdc:Bounds height=\"35.0\" width=\"35.0\" x=\"270.0\" y=\"40.0\"></omgdc:Bounds>\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNEdge bpmnElement=\"flow3\" id=\"BPMNEdge_flow3\">\n        <omgdi:waypoint x=\"287.0\" y=\"155.0\"></omgdi:waypoint>\n        <omgdi:waypoint x=\"287.0\" y=\"180.0\"></omgdi:waypoint>\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge bpmnElement=\"flow4\" id=\"BPMNEdge_flow4\">\n        <omgdi:waypoint x=\"287.0\" y=\"235.0\"></omgdi:waypoint>\n        <omgdi:waypoint x=\"287.0\" y=\"260.0\"></omgdi:waypoint>\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge bpmnElement=\"flow5\" id=\"BPMNEdge_flow5\">\n        <omgdi:waypoint x=\"287.0\" y=\"315.0\"></omgdi:waypoint>\n        <omgdi:waypoint x=\"287.0\" y=\"340.0\"></omgdi:waypoint>\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge bpmnElement=\"flow6\" id=\"BPMNEdge_flow6\">\n        <omgdi:waypoint x=\"287.0\" y=\"75.0\"></omgdi:waypoint>\n        <omgdi:waypoint x=\"287.0\" y=\"100.0\"></omgdi:waypoint>\n      </bpmndi:BPMNEdge>\n    </bpmndi:BPMNPlane>\n  </bpmndi:BPMNDiagram>\n</definitions>',0),('5002',1,'diagrams/HelloWorld.png','5001','�PNG\r\n\Z\n\0\0\0\rIHDR\0\0�\0\0|\0\0\0���\0\0 �IDATx���olw����T�1Hē�~\0��&���S��H�,Q5����jbL�����Q�Qu��FSZK�FX�Jڅ6M����\'��4��ߥI{M�����]]��ڭﾹ����*�������9I�\0\0ثA�\0\0ס�\0`7�\0v��\0`7�\0v��\0`7�\0v��\0`7�\0v��\0`7�\0v��\0`7�\0v��\0`7�\0v��\0`7�\0v��\0`7�\0v��\0`7�\0v��\0`7�\0v��\0`7�\0v��\0`7�\0v��\0`7�\0v��\0`7�\0v��\0`7�\0v��\0`7�\0v��\0`7�\0v��\0`7�\0v��@�h���׮]\n���X,�N�U�@���\\YX��#�+;�ӳug�����ƛ�>�\\8nll\\�dI4\ZU�b������剭�,�T&[yv����������W�¡��]ww�̨<��ksgh��ҥKW�Z�i��-�\Z��2��p�������6n�\'˩TJ��@��Lfwɒ%�X잳k�� \'�L�� ؍�5�g���]�_�vp�Ԧ���~�d(�����PH�f�V������~����bӦM�7���@\rdv��׽��g�~��{�Ay�j���P(T���穧~�a�՛�P^�Z�@�֏��t���ܬza�T%�N766Z��������P؁�U�F��H���[����K�����ʪU�6m�diyw��To(�@y����j~&���鑑����P؁�U���d�s}|����P؁�Uinn=;fiy�44�?IW`7U��|�=JyQ�f�*�~���y݆�U�D\"�n�liyv�immU������aÆ������e�����\r�(/P�d2��z--o{{{oo��\r�(/P-K�#�����F~\\�KP^�Z����/�W���	��%OH�^���\'�?��a��j��Vvtp�Dy��|��zz��1��=���\"O{Uo�Cy�ڤ�����z�����.��Q�Y��j�H$d|e.�?��z�o�� ؍�������\\u`���y�A����Q:�^�t��>\'O]kj���^|1���ꍀ\Z��w����.Z�%�=�&��n�,o��S?��V����W*�z�����c2��?@]^�e����萷���A2�T�����C�����H$����p\'y��n,K�Ӫ_&f�XEVX�K�,Ey��&`�#�\n���*�f82\0�P^���\0�Bya�#�\n���*�f82\0�P^���\0�Bya�#�\n���*�f82\0�P^���\0�Bya�#�\n���*�f82�z��b2����������υ&	�/\r���i۶m\r%�����ꗆY����iڂ\n��x�by���B!��ٚ5k�͛g�w���]]]�_f��_SSS>�^�W��~E�](/P�v�?�,o0�^����%�-[�/���و��H�R��|�eQ^�*|\'�pd`��4-����@ ��zK?]�r��\n�B�h4�g�fʋ9���WGfw˖-;��N��Le2���rzzz:;;�����9���b���u�H���}���Tf�)���.����I�R�wfP^�2�~���ͯLe&��������d2�zw��bN�g�zvo1�ggߎ�K��zw����z{{�ۗg�\ZS�<󳟮_����v�Φi���=;��do2����Ֆ��|�X-�g�F��H$��aL[�[U~��^������Q����B�P�ֿ������xZ�ʈc��Ф\Z�n���[c��N��jb�&n�����<��	�T2���~��]�j������=��N�G�Ɏ1�ײ�ʔ�!�O~�\\�\'>�dyh,#F\'��-����x�C�i�g|���Q��\\����\Z/]�d��#czcZLN�|)�����7���/��^�\nq=+�eĕ�H�c�a������Y)VΦ��1�Yq�������t�w/���o_\Z=7�M���ҋ�g�����j(�Z�>�M�����)ﴸxC�!�&\'}�54<���Y���;\r(����������z^3&�n�<�=w]\\�%���������O~����߿������UCy�b��lz=��ȿ�̉+��9��[�o_�-�<��/<��ٗ���-!�\'ōə;�+���������dA�٫��\"�{-#�N�3�̞#ɖ�=���o^��5qA�\'�l���}E�u�P^�X}8[Q=mK?5t$1x0�{8����=�G����;G��\Z>�����<t�ȩ6�q�ʎ��Hy݉Շ���R8O>�D5����+��誡�j��p6����Z������f�;}��u(�Z�>�M/�E�֡�j��p6���Z��������gjʫ�g�˛bjʫ�g���׉X}8�^��㑋>\\�U>`�+�ۢ�gQ��\\�Շ�ɂLO��b�G.|\n����eT���w|X�u�w����p6�McV���%),se�b��fw}^K�������N����/��Pw�\\��Z���w����p6=O�V���%5,��˕�Z��fw�n(�Z�>�M��VL5�\\z��k*��p�]�z��o��]�j�>���6�5����\r-�^.��E�Fy�c��lz�ޯ���++����W��r���y�\n�T��s5V�6��\\Ҋ19�v\r+޸�zӷL�讏Y��S��\\�Շ��y:c����P�*ܠ�ʻ^.WgK6-�\\�w����p6=O�Y1�#�/�}���X��fh� E7�n���z׹\Z�g��4R����#Ɵw��޾A���^ov��Tx�zm��]�j�>�M��i�֡�j��p6����Z������(/�u\"V�&�˝djʫ�g��{��u(�Z�>�M/o��u(�Z�>�M/�q�֡�j��p6��s��\\�S�P^�X}8���=s�\\�(S�P^�X}8[0�G列x��~�\'^��|�w��Q^8[wwwW����Y���H$�z׹\Z关%�I��K7���8�T9�вx<�z׹\Z�㭝�*\'3���b�	���w��Q^8��i������SyR�>�O�tz@�Ns;ʋ� �H���	�/背��������E����\\188(����#!0�����y����zGa��ܡiZWW$x$\Z�e*�C�a&��w,��p�=\n�˪w>By1����G\"�nn�\\��>����	������-����gfa��Vi�;ta�#�\n���*�f82\0�P^���\0�Bya�#�\n���*�f82\0�P^���\0�Bya�#�\n���*�f82\0�P^���\0�Bya�#�\n���*�f82�z��b2����������υ&	�/\r���i۶m�����-��~i�E(/PO��-X��0��/�g��tZ�K�,By�:[�fͼy��^����K����By��kjj�g�������aկ���o׮]��ϗ�\r��ËR��Ĳe���U�B0Q^��TJ����,�X�豈��5���b�p8�^o�k]Bn�\\�P(�F�L�lCy1��������nٲeg_�鑑�LƝ#�]�@OOOgg�\\�_�;�Q^��.��������L1�s��E�_�8�TJ���ʋ�@f���������$c6�����ښL&U�.P^�	�lW��-����۱t��U�.P^8_ooo{��LVc��g~����W��܎���4M�z�gǒ��M�����Ҳ�\Z�Ey�l�h4�d�7�i~���]��U�~���!>jQ^8[(������]����O�SqlR�C��\r[�~k���)�_M����\r�������W=�<�Jf����W��\\����|>�ѣ2ى��3�q!&r�ZV\\�7���ϟk�ħ�,�e���%��8���sH?�p�O\\�x<�w��Q^8[cc��c��x~dLoL���/es3���?����b�Y!�gŵ���i!v�;��wܝ��w6+�����z^7F�u\"+.�S�� �N����K��f�� �Sz���?Tt_W\r�U�Շ�����13�o���\"#���oѢ��\Z\Z<+��Yxǡ�E�u�P^�X}8�^�k���m��箋�����������O=�P��w�w�����j(�Z�>�M�g��כ9qE�9�xK��K|�呇>��?��_^�%����19sǁ�}E�u�P^�X}8�,H6{՘|Pd|�e��)y��s$��G۾����&.h���ػ�辮\Zʫ�g+�g�m��㧆�$&v\'v8���ȿ�{�ș]�\'�3|b����N9���?n^ٱRy)�;��p6��W\n��\'���ؾ�bE�]5�W-VΦ��2S�P^�X}8�Ly�/1��U�Շ�����:�W-VΦ��S�P^�X}8�^��L�Cy�b��lzySL�Cy�b��l���:�g����ES�������p�R��z׹\Z�g���>W�)�_�5�73�{����,��薕�.�z׹\Z�g��4f�OT�3V�qѕ�7���ysT�:Wc��lz���}\n6ٸ�����޲�^�7+e���K��s5VΦ�iԊ�?���E-�lvߏ�Y�1���+�N��s5VΦ���N�s��>]��.{3�+K��]꾍�w����p6��d�j�X͍�ަl�)�������6�_�)�����^({��)��f�c�F=��]�j�>�m&R�dݧ�a�kJ/T��]�T��e�y-غ�s��u������6���>l�rA\n�ܦ��+߫�����z׹\Z�g�#�^ݧ����\'����]�z�jnc���u������H��}\n6���>uA��_g��r��.�t�w����p6�M��Z��������bjʫ�g���׉X}8�,H.w��u(�Z�>�M/�	�֡�j��p6��	�֡�j��p6��ǙZ������<�͛r�cLMCy�b��l^��̙�r��LMCy�b��l�`���r�]��9�x����u�Fy�l���]]?T�2g͟��\"���]�j�ΖL&}�/�Ԇr�S�B����]�j���vƪ�8�T3��&��inGy�x����U�CL�I���?���;��(/�D\"��/J$俠2f#�+�/���ջ�s��ࠌow���8��N<�����������s��i]]�@��h����!��t�߱د���P( /��E���\\����|���sf���U\Z?/��U�[p�X��������w��G`�3�U(/�pd\0V��0ÑX���G`�3�U(/�pd\0V��0ÑX���G`�3�U(/�pd\0V��0ÑX���G`�3�U(/�pd\0���dp=�������.L$�_\Zf��Ӷm�J1D[[[<W��0�P^��4M[�`Aav/^,�|��ꗆY��u�f͚y���]�zuWW���م����Ԕ�nGG���\'ª_f��߮]��ϟ/�y��(/`�e˖�˫��`6���%R��,/&CY��\n�I3�k4M��b�p8x���O׺��v��P(\Z��ن�bN���ő�ݲe�ξ��##S��;Gn�\\������N�&���wn���#�i]$ioo=;:��b\n�⥋��rqR�����s�̮��u�+S�I�l������5�L��]����ٮ��[L��ٷc�ү��]��p������噬�T3�����?�z��关i���zώ%3ٛL53>q��e14V���٢�h$�do��V���*���f��_�C|Ԣ�p�P(Գ�ﷳ���C!ޟ�2�ؤ84)�Ƴ����ص�S⿚ث��b�-���#��zBy����A�߯z׹\Z关�|��Gd���g��BL�ĵ��2%n�?���O/Y\Zˈ�I1zK$5q:+^{�~�;������xT�:W��p����K��2���Șޘ��3_��f�|��~��_�ź�B\\ϊkq%#�B��wX/�;���lV�Շ����n���DV\\�)��?�A:���K/?�ۗF��|A&\'��\"���辮\Zʫ�g���?cf�;-.���EF���IߢE\r\r44xV|����C���몡�j��p6��׌ɿ� �y�]n����555=0z����(���E�u�P^�X}8�^ϴ1�7s�6s�{��ۗ�j�#}�6~�忼vK��Iqcr�����몡�j��p6Y�l��1����^ˈ�S��7��H��k��}�&�yM\\���I!�;�w_�}]5�W-V�VT�@����O\rIL�N�>pr���=�Α3��O�g���\'�<rꃍܼ�c��R^wb��lzy�ΓO>Q�7�}wŊ�;�j(�Z�>�M/�e�֡�j��p���N_bjʫ�g��{��u(�Z�>�M/��֡�j��p6���Z��������Z������(/�u\"VΦ��C{������£��s[T�:Wc��l� ���l�§+��ƕEI-���к\rQ��\\�Շ��\Z�a*|;\\�m�ޱ�_+\\�gsT�:Wc��lz���0fOd\\_z��\noV.�vlK��U�:Wc��lz�Fm�\'2�/��_*�c���.س9�w����p6�V�0fOTt���������eni۶�K��s5V�fgy��答]�/U~(�;���p6�V�φ�3��$���J��ժ�u�����f��K�<�OZ��~ո��9����z׹\Z�g�kuƆ�?��t��[t��KeoP�6�l��]�j�>�M��{6L������ʏ�Z�^���ml�ջ��X}8������YJ�(�r�$���l��T�:Wc��lz�N3��U�Շ���=��:�W-V�Fy)���p6Y�\\�$S�P^�X}8�^�L�Cy�b��lzyL�Cy�b��lzy�3��U�Շ�y<��7�rǘ������ټ^�3o�rG�������ق��?z7�ĻL�s<���S��\\���ٺ����~��eΚ?G�E\"ջ��(/�-�L�|_��\r����	����qջ��(/o�U9q��f��M8T��܎���4M����ʓJ��\"���w��Q^��D��_�H�Ad�FfW�_T�+�w(/���A���	q�)�x�E�����\'�;\n3(/�MӺ�\"��#��/S�B3���c�_���P@^V���ʋ����?�vs���~46~&^.�z����\n����X���Ѕ	��*�f82\0�P^���\0�Bya�#�\n���*�f82\0�P^���\0�Bya�#�\n���*�f82\0�P^���\0�Bya�#�\n���*�f82\0�P^���\0�)���z<��//477�?.\\�H$T�4�\"���m۶��b����x<���a��@=i��`����.^�X����i�/\r���l͚5���3ʻz�ꮮ.�/\n��ꯩ�)�ݎ���+O�U�\"�.���]�v͟?_�7�/JQ^�˖-˗W��lDyK�R)Y^>L��(/`��f82���4-��]�6\n>�5�hT��~��-(/P2�����CQ���oڴ��:������ɒ%wmn!���\\���H��F\"�ҳ�g��YO�֝}o��ϵ���R�#�m�Ey�{�J��Nu�z�ǧGF�2Y��x��6n���������7\nP^�f�dRF�h0��ܢ��S`��gppP��n����i�g��֯�����e����\Zg�|��m(/P�p8ld��g�=d7?C���TolEy�\Z����<�-��o�i<چ\rTo�Cy�\Z��D�����n~��|������{P^�Z������b�g��R���Ƨ�~�i՛�P^�Z�@��\0Y]���W7o�?lcc��M�M(/P�t:m�\'[�^c~��Ϩ�����P؁�U�F����]9�?�D����A.Ay���Z��^i(��}o�|ɒ%�7v��@U��`>���x���==2b|W��\r�(/P��dC���^^9ƛȪ7v`7U1>�U��h�i��W��������˗�ݣG�(��cTo(��n�b|�wg��u���K��H��P^�*�A��ƍu/�<��?���W�������ݝ�cg��^�u���<��P؁�UI$���\'�[ޥK��<\Z���P؁��2~���X��1>�+��\\����������������y��ÆB!՛�P^�Z����m���x`�ㄗ߆�����\r��x<����##F�W�Z�z�`������2����l��\'ZZZ���`�\n�j�L&��\\)�yo?�a�옑]y�̏�u��L��xsVv���ؽ�x����}�J���x�8��ڡ��)OuWvt4 ��Dy�{�H$��c���g�+��:2�򼸽����2ܼ��Z��w�tz�ڵƏ+���j��p8�Rs3��/�P����U T�����CӴX,&l��\n���\r�B�6m�<y�\0�Fy�n�\0�Fy�n�\0����o����\0\0\0\0IEND�B`�',0),('5003',1,'diagrams/HelloWorld.bpmn','5001','<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<definitions xmlns=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:activiti=\"http://activiti.org/bpmn\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:omgdc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:omgdi=\"http://www.omg.org/spec/DD/20100524/DI\" typeLanguage=\"http://www.w3.org/2001/XMLSchema\" expressionLanguage=\"http://www.w3.org/1999/XPath\" targetNamespace=\"http://www.activiti.org/test\">\n  <process id=\"HelloWorldKey\" name=\"HelloWorldName\" isExecutable=\"true\">\n    <userTask id=\"usertask1\" name=\"提交申请\" activiti:assignee=\"张三\"></userTask>\n    <userTask id=\"usertask2\" name=\"部门经理\" activiti:assignee=\"李四\"></userTask>\n    <userTask id=\"usertask3\" name=\"总经理\" activiti:assignee=\"王五\"></userTask>\n    <endEvent id=\"endevent1\" name=\"End\"></endEvent>\n    <sequenceFlow id=\"flow3\" sourceRef=\"usertask1\" targetRef=\"usertask2\"></sequenceFlow>\n    <sequenceFlow id=\"flow4\" sourceRef=\"usertask2\" targetRef=\"usertask3\"></sequenceFlow>\n    <sequenceFlow id=\"flow5\" sourceRef=\"usertask3\" targetRef=\"endevent1\"></sequenceFlow>\n    <startEvent id=\"startevent1\" name=\"Start\"></startEvent>\n    <sequenceFlow id=\"flow6\" sourceRef=\"startevent1\" targetRef=\"usertask1\"></sequenceFlow>\n  </process>\n  <bpmndi:BPMNDiagram id=\"BPMNDiagram_HelloWorldKey\">\n    <bpmndi:BPMNPlane bpmnElement=\"HelloWorldKey\" id=\"BPMNPlane_HelloWorldKey\">\n      <bpmndi:BPMNShape bpmnElement=\"usertask1\" id=\"BPMNShape_usertask1\">\n        <omgdc:Bounds height=\"55.0\" width=\"105.0\" x=\"235.0\" y=\"100.0\"></omgdc:Bounds>\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape bpmnElement=\"usertask2\" id=\"BPMNShape_usertask2\">\n        <omgdc:Bounds height=\"55.0\" width=\"105.0\" x=\"235.0\" y=\"180.0\"></omgdc:Bounds>\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape bpmnElement=\"usertask3\" id=\"BPMNShape_usertask3\">\n        <omgdc:Bounds height=\"55.0\" width=\"105.0\" x=\"235.0\" y=\"260.0\"></omgdc:Bounds>\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape bpmnElement=\"endevent1\" id=\"BPMNShape_endevent1\">\n        <omgdc:Bounds height=\"35.0\" width=\"35.0\" x=\"270.0\" y=\"340.0\"></omgdc:Bounds>\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape bpmnElement=\"startevent1\" id=\"BPMNShape_startevent1\">\n        <omgdc:Bounds height=\"35.0\" width=\"35.0\" x=\"270.0\" y=\"40.0\"></omgdc:Bounds>\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNEdge bpmnElement=\"flow3\" id=\"BPMNEdge_flow3\">\n        <omgdi:waypoint x=\"287.0\" y=\"155.0\"></omgdi:waypoint>\n        <omgdi:waypoint x=\"287.0\" y=\"180.0\"></omgdi:waypoint>\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge bpmnElement=\"flow4\" id=\"BPMNEdge_flow4\">\n        <omgdi:waypoint x=\"287.0\" y=\"235.0\"></omgdi:waypoint>\n        <omgdi:waypoint x=\"287.0\" y=\"260.0\"></omgdi:waypoint>\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge bpmnElement=\"flow5\" id=\"BPMNEdge_flow5\">\n        <omgdi:waypoint x=\"287.0\" y=\"315.0\"></omgdi:waypoint>\n        <omgdi:waypoint x=\"287.0\" y=\"340.0\"></omgdi:waypoint>\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge bpmnElement=\"flow6\" id=\"BPMNEdge_flow6\">\n        <omgdi:waypoint x=\"287.0\" y=\"75.0\"></omgdi:waypoint>\n        <omgdi:waypoint x=\"287.0\" y=\"100.0\"></omgdi:waypoint>\n      </bpmndi:BPMNEdge>\n    </bpmndi:BPMNPlane>\n  </bpmndi:BPMNDiagram>\n</definitions>',0);

/*Table structure for table `act_ge_property` */

DROP TABLE IF EXISTS `act_ge_property`;

CREATE TABLE `act_ge_property` (
  `NAME_` varchar(64) COLLATE utf8_bin NOT NULL,
  `VALUE_` varchar(300) COLLATE utf8_bin DEFAULT NULL,
  `REV_` int(11) DEFAULT NULL,
  PRIMARY KEY (`NAME_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ge_property` */

insert  into `act_ge_property`(`NAME_`,`VALUE_`,`REV_`) values ('next.dbid','15001',7),('schema.history','create(5.22.0.0)',1),('schema.version','5.22.0.0',1);

/*Table structure for table `act_hi_actinst` */

DROP TABLE IF EXISTS `act_hi_actinst`;

CREATE TABLE `act_hi_actinst` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `ACT_ID_` varchar(255) COLLATE utf8_bin NOT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `CALL_PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACT_NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ACT_TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `ASSIGNEE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `START_TIME_` datetime(3) NOT NULL,
  `END_TIME_` datetime(3) DEFAULT NULL,
  `DURATION_` bigint(20) DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_ACT_INST_START` (`START_TIME_`),
  KEY `ACT_IDX_HI_ACT_INST_END` (`END_TIME_`),
  KEY `ACT_IDX_HI_ACT_INST_PROCINST` (`PROC_INST_ID_`,`ACT_ID_`),
  KEY `ACT_IDX_HI_ACT_INST_EXEC` (`EXECUTION_ID_`,`ACT_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_hi_actinst` */

insert  into `act_hi_actinst`(`ID_`,`PROC_DEF_ID_`,`PROC_INST_ID_`,`EXECUTION_ID_`,`ACT_ID_`,`TASK_ID_`,`CALL_PROC_INST_ID_`,`ACT_NAME_`,`ACT_TYPE_`,`ASSIGNEE_`,`START_TIME_`,`END_TIME_`,`DURATION_`,`TENANT_ID_`) values ('10001','HelloWorldKey:2:5004','7501','7501','usertask2','10002',NULL,'部门经理','userTask','李四','2019-05-16 19:41:42.823','2019-05-16 19:48:22.500',399677,''),('12501','HelloWorldKey:2:5004','7501','7501','usertask3','12502',NULL,'总经理','userTask','王五','2019-05-16 19:48:23.009',NULL,NULL,''),('7502','HelloWorldKey:2:5004','7501','7501','startevent1',NULL,NULL,'Start','startEvent',NULL,'2019-05-16 19:34:22.361','2019-05-16 19:34:22.381',20,''),('7504','HelloWorldKey:2:5004','7501','7501','usertask1','7505',NULL,'提交申请','userTask','张三','2019-05-16 19:34:22.381','2019-05-16 19:41:42.596',440215,'');

/*Table structure for table `act_hi_attachment` */

DROP TABLE IF EXISTS `act_hi_attachment`;

CREATE TABLE `act_hi_attachment` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `URL_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `CONTENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TIME_` datetime(3) DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_hi_attachment` */

/*Table structure for table `act_hi_comment` */

DROP TABLE IF EXISTS `act_hi_comment`;

CREATE TABLE `act_hi_comment` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TIME_` datetime(3) NOT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACTION_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `MESSAGE_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `FULL_MSG_` longblob,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_hi_comment` */

/*Table structure for table `act_hi_detail` */

DROP TABLE IF EXISTS `act_hi_detail`;

CREATE TABLE `act_hi_detail` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACT_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin NOT NULL,
  `VAR_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TIME_` datetime(3) NOT NULL,
  `BYTEARRAY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DOUBLE_` double DEFAULT NULL,
  `LONG_` bigint(20) DEFAULT NULL,
  `TEXT_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TEXT2_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_DETAIL_PROC_INST` (`PROC_INST_ID_`),
  KEY `ACT_IDX_HI_DETAIL_ACT_INST` (`ACT_INST_ID_`),
  KEY `ACT_IDX_HI_DETAIL_TIME` (`TIME_`),
  KEY `ACT_IDX_HI_DETAIL_NAME` (`NAME_`),
  KEY `ACT_IDX_HI_DETAIL_TASK_ID` (`TASK_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_hi_detail` */

/*Table structure for table `act_hi_identitylink` */

DROP TABLE IF EXISTS `act_hi_identitylink`;

CREATE TABLE `act_hi_identitylink` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `GROUP_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_IDENT_LNK_USER` (`USER_ID_`),
  KEY `ACT_IDX_HI_IDENT_LNK_TASK` (`TASK_ID_`),
  KEY `ACT_IDX_HI_IDENT_LNK_PROCINST` (`PROC_INST_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_hi_identitylink` */

insert  into `act_hi_identitylink`(`ID_`,`GROUP_ID_`,`TYPE_`,`USER_ID_`,`TASK_ID_`,`PROC_INST_ID_`) values ('10003',NULL,'participant','李四',NULL,'7501'),('12503',NULL,'participant','王五',NULL,'7501'),('7506',NULL,'participant','张三',NULL,'7501');

/*Table structure for table `act_hi_procinst` */

DROP TABLE IF EXISTS `act_hi_procinst`;

CREATE TABLE `act_hi_procinst` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `BUSINESS_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `START_TIME_` datetime(3) NOT NULL,
  `END_TIME_` datetime(3) DEFAULT NULL,
  `DURATION_` bigint(20) DEFAULT NULL,
  `START_USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `START_ACT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `END_ACT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `SUPER_PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DELETE_REASON_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `PROC_INST_ID_` (`PROC_INST_ID_`),
  KEY `ACT_IDX_HI_PRO_INST_END` (`END_TIME_`),
  KEY `ACT_IDX_HI_PRO_I_BUSKEY` (`BUSINESS_KEY_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_hi_procinst` */

insert  into `act_hi_procinst`(`ID_`,`PROC_INST_ID_`,`BUSINESS_KEY_`,`PROC_DEF_ID_`,`START_TIME_`,`END_TIME_`,`DURATION_`,`START_USER_ID_`,`START_ACT_ID_`,`END_ACT_ID_`,`SUPER_PROCESS_INSTANCE_ID_`,`DELETE_REASON_`,`TENANT_ID_`,`NAME_`) values ('7501','7501','666','HelloWorldKey:2:5004','2019-05-16 19:34:22.361',NULL,NULL,NULL,'startevent1',NULL,NULL,NULL,'',NULL);

/*Table structure for table `act_hi_taskinst` */

DROP TABLE IF EXISTS `act_hi_taskinst`;

CREATE TABLE `act_hi_taskinst` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_DEF_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PARENT_TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ASSIGNEE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `START_TIME_` datetime(3) NOT NULL,
  `CLAIM_TIME_` datetime(3) DEFAULT NULL,
  `END_TIME_` datetime(3) DEFAULT NULL,
  `DURATION_` bigint(20) DEFAULT NULL,
  `DELETE_REASON_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `PRIORITY_` int(11) DEFAULT NULL,
  `DUE_DATE_` datetime(3) DEFAULT NULL,
  `FORM_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_TASK_INST_PROCINST` (`PROC_INST_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_hi_taskinst` */

insert  into `act_hi_taskinst`(`ID_`,`PROC_DEF_ID_`,`TASK_DEF_KEY_`,`PROC_INST_ID_`,`EXECUTION_ID_`,`NAME_`,`PARENT_TASK_ID_`,`DESCRIPTION_`,`OWNER_`,`ASSIGNEE_`,`START_TIME_`,`CLAIM_TIME_`,`END_TIME_`,`DURATION_`,`DELETE_REASON_`,`PRIORITY_`,`DUE_DATE_`,`FORM_KEY_`,`CATEGORY_`,`TENANT_ID_`) values ('10002','HelloWorldKey:2:5004','usertask2','7501','7501','部门经理',NULL,NULL,NULL,'李四','2019-05-16 19:41:42.823',NULL,'2019-05-16 19:48:22.463',399640,'completed',50,NULL,NULL,NULL,''),('12502','HelloWorldKey:2:5004','usertask3','7501','7501','总经理',NULL,NULL,NULL,'王五','2019-05-16 19:48:23.010',NULL,NULL,NULL,NULL,50,NULL,NULL,NULL,''),('7505','HelloWorldKey:2:5004','usertask1','7501','7501','提交申请',NULL,NULL,NULL,'张三','2019-05-16 19:34:22.425',NULL,'2019-05-16 19:41:42.583',440158,'completed',50,NULL,NULL,NULL,'');

/*Table structure for table `act_hi_varinst` */

DROP TABLE IF EXISTS `act_hi_varinst`;

CREATE TABLE `act_hi_varinst` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin NOT NULL,
  `VAR_TYPE_` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `REV_` int(11) DEFAULT NULL,
  `BYTEARRAY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DOUBLE_` double DEFAULT NULL,
  `LONG_` bigint(20) DEFAULT NULL,
  `TEXT_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TEXT2_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `CREATE_TIME_` datetime(3) DEFAULT NULL,
  `LAST_UPDATED_TIME_` datetime(3) DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_PROCVAR_PROC_INST` (`PROC_INST_ID_`),
  KEY `ACT_IDX_HI_PROCVAR_NAME_TYPE` (`NAME_`,`VAR_TYPE_`),
  KEY `ACT_IDX_HI_PROCVAR_TASK_ID` (`TASK_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_hi_varinst` */

insert  into `act_hi_varinst`(`ID_`,`PROC_INST_ID_`,`EXECUTION_ID_`,`TASK_ID_`,`NAME_`,`VAR_TYPE_`,`REV_`,`BYTEARRAY_ID_`,`DOUBLE_`,`LONG_`,`TEXT_`,`TEXT2_`,`CREATE_TIME_`,`LAST_UPDATED_TIME_`) values ('7503','7501','7501',NULL,'hello','string',1,NULL,NULL,NULL,'wangbo',NULL,'2019-05-16 19:34:22.362','2019-05-16 19:41:42.497');

/*Table structure for table `act_id_group` */

DROP TABLE IF EXISTS `act_id_group`;

CREATE TABLE `act_id_group` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_id_group` */

/*Table structure for table `act_id_info` */

DROP TABLE IF EXISTS `act_id_info`;

CREATE TABLE `act_id_info` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `USER_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `VALUE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PASSWORD_` longblob,
  `PARENT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_id_info` */

/*Table structure for table `act_id_membership` */

DROP TABLE IF EXISTS `act_id_membership`;

CREATE TABLE `act_id_membership` (
  `USER_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `GROUP_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`USER_ID_`,`GROUP_ID_`),
  KEY `ACT_FK_MEMB_GROUP` (`GROUP_ID_`),
  CONSTRAINT `ACT_FK_MEMB_GROUP` FOREIGN KEY (`GROUP_ID_`) REFERENCES `act_id_group` (`ID_`),
  CONSTRAINT `ACT_FK_MEMB_USER` FOREIGN KEY (`USER_ID_`) REFERENCES `act_id_user` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_id_membership` */

/*Table structure for table `act_id_user` */

DROP TABLE IF EXISTS `act_id_user`;

CREATE TABLE `act_id_user` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `FIRST_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `LAST_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EMAIL_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PWD_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PICTURE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_id_user` */

/*Table structure for table `act_procdef_info` */

DROP TABLE IF EXISTS `act_procdef_info`;

CREATE TABLE `act_procdef_info` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `INFO_JSON_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `ACT_UNIQ_INFO_PROCDEF` (`PROC_DEF_ID_`),
  KEY `ACT_IDX_INFO_PROCDEF` (`PROC_DEF_ID_`),
  KEY `ACT_FK_INFO_JSON_BA` (`INFO_JSON_ID_`),
  CONSTRAINT `ACT_FK_INFO_JSON_BA` FOREIGN KEY (`INFO_JSON_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
  CONSTRAINT `ACT_FK_INFO_PROCDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_procdef_info` */

/*Table structure for table `act_re_deployment` */

DROP TABLE IF EXISTS `act_re_deployment`;

CREATE TABLE `act_re_deployment` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  `DEPLOY_TIME_` timestamp(3) NULL DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_re_deployment` */

insert  into `act_re_deployment`(`ID_`,`NAME_`,`CATEGORY_`,`TENANT_ID_`,`DEPLOY_TIME_`) values ('2501','hello',NULL,'','2019-05-16 19:24:15.209'),('5001','hello',NULL,'','2019-05-16 19:33:17.818');

/*Table structure for table `act_re_model` */

DROP TABLE IF EXISTS `act_re_model`;

CREATE TABLE `act_re_model` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CREATE_TIME_` timestamp(3) NULL DEFAULT NULL,
  `LAST_UPDATE_TIME_` timestamp(3) NULL DEFAULT NULL,
  `VERSION_` int(11) DEFAULT NULL,
  `META_INFO_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DEPLOYMENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EDITOR_SOURCE_VALUE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EDITOR_SOURCE_EXTRA_VALUE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_MODEL_SOURCE` (`EDITOR_SOURCE_VALUE_ID_`),
  KEY `ACT_FK_MODEL_SOURCE_EXTRA` (`EDITOR_SOURCE_EXTRA_VALUE_ID_`),
  KEY `ACT_FK_MODEL_DEPLOYMENT` (`DEPLOYMENT_ID_`),
  CONSTRAINT `ACT_FK_MODEL_DEPLOYMENT` FOREIGN KEY (`DEPLOYMENT_ID_`) REFERENCES `act_re_deployment` (`ID_`),
  CONSTRAINT `ACT_FK_MODEL_SOURCE` FOREIGN KEY (`EDITOR_SOURCE_VALUE_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
  CONSTRAINT `ACT_FK_MODEL_SOURCE_EXTRA` FOREIGN KEY (`EDITOR_SOURCE_EXTRA_VALUE_ID_`) REFERENCES `act_ge_bytearray` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_re_model` */

/*Table structure for table `act_re_procdef` */

DROP TABLE IF EXISTS `act_re_procdef`;

CREATE TABLE `act_re_procdef` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8_bin NOT NULL,
  `VERSION_` int(11) NOT NULL,
  `DEPLOYMENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `RESOURCE_NAME_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DGRM_RESOURCE_NAME_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `HAS_START_FORM_KEY_` tinyint(4) DEFAULT NULL,
  `HAS_GRAPHICAL_NOTATION_` tinyint(4) DEFAULT NULL,
  `SUSPENSION_STATE_` int(11) DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `ACT_UNIQ_PROCDEF` (`KEY_`,`VERSION_`,`TENANT_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_re_procdef` */

insert  into `act_re_procdef`(`ID_`,`REV_`,`CATEGORY_`,`NAME_`,`KEY_`,`VERSION_`,`DEPLOYMENT_ID_`,`RESOURCE_NAME_`,`DGRM_RESOURCE_NAME_`,`DESCRIPTION_`,`HAS_START_FORM_KEY_`,`HAS_GRAPHICAL_NOTATION_`,`SUSPENSION_STATE_`,`TENANT_ID_`) values ('HelloWorldKey:1:2504',1,'http://www.activiti.org/test','HelloWorldName','HelloWorldKey',1,'2501','diagrams/HelloWorld.bpmn','diagrams/HelloWorld.png',NULL,0,1,1,''),('HelloWorldKey:2:5004',1,'http://www.activiti.org/test','HelloWorldName','HelloWorldKey',2,'5001','diagrams/HelloWorld.bpmn','diagrams/HelloWorld.png',NULL,0,1,1,'');

/*Table structure for table `act_ru_event_subscr` */

DROP TABLE IF EXISTS `act_ru_event_subscr`;

CREATE TABLE `act_ru_event_subscr` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `EVENT_TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `EVENT_NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACTIVITY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `CONFIGURATION_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CREATED_` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_EVENT_SUBSCR_CONFIG_` (`CONFIGURATION_`),
  KEY `ACT_FK_EVENT_EXEC` (`EXECUTION_ID_`),
  CONSTRAINT `ACT_FK_EVENT_EXEC` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ru_event_subscr` */

/*Table structure for table `act_ru_execution` */

DROP TABLE IF EXISTS `act_ru_execution`;

CREATE TABLE `act_ru_execution` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `BUSINESS_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PARENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `SUPER_EXEC_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `IS_ACTIVE_` tinyint(4) DEFAULT NULL,
  `IS_CONCURRENT_` tinyint(4) DEFAULT NULL,
  `IS_SCOPE_` tinyint(4) DEFAULT NULL,
  `IS_EVENT_SCOPE_` tinyint(4) DEFAULT NULL,
  `SUSPENSION_STATE_` int(11) DEFAULT NULL,
  `CACHED_ENT_STATE_` int(11) DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `LOCK_TIME_` timestamp(3) NULL DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_EXEC_BUSKEY` (`BUSINESS_KEY_`),
  KEY `ACT_FK_EXE_PROCINST` (`PROC_INST_ID_`),
  KEY `ACT_FK_EXE_PARENT` (`PARENT_ID_`),
  KEY `ACT_FK_EXE_SUPER` (`SUPER_EXEC_`),
  KEY `ACT_FK_EXE_PROCDEF` (`PROC_DEF_ID_`),
  CONSTRAINT `ACT_FK_EXE_PARENT` FOREIGN KEY (`PARENT_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_EXE_PROCDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`),
  CONSTRAINT `ACT_FK_EXE_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ACT_FK_EXE_SUPER` FOREIGN KEY (`SUPER_EXEC_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ru_execution` */

insert  into `act_ru_execution`(`ID_`,`REV_`,`PROC_INST_ID_`,`BUSINESS_KEY_`,`PARENT_ID_`,`PROC_DEF_ID_`,`SUPER_EXEC_`,`ACT_ID_`,`IS_ACTIVE_`,`IS_CONCURRENT_`,`IS_SCOPE_`,`IS_EVENT_SCOPE_`,`SUSPENSION_STATE_`,`CACHED_ENT_STATE_`,`TENANT_ID_`,`NAME_`,`LOCK_TIME_`) values ('7501',3,'7501','666',NULL,'HelloWorldKey:2:5004',NULL,'usertask3',1,0,1,0,1,2,'',NULL,NULL);

/*Table structure for table `act_ru_identitylink` */

DROP TABLE IF EXISTS `act_ru_identitylink`;

CREATE TABLE `act_ru_identitylink` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `GROUP_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_IDENT_LNK_USER` (`USER_ID_`),
  KEY `ACT_IDX_IDENT_LNK_GROUP` (`GROUP_ID_`),
  KEY `ACT_IDX_ATHRZ_PROCEDEF` (`PROC_DEF_ID_`),
  KEY `ACT_FK_TSKASS_TASK` (`TASK_ID_`),
  KEY `ACT_FK_IDL_PROCINST` (`PROC_INST_ID_`),
  CONSTRAINT `ACT_FK_ATHRZ_PROCEDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`),
  CONSTRAINT `ACT_FK_IDL_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_TSKASS_TASK` FOREIGN KEY (`TASK_ID_`) REFERENCES `act_ru_task` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ru_identitylink` */

insert  into `act_ru_identitylink`(`ID_`,`REV_`,`GROUP_ID_`,`TYPE_`,`USER_ID_`,`TASK_ID_`,`PROC_INST_ID_`,`PROC_DEF_ID_`) values ('10003',1,NULL,'participant','李四',NULL,'7501',NULL),('12503',1,NULL,'participant','王五',NULL,'7501',NULL),('7506',1,NULL,'participant','张三',NULL,'7501',NULL);

/*Table structure for table `act_ru_job` */

DROP TABLE IF EXISTS `act_ru_job`;

CREATE TABLE `act_ru_job` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `LOCK_EXP_TIME_` timestamp(3) NULL DEFAULT NULL,
  `LOCK_OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EXCLUSIVE_` tinyint(1) DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `RETRIES_` int(11) DEFAULT NULL,
  `EXCEPTION_STACK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXCEPTION_MSG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DUEDATE_` timestamp(3) NULL DEFAULT NULL,
  `REPEAT_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_CFG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_JOB_EXCEPTION` (`EXCEPTION_STACK_ID_`),
  CONSTRAINT `ACT_FK_JOB_EXCEPTION` FOREIGN KEY (`EXCEPTION_STACK_ID_`) REFERENCES `act_ge_bytearray` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ru_job` */

/*Table structure for table `act_ru_task` */

DROP TABLE IF EXISTS `act_ru_task`;

CREATE TABLE `act_ru_task` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PARENT_TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TASK_DEF_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ASSIGNEE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DELEGATION_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PRIORITY_` int(11) DEFAULT NULL,
  `CREATE_TIME_` timestamp(3) NULL DEFAULT NULL,
  `DUE_DATE_` datetime(3) DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `SUSPENSION_STATE_` int(11) DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  `FORM_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_TASK_CREATE` (`CREATE_TIME_`),
  KEY `ACT_FK_TASK_EXE` (`EXECUTION_ID_`),
  KEY `ACT_FK_TASK_PROCINST` (`PROC_INST_ID_`),
  KEY `ACT_FK_TASK_PROCDEF` (`PROC_DEF_ID_`),
  CONSTRAINT `ACT_FK_TASK_EXE` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_TASK_PROCDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`),
  CONSTRAINT `ACT_FK_TASK_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ru_task` */

insert  into `act_ru_task`(`ID_`,`REV_`,`EXECUTION_ID_`,`PROC_INST_ID_`,`PROC_DEF_ID_`,`NAME_`,`PARENT_TASK_ID_`,`DESCRIPTION_`,`TASK_DEF_KEY_`,`OWNER_`,`ASSIGNEE_`,`DELEGATION_`,`PRIORITY_`,`CREATE_TIME_`,`DUE_DATE_`,`CATEGORY_`,`SUSPENSION_STATE_`,`TENANT_ID_`,`FORM_KEY_`) values ('12502',1,'7501','7501','HelloWorldKey:2:5004','总经理',NULL,NULL,'usertask3',NULL,'王五',NULL,50,'2019-05-16 19:48:23.010',NULL,NULL,1,'',NULL);

/*Table structure for table `act_ru_variable` */

DROP TABLE IF EXISTS `act_ru_variable`;

CREATE TABLE `act_ru_variable` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin NOT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `BYTEARRAY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DOUBLE_` double DEFAULT NULL,
  `LONG_` bigint(20) DEFAULT NULL,
  `TEXT_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TEXT2_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_VARIABLE_TASK_ID` (`TASK_ID_`),
  KEY `ACT_FK_VAR_EXE` (`EXECUTION_ID_`),
  KEY `ACT_FK_VAR_PROCINST` (`PROC_INST_ID_`),
  KEY `ACT_FK_VAR_BYTEARRAY` (`BYTEARRAY_ID_`),
  CONSTRAINT `ACT_FK_VAR_BYTEARRAY` FOREIGN KEY (`BYTEARRAY_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
  CONSTRAINT `ACT_FK_VAR_EXE` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_VAR_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ru_variable` */

insert  into `act_ru_variable`(`ID_`,`REV_`,`TYPE_`,`NAME_`,`EXECUTION_ID_`,`PROC_INST_ID_`,`TASK_ID_`,`BYTEARRAY_ID_`,`DOUBLE_`,`LONG_`,`TEXT_`,`TEXT2_`) values ('7503',1,'string','hello','7501','7501',NULL,NULL,NULL,NULL,'wangbo',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
