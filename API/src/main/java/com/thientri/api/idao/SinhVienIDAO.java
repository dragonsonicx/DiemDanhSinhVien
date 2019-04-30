package com.thientri.api.idao;

import java.util.List;

import com.thientri.api.model.Lich;
import com.thientri.api.model.MonHocHienTai;

public interface SinhVienIDAO {
	public List<Lich> xemLichHoc(long maNguoiDung);
	public boolean quetQRDiemDanh(String tenPhongHoc, long maSinhVien, String matKhau);
	public MonHocHienTai monHocHienTai(long maSinhVien, String matKhau);
}
