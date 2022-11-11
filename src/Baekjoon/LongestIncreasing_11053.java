package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestIncreasing_11053 {
    private static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer tokens = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        int[] padding = new int[N];
        dp = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(tokens.nextToken());
        }

        for (int i = 0; i < N; i++) {
            LIS(i, arr);
        }

        /*for (int i = 0; i < N; i++) {
            padding[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && padding[i] < padding[j] + 1) {
                    padding[i] = padding[j] + 1;
                }
            }
        }*/

        /*int max = -1;
        for (int i = 0; i < N; i++) {
            max = padding[i] > max ? padding[i] : max;
        }*/

        int max = dp[0];
        // 최댓값 찾기
        for(int i = 1; i < N; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }

    private static int LIS(int N, int[] arr) {
        if (dp[N] == null) {
            dp[N] = 1;

            for (int i = N - 1; i >= 0; i--) {
                if(arr[i] < arr[N]) {
                    dp[N] = Math.max(dp[N], LIS(i, arr) + 1);
                }
            }
        }
        return dp[N];
    }
}
