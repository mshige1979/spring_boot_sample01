create table if not exists memo (
  id int not null auto_increment,
  name varchar(30) not null,
  memo varchar(128),
  create_at datetime not null default current_timestamp,
  update_at datetime not null default current_timestamp on update current_timestamp,
  primary key (id)
) engine = INNODB;

insert into `memo`(name, memo) values('test01', 'hogehoge01');
insert into `memo`(name, memo) values('test02', 'hogehoge02');
insert into `memo`(name, memo) values('test03', 'hogehoge03');
insert into `memo`(name, memo) values('test04', 'hogehoge04');
insert into `memo`(name, memo) values('test05', 'hogehoge05');
insert into `memo`(name, memo) values('test06', 'hogehoge06');
insert into `memo`(name, memo) values('test07', 'hogehoge07');
insert into `memo`(name, memo) values('test08', 'hogehoge08');
insert into `memo`(name, memo) values('test09', 'hogehoge09');
insert into `memo`(name, memo) values('test10', 'hogehoge10');
