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
import com.thientri.api.model.MonHoc;
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
	
	// ngày điểm danh set theo định dạng 2019-04-28 { yyyy-MM-dd }
	@GetMapping(value = "/xemChiTietDiemDanh/{tenMonHoc}/{ngayDiemDanh}",  produces = "application/json;charset=UTF-8")
	public List<ChiTietDiemDanh> xemChiTietDiemDanh(@PathVariable("tenMonHoc") String tenMonHoc,@PathVariable("ngayDiemDanh") String ngayDiemDanh) {
		return giaoVienIDAO.xemChiTietDiemDanh(tenMonHoc,ngayDiemDanh);
	}
	
	@GetMapping(value = "/quetQRDiemDanh/{maSinhVien}/{maGiaoVien}/{matKhauGiaoVien}",  produces = "application/json;charset=UTF-8")
	public boolean quetQRDiemDanh(@PathVariable("maSinhVien") long maSinhVien,@PathVariable("maGiaoVien") long maGiaoVien,@PathVariable("matKhauGiaoVien") String matKhauGiaoVien) {
		return giaoVienIDAO.quetQRDiemDanh(maSinhVien, maGiaoVien, matKhauGiaoVien);
	}
	
	@GetMapping(value = "/monHocHienTai/{maGiaoVien}/{matKhau}",  produces = "application/json;charset=UTF-8")
	public MonHocHienTai monHocHienTai(@PathVariable("maGiaoVien") long maGiaoVien,@PathVariable("matKhau") String matKhau) {
		return giaoVienIDAO.monHocHienTai(maGiaoVien, matKhau);
	}
	
	@GetMapping(value = "/getTenMonHoc/{maGiaoVien}",  produces = "application/json;charset=UTF-8")
	public List<MonHoc> getTenMonHoc(@PathVariable("maGiaoVien") long maGiaoVien) {
		return giaoVienIDAO.getTenMonHoc(maGiaoVien);
	}
	
	@GetMapping(value = "/getNgayHoc/{maGiaoVien}/{maMonHoc}",  produces = "application/json;charset=UTF-8")
	public List<String> getNgayHoc(@PathVariable("maGiaoVien") long maGiaoVien,@PathVariable("maMonHoc") long maMonHoc) {
		return giaoVienIDAO.getNgayHoc(maGiaoVien, maMonHoc);
	}
}
