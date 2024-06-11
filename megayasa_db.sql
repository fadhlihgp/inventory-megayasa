-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 11, 2024 at 10:38 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

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
('16ecf466-577a-48b9-82a9-d9431e08cf8c', 'superadmin@email.com', 'Super Admin', b'1', '2024-05-30 20:19:03.000000', '$2a$10$it1K5OK3rSdanv.Ns75YJuH8Z15tN0W8VlFiZqBMqybFcUMHMkVBm', '0898989898', 'superadmin', NULL, '1'),
('8a772df3-9417-43d6-b258-ce7a56afbb6f', 'personaliaMegayasa@gmail.com', 'Staf Personalia', b'1', NULL, '$2a$10$hTaJTrELPh9AugtBAYSkI.DQcPZnjwg8vxxrNMZDXXTYuA1z3ijKe', '081298771431', 'personalia', '110002', '2'),
('a0d4ba2c-4a87-4fb3-ae48-5bd41bf0a32c', 'ridhomultazam303@gmail.com', 'Ridho  Multazam', b'1', '2024-06-10 23:19:43.000000', '$2a$10$0l5X9Sl6QDoM0x/g7yDLD.df5at2v2d14syF8PRJ9YPnO73G5ccT6', '089626087984', 'admin', NULL, '1'),
('fd003fbc-82bc-4504-a662-9757ef791507', 'gudangMegayasa@gmail.com', 'Staf Gudang', b'1', NULL, '$2a$10$FTr3ZVbxGVwuvJzzEFYJFOMaysaY86ECS29SE/NgBSzELKxxhglfu', '081298748110', 'gudang', '110011', '3');

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
('110001', 'Bekasi', '1973-05-04', 'Muhammad Julian Adnan', 'Pria', '3275048898112112', '08989823323', '345da386-3326-464c-83dc-d6fe6a401f05', b'1'),
('110002', 'Bogor', '1990-09-06', 'Fajar Januani', 'Pria', '3275041711111188', '089877261222', '50272cac-93f7-42c9-8a16-5b35859dc80f', b'1'),
('110003', 'Jakarta', '1983-07-01', 'Denti Rumhayani', 'Wanita', '3275043434756234', '08988832332', '50272cac-93f7-42c9-8a16-5b35859dc80f', b'1'),
('110004', 'Kuningan, Jakarta Selatan', '1986-06-07', 'Nurjaya ', 'Pria', '3276654789876543', '08988821223', '50272cac-93f7-42c9-8a16-5b35859dc80f', b'1'),
('110005', 'Duren Sawit, Jakarta Timur', '1995-07-05', 'Naufal Putra', 'Pria', '3276123489074563', '089788993364', '50272cac-93f7-42c9-8a16-5b35859dc80f', b'1'),
('110006', 'Kota Bekasi', '1997-02-13', 'Zulfahmi ', 'Pria', '3201159876000012', '081298339821', '2f71adf7-d91f-46c1-8479-ca25b81b0065', b'1'),
('110007', 'Cileungsi, Kab Bogor', '1998-07-10', 'Oki Wijaya', 'Pria', '3210049843101248', '081198321983', '2daad959-1ef6-11ef-a022-50ebf6e36494', b'1'),
('110008', 'Kota Bekasi', '1999-08-04', 'Zulkarnain ', 'Pria', '3207438191002198', '089673839211', 'f39c1540-4524-40fc-9d75-51ff8b9c9e0e', b'1'),
('110009', 'Cileungsi, Kab Bogor', '2000-04-04', 'Sukma ', 'Pria', '3104518900001231', '089622137612', '2daad959-1ef6-11ef-a022-50ebf6e36494', b'1'),
('110010', 'Kota Bekasi', '1999-12-02', 'Fajar  Januar', 'Pria', '3208910000871321', '081297874421', '2daad959-1ef6-11ef-a022-50ebf6e36494', b'1'),
('110011', 'Cikarang', '1990-01-01', 'Agus ', 'Pria', '3110009975456172', '081874817622', 'f39c1540-4524-40fc-9d75-51ff8b9c9e0e', b'1');

-- --------------------------------------------------------

--
-- Table structure for table `incident`
--

