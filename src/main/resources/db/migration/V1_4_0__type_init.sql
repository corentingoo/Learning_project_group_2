CREATE TABLE IF NOT EXISTS types (
    type_id bigint(20) NOT NULL AUTO_INCREMENT,
    titre varchar(250) NOT NULL,
    description varchar(250),
    PRIMARY KEY (`type_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE formations
    Add type bigint;

alter table formations add constraint fk_type foreign key(type) references types(type_id) on delete CASCADE;
