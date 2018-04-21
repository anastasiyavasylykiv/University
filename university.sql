-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `university` DEFAULT CHARACTER SET utf8 ;
USE `university` ;

-- -----------------------------------------------------
-- Table `mydb`.`department`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `university`.`department` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `department_id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `department_name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`degree`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `university`.`degree` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `degree_id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `degree_name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`lector`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `university`.`lector` (
  `id` INT NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `lector_name` VARCHAR(45) NULL,
  `subject` VARCHAR(45) NULL,
  `degree_id` INT NOT NULL,
  PRIMARY KEY (`id`, `degree_id`),
  UNIQUE INDEX `lector_id_UNIQUE` (`id` ASC),
  INDEX `fk_lector_degree1_idx` (`degree_id` ASC),
  CONSTRAINT `fk_lector_degree1`
    FOREIGN KEY (`degree_id`)
    REFERENCES `mydb`.`degree` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`department_has_lector`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `university`.`department_has_lector` (
  `department_id` INT NOT NULL,
  `lector_id` INT NOT NULL,
  `lector_degree_id` INT NOT NULL,
  INDEX `fk_department_has_lector_lector1_idx` (`lector_id` ASC, `lector_degree_id` ASC),
  INDEX `fk_department_has_lector_department1_idx` (`department_id` ASC),
  PRIMARY KEY (`department_id`, `lector_degree_id`, `lector_id`),
  CONSTRAINT `fk_department_has_lector_department1`
    FOREIGN KEY (`department_id`)
    REFERENCES `mydb`.`department` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_department_has_lector_lector1`
    FOREIGN KEY (`lector_id`)
    REFERENCES `mydb`.`lector` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
