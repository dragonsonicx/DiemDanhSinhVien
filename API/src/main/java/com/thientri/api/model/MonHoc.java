package com.thientri.api.model;

import java.io.Serializable;
import java.time.LocalDate;

public class MonHoc implements Serializable{	
	private static final long serialVersionUID = 1L;

	private long maMonHoc;

	private String tenMonHoc;
	

	public MonHoc(long maMonHoc, String tenMonHoc) {
		super();
		this.maMonHoc = maMonHoc;
		this.tenMonHoc = tenMonHoc;
	}

	public long getMaMonHoc() {
		return maMonHoc;
	}

	public void setMaMonHoc(long maMonHoc) {
		this.maMonHoc = maMonHoc;
	}

	public String getTenMonHoc() {
		return tenMonHoc;
	}

	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}

}
