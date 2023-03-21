import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai13 {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        int length = 0;
        int index = 0;
        double temp;
        System.out.println("Nhap so luong phan tu trong mang: ");
        length = scanner.nextInt();
        inputArray(list, length);
        System.out.println(list);
        System.out.println("Gia tri trung binh cua mang la: " + avgArray(list));
        System.out.println("Gia tri lon nhat trong mang la: " + maxNumberInArray(list));
        System.out.println("Gia tri nho nhat trong mang la: " + minNumberInArray(list));
        System.out.println("Phan tu am lon nhat trong mang la: " + soAmLonNhat(list));
        System.out.println("Phan tu am nho nhat trong mang la: " + minNumberInArray(list));
        System.out.println("Phan tu duong lon nhat trong mang la: " + maxNumberInArray(list));
        System.out.println("Phan tu duong nho nhat trong mang la: " + soDuongNhoNhat(list));
        inSoChan(list);
        inSoLe(list);
        System.out.println("Them 1 phan tu vao vi tri: ");
        index = scanner.nextInt();
        System.out.println("Nhap phan tu ban muon them vao: ");
        temp = scanner.nextDouble();
        list.add(index, temp);
        System.out.println(list);
        System.out.println("Muon xoa phan tu o vi tri: ");
        index = scanner.nextInt();
        list.remove(index);
        System.out.println(list);

    }

    public static void inputArray(List<Double> arr, int number) {
        for (int i = 0; i < number; i++) {
            System.out.println("Nhap phan tu thu " + (i + 1) + ": ");
            arr.add(scanner.nextDouble());
        }
    }

    public static double avgArray(List<Double> arr) {
        double sum = 0;
        for (double temp : arr)
            sum += temp;
        return sum / arr.size();
    }

    public static double maxNumberInArray(List<Double> arr) {
        double max = arr.get(0);
        for (double temp : arr)
            if (temp > max)
                max = temp;
        return max;
    }

    public static double minNumberInArray(List<Double> arr) {
        double min = arr.get(0);
        for (double temp : arr)
            if (temp < min)
                min = temp;
        return min;
    }

    public static double soAmLonNhat(List<Double> arr) {
        double max = minNumberInArray(arr);
        for (double temp : arr)
            if (temp < 0)
                if (temp > max)
                    max = temp;
        return max;
    }

    public static double soDuongNhoNhat(List<Double> arr) {
        double min = maxNumberInArray(arr);
        for (double temp : arr)
            if (temp > 0)
                if (temp < min)
                    min = temp;
        return min;
    }

    public static void inSoChan(List<Double> arr) {
        System.out.print("Cac so chan trong mang la: ");
        for (double temp : arr)
            if (temp % 2 == 0)
                System.out.print(temp + " ");
    }

    public static void inSoLe(List<Double> arr) {
        System.out.print("Cac so le trong mang la: ");
        for (double temp : arr)
            if (temp % 2 != 0)
                System.out.print(temp + " ");
    }
}
