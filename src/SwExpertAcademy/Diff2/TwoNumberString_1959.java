package SwExpertAcademy.Diff2;

import java.util.Scanner;

public class TwoNumberString_1959 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {

            // A 배열, B 배열 입력
            int sizeA = sc.nextInt();
            int sizeB = sc.nextInt();
            int[] A = new int[sizeA];
            int[] B = new int[sizeB];

            for (int j = 0; j < sizeA; j++) {
                A[j] = sc.nextInt();
            }
            for (int j = 0; j < sizeB; j++) {
                B[j] = sc.nextInt();
            }

            // 길이 별로 다시 초기화
            int[] longer;
            int[] shorter;

            if (sizeA > sizeB) {
                longer = A;
                shorter = B;
            } else {
                longer = B;
                shorter = A;
            }

            int max = -1;
            // solution
            for (int j = 0; j <= longer.length - shorter.length; j++) {
                int sum = 0;
                for (int k = 0; k < shorter.length; k++) {
                    sum += shorter[k] * longer[k + j];
                }
                max = Math.max(max, sum);
            }

            System.out.println("#" + (i + 1) + " " + max);
        }
    }
}
