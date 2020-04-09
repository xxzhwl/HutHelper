# Host: 127.0.0.1  (Version: 5.5.15)
# Date: 2017-12-16 12:08:53
# Generator: MySQL-Front 5.3  (Build 4.269)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "course_table"
#

DROP TABLE IF EXISTS `course_table`;
CREATE TABLE `course_table` (
  `zy` varchar(11) NOT NULL DEFAULT '' COMMENT '专业',
  `0_1` varchar(255) NOT NULL DEFAULT '上午1，2节',
  `1_1` varchar(255) DEFAULT NULL,
  `2_1` varchar(255) DEFAULT NULL,
  `3_1` varchar(255) DEFAULT NULL,
  `4_1` varchar(255) DEFAULT NULL,
  `5_1` varchar(255) DEFAULT NULL,
  `0_2` varchar(255) NOT NULL DEFAULT '上午3，4节',
  `1_2` varchar(255) DEFAULT NULL,
  `2_2` varchar(255) DEFAULT NULL,
  `3_2` varchar(255) DEFAULT NULL,
  `4_2` varchar(255) DEFAULT NULL,
  `5_2` varchar(255) DEFAULT NULL,
  `0_3` varchar(255) NOT NULL DEFAULT '下午5，6节',
  `1_3` varchar(255) DEFAULT NULL,
  `2_3` varchar(255) DEFAULT NULL,
  `3_3` varchar(255) DEFAULT NULL,
  `4_3` varchar(255) DEFAULT NULL,
  `5_3` varchar(255) DEFAULT NULL,
  `0_4` varchar(255) NOT NULL DEFAULT '下午7，8节',
  `1_4` varchar(255) DEFAULT NULL,
  `2_4` varchar(255) DEFAULT NULL,
  `3_4` varchar(255) DEFAULT NULL,
  `4_4` varchar(255) DEFAULT NULL,
  `5_4` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`zy`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程表';

#
# Data for table "course_table"
#

INSERT INTO `course_table` VALUES ('物联网','上午1，2节',NULL,'计算机网络','c语言','c语言','c语言','上午3，4节',NULL,'计算机网络','毛泽东思想','计算机操作系统','oracle大型数据库','下午5，6节','java','毛泽东思想','oracle大型数据库',NULL,'oracle大型数据库','下午7，8节','java','java',NULL,NULL,'计算机操作系统'),('电子信息工程','上午1，2节',NULL,NULL,NULL,NULL,NULL,'上午3，4节',NULL,NULL,NULL,NULL,NULL,'下午5，6节',NULL,NULL,NULL,NULL,NULL,'下午7，8节',NULL,NULL,NULL,NULL,NULL),('电气自动化','上午1，2节','计算机网络',NULL,NULL,NULL,NULL,'上午3，4节',NULL,NULL,NULL,NULL,NULL,'下午5，6节',NULL,NULL,NULL,NULL,NULL,'下午7，8节',NULL,NULL,NULL,NULL,NULL),('网络工程','上午1，2节','计算机网络',NULL,'计算机网络','c语言','计算机网络','上午3，4节','c语言','计算机网络','毛泽东思想','计算机网络','oracle大型数据库','下午5，6节','计算机网络',NULL,'java','计算机操作系统',NULL,'下午7，8节','java','计算机操作系统',NULL,'计算机操作系统',NULL),('计算机','上午1，2节','java',NULL,'oracle大型数据库',NULL,'计算机操作系统','上午3，4节',NULL,'c语言','oracle大型数据库','计算机网络',NULL,'下午5，6节','计算机网络','毛泽东思想','java','毛泽东思想','java','下午7，8节','c语言','c语言',NULL,'c语言',''),('软件工程','上午1，2节','java','c语言','oracle大型数据库','c语言','java','上午3，4节','oracle大型数据库','java','c语言','c++','java','下午5，6节','毛泽东思想',NULL,'oracle大型数据库','计算机网络','c语言','下午7，8节',NULL,'java','毛泽东思想','oracle大型数据库',NULL),('通信工程','上午1，2节',NULL,'c语言',NULL,'c语言','计算机操作系统','上午3，4节','计算机操作系统',NULL,'oracle大型数据库',NULL,'计算机操作系统','下午5，6节','oracle大型数据库','毛泽东思想','计算机操作系统','oracle大型数据库',NULL,'下午7，8节','oracle大型数据库','毛泽东思想','计算机操作系统',NULL,'oracle大型数据库');

#
# Structure for table "users"
#

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `xh` varchar(11) NOT NULL DEFAULT '' COMMENT '账户',
  `yhm` varchar(255) NOT NULL DEFAULT '' COMMENT '用户名',
  `xm` varchar(255) NOT NULL DEFAULT '' COMMENT '姓名',
  `mm` varchar(255) NOT NULL DEFAULT '' COMMENT '密码',
  `nl` varchar(255) NOT NULL DEFAULT '' COMMENT '年龄',
  `tx` varchar(255) NOT NULL DEFAULT 'pic/tx/tx.png' COMMENT '头像',
  `sjhm` varchar(255) DEFAULT '' COMMENT '手机号码',
  `bj` varchar(255) NOT NULL DEFAULT '' COMMENT '班级',
  `zy` varchar(255) NOT NULL DEFAULT '' COMMENT '专业',
  `xy` varchar(255) NOT NULL DEFAULT '' COMMENT '学院',
  `xb` varchar(255) NOT NULL DEFAULT '' COMMENT '性别',
  `ms` varchar(255) DEFAULT '' COMMENT '描述',
  `lb` varchar(255) NOT NULL DEFAULT '普通用户' COMMENT '用户类别',
  PRIMARY KEY (`xh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';

#
# Data for table "users"
#

INSERT INTO `users` VALUES ('101','管理员一号','管理员一号','admin','27','pic/tx/tx.png','13488554533','','','','男','','管理员'),('154080','毛毛女孩','唐一','123456','20','pic/tx/tx (53).png','15738884444','1502','软件工程','计算机学院','男','我是一个计算机学院的男生','普通用户'),('154081','球球','王二','123456','16','pic/tx/tx (93).png','18834569933','1503','电气自动化','电气学院','男','','普通用户'),('154082','溜溜','刘浏','123987','16','pic/tx/tx (19).png','13877758965','1503','计算机','计算机学院','女','','普通用户'),('154083','卡卡','张三','123456','19','pic/tx/tx (32).png','16577564677','1503','计算机','计算机学院','男','','普通用户'),('154084','圈圈','张思卿','1234567','19','pic/tx/tx (49).png','15667675646','1503','电子信息工程','电气学院','男','','普通用户'),('154085','唐太宗','李世民','123456789','19','pic/tx/tx (18).png','15546756775','1504','通信工程','计算机学院','男','','普通用户'),('154086','滋滋','王自','132345','16','pic/tx/tx (55).png','15566656666','1503','电气自动化','电气学院','男','','普通用户'),('154087','浪浪','秦朗','12344546','17','pic/tx/tx (82).png','15569464533','1503','物联网','计算机学院','男','','普通用户'),('154088','丽丽','刘丽','123456','17','pic/tx/tx (2).png','15484966466','1502','网络工程','计算机学院','女','','普通用户'),('154089','柳叶','柳叶','123456','19','pic/tx/tx (24).png','15459656456','1502','软件工程','计算机学院','女','','普通用户'),('154090','erer','王往','123444','20','pic/tx/tx (70).png','15677755546','1503','电子信息工程','电气学院','男','','普通用户'),('154091','Nier','聂风','1234566','19','pic/tx/tx (13).png','16765675676','1503','网络工程','计算机学院','男','','普通用户'),('154092','(((φ(◎ロ◎;)φ)))','步惊云','1234567','19','pic/tx/tx (58).png','15345665766','1501','计算机','计算机学院','男','','普通用户');

#
# Structure for table "score"
#

DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `xh` varchar(11) NOT NULL DEFAULT '' COMMENT '学号',
  `java` int(11) NOT NULL DEFAULT '0' COMMENT 'java成绩',
  `c` int(11) NOT NULL DEFAULT '0' COMMENT 'c语言',
  `oracle` int(11) NOT NULL DEFAULT '0' COMMENT 'oracle大型数据库',
  `cpp` int(11) NOT NULL DEFAULT '0' COMMENT 'c++',
  `mzdsx` int(11) NOT NULL DEFAULT '0' COMMENT '毛泽东思想',
  `jsjwl` int(11) NOT NULL DEFAULT '0' COMMENT '计算机网络',
  `czxt` int(11) NOT NULL DEFAULT '0' COMMENT '操作系统',
  `pjf` int(11) NOT NULL DEFAULT '0' COMMENT '平均分',
  `zcj` int(11) NOT NULL DEFAULT '0' COMMENT '总成绩',
  `bj` varchar(255) NOT NULL DEFAULT '' COMMENT '班级',
  `zy` varchar(255) NOT NULL DEFAULT '' COMMENT '专业',
  PRIMARY KEY (`xh`),
  CONSTRAINT `score_ibfk_1` FOREIGN KEY (`xh`) REFERENCES `users` (`xh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='成绩表';

#
# Data for table "score"
#

INSERT INTO `score` VALUES ('154080',94,87,85,79,78,85,83,84,591,'1502','软件工程'),('154081',0,0,0,0,0,0,0,0,0,'1503','电气自动化'),('154082',80,88,86,86,86,87,86,85,599,'1503','计算机'),('154083',97,96,96,96,96,96,96,96,673,'1503','计算机'),('154084',0,0,0,0,0,0,0,0,0,'1503','电子信息工程'),('154085',0,0,0,0,0,0,0,0,0,'1504','通信工程'),('154086',0,0,0,0,0,0,0,0,0,'1503','电气自动化'),('154087',0,0,0,0,0,0,0,0,0,'1503','物联网'),('154088',89,96,95,93,76,85,88,88,622,'1502','网络工程'),('154089',93,89,85,76,87,85,78,84,593,'1502','软件工程'),('154090',0,0,0,0,0,0,0,0,0,'1503','电子信息工程'),('154091',0,0,0,0,0,0,0,0,0,'1503','计算机学院'),('154092',95,85,89,94,79,85,79,86,606,'1501','计算机');
