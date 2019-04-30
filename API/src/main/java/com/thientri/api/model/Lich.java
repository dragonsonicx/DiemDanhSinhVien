package com.thientri.api.model;

import java.io.Serializable;
import java.util.Date;


public class Lich implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	
	private long maNguoiDung;
	
	private String tenMonHoc;
	
	private String tenNguoiDung;
	
	private String hocKy;
	
	private int namHoc;
	
	private String gioBatDau;

	private String gioKetThuc;

	private String buoiHoc;
	
	private String tenPhongHoc;

	private int thu;
	
	private String ngayBatDau;
	
	private String ngayKetThuc;

	public Lich(long maNguoiDung, String tenMonHoc, String tenNguoiDung, String hocKy, int namHoc, String gioBatDau,
			String gioKetThuc, String buoiHoc, String tenPhongHoc, int thu, String ngayBatDau, String ngayKetThuc) {
		super();
		this.maNguoiDung = maNguoiDung;
		this.tenMonHoc = tenMonHoc;
		this.tenNguoiDung = tenNguoiDung;
		this.hocKy = hocKy;
		this.namHoc = namHoc;
		this.gioBatDau = gioBatDau;
		this.gioKetThuc = gioKetThuc;
		this.buoiHoc = buoiHoc;
		this.tenPhongHoc = tenPhongHoc;
		this.thu = thu;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
	}

	public long getMaNguoiDung() {
		return maNguoiDung;
	}

	public void setMaNguoiDung(long maNguoiDung) {
		this.maNguoiDung = maNguoiDung;
	}

	public String getTenMonHoc() {
		return tenMonHoc;
	}

	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}

	public String getTenNguoiDung() {
		return tenNguoiDung;
	}

	public void setTenNguoiDung(String tenNguoiDung) {
		this.tenNguoiDung = tenNguoiDung;
	}

	public String getHocKy() {
		return hocKy;
	}

	public void setHocKy(String hocKy) {
		this.hocKy = hocKy;
	}

	public int getNamHoc() {
		return namHoc;
	}

	public void setNamHoc(int namHoc) {
		this.namHoc = namHoc;
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

	public String getBuoiHoc() {
		return buoiHoc;
	}

	public void setBuoiHoc(String buoiHoc) {
		this.buoiHoc = buoiHoc;
	}

	public String getTenPhongHoc() {
		return tenPhongHoc;
	}

	public void setTenPhongHoc(String tenPhongHoc) {
		this.tenPhongHoc = tenPhongHoc;
	}

	public int getThu() {
		return thu;
	}

	public void setThu(int thu) {
		this.thu = thu;
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

	
}
