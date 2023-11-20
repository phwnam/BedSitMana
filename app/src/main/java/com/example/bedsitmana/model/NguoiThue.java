package com.example.bedsitmana.model;

public class NguoiThue {
    private String maNguoithue,matKhauNT,tenNguoiThue,thuongTru,sdt;
    private int cCCD,namSinh;
    private int gioiTinh;
    private int maPhong;

    public NguoiThue() {
    }

    public NguoiThue(String maNguoithue, String matKhauNT, String tenNguoiThue, String thuongTru, String sdt, int cCCD, int namSinh, int gioiTinh, int maPhong) {
        this.maNguoithue = maNguoithue;
        this.matKhauNT = matKhauNT;
        this.tenNguoiThue = tenNguoiThue;
        this.thuongTru = thuongTru;
        this.sdt = sdt;
        this.cCCD = cCCD;
        this.namSinh = namSinh;
        this.gioiTinh = gioiTinh;
        this.maPhong = maPhong;
    }

    public String getMaNguoithue() {
        return maNguoithue;
    }

    public void setMaNguoithue(String maNguoithue) {
        this.maNguoithue = maNguoithue;
    }

    public String getMatKhauNT() {
        return matKhauNT;
    }

    public void setMatKhauNT(String matKhauNT) {
        this.matKhauNT = matKhauNT;
    }

    public String getTenNguoiThue() {
        return tenNguoiThue;
    }

    public void setTenNguoiThue(String tenNguoiThue) {
        this.tenNguoiThue = tenNguoiThue;
    }

    public String getThuongTru() {
        return thuongTru;
    }

    public void setThuongTru(String thuongTru) {
        this.thuongTru = thuongTru;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getcCCD() {
        return cCCD;
    }

    public void setcCCD(int cCCD) {
        this.cCCD = cCCD;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(int maPhong) {
        this.maPhong = maPhong;
    }
}
