/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50544
Source Host           : localhost:3306
Source Database       : db_car1

Target Server Type    : MYSQL
Target Server Version : 50544
File Encoding         : 65001

Date: 2018-05-09 13:46:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_car`
-- ----------------------------
DROP TABLE IF EXISTS `t_car`;
CREATE TABLE `t_car` (
  `C_ID` int(30) NOT NULL,
  `C_VIN` int(30) NOT NULL,
  `C_Type` varchar(30) DEFAULT NULL,
  `C_Time` datetime NOT NULL,
  PRIMARY KEY (`C_VIN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_car
-- ----------------------------
INSERT INTO `t_car` VALUES ('1', '1', '奔驰', '2018-01-24 23:30:19');
INSERT INTO `t_car` VALUES ('2', '2', '奔驰', '2018-01-24 23:31:45');
INSERT INTO `t_car` VALUES ('3', '3', '奔驰', '2018-01-24 23:31:58');
INSERT INTO `t_car` VALUES ('4', '4', '宝马', '2018-01-24 23:32:19');
INSERT INTO `t_car` VALUES ('5', '5', '奔驰', '2018-01-24 23:34:07');
INSERT INTO `t_car` VALUES ('6', '6', '奔驰', '2018-01-24 23:34:23');
INSERT INTO `t_car` VALUES ('7', '7', '宝马', '2018-01-24 23:35:24');
INSERT INTO `t_car` VALUES ('8', '8', '奥迪', '2018-01-24 23:35:37');
INSERT INTO `t_car` VALUES ('9', '9', '奥迪', '2018-01-24 23:35:47');
INSERT INTO `t_car` VALUES ('10', '10', '奥迪', '2018-01-24 23:36:05');
INSERT INTO `t_car` VALUES ('11', '11', '奔驰', '2018-01-24 23:36:15');
INSERT INTO `t_car` VALUES ('12', '12', '奥迪', '2018-01-24 23:36:27');
INSERT INTO `t_car` VALUES ('13', '13', '奥迪', '2018-01-24 23:36:37');
INSERT INTO `t_car` VALUES ('14', '14', '法拉利', '2018-01-24 23:37:08');
INSERT INTO `t_car` VALUES ('15', '15', '法拉利', '2018-01-24 23:37:13');
INSERT INTO `t_car` VALUES ('16', '16', '宝马', '2018-01-25 22:53:25');
INSERT INTO `t_car` VALUES ('17', '17', '奔驰', '2018-01-27 14:59:41');
INSERT INTO `t_car` VALUES ('18', '18', '奔驰', '2018-01-27 15:00:39');
INSERT INTO `t_car` VALUES ('19', '19', '法拉利', '2018-01-27 15:02:24');
INSERT INTO `t_car` VALUES ('20', '20', '客运车', '2018-01-31 18:17:53');
INSERT INTO `t_car` VALUES ('21', '21', '客运车', '2018-01-31 18:18:16');
INSERT INTO `t_car` VALUES ('22', '22', '客运车', '2018-01-31 18:18:30');
INSERT INTO `t_car` VALUES ('23', '23', '客运车', '2018-01-31 18:18:44');
INSERT INTO `t_car` VALUES ('24', '24', '客运车', '2018-01-31 18:18:55');
INSERT INTO `t_car` VALUES ('25', '25', '法拉利', '2018-01-31 18:19:09');
INSERT INTO `t_car` VALUES ('26', '26', '宝马', '2018-01-31 18:19:40');
INSERT INTO `t_car` VALUES ('27', '27', '客运车', '2018-05-06 10:16:55');
INSERT INTO `t_car` VALUES ('28', '28', '运输车', '2018-05-06 10:17:13');
INSERT INTO `t_car` VALUES ('29', '29', '运输车', '2018-05-06 10:17:28');
INSERT INTO `t_car` VALUES ('30', '30', '网约车', '2018-05-06 10:17:43');
INSERT INTO `t_car` VALUES ('31', '31', '网约车', '2018-05-06 10:18:09');
INSERT INTO `t_car` VALUES ('32', '32', '网约车', '2018-05-06 10:18:22');
INSERT INTO `t_car` VALUES ('33', '33', '法拉利', '2018-05-06 10:18:45');
INSERT INTO `t_car` VALUES ('34', '34', '法拉利', '2018-05-06 10:19:03');
INSERT INTO `t_car` VALUES ('35', '35', '法拉利', '2018-05-06 10:19:18');
INSERT INTO `t_car` VALUES ('36', '36', '法拉利', '2018-05-06 10:19:34');
INSERT INTO `t_car` VALUES ('37', '37', '法拉利', '2018-05-06 20:40:44');
INSERT INTO `t_car` VALUES ('38', '38', '私家车', '2018-05-06 20:58:24');
INSERT INTO `t_car` VALUES ('39', '39', '运输车', '2018-05-08 12:58:40');

