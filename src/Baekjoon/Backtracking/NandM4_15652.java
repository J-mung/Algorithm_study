package Baekjoon.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NandM4_15652 {
    private static int N;
    private static int M;
    private static int[] arr;
    private static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        arr = new int[M];

        dfs(1, 0);
        System.out.println(result);
    }

    private static void dfs(int at, int depth) {
        if (depth == M) {
            for(int val : arr) {
                result.append(val).append(' ');
            }
            result.append('\n');
            return;
        }
        for(int i = at; i <= N; i++) {
            arr[depth] = i;
            dfs(i, depth+1);
        }
    }
}
