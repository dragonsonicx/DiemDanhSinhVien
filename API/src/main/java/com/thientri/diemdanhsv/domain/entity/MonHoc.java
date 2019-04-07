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
@Table(name = "monhoc")
@Getter @Setter @NoArgsConstructor
public class MonHoc implements Serializable{	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="MaMonHoc")
	private long MaMonHoc;
	
	@Column(name="MaGiaoVien")
	private long MaGiaoVien;
	
	@Column(name="TenMonHoc")
	private String TenMonHoc;
	
	@Column(name="TongSoTiet")
	private int TongSoTiet;
	
	@Column(name="SoTietLyThuyet")
	private int SoTietLyThuyet;
	
	@Column(name="SoTietThucHanh")
	private int SoTietThucHanh;
	
	@Column(name="HocKy")
	private String HocKy;
	
	@Column(name="NamHoc")
	private String NamHoc;
	
	@Column(name="ChiSo")
	private int ChiSo;
	
	@Column(name="NgayBatDau")
	private LocalDate NgayBatDau;
	
	@Column(name="NgayKetThuc")
	private LocalDate NgayKetThuc;
}
