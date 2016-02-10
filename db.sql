
DROP TABLE `cat`;
CREATE TABLE `cat` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL DEFAULT 'none',
  `color` varchar(10) NOT NULL DEFAULT 'none',
  `activate` tinyint(2) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='cat model';

drop table `DOG`;
CREATE TABLE `DOG` (
	`NAME` VARCHAR(100) NOT NULL PRIMARY KEY,
	`COLOR` VARCHAR(100)
);

-- ALTER TABLE CAT ADD ACTIVE ENUM('false', 'true') NOT NULL DEFAULT 'true';