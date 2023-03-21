import sun.plugin2.main.client.WDonatePrivilege;

import java.util.Scanner;

public class Karaoke {
    public static void main(String[] args) {
        int start = 0;
        int end = 0;
        int numberOfWaterBottles = 0;
        totalBill(start, end, numberOfWaterBottles);
    }

    public static float calculateMoney(int time) {
        float result = 0;
        if (time > 0) {
            if (time <= 3)
                result += (30000 * time);
            else
                result += (30000 * 3) + (time - 3) * (30000 * 3) * 0.3;
            return result;
        }
        return 0;
    }

    public static void totalBill(int start, int end, int numberOfWaterBottles) {
        double total = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter start time: ");
            start = scanner.nextInt();
            if (start < 9 || start > 24)
                System.out.println("Time of open the door is from 9h to 24h, please enter again! : ");
        } while (start < 9 || start > 24);
        do {
            System.out.println("Enter end time: ");
            end = scanner.nextInt();
            if (end < 9 || end > 24)
                System.out.println("Time of close the door is from 24h to 9h, please enter again! : ");
            else if (end < start)
                System.out.println("The end time must be less than the start time. please enter again! : ");
        } while (end < 9 || end > 24 || end < start);
        do {
            System.out.println("Enter number of water bottles: ");
            numberOfWaterBottles = scanner.nextInt();
            if (numberOfWaterBottles < 0) {
                System.out.println("Number of water bottles must be more than 0: ");
            }
        } while (numberOfWaterBottles < 0);
        if (end <= 17)
            total = total(end - start, numberOfWaterBottles) - total(end - start, numberOfWaterBottles) * 0.2;
        System.out.println("Total: " + total);
    }

    public static float total(int time, int numberOfWaterBottles) {
        return calculateMoney(time) + numberOfWaterBottles * 10000;
    }
}
