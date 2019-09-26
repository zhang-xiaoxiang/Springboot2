/*
 Navicat Premium Data Transfer

 Source Server         : localhost-mysql-lottery
 Source Server Type    : MySQL
 Source Server Version : 100138
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 100138
 File Encoding         : 65001

 Date: 26/09/2019 13:52:24
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
  `device_id` varchar(64) CHARACTER SET tis620 COLLATE tis620_thai_ci NULL DEFAULT NULL COMMENT '移动设备唯一cid',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '用户注册时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '客户端用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('10', '张晓祥', '18883173476', 'e265048be258b4c63e2e0ac78a19ec1e', '1', '1090510500@qq.com', 123, '重庆', 1, '2019-07-04 19:45:05', '1', 1, '10000', '2019-06-05 17:34:58');
INSERT INTO `user` VALUES ('100', '迪丽热巴2', '18883173100', 'e265048be258b4c63e2e0ac78a19ec1e', '1', '1090510599@qq.com', 123, '福建', 0, '2018-09-17 19:45:05', '1', 0, '10086', '2019-06-17 17:34:58');
INSERT INTO `user` VALUES ('11', '李诞', '18883173411', 'e265048be258b4c63e2e0ac78a19ec1e', '1', '1090510511@qq.com', 123, '四川', 1, '2018-01-01 19:45:05', '1', 1, '10011', '2019-03-19 17:34:58');
INSERT INTO `user` VALUES ('1177096383195250688', '长草颜团子', '18893173476', 'e265048be258b4c63e2e0ac78a19ec1e', 'https://xinzuolvyou.oss-cn-beijing.aliyuncs.com/images/2019-07-08/8d804f9c700f498ea28037bc95c2f667-user_default.png', '10905109995@qq.com', 0, '重庆市-江北区-江北城 南方上格林', 1, '2019-09-26 13:43:41', '遥知不是雪,牙巴都笑缺!', 0, NULL, '2019-09-26 13:43:41');
INSERT INTO `user` VALUES ('1177096924042362880', '长花颜团子', '18893173991', 'e265048be258b4c63e2e0ac78a19ec1e', 'https://xinzuolvyou.oss-cn-beijing.aliyuncs.com/images/2019-07-08/8d804f9c700f498ea28037bc95c2f667-user_default.png', '10905109925@qq.com', 0, '重庆市-江北区-江北城 国际金融中心', 1, '2019-09-26 13:45:50', '遥知不是雪,牙巴都笑缺!', 0, NULL, '2019-09-26 13:45:50');
INSERT INTO `user` VALUES ('1177097116766437376', '长花颜团子2', '18893173922', 'e265048be258b4c63e2e0ac78a19ec1e', 'https://xinzuolvyou.oss-cn-beijing.aliyuncs.com/images/2019-07-08/8d804f9c700f498ea28037bc95c2f667-user_default.png', '10905109925@qq.com', 0, '重庆市-江北区-江北城 国际金融中心', 1, '2019-09-26 13:46:36', '遥知不是雪,牙巴都笑缺!', 0, NULL, '2019-09-26 13:46:36');
INSERT INTO `user` VALUES ('1177097657693241344', '长花颜团子3', '18893173925', 'e265048be258b4c63e2e0ac78a19ec1e', 'https://xinzuolvyou.oss-cn-beijing.aliyuncs.com/images/2019-07-08/8d804f9c700f498ea28037bc95c2f667-user_default.png', '10905109925@qq.com', 0, '重庆市-江北区-江北城 国际金融中心', 1, '2019-09-26 13:48:45', '遥知不是雪,牙巴都笑缺!', 0, NULL, '2019-09-26 13:48:45');
INSERT INTO `user` VALUES ('1177098374755647488', '长花颜团子6', '18893173966', 'e265048be258b4c63e2e0ac78a19ec1e', 'https://xinzuolvyou.oss-cn-beijing.aliyuncs.com/images/2019-07-08/8d804f9c700f498ea28037bc95c2f667-user_default.png', '10905109965@qq.com', 0, '重庆市-江北区-江北城 国际金融中心6', 1, '2019-09-26 13:51:36', '遥知不是雪,牙巴都笑缺!', 0, '100886', '2019-09-26 13:51:36');
INSERT INTO `user` VALUES ('123', '我是jfinal添加的用户', '13512345678', 'e265048be258b4c63e2e0ac78a19ec1e', '0', NULL, NULL, '广东', NULL, '2019-09-11 14:56:04', NULL, NULL, NULL, '2019-09-12 14:57:04');
INSERT INTO `user` VALUES ('124', '我是修改后的2', '13512345678', 'e265048be258b4c63e2e0ac78a19ec1e', '0', NULL, NULL, '广东', NULL, '2009-06-24 14:56:09', NULL, NULL, NULL, '2017-07-11 14:57:09');
INSERT INTO `user` VALUES ('22', '王思文', '18883173422', 'e265048be258b4c63e2e0ac78a19ec1e', '1', '1090510522@qq.com', 123, '重庆', 0, '2019-07-04 19:45:05', '1', 0, '10022', '2019-06-05 17:34:58');
INSERT INTO `user` VALUES ('33', '卡姆', '18883173433', 'e265048be258b4c63e2e0ac78a19ec1e', '1', '1090510533@qq.com', 123, '四川', 1, '2019-07-02 19:45:05', '1', 1, '10086', '2019-03-06 17:34:58');
INSERT INTO `user` VALUES ('44', '赵丽颖', '18883173444', 'e265048be258b4c63e2e0ac78a19ec1e', '1', '1090510544@qq.com', 123, '重庆', 0, '2019-07-04 19:45:05', '1', 0, '10086', '2019-06-04 17:34:58');
INSERT INTO `user` VALUES ('45', '张靓颖', '18883173445', 'e265048be258b4c63e2e0ac78a19ec1e', '1', '1090510545@qq.com', 123, '重庆', 0, '2017-12-18 19:45:05', '1', 1, '10086', '2019-06-17 17:34:58');
INSERT INTO `user` VALUES ('55', '乔丹', '18883173455', 'e265048be258b4c63e2e0ac78a19ec1e', '1', '1090510555@qq.com', 123, '北京', 1, '2014-08-12 19:45:05', '1', 0, '10086', '2018-12-17 17:34:58');
INSERT INTO `user` VALUES ('66', '鲁班七号', '18883173466', 'e265048be258b4c63e2e0ac78a19ec1e', '1', '1090510566@qq.com', 123, '重庆', 1, '2019-07-04 19:45:05', '1', 1, '10086', '2018-12-18 17:34:58');
INSERT INTO `user` VALUES ('77', '诸葛亮', '18883173477', 'e265048be258b4c63e2e0ac78a19ec1e', '1', '1090510577@qq.com', 123, '上海', 1, '2015-01-01 19:45:05', '1', 0, '10086', '2019-06-05 17:34:58');
INSERT INTO `user` VALUES ('88', '周杰伦', '18883173488', 'e265048be258b4c63e2e0ac78a19ec1e', '1', '1090510588@qq.com', 123, '重庆', 1, '2018-12-19 19:45:05', '1', 1, '10086', '2019-06-05 17:34:58');
INSERT INTO `user` VALUES ('99', '迪丽热巴', '18883173499', 'e265048be258b4c63e2e0ac78a19ec1e', '1', '1090510599@qq.com', 123, '福建', 0, '2018-09-17 19:45:05', '1', 0, '10086', '2019-06-17 17:34:58');

SET FOREIGN_KEY_CHECKS = 1;
