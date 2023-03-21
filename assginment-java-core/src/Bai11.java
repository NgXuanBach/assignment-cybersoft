import java.util.Scanner;

public class Bai11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        System.out.println("Nhap n > 1: ");
        n = scanner.nextInt();
        System.out.println("So tu nhien lon nhat nho hon log2 (n) la: " + handle(n));
    }

    public static int handle(int number) {
        if (number == 2)
            return 0;
        int result = 1;
        int soMu = -1;
        while (number > result) {
            result *= 2;
            soMu++;
        }
        return soMu;
    }
}
