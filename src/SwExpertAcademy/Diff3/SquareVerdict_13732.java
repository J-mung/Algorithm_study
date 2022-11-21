package SwExpertAcademy.Diff3;

import java.util.Scanner;

/*
    [설명]
    N×N 크기의 격자판이 있다. 각각의 격자는 비어 있거나(‘.’), 막혀 있다(‘#’).

    이때, 막혀 있는 칸들이 하나의 정사각형을 이루는지를 판단하는 프로그램을 작성하라.

    [입력]
    첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

    각 테스트 케이스의 첫 번째 줄에는 격자판의 크기 N (1≤N≤20 이 주어진다.

    다음 N개의 줄은 격자판의 배치를 나타내며, 각 줄에는 ‘.’ 또는 ‘#’로만 이루어진 길이가 N인 문자열이 주어진다.

    모든 격자판에는 최소 1개 이상의 ‘#’ 칸이 있음이 보장된다.

    3
    3
    ...
    .##
    .##
    4
    #..#
    ....
    ....
    #..#
    5
    .....
    .###.
    .###.
    .###.
    .....

    [출력]
    각 테스트 케이스마다 격자판의 막혀 있는 칸들이 하나의 정사각형을 이루면 ‘yes’를, 그렇지 않다면 ‘no’를 출력한다.

    #1 yes
    #2 no
    #3 yes

*/

public class SquareVerdict_13732 {
    private static int[][] arr;
    private static int N;
    private static int shopNum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            N = sc.nextInt();
            arr = new int[N][N];
            shopNum = 0;

            // 테스트 케이스 입력
            for (int j = 0; j < N; j++) {
                String tmp = sc.next();
                for (int k = 0; k < N; k++) {
                    arr[j][k] = tmp.charAt(k) == '.' ? 0 : 1;
                    if (arr[j][k] == 1)
                        shopNum++;
                }
            }

            String result = check(shopNum);

            System.out.println("#" + (i + 1) + " " + result);
        }
    }

    public static String check(int shopNum) {
        int row = 0;
        int col = 0;

        for (int j = 0; j < N; j++) {
            for (int k = 0; k < N; k++) {
                if (arr[j][k] == 1) {
                    row = 0;
                    col = 0;

                    // 가로
                    for (int l = k + 1; l < N; l++) {
                        if (arr[j][l] == 1)
                            row++;
                        else
                            break;
                    }

                    // 세로
                    for (int l = j + 1; l < N; l++) {
                        if (arr[l][k] == 1)
                            col++;
                        else
                            break;
                    }

                    if (row != col) {
                        return "no";
                    }

                    for (int x = j; x < j + row + 1; x++) {
                        for (int y = k; y < k + col + 1; y++) {
                            if (arr[x][y] == 1)
                                shopNum--;
                            else
                                return "no";
                        }
                    }

                    if (shopNum != 0)
                        return "no";
                    return "yes";
                }
            }
        }
        return "no";
    }
}
