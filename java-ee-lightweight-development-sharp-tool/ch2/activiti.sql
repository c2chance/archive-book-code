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

insert  into `act_ge_bytearray`(`ID_`,`REV_`,`NAME_`,`DEPLOYMENT_ID_`,`BYTES_`,`GENERATED_`) values ('2502',1,'diagrams/HelloWorld.png','2501','âPNG\r\n\Z\n\0\0\0\rIHDR\0\0‘\0\0|\0\0\0˘\n›∏\0\0 rIDATxúÌ›ol[W˝«Òàµ‘T†1HƒìÒ†~\0ç≈&•è®Sâ∆H¿,1-Ü¡“÷jbLç¥±ï±Q°1u∞‘FSZKÎFXõJ⁄Ö6Mˇ≠ù◊6´∑4õ◊si“ﬁ&v|~\'◊›≠Î?∑vÎÎìì˚~È´ qÓøìÔŸgßÓu‹$\0\0\r◊§˙\0¿ç_\0PÄ\0_\0PÄ\0_\0PÄ\0_\0PÄ\0_\0PÄ\0_\0PÄ\0_\0PÄ\0_\0PÄ\0_\0PÄ\0_\0PÄ\0_\0PÄ\0_\0PÄ\0_\0PÄ\0_\0PÄ\0_\0PÄ\0_\0PÄ\0_\0PÄ\0_\0PÄ\0_\0PÄ\0_†n√à«„Î◊ØÖBÅèÉA˘L,Kß”™/Û·‘ÅÃ\\≤èG∆Æå⁄ææ≠;^œ◊ˆW^}¸Ò\'¬·pssÛä+¢—®Íã≈º@¯∑Â‡¡Éry+3WÜÏL&k_Cª˜twˇ¿Ô˜™æp(F¯∑Æ∑∑W&©\\ﬁﬁ4vkdˇË ï+◊¨YcÜÍ@¬∏27√·pOOOM±[XxÓ9πdN•R™á5_†f2yW¨Xã≈n9y≠W!‰qí…§ÍA¬®ô\\Ûﬁ~ÚZ/A»¸Âı\"|Å⁄ÙˆˆﬁŒ´\r•’◊∑5\n©\Zçjp‡Aøﬂ_«‰Õ◊É>¥i”&’ÉCCæ@\rdÚéÏ≠{¯éüû∏˚n//>∏\n·T+èáB°∫\'oæy‰«7nT=D4·T+‘zKoMãﬂ÷÷V’CD„æ@U“Ètss≥C…õØˆˆˆ··a’EÉæ@U¢—h$q4|ü⁄∞°ßßGı@— Ñ/Pï5k÷l⁄¥…—›9z P=P4·T%VÛ´snßNéç›}∑Wı@— Ñ/Pán2+¨KìSèGı@— Ñ/Pï÷÷÷Ò”éÜØ¨¶&˛ìt:\rT≈ÁÛΩyÙ(·ãz°”@UΩ…ó◊|]à™âD^‹ºŸ—⁄ΩßΩΩ]ı@— Ñ/Pïç7>Ú»è\r_Ó››?P=P4·T%ôLzΩ^G√∑≥≥≥øø_ı@— Ñ/P-GˇÕÌ“‰Tss3øÿÃ=_†ZéæÚÙ3œ»É´\"\Zá™%ó•^Ø◊âª}Â≤˜ÓªΩ|ò¶´æ@\rb±ÿ]],{q˚_†6ﬂπÔæææ≠uLﬁ7èmkkìã_’#CCæ@m“Èt{{{Ω˛ÂÌÏπÛ2yOéç©\ZçjñH$d˛ ƒº˝‰ïÎËÌØº™z@PÄn≈¡ÉÂäuh˜û€yµA&8…ÎZÑ/pã“ÈÙ ï+¸	πÄ≠)v/MN=˝Ã3˘◊.T æ¿≠3CÜÔ≤e>¶2R´Iﬁ7oñ€?Ú»èed´æ|®D¯∑+ïJ=˙Ë£ÕÕÕﬂπÔ>ô≠•øs]>≥eÀˇ=–’%∑ÈÓ˛A2ôT}…PèÍCÆÇ„Òx$ikkk∫ë|F&o,Kß”™/Û·8E±ÍK¿¸E¯N·c)`É…8ÖÖ\r&‡¬6òÄS_ÿ`r\0N!|aÉ…8ÖÖ\r&‡¬6òÄS_ÿ`r\0N!|aÉ…8ÖÖ\r&‡¬6òÄS_ÿ`r\0N!|aÉ…8ÖÖ\r&‡¬6ò@=≈b1ôπè«Ô˜À≠≠≠Úœ•Kó&	’óÜ˘ÖÍi€∂mM%:::‚Ò∏ÍK√¸B¯ıd∆í%K\nìw˘ÚÂr˝À°·‘Ÿ∫uÎ-ZdÖÔ⁄µk{zzT_Ê¬®øñññ|ÚvuuyΩ^πV}Eòw_†˛vÌ⁄µxÒbæ¡`êW{Q·8b’™U˘U}!òß_¿©TJÜ/wò°¬p\no≤Ä\r&\Z√0b±X8^Ø∑ÙÆ[óêcó?ÅP(çFπ—m\"|±†Ù˜˜À–ë…ªeÀñù\'«∆f2wñª¸	ÙııuwwÀüâå`’Õ¡\r_,rqâD:;;«Oèœdf®¬:{Ó¨å`˘√I•R™Ök_,2y˝~ˇãõ_ò…LSïj˚+€€€€ì…§Íva·ãÖ@ÆyÕ‰ΩJŸ◊ŒÅ+W~]uª0áÖˆ˙˚˚;;Wg≤UM=ˆ≥ünÿ§Í¶ÅÖÊ√zΩß\'íôÏ™ööú˙®≠m97 +G¯Bo—h4âd≤ó≠Í~´ õ±\n˜rUmÿ+~◊èrÑ/Ù\nÖ˙∂˛˝zÚÆÓ¸@àwg≈âå86-Mãë…Ï∆≠Øø6qqÔå¯Ø!ˆ\ZbË≤ÿqU¸~Ë»ÉkRûÉJjˇË∞ﬂÔW›:∑#|°7üœwÙËÅLv*_r=;)ƒTN\\Ãä3‚≤?˘˘Mü¯Ùä’°âåü„WE“\'≥‚•7ôãﬂ)÷‰‘yè«£∫unG¯BoÕÕÕÁŒOd≤ì˘íyzyVLœŒ}+õõ˚ÛÂWˇ˘≈/ÂO=ù‚RV\\Ãàëb«æ√f¯N∫≥öxÎ≥j4\0z3ÙíUÚÀ©¨8EÃÃ^€ ùNˇÓŸÁü¸Ì≥„ÔœΩø ì3f(ÔŸ®h_W·´\rÄﬁÃ\0˝üUs·;+Œ^Näå3””æeÀööÓhjÚ‹ˇΩÓ¬GFÌÎ™\"|ï£–õ†≠ øÏ WæÔ_gÆäë£Ô¥¥¥‹±Ëìü∫ÛÆ˜oﬂ}˚GãˆuUæ —\0ËÕ–¥UÚÀ+9q¡ò[˘ûΩ*ˆ%æ⁄vœ]üˇ¬ùÕü}˛//]brZ\\ûû€qhx_—æÆ*¬W9\Z\0Ω……f?≤*ü)2/fƒG3r˝õŸs$Ÿˆµ{;æÒÕ3”‚CCú1ƒ˘i!„whÔæ¢}]UÑØr4\0z+\n–@« √où9í>òÿ=öÿ}‡¯û√cˇ⁄{Ïç#ßvçˇœË€ªº=|Ë¯ëÔ=˜«Õt=†<	_◊¢–õæ\nÎ·á™ÊÌmﬂΩˇ˛¢]UÑØr4\0z3√˜<Ukæ —\0Ëm.|gœQµ·´\rÄﬁÃ=K’ZÑØr4\0z3√˜Ukæ —\0ËÕﬂ©ZãUé@of¯¶®ZãUé@oÑ/·´)\Z\0Ωô·˚ÅeπËaõ-´<†˝ìŒç®Ë,™[Áv4\0zì!2;˚æeπïNWÕeÿÔ[ÈÕ ŒçNuÎ‹é@of<M8Q÷ëK“∞ÃìÂBÛ&õ›Ùºé·´\rÄﬁÃ®:]ﬂ*î◊øUÎ°n˙∏öÛ:1F’≠s;\Z\0Ωô	5ÓDYG.	ƒÚõ=∂ˇn—¡+Ì‚\\æ —\0ËÕå™˜ú®jé\\∫M—3∂/;‹∞ÀM7´˚ËT∑ŒÌh\0ÙÊh<Uä≈¢–,ç—≤Y|”«•¡Ì––ﬂ˘Ä@ofBΩ[ﬂ*Ÿû¥Ÿæ“ÖOﬁÙqπîØÛ–\nO™∫unG†∑πÑ %ù(Î»˘◊—v„“Á+æûP·D7=fΩFß∫unG†73°N9Q÷ëÛlNd≥A·ì7}\\.†Z˛\\™[Áv4\0z3Í\' :r˛AŸ}ëÂø¨t¿J)⁄¿π°ÂÆ∫unG†73°∆Í^‚òıÁç“ÎÿÏ[˙|•ÌK7∞9~Ω®∫unG†73°NRµ·´\rÄﬁÃ=A’ZÑØr4\0z#|	_M—\0ËMÜH.wú™µ_Âh\0ÙfÜÔ€T≠E¯*G†73|T≠E¯*G†73|ﬂ¢j-¬W9\Z\0Ωy<û+W‰r«®öäUé@o^Ø˜‘©◊rπ£TME¯*G†∑`0¯è˛M9Ò&U}ΩïxŸÁÛ©nù€æ–[oooOœï«ô^ıÁËSëHDuÎ‹éÖﬁí…§œ˜•+∆HN°™¨PhU<W›:∑#|°Ωıs÷‰ƒa™ö˙[Ï7·pPu”@¯BÜa˜ˇUàCî}•RÚ/\nÈÙêÍ¶Å≈ÇêH$¸˛eâÑ¸´ÙA™R…‰ïˇó\Z|Auª0á≈1<<,Û∑∑˜GB†J+∆ÁÛ˛Iu£p\r·ãÖ√0åûûH pO4˙ÀTjá£T:˝ÔXÏ◊·pg(êèU∑◊æXh#ëo∑∂~ŒÊ√+›£π˘3·jôø™€ÇbÑ/‡Ó•Ö\r¬pJo·EeL¿)Ñ/l09\0ßæ∞¡‰\0úB¯¬ìp\n·L¿)Ñ/l09\0ßæ∞¡‰\0úB¯¬ìp\n·L¿)Ñ/l09\0ßæ∞¡‰\0úB¯¬ìp\n·L¿)Ñ/l09\0ßæ∞¡‰\0Í)ã…Ãıx<~ø_>hmmï.]∫4ëH®æ4Ã/Ñ/PO€∂m+˝8âéééx<Æ˙“0øæ@=Ü±d…í¬‰]æ|π\\ˇ¶”i’óÜ˘ÖÍl›∫uã-≤¬wÌ⁄µ===™/\nÛ·‘_KKK>yª∫∫º^Ø\\´æ\"Ã;Ñ/PªvÌZºx±ﬂ`0»´Ω(ã±j’™|¯™æÃSÑ/‡àT*%√ó;ÃP	·8Ö7Y¿ìça±X,Ø◊[z◊≠K»±Àü@(äF£‹Ë6æXP˙˚˚eË»‰›≤eÀŒÅÅìcc3ôå;Ké]˛˙˙˙∫ªªÂœDF∞ÍÊ‡Ñ/π∏ãD\"ùùù„ß«g23Taù=wVF∞¸·§R)’ç¬5Ñ/ôº~øˇ≈Õ/Ãd¶©Jµ˝ïÌÌÌÌ…dRuª0á≈B ◊ºfÚ^•ÏkÁ¿éï+øÆ∫]òC¯B{˝˝˝ùù´3YÉ™¶˚ŸO7lxRu”@¯BsÜaxΩﬁ”…Lˆ\nUMMN}‘÷∂úêï#|°∑h4\ZâD2ŸÀVuøUÂÕXÖ{π™6l¯øÎG9¬zÖB}[ˇ~=yWw~ ƒª≥‚DFõá¶≈»dv„÷◊_õ∏∏wF¸◊{\r1tYÏ∏*~?t‰¡5)œA%µtÿÔ˜´nù€æ–õœÁ;zÙ@&;ï/πûùb*\'.f≈ÖqYàü¸¸â¶O|z≈Í–DFåOãÒ´\"iàìYÒ“áÃ≈ÔîkrÍº«„Q›:∑#|°∑ÊÊÊsÁ\'2Ÿ…|…<Ω<+¶gÁæïÕÕ˝˘Ú´ˇ¸‚óøÚãßûŒ\nq)+.fƒÖåH±cﬂa3|\'›YMºıY5\Z\0Ωôz…*˘ÂTVúø\"ffØmêNß˜ÏÛO˛ˆŸÒ˜Áﬁ_ê…â3î˜Ï?T¥Ø´äUé@ofÄ˛œ™πùg/ã\'EFàôÈiﬂ≤eMMw45yÓˇ^w·é#£äˆuUæ —\0ËÕ–ãVÂ_vê+ﬂ˜/â3W≈»—wZZZÓXÙ…O›yW¯˚7ÑÔæ˝£E˚∫™_Âh\0Ùfh⁄*˘Âïú∏`Ã≠|œ^˚_mªÁÆœ·ŒÊœ>ˇóóÆ\n19-.OœÌ84ºØh_W·´\rÄﬁdàd≥Yïœôø3‚£π˛ÕÏ9íl˚⁄Ωﬂ¯ÊôiÒ°!Œ‚¸¥êÒ;¥w_—æÆ*¬W9\Z\0Ωh†cÂ·∑NåILÏMÏ>p|œ·±Ì=ˆ∆ëSªFèˇgÙÌ›ﬁ>t¸»â˜û˚„Ê∫PÇÑØk—\0ËÕﬂÖı√UÛˆ∂Ôﬁ—éÆ*¬W9\Z\0Ωô·{û™µ_Âh\0Ù6æ≥Á®ZãUé@of¯û•j-¬W9\Z\0Ωô·{Ü™µ_Âh\0ÙfÜÔáT≠E¯*G†73|ST≠E¯*G†7¬ó’\rÄﬁÃ˝¿°≤?∏ı›≤˜Wyê¢⁄ßÓCS›:∑£–õëŸŸ˜Î^E	XÙL·fïv/}\\zÃ¬\'ã∂¥?~]®∫unG†73û&\ZP÷â™9£˝∆EOñn\\”πny8™[Áv4\0z3„Èt›´∞˘«÷3•*Ì^vÀ“Ω\n7+ÂƒËÚÁR›:∑£–õO„NT˛»÷Òãæ,z\\iﬂè¥¸1ãécÛ¿â—©nù€—\0ËÕåß˜Í[eW†˘ûŒÊ‘e7´ÙdÈ¡ÀÓR˜1™nù€—\0ËÕπx™îß’$c5ó›¶l‚æ\rÄﬁÃxz∑ÓUíÄÔZ\'*}Pv˜¢Éî=f•„84®¢S®nù€—\0Ëm.ßr…∫W·aÛè≠gJÿÔ~”o∞Ã ◊Å—Âœ•∫unG†73ûN’Ω\nõ\\êÜe∂±ﬂ›~Ø¢\rÏè\\«™nù€—\0ËÕÃ©wÍ^%ÀœwJOdsjkóõÓUÕ6\rPuÎ‹é@ofNç’Ω\nõ\\z¢≤ß.»ÎÚœﬂòÈ7Ÿ¿°—ÂOß∫unG†73ûNRµ·´\rÄﬁÃ=A’ZÑØr4\0z#|	_M—\0ËMÜH.wú™µ_Âh\0ÙfÜÔ€T≠E¯*G†73|T≠E¯*G†73|ﬂ¢j-¬W9\Z\0Ωy<û+W‰r«®öäUé@o^Ø˜‘©◊rπ£TME¯*G†∑`0¯è˛M9Ò&U}ΩïxŸÁÛ©nù€æ–[oooOœï«ô^ıÁËSëHDuÎ‹éÖﬁí…§œ˜•+∆HN°™¨PhU<W›:∑#|°Ωıs÷‰ƒa™ö˙[Ï7·pPu”@¯BÜa˜ˇUàCî}•RÚ/\nÈÙêÍ¶Å≈ÇêH$¸˛eâÑ¸´ÙA™R…‰ïˇó\Z|Auª0á≈1<<,Û∑∑˜GB†J+∆ÁÛ˛Iu£p\r·ãÖ√0åûûH pO4˙ÀTjá£T:˝ÔXÏ◊·pg(êèU∑◊æXh#ëo∑∂~Æ“gC∏JsÛg¬·’2U∑≈_¿)‹KÑ/‡î&ﬁ¬ã òÄS_ÿ`r\0N!|aÉ…8ÖÖ\r&‡¬6òÄS_ÿ`r\0N!|aÉ…8ÖÖ\r&‡¬6òÄS_ÿ`r\0N!|aÉ…8ÖÖ\r&‡¬6òÄS_ÿ`r\0N!|aÉ…‘S,ìôÎÒx¸~ø|–⁄⁄*ˇ\\∫ti\"ëP}iò__†û∂m€V˙qÒx\\ı•a~!|Åz2c…í%Ö…ª|˘rπ˛Mß”™/\rÛ·‘Ÿ∫uÎ-ZdÖÔ⁄µk{zzT_Ê¬®øñññ|ÚvuuyΩ^πV}Eòw_†˛vÌ⁄µxÒbæ¡`êW{Q·8b’™U˘U}!òß_¿©TJÜ/wò°¬p\no≤Ä\r&\Z√0b±X8^Ø∑ÙÆ[óêcó?ÅP(çFπ—m\"|±†Ù˜˜À–ë…ªeÀñù\'«∆f2wñª¸	ÙııuwwÀüâå`’Õ¡\r_,rqâD:;;«Oèœdf®¬:{Ó¨å`˘√I•R™Ök_,2y˝~ˇãõ_ò…LSïj˚+€€€€ì…§Íva·ãÖ@ÆyÕ‰ΩJŸ◊ŒÅ+W~]uª0áÖˆ˙˚˚;;Wg≤UM=ˆ≥ünÿ§Í¶ÅÖÊ√zΩß\'íôÏ™ööú˙®≠m97 +G¯Bo—h4âd≤ó≠Í~´ õ±\n˜rUmÿ+~◊èrÑ/Ù\nÖ˙∂˛˝zÚÆÓ¸@àwg≈âå86-Mãë…Ï∆≠Øø6qqÔå¯Ø!ˆ\ZbË≤ÿqU¸~Ë»ÉkRûÉJjˇË∞ﬂÔW›:∑#|°7üœwÙËÅLv*_r=;)ƒTN\\Ãä3‚≤?˘˘Mü¯Ùä’°âåü„WE“\'≥‚•7ôãﬂ)÷‰‘yè«£∫unG¯BoÕÕÕÁŒOd≤ì˘íyzyVLœŒ}+õõ˚ÛÂWˇ˘≈/ÂO=ù‚RV\\Ãàëb«æ√f¯N∫≥öxÎ≥j4\0z3ÙíUÚÀ©¨8EÃÃ^€ ùNˇÓŸÁü¸Ì≥„ÔœΩø ì3f(ÔŸ®h_W·´\rÄﬁÃ\0˝üUs·;+Œ^Näå3””æeÀööÓhjÚ‹ˇΩÓ¬GFÌÎ™\"|ï£–õ†≠ øÏ WæÔ_gÆäë£Ô¥¥¥‹±Ëìü∫ÛÆ˜oﬂ}˚GãˆuUæ —\0ËÕ–¥UÚÀ+9q¡ò[˘ûΩ*ˆ%æ⁄vœ]üˇ¬ùÕü}˛//]brZ\\ûû€qhx_—æÆ*¬W9\Z\0Ω……f?≤*ü)2/fƒG3r˝õŸs$Ÿˆµ{;æÒÕ3”‚CCú1ƒ˘i!„whÔæ¢}]UÑØr4\0z+\n–@« √où9í>òÿ=öÿ}‡¯û√cˇ⁄{Ïç#ßvçˇœË€ªº=|Ë¯ëÔ=˜«Õt=†<	_◊¢–õæ\nÎ·á™ÊÌmﬂΩˇ˛¢]UÑØr4\0z3√˜<Ukæ —\0Ëm.|gœQµ·´\rÄﬁÃ=K’ZÑØr4\0z3√˜Ukæ —\0ËÕﬂ©ZãUé@of¯¶®ZãUé@oÑ/·´)\Z\0Ωô·˚Ac™Ù\\’<cs¥RçãÍ÷π\rÄﬁdàÃŒæﬂ∞*<]ŸS[O•j—ìE[⁄–πÅ®nù€—\0ËÕ¨âîÕõÂ\n∑)ªcŸ/m4f8™[Áv4\0z3Ît™“â¨ÁKî›´p≥r9ﬁà±‰œÆ∫unG†73∞∆PïNd=_†7|´h«¬Ì+=hÃpT∑ŒÌh\0Ùf÷{\r®J\'*zﬁ˙≤˘¬\'?Ë2[6l,˘s©nù€—\0Ë≠ë·[˘5_ª‰≠Ù-˚Cæ\rÄﬁÃ¿zw>‘ç˙nI™^ﬂ¨tG%W´∫unG†∑π‰ %\\Ö\'µøÄ“ÔZœî_˘6p™[Áv4\0z3ÎT*\"ÎtÖÁ-z\\È[e7(ªMcÜ£∫unG†73πﬁi@ÂOTt∫¬\'?N’2{~y”m\Z6’≠s;\Z\0Ωô…5Êtû•‰ÖÇÚ€ó{I·&4f,÷®nù€—\0ËÕ¨ìT≠E¯*G†73|OPµ·´\rÄﬁ_¬WS4\0zì!íÀßj-¬W9\Z\0Ωô·˚6Ukæ —\0ËÕﬂUkæ —\0ËÕﬂ∑®ZãUé@oèÁ ïπ‹1™¶\"|ï£–õ◊Î=uÍµ\\Ó(USæ —\0Ë-˛£SNºIU_o%^ˆ˘|™[ÁvÑ/Ù÷€€€”ÛCÂq¶W˝9˙T$Q›:∑#|°∑d2ÈÛ}Èä1íG®*+Zè«U∑ŒÌ_ho˝ú59qò™¶˛˚M8T›4æ–üaÅ¿Ω√√‚e_©‘Ä¸ãB:=§∫i |± $	øY\"!ˇ*}ê™T2yÂˇ•_P›.Ã!|±@À¸ÌÌ˝ë®“ä«üÒ˘ºÉÉR›(\\C¯b·0£ß\'‹ç˛2ï⁄!ƒ(ïNˇ;˚u8‹\n‰c’-¬uÑ/ö¡¡¡H‰€≠≠ü´ÙiÆ“‹¸ôpxµÃ_’mA1¬p\n˜“¬·8•â∑¢2&‡¬6òÄS_ÿ`r\0N!|aÉ…8ÖÖ\r&‡¬6òÄS_ÿ`r\0N!|aÉ…8ÖÖ\r&‡¬6òÄS_ÿ`r\0N!|aÉ…8ÖÖ\r&‡¬6òÄS_ÿ`r\0ıã≈dÊz<øﬂ/¥∂∂ ?ó.]öH$T_\ZÊ¬®ßm€∂ï~úDGGG<W}iò__†û√X≤dIaÚ._æ\\Æ”È¥ÍK√¸B¯u∂n›∫EãY·ªvÌ⁄ûû’ÖyáÍØ••%üº]]]^ØW.áU_Ê¬®ø]ªv-^ºXÜo0‰’^îE¯éXµjU>|U_Ê)¬pD*ïí·Àf®Ñú¬õ,`É…‘çaÒx|˝˙ı°P(±`0(üâF£r-¨˙1èæ@»ÃïÅ[˙ˆä\"~ø”¶M‹¸\0A¯∑ippp≈ä7ç›B^Øó[ @¯∑H.`#ëHÈ⁄ˆ±«~÷◊∑uÁ¿ÎV=˛¯ùùùE[ ï2o{s3¬∏©T™h¡˚»#?>966ì…V™≥ÁŒˇ·πÁÚøj«Z<xPıP†·‘,ôL ‹¥24⁄«nQÀÖ∞µØ«„V= (@¯µ1£pÕ˚‘Ü\rU∆namŸÚ2v≠ı/7B∏·‘&[…€◊∑ıí7_#˚GõõõÛ«	™áÖF#|Å\Zƒ„Ò€\\Û÷ˆW^µé∂q„F’ÉCCæ@\rÚüOëù˜6ì7_÷Îø≠≠≠‹ˇÎ*Ñ/P≠¸GÂˇïl¸ÙD]¬˜“‰îuˇ√£è>™zàh¬®V ∞Ó*´KÚÊÎ≈ÕõÛámnnV=D4·T%ùN[Øœ÷kŸk’›w_ªqmppPı@— Ñ/Pïh4j›ôPﬂ‰ïı‡ÉÂŒπ·TeÕö5ı∫…°¥vºû?¯ä+T\rB¯U	É˘|‹˛ ´uﬂìcc÷.T\rB¯U±n2Ÿ?Z˜ïeΩ†¨z†h:\rT≈∫!¨˙_„PSY«W=P4ù™‚Û˘Ú·¯Ê—£NÑØı´T\rBßÅ™X7˘ÓxΩÓ…{ˆ‹ynıu¬®äı{”ˇ‹su_πöŒ‹Ô˜´(\ZÑ™“€€õœ«ÓÓ‘=|ü⁄∞!p8¨z†h¬®J\"ë∞^∏49Uﬂ]πre˛‡—hTı@— Ñ/P-Î”+nÁ◊¯ññuìØƒß∫π·T´ßß\'ëmmmu\\¸~Áæ˚Úá\rÖB™áà∆!|Åj…e©u7nΩﬁd<¥{èµÏÂ√4]Öj∞q„∆|Pz<û€øÁÏ‰ÿòïÊk÷¨Q=84·‘∆˙ÙLôõ∑Ûn∑KìSmmm÷°¯M∑!|Å⁄$ìIÎÉ/ehﬁ⁄Øz?=a%Ø\\DÛk|]àj&≥“z°VFg≠oª⁄Ω«zµ°âèŒt+¬∏Òx‹ZˇÊÔ®ÊWM Ô]]MH^◊\"|Å[îH$¨ﬂ∂cE„è?Q˙õwdÊ ’qggg·∆2ªyµ¡Õ_‡÷•”ÈıÎ◊[øê¨H{{{•oÖ√a˛ÖÕÂ_‡v…µ~ÌŒMÅ··a’óı_†>√à≈b2Ö≠œº∞xΩﬁP(¥i”&Vª∞æ\0†\0·\0\næ\0†\0·\0\næ\0†¿ˇΩ5áU#rï{\0\0\0\0IENDÆB`Ç',0),('2503',1,'diagrams/HelloWorld.bpmn','2501','<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<definitions xmlns=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:activiti=\"http://activiti.org/bpmn\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:omgdc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:omgdi=\"http://www.omg.org/spec/DD/20100524/DI\" typeLanguage=\"http://www.w3.org/2001/XMLSchema\" expressionLanguage=\"http://www.w3.org/1999/XPath\" targetNamespace=\"http://www.activiti.org/test\">\n  <process id=\"HelloWordlKey\" name=\"HelloWordlName\" isExecutable=\"true\">\n    <userTask id=\"usertask1\" name=\"Êèê‰∫§Áî≥ËØ∑\" activiti:assignee=\"Âº†‰∏â\"></userTask>\n    <userTask id=\"usertask2\" name=\"ÈÉ®Èó®ÁªèÁêÜ\" activiti:assignee=\"ÊùéÂõõ\"></userTask>\n    <userTask id=\"usertask3\" name=\"ÊÄªÁªèÁêÜ\" activiti:assignee=\"Áéã‰∫î\"></userTask>\n    <endEvent id=\"endevent1\" name=\"End\"></endEvent>\n    <sequenceFlow id=\"flow3\" sourceRef=\"usertask1\" targetRef=\"usertask2\"></sequenceFlow>\n    <sequenceFlow id=\"flow4\" sourceRef=\"usertask2\" targetRef=\"usertask3\"></sequenceFlow>\n    <sequenceFlow id=\"flow5\" sourceRef=\"usertask3\" targetRef=\"endevent1\"></sequenceFlow>\n    <startEvent id=\"startevent1\" name=\"Start\"></startEvent>\n    <sequenceFlow id=\"flow6\" sourceRef=\"startevent1\" targetRef=\"usertask1\"></sequenceFlow>\n  </process>\n  <bpmndi:BPMNDiagram id=\"BPMNDiagram_HelloWordlKey\">\n    <bpmndi:BPMNPlane bpmnElement=\"HelloWordlKey\" id=\"BPMNPlane_HelloWordlKey\">\n      <bpmndi:BPMNShape bpmnElement=\"usertask1\" id=\"BPMNShape_usertask1\">\n        <omgdc:Bounds height=\"55.0\" width=\"105.0\" x=\"235.0\" y=\"100.0\"></omgdc:Bounds>\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape bpmnElement=\"usertask2\" id=\"BPMNShape_usertask2\">\n        <omgdc:Bounds height=\"55.0\" width=\"105.0\" x=\"235.0\" y=\"180.0\"></omgdc:Bounds>\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape bpmnElement=\"usertask3\" id=\"BPMNShape_usertask3\">\n        <omgdc:Bounds height=\"55.0\" width=\"105.0\" x=\"235.0\" y=\"260.0\"></omgdc:Bounds>\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape bpmnElement=\"endevent1\" id=\"BPMNShape_endevent1\">\n        <omgdc:Bounds height=\"35.0\" width=\"35.0\" x=\"270.0\" y=\"340.0\"></omgdc:Bounds>\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape bpmnElement=\"startevent1\" id=\"BPMNShape_startevent1\">\n        <omgdc:Bounds height=\"35.0\" width=\"35.0\" x=\"270.0\" y=\"40.0\"></omgdc:Bounds>\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNEdge bpmnElement=\"flow3\" id=\"BPMNEdge_flow3\">\n        <omgdi:waypoint x=\"287.0\" y=\"155.0\"></omgdi:waypoint>\n        <omgdi:waypoint x=\"287.0\" y=\"180.0\"></omgdi:waypoint>\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge bpmnElement=\"flow4\" id=\"BPMNEdge_flow4\">\n        <omgdi:waypoint x=\"287.0\" y=\"235.0\"></omgdi:waypoint>\n        <omgdi:waypoint x=\"287.0\" y=\"260.0\"></omgdi:waypoint>\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge bpmnElement=\"flow5\" id=\"BPMNEdge_flow5\">\n        <omgdi:waypoint x=\"287.0\" y=\"315.0\"></omgdi:waypoint>\n        <omgdi:waypoint x=\"287.0\" y=\"340.0\"></omgdi:waypoint>\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge bpmnElement=\"flow6\" id=\"BPMNEdge_flow6\">\n        <omgdi:waypoint x=\"287.0\" y=\"75.0\"></omgdi:waypoint>\n        <omgdi:waypoint x=\"287.0\" y=\"100.0\"></omgdi:waypoint>\n      </bpmndi:BPMNEdge>\n    </bpmndi:BPMNPlane>\n  </bpmndi:BPMNDiagram>\n</definitions>',0),('5002',1,'diagrams/HelloWorld.png','5001','âPNG\r\n\Z\n\0\0\0\rIHDR\0\0”\0\0|\0\0\0÷∆¡\0\0 àIDATxúÌ›olw˝¿Òàµ‘T†1HƒìÒ†~\0ç≈&•è®Sâ∆H¿,Q5Ü¡“÷jbLç¥±ñ±Q°Qu∞‘FSZKÎFXõJ⁄Ö6Mˇ≠≠˚\'´∑4ù˚ﬂ•I{MÏ¯˚˚Êº]]€Á⁄≠Ôæπ‹˚•è*◊Òø˚ﬁÒÊÍ9IÉ\0\0ÿ´Aı\0\0◊°º\0`7 \0v£º\0`7 \0v£º\0`7 \0v£º\0`7 \0v£º\0`7 \0v£º\0`7 \0v£º\0`7 \0v£º\0`7 \0v£º\0`7 \0v£º\0`7 \0v£º\0`7 \0v£º\0`7 \0v£º\0`7 \0v£º\0`7 \0v£º\0`7 \0v£º\0`7 \0v£º\0`7 \0v£º\0`7 \0v£º\0`7 \0v£º@›höè«◊Æ]\nÖÉÚöX,ñNßUø@Ãî®\\YXè«#õ+;€”≥ugﬂ€˘Ÿ˛∆õœ>˚\\8nll\\≤dI4\ZU˝b°ÂÓÀ¡ÉÂâ≠Æ,ÏT&[yvÔÈÏ¸ÅﬂÔÔÔÔW˝¬°ÂÓ]ww∑Ã®<±Ωksghˇ“•KW≠Z•iöÍ-Ä\Zî∏2ö·p∏´´´¶ÊŒ6nî\'À©TJı¶@ ‘Lfw…í%±XÏû≥kº˘ \'ôL™ﬁ ÿçÚ5ìgª˜ü]„ù_ﬁvp ‘¶ªª˚~ﬁd(ùûû≠°PHıf¡Vî®¡¡É˝~≥õü«b”¶M™7ˆ°º@\rdváˆ◊Ωº£g«~ÿÀ{ÓAyÅj≈„ÒP(T˜ÏÊÁ©ß~ºa√’õõP^†ZÅ@†÷èÓ÷t⁄€‹‹¨za T%ùN766Zî›¸¥∂∂™ﬁPÿÅÚUâF£ëHƒ“ÚÆ[øæ´´KıÜ¬î® ™U´6m⁄diywˆΩTo(Ï@yÅ™É¡j~&Œ˝ÃÈëëáˆ™ﬁPÿÅÚU±ËÛdÖs}|¬„Ò®ﬁPÿÅÚUinn=;fiyÂ44?IW`7UÒ˘|Ô=JyQÏf†*ñ~òó˜y›ÜÚUâD\"ØnﬁliyvÔimmUΩ°∞Â™≤a√Üßû˙±•ÂïeÔÏ¸ÅÍ\rÖ(/Pïd2Èız--o{{{ooØÍ\rÖ(/P-Kˇ#€ıÒâ∆∆F~\\ôKP^†Zñæ·¬ã/ WΩâ∞	Â™%OHΩ^ØüÍï\'º?ÏÂ∑a∫Âjã≈Vvtp¬ã˚DyÅ⁄|Á±«zz∂÷1ªÔ=⁄““\"O{UoÏCyÅ⁄§”È÷÷÷z˝ß∂ãó.ÀÏûQΩY∞ÂjñH$d|e.Ô?ªÚz˚o™ﬁ ÿçÚ˜‚‡¡ÉÚ\\u`˜û˚yìAÊõÏ∫ÂÓQ:ù^∫tÈ≥œ>\'O]kjÓıÒâ^|1ˇñÖÍçÄ\Zî∏wö¶…Ú.Z‰ì%ï=≠&ªØnﬁ,oˇ‘S?ñΩV˝Ú°ÂÓW*ïz˙ÈßøÛÿc2¨•?@]^≥eÀˇ≠ÏËê∑ÈÏ¸A2ôT˝í°ÂÍCûˇ∆„ÒH$““““p\'yçÃn,Kß”™_&f XEVXıK¿,Ey´&`Ü#∞\nÂÖé¿*îf82\0´P^ò·»\0¨ByaÜ#∞\nÂÖé¿*îf82\0´P^ò·»\0¨ByaÜ#∞\nÂÖé¿*îf82\0´P^ò·»\0¨ByaÜ#∞\nÂÖé¿*îf82Äzä≈b2∏è«Ô˜ÀÕÕÕÚœÖ&	’/\r≥ÂÍi€∂m\r%⁄⁄⁄‚Ò∏ÍóÜYÑÚı§i⁄Ç\n≥ªxÒbyÊÀÔB! ‘Ÿö5kÊÕõgîwıÍ’]]]™_f ‘_SSS>ª^ØWû´~Eò](/PªvÌö?æ,o0‰^î¢ºÄ%ñ-[ñ/ØÍÇŸàÚñH•R≤º|òeQ^¿*|\'Ãpd`Æ—4-ãÖ√·@ ‡ızK?]Îr€Â\nÑB°h4 g⁄f ã9•∑∑WGfwÀñ-;˚˙NèåLe2ÓπÌrzzz:;;Âö»˛™ﬁ9∏çÚbéêßuëH§ΩΩ}ÙÏËTfä)úãó. ˛ ≈I•R™wfP^Ã2ª~øˇ’ÕØLe&≥Ÿ˛∆ˆ÷÷÷d2©zwÅÚbNêgªzvo1ïggﬂé•KøÆzwÅÚ¬˘z{{€€óg≤\ZSÕ<Û≥üÆ_ˇºÍùÊvîŒ¶iö◊Î=;ñÃdo2’Ã¯ƒ’ññ≈|–X- gãF£ëH$ìΩaL[[U~Ó™^ÆöıÎ≈ÒQãÚ¬ŸB°Pœ÷øﬂŒÓÚˆÖxZú àcì‚–§\Zœnÿ˙ˆ[c◊ˆNâˇjbØ&nà∑ƒÔé<æÍ	ÂT2˚á˝~øÍ]ÁjîŒÊÛ˘é=ê…N‰Gû…é1ë◊≤‚ î∏!ƒO~˛\\√\'>Ωdyh,#F\'≈Ë-ë‘ƒÈ¨xÌùC˙iÔÑg|‚≤«„QΩÎ\\çÚ¬Ÿ\Z/]Àd«Û#czcZLNœ|)õõ˘Ûı7ˇ˘≈/ÂÎ^»\nq=+ÆeƒïåH±cﬂaΩº„Óúæ≥Y)VŒ¶◊Û∫1ÚØYq˘¶òö˛ËÈt˙w/Ω¸¸o_\Z=7ÛMôúò“ãºgˇ°¢˚∫j(ØZ¨>úMØÁˇåô)Ô¥∏xCú!¶&\'}ã54<––‡YÒΩŒ¬;\r(∫Ø´ÜÚ™≈Í√ŸÙz^3&ˇnÉ<Á=w]\\∏%Üéæ◊‘‘Ù¿ºO~Í¡á¬ﬂø£º˚ˆ›◊UCy’bı·lz=”∆»øﬁÃâ+⁄Ã9Ô≈[¢o_‚´-è<Ù˘/<ÿ¯ŸóˇÚ⁄-!∆\'≈ç…ô;Ó+∫Ø´ÜÚ™≈Í√ŸdA≤Ÿ´∆‰É\"„{-#ÆN…3ﬂÃû#…ñØ=⁄ˆço^òÁ5qAó\'ÖlÔ¿ﬁ}E˜u’P^µX}8[Q=mK?5t$1x0±{8±˚¿…=áG˛µ˜ÿ;GŒÏ\Z>˘ü·ªú<tÚ»©6˛qÛ éï Hy›â’á≥ÈÂΩR8O>˘D5ﬂ¿ˆ›+äÓË™°ºj±˙p6ΩºóôZáÚ™≈Í√Ÿf ;}â©u(ØZ¨>úM/ÔE¶÷°ºj±˙p6ΩºòZáÚ™≈Í√ŸÙÚûgj ´´g”Àõbj ´´g£ºî◊âX}8õ^ﬁ≠„ëã>\\·ñU>`Â+≠€¢¢gQΩÎ\\ç’á≥…ÇLOü≥båG.|\n≥ß´ÊeTæØŸw|X∑u™wù´±˙p6ΩMcVåÒ»%),seπbﬁÂfw}^KáÚ™≈Í√ŸÙNù≠Ôî´‰Ì/’˙PwΩ\\ÕÛZ±ç™wù´±˙p6=O£VåÒ»%5,≥¢ÀïøZÙ‡fw±n(ØZ¨>úMÔ‘VL5è\\zõ¢k*æ€p«]Óz≥∫oùÍ]Áj¨>úÕ“6ô5±®ò•\r-‚ª^.≠∂EõFyïcı·lzûﬁØÔˆé++‹ﬁÏÖWﬁırπƒ◊y”\nüTıÆs5VŒ6ìß\\“ä19·v\r+ﬁ∏Ùz”∑LûËÆèYØ≠SΩÎ\\ç’á≥Èy:c≈èúøP·â*‹† ª^.WgK6-ˇ\\™wù´±˙p6=OÔY1∆#Á/î}¢è˚X˛Øfhˆ E7∞n”ÚÆz◊π\Z´g”Û4R˜˘∏Ü#∆üwûäﬁæAÖ˚ñ^ov˚“Tx¸zm†Í]Áj¨>úMœ”i¶÷°ºj±˙p6ΩºßòZáÚ™≈Í√Ÿ(/Âu\"VŒ&íÀùdj ´´g”À{Ç©u(ØZ¨>úM/oÇ©u(ØZ¨>úM/Ôq¶÷°ºj±˙p6è«sÛÊÅ\\ÓS”P^µX}8õ◊Î=sÊ≠\\Ó(S”P^µX}8[0¸GÔ¶úxó©~é\'^˜˘|™wù´Q^8[wwwW◊ï∑ÃYÛÁË∫H$¢z◊π\ZÂÖ≥%ìIüÔK7µ°ú8¬T9°–≤x<Æz◊π\ZÂÖ„≠ù±*\'3’Ãﬂbø	áÉ™wö€Q^8û¶iÅ¿£ÉÉ‚SyR©>˘OÑtz@ıNs; ãπ ëH¯˝ã	˘/ËÉåŸ»Ï ˇãÍÔEıÓÂ≈\\188(„€›˝#!0•èøËÛy˚˚ˇ§zGaÂ≈‹°iZWW$x$\Z˝e*µCàa&ù˛w,ˆÎp∏=\n»À™w>By1◊Ù˜˜G\"ﬂnn˛\\Öﬂ>Èççü	áóÀ¯™ﬁ-∏Â¨¬gfaÜÚVi‡;taÇ#∞\nÂÖé¿*îf82\0´P^ò·»\0¨ByaÜ#∞\nÂÖé¿*îf82\0´P^ò·»\0¨ByaÜ#∞\nÂÖé¿*îf82\0´P^ò·»\0¨ByaÜ#∞\nÂÖé¿*îf82Äzä≈b2∏è«Ô˜ÀÕÕÕÚœÖ&	’/\r≥ÂÍi€∂m•ø¢≠≠-è´~iòE(/POö¶-X∞†0ªã/ñgæÈtZıK√,ByÅ:[≥fÕºyÛåÚÆ^Ω∫´´Kıã¬ÏByÅ˙kjj g∑££√Îı a’Ø≥ÂÍo◊Æ]ÛÁœóÂ\rÉº√ãRî∞ƒ≤eÀÚÂU˝B0Q^¿©TJñóì°, XÖÔ§ÄéÃ5ö¶≈b±p8º^oÈßk]Bnª\\ÅP(çF˘L€lCy1ßÙˆˆ ‚»ÏnŸ≤eg_ﬂÈëë©L∆ù#∑]Æ@OOOggß\\Ÿ_’;∑Q^ÃÚ¥.â¥∑∑èûù L1ÖsÒ“EŸ_π8©TJıé¬ ãπ@f◊Ô˜ø∫˘ï©Ã$c6€ﬂÿﬁ⁄⁄öL&UÔ.P^Ã	ÚlWœÓ-¶ÚÏÏ€±tÈ◊UÔ.P^8_ooo{˚ÚLVc™ôg~ˆ”ıÎüWΩ”‹éÚ¬Ÿ4MÛzΩg«íôÏM¶öü∏⁄“≤ò\Z´Ey·l—h4âd≤7åi~´ œ]ﬁÀU≥~˝Ø¯!>jQ^8[(ÍŸ˙˜€Ÿ]ﬁ˛°ÔOãSqlRöC„Ÿ\r[ﬂ~kÏ⁄ﬁ)Ò_MÏ’ƒ¿\r±„ñ¯˝¿ë«W=°<ÇJfˇ†ﬂÔWΩÎ\\çÚ¬Ÿ|>ﬂ—£2Ÿâ¸»3Ÿq!&r‚ZV\\ô7Ñ¯…œük¯ƒßó,çeƒË§Ω%íö8ùØΩsH?Ìùp·åO\\ˆx<™wù´Q^8[cc„•ÀcôÏx~dLoLã…Èô/es3æ˛Ê?ø¯ÂØ¸b›Y!Æg≈µå∏íi!vÏ;¨ów‹ù”¿w6+≈Í√ŸÙz^7F˛u\"+.ﬂS”› ùNˇÓ•óüˇÌK£Áfæâ ìSzë˜Ï?Tt_W\rÂUã’á≥Èı¸ü13ÂùoàÛ„\"#ƒ‘‰§o—¢ÜÜ\Z\Z<+æ◊Yx«°·E˜u’P^µX}8õ^œk∆‰ﬂmêÁºÁÆã∑ƒ–—˜öööò˜…O=¯P¯˚wîwﬂ˛·¢˚∫j(ØZ¨>úMØg⁄˘◊õ9qEõ9ÁΩxKÙÌK|µÂëá>ˇÖ?˚Ú_^ª%ƒ¯§∏19s«Å¡}E˜u’P^µX}8õ,H6{’ò|Pd|Øeƒ’)yÊõŸs$ŸÚµG€æÒÕì‚º&.h‚Ú§êÌÿªØËæÆ\Z ´´g+™g†mÈ·„ßÜé$&v\'v8πÁ»øˆ{Á»ô]√\'ˇ3|b˜ÅÉáN9ı¡∆?n^Ÿ±Ry)Ø;±˙p6ΩºW\nÁ…\'ü®ÊÿæªbE—]5îW-VŒ¶ó˜2SÎP^µX}8€Lyß/1µÂUã’á≥ÈÂΩ»‘:îW-VŒ¶ó˜SÎP^µX}8õ^ﬁÛL≠Cy’bı·lzySL≠Cy’bı·lîóÚ:´g”À˚°ES˘¡çØñ˝ºpïRÙÄßÓõ¶z◊π\Z´gìôû>W˜) _—5Ö73ª{ÈÂ“«,º≤Ëñïø.®z◊π\Z´g”€4f√OTÕ3Væq—ï•7ÆÈπÓysTÔ:Wcı·lzõŒ÷}\n6Ÿ∏¶ÙÇŸ›Àﬁ≤Ù^Ö7+e≈÷ÂüKıÆs5VŒ¶∑i‘ä…?≤Ò¯E-∫lvﬂèÎY˛1ãß¬+∂NıÆs5VŒ¶∑ÈÉ˙NŸsœ¸>]Öß.{3≥+KºÏ]Íæç™wù´±˙p6Î⁄d”j≤XÕçÀﬁ¶lÓ)Ô‹√Í√ŸÙ6Ω_˜)…ﬂ˚∆ï^({˜¢)˚òfèc—F=ÖÍ]Áj¨>úm&Rπd›ßaÛóçkJ/Tæ˚]øT¯ÄeŒy-ÿ∫¸s©ﬁuÆ∆Í√ŸÙ6ù©˚>l˛rA\nÀ‹¶Ú›+ﬂ´Ëïπé®z◊π\Z´g”#ı^›ß‰ƒÛΩ“\'™‘∆]ÓzØjnc—™ﬁuÆ∆Í√ŸÙHç‘}\n6πÙâ >uA¨À_g–Ôrã∂.ˇt™wù´±˙p6ΩMßôZáÚ™≈Í√ŸÙÚûbj ´´g£ºî◊âX}8õ,H.wí©u(ØZ¨>úM/Ô	¶÷°ºj±˙p6Ωº	¶÷°ºj±˙p6Ωº«ôZáÚ™≈Í√Ÿ<œÕõrπcLMCy’bı·l^Ø˜Ãô∑rπ£LMCy’bı·l¡`Ωõr‚]¶˙9ûx›ÁÛ©ﬁuÆFy·l›››]]?Tﬁ2gÕü£Î\"ëàÍ]ÁjîŒñL&}æ/›‘Ür‚SÂÑBÀ‚Ò∏Í]Ájîé∑v∆™ú8ÃT3ã˝&™ﬁinGy·xö¶è˛UàCLÂI•˙‰?“È’;ÕÌ(/ÊÇD\"·˜/J$‰ø†2f#≥+ˇ/™øˇ’ªîs≈‡‡†åow˜èÑ8¿îN<˛¢œÁÌÔˇìÍÖîsá¶i]]ë@‡ëhÙó©‘!Üôt˙ﬂ±ÿØ√·ˆP( /´ﬁE¯Â≈\\”ﬂﬂâ|ªπ˘sføÂ¡U\Z?/óÒUΩ[p XÖœÃ¬Â¨“¿wË¬G` 3ÄU(/Ãpd\0V°º0√ëXÖÚ¬G` 3ÄU(/Ãpd\0V°º0√ëXÖÚ¬G` 3ÄU(/Ãpd\0V°º0√ëXÖÚ¬G` 3ÄU(/Ãpd\0ıã≈dp=èﬂÔóöõõÂü.L$™_\Zf ‘”∂m€J1D[[[<W˝“0ãP^†û4M[∞`Aav/^,œ|”È¥ÍóÜYÑÚu∂fÕöyÛÊÂ]ΩzuWWóÍÖŸÖÚı◊‘‘îœnGGá◊Îï\'¬™_f ‘ﬂÆ]ªÊœü/Àyá•(/`âeÀñÂÀ´˙Ö`6¢ºÄ%R©î,/&CYî∞\nﬂI3òk4Mã≈b·p8xΩﬁ“O◊∫Ñ‹vπ°P(\ZçÚô∂ŸÜÚbNÈÌÌï≈ëŸ›≤eÀŒææ”##Sôå;Gnª\\ÅûûûŒŒNπ&≤ø™wn£ºò#‰i]$ioo=;:ïôb\nÁ‚•ã≤ørqR©îÍÖîsÅÃÆﬂÔuÛ+SôI∆l∂ø±Ωµµ5ôL™ﬁ]†ºò‰ŸÆû›[LÂŸŸ∑cÈ“Ø´ﬁ]†ºpæﬁﬁﬁˆˆÂô¨∆T3œ¸ÏßÎ◊?ØzßπÂÖ≥iöÊızœé%3ŸõL53>qµ•e14VãÚ¬Ÿ¢—h$…do”¸Vïüª*ºó´f˝˙_ÒC|‘¢ºp∂P(‘≥ıÔ∑≥ªº˝C!ﬁüß2‚ÿ§84)Ü∆≥∂æ˝÷ÿµΩS‚øöÿ´âÅb«-Ò˚Å#èØzByïÃ˛·AøﬂØz◊π\ZÂÖ≥˘|æ£Gd≤˘ëg≤„BL‰ƒµ¨∏2%nÒìü?◊âO/Y\ZÀà—I1zK$5q:+^{Áê~⁄;·¬ü∏ÏÒxTÔ:W£ºp∂∆∆∆Kó«2ŸÒ¸»òﬁòì”3_ Êf˛|˝Õ~ÒÀ_˘≈∫≤B\\œäkq%#“BÏÿwX/Ô∏;ßÅÔlVä’á≥Èıºnå¸ÎDV\\æ)¶¶?∫A:ù˛›K/?ˇ€óFœÕ|A&\'¶Ù\"ÔŸ®ËæÆ\Z ´´g”Î˘?cf ;-.ﬁÁ«EFà©…Iﬂ¢E\r\r44xV|Ø≥éC√äÓÎ™°ºj±˙p6Ωû◊å…ø€ œyœ]nâ°£Ô555=0Ôìüz°˜Ô(Ôæ˝√E˜u’P^µX}8õ^œ¥1ÚØ7s‚ä6sŒ{ÒñË€ó¯jÀ#}˛6~ˆÂøºvKàÒIqcrÊéÉ˚äÓÎ™°ºj±˙p6Yêlˆ™1˘†»¯^Àà´SÚÃ7≥ÁH≤Âkè∂}„õ&≈yM\\–ƒÂI!€;∞w_—}]5îW-VŒVTœ@€“√«O\rILÏNÏ>prœ·ëÌ=ˆŒë3ªÜO˛g¯ƒÓ\'ù<rÍÉç‹º≤c•ÚR^wbı·lzyØŒìO>QÕ7∞}w≈ä¢;∫j(ØZ¨>úM/Ôe¶÷°ºj±˙p∂ôÚN_bj ´´g”À{ë©u(ØZ¨>úM/Ô¶÷°ºj±˙p6ΩºÁôZáÚ™≈Í√ŸÙÚ¶òZáÚ™≈Í√Ÿ(/Âu\"VŒ¶ó˜C{¶Ùπ™π¶¬£ï≤s[TÔ:Wcı·l≤ ””Álõ¬ß+˚‘∆ïEI-∫≤Ëñ–∫\rQΩÎ\\ç’á≥Èµ\Z≥a*|;\\·m ﬁ±Ï_+\\∞gsTÔ:Wcı·lz≠Œ⁄0fOd\\_z°ÏΩ\noV.‚vlK˛ŸUÔ:Wcı·lz≠Fm≥\'2Æ/®Á_*∫c·ÌÕ.ÿ≥9™wù´±˙p6ΩVÿ0fOTtΩÒ◊¬ÎØ¸∏Œeni€∂‰üKıÆs5VŒfgyÕﬂÁ≠î]≥/U~( ;∑±˙p6ΩVÔœÜπ3†Ôó$ıˆÕJÔ®‰’™ﬁuÆ∆Í√Ÿf≤ïK⁄<ÖOZ˘î~’∏¶¸9Øçõ†z◊π\Z´g”ku∆Ü…?ëÒtÖœ[tŸÏKeoPˆ6ˆléÍ]Áj¨>úMœ÷{6L˛âäûÆ èìZÊ^ÖΩÎml€’ªŒ’X}8õû≠´ßYJﬁ(˚rÔ$‹ÂˆlãÒTÔ:Wcı·lz≠N3µÂUã’á≥ÈÂ=≈‘:îW-VŒFy)Ø±˙p6Yê\\Ó$SÎP^µX}8õ^ﬁL≠Cy’bı·lzyL≠Cy’bı·lzyè3µÂUã’á≥y<ûõ7‰r«òöÜÚ™≈Í√Ÿº^Ôô3oÂrGôöÜÚ™≈Í√ŸÇ¡‡?z7ÂƒªLıs<Ò∫œÁSΩÎ\\çÚ¬Ÿ∫ªªª∫~®ºeŒö?G◊E\"’ªŒ’(/ú-ôL˙|_∫©\rÂƒ¶ 	Öñ≈„q’ªŒ’(/oÌåU9qò©f˛˚M8TΩ”‹éÚ¬Ò4M¸´áò ìJı…\"§”™wö€Q^ÃâD¬Ô_îH»AdÃFfW˛_Tˇ+™w(/Êä¡¡AﬂÓÓ	qÄ)ùx¸Eüœ€ﬂˇ\'’;\n3(/ÊM”∫∫\"Å¿#—Ë/S©B3ÈÙøc±_á√Ì°P@^VΩã ãπ¶øø?˘vsÛÁÃ~ÔÉ´46~&^.„´z∑‡î∞\nüôÖ X•ÅÔ–Ö	é¿*îf82\0´P^ò·»\0¨ByaÜ#∞\nÂÖé¿*îf82\0´P^ò·»\0¨ByaÜ#∞\nÂÖé¿*îf82\0´P^ò·»\0¨ByaÜ#∞\nÂÖé¿*îf82\0´P^ò·»\0Í)ã…‡z<øﬂ//477À?.\\òH$Tø4Ã\"î®ßm€∂ï˛bà∂∂∂x<Æ˙•a°º@=iö∂`¡Ç¬Ï.^ºXû˘¶”i’/\r≥ÂÍlÕö5ÛÊÕ3 ªzıÍÆÆ.’/\n≥ÂÍØ©©)ü›ééØ◊+OÑUø\"Ã.î®ø]ªvÕü?_ñ7Ú/JQ^¿Àñ-ÀóWı¡lDyK§R)Y^>LÜ≤(/`æìf82Ä∫—4-èØ]ª6\n>Â5—hTû´~Åò-(/P2∏≤∂•ﬂCQƒÔ˜o⁄¥âè:ÄÚ˜•øø…í%wmn!Ø◊À\\éÚ˜Hû∫F\"ë“≥⁄gû˘YOœ÷ù}oÛÏ≥œµ∑∑›Rû#ÛçmÆEyÅ{ëJ•äNuüzÍ«ßGF¶2Y≥πxÈÚ6nÃˇ„‰˜‡¡É™7\nP^†f…dRF”h0¨‹‹¢˛ S`„æègppPı¡nî®ç¶iÖgªÎ÷ØØ≤πÖ≥eÀˇ…Ê\Zgæ|Ï¡m(/Põp8ld∑ßgÎ=d7?C˚áÛèTolEyÅ\Zƒ„Ò˚<€-úÌoºi<⁄Ü\rToÏCyÅ\Z‰”D˛Ω›˚Ãn~å˜|õõõ˘úØ{P^†Z˘ﬂÙìˇœb£g«ÍRﬁÎ„∆ßû~˙i’õõP^†ZÅ@¿¯\0Y]≤õüW7oŒ?lcc£ÍMÑM(/Pït:mº\'[Ø^c~¯£œ®ı˜˜´ﬁPÿÅÚUâF£∆ÁÍõ]9è?˛D˛¡˘ΩA.AyÅ™¨Zµ™^i(ùù}oÁ|…í%™7v†º@UÇ¡`>é€ﬂx≥ÓÂ==2b|WÖÍ\rÖ(/P„ÛdC˚áÎ^^9∆õ»™7v`7U1>˚U˝èh®iå«WΩ°∞ª®äœÁÀóÒ›£G≠(ØÒcTo(Ï¿n™b|òwgﬂ€uœÓ≈Kó˘HØ´P^†*∆Aˇ√∆çu/Ø<èŒ?∏ﬂÔWΩ°∞Â™“››ùècgÁÍ^ﬁuÎ◊Á<´ﬁPÿÅÚUI$∆◊«\'Í[ﬁ•KóÊ<\Zç™ﬁPÿÅÚ’2~≈˝¸Xﬁ“1>Ã+ÒõŸ\\ÇÚ’ÍÍÍ ˜±•••éßΩﬂyÏ±¸√ÜB!’õõP^†ZÚÑ‘¯‘mΩæáx`˜„ÑóﬂÜÈî®¡Ü\rÚïÙx<˜ˇÒ≤”##F W≠Z•z„` ‘∆¯ıó2ö˜Û˝l◊«\'ZZZåá‚ó`∫\nÂjìL&çﬂ\\)ãyo?∆aÙÏòë]y˙ÃèÂu ‘LÜ“xsVv≥÷Ô≠ÿΩ«xì°Åﬂ}ÈJî∏Òx‹8ÛÕ⁄°öü)OuWvt4 ªÓDyÅ{îH$å£cÙ˜Ÿgü+˝ë:2∏Úº∏ΩΩΩ∆2‹º…‡Zî∏wÈtzÌ⁄µ∆è+“⁄⁄jˆ•p8ÃRs3 ‹/ŸP„ÁÈ‹U T˝í°ÂÍC”¥X,&l¸ˆ\nÉ◊Î\rÖBõ6m‚<yî\0ÏFy¿nî\0ÏFy¿nî\0Ïˆˇıoçéãº\0\0\0\0IENDÆB`Ç',0),('5003',1,'diagrams/HelloWorld.bpmn','5001','<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<definitions xmlns=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:activiti=\"http://activiti.org/bpmn\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:omgdc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:omgdi=\"http://www.omg.org/spec/DD/20100524/DI\" typeLanguage=\"http://www.w3.org/2001/XMLSchema\" expressionLanguage=\"http://www.w3.org/1999/XPath\" targetNamespace=\"http://www.activiti.org/test\">\n  <process id=\"HelloWorldKey\" name=\"HelloWorldName\" isExecutable=\"true\">\n    <userTask id=\"usertask1\" name=\"Êèê‰∫§Áî≥ËØ∑\" activiti:assignee=\"Âº†‰∏â\"></userTask>\n    <userTask id=\"usertask2\" name=\"ÈÉ®Èó®ÁªèÁêÜ\" activiti:assignee=\"ÊùéÂõõ\"></userTask>\n    <userTask id=\"usertask3\" name=\"ÊÄªÁªèÁêÜ\" activiti:assignee=\"Áéã‰∫î\"></userTask>\n    <endEvent id=\"endevent1\" name=\"End\"></endEvent>\n    <sequenceFlow id=\"flow3\" sourceRef=\"usertask1\" targetRef=\"usertask2\"></sequenceFlow>\n    <sequenceFlow id=\"flow4\" sourceRef=\"usertask2\" targetRef=\"usertask3\"></sequenceFlow>\n    <sequenceFlow id=\"flow5\" sourceRef=\"usertask3\" targetRef=\"endevent1\"></sequenceFlow>\n    <startEvent id=\"startevent1\" name=\"Start\"></startEvent>\n    <sequenceFlow id=\"flow6\" sourceRef=\"startevent1\" targetRef=\"usertask1\"></sequenceFlow>\n  </process>\n  <bpmndi:BPMNDiagram id=\"BPMNDiagram_HelloWorldKey\">\n    <bpmndi:BPMNPlane bpmnElement=\"HelloWorldKey\" id=\"BPMNPlane_HelloWorldKey\">\n      <bpmndi:BPMNShape bpmnElement=\"usertask1\" id=\"BPMNShape_usertask1\">\n        <omgdc:Bounds height=\"55.0\" width=\"105.0\" x=\"235.0\" y=\"100.0\"></omgdc:Bounds>\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape bpmnElement=\"usertask2\" id=\"BPMNShape_usertask2\">\n        <omgdc:Bounds height=\"55.0\" width=\"105.0\" x=\"235.0\" y=\"180.0\"></omgdc:Bounds>\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape bpmnElement=\"usertask3\" id=\"BPMNShape_usertask3\">\n        <omgdc:Bounds height=\"55.0\" width=\"105.0\" x=\"235.0\" y=\"260.0\"></omgdc:Bounds>\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape bpmnElement=\"endevent1\" id=\"BPMNShape_endevent1\">\n        <omgdc:Bounds height=\"35.0\" width=\"35.0\" x=\"270.0\" y=\"340.0\"></omgdc:Bounds>\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape bpmnElement=\"startevent1\" id=\"BPMNShape_startevent1\">\n        <omgdc:Bounds height=\"35.0\" width=\"35.0\" x=\"270.0\" y=\"40.0\"></omgdc:Bounds>\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNEdge bpmnElement=\"flow3\" id=\"BPMNEdge_flow3\">\n        <omgdi:waypoint x=\"287.0\" y=\"155.0\"></omgdi:waypoint>\n        <omgdi:waypoint x=\"287.0\" y=\"180.0\"></omgdi:waypoint>\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge bpmnElement=\"flow4\" id=\"BPMNEdge_flow4\">\n        <omgdi:waypoint x=\"287.0\" y=\"235.0\"></omgdi:waypoint>\n        <omgdi:waypoint x=\"287.0\" y=\"260.0\"></omgdi:waypoint>\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge bpmnElement=\"flow5\" id=\"BPMNEdge_flow5\">\n        <omgdi:waypoint x=\"287.0\" y=\"315.0\"></omgdi:waypoint>\n        <omgdi:waypoint x=\"287.0\" y=\"340.0\"></omgdi:waypoint>\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge bpmnElement=\"flow6\" id=\"BPMNEdge_flow6\">\n        <omgdi:waypoint x=\"287.0\" y=\"75.0\"></omgdi:waypoint>\n        <omgdi:waypoint x=\"287.0\" y=\"100.0\"></omgdi:waypoint>\n      </bpmndi:BPMNEdge>\n    </bpmndi:BPMNPlane>\n  </bpmndi:BPMNDiagram>\n</definitions>',0);

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

