
#创建用户表#
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `account` varchar(25) NOT NULL DEFAULT '' COMMENT '帐号',
  `password` varchar(25) NOT NULL DEFAULT '' COMMENT '密码',
  `name` varchar(25) NOT NULL DEFAULT '' COMMENT '姓名',
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8

