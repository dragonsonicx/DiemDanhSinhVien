package com.thientri.diemdanhsv.domain.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thientri.diemdanhsv.domain.entity.ChiTietDiemDanh;
import com.thientri.diemdanhsv.domain.repository.ChiTietDiemDanhRepository;
import com.thientri.diemdanhsv.domain.service.ChiTietDiemDanhService;
@Service
public class ChiTietDiemDanhServiceImp implements ChiTietDiemDanhService{
	@Autowired
	private ChiTietDiemDanhRepository chiTietDiemDanhRepository;
	
	@Override
	public ChiTietDiemDanh createChiTietDiemDanh(ChiTietDiemDanh chiTietDiemDanh) {
		return chiTietDiemDanhRepository.save(chiTietDiemDanh);
	}

	@Override
	public void deleteChiTietDiemDanhById(long id) {
		chiTietDiemDanhRepository.deleteById(id);
	}

	@Override
	public ChiTietDiemDanh Update(ChiTietDiemDanh chiTietDiemDanh) {
		return chiTietDiemDanhRepository.save(chiTietDiemDanh);
	}
	
	@Override
	public Optional<ChiTietDiemDanh> findById(long id) {
		
		return chiTietDiemDanhRepository.findById(id);
	}
	
	@Override
	public List<ChiTietDiemDanh> getAllChiTietDiemDanh() {
		return chiTietDiemDanhRepository.findAll();
	}

}
