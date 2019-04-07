package com.thientri.diemdanhsv.domain.entity;

import java.io.Serializable;

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
@Table(name = "chitietdiemdanh")
@Getter @Setter @NoArgsConstructor
public class ChiTietDiemDanh implements Serializable{	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="MaDiemDanh")
	private long MaDiemDanh;

	@Column(name="TenMonHoc")
	private String TenMonHoc;

	@Column(name="TenGiaoVien")
	private String TenGiaoVien;
	
	@Column(name="GioBatDau")
	private String GioBatDau;
	
	@Column(name="GioKetThuc")
	private String GioKetThuc;
	
	@Column(name="BuoiHoc")
	private String BuoiHoc;
	
	@Column(name="Thu")
	private String Thu;
	
	@Column(name="LyDoNghi")
	private String LyDoNghi;

}
