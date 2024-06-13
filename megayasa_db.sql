-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 13, 2024 at 04:28 PM
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
('8a772df3-9417-43d6-b258-ce7a56afbb6f', 'personaliaMegayasa@gmail.com', 'Staf Personalia', b'1', '2024-06-13 18:21:27.000000', '$2a$10$hTaJTrELPh9AugtBAYSkI.DQcPZnjwg8vxxrNMZDXXTYuA1z3ijKe', '081298771431', 'personalia', '110002', '2'),
('a0d4ba2c-4a87-4fb3-ae48-5bd41bf0a32c', 'ridhomultazam303@gmail.com', 'Ridho  Multazam', b'1', '2024-06-11 21:30:07.000000', '$2a$10$0l5X9Sl6QDoM0x/g7yDLD.df5at2v2d14syF8PRJ9YPnO73G5ccT6', '089626087984', 'admin', NULL, '1'),
('fd003fbc-82bc-4504-a662-9757ef791507', 'gudangMegayasa@gmail.com', 'Staf Gudang', b'1', '2024-06-11 23:05:20.000000', '$2a$10$FTr3ZVbxGVwuvJzzEFYJFOMaysaY86ECS29SE/NgBSzELKxxhglfu', '081298748110', 'gudang', '110011', '3');

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
('f887d445-3348-45cd-821e-e1823d04e9b4', '8a772df3-9417-43d6-b258-ce7a56afbb6f', 'personalia', 'personaliaMegayasa@gmail.com', 'Staf Personalia', '081298771431', 'Personalia', '2', '2024-06-16 18:21:27');

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
('00aac368-17ee-4a98-81f3-9d070547fbf2', '2024-05-06', 'Hadir', '', '110002'),
('01f7250c-7f0e-42d5-8eee-018952e9b1a4', '2024-05-02', 'Hadir', '', '110002'),
('032cccfa-213d-4eba-89f9-7d82d699ab10', '2024-05-06', 'Hadir', '', '110008'),
('03561f2c-efa5-42e3-a743-41f79f316b8b', '2024-05-28', 'Hadir', '', '110010'),
('0388b2d8-b9fc-4381-9037-aeb60e5d81ff', '2024-05-08', 'Hadir', '', '110008'),
('0496a159-e2b1-45b0-b2b6-cdbfff9cdaa0', '2024-05-30', 'Hadir', '', '110004'),
('04a45a41-3611-4cce-acb7-e7a4c6be9eec', '2024-05-29', 'Hadir', '', '110002'),
('05bf6a6f-1d55-44c2-8cf8-e8c854b68ffe', '2024-05-16', 'Hadir', '', '110003'),
('08aa9ed0-c8e7-4fa8-982d-c2a9b53e0a15', '2024-05-03', 'Hadir', '', '110002'),
('09c8b987-6b41-4325-8f5e-5fcb8d8dd081', '2024-05-07', 'Hadir', '', '110009'),
('0ae53e24-1f81-43f9-8aa4-270e5beaaedb', '2024-06-03', 'Hadir', '', '110009'),
('0c2c8441-6d20-4d59-8886-a9a19c0f73b6', '2024-05-20', 'Hadir', '', '110007'),
('0d784112-6845-4964-8527-78c5431f22bb', '2024-05-27', 'Hadir', '', '110007'),
('0d83a036-ca8c-47e6-bb1a-e8ba14a1c237', '2024-05-07', 'Hadir', '', '110008'),
('0efc42fd-b69b-4cd4-8468-a914100d8034', '2024-05-02', 'Hadir', '', '110008'),
('0efff2ab-0c10-4cc5-bcf5-c1d981228b9e', '2024-05-03', 'Hadir', '', '110010'),
('103f05bd-f05f-4411-981e-9cb095d104d8', '2024-05-30', 'Hadir', '', '110009'),
('10dce733-23bb-4c8b-b8a7-a11b9ead8c39', '2024-06-05', 'Hadir', '', '110006'),
('11966314-7ddc-4110-88af-b48ddfa641e2', '2024-06-03', 'Hadir', '', '110007'),
('12ae706e-73b7-4bb3-b89d-6bca03210e3e', '2024-05-03', 'Hadir', '', '110003'),
('131bb40d-0106-4cc3-8794-559e9064beeb', '2024-05-31', 'Hadir', '', '110004'),
('13985d66-f1ed-49b9-945b-00e4ef51ed12', '2024-05-06', 'Hadir', '', '110004'),
('15e0c7e4-aab5-489b-bb6a-f60b0154e69d', '2024-06-03', 'Hadir', '', '110005'),
('17c12756-c9a5-4a08-8ff7-caa384466615', '2024-05-06', 'Hadir', '', '110005'),
('1819c2d8-aa67-4751-a160-353e60fe2623', '2024-05-21', 'Hadir', '', '110006'),
('1ab784d2-393e-4ab5-9350-5aad4ae4aad3', '2024-05-29', 'Hadir', '', '110011'),
('1ada7aa7-36f8-4d46-990b-491e5bce94b5', '2024-05-15', 'Hadir', '', '110003'),
('1de41576-ad20-4b4f-8779-0df778561ed1', '2024-05-07', 'Hadir', '', '110002'),
('1e28cb95-16ea-47d9-b233-99840200b873', '2024-06-05', 'Hadir', '', '110008'),
('1f574ea7-76a8-4652-b40a-504560ed247d', '2024-05-08', 'Hadir', '', '110011'),
('1f5c90fc-5d80-4df6-b3c7-2665bba68cca', '2024-06-07', 'Hadir', '', '110010'),
('20fbf32e-fccd-421f-b494-b2fd12599619', '2024-06-06', 'Hadir', '', '110003'),
('212d600f-747c-42f7-a8d8-9d9ef9026165', '2024-06-07', 'Hadir', '', '110007'),
('25518311-a997-4409-8622-9b0191c71123', '2024-05-31', 'Cuti', '', '110007'),
('2602955f-5d28-4c7a-bdfb-b283dab491a2', '2024-05-14', 'Hadir', '', '110005'),
('27f858c3-9022-48b6-90e3-b8ac9c508d9e', '2024-05-20', 'Hadir', '', '110009'),
('283bea61-d6b5-44d4-b36c-7e8e348a5878', '2024-06-04', 'Hadir', '', '110011'),
('29360431-2c7d-4076-8abc-1ff12cc5dc45', '2024-06-06', 'Hadir', '', '110008'),
('295c59c8-d18f-46ef-93bf-231f8e3e1a7a', '2024-06-07', 'Hadir', '', '110006'),
('2a7ae81e-53de-4a33-8009-908a4b4b7aa2', '2024-05-27', 'Hadir', '', '110005'),
('2a8d42d6-011b-4d8b-aed2-2bcb8fa36632', '2024-05-08', 'Hadir', '', '110006'),
('2caae639-a827-4e84-8537-0f8d2ead462b', '2024-05-21', 'Hadir', '', '110011'),
('2e971641-fea7-4f6d-9fd7-810320da9b1c', '2024-05-28', 'Hadir', '', '110002'),
('2f6dbf17-b7cc-40e1-b7d7-271ffaa0829e', '2024-05-08', 'Hadir', '', '110005'),
('316a0617-95d8-4e69-9a52-219352e737f3', '2024-05-13', 'Hadir', '', '110010'),
('32040dad-9ba8-4789-881b-26ed4d740e40', '2024-05-17', 'Hadir', '', '110010'),
('321a5398-ed30-4025-8e8d-bc38f438e5c0', '2024-05-21', 'Sakit', '', '110008'),
('32c4a2aa-25c4-4e80-bba1-67cb01a40950', '2024-05-21', 'Hadir', '', '110007'),
('3302f1d9-b654-48a5-8293-0c10d25f2c17', '2024-05-31', 'Hadir', '', '110008'),
('3606919d-e462-4b8a-b35e-cf202c9fdb91', '2024-05-27', 'Hadir', '', '110009'),
('36e4c1ef-32d1-40cd-98af-28bec329101c', '2024-05-06', 'Hadir', '', '110010'),
('3820c0ab-d7f8-4ec2-99a8-a8d6fe5fca23', '2024-05-13', 'Hadir', '', '110004'),
('38e43ddb-b711-4752-894b-de471bb184ed', '2024-06-06', 'Hadir', '', '110006'),
('3bfc293f-fe31-4c75-ab78-3dd2f7a2b554', '2024-05-28', 'Hadir', '', '110011'),
('3dbc760b-9e8d-4e12-9316-3b64a656b516', '2024-05-07', 'Hadir', '', '110007'),
('3dd49e1f-2607-472d-85cf-ba763b144164', '2024-05-22', 'Hadir', '', '110011'),
('3f0792d0-03ac-467c-8789-c4511117a1cf', '2024-05-02', 'Hadir', '', '110010'),
('40e41736-b881-4bc0-891d-2c98b2407977', '2024-05-01', 'Hadir', '', '110010'),
('440329d0-77b9-4553-bdca-da8876281445', '2024-05-15', 'Hadir', '', '110004'),
('457da647-3427-4cee-8bf9-447442fc52f9', '2024-06-07', 'Hadir', '', '110002'),
('46d715a8-d90c-4e75-86b4-5ef8c0d9258d', '2024-05-14', 'Hadir', '', '110010'),
('47970628-bb37-42e1-88b0-c49fcefaf7cc', '2024-05-01', 'Hadir', '', '110008'),
('485035f5-5993-46af-95d7-c728a00bb754', '2024-05-16', 'Hadir', '', '110011'),
('48741a22-11bf-4e46-9737-a2ce7b283550', '2024-05-27', 'Hadir', '', '110011'),
('4967010d-2e2c-4513-8ba4-25b1d54cc6ea', '2024-05-31', 'Hadir', '', '110010'),
('49fa558e-2246-491f-8f1c-3e368921fa6b', '2024-06-06', 'Hadir', '', '110009'),
('4a373722-36b1-486e-bcc6-3c7daa2b10a2', '2024-05-31', 'Hadir', '', '110006'),
('4a5ee5a4-8f6a-4fe7-9608-d87c39623bfb', '2024-05-02', 'Hadir', '', '110003'),
('4c0f6a14-ea21-4e32-be21-5caef61f4c5e', '2024-05-16', 'Hadir', '', '110008'),
('4c467306-20f1-49a7-a092-743b5a488963', '2024-05-17', 'Hadir', '', '110008'),
('4e4a876b-566c-4452-8349-027d4728bb43', '2024-05-30', 'Cuti', '', '110011'),
('51ae14ee-aa9c-41f7-8e6b-1442730bf0df', '2024-05-07', 'Hadir', '', '110010'),
('51b198f8-2d95-4d0b-b4cc-4dc52e9a1672', '2024-05-17', 'Hadir', '', '110006'),
('51ce5465-bc4e-49ad-8589-089481599995', '2024-06-07', 'Hadir', '', '110004'),
('531d43ac-10c1-4ba2-8d35-cf5a794f9b2e', '2024-05-13', 'Hadir', '', '110011'),
('5463da79-0e16-459d-bf46-365a48304524', '2024-05-01', 'Hadir', '', '110005'),
('563acbe9-48c1-4cf6-ac47-407b7d49b598', '2024-05-14', 'Hadir', '', '110003'),
('5648ec58-7572-463f-8575-c8d800428016', '2024-05-15', 'Hadir', '', '110007'),
('5760ef2d-dabd-49bd-b81f-6394c7ae9e8a', '2024-06-03', 'Hadir', '', '110010'),
('58e6462a-aeb5-4bd2-8346-702e85d050fc', '2024-05-21', 'Hadir', '', '110009'),
('5a2a9576-1ed7-412a-a3a1-99fbd0b25a0a', '2024-05-17', 'Hadir', '', '110009'),
('5adf8dd0-58ca-45bf-bd9f-abf56f69c30f', '2024-05-29', 'Hadir', '', '110009'),
('5b951c01-d710-4340-95b7-22badd9ed31e', '2024-05-15', 'Hadir', '', '110005'),
('5ca2c845-c9d8-4e5c-80a6-ea35e1e1f849', '2024-05-03', 'Cuti', '', '110004'),
('5e43e8db-0046-47d3-9e94-4ba1ed31ae38', '2024-05-22', 'Hadir', '', '110009'),
('5fdd2cce-21d0-4619-a1b2-64dd55dfc555', '2024-05-16', 'Hadir', '', '110002'),
('61518e63-0e9d-4abd-98b5-260b1b78ca04', '2024-05-29', 'Hadir', '', '110010'),
('63708de6-caf7-463d-8d73-a90c7ba1366d', '2024-05-28', 'Hadir', '', '110003'),
('63bd5b85-9680-4077-b782-cba7f1335727', '2024-05-15', 'Hadir', '', '110011'),
('646291ee-2082-4f9a-93af-b24987a009f9', '2024-06-05', 'Hadir', '', '110004'),
('6494d6cd-3b5b-4b5f-a34c-92daa2064321', '2024-05-16', 'Hadir', '', '110006'),
('6516402b-5028-4ea4-8283-cbff838bd47e', '2024-05-28', 'Hadir', '', '110004'),
('657985d8-075a-4ed0-9e02-c5a3840d0576', '2024-05-07', 'Hadir', '', '110005'),
('65954ca4-f344-443a-836a-369e74ddab4b', '2024-05-27', 'Hadir', '', '110006'),
('66cb29a9-3072-4319-9a06-5e51bf6c4c0f', '2024-05-31', 'Cuti', '', '110011'),
('66e1930d-3284-44e1-823a-4ed6ff7fc1a3', '2024-06-06', 'Hadir', '', '110007'),
('66fc53ac-0fb3-448d-9c11-2c077f17e677', '2024-05-15', 'Hadir', '', '110008'),
('695e8dc7-0ddc-43b3-9653-da1ab57e5757', '2024-05-03', 'Hadir', '', '110006'),
('6afa7bc6-e26e-4f7f-98a0-9c0a29716d69', '2024-06-03', 'Hadir', '', '110008'),
('6c1908f5-3853-424e-9d3c-bd0e38c79933', '2024-05-13', 'Hadir', '', '110007'),
('6cec105b-d799-4cba-96e7-c80848b6d2fc', '2024-05-30', 'Sakit', '', '110003'),
('6de2590d-63d8-4686-a841-588d2476d8e5', '2024-05-28', 'Hadir', '', '110008'),
('6df5ac8f-2f1e-4eaa-8594-1e99d2213b36', '2024-06-05', 'Hadir', '', '110002'),
('6e46ea42-2236-44d1-9248-d7f2cfcf82ff', '2024-05-22', 'Hadir', '', '110003'),
('6f763231-de25-44b0-93c6-e2793d778cdf', '2024-05-08', 'Hadir', '', '110004'),
('6fce2526-9f26-4ddd-b070-8ccbb2620fa0', '2024-06-04', 'Hadir', '', '110010'),
('701f3e94-dbd6-490e-a427-26663d181e3c', '2024-05-07', 'Hadir', '', '110003'),
('71f07e8f-ca39-4bb0-8bcf-cc7fbf766d85', '2024-05-01', 'Hadir', '', '110011'),
('744ccb3c-eec8-4d3a-b49c-3aa13dbd3d7f', '2024-05-01', 'Hadir', '', '110004'),
('74fe40b1-09ce-4265-9d75-39039081d42c', '2024-05-03', 'Hadir', '', '110011'),
('7519c0fd-122d-4559-a131-c6c50b006314', '2024-05-31', 'Sakit', '', '110002'),
('756ad944-3514-4a60-a434-71acadcb8ce0', '2024-05-17', 'Hadir', '', '110002'),
('77da9413-370f-4592-997d-d0bbd99ea382', '2024-05-16', 'Hadir', '', '110007'),
('77dddd55-3974-4bb5-9173-521089c22517', '2024-05-08', 'Hadir', '', '110002'),
('78fbff8e-570d-4c12-ac67-581099158496', '2024-05-02', 'Izin', 'Cuti', '110004'),
('79643e87-ccf5-4ade-934f-7c1b0055c707', '2024-05-15', 'Hadir', '', '110009'),
('7a4e507d-c493-4d04-983c-95cdd62ce98c', '2024-05-27', 'Hadir', '', '110002'),
('7ac8685b-e571-4671-bfc8-7e7bb6cb0e90', '2024-05-29', 'Hadir', '', '110003'),
('7e060f36-b27f-4b10-b717-5b1d5b0da84b', '2024-05-16', 'Hadir', '', '110010'),
('7e07b88e-f595-44f7-82e6-1721955a82e0', '2024-05-08', 'Hadir', '', '110003'),
('7e7425e9-6cef-4abd-88eb-0a12916822cf', '2024-05-06', 'Hadir', '', '110006'),
('7f188277-75a8-48e9-8609-2d731f280db4', '2024-06-04', 'Hadir', '', '110008'),
('815b324f-ca25-430a-9dee-31d6dcab011f', '2024-05-29', 'Cuti', '', '110004'),
('81609c29-0729-4478-98ec-a99e5a44395f', '2024-05-03', 'Hadir', '', '110009'),
('81e7181a-b8d5-417b-9c23-e9262e530a94', '2024-05-02', 'Hadir', '', '110009'),
('83290ee3-1f3b-45c9-a2bd-0582ed4b59cb', '2024-06-05', 'Hadir', '', '110007'),
('855f6850-68f1-40f7-90cc-2307f81fff10', '2024-05-06', 'Hadir', '', '110007'),
('8561bf6a-b799-4c5e-9fbc-2b9cc6285dbf', '2024-05-22', 'Hadir', '', '110007'),
('860e51f1-5874-4195-9dde-f834a32ab1bf', '2024-05-20', 'Hadir', '', '110011'),
('861d6f5a-0c02-4d15-8925-38fe5c730420', '2024-05-03', 'Hadir', '', '110007'),
('88d98df3-45bb-447a-b1f3-3f96cecc8a2f', '2024-05-08', 'Hadir', '', '110010'),
('89973e10-0827-4123-9b1b-96ce12350e54', '2024-05-28', 'Hadir', '', '110006'),
('8ad739d8-8d9d-44e0-a202-116447e24bd7', '2024-05-21', 'Hadir', '', '110003'),
('8b2566f4-5929-4e43-9bd2-72833fe35ddd', '2024-06-04', 'Hadir', '', '110002'),
('8e438d37-6886-4a7d-b845-3d54837f60e6', '2024-05-14', 'Hadir', '', '110009'),
('90aab31d-8110-4a4f-ac5e-ccdfeef2acfe', '2024-05-06', 'Hadir', '', '110009'),
('914753ee-bf9a-4787-858b-0a6d290bbacd', '2024-06-06', 'Hadir', '', '110010'),
('92736a76-90b1-42b6-b77e-68e359325cad', '2024-05-22', 'Sakit', '', '110008'),
('94e67cd5-c1b5-420a-a54a-5b4348a65f62', '2024-05-21', 'Hadir', '', '110004'),
('950602b2-8957-4ddb-848b-3f4af5507c85', '2024-05-01', 'Hadir', '', '110007'),
('95f123b3-5fbf-4c6d-8445-7ceefc1a3c40', '2024-05-28', 'Hadir', '', '110009'),
('9678573e-fbee-42bd-917b-145de2eb1395', '2024-05-30', 'Hadir', '', '110008'),
('9a3bc76f-45d7-4f7d-bae8-0d9742a77e90', '2024-05-20', 'Hadir', '', '110010'),
('9a6e275b-78d2-4134-b3a0-d888c41e277f', '2024-05-21', 'Hadir', '', '110010'),
('9bbfdc9c-69c8-400d-84a1-fee9618a911f', '2024-05-17', 'Hadir', '', '110007'),
('9cb6c86a-b83e-4ab9-afc8-9b8c474c9246', '2024-05-20', 'Sakit', '', '110008'),
('9ccb0e39-58ad-47ea-974f-e560bc6cc408', '2024-05-02', 'Hadir', '', '110011'),
('9d7750fb-27a7-4afa-aeb1-7e059e2b5afd', '2024-05-02', 'Hadir', '', '110005'),
('9ea22a03-314b-4b56-9889-6d5232f2a338', '2024-06-03', 'Hadir', '', '110011'),
('9fe299a1-5e1c-477e-a363-5b6720e85e77', '2024-05-30', 'Cuti', '', '110007'),
('a06cd545-5c55-4cff-8d50-19e3e32d27b7', '2024-06-04', 'Hadir', '', '110005'),
('a0ea9413-00d7-49d0-a748-2195cdf88c87', '2024-05-14', 'Hadir', '', '110011'),
('a1f7d9f3-dd9c-497a-963f-3c4dd7b0658a', '2024-05-14', 'Hadir', '', '110006'),
('a73688a2-d83f-4107-88b5-ba173fa0d121', '2024-06-06', 'Hadir', '', '110005'),
('a808029a-3c48-4d89-bb20-531d221caa02', '2024-06-06', 'Hadir', '', '110004'),
('a8a7a2e4-c8b9-44e2-9ada-da45d6c98966', '2024-05-01', 'Hadir', '', '110009'),
('a94a7381-9795-434c-8052-45590bd1a5e1', '2024-05-15', 'Hadir', '', '110002'),
('aa46fdf7-9182-4cf3-a8b1-4c49117ef478', '2024-05-02', 'Hadir', '', '110007'),
('ab8e6109-5058-45cc-81ae-e1650d022263', '2024-06-04', 'Hadir', '', '110006'),
('af6d5d2d-dc62-48b3-a025-4438ccc82a0a', '2024-05-17', 'Hadir', '', '110003'),
('b192c5dc-e749-48d6-be11-2a54b0d671d7', '2024-06-04', 'Hadir', '', '110009'),
('b1a6cbe6-7978-4f89-b9a5-27c23dfd06f3', '2024-06-03', 'Hadir', '', '110006'),
('b2567f39-2d02-4d2d-a728-01bdc7afb91c', '2024-05-07', 'Hadir', '', '110011'),
('b31f9c02-15f2-40fb-9450-ae84e02802d4', '2024-05-02', 'Hadir', '', '110006'),
('b40c9fe8-181e-454b-bdc8-dc3b737a021c', '2024-05-24', 'Hadir', '', '110005'),
('bbd7488d-8a86-47b2-b7f6-90166fc6ef22', '2024-05-13', 'Hadir', '', '110005'),
('bc3e0b91-b396-4815-91a3-797de5e3942f', '2024-05-14', 'Hadir', '', '110002'),
('bda61520-9854-41ac-b88d-a345072e3119', '2024-05-13', 'Hadir', '', '110002'),
('be30dd15-4e86-4a8e-b134-f9b44aa45d50', '2024-05-30', 'Hadir', '', '110006'),
('be8fe698-cfa2-42d5-a191-eaee2ec902c4', '2024-06-07', 'Hadir', '', '110008'),
('bf2050f8-4975-4e3c-8e79-35444f531101', '2024-06-05', 'Hadir', '', '110003'),
('c0c42fd3-22f7-43f6-b039-f746a9e904f5', '2024-05-07', 'Hadir', '', '110004'),
('c103543d-dc18-481a-a7f1-80d77212bbbb', '2024-06-04', 'Hadir', '', '110007'),
('c121c613-643d-4006-b326-40a5cc482570', '2024-05-20', 'Hadir', '', '110004'),
('c1b8ac20-2588-4cc8-a45b-fd086469d501', '2024-05-31', 'Hadir', '', '110003'),
('c262d9c1-c18b-466e-b5fd-1d77e92df826', '2024-06-06', 'Hadir', '', '110002'),
('c30d69e6-e83b-4737-8dc5-f4140a9d9dc5', '2024-05-13', 'Hadir', '', '110006'),
('c4280646-33bf-4ec6-b185-0542ced24399', '2024-05-08', 'Hadir', '', '110007'),
('c5a7eb9c-2070-48a2-8415-cbc166c9fed2', '2024-05-03', 'Hadir', '', '110008'),
('c5c6e23b-3727-4c8d-9d3c-5eff071f4ec2', '2024-05-30', 'Hadir', '', '110005'),
('c63a5e84-ad58-4161-9d6d-f5002ce1a120', '2024-05-22', 'Hadir', '', '110002'),
('c833a3ff-0c03-4bb4-9a74-41ec35b39a99', '2024-05-01', 'Hadir', '', '110002'),
('ca1759a8-7e1f-427d-a753-78d438160362', '2024-05-08', 'Hadir', '', '110009'),
('cb565f36-7138-4bcc-a088-0e4e09aa4673', '2024-05-13', 'Hadir', '', '110003'),
('cc689705-fd19-4fb6-990a-9830ca580ff1', '2024-05-31', 'Hadir', '', '110005'),
('cd420fb4-3254-4e49-b8e8-43d25d9eec4d', '2024-05-14', 'Hadir', '', '110008'),
('cf277fba-cf31-4f83-8200-8ad6045ad1b0', '2024-05-29', 'Hadir', '', '110007'),
('d1ddc4a5-ce8c-406b-8ec6-6a973aef3ece', '2024-06-06', 'Hadir', '', '110011'),
('d22ba180-bdd8-4612-a59b-881cc49a3752', '2024-05-27', 'Hadir', '', '110010'),
('d3915663-ac9a-4eee-9bcd-c93e5e764f8b', '2024-06-04', 'Hadir', '', '110004'),
('d4cbebab-0e87-498c-a55e-c34c3a495a35', '2024-05-31', 'Hadir', '', '110009'),
('d4d97cfa-7dfc-4d9c-bdcc-989d310bb867', '2024-06-05', 'Hadir', '', '110011'),
('d5c4a666-087b-47d9-83d0-66c3997f55bd', '2024-05-20', 'Hadir', '', '110003'),
('d65cdc5d-e5b8-424f-a247-7327f749fcd8', '2024-05-21', 'Hadir', '', '110002'),
('d69ff52a-c9cb-4cee-a368-044df2f1e636', '2024-06-05', 'Hadir', '', '110010'),
('d6ca2367-7e2d-4955-8a6b-5eb1bb97935d', '2024-05-17', 'Hadir', '', '110004'),
('d6e258dc-a777-497a-87e6-e46589cd93d8', '2024-05-17', 'Hadir', '', '110005'),
('d768acb2-d87b-44c7-8f69-efb8ef14b859', '2024-05-29', 'Hadir', '', '110006'),
('d890ee4e-73fd-463f-8278-7bdd64522c44', '2024-05-20', 'Hadir', '', '110005'),
('d903507f-087f-4aad-9d1d-02efe53bd6ab', '2024-05-06', 'Hadir', '', '110003'),
('d94578ec-fd68-4f82-86de-c8e208f1203b', '2024-06-07', 'Hadir', '', '110009'),
('da37d89a-cb2d-4ecf-9df6-4cf782928596', '2024-05-27', 'Hadir', '', '110008'),
('daa29589-25fd-437e-9198-1ab182a0575b', '2024-06-04', 'Hadir', '', '110003'),
('dac81b70-4215-498a-92fb-2ac1709b5f64', '2024-06-07', 'Hadir', '', '110005'),
('db7d5598-e54b-4e2c-9da5-2f700ba6baf2', '2024-05-27', 'Hadir', '', '110004'),
('dbb1225e-5f84-4482-bc6a-fabd0694c8df', '2024-05-14', 'Hadir', '', '110004'),
('dc105337-df33-45df-a5d1-7599b26e295c', '2024-05-16', 'Hadir', '', '110004'),
('dc6d2ab1-bebe-4fe5-94d6-273971ca548f', '2024-05-13', 'Hadir', '', '110008'),
('ddfcce01-3d42-4791-9580-81806745d63a', '2024-05-22', 'Hadir', '', '110005'),
('df68e817-32bb-4fb3-8480-924d92e6761b', '2024-05-29', 'Sakit', '', '110005'),
('e2051237-8430-4cf8-9cb1-7f89b68f917a', '2024-05-13', 'Hadir', '', '110009'),
('e25948db-f803-40ad-a4a4-4bc203f46b82', '2024-06-03', 'Hadir', '', '110003'),
('e37cfa80-bf8f-4fa9-a02c-7ad297d7ba18', '2024-06-03', 'Hadir', '', '110004'),
('e48538b6-17ad-46a2-a1fd-a5299b4f494d', '2024-05-01', 'Hadir', '', '110006'),
('e4ae242d-522b-469a-b640-8f8faccd32e3', '2024-05-20', 'Hadir', '', '110002'),
('e4d58516-a5c1-48d4-b081-188a74c01a64', '2024-06-07', 'Hadir', '', '110003'),
('e51e690b-5e12-47e4-b9e9-a4b489f21637', '2024-05-01', 'Hadir', '', '110003'),
('e5a37a3a-e5bc-4375-a42e-0310673f6da2', '2024-05-20', 'Hadir', '', '110006'),
('e69b02f5-0e68-4789-b350-e9a7b9285d97', '2024-05-14', 'Hadir', '', '110007'),
('e8a37c2b-be38-4471-b68e-2a384f36d616', '2024-05-27', 'Hadir', '', '110003'),
('eb190d80-7905-4503-a58c-fbb24a352cea', '2024-05-03', 'Hadir', '', '110005'),
('ebfeac89-df1d-4d00-951d-21559327af28', '2024-06-05', 'Hadir', '', '110009'),
('ec190b37-af26-4e9b-be82-85977c24b799', '2024-05-29', 'Hadir', '', '110008'),
('ecc7c241-e1c2-4005-9eb8-2848ebefbff0', '2024-05-06', 'Hadir', '', '110011'),
('eccd1905-2b61-4fdf-9493-5d1c984021bf', '2024-06-03', 'Hadir', '', '110002'),
('ed204a1f-445a-4c05-b5d4-6a44840cd419', '2024-06-07', 'Hadir', '', '110011'),
('edcb56b1-367e-4b85-ad4f-aec85ebba2d0', '2024-05-28', 'Hadir', '', '110005'),
('ee86858e-128e-4864-a71e-fe1ba8c940fb', '2024-05-30', 'Hadir', '', '110010'),
('ef72f9e3-c62a-478d-9966-526d4a2e5f76', '2024-05-16', 'Hadir', '', '110005'),
('ef8e5f21-6ccf-4542-a8b5-28e3485fbceb', '2024-05-21', 'Hadir', '', '110005'),
('efe91d0e-f7bb-4aa9-bb24-85ba43c6858d', '2024-05-28', 'Hadir', '', '110007'),
('f1b49bc0-86e7-41a2-a6f9-9be669344314', '2024-05-15', 'Hadir', '', '110010'),
('f1b64050-47a4-4d87-b209-499785508c7b', '2024-05-22', 'Hadir', '', '110004'),
('f54bc80e-aaee-4b0a-a640-de18c2465a0c', '2024-05-30', 'Hadir', '', '110002'),
('f5e18664-3742-41a7-971a-d2c1589dd6ad', '2024-05-07', 'Hadir', '', '110006'),
('f85dd7f4-69bf-4b6d-820e-9014e55c6f5d', '2024-05-22', 'Hadir', '', '110006'),
('f8c92527-61b4-45b7-962c-90eb93a91ae2', '2024-06-05', 'Hadir', '', '110005'),
('f95424e7-9614-49d3-9228-5655d69e4acd', '2024-05-17', 'Hadir', '', '110011'),
('fbe56c08-6719-4de6-8f3d-42b997a0857b', '2024-05-15', 'Hadir', '', '110006'),
('fc1511f1-e871-4ccc-842f-046cff2c1447', '2024-05-16', 'Hadir', '', '110009'),
('fc292967-4a6d-4b8e-b1c3-ccb93a4943ab', '2024-05-22', 'Hadir', '', '110010');

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
