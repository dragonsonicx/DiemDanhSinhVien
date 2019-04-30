package com.thientri.api.model;

import java.io.Serializable;

public class PhongHoc implements Serializable{	
	private static final long serialVersionUID = 1L;

	private long maPhongHoc;

	private String tenPhongHoc;

	private int soChoNgoi;

	public PhongHoc(long maPhongHoc, String tenPhongHoc, int soChoNgoi) {
		super();
		this.maPhongHoc = maPhongHoc;
		this.tenPhongHoc = tenPhongHoc;
		this.soChoNgoi = soChoNgoi;
	}

	public long getMaPhongHoc() {
		return maPhongHoc;
	}

	public void setMaPhongHoc(long maPhongHoc) {
		this.maPhongHoc = maPhongHoc;
	}

	public String getTenPhongHoc() {
		return tenPhongHoc;
	}

	public void setTenPhongHoc(String tenPhongHoc) {
		this.tenPhongHoc = tenPhongHoc;
	}

	public int getSoChoNgoi() {
		return soChoNgoi;
	}

	public void setSoChoNgoi(int soChoNgoi) {
		this.soChoNgoi = soChoNgoi;
	}

}
