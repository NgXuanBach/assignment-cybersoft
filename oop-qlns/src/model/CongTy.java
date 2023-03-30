package model;

import java.util.LinkedList;
import java.util.List;

public class CongTy {
    private String tenCongTy;
    private String maSoThue;
    private double doanhThuThang;
    private List<NhanVien> nhanVienList = new LinkedList<>();

    public String getTenCongTy() {
        return tenCongTy;
    }

    public void setTenCongTy(String tenCongTy) {
        this.tenCongTy = tenCongTy;
    }

    public List<NhanVien> getNhanVienList() {
        return nhanVienList;
    }

    public String getMaSoThue() {
        return maSoThue;
    }

    public void setMaSoThue(String maSoThue) {
        this.maSoThue = maSoThue;
    }

    public double getDoanhThuThang() {
        return doanhThuThang;
    }

    public void setDoanhThuThang(double doanhThuThang) {
        this.doanhThuThang = doanhThuThang;
    }
}
