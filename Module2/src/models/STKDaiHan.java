package models;

import models.SoTietKiem;

public class STKDaiHan extends SoTietKiem {
    String uuDai;
    int kyHan;

    public STKDaiHan() {
    }

    public STKDaiHan(String maSoSo, String maKH, String ngayMoSo, String thoiGianGui, double soTienGui, float laiSuat) {
        super(maSoSo, maKH, ngayMoSo, thoiGianGui, soTienGui, laiSuat);
    }

    public STKDaiHan(String maSoSo, String maKH, String ngayMoSo, String thoiGianGui, double soTienGui, float laiSuat, String uuDai, int kyHan) {
        super(maSoSo, maKH, ngayMoSo, thoiGianGui, soTienGui, laiSuat);
        this.uuDai = uuDai;
        this.kyHan = kyHan;
    }

    public String getUuDai() {
        return uuDai;
    }

    public void setUuDai(String uuDai) {
        this.uuDai = uuDai;
    }

    public int getKyHan() {
        return kyHan;
    }

    public void setKyHan(int kyHan) {
        this.kyHan = kyHan;
    }
}
