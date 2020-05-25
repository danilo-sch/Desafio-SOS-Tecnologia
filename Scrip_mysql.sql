CREATE SCHEMA IF NOT EXISTS `desafio` DEFAULT CHARACTER SET utf8mb4 ;
USE `desafio` ;

-- -----------------------------------------------------
-- Table `desafio`.`marcas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `desafio`.`marcas` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UKr2am2bysorcd90qxo9mscxahg` (`nome` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `desafio`.`patrimonios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `desafio`.`patrimonios` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `descricao` VARCHAR(500) NULL DEFAULT NULL,
  `num_tombo` INT(11) NULL DEFAULT NULL,
  `marcaid` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `marcaid` (`marcaid` ASC) VISIBLE,
  CONSTRAINT `patrimonios_ibfk_1`
    FOREIGN KEY (`marcaid`)
    REFERENCES `desafio`.`marcas` (`id`)
    ON DELETE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 26
DEFAULT CHARACTER SET = utf8mb4;


