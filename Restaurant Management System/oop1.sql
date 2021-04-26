-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 18, 2019 at 12:39 PM
-- Server version: 10.1.34-MariaDB
-- PHP Version: 7.2.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `oop1`
--

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `stfId` varchar(6) NOT NULL,
  `staffName` varchar(30) NOT NULL,
  `designation` varchar(20) NOT NULL,
  `salary` double(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`stfId`, `staffName`, `designation`, `salary`) VALUES
('s00001', 'stf1', 'manager', 300000.00),
('s00002', 'staff2', 'salesman', 220000.00),
('s00003', 'stf3', 'salesman', 10000.00),
('s00006', 's6', 'cashier', 10000.00),
('s013', 'staff13', 'manager', 5345.00),
('s08', 'stf08', 'cashier', 12000.00),
('s11', 'staff11', 'cashier', 10000.00),
('s12', 's12', 'assdd', 1234.00),
('s15', 'stf015', 'manager', 1234.00),
('s16', 'stfgg', 'cashier', 10000.00);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `userId` varchar(8) NOT NULL,
  `password` varchar(10) NOT NULL,
  `status` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`userId`, `password`, `status`) VALUES
('s00001', '1234', 0),
('s00002', '17404044', 1),
('s00003', '13695425', 1),
('s00006', '10415479', 1),
('s013', '14487762', 0),
('s08', '12121238', 1),
('s11', '10956941', 1),
('s12', '17588323', 1),
('s15', '15501192', 0),
('s16', '18587052', 1);


--
-- Table structure for table `menu`
--

CREATE TABLE `menu` (
  `serial` varchar(6) NOT NULL,
  `item` varchar(30) NOT NULL,
  `price` double(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `menu`
--

INSERT INTO `menu` (`serial`, `item`, `price`) VALUES
('m00001', 'Burger',300.00),
('m00002', 'Pizza',200.00),
('m00003', 'Shwarma', 100.00),
('m00006', 'Frech Fry',  100.00),
('m013', 'Mutton Biriyani',  350.00),
('m08', 'Grilled Chicken', 150.00),
('m11', 'Pasta', 100.00),
('m12', 'Kacchi Biriyani', 120.00),
('m15', 'Fried Rice', 123.00),
('m16', 'Chicken Kabab',100.00);



--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `cId` varchar(6) NOT NULL,
  `name` varchar(30) NOT NULL,
  `item` varchar(30) NOT NULL,
  `price` double(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `menu`
--

INSERT INTO `customer` (`cId`, `name`, `item`, `price`) VALUES
('c00001', 'c1', 'Burger', 300.00),
('c00002', 'c2', 'Pizza', 200.00),
('c00003', 'c3', 'Shwarma', 100.00),
('c00006', 'c6',  'French Fry', 100.00),
('c013', 'c13',  'Mutton Biriyani', 350.00),
('c08', 'c08', 'Grilled Chicken', 150.00),
('c11', 'c11', 'Pasta', 100.00),
('c12', 'c12', 'Kacchi Biriyani', 120.00),
('c15', 'c015', 'Fried Rice', 123.00),
('c16', 'cgg', 'Chicken Kabab', 100.00);


--
-- Indexes for dumped tables
--

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`stfId`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`userId`);
  
--
-- Indexes for table `menu`
--
  
  ALTER TABLE `menu`
  ADD PRIMARY KEY (`m1Id`);
--
-- Indexes for table `customer`
--
 ALTER TABLE `customer`
 ADD PRIMARY KEY (`cId`);
  
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
