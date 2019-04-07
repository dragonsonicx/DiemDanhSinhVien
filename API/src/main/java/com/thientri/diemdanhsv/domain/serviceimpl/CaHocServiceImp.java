package com.thientri.diemdanhsv.domain.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thientri.diemdanhsv.domain.entity.CaHoc;
import com.thientri.diemdanhsv.domain.repository.CaHocRepository;
import com.thientri.diemdanhsv.domain.service.CaHocService;

@Service
public class CaHocServiceImp implements CaHocService{

	@Autowired
	private CaHocRepository caHocRepository;
	
	@Override
	public CaHoc createCaHoc(CaHoc caHoc) {
		return caHocRepository.save(caHoc);
	}

	@Override
	public void deleteCaHocById(long id) {
		caHocRepository.deleteById(id);
	}

	@Override
	public CaHoc Update(CaHoc caHoc) {
		return caHocRepository.save(caHoc);
	}
	
	@Override
	public Optional<CaHoc> findById(long id) {
		
		return caHocRepository.findById(id);
	}
	
	@Override
	public List<CaHoc> getAllCaHoc() {
		return caHocRepository.findAll();
	}

}
