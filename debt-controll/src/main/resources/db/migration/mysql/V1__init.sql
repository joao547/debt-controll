CREATE SCHEMA IF NOT EXISTS `debt_controll` DEFAULT CHARACTER SET utf8;
USE `debt_controll`;

CREATE TABLE IF NOT EXISTS `debt_controll`.`usuarios` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `username` VARCHAR(255) NOT NULL,
  `pass` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `debt_controll`.`divida` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `parcelas` DECIMAL NOT NULL,
  `user_id` BIGINT NOT NULL,
  `total` DOUBLE NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_idx` (`user_id` ASC) ,
  CONSTRAINT `fk_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `debt_controll`.`usuarios` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `debt_controll`.`pagamento` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `data_da_parcela` DATETIME NOT NULL,
  `valor_da_parcela` DOUBLE NOT NULL,
  `divida_id` BIGINT NOT NULL,
  `status` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_divida_idx` (`divida_id` ASC) ,
  CONSTRAINT `fk_divida`
    FOREIGN KEY (`divida_id`)
    REFERENCES `debt_controll`.`divida` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


