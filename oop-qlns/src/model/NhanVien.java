package model;

public abstract class NhanVien {
    private String maSo;
    private String hoTen;
    private int soDienThoai;
    private int soNgayLamViec;
    private double luong1Ngay;
    public NhanVien(String maSo, String hoTen, int soDienThoai, int soNgayLamViec, double luong1Ngay) {
        this.maSo = maSo;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.soNgayLamViec = soNgayLamViec;
        this.luong1Ngay = luong1Ngay;
    }

    public NhanVien() {
    }

    public String getMaSo() {
        return maSo;
    }

    public String getHoTen() {
        return hoTen;
    }

    public int getSoDienThoai() {
        return soDienThoai;
    }

    public int getSoNgayLamViec() {
        return soNgayLamViec;
    }

    public double getLuong1Ngay() {
        return luong1Ngay;
    }

    public void setMaSo(String maSo) {
        this.maSo = maSo;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setSoDienThoai(int soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public void setSoNgayLamViec(int soNgayLamViec) {
        this.soNgayLamViec = soNgayLamViec;
    }

    public void setLuong1Ngay(double luong1Ngay) {
        this.luong1Ngay = luong1Ngay;
    }

    public abstract double luongThang();

    @Override
    public String toString() {
        return "NhanVien{" +
                "maSo='" + maSo + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", soDienThoai=" + soDienThoai +
                ", soNgayLamViec=" + soNgayLamViec +
                ", luong1Ngay=" + luong1Ngay +
                '}';
    }
}
