package com.thientri.api.model;

import java.io.Serializable;
import java.time.LocalDate;

public class MonHoc implements Serializable{	
	private static final long serialVersionUID = 1L;

	private long maMonHoc;
	
	private long maGiaoVien;

	private String tenMonHoc;

	private int soTietLyThuyet;

	private int soTietThucHanh;

	private String hocKy;

	private String namHoc;

	private int chiSo;

	private LocalDate ngayBatDau;

	private LocalDate ngayKetThuc;

	public MonHoc(long maMonHoc, long maGiaoVien, String tenMonHoc, int soTietLyThuyet, int soTietThucHanh,
			String hocKy, String namHoc, int chiSo, LocalDate ngayBatDau, LocalDate ngayKetThuc) {
		super();
		this.maMonHoc = maMonHoc;
		this.maGiaoVien = maGiaoVien;
		this.tenMonHoc = tenMonHoc;
		this.soTietLyThuyet = soTietLyThuyet;
		this.soTietThucHanh = soTietThucHanh;
		this.hocKy = hocKy;
		this.namHoc = namHoc;
		this.chiSo = chiSo;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
	}

	public long getMaMonHoc() {
		return maMonHoc;
	}

	public void setMaMonHoc(long maMonHoc) {
		this.maMonHoc = maMonHoc;
	}

	public long getMaGiaoVien() {
		return maGiaoVien;
	}

	public void setMaGiaoVien(long maGiaoVien) {
		this.maGiaoVien = maGiaoVien;
	}

	public String getTenMonHoc() {
		return tenMonHoc;
	}

	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}

	public int getSoTietLyThuyet() {
		return soTietLyThuyet;
	}

	public void setSoTietLyThuyet(int soTietLyThuyet) {
		this.soTietLyThuyet = soTietLyThuyet;
	}

	public int getSoTietThucHanh() {
		return soTietThucHanh;
	}

	public void setSoTietThucHanh(int soTietThucHanh) {
		this.soTietThucHanh = soTietThucHanh;
	}

	public String getHocKy() {
		return hocKy;
	}

	public void setHocKy(String hocKy) {
		this.hocKy = hocKy;
	}

	public String getNamHoc() {
		return namHoc;
	}

	public void setNamHoc(String namHoc) {
		this.namHoc = namHoc;
	}

	public int getChiSo() {
		return chiSo;
	}

	public void setChiSo(int chiSo) {
		this.chiSo = chiSo;
	}

	public LocalDate getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(LocalDate ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public LocalDate getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(LocalDate ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	
}
