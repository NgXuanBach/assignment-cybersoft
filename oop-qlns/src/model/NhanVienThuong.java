package model;

public class NhanVienThuong extends NhanVien {
    TruongPhong truongPhong;
    public NhanVienThuong() {
        setLuong1Ngay(100);
    }

    public TruongPhong getTruongPhong() {
        return truongPhong;
    }

    public void setTruongPhong(TruongPhong truongPhong) {
        this.truongPhong = truongPhong;
    }

    @Override
    public double luongThang() {
        return getLuong1Ngay() * getSoNgayLamViec();
    }

    @Override
    public String toString() {
        return "NhanVienThuong{" +
                "maSo='" + getMaSo() + '\'' +
                ", hoTen='" + getHoTen() + '\'' +
                ", soDienThoai=" + getSoDienThoai() +
                ", soNgayLamViec=" + getSoNgayLamViec() +
                ", luong1Ngay=" + getLuong1Ngay() + ", Luong thang= " + luongThang() +
                '}';
    }
}
