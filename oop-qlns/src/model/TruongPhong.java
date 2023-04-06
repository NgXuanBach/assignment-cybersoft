package model;

import java.util.LinkedList;
import java.util.List;

public class TruongPhong extends NhanVien {
    public TruongPhong(String maSo, String hoTen, int soDienThoai, int soNgayLamViec, double luong1Ngay) {
        super(maSo, hoTen, soDienThoai, soNgayLamViec, luong1Ngay);
        setLuong1Ngay(200);
    }

    private int soLuongNhanVienDuoiQuyen = 0;

    public TruongPhong() {
    }

    public int getSoLuongNhanVienDuoiQuyen() {
        return soLuongNhanVienDuoiQuyen;
    }

    public void setSoLuongNhanVienDuoiQuyen(int soLuongNhanVienDuoiQuyen) {
        this.soLuongNhanVienDuoiQuyen = soLuongNhanVienDuoiQuyen;
    }

    @Override
    public double luongThang() {
        return getLuong1Ngay() * getSoNgayLamViec() + 100 * soLuongNhanVienDuoiQuyen;
    }

    @Override
    public String toString() {
        return "TruongPhong: " +
                "maSo='" + getMaSo() + '\'' +
                ", hoTen='" + getHoTen() + '\'' +
                ", soDienThoai=" + getSoDienThoai() +
                ", soNgayLamViec=" + getSoNgayLamViec() +
                ", luong1Ngay=" + getLuong1Ngay() + "Luong thang= " + luongThang() + "So luong nhan vien duoi quyen= " + soLuongNhanVienDuoiQuyen;
    }
}
