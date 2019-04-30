-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th4 28, 2019 lúc 07:19 AM
-- Phiên bản máy phục vụ: 10.1.37-MariaDB
-- Phiên bản PHP: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `diemdanhsinhvien`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cahoc`
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
-- Đang đổ dữ liệu cho bảng `cahoc`
--

INSERT INTO `cahoc` (`macahoc`, `maphonghoc`, `buoihoc`, `giobatdau`, `gioketthuc`, `mamonhoc`, `thu`) VALUES
(1, 1, 'Sáng', '10:00', '12:30', 1, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietdiemdanh`
--

CREATE TABLE `chitietdiemdanh` (
  `machitietdiemdanh` bigint(20) NOT NULL,
  `madiemdanh` int(11) NOT NULL,
  `lydonghi` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `ngaydiemdanh` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci;

--
-- Đang đổ dữ liệu cho bảng `chitietdiemdanh`
--

INSERT INTO `chitietdiemdanh` (`machitietdiemdanh`, `madiemdanh`, `lydonghi`, `status`, `ngaydiemdanh`) VALUES
(1, 1, NULL, b'1', '2019-04-18 00:00:00'),
(2, 1, NULL, b'1', '2019-04-28 00:00:00');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `diemdanh`
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
-- Đang đổ dữ liệu cho bảng `diemdanh`
--

INSERT INTO `diemdanh` (`madiemdanh`, `magiaovien`, `masinhvien`, `mamonhoc`, `sotietdihoc`, `sotietvang`) VALUES
(1, 10052121, 15094631, 1, 20, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `monhoc`
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
-- Đang đổ dữ liệu cho bảng `monhoc`
--

INSERT INTO `monhoc` (`mamonhoc`, `chiso`, `hocky`, `magiaovien`, `namhoc`, `ngaybatdau`, `ngayketthuc`, `sotietlythuyet`, `sotietthuchanh`, `tenmonhoc`, `tongsotiet`) VALUES
(1, 3, '1', 10052121, '2019', '2019-04-01', '2019-04-30', 30, 30, 'OOP', 60);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nguoidung`
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
-- Đang đổ dữ liệu cho bảng `nguoidung`
--

INSERT INTO `nguoidung` (`ma`, `chucvu`, `gioitinh`, `hinh`, `matkhau`, `ngaysinh`, `sodienthoai`, `email`, `status`, `ten`, `tenkhoa`, `tenlop`, `trinhdo`) VALUES
(10052121, 'Giảng Viên', 'Nữ', NULL, 'abc', '1985-01-10 00:00:00', '', '', 1, 'Nguyễn Hoàng Oanh', 'CNTT', '', 'Tiến sỉ'),
(15094631, 'Sinh viên', 'Nam', NULL, 'zzz', '1997-01-05 00:00:00', '', '', 0, 'Nguyễn Minh Thiên', 'CNTT', 'DHCNTT11A', 'Đại học');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phonghoc`
--

CREATE TABLE `phonghoc` (
  `maphonghoc` bigint(20) NOT NULL,
  `sochongoi` int(11) DEFAULT NULL,
  `tenphonghoc` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci;

--
-- Đang đổ dữ liệu cho bảng `phonghoc`
--

INSERT INTO `phonghoc` (`maphonghoc`, `sochongoi`, `tenphonghoc`) VALUES
(1, 50, 'A1-01');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `cahoc`
--
ALTER TABLE `cahoc`
  ADD PRIMARY KEY (`macahoc`);

--
-- Chỉ mục cho bảng `chitietdiemdanh`
--
ALTER TABLE `chitietdiemdanh`
  ADD PRIMARY KEY (`machitietdiemdanh`);

--
-- Chỉ mục cho bảng `diemdanh`
--
ALTER TABLE `diemdanh`
  ADD PRIMARY KEY (`madiemdanh`);

--
-- Chỉ mục cho bảng `monhoc`
--
ALTER TABLE `monhoc`
  ADD PRIMARY KEY (`mamonhoc`);

--
-- Chỉ mục cho bảng `nguoidung`
--
ALTER TABLE `nguoidung`
  ADD PRIMARY KEY (`ma`);

--
-- Chỉ mục cho bảng `phonghoc`
--
ALTER TABLE `phonghoc`
  ADD PRIMARY KEY (`maphonghoc`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `chitietdiemdanh`
--
ALTER TABLE `chitietdiemdanh`
  MODIFY `machitietdiemdanh` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
