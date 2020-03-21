/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : library_management_system

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 21/03/2020 15:16:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` int(20) NOT NULL,
  `password` varchar(15) NOT NULL,
  `username` varchar(15) NOT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
BEGIN;
INSERT INTO `admin` VALUES (1, '123456', 'admin');
COMMIT;

-- ----------------------------
-- Table structure for book_info
-- ----------------------------
DROP TABLE IF EXISTS `book_info`;
CREATE TABLE `book_info` (
  `book_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '书号',
  `book_name` varchar(20) NOT NULL COMMENT '书名',
  `author` varchar(15) NOT NULL COMMENT '作者',
  `total` int(11) NOT NULL COMMENT '总量',
  `number` int(11) NOT NULL COMMENT '现量',
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book_info
-- ----------------------------
BEGIN;
INSERT INTO `book_info` VALUES (1, 'C++程序语言', '110', 12, 12);
INSERT INTO `book_info` VALUES (2, 'Java程序语言', '222', 12, 12);
INSERT INTO `book_info` VALUES (3, 'Python程序语言', '333', 12, 12);
INSERT INTO `book_info` VALUES (4, '算法', '444', 12, 12);
INSERT INTO `book_info` VALUES (5, '数据结构', '555', 12, 12);
INSERT INTO `book_info` VALUES (6, 'MySQL', '666', 12, 12);
INSERT INTO `book_info` VALUES (7, '编译原理', '777', 12, 12);
INSERT INTO `book_info` VALUES (8, '软件工程', '888', 12, 12);
INSERT INTO `book_info` VALUES (9, '计算机组成原理', '999', 12, 12);
INSERT INTO `book_info` VALUES (10, '大数据', '1010', 12, 12);
INSERT INTO `book_info` VALUES (11, 'Spring', 'spring', 12, 12);
COMMIT;

-- ----------------------------
-- Table structure for lend_list
-- ----------------------------
DROP TABLE IF EXISTS `lend_list`;
CREATE TABLE `lend_list` (
  `ser_num` int(20) NOT NULL AUTO_INCREMENT COMMENT '流水号',
  `book_id` int(20) NOT NULL COMMENT '图书号',
  `reader_id` int(20) NOT NULL COMMENT '读者号',
  `lend_date` datetime DEFAULT NULL COMMENT '借出日期',
  `back_date` datetime DEFAULT NULL COMMENT '归还日期',
  PRIMARY KEY (`ser_num`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for reader_info
-- ----------------------------
DROP TABLE IF EXISTS `reader_info`;
CREATE TABLE `reader_info` (
  `reader_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '读者号',
  `username` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  PRIMARY KEY (`reader_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reader_info
-- ----------------------------
BEGIN;
INSERT INTO `reader_info` VALUES (1, 'reader01', '1', '张三');
INSERT INTO `reader_info` VALUES (2, 'reader02', '1', '李四');
INSERT INTO `reader_info` VALUES (3, 'reader03', '1', '王五');
INSERT INTO `reader_info` VALUES (4, 'reader04', '1', '赵六');
INSERT INTO `reader_info` VALUES (5, 'reader05', '1', 'superman');
INSERT INTO `reader_info` VALUES (6, 'test', '123456', 'superman');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
