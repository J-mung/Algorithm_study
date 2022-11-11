package SwExpertAcademy.Diff2;

import java.util.Scanner;

public class SimpleFactorization_1945 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            int num = sc.nextInt();
            int a = 0;
            int b = 0;
            int c = 0;
            int d = 0;
            int e = 0;

            while(num % 2 == 0) { num /= 2; a++; }
            while(num % 3 == 0) { num /= 3; b++; }
            while(num % 5 == 0) { num /= 5; c++; }
            while(num % 7 == 0) { num /= 7; d++; }
            while(num % 11 == 0) { num /= 11; e++; }

            System.out.format("#%d %d %d %d %d %d\n", (i + 1), a, b, c, d, e);
        }
    }
}
