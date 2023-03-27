import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        System.out.println("Nhap vao so tu nhien: ");
        number = scanner.nextInt();
        System.out.println("Tong cac chu so cua " + number + " la: " + sumNumber(number));
    }

    public static int sumNumber(int number) {
        int result = 0;
        while (number > 0) {
            result += number % 10;
            number /= 10;
        }
        return result;
    }
}
