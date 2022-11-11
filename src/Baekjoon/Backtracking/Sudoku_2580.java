package Baekjoon.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sudoku_2580 {
    private final static int N = 9;
    private final static int[] SUM = {45, 45, 45};  // col, row, inner
    private static int[][] arr = new int[N][N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens;

        for(int i = 0; i < N; i++) {
            tokens = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }

        //dfs();

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                result.append(arr[i][j]).append(' ');
            }
            result.append('\n');
        }
    }

    public static void dfs(int[][] curSum) {
        if(SUM[0] == 0 && SUM[1] == 0 && SUM[2] == 0) {
            return;
        }

    }
}
