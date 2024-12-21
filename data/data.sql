-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               11.5.2-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for stt_16_21011251_tranquochuy
CREATE DATABASE IF NOT EXISTS `stt_16_21011251_tranquochuy` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `stt_16_21011251_tranquochuy`;

-- Dumping structure for table stt_16_21011251_tranquochuy.flight
CREATE TABLE IF NOT EXISTS `flight` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `airplane_name` varchar(255) NOT NULL,
  `arrival_airport` varchar(255) NOT NULL,
  `arrival_date` date DEFAULT NULL,
  `departure_airport` varchar(255) NOT NULL,
  `departure_date` date DEFAULT NULL,
  `flight_status` bit(1) DEFAULT NULL,
  `seat_fare` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table stt_16_21011251_tranquochuy.flight: ~22 rows (approximately)
INSERT INTO `flight` (`id`, `airplane_name`, `arrival_airport`, `arrival_date`, `departure_airport`, `departure_date`, `flight_status`, `seat_fare`) VALUES
	(1, 'Airbus 0001', 'Noi bai Airport', '2024-12-23', 'Tan son nhat Airport', '2024-12-22', b'1', 15.9),
	(2, 'Airbus 0002', 'Ha Noi Airport', '2024-12-25', 'Tay Ninh Airport', '2024-12-23', b'0', 12),
	(4, 'Boeing 0002', 'HELLO Airport', '2024-12-25', 'ALO Airport', '2024-12-22', b'0', 13.7),
	(11, 'Airbus 0002', 'Tay Ninh Airport', '2024-12-21', 'Tay Ninh Airport', '2024-12-21', b'0', 15),
	(14, 'Airbus 0001', 'Tay Ninh Airport', '2024-12-22', 'Tay Ninh Airport', '2024-12-22', b'1', 15),
	(15, 'Boeing 0002', 'Tay Ninh Airport', '2024-12-22', 'Tay Ninh Airport', '2024-12-27', b'1', 15),
	(16, 'Boeing 0002', 'Tay Ninh Airport', '2024-12-22', 'Tay Ninh Airport', '2024-12-27', b'0', 15),
	(17, 'Boeing 0002', 'Tay Ninh Airport', '2024-12-22', 'Tay Ninh Airport', '2024-12-27', b'1', 15),
	(18, 'Boeing 0002', 'Tay Ninh Airport', '2024-12-22', 'Tay Ninh Airport', '2024-12-27', b'1', 15),
	(19, 'Airbus 0001', 'Tay Ninh Airport', '2024-12-22', 'Tay Ninh Airport', '2024-12-22', b'1', 15),
	(20, 'Airbus 0001', 'Tay Ninh Airport', '2024-12-28', 'Tay Ninh Airport', '2024-12-28', b'0', 99),
	(21, 'Airbus 0001', 'Tay Ninh Airport', '2024-12-28', 'Tay Ninh Airport', '2024-12-28', b'1', 12),
	(22, 'Airbus 0001', 'Tay Ninh Airport', '2024-12-28', 'Tay Ninh Airport', '2024-12-28', b'0', 12),
	(23, 'Airbus 0001', 'Tay Ninh Airport', '2024-12-28', 'Tay Ninh Airport', '2024-12-26', b'0', 12),
	(24, 'Airbus 0001', 'Tay Ninh Airport', '2024-12-28', 'Tay Ninh Airport', '2024-12-28', b'0', 12),
	(25, 'Airbus 0001', 'Tay Ninh Airport', '2024-12-28', 'Tay Ninh Airport', '2024-12-28', b'0', 12),
	(26, 'Airbus 0001', 'Tay Ninh Airport', '2024-12-28', 'Tay Ninh Airport', '2024-12-28', b'0', 15),
	(27, 'Airbus 0001', 'Tay Ninh Airport', '2024-12-28', 'Tay Ninh Airport', '2024-12-28', b'0', 12),
	(28, 'Airbus 0001', 'Tay Ninh Airport', '2024-12-28', 'Tay Ninh Airport', '2024-12-28', b'0', 12),
	(29, 'Airbus 0001', 'Tay Ninh Airport', '2024-12-28', 'Tay Ninh Airport', '2024-12-28', b'0', 12),
	(30, 'Boeing 0002', 'Tay Ninh Airport 2', '2024-12-28', 'Tay Ninh Airport 2', '2024-12-22', b'1', 12),
	(31, 'Airbus 0001', 'Tay Ninh Airport 3', '2024-12-30', 'Tay Ninh Airport 3', '2025-01-03', b'1', 15);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
