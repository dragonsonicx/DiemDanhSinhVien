package com.thientri.diemdanhsv.domain.service;

import java.util.List;
import java.util.Optional;

import com.thientri.diemdanhsv.domain.entity.DiemDanh;


public interface DiemDanhService {
	public List<DiemDanh> getAllDiemDanh();
	public DiemDanh createDiemDanh(DiemDanh diemDanh);
	public DiemDanh Update(DiemDanh diemDanh);
	public void deleteDiemDanhById(long id);
	public Optional<DiemDanh> findById(long id);
}