insert  into `act_hi_actinst`(`ID_`,`PROC_DEF_ID_`,`PROC_INST_ID_`,`EXECUTION_ID_`,`ACT_ID_`,`TASK_ID_`,`CALL_PROC_INST_ID_`,`ACT_NAME_`,`ACT_TYPE_`,`ASSIGNEE_`,`START_TIME_`,`END_TIME_`,`DURATION_`,`TENANT_ID_`) values ('10001','HelloWorldKey:2:5004','7501','7501','usertask2','10002',NULL,'ÈÉ®Èó®ÁªèÁêÜ','userTask','ÊùéÂõõ','2019-05-16 19:41:42.823','2019-05-16 19:48:22.500',399677,''),('12501','HelloWorldKey:2:5004','7501','7501','usertask3','12502',NULL,'ÊÄªÁªèÁêÜ','userTask','Áéã‰∫î','2019-05-16 19:48:23.009',NULL,NULL,''),('7502','HelloWorldKey:2:5004','7501','7501','startevent1',NULL,NULL,'Start','startEvent',NULL,'2019-05-16 19:34:22.361','2019-05-16 19:34:22.381',20,''),('7504','HelloWorldKey:2:5004','7501','7501','usertask1','7505',NULL,'Êèê‰∫§Áî≥ËØ∑','userTask','Âº†‰∏â','2019-05-16 19:34:22.381','2019-05-16 19:41:42.596',440215,'');

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

