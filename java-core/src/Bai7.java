import java.util.Scanner;

public class Bai7 {
    public static void main(String[] args) {
        int number;
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap vao 1 so tu nhien de tim uoc so: ");
        number = scanner.nextInt();
        System.out.println("cac uoc so cua " + number + " la: ");
        uocSoTuNhien(number);
    }

    public static void uocSoTuNhien(int number) {
        for (int i = 1; i <= number / 2; i++)
            if (number % i == 0)
                System.out.print(i + " ");
        System.out.print(number);
    }
}
