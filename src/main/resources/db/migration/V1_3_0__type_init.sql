CREATE TABLE IF NOT EXISTS types (
    type_id bigint(20) NOT NULL AUTO_INCREMENT,
    titre varchar(250) NOT NULL,
    description varchar(250) NOT NULL,
    PRIMARY KEY (`type_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
