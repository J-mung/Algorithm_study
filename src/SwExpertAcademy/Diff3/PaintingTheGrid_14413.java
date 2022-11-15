package SwExpertAcademy.Diff3;

import java.util.Scanner;

/*
    [설명]
    N X M 크기의 직사각형 격자판이 있다. 격자판의 각 칸은 1 x 1 크기의 정사각형 모양이다.

    당신은 이 격자판의 각 칸을 검은색 또는 흰색으로 칠할 계획이다.

    당신은 격자판의 칸 중 몇 개(0개 이상 NM개 이하)는 검은색으로 칠할지 흰색으로 칠할지를 이미 정해 놓았다.

    정확히 표현하자면, N X M 크기의 행렬 A가 있어서, Ai,j 가 ‘#’라면 격자판의 i행 j열에 있는 칸은 검은색으로 칠해야 하고,

    Ai,j 가 ‘.’라면 격자판의 i행 j열에 있는 칸은 흰색으로 칠해야 하며,

    Ai,j 가 ‘?’라면 격자판의 i행 j열에 있는 칸은 검은색으로 칠해도 되고 흰색으로 칠해도 된다.

    당신은 아직 색이 정해지지 않은 칸들을 어떤 색으로 칠할지를 잘 정한 뒤 격자판을 색칠할 것이다.

    색칠한 결과 격자판의 인접한 (즉, 변 하나를 공유하는) 두 칸의 색이 항상 다르게 할 수 있는지를 판단하는 프로그램을 작성하라.

    [입력]

    첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

    각 테스트 케이스의 첫 번째 줄에는 두 개의 자연수 N과 M(1 ≤ N ≤50, 1 ≤ M ≤ 50)이 공백 하나를 사이로 두고 주어진다.

    다음 N개의 줄에는 '#', '.', '?'로만 구성된 길이가 M인 문자열이 하나씩 주어지며, 이는 행렬 A를 나타낸다.

    3
    3 6
    #.????
    ?#????
    ???.??
    1 6
    ##????
    3 3
    .#.
    #?#
    .#.

    [출력]

    각 테스트 케이스마다, '?'에 해당하는 칸의 색을 잘 정하여, 격자판의 인접한 두 칸의 색이 항상 서로 다르게 할 수 있다면

    ‘possible’을, 그렇지 않다면 ‘impossible’을 출력한다.

    #1 possible
    #2 impossible
    #3 possible
*/


public class PaintingTheGrid_14413 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            // 정답들로 색칠된 blacks, whites
            char[][] blacks = {
                    "#.#.#.#.#.".toCharArray(),
                    ".#.#.#.#.#".toCharArray()
            };
            char[][] whites = {
                    ".#.#.#.#.#".toCharArray(),
                    "#.#.#.#.#.".toCharArray()
            };

            // 색칠해야 하는 input
            char[][] input = new char[N][M];

            for (int j = 0; j < N; j++) {
                char[] str = sc.next().toCharArray();
                for (int k = 0; k < M; k++) {
                    input[j][k] = str[k];
                }
            }

            // 검은색 판단
            boolean blackPossible = true;

            // 하얀색 판단
            boolean whitePossible = true;

            // 검은색과 흰색 둘 중 하나라도 해당하면 true 아닐 경우 모두 오답이므로 false
            boolean result = true;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M && result; k++) {

                    // 격자판의 현재 칸이 ?가 아니면서 동일한 칸의 검은색 정답판과 서로 다르면
                    if (input[j][k] != blacks[j % 2][k % 10] && input[j][k] != '?') {

                        // impossible
                        blackPossible = false;
                    }

                    // 격자판의 현재 칸이 ?가 아니면서 동일한 칸의 흰색 정답판과 서로 다르면
                    if (input[j][k] != whites[j % 2][k % 10] && input[j][k] != '?') {

                        // impossible
                        whitePossible = false;
                    }
                    result = blackPossible || whitePossible;
                }
            }

            System.out.format("#%d %s\n", (i + 1), result ? "possible" : "impossible");
        }
    }
}
