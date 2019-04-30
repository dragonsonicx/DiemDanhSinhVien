package com.thientri.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thientri.api.idao.GiaoVienIDAO;
import com.thientri.api.model.ChiTietDiemDanh;
import com.thientri.api.model.Lich;
import com.thientri.api.model.MonHocHienTai;

@RestController
@RequestMapping("giaovien")
@CrossOrigin(origins = "*")
public class GiaoVienController {

	@Autowired
	private GiaoVienIDAO giaoVienIDAO;
	
	@GetMapping(value = "/xemLichDay/{magiaovien}",  produces = "application/json;charset=UTF-8")
	public List<Lich> xemLichDay(@PathVariable("magiaovien") long magiaovien){
		return giaoVienIDAO.xemLichDay(magiaovien);
	}
	
	@GetMapping(value = "/xemChiTietDiemDanh/{maMonHoc}",  produces = "application/json;charset=UTF-8")
	public List<ChiTietDiemDanh> xemChiTietDiemDanh(@PathVariable("maMonHoc") long maMonHoc) {
		return giaoVienIDAO.xemChiTietDiemDanh(maMonHoc);
	}
	
	@GetMapping(value = "/quetQRDiemDanh/{maSinhVien}/{maGiaoVien}/{matKhauGiaoVien}",  produces = "application/json;charset=UTF-8")
	public boolean quetQRDiemDanh(@PathVariable("maSinhVien") long maSinhVien,@PathVariable("maGiaoVien") long maGiaoVien,@PathVariable("matKhauGiaoVien") String matKhauGiaoVien) {
		return giaoVienIDAO.quetQRDiemDanh(maSinhVien, maGiaoVien, matKhauGiaoVien);
	}
	
	@GetMapping(value = "/monHocHienTai/{maGiaoVien}/{matKhau}",  produces = "application/json;charset=UTF-8")
	public MonHocHienTai monHocHienTai(@PathVariable("maGiaoVien") long maGiaoVien,@PathVariable("matKhau") String matKhau) {
		return giaoVienIDAO.monHocHienTai(maGiaoVien, matKhau);
	}
}
