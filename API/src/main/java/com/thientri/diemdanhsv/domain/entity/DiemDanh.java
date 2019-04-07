package com.thientri.diemdanhsv.domain.entity;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "diemdanh")
@Getter @Setter @NoArgsConstructor
public class DiemDanh implements Serializable{	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="MaDiemDanh")
	private long MaDiemDanh;

	@Column(name="MaSinhVien")
	private long MaSinhVien;

	@Column(name="NgayDiemDanh")
	private Date NgayDiemDanh;

	@Column(name="SoTietDiHoc")
	private int SoTietDiHoc;

	@Column(name="SoTietVang")
	private int SoTietVang;
}
