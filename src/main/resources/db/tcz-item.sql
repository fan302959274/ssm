USE tcz;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tcz_ad
-- ----------------------------
DROP TABLE IF EXISTS `tcz_ad`;
CREATE TABLE `tcz_ad` (
  `id` bigint(20) NOT NULL,
  `type` char(1) DEFAULT '' COMMENT '类型(0:文本,1:图片)',
  `title` varchar(255) NOT NULL DEFAULT '' COMMENT '标题',
  `path` varchar(255) NOT NULL DEFAULT '' COMMENT '路径',
  `url` varchar(255) NOT NULL DEFAULT '' COMMENT '连接地址',
  `ad_position_id` bigint(20) NOT NULL COMMENT '广告位',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `modify_date` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='广告';

-- ----------------------------
-- Records of tcz_ad
-- ----------------------------
INSERT INTO `tcz_ad` VALUES ('2', '1', '奥迪等你来', 'http://img.1yyg.com/Poster/20160624135422109.jpg', 'http://www.1yyg.com/products/22817.html', '2', '2016-08-09 19:23:50', '2016-08-09 19:23:51');
INSERT INTO `tcz_ad` VALUES ('1', '1', 'logo', 'http://skin.1yyg.com/images/logo-2014.png', 'http://skin.1yyg.com/images/logo-2014.png', '1', '2016-08-15 19:49:42', '2016-08-15 19:49:44');

-- ----------------------------
-- Table structure for tcz_ad_position
-- ----------------------------
DROP TABLE IF EXISTS `tcz_ad_position`;
CREATE TABLE `tcz_ad_position` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '名称',
  `width` varchar(255) NOT NULL DEFAULT '' COMMENT '宽',
  `height` varchar(255) NOT NULL DEFAULT '' COMMENT '高',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `modify_date` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='广告位';

-- ----------------------------
-- Records of tcz_ad_position
-- ----------------------------
INSERT INTO `tcz_ad_position` VALUES ('2', '首页轮播', '709', '300', '2016-08-09 19:24:25', '2016-08-09 19:24:27');
INSERT INTO `tcz_ad_position` VALUES ('1', 'logo', '122', '74', '2016-08-15 19:49:06', '2016-08-15 19:49:08');

-- ----------------------------
-- Table structure for tcz_address
-- ----------------------------
DROP TABLE IF EXISTS `tcz_address`;
CREATE TABLE `tcz_address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `mobile_phone` varchar(255) DEFAULT NULL COMMENT '手机',
  `fixed_phone` varchar(255) DEFAULT NULL COMMENT '固定电话',
  `district_id` bigint(20) DEFAULT '0' COMMENT '区域id',
  `detail_address` varchar(500) DEFAULT NULL COMMENT '详细地址',
  `is_deleted` int(1) DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=82 COMMENT='地址';

-- ----------------------------
-- Records of tcz_address
-- ----------------------------
INSERT INTO `tcz_address` VALUES ('1', '13651638713', '0556-4653825', '0', '上海市松江区九亭镇亭苑小区8号602', '0');
INSERT INTO `tcz_address` VALUES ('2', '18726928963', '0551-2020009', '0', '上海市徐汇区幸福花苑9栋702', '0');
INSERT INTO `tcz_address` VALUES ('3', '13865194966', '0556-4653825', '0', '上海市闸北区共富新村11栋201', '0');
INSERT INTO `tcz_address` VALUES ('4', '13865194515', '0556-4653825', '0', '上海市浦东新区数字产业园A座902', '0');

-- ----------------------------
-- Table structure for tcz_item
-- ----------------------------
DROP TABLE IF EXISTS `tcz_item`;
CREATE TABLE `tcz_item` (
  `id` bigint(20) NOT NULL DEFAULT '0',
  `goods_id` varchar(20) NOT NULL DEFAULT '' COMMENT '货号ID',
  `brand_id` bigint(20) NOT NULL COMMENT '商品品牌',
  `category_id` bigint(20) NOT NULL COMMENT '商品分类',
  `sn` varchar(36) NOT NULL DEFAULT '' COMMENT '商品编号',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '商品名称',
  `title` varchar(255) NOT NULL DEFAULT '' COMMENT '商品标题',
  `image` varchar(255) NOT NULL DEFAULT '' COMMENT '展现图片',
  `cost` decimal(20,4) NOT NULL DEFAULT '0.0000' COMMENT '商品成本',
  `sales` int(10) NOT NULL DEFAULT '0' COMMENT '已销售金额',
  `price` int(10) NOT NULL DEFAULT '0' COMMENT '商品价格',
  `periods` int(11) NOT NULL DEFAULT '1' COMMENT '当前期数',
  `max_periods` int(11) NOT NULL DEFAULT '1' COMMENT '最大期数',
  `status` varchar(1) NOT NULL DEFAULT '' COMMENT '1:进行中 2:揭晓中 3:已揭晓',
  `is_marketable` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否上架(0:否,1:是)',
  `introduction` longtext NOT NULL COMMENT '商品介绍',
  `create_date` datetime NOT NULL COMMENT '创建日期',
  `modify_date` datetime NOT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`),
  KEY `FK_tcz_item_tcz_brand_id` (`brand_id`),
  KEY `FK_tcz_item_tcz_item_categroy_id` (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=2730 COMMENT='商品';

-- ----------------------------
-- Records of tcz_item
-- ----------------------------
INSERT INTO `tcz_item` VALUES ('1', '201608SP0001', '1', '2', '201608SP00001', 'APPLE iPhone SE 16GB 移动联通电信4G手机 玫瑰金', '', 'http://img01.fn-mart.com/C/item/2016/0323/201603C230000169/_345899256_140x140.jpg', '2500.0000', '2899', '2899', '1', '50', '', '1', '', '2016-08-04 11:29:49', '2016-08-04 11:29:49');
INSERT INTO `tcz_item` VALUES ('2', '201608SP0002', '1', '2', '201608SP00002', '【上海移动购机赠话费】APPLE 苹果 iPhone 6S 16G版 移动联通电信4G手机 深空灰色 深空灰', '', 'http://img01.fn-mart.com/C/item/2016/0531/201605C310000026/201605C310000038_642333177_230x230.jpg', '4300.0000', '0', '4598', '1', '50', '', '1', '', '2016-08-04 11:30:09', '2016-08-04 11:30:09');
INSERT INTO `tcz_item` VALUES ('3', '201608SP0003', '1', '2', '201608SP00003', '苹果（Apple）iPod touch 6 16GB MP4播放器带触摸屏 双核A8处理器 金色', '', 'http://img18.fn-mart.com/pic/5813133b57b949ca4387/kn62zz1zDTflhdZdZz/5iSymGOykiVYux/CsmRrVdbE4SAPevVAACW439FFwA068_230x230.jpg', '1300.0000', '0', '1598', '1', '50', '', '1', '', '2016-08-04 11:31:39', '2016-08-04 11:31:39');
INSERT INTO `tcz_item` VALUES ('4', '201608SP0004', '1', '2', '201608SP00004', '苹果（Apple）iPhone 6 Plus 16GB 全网通移动联通电信4G手机', '', 'http://img18.fn-mart.com/pic/9dab133b57f2202f7843/BnHT2212FTtMkMud0n/sioGoGjGCYBYfG/CsmRrFdg5SeAG4E3AAC5MlPYMlc965_230x230.jpg', '4300.0000', '0', '4599', '1', '50', '', '1', '', '2016-08-04 11:44:34', '2016-08-04 11:44:34');
INSERT INTO `tcz_item` VALUES ('5', '201608SP0005', '2', '2', '201608SP00005', '华为 （HUAWEI） G9 青春版 VNS-AL00 全网通4G手机 16GB- 白色', '', 'http://img02.fn-mart.com/C/item/2016/0519/201605C190001295/_170917346_230x230.jpg', '1300.0000', '0', '1599', '1', '50', '', '1', '', '2016-08-04 11:53:47', '2016-08-04 11:53:47');
INSERT INTO `tcz_item` VALUES ('6', '201608SP0006', '2', '2', '201608SP00006', '华为 （HUAWEI） P9 EVA-AL10 4GB+64GB 全网通4G手机 - 玫瑰金', '', 'http://img04.fn-mart.com/C/item/2016/0518/201605C180000665/_278715297_230x230.jpg', '3488.0000', '0', '3488', '1', '50', '', '1', '', '2016-08-04 11:54:52', '2016-08-04 11:54:52');
INSERT INTO `tcz_item` VALUES ('7', '201608SP0007', '2', '2', '201608SP00007', '华为 （HUAWEI） P9 EVA-AL00 3GB+32GB 全网通4G手机 - 流光金', '', 'http://img01.fn-mart.com/C/show/2016/0510/201605CM100001649/23674784_230x230.jpg', '2900.0000', '0', '2900', '1', '50', '', '1', '', '2016-08-04 11:56:14', '2016-08-04 11:56:14');

-- ----------------------------
-- Table structure for tcz_item_brand
-- ----------------------------
DROP TABLE IF EXISTS `tcz_item_brand`;
CREATE TABLE `tcz_item_brand` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '品牌名称',
  `logo` varchar(255) NOT NULL DEFAULT '' COMMENT '品牌logo',
  `create_date` datetime NOT NULL COMMENT '创建日期',
  `modify_date` datetime NOT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=8192 COMMENT='品牌';

-- ----------------------------
-- Records of tcz_item_brand
-- ----------------------------
INSERT INTO `tcz_item_brand` VALUES ('1', '苹果', 'http://search.feiniu.com/?cpseq=CC200456&atv=600002_401286&q=%E8%8B%B9%E6%9E%9C%E6%89%8B%E6%9C%BA', '2016-08-04 11:27:44', '2016-08-04 11:27:45');
INSERT INTO `tcz_item_brand` VALUES ('2', '华为', 'http://www.feiniu.com/category/C19117?tp=www.0.1003_cont_8-1_1.2.1467013114796BqLM', '2016-08-04 11:47:11', '2016-08-04 11:47:11');

-- ----------------------------
-- Table structure for tcz_item_categroy
-- ----------------------------
DROP TABLE IF EXISTS `tcz_item_categroy`;
CREATE TABLE `tcz_item_categroy` (
  `id` bigint(20) NOT NULL,
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '分类名称',
  `tree_path` varchar(255) NOT NULL DEFAULT '' COMMENT '树路径',
  `grade` int(10) NOT NULL COMMENT '层级',
  `parent_id` bigint(20) NOT NULL COMMENT '上级分类',
  `create_date` datetime NOT NULL COMMENT '创建日期',
  `modify_date` datetime NOT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=3276 COMMENT='商品分类';

-- ----------------------------
-- Records of tcz_item_categroy
-- ----------------------------
INSERT INTO `tcz_item_categroy` VALUES ('1', '手机数码', ',', '1', '0', '2016-08-04 11:19:47', '2016-08-04 11:19:48');
INSERT INTO `tcz_item_categroy` VALUES ('2', '手机', ',1,', '2', '1', '2016-08-04 11:20:14', '2016-08-04 11:20:15');
INSERT INTO `tcz_item_categroy` VALUES ('3', '数码', ',1,', '2', '1', '2016-08-04 11:20:39', '2016-08-04 11:21:23');
INSERT INTO `tcz_item_categroy` VALUES ('4', '影音', ',1,', '2', '1', '2016-08-04 11:23:48', '2016-08-04 11:23:50');
INSERT INTO `tcz_item_categroy` VALUES ('5', '耳机', ',1,', '2', '1', '2016-08-04 11:24:07', '2016-08-04 11:24:07');

-- ----------------------------
-- Table structure for tcz_item_categroy_brand
-- ----------------------------
DROP TABLE IF EXISTS `tcz_item_categroy_brand`;
CREATE TABLE `tcz_item_categroy_brand` (
  `item_categroy_id` bigint(20) NOT NULL,
  `brand_id` bigint(20) NOT NULL,
  KEY `FK_tcz_item_categroy_brand_tcz_item_brand_id` (`brand_id`),
  KEY `FK_tcz_item_categroy_brand_tcz_item_categroy_id` (`item_categroy_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=8192 COMMENT='商品品牌';

-- ----------------------------
-- Records of tcz_item_categroy_brand
-- ----------------------------
INSERT INTO `tcz_item_categroy_brand` VALUES ('2', '1');
INSERT INTO `tcz_item_categroy_brand` VALUES ('2', '2');

-- ----------------------------
-- Table structure for tcz_item_image
-- ----------------------------
DROP TABLE IF EXISTS `tcz_item_image`;
CREATE TABLE `tcz_item_image` (
  `id` bigint(20) NOT NULL,
  `item_id` bigint(20) NOT NULL COMMENT '商品ID',
  `title` varchar(100) NOT NULL DEFAULT '' COMMENT '标题',
  `source` varchar(255) NOT NULL DEFAULT '' COMMENT '原图',
  `large` varchar(255) NOT NULL DEFAULT '' COMMENT '大图',
  `medium` varchar(255) NOT NULL DEFAULT '' COMMENT '中图',
  `thumbnail` varchar(255) NOT NULL DEFAULT '' COMMENT '缩略图',
  `order` int(10) NOT NULL DEFAULT '0' COMMENT '排序',
  `create_date` datetime NOT NULL COMMENT '创建日期',
  `modify_date` datetime NOT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`),
  KEY `FK_tcz_item_image_tcz_item_id` (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品图片';

-- ----------------------------
-- Records of tcz_item_image
-- ----------------------------

-- ----------------------------
-- Table structure for tcz_item_tag
-- ----------------------------
DROP TABLE IF EXISTS `tcz_item_tag`;
CREATE TABLE `tcz_item_tag` (
  `item_id` bigint(20) NOT NULL,
  `tag_id` bigint(20) NOT NULL,
  KEY `FK_tcz_item_tag_tcz_item_id` (`item_id`),
  KEY `FK_tcz_item_tag_tcz_tag_id` (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=2730 COMMENT='商品标签';

-- ----------------------------
-- Records of tcz_item_tag
-- ----------------------------
INSERT INTO `tcz_item_tag` VALUES ('1', '1');
INSERT INTO `tcz_item_tag` VALUES ('3', '2');
INSERT INTO `tcz_item_tag` VALUES ('2', '2');
INSERT INTO `tcz_item_tag` VALUES ('3', '4');
INSERT INTO `tcz_item_tag` VALUES ('2', '3');
INSERT INTO `tcz_item_tag` VALUES ('3', '4');
INSERT INTO `tcz_item_tag` VALUES ('1', '2');
INSERT INTO `tcz_item_tag` VALUES ('1', '3');
INSERT INTO `tcz_item_tag` VALUES ('2', '1');
INSERT INTO `tcz_item_tag` VALUES ('3', '1');
INSERT INTO `tcz_item_tag` VALUES ('4', '1');

-- ----------------------------
-- Table structure for tcz_lottery
-- ----------------------------
DROP TABLE IF EXISTS `tcz_lottery`;
CREATE TABLE `tcz_lottery` (
  `id` bigint(20) NOT NULL,
  `goods_id` varchar(20) NOT NULL DEFAULT '' COMMENT '货号',
  `order_id` bigint(20) NOT NULL COMMENT '订单ID',
  `member_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '中奖会员',
  `lottery_number` varchar(255) NOT NULL DEFAULT '' COMMENT '中奖号码',
  `periods` int(255) NOT NULL DEFAULT '0' COMMENT '期数',
  `raffle_date` datetime NOT NULL COMMENT '开奖日期',
  `quantity` int(255) NOT NULL DEFAULT '0' COMMENT '购买数量',
  `create_date` datetime NOT NULL COMMENT '创建日期',
  `modify_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tcz_lottery
-- ----------------------------
INSERT INTO `tcz_lottery` VALUES ('1', '201608SP0001', '1', '1', '', '0', '2016-08-15 15:12:21', '10', '2016-08-15 15:12:23', '2016-08-15 15:12:24');

-- ----------------------------
-- Table structure for tcz_tag
-- ----------------------------
DROP TABLE IF EXISTS `tcz_tag`;
CREATE TABLE `tcz_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '名称',
  `create_date` datetime NOT NULL COMMENT '创建日期',
  `modify_date` datetime NOT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=4096 COMMENT='标签';

-- ----------------------------
-- Records of tcz_tag
-- ----------------------------
INSERT INTO `tcz_tag` VALUES ('1', '即将揭晓', '2016-08-04 11:18:57', '2016-08-04 11:18:58');
INSERT INTO `tcz_tag` VALUES ('2', '新品上架', '2016-08-04 11:39:50', '2016-08-04 11:39:46');
INSERT INTO `tcz_tag` VALUES ('3', '正在揭晓', '2016-08-04 11:40:17', '2016-08-04 11:40:18');
INSERT INTO `tcz_tag` VALUES ('4', '热门推荐', '2016-08-04 11:40:31', '2016-08-04 11:40:31');