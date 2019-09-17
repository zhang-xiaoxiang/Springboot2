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

 Date: 16/09/2019 22:19:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address`  (
  `address_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '收货地址表主键id',
  `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '用户主键ID',
  `address_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '收货人姓名',
  `address_phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '联系方式',
  `address_region` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '所在地区',
  `address_location` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细收货地址',
  `address_state` int(1) NULL DEFAULT NULL COMMENT '是否设置为默认地址(0普通状态,1是默认)',
  `address_time` datetime(0) NULL DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`address_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '收货地址列表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('1560839798862486320', '00', '收货人(鲁班)', '13627699157', '重庆-重庆市-沙坪坝区', '王者峡谷下路', 0, '2019-08-27 09:45:44');
INSERT INTO `address` VALUES ('1560839949549898511', '11', '收货人(诸葛亮)', '188831734765', '重庆市-江北区', '王王者峡谷中路', 0, '2019-06-03 14:39:19');
INSERT INTO `address` VALUES ('1560839991604385397', '00', '收货人(小乔)', '188831734765', '重庆市-江北区', '王王者峡谷中路123门牌号号', 1, '2019-06-22 14:39:52');
INSERT INTO `address` VALUES ('1560840026517866423', '33', '鲁班100号', '188831734765', '重庆市-江北区', '王者峡谷666666', 0, '2019-06-18 14:40:26');
INSERT INTO `address` VALUES ('1566870467519696941', '33', '收货人(周星驰)', '15880000000', '广东省-深圳市-龙岗区', '喜剧天堂666号', 0, '2019-09-12 16:11:45');
INSERT INTO `address` VALUES ('1567512039191879352', '55', '蔡文姬', '18323495263', '重庆-重庆市-南岸区', '重庆市渝中区朝天门', 0, '2019-09-03 20:00:39');
INSERT INTO `address` VALUES ('1567673619850984981', '66', '飞车', '13627699157', '广东省-广州市-白云区', '过分方法G发个古古怪怪嘎嘎嘎vvvvvvvvvvv出发个好吧v尴尬给一个VBv吃v', 0, '2019-09-05 16:53:40');
INSERT INTO `address` VALUES ('1567673715218663627', '77', '皇宫', '15880000000', '广东省-深圳市-龙岗区', '101', 0, '2019-09-12 16:11:45');
INSERT INTO `address` VALUES ('1568275905279185054', '88', '长草颜团子', '15880000000', '广东省-深圳市-龙岗区', '北京朝阳区12栋', 0, '2019-09-12 16:11:45');
INSERT INTO `address` VALUES ('1568275905395583303', '11', '收货人(曹操)', '15880000000', '广东省-深圳市-龙岗区', '三国时期的地址哈哈哈', 1, '2019-09-12 16:11:45');

SET FOREIGN_KEY_CHECKS = 1;
