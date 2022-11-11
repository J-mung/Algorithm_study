package SwExpertAcademy.Diff1;

import java.util.Scanner;

public class NsDivisor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            int remain = N % i;
            if (remain == 0)
                System.out.print(i + " ");
        }
    }
}