-- ----------------------------
-- Table structure for `t_c_status`
-- ----------------------------
DROP TABLE IF EXISTS `t_c_status`;
CREATE TABLE `t_c_status` (
  `ID_Number` int(11) NOT NULL AUTO_INCREMENT,
  `C_ID` int(30) NOT NULL,
  `C_VIN` int(30) NOT NULL,
  `C_Status` int(30) NOT NULL DEFAULT '0',
  `Charge_Status` int(30) NOT NULL DEFAULT '0',
  `C_Speed` int(30) NOT NULL DEFAULT '20',
  `C_Voltage` int(30) NOT NULL DEFAULT '0',
  `C_Electricity` int(30) NOT NULL DEFAULT '0',
  `M_Status` int(30) NOT NULL DEFAULT '0',
  `B_Status` int(30) NOT NULL DEFAULT '0',
  `Cs_Speed` int(30) NOT NULL DEFAULT '0',
  `GPS_Status` int(30) NOT NULL DEFAULT '0',
  `C_longitude` decimal(30,6) NOT NULL DEFAULT '0.000000',
  `C_latitude` decimal(30,6) NOT NULL DEFAULT '0.000000',
  `C_Time` datetime NOT NULL DEFAULT '0000-01-01 00:00:00',
  PRIMARY KEY (`ID_Number`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_c_status
-- ----------------------------
INSERT INTO `t_c_status` VALUES ('1', '1', '1', '0', '1', '20', '1', '1', '1', '1', '1000', '1', '0.000000', '0.000000', '2018-01-29 14:54:01');
INSERT INTO `t_c_status` VALUES ('2', '1', '1', '0', '1', '20', '1', '1', '1', '1', '2000', '1', '0.000000', '0.000000', '2018-01-29 14:57:40');
INSERT INTO `t_c_status` VALUES ('3', '2', '2', '1', '0', '20', '2', '2', '2', '2', '2000', '1', '116.397947', '39.900633', '2018-01-29 15:00:14');
INSERT INTO `t_c_status` VALUES ('4', '3', '3', '1', '0', '20', '3', '3', '3', '3', '2000', '1', '121.469642', '31.228984', '2018-01-29 15:01:35');
INSERT INTO `t_c_status` VALUES ('5', '4', '4', '1', '1', '20', '0', '0', '0', '0', '2000', '1', '0.000000', '0.000000', '2018-01-29 16:41:06');
INSERT INTO `t_c_status` VALUES ('6', '4', '4', '2', '0', '20', '0', '0', '0', '0', '2000', '1', '0.000000', '0.000000', '2018-01-29 15:07:11');
INSERT INTO `t_c_status` VALUES ('7', '5', '5', '2', '0', '20', '0', '0', '0', '0', '1000', '0', '0.000000', '0.000000', '2018-01-29 15:07:13');
INSERT INTO `t_c_status` VALUES ('8', '6', '6', '2', '0', '20', '0', '0', '0', '0', '1000', '0', '0.000000', '0.000000', '2018-01-29 15:07:16');
INSERT INTO `t_c_status` VALUES ('9', '7', '7', '2', '0', '20', '0', '0', '0', '0', '1000', '0', '0.000000', '0.000000', '2018-01-29 15:07:19');
INSERT INTO `t_c_status` VALUES ('10', '8', '8', '1', '0', '20', '0', '0', '0', '0', '1000', '0', '0.000000', '0.000000', '2018-01-29 15:07:21');
INSERT INTO `t_c_status` VALUES ('11', '9', '9', '1', '0', '20', '0', '0', '0', '0', '0', '0', '0.000000', '0.000000', '2018-01-29 15:07:24');
INSERT INTO `t_c_status` VALUES ('12', '10', '10', '1', '0', '20', '0', '0', '0', '0', '0', '0', '0.000000', '0.000000', '2018-01-29 15:07:27');
INSERT INTO `t_c_status` VALUES ('13', '11', '11', '3', '0', '20', '0', '0', '0', '0', '0', '0', '0.000000', '0.000000', '2018-01-29 15:07:29');
INSERT INTO `t_c_status` VALUES ('14', '12', '12', '3', '0', '20', '0', '0', '0', '0', '0', '0', '0.000000', '0.000000', '2018-01-29 15:07:31');
INSERT INTO `t_c_status` VALUES ('15', '13', '13', '3', '0', '20', '0', '0', '0', '0', '0', '0', '0.000000', '0.000000', '2018-01-29 15:07:35');
INSERT INTO `t_c_status` VALUES ('16', '14', '14', '3', '0', '20', '0', '0', '0', '0', '0', '0', '0.000000', '0.000000', '2018-01-29 15:07:37');
INSERT INTO `t_c_status` VALUES ('17', '15', '15', '0', '0', '20', '0', '0', '0', '0', '0', '0', '0.000000', '0.000000', '2018-01-29 15:07:41');
INSERT INTO `t_c_status` VALUES ('18', '16', '16', '0', '0', '20', '0', '0', '0', '0', '0', '0', '0.000000', '0.000000', '2018-01-29 15:07:43');
INSERT INTO `t_c_status` VALUES ('19', '17', '17', '3', '0', '20', '0', '0', '0', '0', '0', '0', '0.000000', '0.000000', '2018-01-29 15:07:50');
INSERT INTO `t_c_status` VALUES ('20', '15', '15', '0', '0', '20', '0', '0', '0', '0', '0', '0', '0.000000', '0.000000', '2018-01-30 12:28:50');
INSERT INTO `t_c_status` VALUES ('21', '17', '17', '1', '0', '20', '0', '0', '0', '0', '0', '0', '0.000000', '0.000000', '2018-01-30 12:26:02');
INSERT INTO `t_c_status` VALUES ('22', '17', '17', '0', '0', '20', '0', '0', '0', '0', '0', '0', '0.000000', '0.000000', '2018-01-29 15:07:46');
INSERT INTO `t_c_status` VALUES ('23', '16', '16', '0', '0', '20', '0', '0', '0', '0', '0', '0', '0.000000', '0.000000', '2018-01-30 12:26:40');
INSERT INTO `t_c_status` VALUES ('24', '14', '14', '1', '0', '20', '0', '0', '0', '0', '0', '0', '0.000000', '0.000000', '2018-01-30 12:29:18');
INSERT INTO `t_c_status` VALUES ('25', '20', '20', '0', '0', '20', '0', '0', '0', '0', '0', '0', '0.000000', '0.000000', '2018-01-31 00:36:49');
INSERT INTO `t_c_status` VALUES ('26', '20', '20', '0', '0', '20', '0', '0', '0', '0', '0', '0', '0.000000', '0.000000', '2018-01-31 18:27:58');
INSERT INTO `t_c_status` VALUES ('27', '21', '21', '0', '0', '20', '0', '0', '0', '0', '0', '0', '0.000000', '0.000000', '2018-01-31 18:28:02');
INSERT INTO `t_c_status` VALUES ('28', '22', '22', '0', '0', '20', '0', '0', '0', '0', '0', '0', '0.000000', '0.000000', '2018-01-31 18:28:04');
INSERT INTO `t_c_status` VALUES ('29', '23', '23', '0', '0', '20', '0', '0', '0', '0', '0', '0', '0.000000', '0.000000', '2018-01-31 18:28:07');
INSERT INTO `t_c_status` VALUES ('30', '24', '24', '0', '0', '20', '0', '0', '0', '0', '0', '0', '0.000000', '0.000000', '2018-01-31 18:28:09');
INSERT INTO `t_c_status` VALUES ('31', '25', '25', '0', '0', '20', '0', '0', '0', '0', '0', '0', '0.000000', '0.000000', '2018-01-31 18:28:12');
INSERT INTO `t_c_status` VALUES ('32', '26', '26', '0', '0', '20', '0', '0', '0', '0', '0', '0', '0.000000', '0.000000', '2018-01-31 18:28:14');
INSERT INTO `t_c_status` VALUES ('34', '1', '1', '0', '0', '20', '0', '0', '0', '0', '0', '0', '117.114150', '39.065520', '2018-02-05 21:01:01');
INSERT INTO `t_c_status` VALUES ('35', '1', '1', '0', '0', '20', '0', '0', '0', '0', '0', '0', '117.114565', '39.075372', '2018-02-05 21:08:29');
INSERT INTO `t_c_status` VALUES ('36', '1', '1', '0', '0', '20', '0', '0', '0', '0', '0', '0', '117.114709', '39.075856', '2018-02-05 21:08:32');
INSERT INTO `t_c_status` VALUES ('37', '1', '1', '0', '0', '20', '0', '0', '0', '0', '0', '0', '117.118634', '39.075834', '2018-02-03 21:08:35');
INSERT INTO `t_c_status` VALUES ('38', '1', '1', '0', '0', '20', '0', '0', '0', '0', '0', '0', '117.121662', '39.076073', '2018-02-03 21:08:38');
INSERT INTO `t_c_status` VALUES ('39', '1', '1', '0', '0', '20', '0', '0', '0', '0', '0', '0', '117.118302', '39.078887', '2018-02-03 21:08:41');
INSERT INTO `t_c_status` VALUES ('40', '1', '1', '0', '0', '20', '0', '0', '0', '0', '0', '0', '121.469642', '31.228984', '2018-02-04 21:08:44');
INSERT INTO `t_c_status` VALUES ('41', '1', '1', '0', '0', '20', '0', '0', '0', '0', '0', '0', '116.406265', '39.905015', '2018-02-04 21:08:46');
INSERT INTO `t_c_status` VALUES ('42', '1', '1', '0', '0', '20', '0', '0', '0', '0', '0', '0', '116.406441', '39.905018', '2018-02-04 21:08:48');
INSERT INTO `t_c_status` VALUES ('43', '1', '1', '0', '0', '20', '0', '0', '0', '0', '0', '0', '116.406670', '39.904457', '2018-02-04 21:08:51');
INSERT INTO `t_c_status` VALUES ('44', '1', '1', '0', '0', '20', '0', '0', '0', '0', '0', '0', '118.120100', '27.324540', '2018-02-04 22:06:52');
INSERT INTO `t_c_status` VALUES ('45', '27', '27', '0', '0', '20', '0', '0', '0', '0', '0', '0', '0.000000', '0.000000', '2018-05-06 10:16:55');
INSERT INTO `t_c_status` VALUES ('46', '28', '28', '0', '0', '20', '0', '0', '0', '0', '0', '0', '0.000000', '0.000000', '2018-05-06 10:17:13');
INSERT INTO `t_c_status` VALUES ('47', '29', '29', '0', '0', '20', '0', '0', '0', '0', '0', '0', '0.000000', '0.000000', '2018-05-06 10:17:28');
INSERT INTO `t_c_status` VALUES ('48', '30', '30', '0', '0', '20', '0', '0', '0', '0', '0', '0', '0.000000', '0.000000', '2018-05-06 10:17:43');
INSERT INTO `t_c_status` VALUES ('49', '31', '31', '0', '0', '20', '0', '0', '0', '0', '0', '0', '0.000000', '0.000000', '2018-05-06 10:18:09');
INSERT INTO `t_c_status` VALUES ('50', '32', '32', '0', '0', '20', '0', '0', '0', '0', '0', '0', '0.000000', '0.000000', '2018-05-06 10:18:22');
INSERT INTO `t_c_status` VALUES ('51', '33', '33', '0', '0', '20', '0', '0', '0', '0', '0', '0', '0.000000', '0.000000', '2018-05-06 10:18:45');
INSERT INTO `t_c_status` VALUES ('52', '34', '34', '0', '0', '20', '0', '0', '0', '0', '0', '0', '0.000000', '0.000000', '2018-05-06 10:19:03');
INSERT INTO `t_c_status` VALUES ('53', '35', '35', '0', '0', '20', '0', '0', '0', '0', '0', '0', '0.000000', '0.000000', '2018-05-06 10:19:18');
INSERT INTO `t_c_status` VALUES ('54', '36', '36', '0', '0', '20', '0', '0', '0', '0', '0', '0', '0.000000', '0.000000', '2018-05-06 10:19:34');
INSERT INTO `t_c_status` VALUES ('55', '37', '37', '0', '0', '20', '0', '0', '0', '0', '0', '0', '0.000000', '0.000000', '2018-05-06 20:40:44');
INSERT INTO `t_c_status` VALUES ('56', '38', '38', '0', '0', '20', '0', '0', '0', '0', '0', '0', '0.000000', '0.000000', '2018-05-06 20:58:24');
INSERT INTO `t_c_status` VALUES ('57', '39', '39', '1', '0', '20', '0', '0', '0', '0', '0', '0', '0.000000', '0.000000', '2018-05-08 12:58:40');

-- ----------------------------
-- Table structure for `t_fbattery`
-- ----------------------------
DROP TABLE IF EXISTS `t_fbattery`;
CREATE TABLE `t_fbattery` (
  `C_VIN` varchar(30) DEFAULT NULL,
  `FB_Voltage` float(10,3) DEFAULT '0.000',
  `FB_Electricity` float(10,3) DEFAULT '0.000',
  `FB_ConRate` float(10,3) DEFAULT '0.000',
  `C_Time` datetime NOT NULL DEFAULT '0000-01-01 00:00:00',
  PRIMARY KEY (`C_Time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_fbattery
-- ----------------------------
INSERT INTO `t_fbattery` VALUES ('1', '3.500', '3.000', '80.000', '2018-02-09 14:43:57');
INSERT INTO `t_fbattery` VALUES ('1', '3.400', '3.000', '80.000', '2018-02-09 14:45:01');
INSERT INTO `t_fbattery` VALUES ('1', '3.300', '2.900', '75.000', '2018-02-09 14:45:21');
INSERT INTO `t_fbattery` VALUES ('1', '3.200', '3.000', '70.000', '2018-02-09 14:45:39');
INSERT INTO `t_fbattery` VALUES ('1', '3.100', '3.000', '70.000', '2018-02-09 14:45:53');

-- ----------------------------
-- Table structure for `t_machine`
-- ----------------------------
DROP TABLE IF EXISTS `t_machine`;
CREATE TABLE `t_machine` (
  `C_VIN` varchar(30) DEFAULT NULL,
  `M_ID` varchar(30) DEFAULT NULL,
  `M_Number` int(30) DEFAULT '2',
  `M_Speed` int(10) DEFAULT '0',
  `M_Temperature` int(10) DEFAULT '0',
  `M_CTemperature` float(10,1) DEFAULT '0.0',
  `M_CVoltage` float(10,1) DEFAULT '0.0',
  `M_CElectricity` float(10,1) DEFAULT '0.0',
  `C_Time` datetime NOT NULL DEFAULT '0000-01-01 00:00:00',
  PRIMARY KEY (`C_Time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_machine
-- ----------------------------
INSERT INTO `t_machine` VALUES ('1', '1', '2', '100', '30', '30.0', '3.5', '3.5', '2018-02-09 11:54:25');
INSERT INTO `t_machine` VALUES ('1', '1', '2', '90', '28', '28.0', '3.3', '3.3', '2018-02-09 12:47:09');
INSERT INTO `t_machine` VALUES ('1', '1', '2', '80', '26', '26.0', '3.1', '3.1', '2018-02-09 12:48:09');
INSERT INTO `t_machine` VALUES ('1', '1', '2', '70', '25', '25.0', '3.0', '3.0', '2018-02-09 12:49:06');
INSERT INTO `t_machine` VALUES ('1', '1', '2', '60', '35', '30.0', '3.5', '3.5', '2018-02-09 12:49:52');
INSERT INTO `t_machine` VALUES ('1', '1', '2', '60', '35', '30.0', '3.5', '3.5', '2018-02-09 12:50:03');

-- ----------------------------
-- Table structure for `t_operator`
-- ----------------------------
DROP TABLE IF EXISTS `t_operator`;
CREATE TABLE `t_operator` (
  `O_ID` varchar(20) NOT NULL,
  `O_Password` varchar(30) NOT NULL,
  `O_Name` varchar(20) NOT NULL,
  `O_IDCard` varchar(30) NOT NULL,
  `O_Department` varchar(30) DEFAULT NULL,
  `O_Duty` varchar(20) DEFAULT NULL,
  `O_Address` varchar(40) DEFAULT NULL,
  `O_Tel` varchar(20) DEFAULT NULL,
  `O_Memo` varchar(200) DEFAULT NULL,
  `O_Time` datetime NOT NULL,
  PRIMARY KEY (`O_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_operator
-- ----------------------------
INSERT INTO `t_operator` VALUES ('aa', '$$$$$$', '1', '1', null, '1', '1', '121212121', '21212121', '2018-01-08 17:37:00');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `C_ID` int(30) NOT NULL,
  `U_ID` int(30) NOT NULL AUTO_INCREMENT,
  `U_Name` varchar(50) NOT NULL,
  `U_Tel` varchar(50) NOT NULL,
  `U_Address` varchar(50) DEFAULT NULL,
  `U_Email` varchar(50) DEFAULT NULL,
  `U_Time` datetime NOT NULL,
  PRIMARY KEY (`U_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '1', '1', '1', '12', '12', '2018-04-08 19:37:48');
INSERT INTO `t_user` VALUES ('2', '2', '1', '1', '12', '12', '2018-04-08 19:37:21');
INSERT INTO `t_user` VALUES ('3', '3', '3', '3', '3', '3', '2018-01-24 23:31:58');
INSERT INTO `t_user` VALUES ('4', '4', '4', '4', '4', '4', '2018-01-24 23:32:19');
INSERT INTO `t_user` VALUES ('5', '5', '5', '5', '5', '5', '2018-01-25 11:56:22');
INSERT INTO `t_user` VALUES ('6', '6', '6', '6', '6', '6', '2018-01-25 11:56:29');
INSERT INTO `t_user` VALUES ('7', '7', '7', '7', '7', '7', '2018-01-25 11:56:37');
INSERT INTO `t_user` VALUES ('8', '8', '8', '8', '8', '8', '2018-01-25 11:56:48');
INSERT INTO `t_user` VALUES ('9', '9', '9', '9', '9', '9', '2018-01-25 12:08:50');
INSERT INTO `t_user` VALUES ('10', '10', '10', '10', '10', '10', '2018-01-27 14:58:37');
INSERT INTO `t_user` VALUES ('11', '11', '1', '1', '12', '12', '2018-04-08 19:37:32');
INSERT INTO `t_user` VALUES ('12', '12', '12', '12', '12', '12', '2018-01-27 14:58:54');
INSERT INTO `t_user` VALUES ('13', '13', '12', '12', '13', '13', '2018-01-27 14:59:01');
INSERT INTO `t_user` VALUES ('14', '14', '14', '14', '14', '14', '2018-01-27 14:59:09');
INSERT INTO `t_user` VALUES ('15', '15', '14', '14', '15', '15', '2018-01-27 14:59:18');
INSERT INTO `t_user` VALUES ('16', '31', '16', '16', '16', '16', '2018-01-25 22:53:25');
INSERT INTO `t_user` VALUES ('17', '32', '17', '17', '17', '17', '2018-01-27 14:59:41');
INSERT INTO `t_user` VALUES ('18', '33', '18', '18', '18', '18', '2018-01-27 15:00:39');
INSERT INTO `t_user` VALUES ('19', '34', '19', '19', '19', '19', '2018-01-27 15:02:24');
INSERT INTO `t_user` VALUES ('20', '35', '20', '20', '20', '20', '2018-01-31 18:17:53');
INSERT INTO `t_user` VALUES ('21', '36', '21', '21', '21', '21', '2018-01-31 18:18:16');
INSERT INTO `t_user` VALUES ('22', '37', '22', '22', '22', '22', '2018-01-31 18:18:30');
INSERT INTO `t_user` VALUES ('23', '38', '23', '23', '23', '23', '2018-01-31 18:18:44');
INSERT INTO `t_user` VALUES ('24', '39', '24', '24', '24', '24', '2018-01-31 18:18:55');
INSERT INTO `t_user` VALUES ('25', '40', '25', '25', '25', '25', '2018-01-31 18:19:09');
INSERT INTO `t_user` VALUES ('26', '41', '26', '26', '26', '826620348@qq.com', '2018-01-31 18:19:40');
INSERT INTO `t_user` VALUES ('27', '42', '27', '27', '27', '27', '2018-05-06 10:16:55');
INSERT INTO `t_user` VALUES ('28', '43', '28', '28', '28', '28', '2018-05-06 10:17:13');
INSERT INTO `t_user` VALUES ('29', '44', '29', '29', '29', '29', '2018-05-06 10:17:28');
INSERT INTO `t_user` VALUES ('30', '45', '30', '30', '30', '30', '2018-05-06 10:17:43');
INSERT INTO `t_user` VALUES ('31', '46', '31', '31', '31', '31', '2018-05-06 10:18:09');
INSERT INTO `t_user` VALUES ('32', '47', '32', '32', '32', '32', '2018-05-06 10:18:22');
INSERT INTO `t_user` VALUES ('33', '48', '33', '33', '33', '33', '2018-05-06 10:18:45');
INSERT INTO `t_user` VALUES ('34', '49', '34', '34', '34', '34', '2018-05-06 10:19:03');
INSERT INTO `t_user` VALUES ('35', '50', '35', '35', '35', '35', '2018-05-06 10:19:18');
INSERT INTO `t_user` VALUES ('36', '51', '36', '36', '36', '36', '2018-05-06 10:19:34');
INSERT INTO `t_user` VALUES ('37', '52', '37', '37', '37', '37', '2018-05-06 20:40:44');
INSERT INTO `t_user` VALUES ('38', '53', '38', '38', '38', '38', '2018-05-06 20:58:24');
INSERT INTO `t_user` VALUES ('39', '54', '39', '39', '39', '39', '2018-05-08 12:58:40');
