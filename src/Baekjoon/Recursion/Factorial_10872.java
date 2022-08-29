package Baekjoon.Recursion;

import java.util.Scanner;

public class Factorial_10872 {
    private static int[] fact;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        fact = new int[N + 1];

        long beforeTime = System.currentTimeMillis();
        System.out.println(factorial(N));
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("Recursion Time : " + secDiffTime);

        beforeTime = System.currentTimeMillis();
        System.out.println(memoi(N));
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Memoization Time : " + secDiffTime);
    }

    private static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static int memoi(int N) {
        if (fact[N] != 0) {
            return fact[N];
        } else {
            if ( N == 0 || N == 1) {
                fact[N] = 1;
            } else {
                fact[N] = memoi(N - 1) * N;
            }
            return fact[N];
        }
    }
}
