-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           5.6.12-log - MySQL Community Server (GPL)
-- OS do Servidor:               Win32
-- HeidiSQL Versão:              8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Copiando estrutura do banco de dados para eventobd
DROP DATABASE IF EXISTS `eventobd`;
CREATE DATABASE IF NOT EXISTS `eventobd` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `eventobd`;


-- Copiando estrutura para tabela eventobd.eventos
DROP TABLE IF EXISTS `eventos`;
CREATE TABLE IF NOT EXISTS `eventos` (
  `idEvento` int(11) NOT NULL AUTO_INCREMENT,
  `idTipoEvento` int(11) NOT NULL DEFAULT '0',
  `tituloEvento` varchar(50) NOT NULL DEFAULT '0',
  `descricaoEvento` varchar(150) NOT NULL DEFAULT '0',
  `dtEvento` date NOT NULL DEFAULT '0000-00-00',
  `horaEvento` time NOT NULL DEFAULT '00:00:00',
  `emiteCertificadoEvento` int(1) NOT NULL DEFAULT '0',
  `logradEvento` varchar(100) NOT NULL DEFAULT '0',
  `bairroEvento` varchar(30) NOT NULL DEFAULT '0',
  `cidadeEvento` varchar(30) NOT NULL DEFAULT '0',
  `ufEstado` varchar(2) NOT NULL DEFAULT '0',
  `valorIncricao` float NOT NULL DEFAULT '0',
  PRIMARY KEY (`idEvento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabela para registrar os eventos.';

-- Copiando dados para a tabela eventobd.eventos: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `eventos` DISABLE KEYS */;
/*!40000 ALTER TABLE `eventos` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
