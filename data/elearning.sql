/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50727
Source Host           : localhost:3306
Source Database       : elearning

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2019-09-08 02:57:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `chapter`
-- ----------------------------
DROP TABLE IF EXISTS `chapter`;
CREATE TABLE `chapter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `_order` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of chapter
-- ----------------------------
INSERT INTO `chapter` VALUES ('1', '1', '新闻');
INSERT INTO `chapter` VALUES ('2', '2', '时政');
INSERT INTO `chapter` VALUES ('3', '3', '民生');
INSERT INTO `chapter` VALUES ('4', '5', '测试');
INSERT INTO `chapter` VALUES ('5', '4', '测试 - 副本');
INSERT INTO `chapter` VALUES ('6', '6', '测试 - 副本 - 副本');

-- ----------------------------
-- Table structure for `childbbs`
-- ----------------------------
DROP TABLE IF EXISTS `childbbs`;
CREATE TABLE `childbbs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `main_id` int(11) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of childbbs
-- ----------------------------
INSERT INTO `childbbs` VALUES ('1', '1', '哇你说的真是太对了', '1', '2019-07-11 17:06:28');
INSERT INTO `childbbs` VALUES ('2', '1', '同意！', '1', '2019-07-12 00:29:04');
INSERT INTO `childbbs` VALUES ('3', '2', '吃吃吃', '1', '2019-08-12 22:28:40');
INSERT INTO `childbbs` VALUES ('4', '-1', 'xxx', '1', '2019-08-13 16:55:42');
INSERT INTO `childbbs` VALUES ('5', '36', '困了累了', '1', '2019-08-13 18:54:32');
INSERT INTO `childbbs` VALUES ('6', '36', '？', '1', '2019-08-13 18:55:41');
INSERT INTO `childbbs` VALUES ('7', '37', '真的多', '1', '2019-08-14 16:27:26');
INSERT INTO `childbbs` VALUES ('8', '37', '', '1', '2019-08-14 16:27:34');
INSERT INTO `childbbs` VALUES ('9', '37', '？？？', '1', '2019-08-14 16:27:46');
INSERT INTO `childbbs` VALUES ('10', '4', '？？', '1', '2019-08-16 08:22:27');
INSERT INTO `childbbs` VALUES ('11', '2', '？', '1', '2019-08-16 08:24:03');
INSERT INTO `childbbs` VALUES ('12', '2', '来了', '1', '2019-08-16 08:24:15');
INSERT INTO `childbbs` VALUES ('13', '2', '困了累了', '1', '2019-08-16 08:25:11');
INSERT INTO `childbbs` VALUES ('14', '2', '该喝喝', '1', '2019-08-16 08:25:22');
INSERT INTO `childbbs` VALUES ('15', '2', '哦破婆婆', '1', '2019-08-16 08:26:04');
INSERT INTO `childbbs` VALUES ('16', '1', '哈哈哈', '1', '2019-08-16 08:27:03');
INSERT INTO `childbbs` VALUES ('17', '3', '？', '1', '2019-08-16 08:28:25');
INSERT INTO `childbbs` VALUES ('18', '1', '不错', '1', '2019-08-28 16:59:33');
INSERT INTO `childbbs` VALUES ('19', '38', '？？', '1', '2019-08-28 16:59:50');
INSERT INTO `childbbs` VALUES ('20', '4', '是的', '999999', '2019-09-06 02:31:12');
INSERT INTO `childbbs` VALUES ('21', '39', '测试内容', '999999', '2019-09-06 02:31:32');

-- ----------------------------
-- Table structure for `collection`
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `question_id` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of collection
-- ----------------------------
INSERT INTO `collection` VALUES ('1', '1', '1');
INSERT INTO `collection` VALUES ('2', '1', '2');
INSERT INTO `collection` VALUES ('3', '1', '3');
INSERT INTO `collection` VALUES ('4', '1', '4');
INSERT INTO `collection` VALUES ('5', '1', '1');

-- ----------------------------
-- Table structure for `mainbbs`
-- ----------------------------
DROP TABLE IF EXISTS `mainbbs`;
CREATE TABLE `mainbbs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `head` varchar(255) NOT NULL,
  `user` int(11) NOT NULL,
  `time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mainbbs
