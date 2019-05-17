package com.thientri.api.controller;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
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

	private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
		HSSFFont font = workbook.createFont();
		font.setBold(true);
		HSSFCellStyle style = workbook.createCellStyle();
		style.setFont(font);
		return style;
	}

	@GetMapping(value = "/xemLichDay/{magiaovien}", produces = "application/json;charset=UTF-8")
	public List<Lich> xemLichDay(@PathVariable("magiaovien") long magiaovien) {
		return giaoVienIDAO.xemLichDay(magiaovien);
	}

	// ngày điểm danh set theo định dạng 2019-04-28 { yyyy-MM-dd }
	@GetMapping(value = "/xemChiTietDiemDanh/{maMonHoc}/{ngayDiemDanh}", produces = "application/json;charset=UTF-8")
	public List<ChiTietDiemDanh> xemChiTietDiemDanh(@PathVariable("maMonHoc") long maMonHoc,
			@PathVariable("ngayDiemDanh") String ngayDiemDanh) {
		return giaoVienIDAO.xemChiTietDiemDanh(maMonHoc, ngayDiemDanh);
	}

	@GetMapping(value = "/quetQRDiemDanh/{maSinhVien}/{maGiaoVien}/{matKhauGiaoVien}", produces = "application/json;charset=UTF-8")
	public boolean quetQRDiemDanh(@PathVariable("maSinhVien") long maSinhVien,
			@PathVariable("maGiaoVien") long maGiaoVien, @PathVariable("matKhauGiaoVien") String matKhauGiaoVien) {
		return giaoVienIDAO.quetQRDiemDanh(maSinhVien, maGiaoVien, matKhauGiaoVien);
	}

	@GetMapping(value = "/monHocHienTai/{maGiaoVien}/{matKhau}", produces = "application/json;charset=UTF-8")
	public MonHocHienTai monHocHienTai(@PathVariable("maGiaoVien") long maGiaoVien,
			@PathVariable("matKhau") String matKhau) {
		return giaoVienIDAO.monHocHienTai(maGiaoVien, matKhau);
	}

	@GetMapping(value = "/getTenMonHoc/{maGiaoVien}", produces = "application/json;charset=UTF-8")
	public List<MonHoc> getTenMonHoc(@PathVariable("maGiaoVien") long maGiaoVien) {
		return giaoVienIDAO.getTenMonHoc(maGiaoVien);
	}

	@GetMapping(value = "/getNgayHoc/{maGiaoVien}/{maMonHoc}", produces = "application/json;charset=UTF-8")
	public List<String> getNgayHoc(@PathVariable("maGiaoVien") long maGiaoVien,
			@PathVariable("maMonHoc") long maMonHoc) {
		return giaoVienIDAO.getNgayHoc(maGiaoVien, maMonHoc);
	}

//	@GetMapping(value = "/fileChiTietDiemDanh/{maGiaoVien}/{maMonHoc}", produces = "application/json;charset=UTF-8")
//	public boolean fileChiTietDiemDanh(@PathVariable("maGiaoVien") long maGiaoVien,
//			@PathVariable("maMonHoc") long maMonHoc) {
//		String tenMonHoc = giaoVienIDAO.tenMonHoc(maMonHoc);
//		List<String> listNgayHoc = giaoVienIDAO.getNgayHoc(maGiaoVien, maMonHoc);
//		HSSFWorkbook workbook = new HSSFWorkbook();
//		HSSFSheet sheet = workbook.createSheet("Môn "+tenMonHoc);
//
//		List<ChiTietDiemDanh> list = giaoVienIDAO.fileChiTietDiemDanh(maMonHoc);
//
//		int rownum = 0;
//		Cell cell;
//		Row row;
//		//
//		HSSFCellStyle style = createStyleForTitle(workbook);
//
//		row = sheet.createRow(rownum);
//
//		// maSinhVien
//		cell = row.createCell(0, CellType.STRING);
//		cell.setCellValue("Mã Sinh Viên");
//		cell.setCellStyle(style);
//		// tenSinhVien
//		cell = row.createCell(1, CellType.STRING);
//		cell.setCellValue("Tên Sinh Viên");
//		cell.setCellStyle(style);
//		// tenLop
//		cell = row.createCell(2, CellType.STRING);
//		cell.setCellValue("Lớp");
//		cell.setCellStyle(style);
//		// gioitinh
//		cell = row.createCell(3, CellType.STRING);
//		cell.setCellValue("Giới Tính");
//		cell.setCellStyle(style);
//		
//		for (int i = 0; i < listNgayHoc.size(); i++) {
//			// ngayDiemDanh
//			cell = row.createCell(4, CellType.STRING);
//			cell.setCellValue(listNgayHoc.get(i));
//			cell.setCellStyle(style);
//		}
//		
//		
//		
//		for (ChiTietDiemDanh c : list) {
//            rownum++;
//            row = sheet.createRow(rownum);
// 
//            // maSinhVien (A)
//            cell = row.createCell(0, CellType.STRING);
//            cell.setCellValue(c.getMaSinhVien());
//            // tenSinhVien (B)
//            cell = row.createCell(1, CellType.STRING);
//            cell.setCellValue(c.getTenSinhVien());
//            // tenLop (C)
//            cell = row.createCell(2, CellType.STRING);
//            cell.setCellValue(c.getTenLop());
//            // gioitinh (D)
//            cell = row.createCell(3, CellType.STRING);
//            cell.setCellValue(c.getGioitinh());
//            for (int i = 0; i < listNgayHoc.size(); i++) {
//    			// ngayDiemDanh (E)
//    			cell = row.createCell(4, CellType.STRING);
//    			cell.setCellValue(listNgayHoc.get(i));
//    			cell.setCellValue();
//    		}
//            
//        }
//        File file = new File("C:/demo/employee.xls");
//        file.getParentFile().mkdirs();
// 
//        FileOutputStream outFile = new FileOutputStream(file);
//        workbook.write(outFile);
//        System.out.println("Created file: " + file.getAbsolutePath());
//
//		return giaoVienIDAO.fileChiTietDiemDanh(maMonHoc);
//	}
}
