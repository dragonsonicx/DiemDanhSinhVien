package com.thientri.diemdanhsv.domain.service;

import java.util.List;
import java.util.Optional;

import com.thientri.diemdanhsv.domain.entity.NguoiDung;


public interface SinhVienService {
	public List<NguoiDung> getAllSinhVien();
	public NguoiDung createSinhVien(NguoiDung nguoiDung);
	public NguoiDung Update(NguoiDung nguoiDung);
	public void deleteSinhVienById(long ma);
	public Optional<NguoiDung> findById(long ma);
	public NguoiDung dangNhap(long ma ,String matKhau);
}
