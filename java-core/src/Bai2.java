import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number1, number2;
        System.out.println("Enter decimal number to convert to binary number: ");
        number1 = scanner.nextInt();
        System.out.println("---> " + convertToBinary(number1));
        System.out.println("Enter binary number to convert to decimal number: ");
        number2 = scanner.nextInt();
        System.out.println("---> " + convertToDecimal(number2));
    }

    public static int convertToBinary(int number) {
        int result = 0;
        int temp = 0;
        int numberOfPow = 0;
        while (number > 0) {
            temp = number % 2;
            number /= 2;
            result += temp * Math.pow(10, numberOfPow);
            numberOfPow++;
        }
        return result;
    }

    public static int convertToDecimal(int number) {
        int result = 0;
        int temp = 0;
        int numberOfPow = 0;
        while (number > 0) {
            temp = number % 10;
            number /= 10;
            result += temp * Math.pow(2, numberOfPow);
            numberOfPow++;
        }
        return result;
    }
}
