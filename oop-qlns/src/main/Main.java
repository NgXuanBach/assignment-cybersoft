package main;

import com.sun.org.apache.xerces.internal.impl.dv.xs.SchemaDVFactoryImpl;
import handle.CongTyHandler;

import java.util.Scanner;

public class Main {
    private static CongTyHandler congTyHandler = new CongTyHandler();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int number = -1;
        do {
            showMenu();
            System.out.println("Chon menu: ");
            number = scanner.nextInt();
            switch (number) {
                case 0:
                    System.out.println("Ket thuc chuong trinh !");
                    break;
                case 1:
                    congTyHandler.nhapThongTin();
                    break;
                case 2:
                    congTyHandler.chiDinhNhanVienVaoTruongPhong();
                    break;
                case 3:
                    congTyHandler.themXoaNhanSu();
                    break;
                case 4:
                    congTyHandler.xuatThongTinNhanVienCongTy();
                    break;
                case 5:
                    congTyHandler.tongLuongToanCongTy();
                    break;
                case 6:
                    congTyHandler.nhanVienThuongLuongCaoNhat();
                    break;
                case 7:
                    congTyHandler.truongPhongCoSoLuongNhanVienDuoiQuyenNhieuNhat();
                    break;
                case 8:
                    congTyHandler.sapXepNhanVienTheoTen();
                    break;
                case 9:
                    congTyHandler.sapXepGiamDanNhanVienTheoLuong();
                    break;
                case 10:
                    congTyHandler.giamDocCoLuongCoPhieuCaoNhat();
                    break;
                case 11:
                    congTyHandler.tongThuNhapCuaTungGiamDoc();
                    break;
                default:
                    System.out.println("Nhập sai vui lòng nhập lại !");
            }
        } while (number != 0);

    }

    public static void showMenu() {
        System.out.println("0. Kết thúc chương trình\n" +
                "1. Nhập thông tin công ty\n" +
                "2. Phân bổ Nhân viên vào Trưởng phòng\n" +
                "3. Thêm, xóa thông tin một nhân sự (có thể là Nhân viên, trưởng phòng hoặc giám đốc)\n" +
                "4. Xuất ra thông tin toàn bộ người trong công ty\n" +
                "5. Tính và xuất tổng lương cho toàn công ty\n" +
                "6. Tìm Nhân viên thường có lương cao nhất\n" +
                "7. Tìm Trưởng Phòng có số lượng nhân viên dưới quyền nhiều nhất\n" +
                "8. Sắp xếp nhân viên toàn công ty theo thứ tự abc\n" +
                "9. Sắp xếp nhân viên toàn công ty theo thứ tự lương giảm dần\n" +
                "10. Tìm Giám Đốc có số lượng cổ phần nhiều nhất\n" +
                "11. Tính và Xuất tổng THU NHẬP của từng Giám Đốc ");
    }


}

