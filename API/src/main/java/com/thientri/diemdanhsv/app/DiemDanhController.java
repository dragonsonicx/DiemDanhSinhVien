package com.thientri.diemdanhsv.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thientri.diemdanhsv.domain.entity.LichDay;
import com.thientri.diemdanhsv.domain.service.DiemDanhService;


@Service
@RestController
@RequestMapping("diemdanh")
@CrossOrigin(origins = "*")
public class DiemDanhController {
	@Autowired
	private DiemDanhService diemDanhService;
		
}
