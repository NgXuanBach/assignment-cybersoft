package model;

import java.util.LinkedList;
import java.util.List;

public class TruongPhong extends NhanVien {
    public TruongPhong(String maSo, String hoTen, int soDienThoai, int soNgayLamViec, double luong1Ngay) {
        super(maSo, hoTen, soDienThoai, soNgayLamViec, luong1Ngay);
    }
    public TruongPhong(){}
    private List<NhanVienThuong> nhanVienDuoiQuyenList = new LinkedList<>();

    public List<NhanVienThuong> getNhanVienDuoiQuyenList() {
        return nhanVienDuoiQuyenList;
    }

    public void addNhanVienThuongList(NhanVienThuong nhanVienThuong) {
        this.nhanVienDuoiQuyenList.add(nhanVienThuong);
    }


    @Override
    public double luongThang() {
        return getLuong1Ngay() * getSoNgayLamViec() + 100 * nhanVienDuoiQuyenList.size();
    }

    @Override
    public String toString() {
        return "NhanVienThuong{" +
                "maSo='" + getMaSo() + '\'' +
                ", hoTen='" + getHoTen() + '\'' +
                ", soDienThoai=" + getSoDienThoai() +
                ", soNgayLamViec=" + getSoNgayLamViec() +
                ", luong1Ngay=" + getLuong1Ngay() + "Luong thang= " + luongThang() + "So luong nhan vien duoi quyen" + nhanVienDuoiQuyenList.size() +
                '}';
    }
}
