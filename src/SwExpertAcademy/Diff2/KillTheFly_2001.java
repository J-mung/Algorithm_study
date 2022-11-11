package SwExpertAcademy.Diff2;

import java.util.Scanner;

public class KillTheFly_2001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int matrix[][] = new int[N][N];

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    matrix[j][k] = sc.nextInt();
                }
            }

            int sum;
            int max = -1;

            System.out.print("#" + (i + 1) + " ");
            for (int j = 0; j < N - M + 1; j++) {
                for (int k = 0; k < N - M + 1; k++) {
                    sum = 0;
                    for (int l = 0; l < M; l++) {
                        for (int m = 0; m < M; m++) {
                            sum += matrix[j + l][k + m];
                        }
                    }
                    if (sum > max) {
                        max = sum;
                    }
                }
            }

            System.out.println(max);
        }
    }
}
