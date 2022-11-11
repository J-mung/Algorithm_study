package Baekjoon.CumulativeSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RemainderSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tokens.nextToken());
        int M = Integer.parseInt(tokens.nextToken());
        long[] arr = new long[M];

        int sum = 0;
        tokens = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sum = (Integer.parseInt(tokens.nextToken()) + sum) % M;
            arr[sum]++;
        }

        long answer = arr[0];
        for (int i = 0; i < M; i++) {
            answer += arr[i] * (arr[i] - 1) / 2;
        }

        System.out.println(answer);
    }
}
