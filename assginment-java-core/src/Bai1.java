public class Bai1 {
    public static void main(String[] args) {
        int j = 0;
        for (int i = 0; i < 15; i++) {
            if (i < 9) {
                if (i % 2 == 0)
                    System.out.print("* * * * * * ");
                else {
                    System.out.print(" * * * * *  ");
                }
                System.out.println("=========================================================================");
            } else {
                System.out.println("=====================================================================================");
            }
        }
    }
}