-- ----------------------------
INSERT INTO `mainbbs` VALUES ('1', '范仲淹的改革，为什么会被宋仁宗抛弃？', '1', '2019-07-11 13:12:15');
INSERT INTO `mainbbs` VALUES ('2', '秦皇陵与金字塔', '1', '2019-07-11 13:12:27');
INSERT INTO `mainbbs` VALUES ('3', '作为象形字，汉字简化之后，是否脱离了本来繁体的味道？', '1', '2019-07-11 13:12:36');
INSERT INTO `mainbbs` VALUES ('4', '蒋中正晚年像不像诸葛亮', '1', '2019-07-11 14:24:32');
INSERT INTO `mainbbs` VALUES ('5', '古代皇帝要求，武将可以贪污，文官绝不准贪污，这是为何？', '1', '2019-07-11 14:25:00');
INSERT INTO `mainbbs` VALUES ('6', '真实历史：方腊和宋江，谁更厉害？', '1', '2019-07-11 14:25:49');
INSERT INTO `mainbbs` VALUES ('7', '为什么清朝的皇帝喜欢练武功骑射？明朝皇帝却很废柴？', '1', '2019-07-11 14:26:15');
INSERT INTO `mainbbs` VALUES ('8', '但使龙城飞将在，龙城飞将指李广还是卫青？', '1', '2019-07-11 14:26:38');
INSERT INTO `mainbbs` VALUES ('9', '八国联军到底有多少人？', '1', '2019-07-11 14:29:12');
INSERT INTO `mainbbs` VALUES ('10', '86版《西游记》，并不算是一部尊重原著的电视剧', '1', '2019-07-11 14:29:29');
INSERT INTO `mainbbs` VALUES ('12', '水电费', '1', '2019-08-12 22:06:24');
INSERT INTO `mainbbs` VALUES ('13', '该喝喝', '1', '2019-08-13 15:11:06');
INSERT INTO `mainbbs` VALUES ('14', '呜呜呜呜', '1', '2019-08-13 16:53:36');
INSERT INTO `mainbbs` VALUES ('15', 'ccx', '1', '2019-08-13 16:55:42');
INSERT INTO `mainbbs` VALUES ('16', '的地方', '1', '2019-08-13 16:56:38');
INSERT INTO `mainbbs` VALUES ('17', '啪啪啪', '1', '2019-08-13 16:59:25');
INSERT INTO `mainbbs` VALUES ('18', '啪啪啪对对对', '1', '2019-08-13 16:59:40');
INSERT INTO `mainbbs` VALUES ('19', 'yu', '1', '2019-08-13 17:01:34');
INSERT INTO `mainbbs` VALUES ('20', 'yu', '1', '2019-08-13 17:01:45');
INSERT INTO `mainbbs` VALUES ('21', 'yul', '1', '2019-08-13 17:02:31');
INSERT INTO `mainbbs` VALUES ('22', 'yul', '1', '2019-08-13 17:02:35');
INSERT INTO `mainbbs` VALUES ('23', 'yul', '1', '2019-08-13 17:03:09');
INSERT INTO `mainbbs` VALUES ('24', 'yul吃醋vv', '1', '2019-08-13 17:04:04');
INSERT INTO `mainbbs` VALUES ('25', 'yul吃醋vv该喝喝', '1', '2019-08-13 17:05:34');
INSERT INTO `mainbbs` VALUES ('26', 'yul吃醋vv该喝喝哦破', '1', '2019-08-13 17:06:23');
INSERT INTO `mainbbs` VALUES ('27', '欧派', '1', '2019-08-13 17:39:31');
INSERT INTO `mainbbs` VALUES ('28', '欧派该喝喝', '1', '2019-08-13 17:41:53');
INSERT INTO `mainbbs` VALUES ('29', '欧派该喝喝白白净净', '1', '2019-08-13 17:45:05');
INSERT INTO `mainbbs` VALUES ('30', '十点', '1', '2019-08-13 17:46:51');
INSERT INTO `mainbbs` VALUES ('31', '十点乖宝宝', '1', '2019-08-13 17:48:39');
INSERT INTO `mainbbs` VALUES ('32', '哦破', '1', '2019-08-13 17:49:41');
INSERT INTO `mainbbs` VALUES ('33', 'nm', '1', '2019-08-13 17:52:05');
INSERT INTO `mainbbs` VALUES ('34', 'nm富强福', '1', '2019-08-13 18:03:42');
INSERT INTO `mainbbs` VALUES ('35', 'pp', '1', '2019-08-13 18:07:14');
INSERT INTO `mainbbs` VALUES ('36', 'mmm', '1', '2019-08-13 18:54:32');
INSERT INTO `mainbbs` VALUES ('37', '啧啧啧', '1', '2019-08-14 16:27:26');
INSERT INTO `mainbbs` VALUES ('38', '教材', '1', '2019-08-28 16:59:50');
INSERT INTO `mainbbs` VALUES ('39', '管理员测试', '999999', '2019-09-06 02:31:32');

