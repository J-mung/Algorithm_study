package Baekjoon.CumulativeSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IntervalSum5_11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tokens.nextToken());
        int M = Integer.parseInt(tokens.nextToken());
        int[][] arr = new int[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            tokens = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                arr[i][j] = arr[i][j - 1] + Integer.parseInt(tokens.nextToken());
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < M; i++) {
            tokens = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(tokens.nextToken());
            int y1 = Integer.parseInt(tokens.nextToken());
            int x2 = Integer.parseInt(tokens.nextToken());
            int y2 = Integer.parseInt(tokens.nextToken());

            int tmp = 0;
            for (int j = x1; j <= x2; j++) {
                tmp += (arr[j][y2] - arr[j][y1 - 1]);
            }
            result.append(tmp).append("\n");
        }

        System.out.println(result);
    }
}
