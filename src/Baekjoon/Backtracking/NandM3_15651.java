package Baekjoon.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NandM3_15651 {
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

        dfs(0);
        System.out.println(result);
    }

    private static void dfs(int depth) {
        if (depth == M) {
           for(int val : arr) {
               result.append(val).append(' ');
           }
           result.append('\n');
           return;
        }
        for(int i = 0; i < N; i++) {
            arr[depth] = i+1;
            dfs(depth+1);
        }
    }
}
