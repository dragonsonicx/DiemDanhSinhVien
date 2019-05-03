-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 03, 2019 at 06:14 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `diemdanhsinhvien`
--

-- --------------------------------------------------------

--
-- Table structure for table `cahoc`
--

CREATE TABLE `cahoc` (
  `macahoc` bigint(20) NOT NULL,
  `maphonghoc` bigint(20) DEFAULT NULL,
  `buoihoc` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `giobatdau` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `gioketthuc` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `mamonhoc` bigint(20) DEFAULT NULL,
  `thu` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci;

--
-- Dumping data for table `cahoc`
--

INSERT INTO `cahoc` (`macahoc`, `maphonghoc`, `buoihoc`, `giobatdau`, `gioketthuc`, `mamonhoc`, `thu`) VALUES
(1, 1, 'Sáng', '10:00', '12:30', 1, 2),
(2, 2, 'Chiều', '12:00', '14:45', 2, 7),
(3, 3, 'Chiều', '15:00', '5:30', 3, 7);

-- --------------------------------------------------------

--
-- Table structure for table `chitietdiemdanh`
--

CREATE TABLE `chitietdiemdanh` (
  `machitietdiemdanh` bigint(20) NOT NULL,
  `madiemdanh` int(11) NOT NULL,
  `lydonghi` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `ngaydiemdanh` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci;

--
-- Dumping data for table `chitietdiemdanh`
--

INSERT INTO `chitietdiemdanh` (`machitietdiemdanh`, `madiemdanh`, `lydonghi`, `status`, `ngaydiemdanh`) VALUES
(1, 1, NULL, b'1', '2019-04-18 00:00:00'),
(2, 2, NULL, b'1', '2019-04-28 00:00:00'),
(3, 1, NULL, b'1', '2019-04-28 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `diemdanh`
--

CREATE TABLE `diemdanh` (
  `madiemdanh` bigint(20) NOT NULL,
  `magiaovien` bigint(20) DEFAULT NULL,
  `masinhvien` int(11) NOT NULL,
  `mamonhoc` int(11) NOT NULL,
  `sotietdihoc` int(11) DEFAULT NULL,
  `sotietvang` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci;

--
-- Dumping data for table `diemdanh`
--

INSERT INTO `diemdanh` (`madiemdanh`, `magiaovien`, `masinhvien`, `mamonhoc`, `sotietdihoc`, `sotietvang`) VALUES
(1, 10052121, 15094631, 1, 20, 0),
(2, 10052121, 15022571, 2, 20, 0);

-- --------------------------------------------------------

--
-- Table structure for table `monhoc`
--

CREATE TABLE `monhoc` (
  `mamonhoc` bigint(20) NOT NULL,
  `chiso` int(11) DEFAULT NULL,
  `hocky` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `magiaovien` bigint(20) DEFAULT NULL,
  `namhoc` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `ngaybatdau` date DEFAULT NULL,
  `ngayketthuc` date DEFAULT NULL,
  `sotietlythuyet` int(11) DEFAULT NULL,
  `sotietthuchanh` int(11) DEFAULT NULL,
  `tenmonhoc` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `tongsotiet` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci;

--
-- Dumping data for table `monhoc`
--

INSERT INTO `monhoc` (`mamonhoc`, `chiso`, `hocky`, `magiaovien`, `namhoc`, `ngaybatdau`, `ngayketthuc`, `sotietlythuyet`, `sotietthuchanh`, `tenmonhoc`, `tongsotiet`) VALUES
(1, 3, '1', 10052121, '2019', '2019-04-01', '2019-04-30', 30, 30, 'Khoá luận tốt nghiệp', 60),
(2, 4, '1', 10052121, '2019', '2019-04-01', '2019-04-30', 30, 30, 'Kiến trúc máy tính', 60),
(3, 4, '1', 10052121, '2019', '2019-04-01', '2019-05-30', 45, 0, 'Tâm lý học đại cương', 45);

-- --------------------------------------------------------

--
-- Table structure for table `nguoidung`
--

CREATE TABLE `nguoidung` (
  `ma` bigint(20) NOT NULL,
  `chucvu` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `gioitinh` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `hinh` tinyblob,
  `matkhau` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `ngaysinh` datetime DEFAULT NULL,
  `sodienthoai` varchar(10) COLLATE utf8mb4_german2_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_german2_ci NOT NULL,
  `status` int(11) DEFAULT NULL,
  `ten` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `tenkhoa` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `tenlop` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `trinhdo` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci;

--
-- Dumping data for table `nguoidung`
--

INSERT INTO `nguoidung` (`ma`, `chucvu`, `gioitinh`, `hinh`, `matkhau`, `ngaysinh`, `sodienthoai`, `email`, `status`, `ten`, `tenkhoa`, `tenlop`, `trinhdo`) VALUES
(10052121, 'Giảng Viên', 'Nữ', NULL, '1', '1985-01-10 00:00:00', '', '', 1, 'Nguyễn Hoàng Oanh', 'CNTT', '', 'Tiến sĩ'),
(15022571, 'Sinh viên', 'Nam', NULL, '3', '1997-07-09 00:00:00', '0972983600', 'minhtri456minh@gmail.com', 0, 'Phạm Nguyễn Minh Trí', 'CNTT', 'DHCNTT11A', 'Đại học'),
(15094631, 'Sinh viên', 'Nam', NULL, '2', '1997-01-05 00:00:00', '0348868611', '', 0, 'Nguyễn Minh Thiên', 'CNTT', 'DHCNTT11A', 'Đại học');

-- --------------------------------------------------------

--
-- Table structure for table `phonghoc`
--

CREATE TABLE `phonghoc` (
  `maphonghoc` bigint(20) NOT NULL,
  `sochongoi` int(11) DEFAULT NULL,
  `tenphonghoc` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci;

--
-- Dumping data for table `phonghoc`
--

INSERT INTO `phonghoc` (`maphonghoc`, `sochongoi`, `tenphonghoc`) VALUES
(1, 50, 'A1.01'),
(2, 45, 'H6.03'),
(3, 50, 'V12.05');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cahoc`
--
ALTER TABLE `cahoc`
  ADD PRIMARY KEY (`macahoc`);

--
-- Indexes for table `chitietdiemdanh`
--
ALTER TABLE `chitietdiemdanh`
  ADD PRIMARY KEY (`machitietdiemdanh`);

--
-- Indexes for table `diemdanh`
--
ALTER TABLE `diemdanh`
  ADD PRIMARY KEY (`madiemdanh`);

--
-- Indexes for table `monhoc`
--
ALTER TABLE `monhoc`
  ADD PRIMARY KEY (`mamonhoc`);

--
-- Indexes for table `nguoidung`
--
ALTER TABLE `nguoidung`
  ADD PRIMARY KEY (`ma`);

--
-- Indexes for table `phonghoc`
--
ALTER TABLE `phonghoc`
  ADD PRIMARY KEY (`maphonghoc`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `chitietdiemdanh`
--
ALTER TABLE `chitietdiemdanh`
  MODIFY `machitietdiemdanh` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
