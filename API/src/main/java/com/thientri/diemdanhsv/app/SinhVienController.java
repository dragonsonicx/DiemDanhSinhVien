package com.thientri.diemdanhsv.app;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.thientri.diemdanhsv.domain.entity.NguoiDung;
import com.thientri.diemdanhsv.domain.service.SinhVienService;


@Service
@RestController
@RequestMapping("/nguoidung")
@CrossOrigin(origins = "*")
public class SinhVienController {
	@Autowired
	private SinhVienService sinhVienService;
	
	
	@GetMapping("/listSinhVien")
	public ResponseEntity<List<NguoiDung>>  getAllSinhVien(){
		List<NguoiDung> list = sinhVienService.getAllSinhVien();
		return new ResponseEntity<List<NguoiDung>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/getSinhVien/{maSinhVien}")
	public Optional<NguoiDung> getProductByID(@PathVariable("maSinhVien") long maSinhVien){
		return sinhVienService.findById(maSinhVien);
	}
	
	@PostMapping(value="/create",headers="Accept=application/json")
	 public ResponseEntity<Void> createSinhVien(@RequestBody NguoiDung nguoiDung, UriComponentsBuilder ucBuilder){
		sinhVienService.createSinhVien(nguoiDung);
		HttpHeaders headers = new HttpHeaders();
	    headers.setLocation(ucBuilder.path("/NguoiDung/{id,name,parentId}").buildAndExpand(nguoiDung.getMa(),nguoiDung.getTen(),nguoiDung.getGioiTinh(),nguoiDung.getHinh(),nguoiDung.getNgaySinh(),nguoiDung.getTenLop()).toUri());
	    return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	//Sua
	@PostMapping(value="/update",headers="Accept=application/json")
	public ResponseEntity<Void> update(@RequestBody NguoiDung nguoiDung, UriComponentsBuilder ucBuilder){
		Optional<NguoiDung> listSinhVien = sinhVienService.findById(nguoiDung.getMa());
		if (!listSinhVien.isPresent()) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		else {
			sinhVienService.Update(nguoiDung);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/NguoiDung/{id,name,parentId}").buildAndExpand(nguoiDung.getMa(),nguoiDung.getTen(),nguoiDung.getGioiTinh(),nguoiDung.getHinh(),nguoiDung.getNgaySinh(),nguoiDung.getTenLop()).toUri());
		return new ResponseEntity<Void>(HttpStatus.OK);
    }
	//delete
			@GetMapping("/delete/{id}")
		    public ResponseEntity<NguoiDung> delete(@PathVariable("id") long id){
				Optional<NguoiDung> listSinhVien = sinhVienService.findById(id);
				if (!listSinhVien.isPresent()) {
		            return new ResponseEntity<NguoiDung>(HttpStatus.NOT_FOUND);
		        }
				else 
					sinhVienService.deleteSinhVienById(id);
		        return new ResponseEntity<NguoiDung>(HttpStatus.NO_CONTENT);
		    }
			
	@GetMapping("/dangNhap/{ma}/{matKhau}")
	public NguoiDung dangNhap(@PathVariable("ma") long ma, @PathVariable("matKhau") String matKhau){
		if(sinhVienService.dangNhap(ma, matKhau) != null) {
			return sinhVienService.dangNhap(ma, matKhau);
		}
		return null;
	}

}
