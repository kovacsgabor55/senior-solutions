create table locations
(
    id   bigint           not null auto_increment,
    lat  double precision not null,
    lon  double precision not null,
    name varchar(255)     not null,
    primary key (id)
);
