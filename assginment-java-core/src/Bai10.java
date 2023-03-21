import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;

import java.util.Scanner;

public class Bai10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao so tu nhien: ");
        int number = scanner.nextInt();
        System.out.println("Tong cac so nguyen to tu 1 den " + number + " la: " + tongSoNguyenTo(number));
    }

    public static int tongSoNguyenTo(int number) {
        int sum = 2;
        System.out.print(2+" ");
        for (int i = 3; i <= number; i += 2) {
            if (checkSoNguyenTO(i))
                System.out.print(i + " ");
            sum += i;
        }
        return sum;
    }

    public static boolean checkSoNguyenTO(int number) {
        if (number >= 2) {
            for (int i = 3; i <= number / 2; i += 2) {
                if (number % i == 0)
                    return false;
            }
            return true;
        } else
            return false;
    }
}
