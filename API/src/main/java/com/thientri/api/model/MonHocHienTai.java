package com.thientri.api.model;

import java.util.Date;

public class MonHocHienTai {
	private long maMonHoc;
	
	private String tenMonHoc;
	
	private String ngayBatDau;
	
	private String ngayKetThuc;
	
	private String tenPhongHoc;
	
	private String gioBatDau;
	
	private String gioKetThuc;

	public MonHocHienTai(long maMonHoc, String tenMonHoc, String ngayBatDau, String ngayKetThuc, String tenPhongHoc,
			String gioBatDau, String gioKetThuc) {
		super();
		this.maMonHoc = maMonHoc;
		this.tenMonHoc = tenMonHoc;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.tenPhongHoc = tenPhongHoc;
		this.gioBatDau = gioBatDau;
		this.gioKetThuc = gioKetThuc;
	}

	public long getMaMonHoc() {
		return maMonHoc;
	}

	public void setMaMonHoc(long maMonHoc) {
		this.maMonHoc = maMonHoc;
	}

	public String getTenMonHoc() {
		return tenMonHoc;
	}

	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}

	public String getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(String ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public String getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(String ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	public String getTenPhongHoc() {
		return tenPhongHoc;
	}

	public void setTenPhongHoc(String tenPhongHoc) {
		this.tenPhongHoc = tenPhongHoc;
	}

	public String getGioBatDau() {
		return gioBatDau;
	}

	public void setGioBatDau(String gioBatDau) {
		this.gioBatDau = gioBatDau;
	}

	public String getGioKetThuc() {
		return gioKetThuc;
	}

	public void setGioKetThuc(String gioKetThuc) {
		this.gioKetThuc = gioKetThuc;
	}

	
}
