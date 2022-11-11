package Baekjoon;

/*
    Input
    4 7(N, M)
    20 15 10 17

    Output
    15

    적어도 M미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최댓값
    10 15 17 20

    12  13  14  15  16
    16  13  10  07  05

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CutTree_2805 {
    private static long N;
    private static long M;
    private static long[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        trees = new long[(int) N];
        long max = -9999;

        tokens = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(tokens.nextToken());
            if(max < trees[i]) {
                max = trees[i];
            }
        }

        solution(++max);
    }

    private static void solution(long max) {
        long min = 0;
        long mid;
        while(min < max) {
            mid = (min + max) / 2;
            long total = felling(mid);
            if (total < M) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min - 1);
    }

    private static long felling(long cm) {
        long total = 0;
        for (int i = 0; i < N; i++) {
            total += (trees[i] - cm) > 0 ? (trees[i] - cm) : 0;
        }
        return total;
    }
}
