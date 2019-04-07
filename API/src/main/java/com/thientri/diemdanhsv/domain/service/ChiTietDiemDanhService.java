package com.thientri.diemdanhsv.domain.service;

import java.util.List;
import java.util.Optional;

import com.thientri.diemdanhsv.domain.entity.ChiTietDiemDanh;


public interface ChiTietDiemDanhService {
	public List<ChiTietDiemDanh> getAllChiTietDiemDanh();
	public ChiTietDiemDanh createChiTietDiemDanh(ChiTietDiemDanh chiTietDiemDanh);
	public ChiTietDiemDanh Update(ChiTietDiemDanh chiTietDiemDanh);
	public void deleteChiTietDiemDanhById(long id);
	public Optional<ChiTietDiemDanh> findById(long id);
}
