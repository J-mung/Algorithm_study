package Baekjoon.Recursion;

// ***
// * *
// ***

import java.util.Scanner;

public class StampStart_2447 {
    private static int[][] graph;

    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();
        graph = new int[N][N];

        int spot = N / 3;
        solution(N, spot, spot);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void solution(int N, int row, int col) {

        // 재귀 종료
        if (N < 3) {
            return;
        }

        int num = N / 3;
        // 빈 공간 지정
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                graph[row + i][col + j] = 1;
            }
        }

        // 재귀 지점 지정
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                solution(N / 3, (num / 3) + (i * num), (num / 3) + (j * num));
            }
        }
    }
}
