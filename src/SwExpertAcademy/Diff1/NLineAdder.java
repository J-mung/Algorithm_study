package SwExpertAcademy.Diff1;

import java.util.Scanner;

public class NLineAdder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.println(N * (N + 1) / 2);
    }
}
