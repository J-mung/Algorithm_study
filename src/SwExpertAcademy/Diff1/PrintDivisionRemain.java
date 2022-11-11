package SwExpertAcademy.Diff1;

import java.util.Scanner;

public class PrintDivisionRemain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println("#" + (i + 1) + " " + (a / b) + " " + (a % b));
        }
    }
}
