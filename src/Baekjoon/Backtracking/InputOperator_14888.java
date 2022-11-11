package Baekjoon.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class InputOperator_14888 {
    private static int[] operators;
    private static int[] input;
    private static int N;
    private static int MAX = Integer.MIN_VALUE;
    private static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        operators = new int[4];
        N = Integer.parseInt(br.readLine());
        input = new int[N];

        StringTokenizer tokens = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(tokens.nextToken());
        }
        tokens = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(tokens.nextToken());
        }

        dfs(1, input[0]);

        StringBuilder answer = new StringBuilder();
        answer.append(MAX).append('\n');
        answer.append(MIN);

        System.out.println(answer);
    }

    private static void dfs(int idx, int cur_result) {
        if(idx == N) {
            MAX = Math.max(cur_result, MAX);
            MIN = Math.min(cur_result, MIN);
            return;
        }

        for(int i = 0; i < 4; i++) {
            if(operators[i] > 0) {
                operators[i]--;
                dfs(idx+1, operation(i, cur_result, input[idx]));
                operators[i]++;
            }
        }
    }

    private static int operation(int val, int x, int y) {
        int result = 0;
        switch(val) {
            case 0:
                result = x + y;
                break;
            case 1:
                result = x - y;
                break;
            case 2:
                result = x * y;
                break;
            case 3:
                result = x / y;
                break;
        }
        return result;
    }
}
