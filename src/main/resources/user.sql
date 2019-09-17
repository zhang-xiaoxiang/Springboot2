/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 15/09/2019 14:18:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户主键ID',
  `user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `user_phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户手机号',
  `user_password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户登录密码',
  `user_icon` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户头像',
  `user_email` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户邮箱地址',
  `user_autonym` int(3) NULL DEFAULT NULL COMMENT '用户身份认证 (0未认证,1已认证)',
  `user_site` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户地址',
  `user_sex` int(1) NULL DEFAULT NULL COMMENT '用户性别( 0女,1男)',
  `user_date_birth` datetime(0) NULL DEFAULT NULL COMMENT '用户出生日期',
  `user_signature` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户个性签名',
  `user_vip` int(3) NULL DEFAULT NULL COMMENT '用户是否会员 ( 0否1是)',
  `c_id` varchar(64) CHARACTER SET tis620 COLLATE tis620_thai_ci NULL DEFAULT NULL COMMENT '移动设备唯一cid',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '用户注册时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '客户端用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('00', '长草颜团子00', '18883173400', 'e265048be258b4c63e2e0ac78a19ec1e', '1', '1090510500@qq.com', 123, '重庆', 1, '2019-07-04 19:45:05', '1', 0, '10000', '2019-06-05 17:34:58');
INSERT INTO `user` VALUES ('11', '长草颜团子11', '18883173411', 'e265048be258b4c63e2e0ac78a19ec1e', '1', '1090510511@qq.com', 123, '四川', 1, '2018-01-01 19:45:05', '1', 1, '10011', '2019-03-19 17:34:58');
INSERT INTO `user` VALUES ('22', '长草颜团子22', '18883173422', 'e265048be258b4c63e2e0ac78a19ec1e', '1', '1090510522@qq.com', 123, '重庆', 0, '2019-07-04 19:45:05', '1', 0, '10022', '2019-06-05 17:34:58');
INSERT INTO `user` VALUES ('33', '长草颜团子33', '18883173433', 'e265048be258b4c63e2e0ac78a19ec1e', '1', '1090510533@qq.com', 123, '四川', 1, '2019-07-02 19:45:05', '1', 1, '10086', '2019-03-06 17:34:58');
INSERT INTO `user` VALUES ('44', '长草颜团子44', '18883173444', 'e265048be258b4c63e2e0ac78a19ec1e', '1', '1090510544@qq.com', 123, '重庆', 0, '2019-07-04 19:45:05', '1', 0, '10086', '2019-06-04 17:34:58');
INSERT INTO `user` VALUES ('45', '长草颜团子45', '18883173445', 'e265048be258b4c63e2e0ac78a19ec1e', '1', '1090510545@qq.com', 123, '重庆', 0, '2017-12-18 19:45:05', '1', 1, '10086', '2019-06-17 17:34:58');
INSERT INTO `user` VALUES ('55', '长草颜团子55', '18883173455', 'e265048be258b4c63e2e0ac78a19ec1e', '1', '1090510555@qq.com', 123, '北京', 1, '2014-08-12 19:45:05', '1', 0, '10086', '2018-12-17 17:34:58');
INSERT INTO `user` VALUES ('66', '长草颜团子66', '18883173466', 'e265048be258b4c63e2e0ac78a19ec1e', '1', '1090510566@qq.com', 123, '重庆', 0, '2019-07-04 19:45:05', '1', 1, '10086', '2018-12-18 17:34:58');
INSERT INTO `user` VALUES ('77', '长草颜团子77', '18883173477', 'e265048be258b4c63e2e0ac78a19ec1e', '1', '1090510577@qq.com', 123, '上海', 1, '2015-01-01 19:45:05', '1', 0, '10086', '2019-06-05 17:34:58');
INSERT INTO `user` VALUES ('88', '长草颜团子88', '18883173488', 'e265048be258b4c63e2e0ac78a19ec1e', '1', '1090510588@qq.com', 123, '重庆', 0, '2018-12-19 19:45:05', '1', 1, '10086', '2019-06-05 17:34:58');
INSERT INTO `user` VALUES ('99', '长草颜团子99', '18883173499', 'e265048be258b4c63e2e0ac78a19ec1e', '1', '1090510599@qq.com', 123, '福建', 1, '2018-09-17 19:45:05', '1', 0, '10086', '2019-06-17 17:34:58');

SET FOREIGN_KEY_CHECKS = 1;
