-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th4 07, 2019 lúc 07:32 PM
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
  `ma_ca_hoc` bigint(20) NOT NULL,
  `buoi_hoc` varchar(255) COLLATE utf8_german2_ci DEFAULT NULL,
  `gio_bat_dau` varchar(255) COLLATE utf8_german2_ci DEFAULT NULL,
  `gio_ket_thuc` varchar(255) COLLATE utf8_german2_ci DEFAULT NULL,
  `ma_mon_hoc` bigint(20) DEFAULT NULL,
  `ma_phong_hoc` bigint(20) DEFAULT NULL,
  `thu` varchar(255) COLLATE utf8_german2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_german2_ci;

--
-- Đang đổ dữ liệu cho bảng `cahoc`
--

INSERT INTO `cahoc` (`ma_ca_hoc`, `buoi_hoc`, `gio_bat_dau`, `gio_ket_thuc`, `ma_mon_hoc`, `ma_phong_hoc`, `thu`) VALUES
(1, 'Sáng', '7h00', '9h30', 4203000959, 1, '2');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietdiemdanh`
--

CREATE TABLE `chitietdiemdanh` (
  `ma_diem_danh` bigint(20) NOT NULL,
  `buoi_hoc` varchar(255) COLLATE utf8_german2_ci DEFAULT NULL,
  `gio_bat_dau` varchar(255) COLLATE utf8_german2_ci DEFAULT NULL,
  `gio_ket_thuc` varchar(255) COLLATE utf8_german2_ci DEFAULT NULL,
  `ly_do_nghi` varchar(255) COLLATE utf8_german2_ci DEFAULT NULL,
  `ten_giao_vien` varchar(255) COLLATE utf8_german2_ci DEFAULT NULL,
  `ten_mon_hoc` varchar(255) COLLATE utf8_german2_ci DEFAULT NULL,
  `thu` varchar(255) COLLATE utf8_german2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_german2_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `diemdanh`
--

CREATE TABLE `diemdanh` (
  `ma_diem_danh` bigint(20) NOT NULL,
  `ma_sinh_vien` bigint(20) DEFAULT NULL,
  `ngay_diem_danh` datetime DEFAULT NULL,
  `so_tiet_di_hoc` int(11) DEFAULT NULL,
  `so_tiet_vang` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_german2_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `giaovien`
--

CREATE TABLE `giaovien` (
  `ma_giao_vien` bigint(20) NOT NULL,
  `chuc_vu` varchar(255) COLLATE utf8_german2_ci DEFAULT NULL,
  `gioi_tinh` varchar(255) COLLATE utf8_german2_ci DEFAULT NULL,
  `hinh_giao_vien` tinyblob,
  `mat_khau` varchar(255) COLLATE utf8_german2_ci DEFAULT NULL,
  `ngay_sinh` date DEFAULT NULL,
  `ten_giao_vien` varchar(255) COLLATE utf8_german2_ci DEFAULT NULL,
  `ten_khoa` varchar(255) COLLATE utf8_german2_ci DEFAULT NULL,
  `trinh_do` varchar(255) COLLATE utf8_german2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_german2_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_german2_ci;

--
-- Đang đổ dữ liệu cho bảng `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `lich_day`
--

