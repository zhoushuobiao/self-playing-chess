/*
Navicat MySQL Data Transfer

Source Server         : 120.55.54.141
Source Server Version : 50642
Source Host           : 120.55.54.141:3308
Source Database       : chess

Target Server Type    : MYSQL
Target Server Version : 50642
File Encoding         : 65001

Date: 2019-08-30 11:07:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for chess_card_record
-- ----------------------------
DROP TABLE IF EXISTS `chess_card_record`;
CREATE TABLE `chess_card_record` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `BIG_FIELD` tinyint(4) NOT NULL COMMENT '大局',
  `SMALL_FIELD` tinyint(4) NOT NULL COMMENT '小局',
  `LEVELS` tinyint(4) NOT NULL COMMENT '等级',
  `POPULATION` tinyint(4) NOT NULL COMMENT '人口',
  `ROLE_1` smallint(6) NOT NULL COMMENT '第一张卡',
  `ROLE_2` smallint(6) NOT NULL COMMENT '第二张卡',
  `ROLE_3` smallint(6) NOT NULL COMMENT '第三张卡',
  `ROLE_4` smallint(6) NOT NULL COMMENT '第四张卡',
  `CREATE_ID` int(11) NOT NULL COMMENT '创建人id',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`ID`),
  KEY `ROLE_1_INDEX` (`ROLE_1`) USING BTREE,
  KEY `ROLE_2_INDEX` (`ROLE_2`) USING BTREE,
  KEY `ROLE_3_INDEX` (`ROLE_3`) USING BTREE,
  KEY `ROLE_4_INDEX` (`ROLE_4`) USING BTREE,
  KEY `FIELD_INDEX` (`BIG_FIELD`,`SMALL_FIELD`) USING BTREE,
  KEY `LEVELS_INDEX` (`LEVELS`) USING BTREE,
  KEY `POPULATION_INDEX` (`POPULATION`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;
