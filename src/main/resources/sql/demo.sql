/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : ca

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 18/10/2019 09:20:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_detail_user
-- ----------------------------
DROP TABLE IF EXISTS `t_detail_user`;
CREATE TABLE `t_detail_user`  (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `id_user` int(8) NULL DEFAULT NULL COMMENT '所属用户id',
  `identification` int(32) NULL DEFAULT NULL COMMENT '认证的账号(学号 or 工号)',
  `name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `gender` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `telephone` int(16) NULL DEFAULT NULL COMMENT '电话号码',
  `major` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业',
  `grade` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班级',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `id_user`(`id_user`) USING BTREE,
  CONSTRAINT `t_detail_user_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_detail_user
-- ----------------------------
INSERT INTO `t_detail_user` VALUES (2, 14, 131, '321', '女', '123', 13, '123', '132');
INSERT INTO `t_detail_user` VALUES (3, 14, 123, '132', '男', '12', 123, '3', '132');
INSERT INTO `t_detail_user` VALUES (4, 14, 3, '3', '男', '123', 13, '123', '132');

-- ----------------------------
-- Table structure for t_favorites_goods
-- ----------------------------
DROP TABLE IF EXISTS `t_favorites_goods`;
CREATE TABLE `t_favorites_goods`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `id_goods` int(16) NULL DEFAULT NULL COMMENT '收藏的商品id',
  `id_user` int(16) NULL DEFAULT NULL COMMENT '收藏者的id',
  `time_create` date NULL DEFAULT NULL COMMENT '收藏时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `id_goods`(`id_goods`) USING BTREE,
  INDEX `id_user`(`id_user`) USING BTREE,
  CONSTRAINT `t_favorites_goods_ibfk_1` FOREIGN KEY (`id_goods`) REFERENCES `t_goods` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_favorites_goods_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_favorites_goods
-- ----------------------------
INSERT INTO `t_favorites_goods` VALUES (7, 7, 14, '2019-10-17');

-- ----------------------------
-- Table structure for t_goods
-- ----------------------------
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods`  (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `id_user` int(8) NULL DEFAULT NULL COMMENT '商品发布者id',
  `title` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品标题',
  `type` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品类型',
  `quota` int(5) NULL DEFAULT NULL COMMENT '商品剩余数量',
  `price` double(16, 2) NULL DEFAULT NULL COMMENT '商品价格',
  `describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品描述',
  `time_create` datetime(0) NULL DEFAULT NULL COMMENT '上架时间',
  `state` tinyint(1) NULL DEFAULT NULL COMMENT '商品状态',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `id_user`(`id_user`) USING BTREE,
  CONSTRAINT `t_goods_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_goods
-- ----------------------------
INSERT INTO `t_goods` VALUES (1, 2, '二手电脑', '电子产品', 1, 100.00, '戴尔的', '2019-10-09 15:51:55', 1);
INSERT INTO `t_goods` VALUES (2, 2, '桌子', '电子产品', 1, 20.00, '新的', '2019-10-23 15:53:46', -1);
INSERT INTO `t_goods` VALUES (3, 1, '椅子', '电子产品', 1, 100.00, '1成新', '2019-10-09 15:54:01', 1);
INSERT INTO `t_goods` VALUES (4, 3, '锅', '电子产品', 1, 3.50, '9成新', '2019-10-09 15:54:19', 1);
INSERT INTO `t_goods` VALUES (5, 2, '饮水机', '电子产品', 1, 10.00, '8成新', '2019-10-09 15:54:34', 1);
INSERT INTO `t_goods` VALUES (6, 3, '华为', '电子产品', 1, 1024.00, '买到赚到', '2019-10-09 15:54:49', 1);
INSERT INTO `t_goods` VALUES (7, 3, '魅族', '电子产品', 1, 888.00, '便宜卖了', '2019-10-09 15:55:03', 1);
INSERT INTO `t_goods` VALUES (8, 2, '小米', '电子产品', 1, 998.00, '不要了', '2019-10-10 15:55:17', 1);
INSERT INTO `t_goods` VALUES (9, 2, '塑料', '电子产品', 1, 1000.00, '没有描述', '2019-10-17 15:55:35', 1);
INSERT INTO `t_goods` VALUES (10, 14, '二手电脑', '电子产品', 1, 100.00, '戴尔的', '2019-10-09 15:51:55', 1);
INSERT INTO `t_goods` VALUES (11, 14, '桌子', '电子产品', 1, 20.00, '新的', '2019-10-23 15:53:46', 1);
INSERT INTO `t_goods` VALUES (12, 14, '椅子', '电子产品', 1, 100.00, '1成新', '2019-10-09 15:54:01', 1);
INSERT INTO `t_goods` VALUES (13, 14, '锅', '电子产品', 1, 3.50, '9成新', '2019-10-09 15:54:19', -1);
INSERT INTO `t_goods` VALUES (14, 14, '饮水机', '电子产品', 1, 10.00, '8成新', '2019-10-09 15:54:34', 0);
INSERT INTO `t_goods` VALUES (15, 14, '华为', '电子产品', 1, 1024.00, '买到赚到', '2019-10-09 15:54:49', 1);
INSERT INTO `t_goods` VALUES (16, 14, '魅族', '电子产品', 1, 888.00, '便宜卖了', '2019-10-09 15:55:03', -1);
INSERT INTO `t_goods` VALUES (17, 14, '小米', '电子产品', 1, 998.00, '不要了', '2019-10-10 15:55:17', 1);
INSERT INTO `t_goods` VALUES (18, 14, '塑料', '电子产品', 1, 1000.00, '没有描述', '2019-10-17 15:55:35', 1);
INSERT INTO `t_goods` VALUES (19, 14, '塑料', '1', 1, 1000.00, '没有描述', '2019-10-17 15:55:35', 1);
INSERT INTO `t_goods` VALUES (20, 14, '塑料', '1', 1, 1000.00, '没有描述', '2019-10-17 15:55:35', 1);
INSERT INTO `t_goods` VALUES (21, 14, '塑料', '1', 1, 1000.00, '没有描述', '2019-10-17 15:55:35', 1);
INSERT INTO `t_goods` VALUES (22, 14, '塑料', '1', 1, 1000.00, '没有描述', '2019-10-17 15:55:35', 1);
INSERT INTO `t_goods` VALUES (23, 14, '塑料', '1', 1, 1000.00, '没有描述', '2019-10-17 15:55:35', 1);
INSERT INTO `t_goods` VALUES (24, 14, '塑料', '1', 1, 1000.00, '没有描述', '2019-10-17 15:55:35', 1);
INSERT INTO `t_goods` VALUES (25, 14, '塑料', '1', 1, 1000.00, '没有描述', '2019-10-17 15:55:35', 1);
INSERT INTO `t_goods` VALUES (26, 14, '塑料', '1', 1, 1000.00, '没有描述', '2019-10-17 15:55:35', 1);

-- ----------------------------
-- Table structure for t_img_goods
-- ----------------------------
DROP TABLE IF EXISTS `t_img_goods`;
CREATE TABLE `t_img_goods`  (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片文件名',
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片存放路径',
  `size` int(64) NULL DEFAULT NULL COMMENT '图片大小',
  `time_upload` datetime(0) NULL DEFAULT NULL COMMENT '上传时间',
  `type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片类型',
  `id_goods` int(16) NULL DEFAULT NULL COMMENT '所属商品id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `id_goods`(`id_goods`) USING BTREE,
  CONSTRAINT `t_img_goods_ibfk_1` FOREIGN KEY (`id_goods`) REFERENCES `t_goods` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_img_goods
-- ----------------------------
INSERT INTO `t_img_goods` VALUES (1, 'timg.jpg', '/mainassets/img/', 1, '2019-10-10 15:56:38', '1', 1);
INSERT INTO `t_img_goods` VALUES (2, 'timg.jpg', '/mainassets/img/', 1, '2019-10-10 15:56:38', '1', 2);
INSERT INTO `t_img_goods` VALUES (3, 'timg.jpg', '/mainassets/img/', 1, '2019-10-10 15:56:38', '1', 3);
INSERT INTO `t_img_goods` VALUES (4, 'timg.jpg', '/mainassets/img/', 1, '2019-10-10 15:56:38', '1', 4);
INSERT INTO `t_img_goods` VALUES (5, 'timg.jpg', '/mainassets/img/', 1, '2019-10-10 15:56:38', '1', 5);
INSERT INTO `t_img_goods` VALUES (6, 'timg.jpg', '/mainassets/img/', 1, '2019-10-10 15:56:38', '1', 6);
INSERT INTO `t_img_goods` VALUES (7, 'timg.jpg', '/mainassets/img/', 1, '2019-10-10 15:56:38', '1', 7);
INSERT INTO `t_img_goods` VALUES (8, 'timg.jpg', '/mainassets/img/', 1, '2019-10-10 15:56:38', '1', 8);
INSERT INTO `t_img_goods` VALUES (9, 'timg.jpg', '/mainassets/img/', 1, '2019-10-10 15:56:38', '1', 9);
INSERT INTO `t_img_goods` VALUES (10, 'timg.jpg', '/mainassets/img/', 1, '2019-10-10 09:15:07', '1', 10);
INSERT INTO `t_img_goods` VALUES (11, 'timg.jpg', '/mainassets/img/', 1, '2019-10-10 09:16:27', '1', 11);
INSERT INTO `t_img_goods` VALUES (12, 'timg.jpg', '/mainassets/img/', 1, '2019-10-10 09:16:27', '1', 12);
INSERT INTO `t_img_goods` VALUES (13, 'timg.jpg', '/mainassets/img/', 1, '2019-10-10 09:16:27', '1', 13);
INSERT INTO `t_img_goods` VALUES (14, 'timg.jpg', '/mainassets/img/', 1, '2019-10-10 09:16:27', '1', 14);
INSERT INTO `t_img_goods` VALUES (15, 'timg.jpg', '/mainassets/img/', 1, '2019-10-10 09:16:27', '1', 15);
INSERT INTO `t_img_goods` VALUES (16, 'timg.jpg', '/mainassets/img/', 1, '2019-10-10 09:16:27', '1', 16);
INSERT INTO `t_img_goods` VALUES (17, 'timg.jpg', '/mainassets/img/', 1, '2019-10-10 09:16:27', '1', 17);
INSERT INTO `t_img_goods` VALUES (18, 'timg.jpg', '/mainassets/img/', 1, '2019-10-10 09:16:27', '1', 18);
INSERT INTO `t_img_goods` VALUES (19, 'timg.jpg', '/mainassets/img/', 1, '2019-10-10 09:16:27', '1', 19);
INSERT INTO `t_img_goods` VALUES (20, 'timg.jpg', '/mainassets/img/', 1, '2019-10-10 09:16:27', '1', 20);
INSERT INTO `t_img_goods` VALUES (21, 'timg.jpg', '/mainassets/img/', 1, '2019-10-10 09:16:27', '1', 21);
INSERT INTO `t_img_goods` VALUES (22, 'timg.jpg', '/mainassets/img/', 1, '2019-10-10 09:16:27', '1', 22);
INSERT INTO `t_img_goods` VALUES (23, 'timg.jpg', '/mainassets/img/', 1, '2019-10-10 09:16:27', '1', 23);
INSERT INTO `t_img_goods` VALUES (24, 'timg.jpg', '/mainassets/img/', 1, '2019-10-10 09:16:27', '1', 24);
INSERT INTO `t_img_goods` VALUES (25, 'timg.jpg', '/mainassets/img/', 1, '2019-10-10 09:16:27', '1', 25);
INSERT INTO `t_img_goods` VALUES (26, 'timg.jpg', '/mainassets/img/', 1, '2019-10-10 09:16:27', '1', 26);

-- ----------------------------
-- Table structure for t_img_task
-- ----------------------------
DROP TABLE IF EXISTS `t_img_task`;
CREATE TABLE `t_img_task`  (
  `id` int(16) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片文件名',
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片存放路径',
  `size` int(64) NULL DEFAULT NULL COMMENT '图片大小',
  `time_upload` datetime(0) NULL DEFAULT NULL COMMENT '上传时间',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片类型',
  `id_task` int(16) NULL DEFAULT NULL COMMENT '所属任务的id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `id_task`(`id_task`) USING BTREE,
  CONSTRAINT `t_img_task_ibfk_1` FOREIGN KEY (`id_task`) REFERENCES `t_task` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_record_task
-- ----------------------------
DROP TABLE IF EXISTS `t_record_task`;
CREATE TABLE `t_record_task`  (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `id_task` int(16) NULL DEFAULT NULL COMMENT '所属任务id',
  `id_responder` int(16) NULL DEFAULT NULL COMMENT '领取任务者的id',
  `time_create` timestamp(0) NULL DEFAULT NULL COMMENT '记录创建时间',
  `time_completion` datetime(0) NULL DEFAULT NULL COMMENT '完成时间',
  `state` tinyint(1) NULL DEFAULT NULL COMMENT '任务进行状态',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `id_task`(`id_task`) USING BTREE,
  INDEX `id_responder`(`id_responder`) USING BTREE,
  CONSTRAINT `t_record_task_ibfk_1` FOREIGN KEY (`id_task`) REFERENCES `t_task` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_record_task_ibfk_3` FOREIGN KEY (`id_responder`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_record_task
-- ----------------------------
INSERT INTO `t_record_task` VALUES (1, 7, 14, '2019-10-14 14:42:10', '2019-10-14 14:42:14', 11);
INSERT INTO `t_record_task` VALUES (2, 5, 14, '2019-10-14 15:44:59', '2019-10-14 16:05:50', 10);
INSERT INTO `t_record_task` VALUES (3, 4, 14, '2019-10-14 16:06:12', NULL, 10);
INSERT INTO `t_record_task` VALUES (4, 22, 5, '2019-10-15 21:26:20', NULL, 10);
INSERT INTO `t_record_task` VALUES (5, 18, 3, '2019-10-15 22:16:38', NULL, 10);

-- ----------------------------
-- Table structure for t_record_transaction
-- ----------------------------
DROP TABLE IF EXISTS `t_record_transaction`;
CREATE TABLE `t_record_transaction`  (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `id_goods` int(16) NULL DEFAULT NULL COMMENT '所属商品id',
  `id_purchaser` int(16) NULL DEFAULT NULL COMMENT '商品购买者id',
  `time_create` datetime(0) NULL DEFAULT NULL COMMENT '订单创建时间',
  `time_completion` datetime(0) NULL DEFAULT NULL COMMENT '订单完成时间',
  `state` tinyint(1) NOT NULL DEFAULT 10 COMMENT '订单状态',
  `trade_no` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付宝订单号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `id_goods`(`id_goods`) USING BTREE,
  INDEX `id_purchaser`(`id_purchaser`) USING BTREE,
  CONSTRAINT `t_record_transaction_ibfk_1` FOREIGN KEY (`id_goods`) REFERENCES `t_goods` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_record_transaction_ibfk_3` FOREIGN KEY (`id_purchaser`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_record_transaction
-- ----------------------------
INSERT INTO `t_record_transaction` VALUES (1, 3, 14, '2019-10-14 10:54:01', '2019-10-14 10:54:04', 101, '2019101622001459221000022738');
INSERT INTO `t_record_transaction` VALUES (2, 1, 1, '2019-10-16 00:00:00', NULL, 10, NULL);
INSERT INTO `t_record_transaction` VALUES (3, 1, 1, '2019-10-16 00:00:00', NULL, 11, NULL);
INSERT INTO `t_record_transaction` VALUES (5, 3, 2, '2019-10-16 00:00:00', NULL, 10, NULL);
INSERT INTO `t_record_transaction` VALUES (6, 6, 2, '2019-10-16 00:00:00', NULL, 10, NULL);
INSERT INTO `t_record_transaction` VALUES (7, 1, 1, '2019-10-16 00:00:00', NULL, 10, NULL);
INSERT INTO `t_record_transaction` VALUES (8, 2, 1, '2019-10-16 00:00:00', NULL, 10, NULL);
INSERT INTO `t_record_transaction` VALUES (9, 2, 1, '2019-10-16 00:00:00', NULL, 10, NULL);
INSERT INTO `t_record_transaction` VALUES (10, 2, 1, '2019-10-16 00:00:00', NULL, 10, NULL);
INSERT INTO `t_record_transaction` VALUES (11, 2, 2, '2019-10-16 00:00:00', NULL, 10, NULL);
INSERT INTO `t_record_transaction` VALUES (12, 1, 2, '2019-10-16 00:00:00', NULL, 10, NULL);
INSERT INTO `t_record_transaction` VALUES (13, 1, 2, '2019-10-16 00:00:00', NULL, 10, '2019101622001459221000022739');
INSERT INTO `t_record_transaction` VALUES (14, 1, 14, '2019-10-16 00:00:00', NULL, 101, '2019101622001459221000025926');
INSERT INTO `t_record_transaction` VALUES (15, 2, 14, '2019-10-16 00:00:00', NULL, 11, '2019101622001459221000025927');
INSERT INTO `t_record_transaction` VALUES (16, 18, 14, '2019-10-17 00:00:00', NULL, 11, NULL);
INSERT INTO `t_record_transaction` VALUES (17, 18, 14, '2019-10-17 00:00:00', NULL, 11, NULL);
INSERT INTO `t_record_transaction` VALUES (18, 10, 14, '2019-10-17 00:00:00', NULL, 10, NULL);
INSERT INTO `t_record_transaction` VALUES (19, 9, 14, '2019-10-17 00:00:00', NULL, 10, NULL);
INSERT INTO `t_record_transaction` VALUES (20, 8, 14, '2019-10-17 00:00:00', NULL, 10, NULL);
INSERT INTO `t_record_transaction` VALUES (21, 11, 14, '2019-10-17 00:00:00', NULL, 10, NULL);
INSERT INTO `t_record_transaction` VALUES (22, 11, 14, '2019-10-17 00:00:00', NULL, 10, NULL);
INSERT INTO `t_record_transaction` VALUES (23, 9, 14, '2019-10-17 00:00:00', NULL, 10, NULL);
INSERT INTO `t_record_transaction` VALUES (24, 9, 14, '2019-10-18 00:00:00', NULL, 10, NULL);
INSERT INTO `t_record_transaction` VALUES (25, 18, 14, '2019-10-18 00:00:00', NULL, 11, '2019101822001459221000028747');

-- ----------------------------
-- Table structure for t_review_task
-- ----------------------------
DROP TABLE IF EXISTS `t_review_task`;
CREATE TABLE `t_review_task`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `id_evaluated` int(16) NULL DEFAULT NULL COMMENT '被评价者id',
  `id_evaluator` int(16) NULL DEFAULT NULL COMMENT '评价者id',
  `evaluation` tinyint(1) NULL DEFAULT NULL COMMENT '好评(1)/一般(0)/差评(-1)',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评价标题',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评价内容',
  `id_record` int(16) NULL DEFAULT NULL COMMENT '所属记录id',
  `time_completion` datetime(0) NULL DEFAULT NULL COMMENT '评价完成时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `id_evaluated`(`id_evaluated`) USING BTREE,
  INDEX `id_user`(`id_evaluator`) USING BTREE,
  INDEX `id_record`(`id_record`) USING BTREE,
  CONSTRAINT `t_review_task_ibfk_1` FOREIGN KEY (`id_evaluated`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_review_task_ibfk_2` FOREIGN KEY (`id_evaluator`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_review_task_ibfk_3` FOREIGN KEY (`id_record`) REFERENCES `t_record_task` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_review_transaction
-- ----------------------------
DROP TABLE IF EXISTS `t_review_transaction`;
CREATE TABLE `t_review_transaction`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `id_evaluator` int(16) NULL DEFAULT NULL COMMENT '评价者id',
  `id_evaluated` int(16) NULL DEFAULT NULL COMMENT '被评价者id',
  `evaluation` tinyint(1) NULL DEFAULT NULL COMMENT '好评(1)/一般(0)/差评(-1)',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评价标题',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评价内容',
  `id_record` int(16) NULL DEFAULT NULL COMMENT '所属交易记录id',
  `time_completion` datetime(0) NULL DEFAULT NULL COMMENT '评价完成时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `id_evaluator`(`id_evaluator`) USING BTREE,
  INDEX `id_evaluated`(`id_evaluated`) USING BTREE,
  INDEX `id_record`(`id_record`) USING BTREE,
  CONSTRAINT `t_review_transaction_ibfk_1` FOREIGN KEY (`id_evaluator`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_review_transaction_ibfk_2` FOREIGN KEY (`id_evaluated`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_review_transaction_ibfk_3` FOREIGN KEY (`id_record`) REFERENCES `t_record_transaction` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_review_transaction
-- ----------------------------
INSERT INTO `t_review_transaction` VALUES (1, 7, 14, 0, '123', 'hhh', 1, '2019-10-15 14:37:40');
INSERT INTO `t_review_transaction` VALUES (2, 14, 10, 0, '33', '222', 1, '2019-10-16 01:00:17');

-- ----------------------------
-- Table structure for t_task
-- ----------------------------
DROP TABLE IF EXISTS `t_task`;
CREATE TABLE `t_task`  (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `id_user` int(8) NULL DEFAULT NULL COMMENT '发布者id',
  `title` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任务标题',
  `type` tinyint(1) NULL DEFAULT NULL COMMENT '任务类型:代拿快递(1)/组建队伍(2)/兼职工作(3)/文件打印(4)/其他(5)',
  `quota` int(5) NULL DEFAULT NULL COMMENT '任务剩余名额',
  `describe` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任务描述',
  `contact` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `time_create` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '任务发布时间',
  `state` tinyint(1) NULL DEFAULT NULL COMMENT '任务状态',
  `price` double(10, 2) NULL DEFAULT NULL COMMENT '任务价格',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `id_user`(`id_user`) USING BTREE,
  CONSTRAINT `t_task_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_task
-- ----------------------------
INSERT INTO `t_task` VALUES (1, 2, '食堂招兼职', 3, 5, '100/天', NULL, '2019-10-15 22:43:15', 0, 1.00);
INSERT INTO `t_task` VALUES (2, 2, '篮球缺人', 2, 5, '打篮球', NULL, '2019-10-15 22:43:16', 0, 1.00);
INSERT INTO `t_task` VALUES (3, 3, '代课', 5, 5, '20/节', NULL, '2019-10-15 22:43:18', 0, 1.00);
INSERT INTO `t_task` VALUES (4, 3, '有在食堂的吗', 5, 1, '热干面', NULL, '2019-10-15 22:45:19', 1, 1.00);
INSERT INTO `t_task` VALUES (5, 3, '带饭', 5, 1, '黄焖鸡', NULL, '2019-10-15 22:45:21', 1, 1.00);
INSERT INTO `t_task` VALUES (6, 2, '竞赛组队了', 2, 1, '冲冲冲', NULL, '2019-10-15 22:43:23', 0, 1.00);
INSERT INTO `t_task` VALUES (7, 1, '韵达的快递', 1, 1, 'gkd', NULL, '2019-10-15 22:45:24', 1, 1.00);
INSERT INTO `t_task` VALUES (8, 4, '表格打印', 4, 1, 'gkd', NULL, '2019-10-15 22:43:27', 0, 1.00);
INSERT INTO `t_task` VALUES (9, 4, '兄弟车行的', 1, 1, 'gkd', NULL, '2019-10-15 22:43:28', 0, 1.00);
INSERT INTO `t_task` VALUES (10, 4, '菜鸟驿站的', 1, 1, 'gkd', NULL, '2019-10-15 22:43:30', 0, 1.00);
INSERT INTO `t_task` VALUES (11, 2, '证书打印', 4, 2, NULL, '10010', '2019-10-15 22:43:32', 0, 1.00);
INSERT INTO `t_task` VALUES (12, 2, '文件打印', 4, 1, 'gkd', '10010', '2019-10-15 22:43:35', 0, 1.00);
INSERT INTO `t_task` VALUES (13, 2, '赚钱了赚钱了', 3, 3, '来来来 我们要发财了', '10010', '2019-10-15 22:43:37', 0, 1.00);
INSERT INTO `t_task` VALUES (14, 14, '食堂招兼职', 3, 5, '100/天', NULL, '2019-10-15 22:44:19', 0, 1.00);
INSERT INTO `t_task` VALUES (15, 14, '篮球缺人', 2, 5, '打篮球', NULL, '2019-10-15 22:44:23', 0, 1.00);
INSERT INTO `t_task` VALUES (16, 14, '代课', 5, 5, '20/节', NULL, '2019-10-15 22:44:25', 0, 1.00);
INSERT INTO `t_task` VALUES (17, 14, '有在食堂的吗', 5, 1, '热干面', NULL, '2019-10-15 22:44:26', 0, 1.00);
INSERT INTO `t_task` VALUES (18, 14, '带饭', 5, 1, '黄焖鸡', NULL, '2019-10-15 22:45:28', 1, 1.00);
INSERT INTO `t_task` VALUES (19, 14, '竞赛组队了', 2, 1, '冲冲冲', NULL, '2019-10-15 22:44:29', 0, 1.00);
INSERT INTO `t_task` VALUES (20, 14, '韵达的快递', 1, 1, 'gkd', NULL, '2019-10-15 22:44:31', 0, 1.00);
INSERT INTO `t_task` VALUES (21, 14, '表格打印', 4, 1, 'gkd', NULL, '2019-10-15 22:44:33', 0, 1.00);
INSERT INTO `t_task` VALUES (22, 14, '兄弟车行的', 1, 1, 'gkd', NULL, '2019-10-15 22:45:32', 1, 1.00);
INSERT INTO `t_task` VALUES (23, 14, '菜鸟驿站的', 1, 1, 'gkd', NULL, '2019-10-15 22:44:36', 0, 1.00);
INSERT INTO `t_task` VALUES (24, 14, '证书打印', 4, 2, NULL, '10010', '2019-10-15 22:44:38', 0, 1.00);
INSERT INTO `t_task` VALUES (25, 14, '文件打印', 4, 1, 'gkd', '10010', '2019-10-15 22:44:40', 0, 1.00);
INSERT INTO `t_task` VALUES (26, 14, '赚钱了赚钱了', 3, 3, '来来来 我们要发财了', '10010', '2019-10-15 22:44:42', 0, 1.00);
INSERT INTO `t_task` VALUES (30, 14, '123', 5, 1, '123', '123', '2019-10-15 22:44:43', 0, 2.00);
INSERT INTO `t_task` VALUES (31, 14, '123', 4, 1, '333', '3333', '2019-10-15 22:44:45', 0, 2.00);
INSERT INTO `t_task` VALUES (32, 14, '2', 3, 1, '22222', '11111', '2019-10-17 00:00:00', NULL, NULL);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '/mainassets/img/pic1.jpg' COMMENT '头像(在服务器中的文件路径)',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `authority` tinyint(1) NULL DEFAULT 1 COMMENT '权限',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '注册邮箱',
  `state` tinyint(1) NULL DEFAULT NULL COMMENT '状态',
  `validate` tinyint(4) NULL DEFAULT NULL COMMENT '验证状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, '/mainassets/img/pic1.jpg', '工具人1号', '12345678', 1, '33333333333', 1, 0);
INSERT INTO `t_user` VALUES (2, '/mainassets/img/pic1.jpg', 'wujinhui', '12345678', 1, 'scarletflandre@foxmail.com', 1, 0);
INSERT INTO `t_user` VALUES (3, '/mainassets/img/pic1.jpg', '工具人3号', '12345678', 1, 'scarletflandre@foxmail.com', 1, 0);
INSERT INTO `t_user` VALUES (4, '/mainassets/img/pic1.jpg', '工具人4号', '12345678', 1, '1213341', 1, 0);
INSERT INTO `t_user` VALUES (5, '/mainassets/img/pic1.jpg', '工具人5号', '12345678', 1, '1231', 1, 0);
INSERT INTO `t_user` VALUES (6, '/mainassets/img/pic1.jpg', 'lzj', '12345678', 1, '123122', 1, 0);
INSERT INTO `t_user` VALUES (7, '/mainassets/img/pic1.jpg', '工具人7号', '12345678', 1, 'scarletflandre@foxmail.com', 1, 0);
INSERT INTO `t_user` VALUES (8, '/mainassets/img/pic1.jpg', '工具人8号', '12345678', 1, 'scarletflandre@foxmail.com', 1, 0);
INSERT INTO `t_user` VALUES (9, '/mainassets/img/pic1.jpg', '工具人9号', '12345678', 1, 'scarletflandre@foxmail.com', 1, 0);
INSERT INTO `t_user` VALUES (10, '/mainassets/img/pic1.jpg', '工具人10号', '12345678', 1, 'scarletflandre@foxmail.com', 1, 0);
INSERT INTO `t_user` VALUES (11, '/mainassets/img/pic1.jpg', '工具人11号', '12345678', 1, 'scarletflandre@foxmail.com', 1, 0);
INSERT INTO `t_user` VALUES (14, '/mainassets/img/pic2.jpg', 'daishuaibi', 'f5bb0c8de146c67b44babbf4e6584cc0', 1, '22@333', 1, 1);
INSERT INTO `t_user` VALUES (15, '/mainassets/img/pic1.jpg', 'admin', '123', 2, '33@22', 1, 0);
INSERT INTO `t_user` VALUES (16, '/mainassets/img/pic1.jpg', 'daishuaibi2', 'f5bb0c8de146c67b44babbf4e6584cc0', 1, '22@33', 1, 0);
INSERT INTO `t_user` VALUES (17, '/mainassets/img/pic1.jpg', '123123123', 'f5bb0c8de146c67b44babbf4e6584cc0', 1, '810687076@qq.com', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