insert  into `act_hi_identitylink`(`ID_`,`GROUP_ID_`,`TYPE_`,`USER_ID_`,`TASK_ID_`,`PROC_INST_ID_`) values ('10003',NULL,'participant','ÊùéÂõõ',NULL,'7501'),('12503',NULL,'participant','Áéã‰∫î',NULL,'7501'),('7506',NULL,'participant','Âº†‰∏â',NULL,'7501');

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

insert  into `act_hi_taskinst`(`ID_`,`PROC_DEF_ID_`,`TASK_DEF_KEY_`,`PROC_INST_ID_`,`EXECUTION_ID_`,`NAME_`,`PARENT_TASK_ID_`,`DESCRIPTION_`,`OWNER_`,`ASSIGNEE_`,`START_TIME_`,`CLAIM_TIME_`,`END_TIME_`,`DURATION_`,`DELETE_REASON_`,`PRIORITY_`,`DUE_DATE_`,`FORM_KEY_`,`CATEGORY_`,`TENANT_ID_`) values ('10002','HelloWorldKey:2:5004','usertask2','7501','7501','ÈÉ®Èó®ÁªèÁêÜ',NULL,NULL,NULL,'ÊùéÂõõ','2019-05-16 19:41:42.823',NULL,'2019-05-16 19:48:22.463',399640,'completed',50,NULL,NULL,NULL,''),('12502','HelloWorldKey:2:5004','usertask3','7501','7501','ÊÄªÁªèÁêÜ',NULL,NULL,NULL,'Áéã‰∫î','2019-05-16 19:48:23.010',NULL,NULL,NULL,NULL,50,NULL,NULL,NULL,''),('7505','HelloWorldKey:2:5004','usertask1','7501','7501','Êèê‰∫§Áî≥ËØ∑',NULL,NULL,NULL,'Âº†‰∏â','2019-05-16 19:34:22.425',NULL,'2019-05-16 19:41:42.583',440158,'completed',50,NULL,NULL,NULL,'');

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

