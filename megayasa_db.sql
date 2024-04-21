-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 21, 2024 at 10:09 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `megayasa_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `absence`
--

CREATE TABLE `absence` (
  `id` varchar(36) NOT NULL,
  `date` date NOT NULL,
  `information` varchar(255) NOT NULL,
  `note` varchar(255) DEFAULT NULL,
  `employee_id` varchar(36) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `absence`
--

INSERT INTO `absence` (`id`, `date`, `information`, `note`, `employee_id`) VALUES
('401540ca-82fa-4495-b3f7-59e4da551d0f', '2024-03-06', 'Sakit', 'Okee', '110004'),
('45314493-990a-4381-954e-155c9e685f73', '2024-04-15', 'Cuti', '', '110002'),
('92692a81-608f-459b-ab79-7ea77dfa5ce2', '2024-04-22', 'Sakit', '', '110005');

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `id` varchar(36) NOT NULL,
  `email` varchar(255) NOT NULL,
  `full_name` varchar(255) NOT NULL,
  `is_active` bit(1) NOT NULL,
  `last_login` datetime(6) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `phone_number` varchar(15) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `employee_id` varchar(36) DEFAULT NULL,
  `role_id` varchar(36) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`id`, `email`, `full_name`, `is_active`, `last_login`, `password`, `phone_number`, `username`, `employee_id`, `role_id`) VALUES
('16ecf466-577a-48b9-82a9-d9431e08cf8c', 'superadmin@email.com', 'Super Admin', b'1', '2024-04-21 14:21:08.000000', '$2a$10$it1K5OK3rSdanv.Ns75YJuH8Z15tN0W8VlFiZqBMqybFcUMHMkVBm', '0898989898', 'superadmin', NULL, '1'),
('1f3439e5-7562-4680-b1d0-f655449cf8bc', 'syifa@email.com', 'Syifa Putri', b'1', NULL, '$2a$10$xm5P7mUHdFbQVIimN6jSgeVMHSQKP.dssnBLSyE5FerlSMvLfAR0W', '089882122', 'syifa123', '110003', '2');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` varchar(36) NOT NULL,
  `address` varchar(255) NOT NULL,
  `birthdate` date NOT NULL,
  `name` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `identity_number` varchar(255) DEFAULT NULL,
  `phone_number` varchar(15) DEFAULT NULL,
  `position_id` varchar(36) DEFAULT NULL,
  `is_active` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `address`, `birthdate`, `name`, `gender`, `identity_number`, `phone_number`, `position_id`, `is_active`) VALUES
('110001', 'Bekasi', '2000-11-17', 'Fadhlih Girindra Putra', 'Pria', '32750488981121', '08989823323', '345da386-3326-464c-83dc-d6fe6a401f05', b'1'),
('110002', 'Bogor', '2002-06-13', 'Putri Angela', 'Wanita', '3275041711111188', '089877261222', '50272cac-93f7-42c9-8a16-5b35859dc80f', b'1'),
('110003', 'Jakarta', '2001-08-16', 'Syifa Putri', 'Wanita', '3275043434756234', '08988832332', '2f71adf7-d91f-46c1-8479-ca25b81b0065', b'1'),
('110004', 'Kuningan, Jakarta Selatan', '2002-11-13', 'Rio Rahmat Iriawan', 'Pria', '3276654789876543', '08988821223', 'f39c1540-4524-40fc-9d75-51ff8b9c9e0e', b'1'),
('110005', 'Duren Sawit, Jakarta Timur', '2004-06-18', 'Dendy Sulistiawan', 'Pria', '3276123489074563', '089788993364', '50272cac-93f7-42c9-8a16-5b35859dc80f', b'1');

-- --------------------------------------------------------

--
-- Table structure for table `incident`
--

