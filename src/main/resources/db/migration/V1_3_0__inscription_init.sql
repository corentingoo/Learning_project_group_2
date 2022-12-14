CREATE TABLE IF NOT EXISTS `inscriptions` (
    `inscription_id` bigint(20) NOT NULL AUTO_INCREMENT,
    `student_id` bigint(20) NOT NULL,
    `formation_id` bigint(20) NOT NULL,
    PRIMARY KEY (`inscription_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table inscriptions add constraint FK_insc_form foreign key (student_id) references users (id_user);
alter table inscriptions add constraint FK_insc_us foreign key (formation_id) references formations (formation_id);
