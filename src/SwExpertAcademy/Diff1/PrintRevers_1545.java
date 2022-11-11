package SwExpertAcademy.Diff1;

import java.util.Scanner;

public class PrintRevers_1545 {
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        int val = sc.nextInt();

        for (int i = val; i >= 0; i--) {
            System.out.print(i + " ");
        }
    }
}
