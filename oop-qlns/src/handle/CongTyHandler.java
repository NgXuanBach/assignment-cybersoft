package handle;

import model.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CongTyHandler {
    Scanner scanner = new Scanner(System.in);
    CongTy congTy;

    public void nhapThongTin() {
        System.out.println("Nhap ten cong ty: ");
        String tenCongTy = scanner.nextLine();
        System.out.println("Nhap ma so thue cong ty: ");
        String maSoThue = scanner.nextLine();
        System.out.println("Nhap doanh thu thang cong ty: ");
        double doanhThuThang = scanner.nextDouble();
        congTy = new CongTy(tenCongTy, maSoThue, doanhThuThang);
    }

    public NhanVien timNhanVienTheoID(String nhanVienID) {
        for (NhanVien nhanVien :
                congTy.getNhanVienList()) {
            if (nhanVien instanceof NhanVienThuong)
                if (nhanVien.getMaSo().toLowerCase().equals(nhanVienID.toLowerCase()))
                    return nhanVien;
        }
        return null;
    }

    public NhanVien timTruongPhongTheoID(String truongPhongID) {
        for (NhanVien nhanVien :
                congTy.getNhanVienList()) {
            if (nhanVien instanceof TruongPhong)
                if (nhanVien.getMaSo().toLowerCase().equals(truongPhongID.toLowerCase()))
                    return nhanVien;
        }
        return null;
    }

    public void truongPhongCoSoLuongNhanVienDuoiQuyenNhieuNhat() {
        if (congTy == null) {
            System.out.println("Thong tin cong ty chua duoc nhap. ");
            return;
        }
        int max = 0;
        NhanVien nhanVienTemp = null;
        for (NhanVien nhanVien :
                congTy.getNhanVienList()) {
            if (nhanVien instanceof TruongPhong)
                if (((TruongPhong) nhanVien).getSoLuongNhanVienDuoiQuyen() > max) {
                    max = ((TruongPhong) nhanVien).getSoLuongNhanVienDuoiQuyen();
                    nhanVienTemp = nhanVien;
                }
        }
        System.out.println((TruongPhong) nhanVienTemp);
    }

    public void chiDinhNhanVienVaoTruongPhong() {
        if (congTy == null) {
            System.out.println("Thong tin cong ty chua duoc nhap. ");
            return;
        }
        scanner.nextLine();
        while (true) {
            xuatThongTinNhanVienCongTy();
//            scanner.next();
            System.out.println("Nhap ma so nhan vien de chi dinh  ( 0 de thoat ): ");
            String nhanVienID;
            nhanVienID = scanner.nextLine();
            if (nhanVienID.toLowerCase().equals("0"))
                break;
            NhanVien nhanVien = timNhanVienTheoID(nhanVienID);
            if (nhanVien == null) {
                System.out.println("Khong tim thay nhan vien nay ");
                continue;
            }
            System.out.println("Nhap ma so truong phong de chi dinh vao (0 de xoa') : ");
            String truongPhongID;
            truongPhongID = scanner.nextLine();
            if (truongPhongID.toLowerCase().equals("0")) {
                ((NhanVienThuong) nhanVien).setTruongPhong(null);
                System.out.println("Nhan vien nay da bi loai khoi bo phan");
            } else {
                NhanVien nhanVien2 = timTruongPhongTheoID(truongPhongID);
                if (nhanVien2 == null) {
                    System.out.println("Khong tim thay truong phong nay.");
                    continue;
                }
                ((NhanVienThuong) nhanVien).setTruongPhong((TruongPhong) nhanVien2);
                ((TruongPhong) nhanVien2).setSoLuongNhanVienDuoiQuyen(((TruongPhong) nhanVien2).getSoLuongNhanVienDuoiQuyen() + 1);
                System.out.println("Chi dinh thanh cong!");
            }
        }
    }

    public void giamDocCoLuongCoPhieuCaoNhat() {
        if (congTy == null) {
            System.out.println("Thong tin cong ty chua duoc nhap. ");
            return;
        }
        double max = 0;
        NhanVien nhanVienTemp = null;
        for (NhanVien nhanVien :
                congTy.getNhanVienList()) {
            if (nhanVien instanceof GiamDoc && ((GiamDoc) nhanVien).getCoPhan() > max) {
                max = ((GiamDoc) nhanVien).getCoPhan();
                nhanVienTemp = nhanVien;
            }
        }
        System.out.println("Giam doc co luong co phieu cao nhat la: ");
        System.out.println(nhanVienTemp);

    }

    public void tongThuNhapCuaTungGiamDoc() {
        if (congTy == null) {
            System.out.println("Thong tin cong ty chua duoc nhap. ");
            return;
        }
        for (NhanVien nhanVien :
                congTy.getNhanVienList()) {
            if (nhanVien instanceof GiamDoc) {
                ((GiamDoc) nhanVien).setThuNhap(nhanVien.luongThang() + ((GiamDoc) nhanVien).getCoPhan() * congTy.getLoiNhuan());
                System.out.println(nhanVien);
                System.out.println(((GiamDoc) nhanVien).getCoPhan());
            }
        }
    }


    public void addNhanVien() {
        int number;
        NhanVien nhanVien = null;
        System.out.println("Ban muon them nhan vien nao: \n" +
                "1: Nhan vien thuong \n" +
                "2: Truong phong \n" +
                "3: Giam doc");
        number = scanner.nextInt();
        scanner.nextLine();//bat ki tu
        if (number == 1) {
            nhanVien = new NhanVienThuong();
            System.out.println("Ten nhan vien: ");
            nhanVien.setHoTen(scanner.nextLine());
            System.out.println("Ma so nhan vien: ");
            nhanVien.setMaSo(scanner.nextLine());
            System.out.println("So dien thoai nhan vien: ");
            nhanVien.setSoDienThoai(scanner.nextInt());
            System.out.println("So ngay lam viec: ");
            nhanVien.setSoNgayLamViec(scanner.nextInt());
            congTy.getNhanVienList().add(nhanVien);
        } else if (number == 2) {
            nhanVien = new TruongPhong();
            System.out.println("Ten truong phong: ");
            nhanVien.setHoTen(scanner.nextLine());
            System.out.println("Ma so truong phong: ");
            nhanVien.setMaSo(scanner.nextLine());
            System.out.println("So dien thoai truong phong: ");
            nhanVien.setSoDienThoai(scanner.nextInt());
            System.out.println("So ngay lam viec: ");
            nhanVien.setSoNgayLamViec(scanner.nextInt());
            congTy.getNhanVienList().add(nhanVien);
        } else if (number == 3) {
            System.out.println("Ten giam doc: ");
            String ten = scanner.nextLine();
            System.out.println("Ma so giam doc: ");
            String maSo = scanner.nextLine();
            System.out.println("So dien thoai giam doc: ");
            int sdt = scanner.nextInt();
            System.out.println("So ngay lam viec: ");
            int soNgayLamViec = scanner.nextInt();
            System.out.println("Co phan: ");
            int coPhan = scanner.nextInt();
            nhanVien = new GiamDoc(maSo, ten, sdt, soNgayLamViec, 300, coPhan);
            congTy.getNhanVienList().add(nhanVien);
        }
    }

    public void themXoaNhanSu() {
        if (congTy == null) {
            System.out.println("Thong tin cong ty chua duoc nhap. ");
            return;
        }
        int number = -1;
        System.out.println("Ban muon Them:1\n" +
                "Xoa:2");
        number = scanner.nextInt();
        if (number == 1) {
            addNhanVien();
        } else {
            String maNV;
            System.out.println("Nhap ma nhan vien ma ban muon xoa: ");
            maNV = scanner.nextLine();
            for (NhanVien nhanVien :
                    congTy.getNhanVienList()) {

                if (maNV.toLowerCase().equals(nhanVien.getMaSo().toLowerCase())) {
                    if (nhanVien instanceof TruongPhong) {
                        for (NhanVien nhanVIenThuong : congTy.getNhanVienList()) {
                            if (nhanVIenThuong instanceof NhanVienThuong)
                                ((NhanVienThuong) nhanVIenThuong).setTruongPhong(null);
                        }
                    }
                    congTy.getNhanVienList().remove(nhanVien);
                }

            }
        }
    }

    public void nhanVienThuongLuongCaoNhat() {
        if (congTy == null) {
            System.out.println("Thong tin cong ty chua duoc nhap. ");
            return;
        }
        double max = 0;
        for (NhanVien nhanVien :
                congTy.getNhanVienList()) {
            if (nhanVien.luongThang() > max)
                System.out.println(nhanVien);
        }
    }


    public void sapXepNhanVienTheoTen() {
        if (congTy == null) {
            System.out.println("Thong tin cong ty chua duoc nhap. ");
            return;
        }
        Collections.sort(congTy.getNhanVienList(), new Comparator<NhanVien>() {

            public int compare(NhanVien o1, NhanVien o2) {
                return o1.getHoTen().compareTo(o2.getHoTen());

            }
        });
        System.out.println("Sắp xếp xong !. ");
    }

    public void sapXepGiamDanNhanVienTheoLuong() {
        if (congTy == null) {
            System.out.println("Thong tin cong ty chua duoc nhap. ");
            return;
        }
        int n = congTy.getNhanVienList().size();

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (congTy.getNhanVienList().get(j).luongThang() > congTy.getNhanVienList().get(min_idx).luongThang())
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            NhanVien temp = congTy.getNhanVienList().get(min_idx);
            congTy.getNhanVienList().set(min_idx, congTy.getNhanVienList().get(i));
            congTy.getNhanVienList().set(i, temp);
        }

        System.out.println("Sắp xếp xong !. ");
    }

    public void tongLuongToanCongTy() {
        if (congTy == null) {
            System.out.println("Thong tin cong ty chua duoc nhap. ");
            return;
        }
        double tongLuong = 0;
        for (NhanVien nhanVien : congTy.getNhanVienList()) {
            tongLuong += nhanVien.luongThang();
        }
        System.out.println("Luong toan cong ty: " + tongLuong);
        congTy.setLoiNhuan(congTy.getDoanhThuThang() - tongLuong);
    }

    /**
     * Xuat thong tin toan bo nhan vien trong cong ty
     */
    public void xuatThongTinNhanVienCongTy() {
        if (congTy == null) {
            System.out.println("Thong tin cong ty chua duoc nhap. ");
            return;
        }
        List<NhanVien> listNhanVien = congTy.getNhanVienList();
        for (int i = 0; i < listNhanVien.size(); i++) {
            System.out.println("Nhan vien thu " + (i + 1) + ": ");
            if (listNhanVien.get(i) instanceof NhanVienThuong)
                System.out.println(((NhanVienThuong) listNhanVien.get(i)).toString());
            if (listNhanVien.get(i) instanceof TruongPhong)
                System.out.println(((TruongPhong) listNhanVien.get(i)).toString());
            if (listNhanVien.get(i) instanceof GiamDoc)
                System.out.println(((GiamDoc) listNhanVien.get(i)).toString());
            System.out.println("---------------------------------------");
        }
    }
}
