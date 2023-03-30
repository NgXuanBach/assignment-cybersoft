package model;

public class GiamDoc extends NhanVien {
    private double coPhan;
    private double thuNhap;

    public GiamDoc(String maSo, String hoTen, int soDienThoai, int soNgayLamViec, double luong1Ngay, int coPhan) {
        super(maSo, hoTen, soDienThoai, soNgayLamViec, luong1Ngay);
        this.coPhan = coPhan;
    }

    public double getCoPhan() {
        return coPhan;
    }

    public void setCoPhan(double coPhan) {
        this.coPhan = coPhan;
    }

    @Override
    public double luongThang() {
        return getLuong1Ngay() * getSoNgayLamViec();
    }

    public double getThuNhap() {
        return thuNhap;
    }

    public void setThuNhap(double thuNhap) {
        this.thuNhap = thuNhap;
    }

    @Override
    public String toString() {
        return "NhanVienThuong{" +
                "maSo='" + getMaSo() + '\'' +
                ", hoTen='" + getHoTen() + '\'' +
                ", soDienThoai=" + getSoDienThoai() +
                ", soNgayLamViec=" + getSoNgayLamViec() +
                ", luong1Ngay=" + getLuong1Ngay() + "Luong thang= " + luongThang() + "Co phan= " + coPhan +
                '}';
    }

}