-- ----------------------------
-- Table structure for `media`
-- ----------------------------
DROP TABLE IF EXISTS `media`;
CREATE TABLE `media` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `_order` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `path` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of media
-- ----------------------------
INSERT INTO `media` VALUES ('1', '1', '机器学习01', 'https://v.youku.com/v_show/id_XNDEyMTU1MTAzMg==.html?spm=a2h0k.11417342.soresults.dtitle');
INSERT INTO `media` VALUES ('2', '2', '机器学习教程02课题导入', 'https://v.youku.com/v_show/id_XNDEyMTU1MTQ5Mg==.html?spm=a2h0k.11417342.soresults.dtitle');
INSERT INTO `media` VALUES ('3', '3', '机器学习教程03算法解析', 'https://v.youku.com/v_show/id_XNDEyMTU1MjM3Ng==.html?spm=a2h0k.11417342.soresults.dtitle');

-- ----------------------------
-- Table structure for `note`
-- ----------------------------
DROP TABLE IF EXISTS `note`;
CREATE TABLE `note` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) DEFAULT NULL,
  `shape` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `tag` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of note
-- ----------------------------
INSERT INTO `note` VALUES ('3', '1', 'text', '1.4', '学习', '这段说的真有意思');
INSERT INTO `note` VALUES ('4', '1', 'photo', '三棵树', '学习', '这幅画真好看');

