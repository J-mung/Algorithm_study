package SwExpertAcademy.Diff1;

import java.util.Scanner;

public class CabinetPassword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int P = sc.nextInt();
        int K = sc.nextInt();
        int result = 0;

        for (int i = K; i <= P; i++) {
            result++;
        }

        System.out.println(result);
    }
}
