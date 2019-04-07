package com.thientri.diemdanhsv.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.thientri.diemdanhsv.domain.entity.NguoiDung;

public interface NguoiDungRepository extends JpaRepository<NguoiDung, Long>{
	@Query(value ="SELECT u FROM NguoiDung u WHERE u.Ma = :Ma AND u.MatKhau = :MatKhau") 
	NguoiDung dangNhap(@Param("Ma")long ma,@Param("MatKhau") String MatKhau);
}