-- ----------------------------
-- Table structure for `photo`
-- ----------------------------
DROP TABLE IF EXISTS `photo`;
CREATE TABLE `photo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `_order` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of photo
-- ----------------------------
INSERT INTO `photo` VALUES ('1', '1', '蒙娜丽莎的微笑');
INSERT INTO `photo` VALUES ('2', '2', '最后的晚餐');
INSERT INTO `photo` VALUES ('3', '3', '岩间圣母');
INSERT INTO `photo` VALUES ('4', '4', '向日葵');
INSERT INTO `photo` VALUES ('5', '5', '星空');
INSERT INTO `photo` VALUES ('6', '6', '三棵树');
INSERT INTO `photo` VALUES ('9', '7', '雪');

-- ----------------------------
-- Table structure for `point`
-- ----------------------------
DROP TABLE IF EXISTS `point`;
CREATE TABLE `point` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) DEFAULT NULL,
  `type` varchar(11) DEFAULT NULL,
  `time` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of point
-- ----------------------------
INSERT INTO `point` VALUES ('1', '1', 'Answer', '20190831');
INSERT INTO `point` VALUES ('2', '1', 'Answer', '20190831');
INSERT INTO `point` VALUES ('8', '1', 'Answer', '20190831');
INSERT INTO `point` VALUES ('9', '1', 'Answer', '20190831');
INSERT INTO `point` VALUES ('10', '1', 'Answer', '20190831');
INSERT INTO `point` VALUES ('11', '1', 'Answer', '20190831');
INSERT INTO `point` VALUES ('12', '1', 'Login', '20190831');
INSERT INTO `point` VALUES ('13', '1', 'TP', '20190831');
INSERT INTO `point` VALUES ('14', '1', 'TP', '20190831');
INSERT INTO `point` VALUES ('15', '1', 'TextTime', '20190831');
INSERT INTO `point` VALUES ('16', '1', 'TextTime', '20190831');
INSERT INTO `point` VALUES ('17', '1', 'TextTime', '20190831');
INSERT INTO `point` VALUES ('20', '1', 'MediaTime', '20190831');
INSERT INTO `point` VALUES ('21', '1', 'Login', '20190903');
INSERT INTO `point` VALUES ('22', '1', 'Login', '20190905');
INSERT INTO `point` VALUES ('23', '1', 'TP', '20190905');
INSERT INTO `point` VALUES ('24', '1', 'TP', '20190905');
INSERT INTO `point` VALUES ('25', '1', 'Answer', '20190905');
INSERT INTO `point` VALUES ('26', '1', 'Answer', '20190905');
INSERT INTO `point` VALUES ('27', '1', 'Answer', '20190905');
INSERT INTO `point` VALUES ('28', '1', 'Answer', '20190905');
INSERT INTO `point` VALUES ('29', '1', 'Answer', '20190905');
INSERT INTO `point` VALUES ('30', '1', 'Answer', '20190905');
INSERT INTO `point` VALUES ('31', '1', 'Login', '20190906');
INSERT INTO `point` VALUES ('32', '999999', 'BBS', '20190906');
INSERT INTO `point` VALUES ('33', '1', 'TP', '20190906');
INSERT INTO `point` VALUES ('34', '1', 'TP', '20190906');
INSERT INTO `point` VALUES ('35', '1', 'TP', '20190906');
INSERT INTO `point` VALUES ('36', '1', 'TP', '20190906');
INSERT INTO `point` VALUES ('37', '1', 'TP', '20190906');
INSERT INTO `point` VALUES ('38', '1', 'TP', '20190906');
INSERT INTO `point` VALUES ('39', '999999', 'TP', '20190906');
INSERT INTO `point` VALUES ('40', '999999', 'TP', '20190906');
INSERT INTO `point` VALUES ('41', '999999', 'TP', '20190906');
INSERT INTO `point` VALUES ('42', '999999', 'TP', '20190906');
INSERT INTO `point` VALUES ('43', '999999', 'TP', '20190906');
INSERT INTO `point` VALUES ('44', '999999', 'TP', '20190906');
INSERT INTO `point` VALUES ('45', '999999', 'TP', '20190907');
INSERT INTO `point` VALUES ('46', '999999', 'TP', '20190907');
INSERT INTO `point` VALUES ('47', '999999', 'TP', '20190907');
INSERT INTO `point` VALUES ('48', '999999', 'TP', '20190907');
INSERT INTO `point` VALUES ('49', '999999', 'TP', '20190907');
INSERT INTO `point` VALUES ('50', '999999', 'TP', '20190907');
INSERT INTO `point` VALUES ('51', '1', 'Login', '20190907');
INSERT INTO `point` VALUES ('52', '999999', 'TP', '20190908');
INSERT INTO `point` VALUES ('53', '999999', 'TP', '20190908');
INSERT INTO `point` VALUES ('54', '999999', 'TP', '20190908');
INSERT INTO `point` VALUES ('55', '999999', 'TP', '20190908');
INSERT INTO `point` VALUES ('56', '999999', 'TP', '20190908');
INSERT INTO `point` VALUES ('57', '999999', 'TP', '20190908');
INSERT INTO `point` VALUES ('58', '1', 'Login', '20190908');
INSERT INTO `point` VALUES ('59', '1', 'TP', '20190908');
INSERT INTO `point` VALUES ('60', '1', 'TP', '20190908');
INSERT INTO `point` VALUES ('61', '1', 'TP', '20190908');
INSERT INTO `point` VALUES ('62', '1', 'TP', '20190908');
INSERT INTO `point` VALUES ('63', '1', 'TP', '20190908');

-- ----------------------------
-- Table structure for `question`
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `_order` int(11) DEFAULT NULL,
  `_type` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `question` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `answer` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('1', '1', 'Radio', '最小数？@1@2@3@4', 'A');
INSERT INTO `question` VALUES ('2', '2', 'Radio', '1+2=?@1@2@3@4', 'C');
INSERT INTO `question` VALUES ('3', '3', 'Check', '偶数?@1@2@3@4', 'BD');
INSERT INTO `question` VALUES ('4', '4', 'Fill', '1 _=23?', '22');

-- ----------------------------
-- Table structure for `record`
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `_type` varchar(255) NOT NULL,
  `flag` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('1', '1', 'text', '3_2');
INSERT INTO `record` VALUES ('2', '1', 'text', '3_3');
INSERT INTO `record` VALUES ('3', '1', 'photo', '最后的晚餐');
INSERT INTO `record` VALUES ('4', '1', 'photo', '向日葵');
INSERT INTO `record` VALUES ('5', '1', 'media', '机器学习教程03算法解析');
INSERT INTO `record` VALUES ('8', '1', 'photo', '蒙娜丽莎的微笑');
INSERT INTO `record` VALUES ('9', '1', 'photo', '岩间圣母');
INSERT INTO `record` VALUES ('10', '1', 'photo', '星空');
INSERT INTO `record` VALUES ('11', '1', 'photo', '三棵树');
INSERT INTO `record` VALUES ('12', '1', 'text', '1_4');
INSERT INTO `record` VALUES ('13', '1', 'text', '1_1');
INSERT INTO `record` VALUES ('14', '1', 'text', '5_2');
INSERT INTO `record` VALUES ('15', '1', 'media', '机器学习教程01聚类算法');
INSERT INTO `record` VALUES ('16', '1', 'media', '机器学习教程02课题导入');
INSERT INTO `record` VALUES ('23', '1', 'photo', '雪');
INSERT INTO `record` VALUES ('24', '1', 'text', '1_2');
INSERT INTO `record` VALUES ('25', '1', 'text', '1_3');
INSERT INTO `record` VALUES ('26', '1', 'text', '1_5');
INSERT INTO `record` VALUES ('27', '1', 'text', '1_6');

-- ----------------------------
-- Table structure for `score`
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `score` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `time` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `rate` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `errorNum` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `day` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('4', '1', '25', '6', '1/4', '2、3、4', '2019-08-28 16:44:00');
INSERT INTO `score` VALUES ('5', '8', '75', '21', '3/4', '3', '2019-08-29 15:00:00');

-- ----------------------------
-- Table structure for `section`
-- ----------------------------
DROP TABLE IF EXISTS `section`;
CREATE TABLE `section` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `_order` int(11) NOT NULL,
  `chapter_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of section
