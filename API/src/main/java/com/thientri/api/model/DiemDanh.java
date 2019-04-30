package com.thientri.api.model;

import java.io.Serializable;
import java.util.Date;


public class DiemDanh implements Serializable{	
	private static final long serialVersionUID = 1L;


	private long maDiemDanh;


	private long maSinhVien;


	private Date ngayDiemDanh;


	private int soTietDiHoc;


	private int soTietVang;


	public DiemDanh(long maDiemDanh, long maSinhVien, Date ngayDiemDanh, int soTietDiHoc, int soTietVang) {
		super();
		this.maDiemDanh = maDiemDanh;
		this.maSinhVien = maSinhVien;
		this.ngayDiemDanh = ngayDiemDanh;
		this.soTietDiHoc = soTietDiHoc;
		this.soTietVang = soTietVang;
	}


	public long getMaDiemDanh() {
		return maDiemDanh;
	}


	public void setMaDiemDanh(long maDiemDanh) {
		this.maDiemDanh = maDiemDanh;
	}


	public long getMaSinhVien() {
		return maSinhVien;
	}


	public void setMaSinhVien(long maSinhVien) {
		this.maSinhVien = maSinhVien;
	}


	public Date getNgayDiemDanh() {
		return ngayDiemDanh;
	}


	public void setNgayDiemDanh(Date ngayDiemDanh) {
		this.ngayDiemDanh = ngayDiemDanh;
	}


	public int getSoTietDiHoc() {
		return soTietDiHoc;
	}


	public void setSoTietDiHoc(int soTietDiHoc) {
		this.soTietDiHoc = soTietDiHoc;
	}


	public int getSoTietVang() {
		return soTietVang;
	}


	public void setSoTietVang(int soTietVang) {
		this.soTietVang = soTietVang;
	}
	
	
}
