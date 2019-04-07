package com.thientri.diemdanhsv.domain.entity;

import java.io.Serializable;
import java.time.LocalDate;


public class LichDay implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	
	private long MaMonHoc;
	
	private long MaNguoiDung;
	
	private String TenMonHoc;
	
	private int TongSoTiet;
	
	private int SoTietLyThuyet;
	
	private int SoTietThucHanh;
	
	private String HocKy;
	
	private int NamHoc;
	
	private int ChiSo;

	private String GioBatDau;

	private String GioKetThuc;

	private String BuoiHoc;
	
	private String TenPhongHoc;

	private int SoChoNgoi;
	
	private String Thu;
	
	private LocalDate NgayBatDau;
	
	private LocalDate NgayKetThuc;

	public String getThu() {
		return Thu;
	}

	public void setThu(String thu) {
		Thu = thu;
	}

	public long getMaMonHoc() {
		return MaMonHoc;
	}

	public void setMaMonHoc(long maMonHoc) {
		MaMonHoc = maMonHoc;
	}

	public long getMaNguoiDung() {
		return MaNguoiDung;
	}

	public void setMaNguoiDung(long maNguoiDung) {
		MaNguoiDung = maNguoiDung;
	}

	public String getTenMonHoc() {
		return TenMonHoc;
	}

	public void setTenMonHoc(String tenMonHoc) {
		TenMonHoc = tenMonHoc;
	}

	public int getTongSoTiet() {
		return TongSoTiet;
	}

	public void setTongSoTiet(int tongSoTiet) {
		TongSoTiet = tongSoTiet;
	}

	public int getSoTietLyThuyet() {
		return SoTietLyThuyet;
	}

	public void setSoTietLyThuyet(int soTietLyThuyet) {
		SoTietLyThuyet = soTietLyThuyet;
	}

	public int getSoTietThucHanh() {
		return SoTietThucHanh;
	}

	public void setSoTietThucHanh(int soTietThucHanh) {
		SoTietThucHanh = soTietThucHanh;
	}

	public String getHocKy() {
		return HocKy;
	}

	public void setHocKy(String hocKy) {
		HocKy = hocKy;
	}

	public int getNamHoc() {
		return NamHoc;
	}

	public void setNamHoc(int namHoc) {
		NamHoc = namHoc;
	}

	public int getChiSo() {
		return ChiSo;
	}

	public void setChiSo(int chiSo) {
		ChiSo = chiSo;
	}

	public String getGioBatDau() {
		return GioBatDau;
	}

	public void setGioBatDau(String gioBatDau) {
		GioBatDau = gioBatDau;
	}

	public String getGioKetThuc() {
		return GioKetThuc;
	}

	public void setGioKetThuc(String gioKetThuc) {
		GioKetThuc = gioKetThuc;
	}

	public String getBuoiHoc() {
		return BuoiHoc;
	}

	public void setBuoiHoc(String buoiHoc) {
		BuoiHoc = buoiHoc;
	}

	public String getTenPhongHoc() {
		return TenPhongHoc;
	}

	public void setTenPhongHoc(String tenPhongHoc) {
		TenPhongHoc = tenPhongHoc;
	}

	public int getSoChoNgoi() {
		return SoChoNgoi;
	}

	public void setSoChoNgoi(int soChoNgoi) {
		SoChoNgoi = soChoNgoi;
	}

	public LocalDate getNgayBatDau() {
		return NgayBatDau;
	}

	public void setNgayBatDau(LocalDate ngayBatDau) {
		NgayBatDau = ngayBatDau;
	}

	public LocalDate getNgayKetThuc() {
		return NgayKetThuc;
	}

	public void setNgayKetThuc(LocalDate ngayKetThuc) {
		NgayKetThuc = ngayKetThuc;
	}
	
}
