package SwExpertAcademy.Diff2;

import java.util.Scanner;

public class SolveMiddleAverage_1984 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            int max = -1;
            int min = 10001;
            int avrag = 0;

            for (int j = 0; j < 10; j++) {
                int val = sc.nextInt();
                if (max < val) {
                    max = val;
                }
                if (min > val) {
                    min = val;
                }
                avrag += val;
            }
            avrag = avrag - min - max;
            System.out.println("#" + (i + 1) + " " + Math.round((float) avrag / 8));
        }
    }
}