CREATE TABLE `incident` (
  `id` varchar(36) NOT NULL,
  `date` date NOT NULL,
  `description` varchar(255) NOT NULL,
  `picture_url` varchar(255) DEFAULT NULL,
  `title` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `incident`
--

INSERT INTO `incident` (`id`, `date`, `description`, `picture_url`, `title`) VALUES
('IN-1106245702', '2024-04-01', '', 'src/main/resources/upload/INS11-032957.png', 'Badminton'),
('IN-2304245402', '2024-04-23', 'Menyala Abangku', 'src/main/resources/upload/INS23-014254.jpg', 'Kebakaran');

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
('aeed7a1f-bfdc-4f65-9b93-835eab3e560d', 'BRG001', 'Laser', 0, 'Senjata'),
('deda9237-167f-4e8a-a27b-ca200a7cd605', 'BRG111', 'Suntik', 5, 'Barang'),
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
('358a5d15-ebbd-40db-b6e1-6685903ab7f2', 'a0d4ba2c-4a87-4fb3-ae48-5bd41bf0a32c', 'admin', 'ridhomultazam303@gmail.com', 'Ridho  Multazam', '089626087984', 'SuperAdmin', '1', '2024-06-13 23:19:43');

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
('2daad959-1ef6-11ef-a022-50ebf6e36494', 'Staf'),
('2f71adf7-d91f-46c1-8479-ca25b81b0065', 'Supervisor'),
('345da386-3326-464c-83dc-d6fe6a401f05', 'Direktur'),
('50272cac-93f7-42c9-8a16-5b35859dc80f', 'Manager'),
('f39c1540-4524-40fc-9d75-51ff8b9c9e0e', 'Admin');

-- --------------------------------------------------------

--
-- Table structure for table `presence`
--

CREATE TABLE `presence` (
  `id` varchar(36) NOT NULL,
  `date` date NOT NULL,
  `information` varchar(255) NOT NULL,
  `note` varchar(255) DEFAULT NULL,
  `employee_id` varchar(36) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `presence`
--

INSERT INTO `presence` (`id`, `date`, `information`, `note`, `employee_id`) VALUES
('085913cb-90ac-42df-90ce-aab95876f6f9', '2024-04-03', 'Hadir', '', '110002'),
('0e70e6cf-8677-4eb0-9bff-94f660445d94', '2024-04-03', 'Hadir', '', '110008'),
('0fb07259-5b06-4ffa-9b91-4f38bd68a1bf', '2024-05-31', 'Hadir', '', '110007'),
('10dc6bf5-5d1b-4ce4-8978-4150a8da8916', '2024-04-03', 'Hadir', '', '110011'),
('1c19b17a-1ad8-4d04-8d2b-076e242127f5', '2024-05-31', 'Hadir', '', '110008'),
('3165a5ba-ed60-4de7-80bf-d96a7622c8cd', '2024-05-31', 'Hadir', '', '110002'),
('3e3c0197-d664-47d1-ae35-aeb8faf20ef5', '2024-04-03', 'Hadir', '', '110003'),
('4c4aa5ad-0183-4078-bf69-616118fa3ee0', '2024-05-31', 'Hadir', '', '110004'),
('9a8172da-eb4d-478f-b33f-8b724567bcff', '2024-05-31', 'Hadir', '', '110010'),
('9b06a319-3426-4828-a43c-4441f46ec72d', '2024-05-31', 'Hadir', '', '110003'),
('a7ae65ab-1a67-4d46-b88e-2c20d46335d4', '2024-04-03', 'Hadir', '', '110005'),
('ad11bcb4-ac6b-4515-88b3-f06447190430', '2024-04-03', 'Hadir', '', '110010'),
('b2d3fa24-e278-4764-bf11-58cfb2fe1002', '2024-04-03', 'Hadir', '', '110006'),
('b41ac82d-eb5f-4dec-b072-cf4b12111486', '2024-04-03', 'Hadir', '', '110007'),
('bef53c05-c963-4bb2-b36e-6d781f620305', '2024-05-31', 'Hadir', '', '110006'),
('c7f65a17-4c7d-473c-a9d2-8388abb1b18a', '2024-05-31', 'Hadir', '', '110005'),
('d77037f0-23d5-4615-9e5e-b86144e6d408', '2024-05-31', 'Hadir', '', '110009'),
('dfb18d86-45c2-47ed-8f46-a13bbf7dc368', '2024-04-03', 'Hadir', '', '110004'),
('f3e356fc-e77c-444e-952f-3e9ba1eb2214', '2024-04-03', 'Hadir', '', '110009'),
('f562338a-9c02-449d-b416-603368563844', '2024-05-31', 'Sakit', 'Demam', '110011');

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
('IN-110624151', '2024-04-01', '', b'1', 'deda9237-167f-4e8a-a27b-ca200a7cd605', 4),
('IN-210424202', '2024-04-19', '', b'1', 'fc8338da-6a90-4eb6-b1c9-14991ee12069', 5),
('IN-210424511', '2024-04-21', '', b'0', 'deda9237-167f-4e8a-a27b-ca200a7cd605', 3),
('OUT-210424231', '2024-04-21', '', b'1', 'deda9237-167f-4e8a-a27b-ca200a7cd605', 4),
('OUT-230424561', '2024-04-23', 'tes', b'0', 'fc8338da-6a90-4eb6-b1c9-14991ee12069', 1);

--
-- Indexes for dumped tables
--

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
-- Indexes for table `presence`
--
ALTER TABLE `presence`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKs69fc883x11wl5lkx9vjhf5ym` (`employee_id`);

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
-- Constraints for table `presence`
--
ALTER TABLE `presence`
  ADD CONSTRAINT `FKs69fc883x11wl5lkx9vjhf5ym` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`);

--
-- Constraints for table `stock_in_out`
--
ALTER TABLE `stock_in_out`
  ADD CONSTRAINT `FKhgmaw76ildy5p3xkg7ep5hsu9` FOREIGN KEY (`inventory_id`) REFERENCES `inventory` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
