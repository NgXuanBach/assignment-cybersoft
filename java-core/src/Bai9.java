import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai9 {
    public static void main(String[] args) {
        int number1=0, number2=0;
        System.out.println(handleAll(number1, number2));
    }

    public static boolean handle(int number1, int number2) {
        List<Integer> arr1 = new ArrayList<>();
        while (number1 != 0) {
            arr1.add(number1 % 10);
            number1 /= 10;
        }
        while (number2 != 0) {
            arr1.add(number2 % 10);
            number2 /= 10;
        }
        int i = 0, j = arr1.size() - 1;
        while (i <= 1) {
            if (arr1.get(i) == arr1.get(j))
                return true;
            else
                j--;
            if (j == 1) {
                i++;
                j = arr1.size() - 1;
            }
        }
        return false;
    }

    public static boolean handleAll(int number1, int number2) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Nhap so thu nhat [10 ; 99] : ");
            number1 = scanner.nextInt();
            if (number1 < 10 || number1 > 99)
                System.out.println("Nhap sai, vui long nhap lai tu [10 ; 99]");
        } while (number1 < 10 || number1 > 99);
        do {
            System.out.println("Nhap so thu hai [10 ; 99] : ");
            number2 = scanner.nextInt();
            if (number2 < 10 || number2 > 99)
                System.out.println("Nhap sai, vui long nhap lai tu [10 ; 99]");
        } while (number2 < 10 || number2 > 99);
        return handle(number1, number2);
    }

}
