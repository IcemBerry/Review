/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : review

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-06-01 14:26:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for delivery
-- ----------------------------
DROP TABLE IF EXISTS `delivery`;
CREATE TABLE `delivery` (
  `delivery_id` int(11) NOT NULL AUTO_INCREMENT,
  `delivery_user_id` int(11) DEFAULT NULL,
  `delivery_type` int(11) DEFAULT NULL,
  `delivery_desc` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `delivery_path` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `delivery_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `delivery_state` int(11) DEFAULT NULL,
  PRIMARY KEY (`delivery_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `score_id` int(11) NOT NULL AUTO_INCREMENT,
  `score_user_id` int(11) DEFAULT NULL,
  `score_topic` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `score_opinion` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `score_fraction` int(11) DEFAULT NULL,
  PRIMARY KEY (`score_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_role` int(11) DEFAULT NULL,
  `user_lead` int(11) DEFAULT NULL,
  `user_login_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_login_password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_college` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_message` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_state` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
SET FOREIGN_KEY_CHECKS=1;
