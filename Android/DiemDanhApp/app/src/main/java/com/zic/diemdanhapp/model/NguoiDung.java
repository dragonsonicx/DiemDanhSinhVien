package com.zic.diemdanhapp.model;

import java.util.Date;

public class NguoiDung {

    public int manguoidung;
    public String tennguoidung;
    public String hinh;
    public String ngaysinh;
    public String gioitinh;
    public String tenlop;
    public String trinhdo;
    public String chucvu;
    public String tenkhoa;
    public String matkhau;
    public String stat;

    public NguoiDung(){

    }

    public int getManguoidung() {
        return manguoidung;
    }

    public void setManguoidung(int manguoidung) {
        this.manguoidung = manguoidung;
    }

    public String getTennguoidung() {
        return tennguoidung;
    }

    public void setTennguoidung(String tennguoidung) {
        this.tennguoidung = tennguoidung;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getTenlop() {
        return tenlop;
    }

    public void setTenlop(String tenlop) {
        this.tenlop = tenlop;
    }

    public String getTrinhdo() {
        return trinhdo;
    }

    public void setTrinhdo(String trinhdo) {
        this.trinhdo = trinhdo;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

    public String getTenkhoa() {
        return tenkhoa;
    }

    public void setTenkhoa(String tenkhoa) {
        this.tenkhoa = tenkhoa;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public NguoiDung(int manguoidung, String tennguoidung, String hinh, String ngaysinh, String gioitinh, String tenlop, String trinhdo, String chucvu, String tenkhoa, String matkhau, String stat) {
        this.manguoidung = manguoidung;
        this.tennguoidung = tennguoidung;
        this.hinh = hinh;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.tenlop = tenlop;
        this.trinhdo = trinhdo;
        this.chucvu = chucvu;
        this.tenkhoa = tenkhoa;
        this.matkhau = matkhau;
        this.stat = stat;
    }
}