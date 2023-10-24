create table `books` (
	`id` int(10) not null auto_increment primary key,
	`name` varchar(100) not null,
	`count` int(11) not null,
	`detail` varchar(200) not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `books`(name, count, detail) values
("1984", 100, "Author: George Orwell"),
("The Great Gatsby", 20, "Author: F. Scott Fitzgerald"),
("To Kill a Mockingbird", 60, "Author: Harper Lee");
