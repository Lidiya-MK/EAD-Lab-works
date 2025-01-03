create schema bookstoredb;

CREATE TABLE `bookstoredb`.`books` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NULL,
  `author` VARCHAR(45) NULL,
  `price` DOUBLE NULL);
