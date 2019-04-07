package com.thientri.diemdanhsv.domain.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "nguoidung")
@Getter @Setter @NoArgsConstructor
public class NguoiDung implements Serializable{	
	private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		
		@Column(name="Ma")
		private long Ma;
		
		@Column(name="Ten")
		private String Ten;
		
		@Column(name="Hinh")
		private byte[] hinh;
		
		@Column(name="NgaySinh")
		private LocalDate NgaySinh;
		
		@Column(name="GioiTinh")
		private String GioiTinh;
		
		@Column(name="TenLop")
		private String TenLop;
		
		@Column(name="TrinhDo")
		private String TrinhDo;
		
		@Column(name="ChucVu")
		private String ChucVu;
		
		@Column(name="TenKhoa")
		private String TenKhoa;
		
		@Column(name="MatKhau")
		private String MatKhau;
		
		@Column(name="status")
		private boolean status;
}
