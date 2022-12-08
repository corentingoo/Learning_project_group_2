CREATE TABLE IF NOT EXISTS formations (
    formation_id bigint(20) NOT NULL AUTO_INCREMENT,
    titre varchar(250) NOT NULL,
    num_eleve int(20) NOT NULL,
    PRIMARY KEY (`formation_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