-- ----------------------------
INSERT INTO `section` VALUES ('1', '1', '1', '大学高素质教师队伍从哪里来');
INSERT INTO `section` VALUES ('2', '2', '1', '首届四川高校阅读文化节在蓉举行');
INSERT INTO `section` VALUES ('3', '3', '1', '西南交大校长徐飞著作入选“改革开放百本优秀书籍”');
INSERT INTO `section` VALUES ('4', '4', '1', '“中国—拉共体轨道交通联合实验室”揭牌');
INSERT INTO `section` VALUES ('5', '5', '1', '6名西南交大研究生受聘甘洛县普昌镇，当乡村规划师');
INSERT INTO `section` VALUES ('6', '1', '2', '数学学院召开学位点合格评估专家评审会');
INSERT INTO `section` VALUES ('7', '2', '2', '西南交通大学第二十九次学生代表大会、第八次研究生代表大会隆重召开');
INSERT INTO `section` VALUES ('8', '3', '2', '西南交通大学团学骨干集体学习并热议习近平总书记在北大师生座谈会上的讲话');
INSERT INTO `section` VALUES ('9', '1', '3', '出门靠打拼 爱拼才会赢 全校齐努力 共创新未来');
INSERT INTO `section` VALUES ('10', '2', '3', '后基处党委陈兴莲书记督导检查退休党支部党建工作并与党员同志座谈交流');
INSERT INTO `section` VALUES ('13', '3', '3', '山西省话剧院原创话剧《生命如歌》走进西南交通大学');
INSERT INTO `section` VALUES ('14', '4', '3', '后勤与基建管理处党委 “七一”前夕开展看望慰问重病退休党员活动');
INSERT INTO `section` VALUES ('15', '1', '4', '测试1');
INSERT INTO `section` VALUES ('16', '2', '4', '测试2');
INSERT INTO `section` VALUES ('17', '3', '4', '测试3');
INSERT INTO `section` VALUES ('18', '4', '4', '测试4');
INSERT INTO `section` VALUES ('19', '1', '5', '测试1');
INSERT INTO `section` VALUES ('20', '2', '5', '测试2');
INSERT INTO `section` VALUES ('21', '3', '5', '测试3');
INSERT INTO `section` VALUES ('22', '4', '5', '测试4');
INSERT INTO `section` VALUES ('23', '1', '6', '测试1');
INSERT INTO `section` VALUES ('24', '2', '6', '测试2');
INSERT INTO `section` VALUES ('27', '6', '1', '洛县普昌镇，当乡村规划师');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `pwd` varchar(255) NOT NULL,
  `st_id` varchar(255) NOT NULL,
  `sex` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'zhangsan', '333', '20190001', 'girl');
