package com.thientri.diemdanhsv.domain.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thientri.diemdanhsv.domain.entity.NguoiDung;
import com.thientri.diemdanhsv.domain.repository.NguoiDungRepository;
import com.thientri.diemdanhsv.domain.service.SinhVienService;

@Service
public class SinhVienServiceImp implements SinhVienService{
	@Autowired
	private NguoiDungRepository nguoiDungRepository;
	
	@Override
	public NguoiDung createSinhVien(NguoiDung nguoiDung) {
		return nguoiDungRepository.save(nguoiDung);
	}

	@Override
	public void deleteSinhVienById(long ma) {
		nguoiDungRepository.deleteById(ma);
	}

	@Override
	public NguoiDung Update(NguoiDung nguoiDung) {
		return nguoiDungRepository.save(nguoiDung);
	}
	
	@Override
	public Optional<NguoiDung> findById(long ma) {
		
		return nguoiDungRepository.findById(ma);
	}
	
	@Override
	public List<NguoiDung> getAllSinhVien() {
		return nguoiDungRepository.findAll();
	}

	@Override
	public NguoiDung dangNhap(long ma, String matKhau) {
		return nguoiDungRepository.dangNhap(ma, matKhau);
	}
}
