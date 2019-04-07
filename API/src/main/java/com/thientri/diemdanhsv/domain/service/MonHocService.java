package com.thientri.diemdanhsv.domain.service;

import java.util.List;
import java.util.Optional;

import com.thientri.diemdanhsv.domain.entity.MonHoc;


public interface MonHocService {
	public List<MonHoc> getAllMonHoc();
	public MonHoc createMonHoc(MonHoc monHoc);
	public MonHoc Update(MonHoc monHoc);
	public void deleteMonHocById(long id);
	public Optional<MonHoc> findById(long id);
}
