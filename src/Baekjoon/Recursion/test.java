package Baekjoon.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class test {
    private static int N;
    private static int M;
    private static int[] arr;
    private static boolean[] visit;
    private static StringBuilder result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        visit = new boolean[N];
        arr = new int[M];
        result = new StringBuilder();

        dfs(1, 0);

        System.out.println(result);
    }

    public static void dfs(int start, int depth) {
        if (M == depth) {
            for (int i = 0; i < M; i++) {
                result.append(arr[i]).append(" ");
            }
            result.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            arr[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }
}