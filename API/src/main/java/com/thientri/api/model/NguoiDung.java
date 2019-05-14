package com.thientri.api.model;

import java.io.Serializable;
import java.util.Date;

public class NguoiDung implements Serializable{	
	private static final long serialVersionUID = 1L;

		private long maNguoiDung;
		

		private String tenNguoiDung;
		
		private String hinh;
		
		private String ngaySinh;
		
		private String sodienthoai;
		
		private String email;
		
		private String gioiTinh;
		
		private String tenLop;

		private String trinhDo;
		
		private String chucVu;
		
		private String tenKhoa;

		private String matKhau;

		private int status;

		public NguoiDung(long maNguoiDung, String tenNguoiDung, String hinh, String ngaySinh, String sodienthoai,
				String email, String gioiTinh, String tenLop, String trinhDo, String chucVu, String tenKhoa,
				String matKhau, int status) {
			super();
			this.maNguoiDung = maNguoiDung;
			this.tenNguoiDung = tenNguoiDung;
			this.hinh = hinh;
			this.ngaySinh = ngaySinh;
			this.sodienthoai = sodienthoai;
			this.email = email;
			this.gioiTinh = gioiTinh;
			this.tenLop = tenLop;
			this.trinhDo = trinhDo;
			this.chucVu = chucVu;
			this.tenKhoa = tenKhoa;
			this.matKhau = matKhau;
			this.status = status;
		}

		public long getMaNguoiDung() {
			return maNguoiDung;
		}

		public void setMaNguoiDung(long maNguoiDung) {
			this.maNguoiDung = maNguoiDung;
		}

		public String getTenNguoiDung() {
			return tenNguoiDung;
		}

		public void setTenNguoiDung(String tenNguoiDung) {
			this.tenNguoiDung = tenNguoiDung;
		}

		public String getHinh() {
			return hinh;
		}

		public void setHinh(String hinh) {
			this.hinh = hinh;
		}

		public String getNgaySinh() {
			return ngaySinh;
		}

		public void setNgaySinh(String ngaySinh) {
			this.ngaySinh = ngaySinh;
		}

		public String getSodienthoai() {
			return sodienthoai;
		}

		public void setSodienthoai(String sodienthoai) {
			this.sodienthoai = sodienthoai;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getGioiTinh() {
			return gioiTinh;
		}

		public void setGioiTinh(String gioiTinh) {
			this.gioiTinh = gioiTinh;
		}

		public String getTenLop() {
			return tenLop;
		}

		public void setTenLop(String tenLop) {
			this.tenLop = tenLop;
		}

		public String getTrinhDo() {
			return trinhDo;
		}

		public void setTrinhDo(String trinhDo) {
			this.trinhDo = trinhDo;
		}

		public String getChucVu() {
			return chucVu;
		}

		public void setChucVu(String chucVu) {
			this.chucVu = chucVu;
		}

		public String getTenKhoa() {
			return tenKhoa;
		}

		public void setTenKhoa(String tenKhoa) {
			this.tenKhoa = tenKhoa;
		}

		public String getMatKhau() {
			return matKhau;
		}

		public void setMatKhau(String matKhau) {
			this.matKhau = matKhau;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		
		
}
