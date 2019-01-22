-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 17-Jan-2019 às 00:57
-- Versão do servidor: 10.1.34-MariaDB
-- PHP Version: 5.6.37

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bancofinal`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `categoria`
--

CREATE TABLE `categoria` (
  `idcategoria` int(11) NOT NULL,
  `categoria_nome` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `categoria`
--

INSERT INTO `categoria` (`idcategoria`, `categoria_nome`) VALUES
(5, 'doce'),
(6, 'fitness'),
(7, 'salgada'),
(8, 'bebidas');

-- --------------------------------------------------------

--
-- Estrutura da tabela `itemvenda`
--

CREATE TABLE `itemvenda` (
  `iditem_venda` int(11) NOT NULL,
  `produto_idproduto` int(11) NOT NULL,
  `preco_parcial` varchar(45) DEFAULT NULL,
  `quantidade_itemVenda` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `login`
--

CREATE TABLE `login` (
  `idlogin` int(11) NOT NULL,
  `login` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `idproduto` int(11) NOT NULL,
  `nome_produto` varchar(45) DEFAULT NULL,
  `preco_produto` varchar(45) DEFAULT NULL,
  `imagem_produto` varchar(200) DEFAULT NULL,
  `desc_produto` varchar(45) DEFAULT NULL,
  `categoria_idcategoria` int(11) NOT NULL,
  `tamanho_idtamanho` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`idproduto`, `nome_produto`, `preco_produto`, `imagem_produto`, `desc_produto`, `categoria_idcategoria`, `tamanho_idtamanho`) VALUES
(8, 'pizza de chocolate', '23.0', '1547575504399.jpg', 'pizza nova', 5, 2),
(9, 'pizza de calabresa', '60.0', '1547654427982.jpg', 'Pizza com o dobro de calabresa', 7, 1),
(10, 'pizza de frango com batata doce', '60.0', '1547654460518.jpg', 'pizza para os marombas', 6, 2),
(11, 'Coca-cola zero', '8.0', '1547654490325.jpg', 'bebida zero açucar', 8, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tamanho`
--

CREATE TABLE `tamanho` (
  `idtamanho` int(11) NOT NULL,
  `tamanho` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tamanho`
--

INSERT INTO `tamanho` (`idtamanho`, `tamanho`) VALUES
(1, 'Grande'),
(2, 'Média'),
(5, 'Pequena');

-- --------------------------------------------------------

--
-- Estrutura da tabela `venda`
--

CREATE TABLE `venda` (
  `idvenda` int(11) NOT NULL,
  `precoTotal_venda` varchar(45) DEFAULT NULL,
  `data_venda` varchar(45) DEFAULT NULL,
  `itemvenda_iditem_venda` int(11) NOT NULL,
  `numero_mesa` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`idcategoria`);

--
-- Indexes for table `itemvenda`
--
ALTER TABLE `itemvenda`
  ADD PRIMARY KEY (`iditem_venda`),
  ADD KEY `fk_itemvenda_produto_idx` (`produto_idproduto`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`idlogin`);

--
-- Indexes for table `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`idproduto`),
  ADD KEY `fk_produto_categoria1_idx` (`categoria_idcategoria`),
  ADD KEY `fk_produto_tamanho1_idx` (`tamanho_idtamanho`);

--
-- Indexes for table `tamanho`
--
ALTER TABLE `tamanho`
  ADD PRIMARY KEY (`idtamanho`);

--
-- Indexes for table `venda`
--
ALTER TABLE `venda`
  ADD PRIMARY KEY (`idvenda`),
  ADD KEY `fk_venda_itemvenda1_idx` (`itemvenda_iditem_venda`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `categoria`
--
ALTER TABLE `categoria`
  MODIFY `idcategoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `itemvenda`
--
ALTER TABLE `itemvenda`
  MODIFY `iditem_venda` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `idlogin` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `produto`
--
ALTER TABLE `produto`
  MODIFY `idproduto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `tamanho`
--
ALTER TABLE `tamanho`
  MODIFY `idtamanho` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `venda`
--
ALTER TABLE `venda`
  MODIFY `idvenda` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `itemvenda`
--
ALTER TABLE `itemvenda`
  ADD CONSTRAINT `fk_itemvenda_produto` FOREIGN KEY (`produto_idproduto`) REFERENCES `produto` (`idproduto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `produto`
--
ALTER TABLE `produto`
  ADD CONSTRAINT `fk_produto_categoria1` FOREIGN KEY (`categoria_idcategoria`) REFERENCES `categoria` (`idcategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_produto_tamanho1` FOREIGN KEY (`tamanho_idtamanho`) REFERENCES `tamanho` (`idtamanho`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `venda`
--
ALTER TABLE `venda`
  ADD CONSTRAINT `fk_venda_itemvenda1` FOREIGN KEY (`itemvenda_iditem_venda`) REFERENCES `itemvenda` (`iditem_venda`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
