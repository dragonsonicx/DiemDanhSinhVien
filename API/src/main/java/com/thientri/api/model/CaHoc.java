package com.thientri.api.model;

import java.io.Serializable;

public class CaHoc implements Serializable{	
	private static final long serialVersionUID = 1L;

	private long maCaHoc;
	
	private long maMonHoc;

	private long maPhongHoc;

	private String gioBatDau;

	private String gioKetThuc;

	private String buoiHoc;

	private int thu;
	
	private int tiet;

	public CaHoc(long maCaHoc, long maMonHoc, long maPhongHoc, String gioBatDau, String gioKetThuc, String buoiHoc,
			int thu, int tiet) {
		super();
		this.maCaHoc = maCaHoc;
		this.maMonHoc = maMonHoc;
		this.maPhongHoc = maPhongHoc;
		this.gioBatDau = gioBatDau;
		this.gioKetThuc = gioKetThuc;
		this.buoiHoc = buoiHoc;
		this.thu = thu;
		this.tiet = tiet;
	}

	public long getMaCaHoc() {
		return maCaHoc;
	}

	public void setMaCaHoc(long maCaHoc) {
		this.maCaHoc = maCaHoc;
	}

	public long getMaMonHoc() {
		return maMonHoc;
	}

	public void setMaMonHoc(long maMonHoc) {
		this.maMonHoc = maMonHoc;
	}

	public long getMaPhongHoc() {
		return maPhongHoc;
	}

	public void setMaPhongHoc(long maPhongHoc) {
		this.maPhongHoc = maPhongHoc;
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

	public int getThu() {
		return thu;
	}

	public void setThu(int thu) {
		this.thu = thu;
	}

	public int getTiet() {
		return tiet;
	}

	public void setTiet(int tiet) {
		this.tiet = tiet;
	}

	
}
