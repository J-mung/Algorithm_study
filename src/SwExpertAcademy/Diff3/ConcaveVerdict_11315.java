package SwExpertAcademy.Diff3;

import java.util.Scanner;

/*
    [설명]
    N X N 크기의 판이 있다. 판의 각 칸에는 돌이 있거나 없을 수 있다.

    돌이 가로, 세로, 대각선 중 하나의 방향으로 다섯 개 이상 연속한 부분이 있는지 없는지 판정하는 프로그램을 작성하라.

    [입력]
    첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

    각 테스트 케이스의 첫 번째 줄에는 하나의 정수 N(5 ≤ N ≤ 20)이 주어진다.

    다음 N개의 줄의 각 줄에는 길이 N인 문자열이 주어진다. 각 문자는 ‘o’또는 ‘.’으로, ‘o’는 돌이 있는 칸을 의미하고, ‘.’는 돌이 없는 칸을 의미한다.

    4
    5
    ....o
    ...o.
    ..o..
    .o...
    o....
    5
    ...o.
    ooooo
    ...o.
    ...o.
    .....
    5
    .o.oo
    oo.oo
    .oo..
    .o...
    .o...
    5
    .o.o.
    o.o.o
    .o.o.
    o.o.o
    .o.o.

    [출력]
    각 테스트 케이스 마다 돌이 다섯 개 이상 연속한 부분이 있으면 “YES”를, 아니면 “NO”를 출력한다.

    #1 YES
    #2 YES
    #3 YES
    #4 NO
*/

public class ConcaveVerdict_11315 {
    // Direction : 오른쪽 > 아래, 오른쪽 아래, 왼쪽 아래
    private static int[] DIRECTION_ROW = {0, 1, 1, 1};
    private static int[] DIRECTION_COL = {1, 0, 1, -1};

    private static boolean[][] table;
    private static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            N = sc.nextInt();
            table = new boolean[N][N];

            // 바둑판에 돌 올리기
            for (int j = 0; j < N; j++) {
                char[] tmp = sc.next().toCharArray();
                for (int k = 0; k < N; k++) {
                    if (tmp[k] == '.')
                        table[j][k] = false;
                    else
                        table[j][k] = true;
                }
            }

            String result = Solve();

            System.out.println("#" + (i + 1) + " " + result);
        }
    }

    private static String Solve() {
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {

                // 돌 확인
                if (table[row][col]) {
                    for (int direc = 0; direc < 4; direc++) {
                        // 좌표 이동 방향은 오른쪽 > 아래 > 오른쪽 아래 > 왼쪽 아래 순서로
                        boolean thereIs = CheckStone(direc, row, col);
                        if (thereIs)
                            return "YES";
                    }
                }
            }
        }
        return "NO";
    }

    private static boolean CheckStone(int direction, int row, int col) {
        // 지정된 방향으로 좌표를 이동하면서 현재 좌표의 4개 방면에 돌이 있는지 확인
        for (int i = 0; i < 4; i++) {
            row += DIRECTION_ROW[direction];
            col += DIRECTION_COL[direction];

            if (row < 0 || col < 0 || row > N - 1 || col > N - 1)
                return false;
            if (!table[row][col])
                return false;
        }
        return true;
    }
}
