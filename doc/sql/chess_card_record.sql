/*
Navicat MySQL Data Transfer

Source Server         : 120.55.54.141
Source Server Version : 50642
Source Host           : 120.55.54.141:3308
Source Database       : chess

Target Server Type    : MYSQL
Target Server Version : 50642
File Encoding         : 65001

Date: 2019-08-22 18:20:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for chess_card_record
-- ----------------------------
DROP TABLE IF EXISTS `chess_card_record`;
CREATE TABLE `chess_card_record` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `BIG_FIELD` tinyint(4) DEFAULT NULL COMMENT '大场',
  `SMALL_FIELD` tinyint(4) DEFAULT NULL COMMENT '小场',
  `LEVEL` tinyint(4) DEFAULT NULL COMMENT '等级',
  `POPULATION` tinyint(4) DEFAULT NULL,
  `ROLE_1` smallint(6) DEFAULT NULL COMMENT '第一个角色',
  `ROLE_2` smallint(6) DEFAULT NULL COMMENT '第二个角色',
  `ROLE_3` smallint(6) DEFAULT NULL COMMENT '第三个角色',
  `ROLE_4` smallint(6) DEFAULT NULL COMMENT '第四个角色',
  `CREATE_ID` int(11) DEFAULT NULL COMMENT '创建人id',
  `CREATE_TIME` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