CREATE TABLE `incident` (
  `id` varchar(36) NOT NULL,
  `date` datetime(6) NOT NULL,
  `description` varchar(255) NOT NULL,
  `picture_url` varchar(255) DEFAULT NULL,
  `title` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `inventory`
--

CREATE TABLE `inventory` (
  `id` varchar(36) NOT NULL,
  `code` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `stock` int(11) NOT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `inventory`
--

INSERT INTO `inventory` (`id`, `code`, `name`, `stock`, `type`) VALUES
('deda9237-167f-4e8a-a27b-ca200a7cd605', 'BRG111', 'Suntik', 1, 'Barang'),
('fc8338da-6a90-4eb6-b1c9-14991ee12069', 'BRG110', 'Kabel', 5, 'Yooi');

-- --------------------------------------------------------

--
-- Table structure for table `login_information`
--

CREATE TABLE `login_information` (
  `id` varchar(36) NOT NULL,
  `account_id` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `role_id` varchar(255) DEFAULT NULL,
  `expired_login` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `login_information`
--

INSERT INTO `login_information` (`id`, `account_id`, `username`, `email`, `full_name`, `phone_number`, `role`, `role_id`, `expired_login`) VALUES
('71927317-14a9-4db4-8079-027d3711f2f5', '16ecf466-577a-48b9-82a9-d9431e08cf8c', 'superadmin', 'superadmin@email.com', 'Super Admin', '0898989898', 'SuperAdmin', '1', '2024-04-24 14:21:08');

-- --------------------------------------------------------

--
-- Table structure for table `position`
--

CREATE TABLE `position` (
  `id` varchar(36) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `position`
--

INSERT INTO `position` (`id`, `name`) VALUES
('2f71adf7-d91f-46c1-8479-ca25b81b0065', 'Staff Personalia'),
('345da386-3326-464c-83dc-d6fe6a401f05', 'Direktur'),
('50272cac-93f7-42c9-8a16-5b35859dc80f', 'Staff Keuangan'),
('f39c1540-4524-40fc-9d75-51ff8b9c9e0e', 'Admin Operator');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` varchar(36) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
('1', 'SuperAdmin'),
('2', 'Personalia'),
('3', 'Staff');

-- --------------------------------------------------------

--
-- Table structure for table `stock_in_out`
--

CREATE TABLE `stock_in_out` (
  `id` varchar(36) NOT NULL,
  `date` date NOT NULL,
  `note` varchar(255) DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `inventory_id` varchar(36) NOT NULL,
  `amount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `stock_in_out`
--

INSERT INTO `stock_in_out` (`id`, `date`, `note`, `status`, `inventory_id`, `amount`) VALUES
('IN-210424202', '2024-04-19', '', b'1', 'fc8338da-6a90-4eb6-b1c9-14991ee12069', 5),
('IN-210424511', '2024-04-21', '', b'0', 'deda9237-167f-4e8a-a27b-ca200a7cd605', 3),
('OUT-210424231', '2024-04-21', '', b'1', 'deda9237-167f-4e8a-a27b-ca200a7cd605', 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `absence`
--
ALTER TABLE `absence`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKs69fc883x11wl5lkx9vjhf5ym` (`employee_id`);

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_q0uja26qgu1atulenwup9rxyr` (`email`),
  ADD UNIQUE KEY `UK_gex1lmaqpg0ir5g1f5eftyaa1` (`username`),
  ADD UNIQUE KEY `UK_di2gpau46j4053lfccsrrq1sb` (`employee_id`),
  ADD KEY `FKd4vb66o896tay3yy52oqxr9w0` (`role_id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_fg7c8qqudo49j0eqghq032xis` (`identity_number`),
  ADD UNIQUE KEY `UK_if2qx9bhvigig71puh5sow65g` (`phone_number`),
  ADD KEY `FKbc8rdko9o9n1ri9bpdyxv3x7i` (`position_id`);

--
-- Indexes for table `incident`
--
ALTER TABLE `incident`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `inventory`
--
ALTER TABLE `inventory`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_r16gsk43x9ty7eai47qjl1it` (`code`);

--
-- Indexes for table `login_information`
--
ALTER TABLE `login_information`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `position`
--
ALTER TABLE `position`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `stock_in_out`
--
ALTER TABLE `stock_in_out`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKhgmaw76ildy5p3xkg7ep5hsu9` (`inventory_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `absence`
--
ALTER TABLE `absence`
  ADD CONSTRAINT `FKs69fc883x11wl5lkx9vjhf5ym` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`);

--
-- Constraints for table `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `FK1kec5bwba2rl0j8garlarwe3d` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
  ADD CONSTRAINT `FKd4vb66o896tay3yy52oqxr9w0` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `FKbc8rdko9o9n1ri9bpdyxv3x7i` FOREIGN KEY (`position_id`) REFERENCES `position` (`id`);

--
-- Constraints for table `stock_in_out`
--
ALTER TABLE `stock_in_out`
  ADD CONSTRAINT `FKhgmaw76ildy5p3xkg7ep5hsu9` FOREIGN KEY (`inventory_id`) REFERENCES `inventory` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
