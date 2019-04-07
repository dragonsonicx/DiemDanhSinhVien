package com.thientri.diemdanhsv.domain.service;

import java.util.List;
import java.util.Optional;

import com.thientri.diemdanhsv.domain.entity.PhongHoc;


public interface PhongHocService {
	public List<PhongHoc> getAllPhongHoc();
	public PhongHoc createPhongHoc(PhongHoc phongHoc);
	public PhongHoc Update(PhongHoc phongHoc);
	public void deletePhongHocById(long id);
	public Optional<PhongHoc> findById(long id);
}
