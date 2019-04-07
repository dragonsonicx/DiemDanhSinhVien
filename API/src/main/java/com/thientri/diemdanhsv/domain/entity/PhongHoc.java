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
@Table(name = "phonghoc")
@Getter @Setter @NoArgsConstructor
public class PhongHoc implements Serializable{	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="MaPhongHoc")
	private long MaPhongHoc;

	@Column(name="TenPhongHoc")
	private String TenPhongHoc;

	@Column(name="SoChoNgoi")
	private int SoChoNgoi;

}
