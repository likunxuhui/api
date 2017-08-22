/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : ssm

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-08-21 13:29:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for author
-- ----------------------------
DROP TABLE IF EXISTS `author`;
CREATE TABLE `author` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of author
-- ----------------------------
INSERT INTO `author` VALUES ('1', '小明', '男');
INSERT INTO `author` VALUES ('2', '小花', '女');
INSERT INTO `author` VALUES ('3', '小鑫', '男');

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `author_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('1', '为什么读书', '2');
INSERT INTO `blog` VALUES ('2', '成长', '3');
INSERT INTO `blog` VALUES ('3', '责任', '2');
INSERT INTO `blog` VALUES ('4', '稳住', '4');

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `price` double DEFAULT NULL,
  `date` datetime(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=191 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('10', '数据库', '12.3', '2017-07-03 15:13:45.9340');
INSERT INTO `book` VALUES ('11', '数据库', '12.3', '2017-07-03 15:16:22.5140');
INSERT INTO `book` VALUES ('12', '数据库', '12.3', '2017-07-03 15:23:06.7850');
INSERT INTO `book` VALUES ('13', '数据库', '12.3', '2017-07-03 15:36:47.2030');
INSERT INTO `book` VALUES ('14', '数据库', '12.3', '2017-07-05 16:11:38.6520');
INSERT INTO `book` VALUES ('15', '数据库', '12.3', '2017-07-05 16:12:32.7520');
INSERT INTO `book` VALUES ('16', '数据库', '12.3', '2017-07-05 16:13:38.1220');
INSERT INTO `book` VALUES ('17', '数据库', '12.3', '2017-07-05 17:22:36.2870');
INSERT INTO `book` VALUES ('18', '数据库', '12.3', '2017-07-05 18:36:34.3010');
INSERT INTO `book` VALUES ('19', '数据库', '12.3', '2017-07-05 18:50:22.3750');
INSERT INTO `book` VALUES ('20', '数据库', '12.3', '2017-07-05 18:59:25.9980');
INSERT INTO `book` VALUES ('21', '数据库', '12.3', '2017-07-05 18:59:44.9130');
INSERT INTO `book` VALUES ('22', '数据库', '12.3', '2017-07-06 16:44:36.8780');
INSERT INTO `book` VALUES ('23', '数据库1', '12.2', '2017-08-15 15:35:00.0000');
INSERT INTO `book` VALUES ('24', '数据库2', '12.6', '2017-08-15 15:35:00.0000');
INSERT INTO `book` VALUES ('25', '数据库1', '12.2', '2017-08-15 15:40:00.0000');
INSERT INTO `book` VALUES ('26', '数据库2', '12.6', '2017-08-15 15:40:00.0000');
INSERT INTO `book` VALUES ('27', '数据库1', '12.2', '2017-08-15 16:00:00.0000');
INSERT INTO `book` VALUES ('28', '数据库2', '12.6', '2017-08-15 16:00:00.0000');
INSERT INTO `book` VALUES ('29', '数据库1', '12.2', '2017-08-15 16:05:00.0000');
INSERT INTO `book` VALUES ('30', '数据库2', '12.6', '2017-08-15 16:05:00.0000');
INSERT INTO `book` VALUES ('31', '数据库1', '12.2', '2017-08-15 16:10:00.0000');
INSERT INTO `book` VALUES ('32', '数据库2', '12.6', '2017-08-15 16:10:00.0000');
INSERT INTO `book` VALUES ('33', '数据库1', '12.2', '2017-08-15 18:50:00.0000');
INSERT INTO `book` VALUES ('34', '数据库2', '12.6', '2017-08-15 18:50:00.0000');
INSERT INTO `book` VALUES ('35', '数据库1', '12.2', '2017-08-15 18:55:00.0000');
INSERT INTO `book` VALUES ('36', '数据库2', '12.6', '2017-08-15 18:55:00.0000');
INSERT INTO `book` VALUES ('37', '数据库1', '12.2', '2017-08-15 18:55:00.0000');
INSERT INTO `book` VALUES ('38', '数据库2', '12.6', '2017-08-15 18:55:00.0000');
INSERT INTO `book` VALUES ('39', '数据库1', '12.2', '2017-08-15 19:00:00.0000');
INSERT INTO `book` VALUES ('40', '数据库1', '12.2', '2017-08-15 19:00:00.0000');
INSERT INTO `book` VALUES ('41', '数据库2', '12.6', '2017-08-15 19:00:00.0000');
INSERT INTO `book` VALUES ('42', '数据库2', '12.6', '2017-08-15 19:00:00.0000');
INSERT INTO `book` VALUES ('43', '数据库1', '12.2', '2017-08-15 19:05:00.0000');
INSERT INTO `book` VALUES ('44', '数据库1', '12.2', '2017-08-15 19:05:00.0000');
INSERT INTO `book` VALUES ('45', '数据库2', '12.6', '2017-08-15 19:05:00.0000');
INSERT INTO `book` VALUES ('46', '数据库2', '12.6', '2017-08-15 19:05:00.0000');
INSERT INTO `book` VALUES ('47', '数据库1', '12.2', '2017-08-15 19:10:00.0000');
INSERT INTO `book` VALUES ('48', '数据库2', '12.6', '2017-08-15 19:10:00.0000');
INSERT INTO `book` VALUES ('49', '数据库1', '12.2', '2017-08-15 19:10:00.0000');
INSERT INTO `book` VALUES ('50', '数据库2', '12.6', '2017-08-15 19:10:00.0000');
INSERT INTO `book` VALUES ('51', '数据库1', '12.2', '2017-08-15 19:15:00.0000');
INSERT INTO `book` VALUES ('52', '数据库2', '12.6', '2017-08-15 19:15:00.0000');
INSERT INTO `book` VALUES ('53', '数据库1', '12.2', '2017-08-15 19:15:00.0000');
INSERT INTO `book` VALUES ('54', '数据库2', '12.6', '2017-08-15 19:15:00.0000');
INSERT INTO `book` VALUES ('55', '数据库1', '12.2', '2017-08-15 19:20:00.0000');
INSERT INTO `book` VALUES ('56', '数据库1', '12.2', '2017-08-15 19:20:00.0000');
INSERT INTO `book` VALUES ('57', '数据库2', '12.6', '2017-08-15 19:20:00.0000');
INSERT INTO `book` VALUES ('58', '数据库2', '12.6', '2017-08-15 19:20:00.0000');
INSERT INTO `book` VALUES ('59', '数据库1', '12.2', '2017-08-15 19:25:00.0000');
INSERT INTO `book` VALUES ('60', '数据库1', '12.2', '2017-08-15 19:25:00.0000');
INSERT INTO `book` VALUES ('61', '数据库2', '12.6', '2017-08-15 19:25:00.0000');
INSERT INTO `book` VALUES ('62', '数据库2', '12.6', '2017-08-15 19:25:00.0000');
INSERT INTO `book` VALUES ('63', '数据库1', '12.2', '2017-08-15 19:30:00.0000');
INSERT INTO `book` VALUES ('64', '数据库1', '12.2', '2017-08-15 19:30:00.0000');
INSERT INTO `book` VALUES ('65', '数据库2', '12.6', '2017-08-15 19:30:00.0000');
INSERT INTO `book` VALUES ('66', '数据库2', '12.6', '2017-08-15 19:30:00.0000');
INSERT INTO `book` VALUES ('67', '数据库1', '12.2', '2017-08-15 19:35:00.0000');
INSERT INTO `book` VALUES ('68', '数据库1', '12.2', '2017-08-15 19:35:00.0000');
INSERT INTO `book` VALUES ('69', '数据库2', '12.6', '2017-08-15 19:35:00.0000');
INSERT INTO `book` VALUES ('70', '数据库2', '12.6', '2017-08-15 19:35:00.0000');
INSERT INTO `book` VALUES ('71', '数据库1', '12.2', '2017-08-15 19:40:00.0000');
INSERT INTO `book` VALUES ('72', '数据库1', '12.2', '2017-08-15 19:40:00.0000');
INSERT INTO `book` VALUES ('73', '数据库2', '12.6', '2017-08-15 19:40:00.0000');
INSERT INTO `book` VALUES ('74', '数据库2', '12.6', '2017-08-15 19:40:00.0000');
INSERT INTO `book` VALUES ('75', '数据库1', '12.2', '2017-08-15 19:45:00.0000');
INSERT INTO `book` VALUES ('76', '数据库1', '12.2', '2017-08-15 19:45:00.0000');
INSERT INTO `book` VALUES ('77', '数据库2', '12.6', '2017-08-15 19:45:00.0000');
INSERT INTO `book` VALUES ('78', '数据库2', '12.6', '2017-08-15 19:45:00.0000');
INSERT INTO `book` VALUES ('79', '数据库1', '12.2', '2017-08-15 19:50:00.0000');
INSERT INTO `book` VALUES ('80', '数据库1', '12.2', '2017-08-15 19:50:00.0000');
INSERT INTO `book` VALUES ('81', '数据库2', '12.6', '2017-08-15 19:50:00.0000');
INSERT INTO `book` VALUES ('82', '数据库2', '12.6', '2017-08-15 19:50:00.0000');
INSERT INTO `book` VALUES ('83', '数据库1', '12.2', '2017-08-15 19:55:00.0000');
INSERT INTO `book` VALUES ('84', '数据库1', '12.2', '2017-08-15 19:55:00.0000');
INSERT INTO `book` VALUES ('85', '数据库2', '12.6', '2017-08-15 19:55:00.0000');
INSERT INTO `book` VALUES ('86', '数据库2', '12.6', '2017-08-15 19:55:00.0000');
INSERT INTO `book` VALUES ('87', '数据库1', '12.2', '2017-08-15 20:00:00.0000');
INSERT INTO `book` VALUES ('88', '数据库1', '12.2', '2017-08-15 20:00:00.0000');
INSERT INTO `book` VALUES ('89', '数据库2', '12.6', '2017-08-15 20:00:00.0000');
INSERT INTO `book` VALUES ('90', '数据库2', '12.6', '2017-08-15 20:00:00.0000');
INSERT INTO `book` VALUES ('91', '数据库1', '12.2', '2017-08-15 20:05:00.0000');
INSERT INTO `book` VALUES ('92', '数据库1', '12.2', '2017-08-15 20:05:00.0000');
INSERT INTO `book` VALUES ('93', '数据库2', '12.6', '2017-08-15 20:05:00.0000');
INSERT INTO `book` VALUES ('94', '数据库2', '12.6', '2017-08-15 20:05:00.0000');
INSERT INTO `book` VALUES ('95', '数据库1', '12.2', '2017-08-15 20:10:00.0000');
INSERT INTO `book` VALUES ('96', '数据库1', '12.2', '2017-08-15 20:10:00.0000');
INSERT INTO `book` VALUES ('97', '数据库2', '12.6', '2017-08-15 20:10:00.0000');
INSERT INTO `book` VALUES ('98', '数据库2', '12.6', '2017-08-15 20:10:00.0000');
INSERT INTO `book` VALUES ('99', '数据库1', '12.2', '2017-08-15 20:15:00.0000');
INSERT INTO `book` VALUES ('100', '数据库1', '12.2', '2017-08-15 20:15:00.0000');
INSERT INTO `book` VALUES ('101', '数据库2', '12.6', '2017-08-15 20:15:00.0000');
INSERT INTO `book` VALUES ('102', '数据库2', '12.6', '2017-08-15 20:15:00.0000');
INSERT INTO `book` VALUES ('103', '数据库1', '12.2', '2017-08-15 20:20:00.0000');
INSERT INTO `book` VALUES ('104', '数据库1', '12.2', '2017-08-15 20:20:00.0000');
INSERT INTO `book` VALUES ('105', '数据库2', '12.6', '2017-08-15 20:20:00.0000');
INSERT INTO `book` VALUES ('106', '数据库2', '12.6', '2017-08-15 20:20:00.0000');
INSERT INTO `book` VALUES ('107', '数据库1', '12.2', '2017-08-15 20:25:00.0000');
INSERT INTO `book` VALUES ('108', '数据库1', '12.2', '2017-08-15 20:25:00.0000');
INSERT INTO `book` VALUES ('109', '数据库2', '12.6', '2017-08-15 20:25:00.0000');
INSERT INTO `book` VALUES ('110', '数据库2', '12.6', '2017-08-15 20:25:00.0000');
INSERT INTO `book` VALUES ('111', '数据库1', '12.2', '2017-08-15 20:30:00.0000');
INSERT INTO `book` VALUES ('112', '数据库1', '12.2', '2017-08-15 20:30:00.0000');
INSERT INTO `book` VALUES ('113', '数据库2', '12.6', '2017-08-15 20:30:00.0000');
INSERT INTO `book` VALUES ('114', '数据库2', '12.6', '2017-08-15 20:30:00.0000');
INSERT INTO `book` VALUES ('115', '数据库1', '12.2', '2017-08-15 20:35:00.0000');
INSERT INTO `book` VALUES ('116', '数据库1', '12.2', '2017-08-15 20:35:00.0000');
INSERT INTO `book` VALUES ('117', '数据库2', '12.6', '2017-08-15 20:35:00.0000');
INSERT INTO `book` VALUES ('118', '数据库2', '12.6', '2017-08-15 20:35:00.0000');
INSERT INTO `book` VALUES ('119', '数据库1', '12.2', '2017-08-15 20:40:00.0000');
INSERT INTO `book` VALUES ('120', '数据库1', '12.2', '2017-08-15 20:40:00.0000');
INSERT INTO `book` VALUES ('121', '数据库2', '12.6', '2017-08-15 20:40:00.0000');
INSERT INTO `book` VALUES ('122', '数据库2', '12.6', '2017-08-15 20:40:00.0000');
INSERT INTO `book` VALUES ('123', '数据库1', '12.2', '2017-08-16 09:21:24.0000');
INSERT INTO `book` VALUES ('124', '数据库2', '12.6', '2017-08-16 09:21:24.0000');
INSERT INTO `book` VALUES ('125', '数据库1', '12.2', '2017-08-16 09:21:24.0000');
INSERT INTO `book` VALUES ('126', '数据库1', '12.2', '2017-08-16 09:21:24.0000');
INSERT INTO `book` VALUES ('127', '数据库1', '12.2', '2017-08-16 09:21:24.0000');
INSERT INTO `book` VALUES ('128', '数据库2', '12.6', '2017-08-16 09:21:24.0000');
INSERT INTO `book` VALUES ('129', '数据库2', '12.6', '2017-08-16 09:21:24.0000');
INSERT INTO `book` VALUES ('130', '数据库2', '12.6', '2017-08-16 09:21:24.0000');
INSERT INTO `book` VALUES ('131', '数据库1', '12.2', '2017-08-16 09:25:00.0000');
INSERT INTO `book` VALUES ('132', '数据库1', '12.2', '2017-08-16 09:25:00.0000');
INSERT INTO `book` VALUES ('133', '数据库2', '12.6', '2017-08-16 09:25:00.0000');
INSERT INTO `book` VALUES ('134', '数据库2', '12.6', '2017-08-16 09:25:00.0000');
INSERT INTO `book` VALUES ('135', '数据库1', '12.2', '2017-08-16 09:30:00.0000');
INSERT INTO `book` VALUES ('136', '数据库1', '12.2', '2017-08-16 09:30:00.0000');
INSERT INTO `book` VALUES ('137', '数据库2', '12.6', '2017-08-16 09:30:00.0000');
INSERT INTO `book` VALUES ('138', '数据库2', '12.6', '2017-08-16 09:30:00.0000');
INSERT INTO `book` VALUES ('139', '数据库1', '12.2', '2017-08-16 09:35:00.0000');
INSERT INTO `book` VALUES ('140', '数据库1', '12.2', '2017-08-16 09:35:00.0000');
INSERT INTO `book` VALUES ('141', '数据库2', '12.6', '2017-08-16 09:35:00.0000');
INSERT INTO `book` VALUES ('142', '数据库2', '12.6', '2017-08-16 09:35:00.0000');
INSERT INTO `book` VALUES ('143', '数据库1', '12.2', '2017-08-16 09:40:00.0000');
INSERT INTO `book` VALUES ('144', '数据库1', '12.2', '2017-08-16 09:40:00.0000');
INSERT INTO `book` VALUES ('145', '数据库2', '12.6', '2017-08-16 09:40:00.0000');
INSERT INTO `book` VALUES ('146', '数据库2', '12.6', '2017-08-16 09:40:00.0000');
INSERT INTO `book` VALUES ('147', '数据库1', '12.2', '2017-08-16 09:45:00.0000');
INSERT INTO `book` VALUES ('148', '数据库1', '12.2', '2017-08-16 09:45:00.0000');
INSERT INTO `book` VALUES ('149', '数据库2', '12.6', '2017-08-16 09:45:00.0000');
INSERT INTO `book` VALUES ('150', '数据库2', '12.6', '2017-08-16 09:45:00.0000');
INSERT INTO `book` VALUES ('151', '数据库1', '12.2', '2017-08-16 09:50:00.0000');
INSERT INTO `book` VALUES ('152', '数据库1', '12.2', '2017-08-16 09:50:00.0000');
INSERT INTO `book` VALUES ('153', '数据库2', '12.6', '2017-08-16 09:50:00.0000');
INSERT INTO `book` VALUES ('154', '数据库2', '12.6', '2017-08-16 09:50:00.0000');
INSERT INTO `book` VALUES ('155', '数据库1', '12.2', '2017-08-16 09:55:00.0000');
INSERT INTO `book` VALUES ('156', '数据库1', '12.2', '2017-08-16 09:55:00.0000');
INSERT INTO `book` VALUES ('157', '数据库2', '12.6', '2017-08-16 09:55:00.0000');
INSERT INTO `book` VALUES ('158', '数据库2', '12.6', '2017-08-16 09:55:00.0000');
INSERT INTO `book` VALUES ('159', '数据库1', '12.2', '2017-08-16 10:00:00.0000');
INSERT INTO `book` VALUES ('160', '数据库1', '12.2', '2017-08-16 10:00:00.0000');
INSERT INTO `book` VALUES ('161', '数据库2', '12.6', '2017-08-16 10:00:00.0000');
INSERT INTO `book` VALUES ('162', '数据库2', '12.6', '2017-08-16 10:00:00.0000');
INSERT INTO `book` VALUES ('163', '数据库1', '12.2', '2017-08-16 10:05:00.0000');
INSERT INTO `book` VALUES ('164', '数据库1', '12.2', '2017-08-16 10:05:00.0000');
INSERT INTO `book` VALUES ('165', '数据库2', '12.6', '2017-08-16 10:05:00.0000');
INSERT INTO `book` VALUES ('166', '数据库2', '12.6', '2017-08-16 10:05:00.0000');
INSERT INTO `book` VALUES ('167', '数据库1', '12.2', '2017-08-16 10:25:00.0000');
INSERT INTO `book` VALUES ('168', '数据库2', '12.6', '2017-08-16 10:25:00.0000');
INSERT INTO `book` VALUES ('169', '数据库1', '12.2', '2017-08-21 12:25:00.0000');
INSERT INTO `book` VALUES ('170', '数据库2', '12.6', '2017-08-21 12:25:00.0000');
INSERT INTO `book` VALUES ('171', '数据库1', '12.2', '2017-08-21 12:30:00.0000');
INSERT INTO `book` VALUES ('172', '数据库2', '12.6', '2017-08-21 12:30:00.0000');
INSERT INTO `book` VALUES ('173', '数据库1', '12.2', '2017-08-21 12:35:00.0000');
INSERT INTO `book` VALUES ('174', '数据库2', '12.6', '2017-08-21 12:35:00.0000');
INSERT INTO `book` VALUES ('175', '数据库1', '12.2', '2017-08-21 12:40:00.0000');
INSERT INTO `book` VALUES ('176', '数据库2', '12.6', '2017-08-21 12:40:00.0000');
INSERT INTO `book` VALUES ('177', '数据库1', '12.2', '2017-08-21 12:45:00.0000');
INSERT INTO `book` VALUES ('178', '数据库2', '12.6', '2017-08-21 12:45:00.0000');
INSERT INTO `book` VALUES ('179', '数据库1', '12.2', '2017-08-21 12:50:00.0000');
INSERT INTO `book` VALUES ('180', '数据库2', '12.6', '2017-08-21 12:50:00.0000');
INSERT INTO `book` VALUES ('181', '数据库1', '12.2', '2017-08-21 12:55:00.0000');
INSERT INTO `book` VALUES ('182', '数据库2', '12.6', '2017-08-21 12:55:00.0000');
INSERT INTO `book` VALUES ('183', '数据库1', '12.2', '2017-08-21 13:00:00.0000');
INSERT INTO `book` VALUES ('184', '数据库2', '12.6', '2017-08-21 13:00:00.0000');
INSERT INTO `book` VALUES ('185', '数据库1', '12.2', '2017-08-21 13:05:00.0000');
INSERT INTO `book` VALUES ('186', '数据库2', '12.6', '2017-08-21 13:05:00.0000');
INSERT INTO `book` VALUES ('187', '数据库1', '12.2', '2017-08-21 13:10:00.0000');
INSERT INTO `book` VALUES ('188', '数据库2', '12.6', '2017-08-21 13:10:00.0000');
INSERT INTO `book` VALUES ('189', '数据库1', '12.2', '2017-08-21 13:15:00.0000');
INSERT INTO `book` VALUES ('190', '数据库2', '12.6', '2017-08-21 13:15:00.0000');

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `context` varchar(255) DEFAULT NULL,
  `blog_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES ('1', '上学很好', '1');
INSERT INTO `post` VALUES ('2', '上学逃离农村', '1');
INSERT INTO `post` VALUES ('3', '成长很快乐', '2');
