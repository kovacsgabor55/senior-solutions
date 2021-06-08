CREATE TABLE employees (
id bigint not null auto_increment,
name varchar(255)  COLLATE 'utf8_hungarian_ci',
width int(4),
height int(4),
primary key (id))
COLLATE='utf8_hungarian_ci';