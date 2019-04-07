package com.thientri.diemdanhsv.domain.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thientri.diemdanhsv.domain.entity.MonHoc;
import com.thientri.diemdanhsv.domain.repository.MonHocRepository;
import com.thientri.diemdanhsv.domain.service.MonHocService;

@Service
public class MonHocServiceImp implements MonHocService{
	@Autowired
	private MonHocRepository monHocRepository;
	
	@Override
	public MonHoc createMonHoc(MonHoc monHoc) {
		return monHocRepository.save(monHoc);
	}

	@Override
	public void deleteMonHocById(long id) {
		monHocRepository.deleteById(id);
	}

	@Override
	public MonHoc Update(MonHoc monHoc) {
		return monHocRepository.save(monHoc);
	}
	
	@Override
	public Optional<MonHoc> findById(long id) {
		
		return monHocRepository.findById(id);
	}
	
	@Override
	public List<MonHoc> getAllMonHoc() {
		return monHocRepository.findAll();
	}
}
