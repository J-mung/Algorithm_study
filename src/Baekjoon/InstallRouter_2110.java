package Baekjoon;

/*
    Input
    5 3 (N C)
    1
    2
    8
    4
    9

    Output
    3

    hint
    공유기를 1, 4, 8 또는 1, 4, 9에 설치하면 가장 인접한 두 공유기 사이의 거리는 3이고, 이 거리보다 크게 공유기를 3개 설치할 수 없다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class InstallRouter_2110 {
    private static int N;
    private static int C;
    private static long[] house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        C = Integer.parseInt(tokens.nextToken());
        house = new long[N];

        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        solution();
    }

    private static void solution() {
        long min = 0;
        long mid;
        long max = house[N - 1] - house[0] + 1;
        while(min < max) {
            mid = (min + max) / 2;
            if (install(mid) < C) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
    }

    private static long install(long distance) {
        long total = 1;
        long prev = house[0];
        for (int i = 1; i < N; i++) {
            if (house[i] - prev >= distance ) {
                total++;
                prev = house[i];
            }
        }
        return total;
    }
}
