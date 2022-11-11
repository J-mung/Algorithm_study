package SwExpertAcademy.Diff2;

import java.util.Scanner;

public class ChangeMoney_1970 {
    private static final int[] Moneys = {50000, 10000, 5000, 1000, 500, 100, 50, 10};

    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            int money = sc.nextInt();
            int result = 0;

            System.out.println("#" + (i + 1));

            for (int j = 0; j < Moneys.length; j++) {
                System.out.print(money / Moneys[j] + " ");
                money %= Moneys[j];
            }
        }
    }
}
