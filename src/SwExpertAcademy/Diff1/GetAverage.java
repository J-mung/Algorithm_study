package SwExpertAcademy.Diff1;

import java.util.Scanner;

public class GetAverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int avag = 0;
            for (int j = 0; j < 10; j++) {
                avag += sc.nextInt();
            }
            System.out.println("#" + (i + 1) + " " + Math.round(((float) avag / 10)));
        }
    }
}
