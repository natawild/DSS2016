-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema dss
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema dss
-- -----------------------------------------------------
drop SCHEMA IF exists `dss`;

CREATE SCHEMA IF NOT EXISTS `dss` DEFAULT CHARACTER SET utf8 ;
USE `dss` ;

-- -----------------------------------------------------
-- Table `dss`.`Morador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dss`.`Morador` (
  `idUtilizador` INT NOT NULL auto_increment,
  `nome` VARCHAR(45) NOT NULL,
  `dataNascimento` DATE NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL unique,
  `valorConta` DECIMAL(21,11)  unsigned NOT NULL,
  `nrTelemovel` VARCHAR(45) NOT NULL  unique,
  `admin` INT NULL,
  PRIMARY KEY (`idUtilizador`),
  INDEX `fk_Morador_Morador1_idx` (`admin` ASC),
  CONSTRAINT `fk_Morador_Morador1`
    FOREIGN KEY (`admin`)
    REFERENCES `dss`.`Morador` (`idUtilizador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dss`.`Divida`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dss`.`Divida` (
  `idDivida` INT NOT NULL  auto_increment,
  `valorDivida` DECIMAL(21,11) unsigned NOT NULL,
  `dataDivida` DATE NOT NULL,
  `idUtilizador` INT NOT NULL,
  PRIMARY KEY (`idDivida`),
  INDEX `fk_Divida_Morador_idx` (`idUtilizador` ASC),
  CONSTRAINT `fk_Divida_Morador`
    FOREIGN KEY (`idUtilizador`)
    REFERENCES `dss`.`Morador` (`idUtilizador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dss`.`Emprestimo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dss`.`Emprestimo` (
  `idEmprestimo` INT NOT NULL  auto_increment,
  `valor` DECIMAL(21,11) unsigned NOT NULL,
  `dataEmprestimo` DATE NOT NULL,
  `idUtilizador` INT NOT NULL,
  PRIMARY KEY (`idEmprestimo`),
  INDEX `fk_Emprestimo_Morador1_idx` (`idUtilizador` ASC),
  CONSTRAINT `fk_Emprestimo_Morador1`
    FOREIGN KEY (`idUtilizador`)
    REFERENCES `dss`.`Morador` (`idUtilizador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dss`.`Mensagem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dss`.`Mensagem` (
  `idMensagem` INT NOT NULL  auto_increment,
  `Assunto` VARCHAR(45) NOT NULL,
  `mensagem` TEXT NOT NULL,
  `dataMensagem` DATE NOT NULL,
  PRIMARY KEY (`idMensagem`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dss`.`MensagemAdmin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dss`.`MensagemAdmin` (
  `idMensagem` INT NOT NULL,
  `idUtilizador` INT NOT NULL,
  PRIMARY KEY (`idMensagem`, `idUtilizador`),
  INDEX `fk_Mensagem_has_Morador_Morador1_idx` (`idUtilizador` ASC),
  INDEX `fk_Mensagem_has_Morador_Mensagem1_idx` (`idMensagem` ASC),
  CONSTRAINT `fk_Mensagem_has_Morador_Mensagem1`
    FOREIGN KEY (`idMensagem`)
    REFERENCES `dss`.`Mensagem` (`idMensagem`)
    ON DELETE cascade
    ON UPDATE cascade,
  CONSTRAINT `fk_Mensagem_has_Morador_Morador1`
    FOREIGN KEY (`idUtilizador`)
    REFERENCES `dss`.`Morador` (`idUtilizador`)
    ON DELETE cascade
    ON UPDATE cascade)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dss`.`Conta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dss`.`Conta` (
  `idConta` INT NOT NULL  auto_increment,
  `nome` VARCHAR(45) NOT NULL,
  `nrPessoasPagaram` INT unsigned NOT NULL,
  `nrPessoasApagar` INT unsigned NOT NULL,
  `dataLimite` DATE NOT NULL,
  `dataPagamento` DATE NULL,
  `totalConta` DECIMAL(21,11) unsigned NOT NULL,
  `totalContaPago` DECIMAL(21,11) unsigned NOT NULL,
  `pago` TINYINT(1) NOT NULL DEFAULT FALSE,
  `tipo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idConta`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dss`.`Pagamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dss`.`Pagamento` (
  `idConta` INT NOT NULL,
  `idUtilizador` INT NOT NULL,
  `valorPago` DECIMAL(21,11) NOT NULL,
  `valorApagar` DECIMAL(21,11) unsigned NOT NULL,
  PRIMARY KEY (`idConta`, `idUtilizador`),
  INDEX `fk_Conta_has_Morador_Morador1_idx` (`idUtilizador` ASC),
  INDEX `fk_Conta_has_Morador_Conta1_idx` (`idConta` ASC),
  CONSTRAINT `fk_Conta_has_Morador_Conta1`
    FOREIGN KEY (`idConta`)
    REFERENCES `dss`.`Conta` (`idConta`)
    ON DELETE cascade
    ON UPDATE cascade,
  CONSTRAINT `fk_Conta_has_Morador_Morador1`
    FOREIGN KEY (`idUtilizador`)
    REFERENCES `dss`.`Morador` (`idUtilizador`)
    ON DELETE cascade
    ON UPDATE cascade)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
