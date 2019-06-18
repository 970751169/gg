/*
Navicat MySQL Data Transfer

Source Server         : localhost_3305
Source Server Version : 50726
Source Host           : localhost:3305
Source Database       : crm

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-06-17 14:26:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article_web
-- ----------------------------
DROP TABLE IF EXISTS `article_web`;
CREATE TABLE `article_web` (
  `article_web_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '增长ID',
  `title` char(255) NOT NULL COMMENT '标题',
  `category_name` char(50) NOT NULL COMMENT '分类名称',
  `summary` varchar(50) DEFAULT NULL COMMENT '简介',
  `content` varchar(255) NOT NULL COMMENT '内容',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `tb_status` char(50) DEFAULT '正常' COMMENT '状态：正常，正常；删除，删除',
  PRIMARY KEY (`article_web_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