INSERT INTO `user` VALUES ('8', 'lisi', '444', '20190002', 'girl');
INSERT INTO `user` VALUES ('999999', 'admin', 'admin', '1', 'boy');

-- ----------------------------
-- Table structure for `vote`
-- ----------------------------
DROP TABLE IF EXISTS `vote`;
CREATE TABLE `vote` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `from_id` varchar(11) DEFAULT NULL,
  `to_id` varchar(11) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of vote
-- ----------------------------
INSERT INTO `vote` VALUES ('1', '1', '1');
INSERT INTO `vote` VALUES ('4', '1', '4');
INSERT INTO `vote` VALUES ('6', '1', '3');
INSERT INTO `vote` VALUES ('7', '1', '7');
INSERT INTO `vote` VALUES ('8', '1', '11');

-- ----------------------------
-- Table structure for `work`
-- ----------------------------
DROP TABLE IF EXISTS `work`;
CREATE TABLE `work` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of work
-- ----------------------------
INSERT INTO `work` VALUES ('1', '伊阿宋', '1');
INSERT INTO `work` VALUES ('2', '达芬奇', '1');
INSERT INTO `work` VALUES ('3', '巴沙洛缪', '1');
INSERT INTO `work` VALUES ('4', '陈宫', '1');
INSERT INTO `work` VALUES ('5', '加雷斯', '1');
INSERT INTO `work` VALUES ('6', '夏绿蒂', '1');
INSERT INTO `work` VALUES ('7', '未命名', '1');
INSERT INTO `work` VALUES ('11', '鲨鱼', '1');

-- ----------------------------
-- Table structure for `workcommit`
-- ----------------------------
DROP TABLE IF EXISTS `workcommit`;
CREATE TABLE `workcommit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `workID` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `userID` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `commit` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of workcommit
-- ----------------------------
INSERT INTO `workcommit` VALUES ('1', '1', '1', '真棒！');
INSERT INTO `workcommit` VALUES ('2', '1', '1', '加油！');
INSERT INTO `workcommit` VALUES ('3', '2', '1', '可爱!');
INSERT INTO `workcommit` VALUES ('4', '3', '1', '帅气');
INSERT INTO `workcommit` VALUES ('5', '3', '1', '？？？');
INSERT INTO `workcommit` VALUES ('6', '3', '1', '抽出');
INSERT INTO `workcommit` VALUES ('7', '3', '1', '抽出抽出');
INSERT INTO `workcommit` VALUES ('8', '3', '1', 'ccc');
INSERT INTO `workcommit` VALUES ('9', '3', '1', 'cccccc');
INSERT INTO `workcommit` VALUES ('10', '6', '1', 'good');
INSERT INTO `workcommit` VALUES ('11', '5', '1', 'ex');
INSERT INTO `workcommit` VALUES ('12', '1', '1', '55');
INSERT INTO `workcommit` VALUES ('13', '11', '1', '测试');