CREATE TABLE `lich_day` (
  `ma_mon_hoc` bigint(20) NOT NULL,
  `buoi_hoc` varchar(255) COLLATE utf8_german2_ci DEFAULT NULL,
  `chi_so` int(11) NOT NULL,
  `gio_bat_dau` varchar(255) COLLATE utf8_german2_ci DEFAULT NULL,
  `gio_ket_thuc` varchar(255) COLLATE utf8_german2_ci DEFAULT NULL,
  `hoc_ky` varchar(255) COLLATE utf8_german2_ci DEFAULT NULL,
  `ma_nguoi_dung` bigint(20) NOT NULL,
  `nam_hoc` int(11) NOT NULL,
  `ngay_bat_dau` date DEFAULT NULL,
  `ngay_ket_thuc` date DEFAULT NULL,
  `so_cho_ngoi` int(11) NOT NULL,
  `so_tiet_ly_thuyet` int(11) NOT NULL,
  `so_tiet_thuc_hanh` int(11) NOT NULL,
  `ten_mon_hoc` varchar(255) COLLATE utf8_german2_ci DEFAULT NULL,
  `ten_phong_hoc` varchar(255) COLLATE utf8_german2_ci DEFAULT NULL,
  `thu` varchar(255) COLLATE utf8_german2_ci DEFAULT NULL,
  `tong_so_tiet` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_german2_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `monhoc`
--

CREATE TABLE `monhoc` (
  `ma_mon_hoc` bigint(20) NOT NULL,
  `chi_so` int(11) DEFAULT NULL,
  `hoc_ky` varchar(255) COLLATE utf8_german2_ci DEFAULT NULL,
  `ma_giao_vien` bigint(20) DEFAULT NULL,
  `nam_hoc` int(11) DEFAULT NULL,
  `ngay_bat_dau` date DEFAULT NULL,
  `ngay_ket_thuc` date DEFAULT NULL,
  `so_tiet_ly_thuyet` int(11) DEFAULT NULL,
  `so_tiet_thuc_hanh` int(11) DEFAULT NULL,
  `ten_mon_hoc` varchar(255) COLLATE utf8_german2_ci DEFAULT NULL,
  `tong_so_tiet` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_german2_ci;

--
-- Đang đổ dữ liệu cho bảng `monhoc`
--

INSERT INTO `monhoc` (`ma_mon_hoc`, `chi_so`, `hoc_ky`, `ma_giao_vien`, `nam_hoc`, `ngay_bat_dau`, `ngay_ket_thuc`, `so_tiet_ly_thuyet`, `so_tiet_thuc_hanh`, `ten_mon_hoc`, `tong_so_tiet`) VALUES
(4203000959, 3, '1', 10039791, 2018, '2019-08-01', '2019-11-04', 30, 30, 'Triển khai an ninh hệ thống', 60);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nguoidung`
--

CREATE TABLE `nguoidung` (
  `ma` bigint(20) NOT NULL,
  `chuc_vu` varchar(255) COLLATE utf8_german2_ci DEFAULT NULL,
  `gioi_tinh` varchar(255) COLLATE utf8_german2_ci DEFAULT NULL,
  `mat_khau` varchar(255) COLLATE utf8_german2_ci DEFAULT NULL,
  `ngay_sinh` date DEFAULT NULL,
  `ten` varchar(255) COLLATE utf8_german2_ci DEFAULT NULL,
  `ten_khoa` varchar(255) COLLATE utf8_german2_ci DEFAULT NULL,
  `ten_lop` varchar(255) COLLATE utf8_german2_ci DEFAULT NULL,
  `trinh_do` varchar(255) COLLATE utf8_german2_ci DEFAULT NULL,
  `hinh` tinyblob,
  `status` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_german2_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phonghoc`
--

CREATE TABLE `phonghoc` (
  `ma_phong_hoc` bigint(20) NOT NULL,
  `so_cho_ngoi` int(11) DEFAULT NULL,
  `ten_phong_hoc` varchar(255) COLLATE utf8_german2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_german2_ci;

--
-- Đang đổ dữ liệu cho bảng `phonghoc`
--

INSERT INTO `phonghoc` (`ma_phong_hoc`, `so_cho_ngoi`, `ten_phong_hoc`) VALUES
(1, 70, 'A1-01');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sinhvien`
--

CREATE TABLE `sinhvien` (
  `ma_sinh_vien` bigint(20) NOT NULL,
  `gioi_tinh` varchar(255) COLLATE utf8_german2_ci DEFAULT NULL,
  `hinh_sinh_vien` tinyblob,
  `mat_khau` varchar(255) COLLATE utf8_german2_ci DEFAULT NULL,
  `ngay_sinh` date DEFAULT NULL,
  `ten_lop` varchar(255) COLLATE utf8_german2_ci DEFAULT NULL,
  `ten_sinh_vien` varchar(255) COLLATE utf8_german2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_german2_ci;

--
-- Đang đổ dữ liệu cho bảng `sinhvien`
--

INSERT INTO `sinhvien` (`ma_sinh_vien`, `gioi_tinh`, `hinh_sinh_vien`, `mat_khau`, `ngay_sinh`, `ten_lop`, `ten_sinh_vien`) VALUES
(15094631, 'Nam', NULL, '12345', '1997-01-05', 'DHCNTT11A', 'Nguyễn Minh Thiên');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `cahoc`
--
ALTER TABLE `cahoc`
  ADD PRIMARY KEY (`ma_ca_hoc`);

--
-- Chỉ mục cho bảng `chitietdiemdanh`
--
ALTER TABLE `chitietdiemdanh`
  ADD PRIMARY KEY (`ma_diem_danh`);

--
-- Chỉ mục cho bảng `diemdanh`
--
ALTER TABLE `diemdanh`
  ADD PRIMARY KEY (`ma_diem_danh`);

--
-- Chỉ mục cho bảng `giaovien`
--
ALTER TABLE `giaovien`
  ADD PRIMARY KEY (`ma_giao_vien`);

--
-- Chỉ mục cho bảng `lich_day`
--
ALTER TABLE `lich_day`
  ADD PRIMARY KEY (`ma_mon_hoc`);

--
-- Chỉ mục cho bảng `monhoc`
--
ALTER TABLE `monhoc`
  ADD PRIMARY KEY (`ma_mon_hoc`);

--
-- Chỉ mục cho bảng `nguoidung`
--
ALTER TABLE `nguoidung`
  ADD PRIMARY KEY (`ma`);

--
-- Chỉ mục cho bảng `phonghoc`
--
ALTER TABLE `phonghoc`
  ADD PRIMARY KEY (`ma_phong_hoc`);

--
-- Chỉ mục cho bảng `sinhvien`
--
ALTER TABLE `sinhvien`
  ADD PRIMARY KEY (`ma_sinh_vien`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
