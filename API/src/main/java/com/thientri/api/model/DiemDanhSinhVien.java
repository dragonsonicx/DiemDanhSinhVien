package com.thientri.api.model;

public class DiemDanhSinhVien {
	private String ngayDiemDanh;
	
	private boolean status;

	public DiemDanhSinhVien(String ngayDiemDanh, boolean status) {
		this.ngayDiemDanh = ngayDiemDanh;
		this.status = status;
	}

	public String getNgayDiemDanh() {
		return ngayDiemDanh;
	}

	public void setNgayDiemDanh(String ngayDiemDanh) {
		this.ngayDiemDanh = ngayDiemDanh;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
