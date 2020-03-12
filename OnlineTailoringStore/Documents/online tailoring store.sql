SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `onlinetailoringsystem` DEFAULT CHARACTER SET utf8 ;
USE `onlinetailoringsystem` ;

-- -----------------------------------------------------
-- Table `onlinetailoringsystem`.`admin_table`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `onlinetailoringsystem`.`admin_table` ;

CREATE  TABLE IF NOT EXISTS `onlinetailoringsystem`.`admin_table` (
  `username` VARCHAR(45) NOT NULL ,
  `password` VARCHAR(45) NOT NULL ,
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `onlinetailoringsystem`.`category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `onlinetailoringsystem`.`category` ;

CREATE  TABLE IF NOT EXISTS `onlinetailoringsystem`.`category` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `category` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `onlinetailoringsystem`.`dress_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `onlinetailoringsystem`.`dress_type` ;

CREATE  TABLE IF NOT EXISTS `onlinetailoringsystem`.`dress_type` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `dress_type` VARCHAR(45) NOT NULL ,
  `category_id` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_category_id` (`category_id` ASC) ,
  CONSTRAINT `category_id`
    FOREIGN KEY (`id` )
    REFERENCES `onlinetailoringsystem`.`category` (`id` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_category_id`
    FOREIGN KEY (`category_id` )
    REFERENCES `onlinetailoringsystem`.`category` (`id` ))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `onlinetailoringsystem`.`pattern`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `onlinetailoringsystem`.`pattern` ;

CREATE  TABLE IF NOT EXISTS `onlinetailoringsystem`.`pattern` (
  `idpat` INT(11) NOT NULL AUTO_INCREMENT ,
  `caption` VARCHAR(45) NOT NULL ,
  `pat` LONGBLOB NOT NULL ,
  `cost` FLOAT(5,2) NULL DEFAULT NULL ,
  `dressId` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`idpat`) ,
  INDEX `dressId` (`dressId` ASC) ,
  CONSTRAINT `pattern_ibfk_1`
    FOREIGN KEY (`dressId` )
    REFERENCES `onlinetailoringsystem`.`dress_type` (`id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `onlinetailoringsystem`.`user_table`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `onlinetailoringsystem`.`user_table` ;

CREATE  TABLE IF NOT EXISTS `onlinetailoringsystem`.`user_table` (
  `firstname` VARCHAR(45) NOT NULL ,
  `lastname` VARCHAR(45) NOT NULL ,
  `dateofbirth` VARCHAR(45) NOT NULL ,
  `gender` VARCHAR(45) NOT NULL ,
  `contact_number` VARCHAR(45) NOT NULL ,
  `category` VARCHAR(45) NOT NULL ,
  `username` VARCHAR(45) NOT NULL ,
  `password` VARCHAR(45) NOT NULL ,
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `contact_number_UNIQUE` (`contact_number` ASC) ,
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 16
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `onlinetailoringsystem`.`orders`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `onlinetailoringsystem`.`orders` ;

CREATE  TABLE IF NOT EXISTS `onlinetailoringsystem`.`orders` (
  `order_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `placed_date` DATE NOT NULL ,
  `exp_delivery_date` DATE NOT NULL ,
  `delivered_date` DATE NOT NULL ,
  `order_status` VARCHAR(45) NOT NULL ,
  `amount` FLOAT(5,2) NOT NULL ,
  `pattern_id` INT(11) NOT NULL ,
  `user_id` INT(11) NOT NULL ,
  `tailor_id` INT(11) NOT NULL ,
  PRIMARY KEY (`order_id`) ,
  INDEX `pattern_id` (`pattern_id` ASC) ,
  INDEX `user_id` (`user_id` ASC) ,
  CONSTRAINT `orders_ibfk_1`
    FOREIGN KEY (`pattern_id` )
    REFERENCES `onlinetailoringsystem`.`pattern` (`idpat` )
    ON DELETE CASCADE,
  CONSTRAINT `orders_ibfk_2`
    FOREIGN KEY (`user_id` )
    REFERENCES `onlinetailoringsystem`.`user_table` (`id` )
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `onlinetailoringsystem`.`tailors`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `onlinetailoringsystem`.`tailors` ;

CREATE  TABLE IF NOT EXISTS `onlinetailoringsystem`.`tailors` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `shop_name` VARCHAR(45) NOT NULL ,
  `address` VARCHAR(100) NOT NULL ,
  `contact_number` BIGINT(20) NOT NULL ,
  `working_hours` VARCHAR(20) NOT NULL ,
  `available_services` VARCHAR(150) NOT NULL ,
  `courier` TINYINT(1) NOT NULL ,
  `user_id` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_user_id` (`user_id` ASC) ,
  CONSTRAINT `user_id`
    FOREIGN KEY (`id` )
    REFERENCES `onlinetailoringsystem`.`user_table` (`id` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;

USE `onlinetailoringsystem` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
