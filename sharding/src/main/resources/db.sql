CREATE SCHEMA `sharding1` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE `sharding1`.`t_user1` (
  `id` INT NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `sharding1`.`t_user2` (
  `id` INT NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `sharding1`.`t_user3` (
  `id` INT NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`)
);



CREATE SCHEMA `sharding2` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE `sharding2`.`t_user1` (
  `id` INT NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `sharding2`.`t_user2` (
  `id` INT NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `sharding2`.`t_user3` (
  `id` INT NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`)
);
