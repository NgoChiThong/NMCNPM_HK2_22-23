/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 100422 (10.4.22-MariaDB)
 Source Host           : localhost:3306
 Source Schema         : money

 Target Server Type    : MySQL
 Target Server Version : 100422 (10.4.22-MariaDB)
 File Encoding         : 65001

 Date: 08/05/2023 12:52:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for categories
-- ----------------------------
DROP TABLE IF EXISTS `categories`;
CREATE TABLE `categories`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of categories
-- ----------------------------
INSERT INTO `categories` VALUES (1, NULL, NULL, 'Food & Beverage', 'https://static.moneylover.me/img/icon/ic_category_foodndrink.png', 'chi');
INSERT INTO `categories` VALUES (2, NULL, NULL, 'hihi', 'https://static.moneylover.me/img/icon/ic_category_foodndrink.png', 'chi');
INSERT INTO `categories` VALUES (3, NULL, NULL, 'abc', 'https://static.moneylover.me/img/icon/ic_category_foodndrink.png', 'thu');
INSERT INTO `categories` VALUES (4, NULL, NULL, 'asdasd', 'https://static.moneylover.me/img/icon/ic_category_foodndrink.png', 'thu');
INSERT INTO `categories` VALUES (5, NULL, NULL, 'asdasd', 'https://static.moneylover.me/img/icon/ic_category_foodndrink.png', 'vay');
INSERT INTO `categories` VALUES (6, NULL, NULL, 'ad2f', 'https://static.moneylover.me/img/icon/ic_category_foodndrink.png', 'vay');

-- ----------------------------
-- Table structure for transactions
-- ----------------------------
DROP TABLE IF EXISTS `transactions`;
CREATE TABLE `transactions`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `money` int NULL DEFAULT NULL,
  `categoryId` int NULL DEFAULT NULL,
  `note` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `started_at` timestamp NULL DEFAULT NULL,
  `userId` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `categoryId`(`categoryId` ASC) USING BTREE,
  INDEX `userId`(`userId` ASC) USING BTREE,
  CONSTRAINT `transactions_ibfk_1` FOREIGN KEY (`categoryId`) REFERENCES `categories` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `transactions_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of transactions
-- ----------------------------
INSERT INTO `transactions` VALUES (2, '2023-04-11 21:55:36', '2023-04-13 21:55:42', 123123, 1, 'FADSFSAD', '2023-04-11 21:55:24', 1);
INSERT INTO `transactions` VALUES (3, '2023-04-28 01:00:30', '2023-04-28 01:00:30', 123, 1, '123', '2023-03-31 07:00:00', 1);
INSERT INTO `transactions` VALUES (4, '2023-04-28 01:06:26', '2023-04-28 01:06:26', 213, 2, '576', '2023-03-30 07:00:00', 1);
INSERT INTO `transactions` VALUES (5, '2023-04-28 01:17:51', '2023-04-28 01:17:51', 123, 1, '12441231', '2023-04-23 07:00:00', 1);
INSERT INTO `transactions` VALUES (6, '2023-04-28 01:20:46', '2023-04-28 01:20:46', 12567, 1, 'dcvdfs', '2023-04-22 07:00:00', 1);
INSERT INTO `transactions` VALUES (7, '2023-04-28 01:25:40', '2023-04-28 01:25:40', 5000000, 2, 'chi cho em be', '2023-04-29 07:00:00', 1);
INSERT INTO `transactions` VALUES (8, '2023-04-28 01:28:47', '2023-04-28 01:28:47', 12312123, 2, 'hfghdsfgh', '2023-04-30 07:00:00', 1);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `pass` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `money` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, NULL, NULL, '123123', '1123', '12312', 'FDSF', NULL);

SET FOREIGN_KEY_CHECKS = 1;
