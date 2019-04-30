package com.thientri.api.idao;

import java.util.List;

import com.thientri.api.model.NguoiDung;

public interface NguoiDungIDAO{
	public List<NguoiDung> getAllNguoiDung();
	public boolean createNguoiDung(NguoiDung nguoiDung);
	public boolean updateNguoiDung(NguoiDung nguoiDung);
	public boolean deleteNguoiDungById(long ma);
	public NguoiDung findById(long ma);
	public NguoiDung dangNhap(long ma ,String matKhau);
	public boolean doiMatKhau(long ma, String matKhauCu, String matKhauMoi);
}
