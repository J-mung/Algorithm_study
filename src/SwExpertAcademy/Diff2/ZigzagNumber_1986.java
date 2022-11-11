package SwExpertAcademy.Diff2;

import java.util.Scanner;

public class ZigzagNumber_1986 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            int N = sc.nextInt();
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                if (j % 2 == 0)
                    sum -= j;
                else
                    sum += j;
            }
            System.out.println("#" + (i + 1) + " " + sum);
        }
    }
}
