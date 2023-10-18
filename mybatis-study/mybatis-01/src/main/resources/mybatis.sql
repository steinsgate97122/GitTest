create database `mybatis`;

use `mybatis`;

create table `user`(
	`id` int(20) not null primary key,
	`name` varchar(30) default null,
	`pwd` varchar(30) default null
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `user`(`id`,`name`,`pwd`) values
(1,"Alice","a123"),
(2,"Bob","b456"),
(3,"Carol","c789");

create table `teacher`(
	`id` int(20) not null primary key,
	`name` varchar(30) default null
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `teacher`(`id`,`name`) values (1,"Tim");

create table `student`(
	`id` int(20) not null,
	`name` varchar(30) default null,
	`tid` int(20) default null,
	primary key (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `student`(`id`,`name`,`tid`) values (1,"Alice",1);
insert into `student`(`id`,`name`,`tid`) values (2,"Bob",1);
insert into `student`(`id`,`name`,`tid`) values (3,"Carol",1);

create table `blog` (
	`id` varchar(50) not null primary key,
	`title` varchar(100) not null,
	`author` varchar(30) not null,
	`create_time` datetime not null,
	`views` int(30) not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
