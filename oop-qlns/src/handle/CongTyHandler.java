package handle;

import model.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class CongTyHandler {
    Scanner scanner = new Scanner(System.in);
    CongTy congTy = new CongTy();

    public void nhapThongTin() {
        System.out.println("Nhap ten cong ty: ");
        String tenCongTy = scanner.nextLine();
        congTy.setTenCongTy(tenCongTy);
        System.out.println("Nhap ma so thue cong ty: ");
        String maSoThue = scanner.nextLine();
        congTy.setMaSoThue(maSoThue);
        System.out.println("Nhap doanh thu thang cong ty: ");
        congTy.setDoanhThuThang(scanner.nextDouble());
    }

    public void giamDocCoLuongCoPhieuCaoNhat() {
        double max = 0;
        NhanVien nhanVienTemp=null;
        for (NhanVien nhanVien :
                congTy.getNhanVienList()) {
            if (nhanVien instanceof GiamDoc && ((GiamDoc) nhanVien).getCoPhan() > max) {
                max = ((GiamDoc) nhanVien).getCoPhan();
                nhanVienTemp=nhanVien;
            }
        }
        System.out.println("Giam doc co luong co phieu cao nhat la: ");
        System.out.println(nhanVienTemp);

    }
    public void tongThuNhapCuaTungGIamDoc(){
        for (NhanVien nhanVien :
                congTy.getNhanVienList()) {
            if (nhanVien instanceof GiamDoc ) {
                ((GiamDoc) nhanVien).setThuNhap(nhanVien.luongThang()+((GiamDoc) nhanVien).getCoPhan());
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
                if (maNV.toLowerCase().equals(nhanVien.getMaSo().toLowerCase()))
                    congTy.getNhanVienList().remove(nhanVien);
            }
        }
    }

    public void nhanVienThuongLuongCaoNhat() {
        double max = 0;
        for (NhanVien nhanVien :
                congTy.getNhanVienList()) {
            if (nhanVien.luongThang() > max)
                System.out.println(nhanVien);
        }
    }


    public void sapXepNhanVienTheoTen() {
        Collections.sort(congTy.getNhanVienList(), new Comparator<NhanVien>() {

            public int compare(NhanVien o1, NhanVien o2) {
                return o1.getHoTen().compareTo(o2.getHoTen());

            }
        });
        System.out.println("Sắp xếp xong !. ");
    }

    public void sapXepGiamDanNhanVienTheoLuong() {
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
        double tongLuong = 0;
        for (NhanVien nhanVien : congTy.getNhanVienList()) {
            tongLuong += nhanVien.luongThang();
        }
        System.out.println("Luong toan cong ty: " + tongLuong);
    }

    /**
     * Xuat thong tin toan bo nhan vien trong cong ty
     */
    public void xuatThongTinNhanVienCongTy() {
        for (int i = 0; i < congTy.getNhanVienList().size(); i++) {
            System.out.println("Nhan vien thu " + (i + 1) + ": ");
            congTy.getNhanVienList().get(i).toString();
            System.out.println("---------------------------------------");
        }
    }


}
