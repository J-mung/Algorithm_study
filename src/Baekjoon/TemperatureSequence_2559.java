package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TemperatureSequence_2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tokens.nextToken());
        int k = Integer.parseInt(tokens.nextToken()) - 1;
        int[] arr = new int[N + 1];

        tokens = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(tokens.nextToken());
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i + k <= N; i++) {
            max = Math.max(max, arr[i + k] - arr[i - 1]);
        }

        System.out.println(max);
    }
}
