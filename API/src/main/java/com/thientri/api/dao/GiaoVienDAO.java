package com.thientri.api.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.thientri.api.config.ApplicationContextConfig;
import com.thientri.api.idao.GiaoVienIDAO;
import com.thientri.api.model.ChiTietDiemDanh;
import com.thientri.api.model.Lich;
import com.thientri.api.model.MonHocHienTai;

@Repository
public class GiaoVienDAO implements GiaoVienIDAO{
	
	ApplicationContextConfig app;
	
	public List<Lich> xemLichDay(long maNguoiDung) {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		ArrayList<Lich> list = new ArrayList<Lich>() ;
		PreparedStatement smt = null;
		try {
			Connection con = app.getConnection();
			String sql = "SELECT n.ma, m.tenmonhoc,n.ten, p.tenphonghoc, c.buoihoc, c.giobatdau, c.gioketthuc, m.ngaybatdau, m.ngayketthuc, m.namhoc, m.hocky, c.thu FROM cahoc c, monhoc m, phonghoc p, nguoidung n WHERE m.magiaovien = n.ma AND c.maphonghoc = p.maphonghoc AND c.mamonhoc = m.mamonhoc AND n.ma = ? AND n.status= 1";
			smt = con.prepareStatement(sql);
			smt.setLong(1, maNguoiDung);
			ResultSet rs= smt.executeQuery();
			while(rs.next()) {
				long ma = rs.getLong("ma");
				String tenMonHoc = rs.getString("tenmonhoc");
				String tenNguoiDung = rs.getString("ten");
				String tenPhongHoc = rs.getString("tenphonghoc");
				String buoiHoc = rs.getString("buoihoc");
				String gioBatDau = rs.getString("giobatdau");
				String gioKetThuc = rs.getString("gioketthuc");
				Date ngayBD = rs.getDate("ngaybatdau");
                String ngayBatDau = dateFormat.format(ngayBD);
				Date ngayKT = rs.getDate("ngayketthuc");
				String ngayKetThuc = dateFormat.format(ngayKT);
				int namHoc = rs.getInt("namhoc");
				String hocKy = rs.getString("hocky");
				int thu = rs.getInt("thu");
				  
				Lich l = new Lich(ma, tenMonHoc, tenNguoiDung, hocKy, namHoc, gioBatDau, gioKetThuc, buoiHoc, tenPhongHoc, thu, ngayBatDau, ngayKetThuc);
				list.add(l);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<ChiTietDiemDanh> xemChiTietDiemDanh(long maMonHoc) {
		ArrayList<ChiTietDiemDanh> list = new ArrayList<ChiTietDiemDanh>() ;
		PreparedStatement smt = null;
		try {
			Connection con = app.getConnection();
			String sql = "SELECT n.ma, n.ten, n.tenlop, n.hinh, n.gioitinh, c.ngaydiemdanh, c.status , c.lydonghi FROM nguoidung n, diemdanh d, chitietdiemdanh c WHERE c.madiemdanh = d.madiemdanh AND d.masinhvien =n.ma AND d.mamonhoc = ? AND n.status = 0";
			smt = con.prepareStatement(sql);
			smt.setLong(1, maMonHoc);
			ResultSet rs= smt.executeQuery();
			while(rs.next()) {
				long maSinhVien = rs.getLong("ma");

				String tenSinhVien = rs.getString("ten");
				
				String tenLop = rs.getString("tenlop");

				byte[] hinh = rs.getBytes("hinh");
				
				String gioitinh = rs.getString("hinh");
				
				String ngayDiemDanh = rs.getString("gioitinh");
				
				String lyDoNghi = rs.getString("lydonghi");
				
				boolean status = rs.getBoolean("status");
				ChiTietDiemDanh c = new  ChiTietDiemDanh(maSinhVien, tenSinhVien, tenLop, hinh, gioitinh, ngayDiemDanh, lyDoNghi, status);
				list.add(c);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public boolean quetQRDiemDanh(long maSinhVien, long maGiaoVien, String matKhauGiaoVien) {
		// lấy mã diem danh của môn học hiện tại
		long madiemdanh = getMaDiemdanh(maSinhVien, maGiaoVien, matKhauGiaoVien);
		if(madiemdanh != 0) {
			// Ngày hiện tại
			LocalDate now = LocalDate.now();
			Date date = java.sql.Date.valueOf(now);
			// them du lieu vao ban chi tiet diem danh 
			PreparedStatement smt = null;
			int n = 0;
			try {
				Connection con = app.getConnection();
				String sql = "INSERT INTO chitietdiemdanh (madiemdanh,ngaydiemdanh,status) values (?,?,?)";
				smt = con.prepareStatement(sql);
				smt.setLong(1, madiemdanh);
				smt.setDate(2, (java.sql.Date) date);
				smt.setBoolean(3, true);
				n = smt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return n>0;
		}
		return false;
		
	}
	
	// lấy mã diem danh của môn học hiện tại
	public long getMaDiemdanh(long maSinhVien, long maGiaoVien, String matKhauGiaoVien) {
		MonHocHienTai monHocHienTai = monHocHienTai(maGiaoVien, matKhauGiaoVien);
		if(monHocHienTai != null) {
			long madiemdanh = 0;
			PreparedStatement smt = null;
			try {
				Connection con = app.getConnection();
			String sql = "SELECT d.madiemdanh FROM diemdanh d WHERE d.magiaovien = ? AND d.masinhvien = ? AND d.mamonhoc = ?";
			smt = con.prepareStatement(sql);
			smt.setLong(1, maGiaoVien);
			smt.setLong(2, maSinhVien);
			smt.setLong(3, monHocHienTai.getMaMonHoc());
			ResultSet rs= smt.executeQuery();
			while(rs.next()) {
				madiemdanh = rs.getLong("madiemdanh");
			}
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return madiemdanh;
		}
		return 0;
	}
	
	public MonHocHienTai monHocHienTai(long maGiaoVien, String matKhau) {
		// lay thu cua ngay hien tai
		Calendar calendar = Calendar.getInstance();
		int thu = calendar.get(Calendar.DAY_OF_WEEK);
		Date d = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		MonHocHienTai monHocHienTai = null;
		PreparedStatement smt = null;
		try {
			Connection con = app.getConnection();
			String sql = "SELECT m.mamonhoc, m.tenmonhoc, m.ngaybatdau , m.ngayketthuc, p.tenphonghoc, c.giobatdau, c.gioketthuc FROM nguoidung n, monhoc m,diemdanh d, cahoc c, phonghoc p WHERE n.status = 1 AND n.ma = d.magiaovien AND d.magiaovien = m.magiaovien AND m.mamonhoc = c.macahoc AND c.maphonghoc = p.maphonghoc AND c.thu = ? AND m.magiaovien = ? AND n.matkhau = ?";
			smt = con.prepareStatement(sql);
			smt.setInt(1, thu);
			smt.setLong(2, maGiaoVien);
			smt.setString(3, matKhau);
			ResultSet rs= smt.executeQuery();
			while(rs.next()) {
				long maMonHoc = rs.getLong("mamonhoc");
				String tenMonHoc = rs.getString("tenmonhoc");
				Date ngayBD = rs.getDate("ngaybatdau");
				String ngayBatDau = dateFormat.format(ngayBD);
				Date ngayKT = rs.getDate("ngayketthuc");
				String ngayKetThuc = dateFormat.format(ngayKT);
				String tenPhongHoc = rs.getString("tenphonghoc");
				String gioBatDau = rs.getString("giobatdau");
				String gioKetThuc = rs.getString("gioketthuc");
				if(d.after(ngayBD) && d.before(ngayKT)){
					LocalTime now = LocalTime.now();
					LocalTime timeStart = LocalTime.parse(gioBatDau);
					LocalTime timeEnd = LocalTime.parse(gioKetThuc);
					// hiển thị môn học hiện tại trước 10 phút đầu giờ và sau 10 phút cuối giờ
					if(now.isAfter(timeStart.minusMinutes(10)) && now.isBefore(timeEnd.minusMinutes(10))) {
						monHocHienTai = new MonHocHienTai(maMonHoc, tenMonHoc, ngayBatDau, ngayKetThuc, tenPhongHoc, gioBatDau, gioKetThuc);
					}
					
				}
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		      
		return monHocHienTai;
	}

}