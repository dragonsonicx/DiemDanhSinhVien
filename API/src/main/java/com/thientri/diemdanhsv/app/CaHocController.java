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

import com.thientri.diemdanhsv.domain.entity.CaHoc;
import com.thientri.diemdanhsv.domain.service.CaHocService;


@Service
@RestController
@RequestMapping("cahoc")
@CrossOrigin(origins = "*")
public class CaHocController {
	@Autowired
	private CaHocService caHocService;
	
	@GetMapping("/listCaHoc")
	public ResponseEntity<List<CaHoc>>  getAllCaHoc(){
		List<CaHoc> list = caHocService.getAllCaHoc();
		return new ResponseEntity<List<CaHoc>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/getCaHoc/{id}")
	public Optional<CaHoc> getProductByID(@PathVariable("id") long id){
		return caHocService.findById(id);
	}
	
	@PostMapping(value="/create",headers="Accept=application/json")
	 public ResponseEntity<Void> createCaHoc(@RequestBody CaHoc caHoc, UriComponentsBuilder ucBuilder){
		caHocService.createCaHoc(caHoc);
		HttpHeaders headers = new HttpHeaders();
	    headers.setLocation(ucBuilder.path("/CaHoc/{id,name,parentId}").buildAndExpand(caHoc.getMaCaHoc(),caHoc.getThu(),caHoc.getGioBatDau(),caHoc.getGioKetThuc()).toUri());
	    return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	//Sua
	@PostMapping(value="/update",headers="Accept=application/json")
	public ResponseEntity<Void> update(@RequestBody CaHoc caHoc, UriComponentsBuilder ucBuilder){
		Optional<CaHoc> listCaHoc = caHocService.findById(caHoc.getMaCaHoc());
		if (!listCaHoc.isPresent()) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		else {
			caHocService.Update(caHoc);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/CaHoc/{id,name,parentId}").buildAndExpand(caHoc.getMaCaHoc(),caHoc.getThu(),caHoc.getGioBatDau(),caHoc.getGioKetThuc()).toUri());
		return new ResponseEntity<Void>(HttpStatus.OK);
    }
	//delete
			@GetMapping("/delete/{id}")
		    public ResponseEntity<CaHoc> delete(@PathVariable("id") long id){
				Optional<CaHoc> listCaHoc = caHocService.findById(id);
				if (!listCaHoc.isPresent()) {
		            return new ResponseEntity<CaHoc>(HttpStatus.NOT_FOUND);
		        }
				else 
					caHocService.deleteCaHocById(id);
		        return new ResponseEntity<CaHoc>(HttpStatus.NO_CONTENT);
		    }
}
