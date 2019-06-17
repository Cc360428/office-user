/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-06-17 19:41:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `account` varchar(20) DEFAULT '' COMMENT '账号',
  `mobile` varchar(20) DEFAULT '' COMMENT '手机号码',
  `email` varchar(50) DEFAULT '' COMMENT '邮箱',
  `password` varchar(50) DEFAULT '' COMMENT '密码',
  `salt` varchar(50) DEFAULT '' COMMENT '密码加密盐值',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `token` varchar(100) DEFAULT '' COMMENT 'token值',
  `is_delete` int(2) DEFAULT '1' COMMENT '删除状态（1未删除，2已删除）',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_name` varchar(24) DEFAULT '' COMMENT '添加人',
  `update_name` varchar(24) DEFAULT '' COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `账号要唯一` (`account`) USING BTREE,
  UNIQUE KEY `手机号码要唯一` (`mobile`) USING BTREE,
  UNIQUE KEY `邮箱要唯一` (`email`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='user';
