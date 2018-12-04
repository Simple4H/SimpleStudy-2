SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

create Database db_test;
  DEFAULT CHARACTER SET utf8
  COLLATE utf8_general_ci;
use db_test;
-- 用户表
CREATE TABLE `simple_user` (
  `id`          int(11)     NOT NULL AUTO_INCREMENT
  COMMENT '管理员表id',
  `username`    varchar(50) NOT NULL
  COMMENT '账号',
  `detail`       varchar(50) not null
  comment '详情',
  `create_time` datetime    not null
  comment '创建时间',
  `update_time` datetime    not null
  comment '最后一次登录时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name_unique` (`username`) USING BTREE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;