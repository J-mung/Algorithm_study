package SwExpertAcademy.Diff1;

import java.util.Scanner;

public class MaximumNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int max;

        for (int i = 0; i < N; i++) {
            max = -1;
            for (int j = 0; j < 10; j++) {
                int val = sc.nextInt();
                if (max < val)
                    max = val;
            }
            System.out.println("#" + (i + 1) + " " + max);
        }
    }
}
