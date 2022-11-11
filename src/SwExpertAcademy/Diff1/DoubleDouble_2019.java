package SwExpertAcademy.Diff1;

import java.util.Scanner;

public class DoubleDouble_2019 {
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        int val = sc.nextInt();

        for (int i = 0; i <= val; i++) {
            System.out.print((int)Math.pow(2, i) + " ");
        }
    }
}
