package com.thientri.diemdanhsv.domain.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thientri.diemdanhsv.domain.entity.DiemDanh;
import com.thientri.diemdanhsv.domain.repository.DiemDanhRepository;
import com.thientri.diemdanhsv.domain.service.DiemDanhService;

@Service
public class DiemDanhServiceImp implements DiemDanhService{
	@Autowired
	private DiemDanhRepository diemDanhRepository;
	
	@Override
	public DiemDanh createDiemDanh(DiemDanh diemDanh) {
		return diemDanhRepository.save(diemDanh);
	}

	@Override
	public void deleteDiemDanhById(long id) {
		diemDanhRepository.deleteById(id);
	}

	@Override
	public DiemDanh Update(DiemDanh diemDanh) {
		return diemDanhRepository.save(diemDanh);
	}
	
	@Override
	public Optional<DiemDanh> findById(long id) {
		return diemDanhRepository.findById(id);
	}
	
	@Override
	public List<DiemDanh> getAllDiemDanh() {
		return diemDanhRepository.findAll();
	}


}
