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
@Table(name = "cahoc")
@Getter @Setter @NoArgsConstructor
public class CaHoc implements Serializable{	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="MaCaHoc")
	private long MaCaHoc;
	
	@Column(name="MaMonHoc")
	private long MaMonHoc;

	@Column(name="MaPhongHoc")
	private long MaPhongHoc;

	@Column(name="GioBatDau")
	private String GioBatDau;

	@Column(name="GioKetThuc")
	private String GioKetThuc;

	@Column(name="BuoiHoc")
	private String BuoiHoc;

	@Column(name="Thu")
	private String Thu;
	
}
