package com.thientri.diemdanhsv.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.thientri.diemdanhsv.domain.entity.DiemDanh;
import com.thientri.diemdanhsv.domain.entity.LichDay;


public interface DiemDanhRepository extends JpaRepository<DiemDanh, Long>{
	
	@Query(value ="SELECT m.MaMonHoc, m.MaGiaoVien,m.TenMonHoc, m.TongSoTiet,m.SoTietLyThuyet,m.SoTietThucHanh,m.HocKy,m.NamHoc,m.ChiSo,m.NgayBatDau,m.NgayKetThuc,c.GioBatDau,c.GioKetThuc,c.BuoiHoc,c.Thu,p.TenPhongHoc,p.SoChoNgoi FROM MonHoc m ,PhongHoc p , CaHoc c WHERE m.MaGiaoVien= :MaGiaoVien") 
	LichDay xemLichDay(@Param("MaGiaoVien")long MaGiaoVien);
}
