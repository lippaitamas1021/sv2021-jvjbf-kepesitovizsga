create table recorders (
    id bigint not null auto_increment,
    date_of_birth date,
    name varchar(255),
    primary key (id));
create table worldrecords (
    id bigint not null auto_increment,
    date date,
    description varchar(255),
    old_recorder_id bigint,
    unit_of_measure varchar(255),
    value double precision not null,
    recorder_id bigint,
    primary key (id));
alter table worldrecords add constraint FK_WR foreign key (recorder_id) references recorders (id);