insert  into `act_ru_identitylink`(`ID_`,`REV_`,`GROUP_ID_`,`TYPE_`,`USER_ID_`,`TASK_ID_`,`PROC_INST_ID_`,`PROC_DEF_ID_`) values ('10003',1,NULL,'participant','ÊùéÂõõ',NULL,'7501',NULL),('12503',1,NULL,'participant','Áéã‰∫î',NULL,'7501',NULL),('7506',1,NULL,'participant','Âº†‰∏â',NULL,'7501',NULL);

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

insert  into `act_ru_task`(`ID_`,`REV_`,`EXECUTION_ID_`,`PROC_INST_ID_`,`PROC_DEF_ID_`,`NAME_`,`PARENT_TASK_ID_`,`DESCRIPTION_`,`TASK_DEF_KEY_`,`OWNER_`,`ASSIGNEE_`,`DELEGATION_`,`PRIORITY_`,`CREATE_TIME_`,`DUE_DATE_`,`CATEGORY_`,`SUSPENSION_STATE_`,`TENANT_ID_`,`FORM_KEY_`) values ('12502',1,'7501','7501','HelloWorldKey:2:5004','ÊÄªÁªèÁêÜ',NULL,NULL,'usertask3',NULL,'Áéã‰∫î',NULL,50,'2019-05-16 19:48:23.010',NULL,NULL,1,'',NULL);

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
