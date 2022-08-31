package Baekjoon.Recursion;

import java.util.Scanner;

public class Fibonacci_10870 {
    private static long[] fibo;

    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();
        fibo = new long[N + 1];

        System.out.println(fibonacci(N));
    }

    private static long fibonacci(int n) {

        // 값이 저장되어 있으면 반환
        if (fibo[n] != 0) {
            return fibo[n];
        }
        // 그렇지 않을 때
        else {

            // n이 1 이거나 2 이면 1을 저장
            if (n == 1 || n == 2) {
                fibo[n] = 1;
            }
            // 0, 1, 2 이외의 숫자일 경우 재귀해서 합을 구함
            else if (n != 0) {
                fibo[n] = fibonacci(n - 1) + fibonacci(n - 2);
            }
            // 반환
            return fibo[n];
        }
    }
}
