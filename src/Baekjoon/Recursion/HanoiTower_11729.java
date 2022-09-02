package Baekjoon.Recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class HanoiTower_11729 {
    private static StringBuilder result;

    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();
        result = new StringBuilder();

        result.append((int)Math.pow(2, N) - 1).append("\n");
        hanoi(N, 1, 2, 3);

        System.out.println(result);
    }

    private static void hanoi(int N, int start, int mid, int to) {
        if(N == 1) {
            result.append(start + " " + to + "\n");
            return;
        }

        hanoi(N - 1, start, to, mid);
        result.append(start + " " + to + "\n");
        hanoi(N - 1, mid, start, to);
    }
}
