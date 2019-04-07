package com.thientri.diemdanhsv.domain.service;

import java.util.List;
import java.util.Optional;

import com.thientri.diemdanhsv.domain.entity.CaHoc;

public interface CaHocService {
	public List<CaHoc> getAllCaHoc();
	public CaHoc createCaHoc(CaHoc caHoc);
	public CaHoc Update(CaHoc caHoc);
	public void deleteCaHocById(long id);
	public Optional<CaHoc> findById(long id);
}
