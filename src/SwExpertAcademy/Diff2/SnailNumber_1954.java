package SwExpertAcademy.Diff2;

/*
    [설명]
    달팽이는 1부터 N*N까지의 숫자가 시계방향으로 이루어져 있다.

    다음과 같이 정수 N을 입력 받아 N크기의 달팽이를 출력하시오.

    [예제]
    1 2 3
    8 9 4
    7 6 5

    01 02 03 04
    12 13 14 05
    11 16 15 06
    10 09 08 07

    [제약사항]
    달팽이의 크기 N은 1 이상 10 이하의 정수이다. (1 ≤ N ≤ 10)

    [입력]
    가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.

    각 테스트 케이스에는 N이 주어진다.

    [출력]
    각 줄은 '#t'로 시작하고, 다음 줄부터 빈칸을 사이에 두고 달팽이 숫자를 출력한다.

    (t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
*/

import java.util.Scanner;

public class SnailNumber_1954 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            int N = sc.nextInt();
            int arr[][] = new int[N][N];
            int dx[] = {0, 1, 0, -1}, dy[] = {1, 0, -1, 0}, dd[] = {0, 1, 2, 3};

            // 기본 방향은 오른쪽(우 하 좌 상 순서)
            int n = 1, x = 0, y = 0, d = 0;
            while (n <= N * N) {
                int X = x + dx[dd[d]], Y = y + dy[dd[d]];

                // 방향을 바꿔야 하는 순간
                if (X < 0 || X >= N || Y < 0 || Y >= N || arr[X][Y] != 0) {

                    // 방향 바꿈
                    d = (d + 1) % 4;
                    X = x + dx[dd[d]];
                    Y = y + dy[dd[d]];
                }

                // 배열에 n 입력
                arr[x][y] = n++;

                // 방향 최신화
                x = X;
                y = Y;
            }

            System.out.println("#" + (i + 1));
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    System.out.print(arr[j][k] + " ");
                }
                System.out.println();
            }
        }
    }
}
