CREATE TABLE `pizza` (
  `id` int(11) auto_increment NOT NULL,
  `categorie` varchar(255) DEFAULT NULL,
  `code` varchar(5) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `nom` varchar(25) DEFAULT NULL,
  `prix` decimal(10,2) DEFAULT NULL,
  `url_image` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `pizza` (`id`, `categorie`, `code`, `description`, `nom`, `prix`, `url_image`) VALUES
(NULL, 'Viande', 'TOT', NULL, 'toto', 45, NULL);