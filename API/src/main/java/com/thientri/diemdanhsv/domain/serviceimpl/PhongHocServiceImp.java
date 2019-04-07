package com.thientri.diemdanhsv.domain.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thientri.diemdanhsv.domain.entity.PhongHoc;
import com.thientri.diemdanhsv.domain.repository.PhongHocRepository;
import com.thientri.diemdanhsv.domain.service.PhongHocService;

@Service
public class PhongHocServiceImp implements PhongHocService{
	@Autowired
	private PhongHocRepository phongHocRepository;
	
	@Override
	public PhongHoc createPhongHoc(PhongHoc phongHoc) {
		return phongHocRepository.save(phongHoc);
	}

	@Override
	public void deletePhongHocById(long id) {
		phongHocRepository.deleteById(id);
	}

	@Override
	public PhongHoc Update(PhongHoc phongHoc) {
		return phongHocRepository.save(phongHoc);
	}
	
	@Override
	public Optional<PhongHoc> findById(long id) {
		
		return phongHocRepository.findById(id);
	}
	
	@Override
	public List<PhongHoc> getAllPhongHoc() {
		return phongHocRepository.findAll();
	}
}
