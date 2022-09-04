package Baekjoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Coin0_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tokens.nextToken());
        int K = Integer.parseInt(tokens.nextToken());
        int[] coins = new int[N];

        for (int i = 0; i < N; i++) {
            tokens = new StringTokenizer(br.readLine());
            coins[i] = Integer.parseInt(tokens.nextToken());
        }

        int answer = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (K >= coins[i]) {
                answer += K / coins[i];
                K = K % coins[i];
            }
        }

        System.out.println(answer);
    }
}
