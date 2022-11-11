package SwExpertAcademy.Diff1;

import java.util.Scanner;

public class AddOddNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sum;

        for (int i = 0; i < N; i++) {
            sum = 0;
            for (int j = 0; j < 10; j++) {
                int tmp = sc.nextInt();
                if(tmp % 2 != 0)
                    sum += tmp;
            }
            System.out.println("#" + (i + 1) + " " + sum);
        }
    }
}
