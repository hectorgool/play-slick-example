
CREATE TABLE `CAT` (
	`NAME` VARCHAR(100) NOT NULL PRIMARY KEY,
	`COLOR` VARCHAR(100),
	`ACTIVATE` BOOL NOT NULL DEFAULT '1'
);

-- INSERT INTO `CAT` VALUES ('Garfield','naranja'),('felix','negro');



CREATE TABLE `DOG` (
	`NAME` VARCHAR(100) NOT NULL PRIMARY KEY,
	`COLOR` VARCHAR(100)
);


drop table CAT;
drop table DOG;

-- ALTER TABLE CAT ADD ACTIVE ENUM('false', 'true') NOT NULL DEFAULT 'true';