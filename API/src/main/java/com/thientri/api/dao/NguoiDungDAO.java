package com.thientri.api.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.thientri.api.config.ApplicationContextConfig;
import com.thientri.api.idao.NguoiDungIDAO;
import com.thientri.api.model.NguoiDung;

@Repository
public class NguoiDungDAO implements NguoiDungIDAO {
	
	ApplicationContextConfig app;
	
	public List<NguoiDung> getAllNguoiDung() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		ArrayList<NguoiDung> list = new ArrayList<NguoiDung>() ;
		PreparedStatement smt = null;
		try {
			Connection con = app.getConnection();
			String sql = "select * from  nguoidung";
			smt = con.prepareStatement(sql);
			ResultSet rs= smt.executeQuery();
			while(rs.next()) {
				long maNguoiDung = rs.getLong("ma");
				String tenNguoiDung = rs.getString("ten");
				byte[] hinh = rs.getBytes("hinh");
				Date ngayS = rs.getDate("ngaysinh");
				String ngaySinh = dateFormat.format(ngayS);
				String gioiTinh = rs.getString("gioitinh");
				String tenLop = rs.getString("tenlop");
				String trinhDo = rs.getString("trinhdo");
				String chucVu = rs.getString("chucvu");
				
				String tenKhoa = rs.getString("tenkhoa");
				String matKhau = rs.getString("matkhau");
				String sodienthoai = rs.getString("sodienthoai");
				String email = rs.getString("email");

				int status = rs.getInt("status");
				NguoiDung n = new NguoiDung(maNguoiDung, tenNguoiDung, hinh, ngaySinh, sodienthoai, email, gioiTinh, tenLop, trinhDo, chucVu, tenKhoa, matKhau, status);
				list.add(n);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean createNguoiDung(NguoiDung nguoiDung) {
		PreparedStatement smt = null;
		int n = 0;
		try {
			Connection con = app.getConnection();
			String sql = "insert into nguoidung values (?,?,?,?,?,?,?,?,?,?,?)";
			smt = con.prepareStatement(sql);
			smt.setLong(1, nguoiDung.getMaNguoiDung());
			smt.setString(2, nguoiDung.getChucVu());
			smt.setString(3, nguoiDung.getGioiTinh());
			smt.setBytes(4, nguoiDung.getHinh());
			smt.setString(5, nguoiDung.getMatKhau());
			smt.setString(6,nguoiDung.getNgaySinh());
			smt.setInt(7, nguoiDung.getStatus());
			smt.setString(8, nguoiDung.getTenNguoiDung());
			smt.setString(9, nguoiDung.getTenKhoa());
			smt.setString(10, nguoiDung.getTenLop());
			smt.setString(11, nguoiDung.getTrinhDo());
			n = smt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n>0;
	}

	public boolean updateNguoiDung(NguoiDung nguoiDung) {
		PreparedStatement smt = null;
		int n = 0;
		try {
			Connection con = app.getConnection();
			String sql = "update nguoidung set ten=?,hinh=?,ngaysinh=?,gioitinh=?,tenlop=?,trinhdo=?,chucvu=?,tenkhoa=?, matkhau=?, status=? where ma=?";
			smt = con.prepareStatement(sql);
			smt.setString(1, nguoiDung.getTenNguoiDung());
			smt.setBytes(2, nguoiDung.getHinh());
			smt.setString(3,nguoiDung.getNgaySinh());
			smt.setString(4, nguoiDung.getGioiTinh());
			smt.setString(5, nguoiDung.getTenLop());
			smt.setString(6, nguoiDung.getTrinhDo());
			smt.setString(7, nguoiDung.getChucVu());
			smt.setString(8, nguoiDung.getTenKhoa());
			smt.setString(9, nguoiDung.getMatKhau());
			smt.setInt(10, nguoiDung.getStatus());
			smt.setLong(11, nguoiDung.getMaNguoiDung());
			n = smt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n>0;
	}

	public boolean deleteNguoiDungById(long ma) {
		PreparedStatement smt = null;
		int n = 0;
		try {
			Connection con = app.getConnection();
			String sql = "DELETE FROM nguoidung WHERE ma= ?";
			smt = con.prepareStatement(sql);
			smt.setLong(1, ma);
			n = smt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n>0;
	}

	public NguoiDung findById(long ma) {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		NguoiDung n = null ;
		PreparedStatement smt = null;
		try {
			Connection con = app.getConnection();
			String sql = "select * from  nguoidung n where n.ma = ?";
			smt = con.prepareStatement(sql);
			smt.setLong(1, ma);
			ResultSet rs= smt.executeQuery();
			while(rs.next()) {
				String tenNguoiDung = rs.getString("ten");
				byte[] hinh = rs.getBytes("hinh");
				Date ngayS = rs.getDate("ngaysinh");
				String ngaySinh = dateFormat.format(ngayS);
				String gioiTinh = rs.getString("gioitinh");
				String tenLop = rs.getString("tenlop");
				String trinhDo = rs.getString("trinhdo");
				String chucVu = rs.getString("chucvu");
				
				String tenKhoa = rs.getString("tenkhoa");
				String matKhau = rs.getString("matkhau");
				String sodienthoai = rs.getString("sodienthoai");
				String email = rs.getString("email");
				int status = rs.getInt("status");
				n = new NguoiDung(ma, tenNguoiDung, hinh, ngaySinh, sodienthoai, email, gioiTinh, tenLop, trinhDo, chucVu, tenKhoa, matKhau, status);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n;
	}

	public NguoiDung dangNhap(long ma, String matKhau) {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		NguoiDung n = null ;
		PreparedStatement smt = null;
		try {
			Connection con = app.getConnection();
			String sql = "select * from  nguoidung n where n.ma = ? and n.matkhau=?";
			smt = con.prepareStatement(sql);
			smt.setLong(1, ma);
			smt.setString(2, matKhau);
			ResultSet rs= smt.executeQuery();
			while(rs.next()) {
				String tenNguoiDung = rs.getString("ten");
				byte[] hinh = rs.getBytes("hinh");
				Date ngayS = rs.getDate("ngaysinh");
				String ngaySinh = dateFormat.format(ngayS);
				String gioiTinh = rs.getString("gioitinh");
				String tenLop = rs.getString("tenlop");
				String trinhDo = rs.getString("trinhdo");
				String chucVu = rs.getString("chucvu");
				
				String tenKhoa = rs.getString("tenkhoa");
				String sodienthoai = rs.getString("sodienthoai");
				String email = rs.getString("email");

				int status = rs.getInt("status");
				n = new NguoiDung(ma, tenNguoiDung, hinh, ngaySinh, sodienthoai, email, gioiTinh, tenLop, trinhDo, chucVu, tenKhoa, matKhau, status);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n;
	}

	public boolean doiMatKhau(long ma, String matKhauCu, String matKhauMoi) {
		PreparedStatement smt = null;
		int n = 0;
		try {
			Connection con = app.getConnection();
			String sql = "update nguoidung n set n.matkhau=? where n.ma=? and n.matkhau = ?";
			smt = con.prepareStatement(sql);
			smt.setString(1, matKhauMoi);
			smt.setLong(2, ma);
			smt.setString(3,matKhauCu);
			n = smt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n>0;
	}

}
