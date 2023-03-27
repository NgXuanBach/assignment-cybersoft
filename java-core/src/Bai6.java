import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string;
        System.out.println("Nhap chuoi: ");
        string = scanner.nextLine();
        handleString(string);
    }

    public static void handleString(String string) {
        for (int i = string.length() - 1; i >= 0; i--) {
            System.out.print(string.charAt(i));
        }
    }
}
