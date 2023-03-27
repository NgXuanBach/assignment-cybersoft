import java.util.Scanner;

public class Bai12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        System.out.println("Nhap n (tu 1 den 9): ");
        number = scanner.nextInt();
        handle(number);
    }

    public static void handle(int number) {
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= i; j++)
                System.out.print(j);
            System.out.println();
        }
    }
}
