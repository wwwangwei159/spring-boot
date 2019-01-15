CREATE TABLE `tt_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(80) DEFAULT NULL,
  `email` varchar(80) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


INSERT INTO tt_user (user_id,user_name,email,age) VALUES
(1,'张三','zhangsan@qq.com',30)
,(2,'李四2','lisi@qq.com',40)
;

show variables like '%time_zone%';

set global time_zone='+8:00';

url: jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC&characterEncoding=utf-8&allowPublicKeyRetrieval=true