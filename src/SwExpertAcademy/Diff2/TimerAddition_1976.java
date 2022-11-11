package SwExpertAcademy.Diff2;

import java.util.Scanner;

public class TimerAddition_1976 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            int A = sc.nextInt();
            int a = sc.nextInt();
            int B = sc.nextInt();
            int b = sc.nextInt();

            int hour = ((A + B) % 12) + ((a + b) / 60);
            int minute = (a + b) % 60;

            System.out.println("#" + (i + 1) + " " + hour + " " + minute);
        }
    }
}