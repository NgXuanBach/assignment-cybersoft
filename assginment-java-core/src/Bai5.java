import java.util.List;
import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        int[] arr1 = new int[2];
        int[] arr2 = new int[2];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap toa do diem A(x1,y1): ");
        System.out.println("x1: ");
        arr1[0] = scanner.nextInt();
        System.out.println("y1: ");
        arr1[1] = scanner.nextInt();
        System.out.println("Nhap toa do diem B2(x2,y2): ");
        System.out.println("x2: ");
        arr2[0] = scanner.nextInt();
        System.out.println("y2: ");
        arr2[1] = scanner.nextInt();
        System.out.println("Do dai cua A den B la: " + lengthOfTwoPoints(arr1, arr2));
    }

    public static float lengthOfTwoPoints(int[] arr1, int[] arr2) {
        int[] canhGocVuong = new int[2];
        float result = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] >= arr2[i])
                canhGocVuong[i] = arr1[i] - arr2[i];
            else
                canhGocVuong[i] = arr2[i] - arr1[i];
        }
        result = (float) Math.sqrt(canhGocVuong[0] * canhGocVuong[0] + canhGocVuong[1] * canhGocVuong[1]);
        return result;
    }
}