DROP TABLE IF EXISTS `contacts`;
CREATE TABLE IF NOT EXISTS `contacts` (
  `id_cont` int(6) NOT NULL AUTO_INCREMENT,
  `nom_cont` varchar(250) NOT NULL,
  `prenom_cont` varchar(250) NOT NULL,
  `mail_cont` varchar(250) DEFAULT NULL,
  `tel_cont` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id_cont`)
);

INSERT INTO `contacts` (`id_cont`, `nom_cont`, `prenom_cont`, `mail_cont`, `tel_cont`) VALUES
(1, 'Desrousseaux', 'Aurore', 'syldesrousseaux@gmail.com', '0635564593'),
(3, 'Vandamme', 'Jean-Claude', 'jc-vandamme@hotmail.fr', '0320844533');
