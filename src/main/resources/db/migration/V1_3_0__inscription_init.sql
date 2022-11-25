CREATE TABLE IF NOT EXISTS `inscriptions` (
    `inscription_id` bigint(20) NOT NULL AUTO_INCREMENT,
    `student_id` bigint(20) NOT NULL,
    `formation_id` bigint(20) NOT NULL,
    PRIMARY KEY (`inscription_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
